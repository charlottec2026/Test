import java.io.IOException;
// For scanner functions so the user can input their information
import java.util.Scanner;
// For files so I can save to CSV file
import java.io.PrintStream;
import java.io.File;

// a. Cheung, Charlotte
// b. Started 23rd April 2024, completed
// c. End of Semester 2 Project
// d. See criterion C/D submissions.
// e. Hong Kong tax calculator which evaluates how much tax (in HKD) is owed to the Hong Kong government based off the user's responses to a number of questions. Follows the Salaries Tax/Personal Assessment outlines as regulated by the HK Government for fiscal years from 2023-24 onwards.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int allowance = 0;
        int deduction = 0;
        System.out.println("This is a program that calculates the amount of taxes, in Hong Kong Dollars, that you must pay. This program will ask you some questions, and your answers to them will determine how much your final taxes are.");
        Scanner scanner = new Scanner(System.in);
        // Opens the portal to execution of the following program.
        System.out.println("If you would like to begin this program, type '0' and hit enter.");
        String response = scanner.nextLine();
        // Blocks against responses which are not "0"
        while (!response.equals("0")) {
            System.out.println("If you would like to begin this program, type '0' and hit enter.");
            response = scanner.nextLine();
        }
        // What happens when "0" is typed as response to line 21.
        // Asks for first, middle and last name.
        System.out.println("Very well. You will now be asked some questions about yourself.");
        System.out.println("What is your first name?");
        String FName = scanner.nextLine();
        System.out.println("What is your middle name? If you don't have one, type '0'.");
        String MName = scanner.nextLine();
        if (MName.equals("0")) {
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
        System.out.println("Enter your current age.");
        String ageString = scanner.nextLine();
        while (Double.parseDouble(ageString) <= 0) {
            System.out.println("Invalid input. Try again.");
            ageString = scanner.nextLine();
        }
                System.out.println("You are " + ageString + " years old.");

        // Asks for annual income.
        System.out.println("Enter your annual income as a whole number. Exclude cents. Do not type with spaces or commas.");
        int income = scanner.nextInt();
        System.out.println("Currently, you make " + income + " dollars per year.");

        System.out.println("Now, you will be asked some questions regarding allowances.");

        // Asks for how many children, if any.
        // Caps at 9, because the HK taxation system gives allowances for a maximum 9 children
        System.out.println("How many children do you have? If you have more than 9, still enter 9.");
        int totalChildren = scanner.nextInt();
        while (totalChildren > 9) {
            System.out.println("The maximum is 9. If you have more than 9, enter 9 anyways. The system will process it equally. Try again.");
            totalChildren = scanner.nextInt();
        }
        System.out.println("Of your children, how many were born between April 1st of last year and March 31st of this year?");
        int childrenInYear = scanner.nextInt();
        allowance += (childrenInYear * 260000) + ((totalChildren - childrenInYear) * 130000);

        // Asks for dependent brothers and/or sisters.
        // Caps at 9, because the HK taxation system gives allowances for a maximum 9 siblings
        System.out.println("How many dependent brothers or sisters are you currently supporting? If you have more than 9, still enter 9.");
        int dependentSiblings = scanner.nextInt();
        while (dependentSiblings > 9) {
            System.out.println("The maximum is 9. If you have more than 9, enter 9 anyways. The system will process it equally. Try again.");
            dependentSiblings = scanner.nextInt();
        }
        System.out.println("Of those siblings, how many are eligible for the Disabled Dependent Allowance?");
        int disabledSiblings = scanner.nextInt();
        while (disabledSiblings > dependentSiblings) {
            System.out.println("This is not a possible scenario. Try again.");
            disabledSiblings = scanner.nextInt();
        }
        allowance += ((dependentSiblings * 37500) + (disabledSiblings * 75000));

        // Asks for dependent parents and/or grandparents.
        // Cap the total amount of parents/grandparents combined at 6, not possible to have more
        System.out.println("Of your dependent parents/grandparents, how many are above the age of 60 or are eligible for the Disability Allowance Scheme?");
        int above60Elders = scanner.nextInt();
        while (above60Elders > 6) {
            System.out.println("This is not a possible scenario. Try again.");
            above60Elders = scanner.nextInt();
        }
        System.out.println("How many of your dependent parents/grandparents who are above the age of 60 and are eligible for DAS live with you?");
        int eldersLiving = scanner.nextInt();
        while (eldersLiving > above60Elders) {
            System.out.println("This is not a possible scenario. Try again.");
            eldersLiving = scanner.nextInt();
        }
        allowance += ((above60Elders * 100000) + (eldersLiving) * 50000);

        // Asks if they are married or not (currently).
        System.out.println("If you are currently married, type '1'. If you are separated, divorced, widowed or single, type '0'.");
        int married = scanner.nextInt();
        // Blocks against any invalid responses
        while (married != 1 && married != 0) {
            System.out.println("Invalid response. Try again.");
            married = scanner.nextInt();
        }
        if (married == 0) {
            allowance += 132000;
            System.out.println("Are you a single parent? Type '0' for no and '1' for yes.");
            int singleParent = scanner.nextInt();
            while (singleParent > 1) {
                System.out.println("Invalid response. Try again.");
                singleParent = scanner.nextInt();
            }
            if (singleParent == 1) {
                allowance += 132000;
            }
        }
        if (married == 1) {
            allowance += 264000;
        }

        // Asks regarding personal disability.
        System.out.println("Are you eligible for a personal disability allowance? If yes, type '1'. If no, type '0'.");
        int personalDisability = scanner.nextInt();
        String eligibilityDisable = "";
        if (personalDisability == 1) {
            allowance += 75000;
            eligibilityDisable = "yes";
        }
        if (personalDisability == 0) {
            eligibilityDisable = "no";
        }
        while (personalDisability != 1 && personalDisability != 0) {
            System.out.println("Invalid response. Try again.");
            personalDisability = scanner.nextInt();
        }
        // Uses "allowance" variable initialized in line 15 to print out to user how much they have in allowances
        System.out.println("Total allowance: HK$" + allowance);

        // Moves on to deductions.
        System.out.println("Now, you will be asked some questions about deductions.");

        // Self-education expenses.
        System.out.println("How much have you and/or your spouse spent on expenses for self-education, to a limit of $100,000? If the amount is more than $100,000, input 100000.");
        int selfEd = scanner.nextInt();
        if (selfEd >= 100000) {
            deduction += 100000;
        }
        if (selfEd < 100000) {
            deduction += selfEd;
        }

        // Elderly residential care expenses.
        System.out.println("How much have you and/or your spouse spent on elderly residential care, to a limit of $100,000? If the amount exceeds $100,000, input 100000.");
        int elderlyExpenses = scanner.nextInt();
        if (elderlyExpenses >= 100000) {
            deduction += 100000;
        }
        if (elderlyExpenses < 100000) {
            deduction += elderlyExpenses;
        }
        // Home loan interest deductions
        System.out.println("How much have you and/or your spouse spent on home loan interest, to a limit of $100,000? If the amount exceeds $100,000, input 100000.");
        int homeInterest = scanner.nextInt();
        if (homeInterest >= 100000) {
            deduction += 100000;
        }
        if (homeInterest < 100000) {
            deduction += homeInterest;
        }

        // Qualifying health insurance premiums (what does that even mean bruh)
        System.out.println("How much have you and/or your spouse spent on qualifying health insurance premiums, to a limit of $8,000? If the amount exceeds $8,000, input 8000.");
        int QHIP = scanner.nextInt();
        if (QHIP >= 8000) {
            deduction += 8000;
        }
        if (QHIP < 8000) {
            deduction += QHIP;
        }

        // Uses "deduction" variable initialized in line 16 to show the user how much in deductions they have
        System.out.println("Total deduction: HK$" + deduction);

        // Calculation of net chargeable income (total income - allowance - deduction)
        int netIncome = income - allowance - deduction;
        // Create taxDue as a double because I need to do decimal multiplication with that
        double taxDue = 0;
        // Makes the tax calculations in the next part easier by setting any net income less than 0 to 0.
        if (netIncome < 0) {
            netIncome = 0;
        }


        // Tower of if statements to calculate tax based on progressive rate (ranges of values)
        // On first $50,000 = 2%
        if (netIncome > 0 && netIncome < 50000) {
            taxDue = 0.02 * netIncome;
        }
        // On next $50,000 = 6%
        if (netIncome > 50000 && netIncome < 100000) {
            taxDue = 1000 + (0.06 * (netIncome - 50000));
        }
        // On next $50,000 = 10%
        if (netIncome > 100000 && netIncome < 150000) {
            taxDue = 4000 + (0.1 * (netIncome - 100000));
        }
        // On next $50,000 = 14%
        if (netIncome > 150000 && netIncome < 200000) {
            taxDue = 9000 + (0.14 * (netIncome - 150000));
        }
        // On all remaining net income = 17%
        if (netIncome > 200000) {
            taxDue = 16000 + (0.17 * (netIncome - 200000));
        }

        // Prevents negative tax from being due (the least tax is $0.00)
        if (netIncome == 0) {
            taxDue = 0;
        }

        System.out.println("The total amount of tax due is " + taxDue + " Hong Kong dollars.");
        PrintStream originalOut = System.out;
        try {
            // Create a PrintStream that writes to the CSV file
            PrintStream printStream = new PrintStream("taxDue.csv");

            // Redirect the standard output to the PrintStream
            System.setOut(printStream);

            // Write to the CSV file (use System.out.println commands)
            printStream.println("Full name: " + FName + " " + MName + " " + LName);
            printStream.println("Age: " + ageString);
            printStream.println("Income (in HKD): " + income);
            printStream.println("Number of dependent children: " + totalChildren);
            printStream.println("Number of dependent siblings: " + dependentSiblings);
            printStream.println("Number of dependent parents/grandparents: " + eldersLiving);
            printStream.println("Eligibility for a personal disability allowance: " + eligibilityDisable);
            printStream.println("Self-education expenses: HK$" + selfEd);
            printStream.println("Expenses on elderly residential care: HK$" + elderlyExpenses);
            printStream.println("Expenses on home loan interest: HK$" + homeInterest);
            printStream.println("Expenses on qualifying health insurance premiums: HK$" + QHIP);
            printStream.println("Total allowances: HK$" + allowance);
            printStream.println("Total deductions: HK$" + deduction);
            printStream.println("Final tax due: HK$" + taxDue);

            // Close the PrintStream
            printStream.close();

            // Restore the original output
            System.setOut(originalOut);

            // Indicate to the user that all data has been saved to the CSV file
            System.out.println("Data saved to taxInfo.csv");
        }
        // Catch errors when writing and saving CSV file
        catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }

        System.out.println("You will now see all your information.");
        System.out.println("Full name: " + FName + " " + MName + " " + LName);
        System.out.println("Age: " + ageString);
        System.out.println("Income (in HKD): " + income);
        System.out.println("Number of dependent children: " + totalChildren);
        System.out.println("Number of dependent siblings: " + dependentSiblings);
        System.out.println("Number of dependent parents/grandparents: " + eldersLiving);
        System.out.println("Eligibility for a personal disability allowance: " + eligibilityDisable);
        System.out.println("Self-education expenses: HK$" + selfEd);
        System.out.println("Expenses on elderly residential care: HK$" + elderlyExpenses);
        System.out.println("Expenses on home loan interest: HK$" + homeInterest);
        System.out.println("Expenses on qualifying health insurance premiums: HK$" + QHIP);
        System.out.println("Total allowances: HK$" + allowance);
        System.out.println("Total deductions: HK$" + deduction);
        System.out.println("Final tax due: HK$" + taxDue);

        // Asks if the user would like to continue the program.
        System.out.println("Would you like to continue the program? Type '1' for yes and '0' for no.");
        String response3 = scanner.nextLine();
        // Blocks invalid responses
        if (response3.equals("0")) {
            // Ends the program
            System.out.println("The program will now end.");
        }
        if (response3.equals("1")) {
            // Ends the program
            System.out.println("The program will now also end, but you can run it again from there.");
        }
    }
}