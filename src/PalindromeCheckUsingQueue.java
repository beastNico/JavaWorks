import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeCheckUsingQueue 
{
   public static void main(String[] args) 
   {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the string to check : ");
        String str = s.nextLine();

        checkPalindrome(str);

        s.close();
   }
   
   public static void checkPalindrome(String str)
   {
        Queue<Character> chars = new LinkedList<>();

        for (int i = str.length()-1; i >=0; i--) 
        {
            chars.add(str.charAt(i));
        }

        String revStr = "";

        while (!chars.isEmpty()) 
        {
            revStr = revStr + chars.remove();
        }
        if (str.equals(revStr))
            System.out.println(str + " is a palindrome.");
        else
            System.out.println(str + " is not a palindrome.");
    }
}
