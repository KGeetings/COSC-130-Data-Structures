package List;

public class ArrayList<E> implements List<E> {
    private int size;
    private int capacity;
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    
    public ArrayList(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E item) {
    
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            resize(2 * capacity);
        }
    }

    public E get(int index) {
        //indexOutOfBoundsException
        return null;
    }

    public int indexOf(E item) {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public E removeAt(int index) {
        return null;
    }

    public E set(int index, E item) {
        return null;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        Object[] newdata = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
           newdata[i] = data[i];
        }
        data = newdata;
        capacity = newCapacity;
    }
    
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(0,10);
        nums.add(0,20);
    }
}
