package Recursion;

public class Recursion {
   public static int factorial(int n) {
      if (n <= 1) {
         return 1;
      }
      return n * factorial(n - 1);
   }
   public static int add(int m, int n) {
      if (n == 0) {
         return m;
      }
      return 1 + add(m, n - 1);
   }
   public static int fib(int n) {
      if (n <= 1) {
         return 1;
      }
      return fib(n - 1) + fib(n - 2);
   }
   public static void main(String[] args) {
      for (int n = 0; n < 10; n++) {
         System.out.println(n + "! = " + factorial(n));
      }
      System.out.println(add(11,3));
      for (int n = 0; n < 10; n++) {
         System.out.print(fib(n) + ", ");
      }
   }
}