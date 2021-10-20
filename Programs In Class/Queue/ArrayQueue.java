package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] data;
    private int size;
    private int capacity;
    private int front;
    private int rear = -1;
    private static final int DEFAULT_CAPACITY = 3;

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(E item) {
        if (capacity == rear + 1) {
            //this is where it might possibly overwrite needed numbers in the queue, almost need to expand data[]
            front += 1;
            data[(rear + 1) % capacity] = item;
            return;
        }
        else {
            rear = (rear + 1) % capacity;
            data[rear] = item;
            size++;
        }
        return;
    }

    public E dequeue() {
        /* if (isEmpty()) {
            throw new NoSuchElementException();
        } */
        return null;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) data[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>();
        /* q.enqueue(2);
        System.out.println("Peek " + q.peek()); */
        for (int i = 0; i <= 20; i++) {
            q.enqueue(i);
            //System.out.println("Peek " + q.peek());
        }

        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Size " + q.size());
     } 
}