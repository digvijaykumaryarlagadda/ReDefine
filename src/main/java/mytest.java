import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mom on 6/30/2016.
 */
public class mytest {
    public static void main(String[] args) throws IOException {

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
    }




}
