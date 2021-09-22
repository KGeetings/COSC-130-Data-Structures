package initialJavaFunctions;
public class NumericFunctions {

   public static int factorial(int n) {
      int result = 1;
      for (int i = 1; i <= n; i ++){
         result = result * i;
      }
      return (result);
   }

   public static void main(String[] args) {
      for (int n = 0; n <= 10; n++){
         System.out.println(n + "! = " + factorial(n));
      }
   }
}