import java.security.SecureRandom;

public class PasswordGenerator 
{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@$#%^&*()<>?";
    
    public static void main(String[] args) 
    {
        String password = generatePassword(8);
        System.out.println("Password : " + password);
    }

    public static String generatePassword(int length)
    {
        SecureRandom r = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) 
        {
            int randomIndex = r.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);    
        }

        return sb.toString();
    }
}
