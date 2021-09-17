/* Add these two functions to ArrayFunctions.java and test both of them in main():

    Write a linearSearch(String[] words, String target) to work with strings instead of integers.  
    That is, it should return the first index in the array words that matches the target string (or -1 if it is not found).  
    The first parameter is an array of strings, such as {"apple", "pear", "banana", "grape"}, 
    and the target is a single word such as "orange".
   
    Write the sum() function of problem #11 in Section 1.3.  Hint: use an enhanced-for loop.
    Write a sum(int[] data) method for the ArrayFunctions class that returns
    the sum of the elements in the given array. Test your implementation in main().

    Write a min(int[] data) method for the ArrayFunctions class that returns
    the value of the smallest element in the given array. You may
    assume the array is nonempty. Test your implementation in main().
 */
import java.util.Random;

public class ArrayFunctions {
    //job is the randomly fill an array with numbers
    public static void randomFill(int[] data, int cap) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++){
            data[i] = gen.nextInt(cap);
        }
    }

    public static int linearSearch(int[] data, int target) {
        // return first location with target or -1 if not found
        for (int i = 0; i < data.length; i++) {
            if (target == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchString(String[] data, String target) {
        for (int i = 0; i < data.length; i++) {
            if (target.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
    public static int min(int[] data) {
        int totalMin = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] <= totalMin) {
                totalMin = data[i];
            }
        }
        return totalMin;
    }

    public static int sum(int[] data) {
        int totalSum = 0;
        for(int sum: data) {
            totalSum = totalSum + sum;
        }
        return totalSum;
    }
    public static void insertionSort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            // put data[i] in correct spot
            int key = data[i];
            int j = i - 1;
            //run through values of data, making sure j doesn't exit the array(-1), and the number we want to move is less than the other parts of array
            while(j >= 0 && key < data[j]) {
                //place the correct value in it's ordered spot
                data[j + 1] = data[j];
                //decrease j by 1 to make sure it remains the same value as when it entered
                j--;
            }
            //add the number we wanted to move from the beginning into the correct spot (as it wasn't saved when overwriting the array)
            data[j + 1] = key;
        }
    }

    public static int binarySearch(int data[], int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ( target == data[mid]) {
                return mid;
            } else if (target < data[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        return -1;
    }

    public static void display(int[] data) {
        for (int num: data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //do printing here
        int[] nums = {5, 12, 3, 1, -11, 33, 44, -22};
        String[] words = {"apple", "pear", "banana", "grape"};
        System.out.println(linearSearchString(words, "banana"));
        System.out.println(linearSearchString(words, "orange"));
        System.out.println("The sum of the array is " + sum(nums));
        System.out.println("The min number in the array is " + min(nums));
        System.out.println(linearSearch(nums, 33));
        System.out.println(linearSearch(nums, 2));
        display(nums);
        insertionSort(nums);
        display(nums);
        System.out.println("Search for 1: " + binarySearch(nums, 1));
        int[] manyNums = new int[100];
        randomFill(manyNums, 1000);
        insertionSort(manyNums);
        display(manyNums);
        for (int x: manyNums) {
            System.out.println("Search for " + x + ": " + binarySearch(manyNums,x));
        }

    }
}