import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Generator genOBJ = new Generator();
        int selection;
        String modify;

        while (true) {

            System.out.println("\n---------------------------");
            System.out.println("         Main Menu         ");
            System.out.println("---------------------------\n");

            System.out.println("""
                1. Generate a password.
                2. Show current password generation settings.
                3. Show previously generated passwords.
                4. Exit program.
                """);

            System.out.print("Please select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    genOBJ.generator();
                    break;
                case 2:
                    genOBJ.displaySettings();

                    while (true) {
                        System.out.println("\nDo you wish to modify your settings?");
                        System.out.print("(Y/N): ");
                        modify = input.next();

                        if (modify.equals("Y") || modify.equals("y")) {
                            genOBJ.modifySettings();
                            break;
                        } else if (modify.equals("N") || modify.equals("n")) {
                            break;
                        } else {
                            System.out.println("Error: Invalid option.");
                        }
                    }
                    break;
                case 3:
                    genOBJ.history();
                    break;
                case 4:
                    System.out.println("Program exited successfully.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: Invalid option.");
                    break;
            }
        }
    }
}
