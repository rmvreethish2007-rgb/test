import java.io.FileWriter;
import java.io.IOException;

public class EX5_3 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("1.txt");  // Overwrites file

            fw.write("Hello, this is a sample file.\n");
            fw.write("Writing data using FileWriter in Java.");

            fw.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
