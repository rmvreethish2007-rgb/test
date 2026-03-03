
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadFileContent {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1mcab37\\Documents\\NetBeansProjects\\example.txt";  
 
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
 
            String line;
            System.out.println("---- File Content ----");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
 
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
         


