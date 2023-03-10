import java.util.ArrayList;

public class ArrayStringList {
    private String[] data;
    private int size;

    private void resizeData(int newSize) {
        String[] newArr = new String[newSize];
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
        data = newArr;
        size = newSize;
    }
    
    public ArrayStringList(int initialCapacity) {
        this.size = initialCapacity;
        data = new String[size];
    }

    public void add(String str) {
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

    public void add(int index, String str) {
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

    public String get(int index) {
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

    public boolean contains(String str) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(str)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayStringList list = new ArrayStringList(2);
        ArrayList<String> referenceList = new ArrayList<>();

        list.add("alpha");
        referenceList.add("alpha");
        list.add("beta");
        referenceList.add("beta");
        list.add("gamma");
        referenceList.add("gamma");

        // You may ask why I didn't just use JUnit instead of these honestly
        // ugly if statements.
        // The only reason is I didn't want to force people to set up JUnit for
        // what should be a fairly simple lab.

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("Your size method produced "
                + "the wrong results. It should be been %d, but it was %d.",
                referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("The item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "add or get methods may be wrong.", i,
                    referenceList.get(i), list.get(i)));
            }
        }

        list.remove(1);
        referenceList.remove(1);

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After removing an item, "
            + "the size of your list should be %d, but it was %d. Your "
            + "remove method may not properly be updating the list's size.",
            referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        if (!list.contains("alpha")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string doesn't exist in the List, even though "
                + "it should."));
        }

        if (list.contains("beta")) {
            throw new AssertionError(String.format("Your contains method "
                + "reported a string DID exist in the List, even though it "
                + "should have been removed."));
        }

        // Fun fact: Java strings (and chars, for that matter) are
        // Unicode-compatible!

        list.add("delta");
        referenceList.add("delta");
        list.add("epsilon");
        referenceList.add("epsilon");
        list.add("zeta");
        referenceList.add("zeta");
        list.add("eta");
        referenceList.add("eta");
        list.add("theta");
        referenceList.add("theta");
        list.add("iota");
        referenceList.add("iota");
        list.add("kappa");
        referenceList.add("kappa");
        list.add("lambda");
        referenceList.add("lambda");
        list.add("mu");
        referenceList.add("mu");

        if (list.size() != referenceList.size()) {
            throw new AssertionError(String.format("After adding a bunch of "
                + "new elements, the size of your list should have been %d "
                + "but it was %d", referenceList.size(), list.size()));
        }

        for (int i = 0; i < referenceList.size(); i++) {
            if (!list.get(i).equals(referenceList.get(i))) {
                throw new AssertionError(String.format("After removing an "
                    + "item, the item at index %d "
                    + "in your list should have been %s, but it was %s. Your "
                    + "remove method may be wrong.",
                    referenceList.get(i), list.get(i)));
            }
        }

        System.out.println("If you're reading this, everything worked!");
    }
}