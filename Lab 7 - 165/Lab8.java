public class Lab8 {
    
    public static <T extends Comparable<T>> int checkOrder(T a, T b, T c, T d){
        if (a.compareTo(b) < 0 && b.compareTo(c) < 0 && c.compareTo(d) < 0) {
            return -1;
        }
        else if (a.compareTo(b) > 0 && b.compareTo(c) > 0 && c.compareTo(d) > 0) {
            return 1;
        }
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(checkOrder(63.2, 96.5, 100.1, 123.5));
        System.out.println(checkOrder("bat", "hat", "mat", "sat"));
    }
}
