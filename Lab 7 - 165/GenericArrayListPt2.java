//import java.util.List;
//import java.util.ArrayList;


public class GenericArrayListPt2 <T> {
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
    
    public GenericArrayListPt2(int initialCapacity) {
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

        GenericArrayListPt2<Point> pointList = new GenericArrayListPt2<Point>(2);
        GenericArrayListPt2<Point3D> pointList3D = new GenericArrayListPt2<Point3D>(3);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList3D.add(new Point3D(1.0f, 2.0f, 3.0f));
        pointList3D.add(new Point3D(7.3f, 4, 0));

        Point p = pointList.get(2);
        Point3D p3 = pointList3D.get(0);

        //GenericArrayListPt2<Float> floatList = new GenericArrayList<Float>(2);

    }
}

