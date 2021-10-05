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
    
    /* Modify the pop() method of Listing 3.2 to reduce the array length by
    half if the number of elements in the stack is less than or equal to onefourth
    the current length of the array (but do not let the array have a size
    smaller than 10). Include an output statement in the resize() method
    to report each resizing, and then test your modification by pushing and
    then popping a large number of elements. */

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (size() <= (data.length * 0.25) && ((size() * 0.5) >= DEFAULT_CAPACITY) ) {
            //Using some classic Narrowing Type Casting to convert what might be a double, into an int
            resize((int)(0.5 * data.length));
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
        for (int i = 0; i < data.length && i < newCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String [] args) {
        IntStack s = new IntArrayStack();
        //s.pop();
        /* s.push(12);
        s.push(7);
        System.out.println("Peek: " + s.peek());
        s.push(92);
        s.push(35);
        System.out.println("Size: " + s.size());
        System.out.println("First pop: " + s.pop()); */
        for (int i = 0; i <200; i++) {
            s.push(i);
        }
        while(!s.isEmpty()) {
            System.out.println(s.pop());
            //System.out.println("S.size is :" + s.size());
        }
    }
}