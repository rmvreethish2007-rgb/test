
import java.util.*;
 
public class ListImplementation {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
 
        System.out.println("ArrayList Elements:");
        for(String item : arrayList) {
            System.out.println(item);
        }
 
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");
 
        // Display LinkedList
        System.out.println("\nLinkedList Elements:");
        for(String item : linkedList) {
            System.out.println(item);
        }
    }
}



