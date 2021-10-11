package Stack;

public class Expression {
    private static final String SPACE = " ";

    public static String toPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<String> operators = new ArrayStack<>();
        for (String token : expr.split(SPACE)) {
            if (isOperator(token)) {
                //pop equal or higher
                operators.push(token);
            } else {
                result.append(token + SPACE);
            }
        }
        //add to result by calling result.append(WHATEVER)
        return result.toString();
    }

    private static boolean isOperator(String token) {
        return rank(token) > 0;
    }

    public static void main(String[] args) {
        String expr = "1 + 2";
        System.out.println("Postfix: " + toPostfix(expr));
    }
}
