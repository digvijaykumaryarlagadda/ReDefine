import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//
public class PDFtoTXTWatson {
   public static void main(String[] args) throws IOException {
        DocumentConversion service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
        service.setUsernameAndPassword("26008258-bc7c-4639-bfbe-e04cfe9eeb40", "jYpdOjxBEjmu");
       Files.walk(Paths.get("data/researchArticles")).forEach(filePath -> {
           if (Files.isRegularFile(filePath)) {
               File pdf = new File("data/sparkpaper.pdf");
               System.out.println(filePath);
           }
       });


       System.out.println("Convert pdf document to Text");
        String normalizedtext = service.convertDocumentToText(pdf).execute();
        System.out.println(normalizedtext);
        BufferedWriter output = null;
        try {
            File file = new File("output/TXTOut.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(normalizedtext);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
       //code to read all the text documents in a folder into a string
       /*
       File folder = new File("data/researchArticles");
       File[] listOfFiles = folder.listFiles();

       for (int i = 0; i < listOfFiles.length; i++) {
           File file = listOfFiles[i];
           if (file.isFile() && file.getName().endsWith(".txt")) {
               String content = FileUtils.readFileToString(file);
               }
       }
       */


       // code to read all the files and print the file paths in a directory
       /*
       Files.walk(Paths.get("data/researchArticles")).forEach(filePath -> {
           if (Files.isRegularFile(filePath)) {
               System.out.println(filePath);
           }
       });
      */
   }

}