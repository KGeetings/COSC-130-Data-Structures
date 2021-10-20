package Stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
   private Object[] data;
   private int top = -1;
   private static final int DEFAULT_CAPACITY = 10;
   
   public ArrayStack(int capacity) {
      data = new Object[capacity];
   }

   public ArrayStack() {
      this(DEFAULT_CAPACITY);
   }
   
   public void push(E item) {
      if (size() == data.length) {
         resize(2 * data.length);
      }
      data[++top] = item;
   }

   //Suppress needed because we are going from Object to generic E
   @SuppressWarnings("unchecked")
   public E pop() {
      if (isEmpty()) {
         throw new EmptyStackException();
      }
      return (E) data[top--];
   }

   public boolean isEmpty() {
      return size() == 0;
   }

   public int size() {
      return top + 1;
   }

   @SuppressWarnings("unchecked")
   public E peek() {
      if (isEmpty()) {
         throw new EmptyStackException();
      }
      return (E) data[top];
   }
   
   private void resize(int newCapacity) {
      Object[] newdata = new Object[newCapacity];
      for (int i = 0; i < top; i++) {
         newdata[i] = data[i];
      }
      data = newdata;
   }
   
   public static void main(String[] args) {
      Stack<String> words = new ArrayStack<>();
      String[] examples = {"antelope", "pumpkin", "chocolate", "silence"}; 
      
      for (String word: examples) {
         words.push(word);
      }

      System.out.println(words.peek());
      while (!words.isEmpty()) {
         System.out.println(words.pop());
      }
   }
}