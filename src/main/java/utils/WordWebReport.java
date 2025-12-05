package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * Genera un reporte en Word tomando imágenes de la carpeta /Capturas
 * y las inserta en un documento .docx existente.
 */
public class WordWebReport {

    private static final Logger LOGGER = Logger.getLogger(WordWebReport.class.getName());

    private static final String CAPTURAS_PATH = "Capturas/";
    private static final String COPIA_PATH = "Copia/";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");

    /**
     * Genera el reporte agregando todas las imágenes al documento Word indicado.
     */
    public static void generarReporte(String rutaDocumento) {
        File carpetaCapturas = new File(CAPTURAS_PATH);
        File[] archivosCaptura = carpetaCapturas.listFiles();

        if (archivosCaptura == null || archivosCaptura.length == 0) {
            LOGGER.info("No hay capturas para agregar al reporte.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(rutaDocumento);
             XWPFDocument document = new XWPFDocument(fis);
             FileOutputStream fos = new FileOutputStream(rutaDocumento)) {

            LOGGER.info("Insertando capturas en el reporte...");

            for (File captura : archivosCaptura) {
                agregarImagen(document, captura);
            }

            document.write(fos);

            LOGGER.info("Reporte actualizado correctamente.");

        } catch (IOException | InvalidFormatException e) {
            LOGGER.severe("Error generando reporte: " + e.getMessage());
            e.printStackTrace();
        }

        moverCapturas(archivosCaptura);
    }

    /**
     * Inserta una imagen como un párrafo nuevo en el documento Word.
     */
    private static void agregarImagen(XWPFDocument document, File imagen)
            throws IOException, InvalidFormatException {

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setSpacingAfter(200);

        XWPFRun run = paragraph.createRun();
        run.addBreak();

        try (FileInputStream fis = new FileInputStream(imagen)) {
            run.addPicture(
                    fis,
                    Document.PICTURE_TYPE_PNG,
                    imagen.getName(),
                    Units.toEMU(450),   // ancho px → EMU
                    Units.toEMU(300)    // alto px → EMU
            );
        }

        run.addBreak();
        run.setText("Imagen: " + imagen.getName());
        run.addBreak();
    }

    /**
     * Mueve las capturas a una carpeta de respaldo después de generar el reporte.
     */
    private static void moverCapturas(File[] archivos, String destinoPath) {
        moverCapturas(archivos);
    }

    private static void moverCapturas(File[] archivos) {

        File carpetaDestino = new File(COPIA_PATH);
        if (!carpetaDestino.exists()) {
            carpetaDestino.mkdirs();
        }

        for (File archivo : archivos) {
            try {
                Files.move(
                        archivo.toPath(),
                        new File(carpetaDestino, archivo.getName()).toPath(),
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException e) {
                LOGGER.warning("Error moviendo archivo: " + archivo.getName());
                e.printStackTrace();
            }
        }

        LOGGER.info("Capturas movidas a la carpeta de copia.");
    }
}
