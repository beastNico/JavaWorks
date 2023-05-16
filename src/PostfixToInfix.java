import java.util.*;

public class PostfixToInfix 
{
    // returning true if the character is operand or returning false
    public static boolean isOperand(char ch)
    {
        if(ch >= 'a' && ch <= 'z')
        {
            return true;
        }
        
        if(ch >= 'A' && ch <= 'Z')
        {
            return true;
        }

        return false;   // if it is a operator (eg. + - * / )
    }    

    static String convertToInfix(String postfix)
    {
        Stack<String> infix = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) 
        {
            char ch = postfix.charAt(i);
            
            if(isOperand(ch))
            {
                infix.push(ch + "");
            }
            else {
                String operand1 = infix.pop();
                String operand2 = infix.pop();

                infix.push("(" + operand2 + ch + operand1 + ")");
            }
        }
        return infix.pop();  //the final expression
    }

    public static void main(String[] args) 
    {
        // checking for capital alphabets
        String postfix1 = "ABC-*D/E+";
        System.out.println("The postfix expression to be converted : ");
        String result1 = convertToInfix(postfix1);
        System.out.println("The converted infix expression : " + result1);
        
        System.out.println();

        
        // checking for small alphabets
        String postfix2 = "abc-*d/e+";
        System.out.println("The postfix expression to be converted : ");
        String result2 = convertToInfix(postfix2);
        System.out.println("The converted infix expression : " + result2);
    }
}
