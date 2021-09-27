package intStack;
import java.util.EmptyStackException;

public class IntLinkedStack implements IntStack{
    private Node top;
    private int size;

    public void push(int value) {
        top = new Node(value, top);
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private static class Node {
        private int data;
        private Node next;

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String [] args) {
        IntStack s = new IntLinkedStack();
        //s.pop();
        s.push(12);
        s.push(7);
        System.out.println("Peek: " + s.peek());
        s.push(92);
        s.push(35);
        System.out.println("Size: " + s.size());
        System.out.println("First pop: " + s.pop());
        for (int i = 0; i <100; i++) {
            s.push(i);
        }
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
