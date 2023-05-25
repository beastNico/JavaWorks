import java.util.Stack;

public class ReverseString 
{
    public static String reverse(String str)
    {
        if(str == null || str.equals(""))
        {
            return str;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) 
        {
            stack.push(str.charAt(i));    
        }

        char[] reversed = new char[str.length()];
        for (int i = 0; i < str.length(); i++) 
        {
            reversed[i] = stack.pop();    
        }

        return String.copyValueOf(reversed);
    }
    
    public static void main(String[] args) 
    {
          String str = "Hello World";
          
          String reversed = reverse(str);
          System.out.println("The reverse of " + str + ": " + reversed);
    }
}
