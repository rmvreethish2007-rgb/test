import java.io.File
public class FileProperties {
public static void main(String[] args) {
String filePath = "C:\\Users\\1mcab37\\Documents\\NetBeansProjects\\example.txt"; 
File file = new File(filePath);
if (file.exists()) {
System.out.println("---- File Properties ----");
System.out.println("Name: " + file.getName());
System.out.println("Path: " + file.getAbsolutePath());
System.out.println("Size: " + file.length() + " bytes");
System.out.println("Readable: " + file.canRead());
System.out.println("Writable: " + file.canWrite());
System.out.println("Executable: " + file.canExecute());
} else {
System.out.println("File does not exist!");
}
}
}
