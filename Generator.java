import java.lang.Math;
import java.util.ArrayList;

public class Generator {

    public ArrayList<String> generatedPasswords = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    void generator() {

        int randomValue;

        while (str.length() < 16) {

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

        str.delete(0,16);
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

        i = 1;
    }
}
