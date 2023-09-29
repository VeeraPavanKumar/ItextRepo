package html;




import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmltoPdfConvertor2{

	    public static void main(String[] args) {
	        String htmlFilePath = "C://Users//User//Downloads//htmlcss.html";

	        try {
	            Document doc = Jsoup.parse(new File(htmlFilePath), "UTF-8");

	            String outputFilePath = "C://Users//User//Downloads//ppp.pdf";

	            FileOutputStream os = new FileOutputStream(outputFilePath);

	            ITextRenderer renderer = new ITextRenderer();

	            renderer.setDocument(new W3CDom().fromJsoup(doc), null);

	            renderer.layout();
	            renderer.createPDF(os, true);

	            os.close();

	            System.out.println("PDF file generated at: " + outputFilePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Error: Unable to load or parse the HTML file.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Error: An unexpected error occurred during PDF conversion.");
	        }
	    }
	}
