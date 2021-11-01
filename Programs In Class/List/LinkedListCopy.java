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
        Node<E> n = new Node<>(item);
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        size++;
    }

    public void add(int index, E item) {
        Node<E> n = new Node<>(item);
        Node<E> prev = getNode(index - 1);
        n.prev = prev;
        n.next = prev.next;
        prev.next.prev = n;
        prev.next = n;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
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
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNode(index);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
        return n.data;
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNode(index);
        E old = n.data;
        n.data = item;
        return old;
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
        List<Integer> nums = new LinkedListCopy<>();
        nums.add(0,10);
        nums.add(0,20);
    }
}
