import java.util.*;

public class InfixToPostfix 
{
    public static void main(String[] args) 
    {
        // Uppercase Infix 
        String infixExpression1 = "A*(B-C)/D+E";
        System.out.println("Infix expression to be converted : " + infixExpression1);
        String result = convertToPostfix(infixExpression1);
        System.out.println("Converted Postfix expression : " + result);   // result1 = ABC-*D/E+ 

        System.out.println();

        // Lowercase Infix
        String infixExpression2 = "a*(b-c)/d+e";
        System.out.println("Infix expression to be converted : " + infixExpression2);
        String result2 = convertToPostfix(infixExpression2);
        System.out.println("Converted Postfix expression : " + result2);   // result2 = abc-*d/e+
    }

    public static int precedence(char ch)
    {
        if(ch == '+' || ch == '-')
            return 1;
        if(ch == '*' || ch == '/')      // '*' and '-' has higher precedence
            return 2;
        
        return 0;
    }    

    public static String convertToPostfix(String exp)
    {
        Stack<Character> operators = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) 
        {
            char ch = exp.charAt(i);
            
            if(ch == '(')
                operators.push(ch);
            else if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
                postfix.push(ch + "");
            else if(ch == ')')
            {
                while(operators.peek() != '(')
                {
                    char op = operators.pop();

                    String first = postfix.pop();
                    String second = postfix.pop();

                    String newPostfix = second + first + op;

                    postfix.push(newPostfix);  // push the result to postFix stack again
                }

                operators.pop();  // pop '(' from stack
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                // check precedence of each operator with top of the stack and process them
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek()))
                {
                    char op = operators.pop();

                    String first = postfix.pop();
                    String second = postfix.pop();

                    String newPostfix = second + first + op;

                    postfix.push(newPostfix);
                }

                operators.push(ch);
            }
        }

        // If the operator stack still has some elements in it process them too Repeat
        while(operators.size() > 0)
        {
            char op = operators.pop();

            String first = postfix.pop();
            String second = postfix.pop();

            String newPostfix = second + first + op;

            postfix.push(newPostfix);
        }

        return postfix.pop();  // returning the postfix expression
    }
}
