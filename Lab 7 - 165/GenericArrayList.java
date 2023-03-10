public class GenericArrayList<T> {
    private T[] data;
    private int size;

    private void resizeData(int newSize) {
        Object[] newArr = new Object[newSize];
        if (newSize >= size) {
            for (int i = 0; i < data.length; i++) {
                newArr[i] = data[i];
            }
        }
        else {
            for (int i = 0; i < data.length - 1; i++) {
                newArr[i] = data[i];
            } 
        }
        T[] oldArr = data;
        data = (T[]) newArr;
        size = newSize;
    }
    
    public GenericArrayList(int initialCapacity) {
        this.size = initialCapacity;
        data = (T[]) new Object[size];
    }

    public void add(T str) {
        if (data[data.length - 1] != null) {
            resizeData(size() + 1);
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = str;
                break;
            }
        }
    }

    public void add(int index, T str) {
        if (index >= data.length) {
            return;
        }
        if (data[data.length - 1] != null) {
            resizeData(size() + 1);
        }
 
        for (int i = data.length - 1; i > index; i--) {
            data[i] = data[i - 1];

        }
        data[index] = str;
    }

    public T get(int index) {
        if (index >= data.length) return null;
        else return data[index];
    }

    public void remove(int index) {
        if (index >= data.length) {
            return;
        }
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        resizeData(size() - 1);
    }

    public int size() {
        return size;
    }

    public boolean contains(T str) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(str)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        /* PART 1:
         * Modify the GenericArrayList above so that it can store *any* class,
         * not just strings.
         * When you've done that, uncomment the block of code below, and see if
         * it compiles. If it does, run it. If there are no errors, you did
         * it right!
         */

        GenericArrayList<Point> pointList = new GenericArrayList<Point>(2);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList.remove(0);
        Point p = pointList.get(2);

        if (p.x != 19.16f && p.y != 22.32f) {
            throw new AssertionError("Your GenericArrayList compiled properly "
            + "but is not correctly storing things. Make sure you didn't "
            + "accidentally change any of your ArrayStringList code, aside "
            + "from changing types.");
        }

        GenericArrayList<Float> floatList = new GenericArrayList<Float>(2);

        for (float f = 0.0f; f < 100.0f; f += 4.3f) {
            floatList.add(f);
        }

        float f = floatList.get(19);

        System.out.println("Hurray, everything worked!");


       

    }
}

