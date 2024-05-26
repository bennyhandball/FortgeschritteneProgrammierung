package BonusAufgaben;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!_-.;,?*'+/§$[]{}|";


    public void generatePassword(){
        Scanner scanner = new Scanner(System.in);
        int passwordLength = getValidInteger(scanner, "How long should the password be? ", 8);

        boolean includeCapitals = getValidYesNo(scanner, "Should capital letters be used? [y/n] ");
        boolean includeLowercase = getValidYesNo(scanner, "Should lowercase letters be used? [y/n] ");
        boolean includeNumbers = getValidYesNo(scanner, "Should numbers be used? [y/n] ");
        boolean includeSpecialChars = getValidYesNo(scanner, "Should special characters be used? [y/n] ");

        String finalDataSet = generateCharacterSet(includeCapitals, includeLowercase, includeSpecialChars, includeNumbers);
        try {
            String password = generatePasswordString(finalDataSet, passwordLength);
            copyPasswordToClipboard(password);
        } catch (Exception e) {
            System.out.println("No values selected. Start again!");
            generatePassword();
            return;
        }    
    }

    private static boolean getValidYesNo(Scanner scanner, String prompt) {
        boolean validInput = false;
        boolean value = false;

        while (!validInput) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                value = true;
                validInput = true;
            } else if (input.equals("n")) {
                validInput = true;
            } else {
                System.out.println("Please enter 'y' or 'n'");
            }
        }
        return value;
    }
    private static int getValidInteger(Scanner scanner, String prompt, int minValue) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < minValue) {
                    System.out.println("The value should be greater than or equal to " + minValue);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an integer");
            }
        }
        return value;
    }
    private static String generateCharacterSet(boolean includeCapitals, boolean includeLowercase, boolean includeSpecialChars, boolean includeNumbers) {
        StringBuilder characterSet = new StringBuilder();

        if (includeCapitals) {
            characterSet.append(UPPERCASE_CHARS);
        }
        if (includeLowercase) {
            characterSet.append(LOWERCASE_CHARS);
        }
        if (includeSpecialChars) {
            characterSet.append(SPECIAL_CHARS);
        }
        if (includeNumbers) {
            characterSet.append(NUMERIC_CHARS);
        }

        return characterSet.toString();
    }

    private static String generatePasswordString(String characterSet, int passwordLength) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }
        System.out.println(password);
        return password.toString();
    }

    private static void copyPasswordToClipboard(String passwortFinal){

        StringSelection stringSelection = new StringSelection(passwortFinal);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

}
