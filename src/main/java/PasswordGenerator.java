
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    
    private static final String DIGITS = "0123456789";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:'\",.<>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Password Generator!");

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include digits (0-9)? (yes/no): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters (a-z)? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters (A-Z)? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters (!@#$% etc.)? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

       
        String password = generatePassword(length, includeDigits, includeLowercase, includeUppercase, includeSpecial);

       
        System.out.println("Your generated password is: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeDigits, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        
        StringBuilder chars = new StringBuilder();
        if (includeDigits) {
            chars.append(DIGITS);
        }
        if (includeLowercase) {
            chars.append(LOWERCASE_LETTERS);
        }
        if (includeUppercase) {
            chars.append(UPPERCASE_LETTERS);
        }
        if (includeSpecial) {
            chars.append(SPECIAL_CHARACTERS);
        }

        
        if (chars.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        
        Random random = new Random();

        
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password[i] = chars.charAt(randomIndex);
        }

        return new String(password);
    }
}
