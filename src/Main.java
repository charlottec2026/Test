import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

//a. Cheung, Charlotte
//b. Started 23rd April 2024, completed
//c. End of Semester 1 Project
//d. List of Collaborators and where you got help
//e. Hong Kong tax calculator which evaluates how much tax (in HKD) is owed to the Hong Kong government based off the user's responses to a number of questions. Follows the Salaries Tax/Personal Assessment outlines as regulated by the HK Government for fiscal years from 2023-24 onwards.
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
        int response = scanner.nextInt();
        // Blocks against responses which are not "0"
        while (response != 0) {
            System.out.println("If you would like to begin this program, type '0' and hit enter.");
            response = scanner.nextInt();
        }
        // What happens when "0" is typed as response to line 14.
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


        System.out.println("Now, you will be asked some questions regarding allowances.");

        // Asks for how many children, if any.
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

        // Asks for dependent parents and/or grandparents. I simplified this one a bit.
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

            // Asks if they are married or not (currently). If they're not, ask them if they're a single parent.
            System.out.println("If you are currently married, type '1'. If you are separated, divorced, widowed or single, type '0'.");
            int married = scanner.nextInt();
            while (married > 1) {
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
            if (personalDisability > 1 || personalDisability < 0) {
            System.out.println("Invalid response. Try again.");
            personalDisability = scanner.nextInt();
        }
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

            // Qualifying health insurance premiums (what does that even mean bro)
            System.out.println("How much have you and/or your spouse spent on qualifying health insurance premiums, to a limit of $8,000? If the amount exceeds $8,000, input 8000.");
            int QHIP = scanner.nextInt();
            if (QHIP >= 8000) {
                deduction += 8000;
            }
            if (QHIP < 8000) {
                deduction += QHIP;
            }
            System.out.println("Total deduction: HK$" + deduction);

            // Net chargeable income calculation
        int netIncome = income - allowance - deduction;
        double taxDue = 0;
        if (netIncome < 0) {
            netIncome = 0;
        }

        if (netIncome > 0 && netIncome < 50000) {
            taxDue = 0.02*netIncome;
        }
        if (netIncome > 50000 && netIncome < 100000) {
            taxDue = 1000+(0.06*(netIncome-50000));
        }
        if (netIncome > 100000 && netIncome < 150000) {
            taxDue = 4000+(0.1*(netIncome-100000));
        }
        if (netIncome > 150000 && netIncome < 200000) {
            taxDue = 9000+(0.14*(netIncome-150000));
        }
        if (netIncome > 200000) {
            taxDue = 16000+(0.17*(netIncome - 200000));
        }
        if (netIncome == 0) {
            taxDue = 0;
        }

        System.out.println("The total amount of tax due is " + taxDue + " Hong Kong dollars.");
        PrintStream originalOut = System.out;
        try {
            // Create a PrintStream to write to the CSV file
            PrintStream printStream = new PrintStream(new File("taxInfo.csv"));

            // Redirect the standard output to the PrintStream
            System.setOut(printStream);

            // Write println commands
            System.out.println("Full name: " + FName + " " + MName + " " + LName);
            System.out.println("Age: " + age);
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

            // Close the PrintStream
            printStream.close();

            // Restore the original standard output
            System.setOut(originalOut);

            System.out.println("Data saved to taxInfo.csv");
        }
        catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }

        System.out.println("Would you like to continue the program? Type '1' for yes and '0' for no.");
        int response2 = scanner.nextInt();
        if (response2 == 0) {
            System.out.println("The program will now end.");
        }
        if (response2 == 1) {
            System.out.println("The program will now also end, but you can run it again from there.");
        }
        while (response2!=0 && response2!=1) {
            System.out.println("That's not a valid input. Try again.");
            response2 = scanner.nextInt();
        }
    }
}