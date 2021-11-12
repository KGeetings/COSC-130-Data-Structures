package Simulator;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
   private int size;
   private int capacity;
   private int front;
   private int rear = -1;
   private Object[] data;
   private static final int DEFAULT_CAPACITY = 10;
   
   public ArrayQueue(int capacity) {
      data = new Object[capacity];
      this.capacity = capacity;
   }
   
   public ArrayQueue() {
      this(DEFAULT_CAPACITY);
   }
   
   public void enqueue(E item) {
      if (size() == capacity) {
         resize(2 * capacity);
      }
      rear = (rear + 1) % capacity;
      data[rear] = item;
      size++;
   }
   
   @SuppressWarnings("unchecked")
   public E dequeue() {
      if (isEmpty()) {
         throw new NoSuchElementException();
      }
      E result = (E) data[front];
      data[front] = null;
      front = (front + 1) % capacity;
      size--;
      return result;
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
      Object[] newData = new Object[newCapacity];
      int j = front;
      for (int i = 0; i < size; i++) {
         newData[i] = data[j];
         j = (j + 1) % capacity;
      }
      data = newData;
      front = 0;
      rear = size - 1;
      capacity = newCapacity;
   }
   
   public static void main(String[] args) {
      Queue<Integer> q = new ArrayQueue<>(5);
      q.enqueue(2);
      q.enqueue(12);
      q.enqueue(6);
      q.enqueue(27);
      for (int i = 0; i < 10; i++) {
         q.enqueue(i * 3);
         System.out.println(q.dequeue());
      }
      System.out.println("Peek " + q.peek());
   }

}