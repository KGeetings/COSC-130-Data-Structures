package Stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
   private Node<E> top;
   private int size;

   @SuppressWarnings({"unchecked","rawtypes"})
   public void push(E item) {
      top = new Node(item, top);
      size++;
   }

   @SuppressWarnings("unchecked")
   public E pop() {
      if (isEmpty()) {
         throw new EmptyStackException();
      }
      E result = top.data;
      top = top.next;
      size--;
      return result;
   }

   public boolean isEmpty() {
      return size() == 0;
   }

   public int size() {
      return size;
   }

   public E peek() {
      if (isEmpty()) {
         throw new EmptyStackException();
      }
      return top.data;
   }

   @SuppressWarnings("rawtypes")
   private static class Node<T> {
      private T data;
      private Node next;

      private Node(T data, Node next) {
         this.data = data;
         this.next = next;
      }
   }
    
   public static void main(String[] args) {
      Stack<String> words = new LinkedStack<>();
      String[] examples = {"antelope", "pumpkin", "chocolate", "silence"}; 
      
      for (String word: examples) {
         words.push(word);
      }

      while (!words.isEmpty()) {
         System.out.println(words.pop());
      }

      Stack<Integer> numbers = new LinkedStack<>();
      for (int i = 10; i < 20; i++) {
         numbers.push(i*i);
      }

      while (!numbers.isEmpty()) {
         System.out.println(numbers.pop());
      }
   }
}