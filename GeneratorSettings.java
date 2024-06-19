import java.util.Scanner;

public class GeneratorSettings extends Generator {

    Scanner input = new Scanner(System.in);
    void displaySettings() {
        System.out.println("\n---------------------------");
        System.out.println("         Settings          ");
        System.out.println("---------------------------\n");

        if (passwordLength < 8) {
            System.out.println("Warning: Generated passwords are less than eight characters long.");
            System.out.println("This makes these passwords more vulnerable to being compromised.\n");
        }

        System.out.println("Password length: " + passwordLength + " characters");
        System.out.print("First character is a number: ");

        if (firstCharIsNumber) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.print("Includes symbols: ");

        if (generateWithSymbols) {
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
                    4. Toggle Option - Includes symbols.
                    5. Return to main menu.
                    """);

            System.out.print("Please select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1: {
                    displaySettings();
                    break;
                }
                case 2:
                    while (true) {

                        System.out.println("\nTip: A strong password typically has 16 or more characters.\n");

                        System.out.print("Enter password length (1 - 50): ");
                        passwordLength = input.nextInt();

                        if (passwordLength < 1 || passwordLength > 50) {
                            System.out.println("Error: Password length outside of range.");
                        } else {
                            System.out.println("Current settings updated.");
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("\nDo you want the first character to be a number?");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        if (modify.equals("Y") || modify.equals("y")) {
                            firstCharIsNumber = true;
                            System.out.println("Current settings updated.");
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            firstCharIsNumber = false;
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 4:
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
                            System.out.println("Current settings updated.");
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Error: Invalid option.");
            }

        } while (!returnToMainMenu);
    }
}