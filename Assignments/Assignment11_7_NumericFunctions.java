public class Assignment11_7_NumericFunctions {

   public static int factorial(int n) {
      int result = 1;
      for (int i = 1; i <= n; i ++){
         result = result * i;
      }
      return (result);
   }

   public static int pow(int m, int n) {
      int power = m;
      for (int i = 1; i < n; i ++){
         power = power * m;
      }
      return (power);
   }

   public static void main(String[] args) {
      for (int m = 1; m < 10; m++){
         //System.out.println(m + "! = " + factorial(m));
         for (int n = 1; n < 10; n++) {
            System.out.println(m + " to the power of " + n + " is " + pow(m,n));
         }
      }
   }
}