package List;

public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> getNode(int index) {
        Node<E> n = head;
        for (int i = -1; i < index; i++) {
            n = n.next;
        }
        return n;
    }
    @SuppressWarnings("unused")
    private int size;
    @SuppressWarnings("unused")
    private Node<E> front;
    @SuppressWarnings("unused")
    private Node<E> rear;

    public void add(E item) {

    }

    public void add(int index, E item) {

    }

    public E get(int index) {
        return null;
    }

    public int indexOf(E item) {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public E removeAt(int index) {
        return null;
    }

    public E set(int index, E item) {
        return null;
    }

    public int size() {
        return -1;
    }

    private static class Node<T> {
        @SuppressWarnings("unused")
        private T data;
        @SuppressWarnings("unused")
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private Node(T data) {
            this(data, null);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(0,10);
        nums.add(0,20);
    }
}
