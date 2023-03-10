import java.util.ArrayList;
import java.util.stream.*;

public final class Discussion {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ayush");
        list.add("Zendaya");

        for (String s: list) {
            System.out.println(s);
        }

        // System.out.println(list.get(5));
        //list.forEach(x -> System.out.println(x));
    }
}
/*
1. ArrayList<Object> list = new ArrayList<>(20);
2. The size of the list is 3 whereas the capacity is 10 because it was
initialized as 10.
3. Bart will be at Index 2.
4. list.add(5, "Oscar");
5. list.remove("Carl");
6. list.remove("Elmo");
7. Iterator<String> iter = list.iterator();
    while(iter.hasNext()) {
        System.out.println(iter.next());
    }
8.  I am not sure if this is correct as the problem has while, but I don't know any while-each loops
    for (String name: list) {
        System.out.println(name);
    }
9. ArrayList<Integer> list = new ArrayList<>();
10. A class such as ArrayList implements the List inteface which itself implements the collection interface. This allows the class to implement the iterable interface.
11. The iterable interface.
12. They implement the iterable interface.
13. The code will not compile because the greater than sign is not applicable to objects passed as parameters to a generic method.
14. Yes,  the code will compile since both nc and ns are the same type.
15. Yes, the code will compile because the node class implements the Comparable interface. This is just an example of polymorphism.
*/