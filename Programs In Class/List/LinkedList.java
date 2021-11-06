package List;

public class LinkedList<E> implements List<E> {
    private Node<E> head = new Node<> (null);       // dummy node
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> prev, next;     // double links

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<E> newNode = new Node<>(item);
        Node<E> curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;

        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next = newNode;
        if (newNode.next != null)
            newNode.next.prev = newNode;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //one option is:
        //E result = getNode(index).data;
        //return result;

        //another option is:
        //Node<E> node = getNode(index);
        //return node.data;

        return getNode(index).data;
    }


    public int indexOf(E item) {
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        E oldValue = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        node.prev = null;
        node.next = null;
        size--;
        return oldValue;
        //not on test
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        E oldValue = node.data;
        node.data = item;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        Node<E> n = head;
        for (int i = -1; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
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
        List<Integer> items = new LinkedList<>();
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
