package Queue;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private int size;
    private Node<E> front;
    private Node<E> rear;


    public void enqueue(E item) {
        //New node
        Node<E> newNode = new Node<>(item);
        //2 cases: empty or not
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        //update the rear and size
        rear = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        //save the front
        E item = front.data;
        //update the front
        front = front.next;
        //update the size
        size--;
        //return the item
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
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
        Queue<Integer> q = new LinkedQueue<>();
        q.enqueue(2);
        q.enqueue(12);
        q.enqueue(6);
        q.enqueue(27);
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Size " + q.size());
     }
}
