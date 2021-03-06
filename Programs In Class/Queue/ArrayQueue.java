package Queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    //All O(1), except resizing
    private Object[] data;
    private int size;
    private int capacity;
    private int front;
    private int rear = -1;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(E item) {
        //size()
        if (capacity == size()) {
            resize(2 * capacity);
        }
        else {
            rear = (rear + 1) % capacity;
            data[rear] = item;
            size++;
        }
        return;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = (E) data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        //Shrink array if needed
        if (size() < capacity / 4) {
            resize(capacity / 2);
        }
        return item;
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

    private void resize(int newCapacity) {
        Object[] newdata = new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newdata[i] = data[j];
            j = (j + 1) % capacity;
        }
        capacity = newCapacity;
        front = 0;
        rear = size() - 1;
        data = newdata;
     }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayQueue<>();
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(6);
        System.out.println("Dequeue " + q.dequeue());
        q.enqueue(8);
        q.enqueue(10);
        System.out.println("Dequeue " + q.dequeue());
        System.out.println("Dequeue " + q.dequeue());
        q.enqueue(12);
        //System.out.println("Size " + q.size());
     } 
}