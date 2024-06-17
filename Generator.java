import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Generator extends MainMenu {

    public ArrayList<String> generatedPasswords = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    int passwordLength = 16;
    void generator() {

        int randomValue;

        while (str.length() < passwordLength) {

            randomValue = (int) (Math.random() * (126 + 1 - 50) + 50);
            char character = (char) randomValue;

            if (Character.isDigit(character)) {
                str.append(character);
            } else if (Character.isLetter(character)) {
                str.append(character);
            }
        }

        System.out.println("The generated password is " + str);
        generatedPasswords.add(str.toString());

        str.delete(0,passwordLength);
    }

    void history() {

        if (generatedPasswords.isEmpty()) {
            System.out.println("Error: No passwords have been generated yet.");
        }

        int i = 1;
        for (String str : generatedPasswords) {
            System.out.println(i + ". " + str);
            i++;
        }
    }

    void displaySettings() {
        System.out.println("\n---------------------------");
        System.out.println("         Settings          ");
        System.out.println("---------------------------\n");

        System.out.println("Password length: " + passwordLength + " characters.");
    }

    void modifySettings() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nTip: A strong password typically has 16 or more characters.\n");

        while (true) {
            System.out.print("Enter password length (1 - 50): ");
            passwordLength = input.nextInt();

            if (passwordLength < 1 || passwordLength > 50) {
                System.out.println("Error: Password length outside of range.");
            } else {
                System.out.println("Current settings updated.");
                break;
            }
        }
    }
}
