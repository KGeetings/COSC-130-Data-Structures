import java.util.Random;

public class Sort {
    //job is to randomly fill an array with numbers
    public static void randomFill(int[] data, int cap) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++){
            data[i] = gen.nextInt(cap);
        }
    }

    //same as above randomFill but without the cap parameter.
    public static void randomFill(int[] data) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++){
            data[i] = gen.nextInt();
        }
    }

    private static void swap(int[] data, int i, int j) {
        int dataSubI = data[i];
        int dataSubJ = data[j];
        data[i] = dataSubJ;
        data[j] = dataSubI;
    }
    
    public static void sort(int[] data) {
        int startingPoint = 0;
        for(int i = startingPoint; i < data.length; i++) {
            int min = data[startingPoint];
            int key = startingPoint;
            for(int j = (startingPoint + 1); j < data.length; j++) {
                if(data[j] < min) {
                    min = data[j];
                    key = j;
                }
            }
            swap(data, startingPoint, key);
            startingPoint += 1;
        }
    }

    //Basically compares every number to the previous one, and they should all be more than the one before it
    public static boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void display(int[] data) {
        for (int num: data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] items = {1,3,5,7,9,11};
        swap(items, 2 ,4);
        System.out.println("This item is sorted: " + isSorted(items));
        sort(items);
        display(items);
        int[] manyNums = new int[100];
        randomFill(manyNums, 1000);
        sort(manyNums);
        display(manyNums);
        System.out.println("This item is sorted: " + isSorted(items));
        randomFill(manyNums);
        sort(manyNums);
        display(manyNums);
        System.out.println("This item is sorted: " + isSorted(items));
    }
}
