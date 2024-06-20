import java.lang.Math;
import java.util.ArrayList;

public class Generator {

    // This is the array that stores every generated password in this session.
    public ArrayList<String> generatedPasswords = new ArrayList<>();
    StringBuilder str = new StringBuilder(); // This is where the generated passwords are assembled.
    String modify;
    char [] similarChars = {'i', 'I', 'l', 'L', '1', '0', 'o', 'O'};

    // Modifiable conditions that the user can change in the settings menu.
    boolean firstCharIsNumber = false, firstCharIsSymbol = false;
    boolean generateWithSymbols = true, useSimilarChars = false;

    int passwordLength = 16;
    void generator() {

        int randomValue;
        char character;

        if (firstCharIsNumber) {
            if (!useSimilarChars) { // The randomValue equation below excludes 0 and 1.
                randomValue = (int) (Math.random() * (57 + 1 - 50) + 50);

            } else { // The randomValue equation below includes 0 and 1.
                randomValue = (int) (Math.random() * (57 + 1 - 48) + 48);

            }
            character = (char) randomValue;
            str.append(character);

        } else if (firstCharIsSymbol) {
            while (true) {
                randomValue = (int) (Math.random() * (126 + 1 - 48) + 48);
                character = (char) randomValue;

                if (!(Character.isDigit(character) || Character.isLetter(character))) {
                    str.append(character);
                    break;
                }
            }
        }

        if (generateWithSymbols) {
            while (str.length() < passwordLength) {

                randomValue = (int) (Math.random() * (126 + 1 - 48) + 48);
                character = (char) randomValue;

                str.append(character);

                if (!useSimilarChars) {
                    removeSimilarCharacters(character);
                }
            }
        } else { // Generating without symbols. Only adds numbers and letters.
            while (str.length() < passwordLength) {

                randomValue = (int) (Math.random() * (126 + 1 - 48) + 48);
                character = (char) randomValue;

                if (Character.isDigit(character)) {
                    str.append(character);
                } else if (Character.isLetter(character)) {
                    str.append(character);
                }

                if (!useSimilarChars) {
                    removeSimilarCharacters(character);
                }
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

    void removeSimilarCharacters(char character) { // Removes characters that look similar to other characters.
        for (int i = 0; i < similarChars.length; i++) {
            if (similarChars[i] == character) {
                str.delete(str.length() - 1, character);
                break;
            }
        }
    }
}
