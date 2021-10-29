package List;

public class ArrayListCoPilot<E> implements List<E> {
    private int size;
    private int capacity;
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    
    public ArrayListCoPilot(int capacity) {
        data = new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayListCoPilot() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E item) {
        if (size == capacity) {
            grow();
        }
        data[size++] = item;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @SuppressWarnings ("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings ("unchecked")
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E item = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return item;
        //big-O: O(n)
    }

    @SuppressWarnings ("unchecked")
    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldItem = (E) data[index];
        data[index] = item;
        return oldItem;
    }

    public int size() {
        return size;
    }

    private void grow() {
        int newCapacity = capacity * 2;
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
    }
    
    public static void main(String[] args) {
        List<Integer> nums = new ArrayListCoPilot<>();
        nums.add(0,10);
        nums.add(0,20);
        //loop to add numbers from 30 to 100
        for (int i = 30; i <= 100; i++) {
            nums.add(i);
        }

        System.out.println("Nums get: " + nums.get(1));
        System.out.println("Nums index of 10: " + nums.indexOf(10));
    }
}

