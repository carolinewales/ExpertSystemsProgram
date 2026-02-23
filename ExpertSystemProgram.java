import java.util.Scanner;

public class ExpertSystemProgram {
    static Scanner scnr = new Scanner(System.in);

    // Asks user a yes or no question. 1 is returned if they answer yes, 0 is returned if they answered no
    // If incorrect input is given, the user is re-prompted to correct their answer
    static int yesOrNoQuestion(String question) {
        String answer;
        System.out.print(question + "(yes/no): "); // Ask user question

        while (true) { // Loop until acceptable answer is given
            answer = scnr.nextLine().trim(); // Scan in answer, trimming any leading/excess spaces

            // Parse answer
            if (answer.equalsIgnoreCase("yes") || (answer.equalsIgnoreCase("y"))){
                return 1; // User answers 'yes,' 1 is returned
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){
                return 0; // User answers 'no,' 0 is returned
            } else { // Incorrect answer given
                System.out.print("Please enter yes or no: "); // Re-prompt user
            }
        }
    }

    // Asks user how much experience they have in an area. The amount of years the user answers with is returned.
    // If incorrect input is given, the user is re-prompted to correct their answer.
    static int yearsQuestion(String question) {
        String answer;
        int years;
        System.out.print(question + ": "); // Ask user question

        while (true) { // Loop until acceptable answer is given
            answer = scnr.nextLine().trim(); // Scan in answer, trimming any leading/excess spaces

            try {
                years = Integer.parseInt(answer); // Convert answer to an int to be returned

                if (years >= 0) {
                    return years;
                } else { // User entered a negative number
                    System.out.print("Please enter a non-negative number: "); // Re-prompt user
                }
            } catch (NumberFormatException e) { // User entered characters, symbols, etc.
                System.out.print("Please enter a number: "); // Re-prompt user
            }
        }
    }

