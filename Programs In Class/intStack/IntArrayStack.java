package intStack;

public class IntArrayStack implements IntStack{
    public void push(int value) {

    }
    public int pop() {
        return 0;
    }
    public int size() {
        return 0;
    }
    public int peek() {
        return 0;
    }
    public boolean isEmpty() {
        return false;
    }

    public static void main(String [] args) {
        IntStack s = new IntArrayStack();
        s.push(12);
        s.push(7);
        s.push(92);
        System.out.println("Size: " + s.size());
        System.out.println("First pop: " + s.pop());
    }
}
