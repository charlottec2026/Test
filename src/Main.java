import java.util.Scanner;
// Cheung, Charlotte
//b. Started 23rd April 2024, completed
//c. End of Semester 1 Project
//d. List of Collaborators and where you got help
//e. Hong Kong tax calculator which evaluates how much tax (in HKD) is owed to the Hong Kong government based off the user's responses to a number of questions. Takes into account marital status,
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int allowance = 0;
        int deduction = 0;
        System.out.println("This is a program that calculates the amount of taxes, in Hong Kong Dollars, that you must pay. This program will ask you some questions, and your answers to them will determine how much your final taxes are.");
        Scanner scanner = new Scanner(System.in);
        // Opens the portal to execution of the following program.
        System.out.println("If you would like to begin this program, type 'B' or 'b' and hit enter.");
        // Blocks against responses which are not "B" or "b".
        while (!scanner.nextLine().equalsIgnoreCase("b")) {
            System.out.println("If you would like to begin this program, type 'B' or 'b' and hit enter.");
        }
        // What happens when "B" or "b" is typed as response to line 14.
        // Asks for first, middle and last name.
        System.out.println("Very well. You will now be asked some questions about yourself.");
        System.out.println("What is your first name?");
        String FName = scanner.nextLine();
        System.out.println("What is your middle name? If you don't have one, type 'N/A' or 'n/a'.");
        String MName = scanner.nextLine();
        if (MName.equals("N/A") || MName.equals("n/a")) {
            MName = "";
        }
        System.out.println("What is your last name?");
        String LName = scanner.nextLine();
        if (MName.isEmpty()) {
            System.out.println("Your full name is " + FName + " " + LName + ".");
        }
        else {
            System.out.println("Your full name is " + FName + " " + MName + " " + LName + ".");
        }

        // Asks for age as an integer input.
        System.out.println("Enter your current age as a whole number. Do not type in anything that is not a whole number.");
        int age = scanner.nextInt();
        if (age < 0) {
            System.out.println("This is not a valid age. Try again.");
        }
        System.out.println("You are " + age + " years old.");

        // Asks for marital status.
        System.out.println("Are you married? If you are currently single, divorced, widowed or separated, type 'N' or 'n'. If you are currently living with your spouse, type 'Y' or 'y'.");
        boolean validInput = (scanner.nextLine().equals("Y") || scanner.nextLine().equals("y") || scanner.nextLine().equals("N") || scanner.nextLine().equals("n"));
    }
}