import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Generator genOBJ = new Generator();
        int selection;

        while (true) {

            System.out.println("\n---------------------------");
            System.out.println(" Secure Password Generator");
            System.out.println("         Main Menu         ");
            System.out.println("---------------------------\n");

            System.out.println("""
                1. Generate a password.
                2. Show previously generated passwords.
                3. Exit program.
                """);

            System.out.print("Please select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    genOBJ.generator();
                    break;
                case 2:
                    genOBJ.history();
                    break;
                case 3:
                    System.out.println("Program exited successfully.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
