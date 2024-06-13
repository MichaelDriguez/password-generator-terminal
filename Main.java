import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Generator genOBJ = new Generator();

        while (true) {

            String regenerate;

            genOBJ.title();
            genOBJ.generator();

            System.out.print("\nWould you like to generate another secure password? (Y/N): ");
            regenerate = input.nextLine();

            if (!(regenerate.equals("Y") || regenerate.equals("y"))) {
                System.out.println("Exiting program...");
                break;
            } else {
                genOBJ.clearScreen();
            }
        }
    }
}
