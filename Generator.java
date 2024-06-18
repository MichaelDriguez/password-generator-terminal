import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Generator {

    public ArrayList<String> generatedPasswords = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    String modify;

    boolean firstCharIsNumber = false;

    int passwordLength = 16;
    void generator() {

        int randomValue;

        if (firstCharIsNumber == true) {
            randomValue = (int) (Math.random() * (57 + 1 - 50) + 50);
            char character = (char) randomValue;
            str.append(character);
        }

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

        System.out.println("\n---------------------------");
        System.out.println("      Password History      ");
        System.out.println("---------------------------\n");

        if (generatedPasswords.isEmpty()) {
            System.out.println("Error: No passwords have been generated yet.");
        }

        int i = 1;
        for (String str : generatedPasswords) {
            System.out.println(i + ". " + str);
            i++;
        }
    }
}