    // Asks a series of questions to determine what jobs a user is qualified for. Results at the end show users which jobs
    // they do and do not qualify for. If they are unqualified for a job, the reason(s) why are given
    public static void main(String[] args) throws InterruptedException {
        int degreeBS, degreeMS, pmiCert; // Qualification variables
        int pythonCW, sweCW, agileCW; // Coursework variables
        int git, pythonYears, agileYears, dataDevYears, dataArchYears, managingYears, expertSystemYears; // Skills & experience variables

        // Welcome the user to the expert system
        System.out.println("=+=+=+=+=+= Expert System: Applicant Qualification =+=+=+=+=+=");
        System.out.println("Welcome to the Applicant Qualification expert system! Let's begin.");
        System.out.println();
        Thread.sleep(1000); // Sleep for 1 second, so user is not overwhelmed with information

        // Ask user about their qualifications and record answers
        System.out.println("=+=+=+=+=+= Qualifications =+=+=+=+=+=");
        degreeBS = yesOrNoQuestion("Do you have a Bachelor in CS? ");
        degreeMS = yesOrNoQuestion("Do you have a Master in CS? ");
        pmiCert = yesOrNoQuestion("Do you have a PMI Lean Project Management Certification? ");
        System.out.println(); // Spacing
        Thread.sleep(1000);

        // Ask user about their coursework and record answers
        System.out.println("=+=+=+=+=+= Coursework =+=+=+=+=+=");
        pythonCW = yesOrNoQuestion("Have you completed any Python coursework? ");
        sweCW = yesOrNoQuestion("Have you completed any Software Engineering coursework? ");
        agileCW = yesOrNoQuestion("Have you completed any Agile coursework?");
        System.out.println();
        Thread.sleep(1000);

        // Ask user about their skills & experience and record answers
        System.out.println("=+=+=+=+=+= Skills & Experience =+=+=+=+=+=");
        git = yesOrNoQuestion("Have you used GitHub? ");

        // Ask time-based questions
        System.out.println("For the following questions, enter how many years of experience you have working in each area.");
        pythonYears = yearsQuestion("Python Development");
        dataDevYears = yearsQuestion("Data Development");
        dataArchYears = yearsQuestion("Data Architecture");
        agileYears = yearsQuestion("Agile Projects");
        expertSystemYears = yearsQuestion("Expert Systems Development");
        managingYears = yearsQuestion("Managing Software Projects");
        System.out.println();
        Thread.sleep(1000);

        // Display results for users, showing which jobs they are and are not qualified for
        // If a user is unqualified for a job, the reason(s) why are given
        System.out.println("=+=+=+=+=+= Results =+=+=+=+=+=");
        System.out.println("Thank you for filling out your qualifications. Here are your results:");
        System.out.println();
        Thread.sleep(1000);

        // Show results for the Entry-Level Python Engineer position
        System.out.print("Entry-Level Python Engineer - ");
        if (pythonCW == 1 && sweCW == 1 && degreeBS == 1) { // If all conditions are met, user is qualified for this position
            System.out.println("Qualified");
            if (agileCW == 1) { // Taking desired skill of Agile coursework into account
                System.out.println("- Though not required, Agile coursework is a desired skill for this position. It is helpful that you have completed some");
            }
        } else { // User is unqualified, they are missing at least one needed skill and/or qualification
            // Print reason(s) why unqualified
            System.out.println("Not Qualified");
            if (pythonCW == 0) {
                System.out.println("- Requires Python coursework");
            }
            if (sweCW == 0) {
                System.out.println("- Requires Software Engineering coursework");
            }
            if (degreeBS == 0) {
                System.out.println("- Requires a Bachelor in CS");
            }
            if (agileCW == 0) { // Informing user that completing Agile coursework could be helpful
                System.out.println("- Though not required, Agile coursework is a desired skill for this position");
            }
        }
        System.out.println();
        Thread.sleep(1000);

        // Show results for the Python Engineer position
        System.out.print("Python Engineer - ");
        if (pythonYears >= 3 && dataDevYears >= 1 && agileYears > 0 && degreeBS == 1) { // If all conditions are met, user is qualified for this position
            System.out.println("Qualified");
            if (git == 1) { // Taking desired skill of GitHub into account
                System.out.println("- Though not required, using Github is a desired skill for this position. It is helpful that you have used it before");
            }
        } else { // User is unqualified, they are missing at least one needed skill and/or qualification
            // Print reason(s) why unqualified
            System.out.println("Not Qualified");
            if (pythonYears < 3) {
                System.out.println("- Requires at least 3 years of experience in Python");
            }
            if (dataDevYears < 1) {
                System.out.println("- Requires at least 1 year of experience in data development");
            }
            if (agileYears == 0 && agileCW == 0) {
                System.out.println("- Requires experience in Agile projects");
            }
            if (degreeBS == 0) {
                System.out.println("- Requires a Bachelor in CS");
            }
            if (git == 0) { // Informing user that gaining experience with GitHub could be helpful
                System.out.println("- Though not required, using GitHub is a desired skill for this position");
            }
        }
        System.out.println();
        Thread.sleep(1000);

        // Show results for the Project Manager position
        System.out.print("Project Manager - ");
        if (managingYears >= 3 && agileYears >= 2 && pmiCert == 1) { // If all conditions are met, user is qualified for this position
            System.out.println("Qualified");
        } else { // User is unqualified, they are missing at least one needed skill and/or qualification
            // Print reason(s) why unqualified
            System.out.println("Not Qualified");
            if (managingYears < 3) {
                System.out.println("- Requires at least 3 years managing software projects");
            }
            if (agileYears < 2) {
                System.out.println("- Requires at least 2 years of experience in Agile projects");
            }
            if (pmiCert == 0) {
                System.out.println("- Requires a PMI Lean Project Management Certification");
            }
        }
        System.out.println();
        Thread.sleep(1000);

        // Show results for the Senior Knowledge Engineer position
        System.out.print("Senior Knowledge Engineer - ");
        if (pythonYears >= 4 && expertSystemYears >= 2 && dataArchYears >= 2 && dataDevYears >= 2 && degreeMS == 1) { // If all conditions are met, user is qualified for this position
            System.out.println("Qualified");
        } else { // User is unqualified, they are missing at least one needed skill and/or qualification
            // Print reason(s) why unqualified
            System.out.println("Not Qualified");
            if (pythonYears < 4) {
                System.out.println("- Requires at least 4 years of experience in Python development");
            }
            if (expertSystemYears < 2) {
                System.out.println("- Requires at least 2 years of experience in developing Expert Systems");
            }
            if (dataArchYears < 2) {
                System.out.println("- Requires 2 years of experience in data architecture");
            }
            if (dataDevYears < 2) {
                System.out.println("- Requires 2 years of experience in data development");
            }
            if (degreeMS == 0) {
                System.out.println("- Requires a Masters in CS");
            }
        }
    }
}