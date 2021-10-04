package intStack;

import java.util.EmptyStackException;
public class IntArrayStack implements IntStack{
    //complications:
    //pop empty
    //peek
    //full

    private int top = -1;
    private int[] data;
    private static final int DEFAULT_CAPACITY = 10;

    public IntArrayStack() {
        data = new int[DEFAULT_CAPACITY];
    }

    public void push(int value) {
        if (size() == data.length) {
            resize(2 * data.length);
        }
        data[++top] = value;
    }
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }
    public int size() {
        return (top + 1);
    }
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int newCapacity) {
        System.out.println("Resizing to " + newCapacity);
        int[] newData = new int[newCapacity];
        // copy elements
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String [] args) {
        IntStack s = new IntArrayStack();
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