package HtmltoPdf;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmltoPdfConvertor {

    public static void main(String[] args) {
        String htmlDirectoryPath = "C:\\Users\\Administrator\\Documents\\";
        int pdfFileCounter = 1;

        File htmlDirectory = new File(htmlDirectoryPath);

        File[] files = htmlDirectory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".html")) {
                try {
                    Document doc = Jsoup.parse(file, "UTF-8");

                    String pdfFileName = "output" + pdfFileCounter + ".pdf";
                    String outputFilePath = file.getParent() + File.separator + pdfFileName;

                    FileOutputStream os = new FileOutputStream(outputFilePath);

                    ITextRenderer renderer = new ITextRenderer();

                    renderer.setDocument(new W3CDom().fromJsoup(doc), null);

                    renderer.layout();
                    renderer.createPDF(os, true);

                    os.close();

                    System.out.println("PDF file generated at: " + outputFilePath);

                    pdfFileCounter++;
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Error: Unable to load or parse the HTML file.");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Error: An unexpected error occurred during PDF conversion.");
                }
            }
        }
    }
}
