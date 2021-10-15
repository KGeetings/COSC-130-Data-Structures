package CalculatorProg2;

/* 
Finish the applyOperator() and evalPostfix() functions in the Expression class to make the calculator work:
   applyOperator() is described in exercise #7 in 4.4
   evalPostfix() is exercise #8.  Follow Listing 4.4 on page 77.  Use a stack of integers, and notice the top of page 83: 
   you will need to call Integer.parseInt(token) to convert a string token to an int.

Start from the attached code; you should not need to make any changes to the Calculator class.
Extra credit: make the decimal point key work and change all computations to use doubles instead of ints.  
You will need to make two small changes in the Calculator class (one of them is marked), 
and most of the other changes will be in the Expression class.  If you try this, do not make Expression generic; 
just change it to use doubles.  Extra credit will only be given if the main part of the assignment is essentially correct.
 */
public class Expression {
   public static final String SPACE = " ";
   public static final String PLUS = "+";
   public static final String MINUS = "-";
   public static final String TIMES = "*";
   public static final String DIVIDE = "/";
   
   public static int eval(String infix) {
      return evalPostfix(toPostfix(infix));
   }
   
   public static int evalPostfix(String expr) {
      // TODO you write this
      return 0;
   }
   
   private static int applyOperator(String operator, int op1, int op2) {
      // TODO fill in the switch cases
      switch (operator) {
         default:
            return 0;
      }
   }
   
   public static String toPostfix(String expr) {
      StringBuilder result = new StringBuilder();
      Stack<String> operators = new ArrayStack<>();
      for (String token: expr.split(SPACE)) {
         if (isOperator(token)) {
            while (!operators.isEmpty() && rank(operators.peek()) >= rank(token)) {
               result.append(operators.pop() + SPACE);
            }
            operators.push(token);
         } else {
            result.append(token + SPACE);
         }
      }
      while (!operators.isEmpty()) {
         result.append(operators.pop() + SPACE);
      }
      return result.toString();
   }
   
   private static boolean isOperator(String token) {
      return rank(token) > 0;
   }
   
   private static int rank(String token) {
      switch (token) {
         case TIMES:
         case DIVIDE:
            return 2;
         case PLUS:
         case MINUS:
            return 1;
         default:
            return -1;
      }
   }
   
   public static void main(String[] args) {
      String expr = "3 * 2 + 1";
      System.out.println("Postfix: " + toPostfix(expr));
   }
}