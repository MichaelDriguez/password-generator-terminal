import java.lang.Math;

public class Generator {

    StringBuilder str = new StringBuilder();
    void clearScreen() {

        // This for loop is to clear the terminal after every generated password.
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
    void title() {

        System.out.println("\n---------------------------");
        System.out.println(" Secure Password Generator");
        System.out.println("---------------------------\n");
    }
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

        System.out.println("The generated password is " + str.toString());
        str.delete(0,16);
    }
}
