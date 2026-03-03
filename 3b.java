
import java.util.*;
public class BookListUsingArrayList {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("The Alchemist");
        books.add("Harry Potter");
        books.add("The Hobbit");
        books.add("Rich Dad Poor Dad");
        System.out.println("Books in the list:");
        Iterator<String> itr = books.iterator();
        
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
