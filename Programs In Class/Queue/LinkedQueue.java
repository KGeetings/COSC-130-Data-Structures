package Queue;

public class LinkedQueue<E> implements Queue<E> {
    private int size;

    public void enqueue(E item) {
        
    }

    public E dequeue() {
        return null;
    }

    public E peek() {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private T data;
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
        Queue<Integer> q = new LinkedQueue<>();
        q.enqueue(2);
        q.enqueue(12);
        q.enqueue(6);
        q.enqueue(27);
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Size " + q.size());
     }
}
