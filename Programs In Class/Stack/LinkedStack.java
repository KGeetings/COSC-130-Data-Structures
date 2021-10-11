package Stack;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    public void push(E item) {
    
    }

    public E pop() {
       return null;
    }

    public boolean isEmpty() {
       return true;
    }

    public int size() {
       return 0;
    }

    public E peek() {
       return null;
    }

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
       Stack<Integer> numbers = new LinkedStack<>();
       for (int i = 10; i < 20; i++) {
          numbers.push(i*i);
       }
    }
 }