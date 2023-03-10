import java.util.Arrays;
import java.util.LinkedList;

public class Quiz {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.addFirst("C");
        list.addFirst("D");
        list.addLast("E");
        list.add("F");
        System.out.println(list);
    }
}
