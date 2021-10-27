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
        add(size, item);
        //best case: O(1)
        //worst case: O(n)
        //average case: O(n)
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            resize(2 * capacity);
        }
        // shift elements to the right of index over one
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        // insert item
        data[index] = item;
        // increment size
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
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

    @SuppressWarnings("unchecked")
    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // store old value
        E oldItem = (E) data[index];
        // set new value
        data[index] = item;
        // return old value
        return oldItem;
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
        //add elements
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        //get elements
        System.out.println(nums.get(0));
        System.out.println(nums.get(1));
    }
}
