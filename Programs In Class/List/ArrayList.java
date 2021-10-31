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

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E item = get(index);
        // shift elements to the left of index over one
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // decrement size
        size--;
        // shift elements to the left of size over one
        for (int i = size; i < capacity; i++) {
            data[i] = null;
        }
        // shrink array if necessary
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return item;
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

        //call indexOf 
        System.out.println("Index of 3 is: " + nums.indexOf(3));

        //List items from 6.1 #2
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(7);
        items.add(2);
        items.add(4);
        items.add(1);
        items.add(8);
        items.add(9);
        items.add(7);
        // breakpoint
        System.out.println("size " + items.size());
        System.out.println("get " + items.get(3));
        System.out.println("indexOf " + items.indexOf(7));
        System.out.println("removeAt " + items.removeAt(5));
        items.add(0,3);
        items.add(2,5);
        System.out.println("removeAt " + items.removeAt(1));
    }
}
