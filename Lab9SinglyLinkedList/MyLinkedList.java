/** Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    private Node head;
    private Node tail;

    public class Node {
        // declare member variables (data and next)
        int data;
        Node next;

        // finish these constructors
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
            this.next = null;
        } // HINT: use this() with next = null
    }

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean add(Integer item) {
        Node curr = head;
        
        if (head == null) { 
            head = new Node(item, tail);
            return true;
        }
        else {
            for (int i = 0; i < size() - 1; i++) {
                curr = curr.next;
            }
            curr.next = new Node(item, curr.next);
            return true;
        }
    }

    @Override
    public void add(int index, Integer element) {
        if (index > size()) throw new NullPointerException();
        Node prev = head;

        for (int i = 0; i < index - 1; i++)
            prev = prev.next;

        prev.next = new Node(element, prev.next);
    }

    @Override
    public Integer remove() {
        Integer x = head.data;

        head = head.next;

        return x;
    }

    @Override
    public Integer remove(int index) {
        if (index > size()) throw new NullPointerException();
        Node prev = head;
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = curr.next;
        return curr.data;
    }

    @Override
    public boolean remove(Integer item) {
        int size = size();
        int index = 0;
        Node curr = head;
        Node prev = head;

        if (contains(item)) {
            for (int i = 0; i < size; i++) {
                if (curr.data == item) {
                    index = i;
                    break;
                }
                curr = curr.next;
            }
        }
        else return false;

        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = curr.next;
        return true;
    }

    @Override
    public void clear() {
        Node next;
        while (head != null) {
            head.data = (Integer) null;
            next = head.next;
            head.next = null;
            head = next;
        }
        head = tail = null;
    }

    @Override
    public boolean contains(Integer item) {
        int size = size();
        Node curr = head;
        boolean bool = true;

        for (int i = 0; i < size; i++) {
            if (curr.data == item){
                 bool = true;
                 break;
            }
            else if (i == size - 1 && curr.data != item) bool = false;
            curr = curr.next;
        }

        return bool;
    }

    @Override
    public Integer get(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    @Override
    public int indexOf(Integer item) {
        int size = size();
        int index = -1;
        Node curr = head;

        for (int i = 0; i < size; i++) {
            if (curr.data == item) {
                index = i;
                break;
            }
            curr = curr.next;
        }

        return index;
    }

    @Override
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        return count;
    }


    @Override
    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}