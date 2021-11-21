package Recursion;

public class Recursion {
   public static int factorial(int n) {
      // Base case, we get a stackOverFlowError if we try to call the call stack, as we just keep calling new factorials
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

   public static int mul(int m, int n) {
      if (n == 0) {
         return 0;
      }
      return m + mul(m, n - 1);
   }

   public static int fib(int n) {
      if (n <= 1) {
         return 1;
      }
      return fib(n - 1) + fib(n - 2);
   }

   public static void towers(int n, int from, int to, int using) {
      if (n >= 1) {
         towers(n - 1, from, using, to);
         System.out.println("Move disk " + n + " from " + from + " to " + to);
         towers(n - 1, using, to, from);
      }
   }

   public static void main(String[] args) {
      for (int n = 0; n < 10; n++) {
         System.out.println(n + "! = " + factorial(n));
      }

      System.out.println(add(11,3));
      
      for (int n = 0; n < 100; n++) {
         System.out.print(fib(n) + ", ");
      }

      /* System.out.println("\nMul(2,4): " + mul(2, 4));
      System.out.println("\nMul(5,4): " + mul(5, 4));

      towers(4, 0, 1, 2); */
   }
}