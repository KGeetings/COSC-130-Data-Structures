package List;

public class LinkedListCopy<E> implements List<E> {
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
        Node<E> newNode = new Node<>(item);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<E> newNode = new Node<>(item);
        Node<E> curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
        //average case: O(1)
    }


    public int indexOf(E item) {
        Node<E> n = head.next;
        for (int i = 0; i < size; i++) {
            if (n.data.equals(item)) {
                return i;
            }
            n = n.next;
        }
        return -1;
        //average case: O(n)
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
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNode(index);
        E old = n.data;
        n.data = item;
        return old;
        //average case: O(1)
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
        //average case: O(n)
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
        List<Integer> items = new LinkedListCopy<>();
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
