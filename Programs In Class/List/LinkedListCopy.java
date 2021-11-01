package List;

public class LinkedListCopy<E> implements List<E> {
    private Node<E> head;
    private Node<E> getNode(int index) {
        Node<E> n = head;
        for (int i = -1; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    private int size;
    public LinkedListCopy() {
        head = null;
        size = 0;
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = new Node<E>(item);
        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            Node<E> prev = getNode(index - 1);
            n.next = prev.next;
            prev.next = n;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }

    public int indexOf(E item) {
        Node<E> n = head;
        for (int i = 0; i < size; i++) {
            if (n.item.equals(item)) {
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E item = getNode(index).item;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = prev.next.next;
        }
        size--;
        return item;
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNode(index);
        E old = n.item;
        n.item = item;
        return old;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedListCopy<>();
        //add elements
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        //get elements
        System.out.println(nums.get(0));
        System.out.println(nums.get(1));

        //call indexOf 
        System.out.println("Index of 3 is: " + nums.indexOf(3));

        //List items from 6.1 #2
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(7);
        items.add(2);
        items.add(4);
        items.add(1);
        items.add(8);
        items.add(9);
        items.add(7);
        // breakpoint
        System.out.println("size " + items.size());
        System.out.println("get " + items.get(3));
        System.out.println("indexOf " + items.indexOf(7));
        System.out.println("removeAt " + items.removeAt(5));
        items.add(0,3);
        items.add(2,5);
        System.out.println("removeAt " + items.removeAt(1));
    }
}
