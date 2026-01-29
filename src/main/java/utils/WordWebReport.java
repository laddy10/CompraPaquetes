package utils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import freemarker.log.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

public class WordWebReport {

    private static final String EXISTING_DOCUMENT_PATH = System.getProperty("user.dir") + File.separator + "ruta" + File.separator + "EXXO.docx";
    private static final String CAPTURAS_FOLDER_PATH = "Capturas/";
    private static final String COPIA_FOLDER_PATH = "Copia/";
    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());
    private static Map<String, Integer> contadorPasos = new HashMap<>();

    public static void main() {
        crearCarpetaSiNoExiste(COPIA_FOLDER_PATH);
        contadorPasos.clear();

        File docFile = new File(EXISTING_DOCUMENT_PATH);

        if (!docFile.exists()) {
            System.err.println("⚠️ Error: El documento EXXO.docx no existe en la ruta especificada.");
            return;
        }

        File[] capturasFiles = new File(CAPTURAS_FOLDER_PATH).listFiles();
        if (capturasFiles == null || capturasFiles.length == 0) {
            LOGGER.info("📌 No hay imágenes para agregar al documento.");
            return;
        }

        Arrays.sort(capturasFiles, (f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

        try (FileInputStream fis = new FileInputStream(docFile);
             XWPFDocument document = new XWPFDocument(fis);
             FileOutputStream outputStream = new FileOutputStream(EXISTING_DOCUMENT_PATH)) {

            for (File capturaFile : capturasFiles) {
                addImageToWordDocument(document, capturaFile);
                moverArchivo(capturaFile, COPIA_FOLDER_PATH);
            }

            document.write(outputStream);
            LOGGER.info("✅ Capturas agregadas y documento actualizado correctamente.");

        } catch (IOException | InvalidFormatException e) {
            System.err.println("❌ Error al procesar el documento:");
            e.printStackTrace();
        }
    }

    private static void addImageToWordDocument(XWPFDocument document, File capturaFile)
            throws IOException, InvalidFormatException {

        BufferedImage image = ImageIO.read(capturaFile);
        if (image == null) {
            System.err.println("⚠️ No se pudo leer la imagen: " + capturaFile.getName());
            return;
        }

        String fileName = capturaFile.getName();

        // Quitar extensión
        String paso = fileName.substring(0, fileName.lastIndexOf("."));

        // 🔥 PATRÓN CORREGIDO: Elimina el formato específico de fecha/hora
        // Formato: "texto 1 18 12 2025 12 31 22" (día mes día año hora min seg)
        // Este patrón busca: número espacio número número espacio número número espacio número número número número espacio etc...
        paso = paso.replaceAll("\\s+\\d{1,2}\\s+\\d{2}\\s+\\d{2}\\s+\\d{4}\\s+\\d{2}\\s+\\d{2}\\s+\\d{2}$", "");

        // Patrón alternativo más flexible (por si los números no siempre tienen 2 dígitos)
        if (paso.matches(".*\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+$")) {
            paso = paso.replaceAll("\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+$", "");
        }

        // Limpiar espacios extras y caracteres especiales
        paso = paso.replace("_", " ").replaceAll("\\s+", " ").trim();

        if (paso.isEmpty()) {
            paso = "Paso de prueba";
        }

        // Agregar contador para pasos repetidos
        String pasoFinal = agregarContadorSiEsNecesario(paso);

        // Crear párrafo del paso
        XWPFParagraph pasoParagraph = document.createParagraph();
        pasoParagraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun pasoRun = pasoParagraph.createRun();
        pasoRun.setFontSize(12);
        pasoRun.setText(pasoFinal);

        // Calcular dimensiones
        int[] dimensiones = resizeImageDimensions(image.getWidth(), image.getHeight(), 19.05, 11.31);

        // Agregar imagen
        try (InputStream inputStream = new FileInputStream(capturaFile)) {
            XWPFParagraph imageParagraph = document.createParagraph();
            imageParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun imageRun = imageParagraph.createRun();
            imageRun.addPicture(inputStream, Document.PICTURE_TYPE_JPEG, capturaFile.getName(),
                    Units.toEMU(dimensiones[0]), Units.toEMU(dimensiones[1]));
        }

        document.createParagraph();

        // Debug: mostrar qué se procesó
        LOGGER.info("📝 Archivo: " + fileName + " → Paso: " + pasoFinal);
    }

    private static String agregarContadorSiEsNecesario(String pasoBase) {
        String pasoNormalizado = pasoBase.toLowerCase().trim();

        contadorPasos.put(pasoNormalizado, contadorPasos.getOrDefault(pasoNormalizado, 0) + 1);
        int numeroOcurrencia = contadorPasos.get(pasoNormalizado);

        if (numeroOcurrencia == 1) {
            return pasoBase;
        }

        return pasoBase + " - Página " + numeroOcurrencia;
    }

    private static int[] resizeImageDimensions(int originalWidth, int originalHeight, double maxCmWidth, double maxCmHeight) {
        int maxWidthPx = (int) (maxCmWidth * 28.3464567);
        int maxHeightPx = (int) (maxCmHeight * 28.3464567);

        if (originalWidth <= maxWidthPx && originalHeight <= maxHeightPx) {
            return new int[]{originalWidth, originalHeight};
        }

        double aspectRatio = (double) originalWidth / originalHeight;
        int adjustedWidth, adjustedHeight;

        if (aspectRatio >= 1) {
            adjustedWidth = maxWidthPx;
            adjustedHeight = (int) (maxWidthPx / aspectRatio);
        } else {
            adjustedWidth = (int) (maxHeightPx * aspectRatio);
            adjustedHeight = maxHeightPx;
        }

        return new int[]{adjustedWidth, adjustedHeight};
    }

    private static void moverArchivo(File archivo, String destino) {
        try {
            Files.move(archivo.toPath(), new File(destino + archivo.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            LOGGER.info("📂 Archivo movido a: " + destino);
        } catch (IOException e) {
            System.err.println("❌ Error al mover archivo: " + archivo.getName());
        }
    }

    private static void crearCarpetaSiNoExiste(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}