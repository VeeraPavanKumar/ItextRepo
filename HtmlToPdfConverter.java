package hmtl2;



import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;

public class HtmlToPdfConverter {
    public static void main(String[] args) {
        String htmlFilePath = "C:\\Users\\Administrator\\Downloads\\htmlcss.html";

        try {
            Document doc = Jsoup.parse(new File(htmlFilePath), "UTF-8");

            String outputFilePath = "C:\\Users\\Administrator\\Documents\\ppp.pdf";

            try (OutputStream os = new FileOutputStream(outputFilePath)) {
                ITextRenderer renderer = new ITextRenderer();

                renderer.setDocument(new W3CDom().fromJsoup(doc), null);

                renderer.layout();
                renderer.createPDF(os, true);

                renderer.finishPDF();
                
                System.out.println("PDF file generated at: " + outputFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("Error: Output PDF file not found.");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error: An unexpected error occurred during PDF conversion.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: Unable to load or parse the HTML file.");
        }
    }
}
