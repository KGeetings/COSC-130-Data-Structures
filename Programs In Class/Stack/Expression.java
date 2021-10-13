package Stack;

public class Expression {
    private static final String SPACE = " ";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String TIMES = "*";

    public static String toPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<String> operators = new ArrayStack<>();
        for (String token : expr.split(SPACE)) {
            if (isOperator(token)) {
                //pop equal or higher
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
        //add to result by calling result.append(WHATEVER)
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
