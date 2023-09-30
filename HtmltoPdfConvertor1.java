package HTML12;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
public class HtmltoPdfConvertor1 {
	


	    public static void main(String[] args) {
	        String htmlFilePath = "C:\\Users\\Administrator\\Downloads\\newhtml.html"; // Replace with the path to your HTML file
	        String pdfFilePath = "C:\\Users\\Administrator\\Downloads\\newhtml.pdf"; // Replace with your desired PDF output path

	        InputStream is = null;
	        OutputStream os = null;

	        try {
	            is = new FileInputStream(htmlFilePath);
	            os = new FileOutputStream(pdfFilePath);

	            Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document, os);
	            document.open();

	            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);

	            document.close();
	            os.close();

	            System.out.println("PDF file generated at: " + pdfFilePath);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Error: An unexpected error occurred during PDF conversion.");
	        } finally {
	            try {
	                if (is != null) {
	                    is.close();
	                }
	                if (os != null) {
	                    os.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


