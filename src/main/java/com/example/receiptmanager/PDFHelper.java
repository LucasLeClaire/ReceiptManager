package com.example.receiptmanager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class PDFHelper {
    private final Map<String, String> content;

    public PDFHelper(Map<String, String> content) {
        this.content = content;
    }

    public void create() {
        try {
            //TODO vrai nomamge
            Random rand = new Random();
            String numbers = "1234567890";
            String name = "";
            short iter = (short) numbers.length();
            for(int i = 0; i < 10; i++) {
                name  += numbers.charAt(rand.nextInt(iter));
            }

            // Create a new document
            PDDocument document = new PDDocument();

            // Create a page
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Create a content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Add text to the page
            contentStream.setLeading(14.5f);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 700); // Set the position
            contentStream.showText(this.content.get("QCompany"));
            contentStream.newLine();
            contentStream.showText(this.content.get("QTitle"));
            contentStream.newLine();
            contentStream.showText(this.content.get("QDetails"));
            contentStream.newLine();
            contentStream.showText(this.content.get("QSignCompany"));
            contentStream.newLine();
            contentStream.showText(this.content.get("QSignIntern"));
            contentStream.newLine();
            contentStream.showText(this.content.get("QPrice"));
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save("src/main/resources/Receipts/Receipt" + name + ".pdf");

            // Close the document
            document.close();

            System.out.println("PDF créé dans src/main/resources/Receipts/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}