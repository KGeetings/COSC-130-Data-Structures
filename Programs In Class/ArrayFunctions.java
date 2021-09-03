/* Add these two functions to ArrayFunctions.java and test both of them in main():

    Write a linearSearch(String[] words, String target) to work with strings instead of integers.  
    That is, it should return the first index in the array words that matches the target string (or -1 if it is not found).  
    The first parameter is an array of strings, such as {"apple", "pear", "banana", "grape"}, 
    and the target is a single word such as "orange".
   
    Write the sum() function of problem #11 in Section 1.3.  Hint: use an enhanced-for loop.
    Write a sum(int[] data) method for the ArrayFunctions class that returns
    the sum of the elements in the given array. Test your implementation in main().
 */

public class ArrayFunctions {
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

    public static int sum(int[] data) {
        int totalSum = 0;
        for(int sum: data) {
            totalSum = totalSum + sum;
        }
        return totalSum;
    }

    public static void display(int[] data) {
        for (int num: data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //do printing here
        int[] nums = {5, 12, 3, 1, -11, 33, 44};
        String[] words = {"apple", "pear", "banana", "grape"};
        System.out.println(linearSearchString(words, "banana"));
        System.out.println(linearSearchString(words, "orange"));
        System.out.println("The sum of the array is " + sum(nums));
        /* System.out.println(linearSearch(nums, 33));
        System.out.println(linearSearch(nums, 2));
        display(nums); */
    }
}