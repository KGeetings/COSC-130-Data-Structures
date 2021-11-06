package List;

public class LinkedList<E> implements List<E> {
    private Node<E> head = new Node<> (null);       // dummy node
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> prev, next;     // double links

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(E item) {
        add(size, item);
    }

    public void add(int index, E item) {
        // added a more usefull error message in my opinion
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        // add new node before specified node
        Node<E> newNode = new Node<>(item);
        Node<E> current = head;
        // find the node at index
        for (int i = 0; i < index; i++)
            current = current.next;

        // insert new node between current and current.next
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        // if new node is not the last node, update next node's prev reference
        if (newNode.next != null)
            newNode.next.prev = newNode;
        // update size
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // one option is:
        // E result = getNode(index).data;
        // return result;

        // another option is:
        // Node<E> node = getNode(index);
        // return node.data;

        return getNode(index).data;
    }


    public int indexOf(E item) {
        Node<E> current = head.next;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item))
                return i;
            current = current.next;
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
        Node<E> node = getNode(index);
        E oldValue = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        node.prev = null;
        node.next = null;
        size--;
        return oldValue;
        //not on test
    }

    public E set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        E oldValue = node.data;
        node.data = item;
        return oldValue;
    }

    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        Node<E> n = head;
        for (int i = -1; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        // add elements
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(2,5);

        // Testing index out of bound exception
        //nums.add(6,7);

        // get elements
        System.out.println("Get: " + nums.get(0));
        System.out.println("Get: " + nums.get(1));

        // call indexOf 
        System.out.println("Index of 3 is: " + nums.indexOf(3));

        // List items from 6.1 #2
        List<Integer> items = new LinkedList<>();
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
