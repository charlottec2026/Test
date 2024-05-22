import java.util.Scanner;
// Cheung, Charlotte
//b. Started 23rd April 2024, completed
//c. End of Semester 1 Project
//d. List of Collaborators and where you got help
//e. Hong Kong tax calculator which evaluates how much tax (in HKD) is owed to the Hong Kong government based off the user's responses to a number of questions. Follows the Salaries Tax/Personal Assessment outlines as regulated by the HK Government for fiscal years from 2023-24 onwards.
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
        System.out.println("What is your middle name? If you don't have one, type '0' or 'none'.");
        String MName = scanner.nextLine();
        if (MName.equals("0") || MName.equals("N/A")) {
            MName = "";
        }
        System.out.println("What is your last name?");
        String LName = scanner.nextLine();
        if (MName.isEmpty()) {
            System.out.println("Your full name is " + FName + " " + LName + ".");
        } else {
            System.out.println("Your full name is " + FName + " " + MName + " " + LName + ".");
        }

        // Asks for age as an integer input.
        System.out.println("Enter your current age as a whole number. Exclude decimals.");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.");

        // Asks for annual income.
        System.out.println("Enter your annual income as a whole number. Exclude cents. Do not type with spaces or commas.");
        int income = scanner.nextInt();
        System.out.println("Currently, you make " + income + " dollars per year.");

        // Asks for how many children, if any.
        System.out.println("How many children do you have? If you have more than 9, still enter 9.");
        int totalChildren = scanner.nextInt();
        while (totalChildren > 9) {
            System.out.println("The maximum is 9. If you have more than 9, enter 9 anyways. The system will process it equally. Try again.");
            totalChildren = scanner.nextInt();
        }
        System.out.println("Of your children, how many were born between April 1st of last year and March 31st of this year?");
        int childrenInYear = scanner.nextInt();
        allowance += (childrenInYear*260000)+((totalChildren-childrenInYear)*130000);
        System.out.println("Your allowance currently stands at " + allowance + " dollars.");

        // Asks for dependent brothers and/or sisters.
        System.out.println("How many dependent brothers or sisters are you currently supporting? If you have more than 9, still enter 9.");
        int dependentSiblings = scanner.nextInt();
        while (dependentSiblings > 9) {
            System.out.println("The maximum is 9. If you have more than 9, enter 9 anyways. The system will process it equally. Try again.");
            dependentSiblings = scanner.nextInt();
        }
        System.out.println("Of those siblings, how many are eligible for the Disabled Dependent Allowance?");
        int disabledSiblings = scanner.nextInt();
        allowance += ((dependentSiblings*37500)+(disabledSiblings*75000));
        System.out.println("Your allowance currently stands at " + allowance + " dollars.");

        // Asks for dependent parents and/or grandparents. I simplified this one a bit.
        System.out.println("How many dependent parents/grandparents do you currently support?");
        int dependentElders = scanner.nextInt();
        while (dependentElders > 4) {
            System.out.println("The maximum is 4. Try again.");
            dependentElders = scanner.nextInt();
        }
        System.out.println("Of those, how many are either above the age of 60 or are eligible for the Disability Allowance Scheme?");
        int above60Elders = scanner.nextInt();
        allowance += ((above60Elders*50000)+(dependentElders-above60Elders)*25000);
        System.out.println("Your allowance currently stands at " + allowance + " dollars.");
    }
}