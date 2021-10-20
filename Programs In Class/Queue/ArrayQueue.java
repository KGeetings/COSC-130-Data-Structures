package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] data;
    private int size;
    private int capacity;
    private int front;
    private int rear = -1;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(E item) {
        if (capacity == rear) {
            rear = (rear + 1) % capacity;
            return;
        }
        else {
            data[rear] = data;
            rear++;
        }
        return;
    }

    public E dequeue() {
        /* if (isEmpty()) {
            throw new NoSuchElementException();
        } */
        return null;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>();
        q.enqueue(2);
        q.enqueue(12);
        q.enqueue(6);
        q.enqueue(27);
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Size " + q.size());
     } 
}