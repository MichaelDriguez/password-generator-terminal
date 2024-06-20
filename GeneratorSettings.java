import java.util.Scanner;

public class GeneratorSettings extends Generator {

    Scanner input = new Scanner(System.in);

    // GeneratorSettings contains the settings menu.
    void displaySettings() {
        System.out.println("\n---------------------------");
        System.out.println("         Settings          ");
        System.out.println("---------------------------\n");

        if (passwordLength < 8) {
            System.out.println("Warning: Generated passwords are less than eight characters long.");
            System.out.println("This makes these passwords more vulnerable to being compromised.\n");
        }

        if (passwordLength == 1) {
            System.out.println("Password length: " + passwordLength + " character");
        } else {
            System.out.println("Password length: " + passwordLength + " characters");
        }

        System.out.print("First character is a number: ");

        if (firstCharIsNumber) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.print("First character is a symbol: ");

        if (firstCharIsSymbol) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.print("Generate passwords with symbols: ");

        if (generateWithSymbols) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.print("Include similar characters: ");

        if (useSimilarChars) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    void modifySettings() {

        int selection;
        boolean returnToMainMenu = false;

        do {
            System.out.println("\n---------------------------");
            System.out.println("       Modify Settings        ");
            System.out.println("---------------------------\n");

            System.out.println("""
                    1. Display current settings.
                    2. Change Option - Password length.
                    3. Toggle Option - First character is a number.
                    4. Toggle Option - First character is a symbol.
                    5. Toggle Option - Generate passwords with symbols.
                    6. Toggle Option - Include similar characters (i, I, 1, o, O, 0, etc.).
                    7. Return to main menu.
                    """);

            System.out.print("Please select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1: { // 1. Display current settings.
                    displaySettings();
                    break;
                }
                case 2: // 2. Change Option - Password length.

                    System.out.println("\nTip: A strong password typically has 16 or more characters.\n");

                    while (true) {
                        System.out.print("Enter password length (1 - 100): ");
                        passwordLength = input.nextInt();

                        if (passwordLength < 1 || passwordLength > 100) {
                            System.out.println("Error: Password length outside of range.");
                        } else {
                            System.out.println("Current settings updated.");
                            break;
                        }
                    }
                    break;
                case 3: // 3. Toggle Option - First character is a number.
                    while (true) {
                        System.out.println("\nDo you want the first character to be a number?");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        // The first character can either be a number or a symbol. It cannot be both.
                        if (modify.equals("Y") || modify.equals("y")) {
                            firstCharIsNumber = true;
                            firstCharIsSymbol = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            firstCharIsNumber = false;
                            firstCharIsSymbol = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 4: // 4. Toggle Option - First character is a symbol.
                    while (true) {
                        System.out.println("\nDo you want the first character to be a symbol?");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        // The first character can either be a symbol or a number. It cannot be both.
                        if (modify.equals("Y") || modify.equals("y")) {
                            firstCharIsSymbol = true;
                            firstCharIsNumber = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            firstCharIsSymbol = false;
                            firstCharIsNumber = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 5: // 5. Toggle Option - Generate passwords with symbols.
                    while (true) {
                        System.out.println("\nDo you want to include symbols for password generation?");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        if (modify.equals("Y") || modify.equals("y")) {
                            generateWithSymbols = true;
                            System.out.println("Current settings updated.");
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            generateWithSymbols = false;
                            firstCharIsSymbol = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 6: // Toggle Option - Include similar characters (i, I, 1, o, O, 0, etc.).
                    while (true) {
                        System.out.println("\nDo you want to generate passwords using similar characters?");
                        System.out.println("For example, i, I, 1, o, O, 0, etc.");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        if (modify.equals("Y") || modify.equals("y")) {
                            useSimilarChars = true;
                            System.out.println("Current settings updated.");
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            useSimilarChars = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 7: // 7. Return to main menu.
                    System.out.println("Returning to main menu...");
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Error: Invalid option.");
            }

        } while (!returnToMainMenu);
    }
}