import org.apache.xmpbox.xml.XmpParsingException;

import java.io.IOException;

/**
 * Created by mom on 6/30/2016.
 */
public class mytest{
    public static void main(String[] args) throws IOException, XmpParsingException {
        PDFExtractMetadata e = PDFExtractMetadata.objectcreationmethod();
        String[] inputFiles= new String[] {"data/researchArticles/Bigtable A Distributed Storage System for Structured Data.pdf"};
        e.main(inputFiles);

       /*
// code to read all filepaths in a folder in string format
        Files.walk(Paths.get("data/researchArticles")).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                //System.out.println(filePath);
           filePath.toString();
           System.out.println(filePath);

            }
        });
    }
    private static String nameOf(Object o) {
        return o.getClass().getSimpleName();
*/
    }




}
