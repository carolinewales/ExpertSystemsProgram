import java.util.Scanner;

public class ExpertSystemProgram {
    static Scanner scnr = new Scanner(System.in);

    static int degreeQuestion() {
        String answer;
        System.out.print("What is the highest degree you have earned? (Bachelor in CS/Masters in CS/None): ");

        while (true) {
            answer = scnr.nextLine().trim();

            if (answer.equalsIgnoreCase("None")) {
                return 0;
            } else if (answer.equalsIgnoreCase("Bachelor in CS")) {
                return 1;
            } else if (answer.equalsIgnoreCase("Masters in CS")) {
                return 2;
            } else {
                System.out.print("Please correctly format your answer (Bachelor in CS/Masters in CS/None): ");
            }
        }
    }

    // Asks user a yes or no question. 1 is returned if they answer yes, 0 is returned if they answered no
    // If incorrect input is given, the user is re-prompted to correct their answer
    static int yesOrNoQuestion(String question) {
        String answer;
        System.out.print(question + "(yes/no): "); // Ask user question

        while (true) { // Loop until acceptable answer is given
            answer = scnr.nextLine().trim();

            if (answer.equalsIgnoreCase("yes") || (answer.equalsIgnoreCase("y"))){
                return 1;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){
                return 0;
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
            answer = scnr.nextLine().trim();

            try {
                years = Integer.parseInt(answer);

                if (years >= 0) {
                    return years;
                } else {
                    System.out.print("Please enter a non-negative number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    // Asks a series of questions to determine what jobs a user is qualified for
    public static void main(String[] args) throws InterruptedException {
        int degree, pmiCert; // Qualification variables
        int pythonCW, sweCW, agileCW; // Coursework variables
        int git, pythonYears, agileYears, dataDevYears, dataArchYears, managingYears, expertSystemYears; // Skills & experience variables

        // Welcome the user to the expert system
        System.out.println("=+=+=+=+=+= Expert System: Applicant Qualification =+=+=+=+=+=");
        System.out.println("Welcome to the Applicant Qualification expert system! Let's begin.");
        System.out.println();
        Thread.sleep(1000); // Sleep for 1 second, so user is not overwhelmed with information

        // Ask user about their qualifications and record answers
        System.out.println("=+=+=+=+=+= Qualifications =+=+=+=+=+=");
        degree = degreeQuestion();
        pmiCert = yesOrNoQuestion("Do you have a PMI Lean Project Management Certification? ");
        System.out.println();

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

        // Ask time-based skills/experience questions
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

        System.out.print("Entry-Level Python Engineer - ");
        if (pythonCW == 1 && sweCW == 1 && (degree == 1 || degree == 2)) {
            System.out.println("Qualified");
            if (agileCW == 1){
                System.out.println("- It's helpful that you have completed Agile coursework");
            }
        } else {
            System.out.println("Not Qualified");
            if (pythonCW == 0) {
                System.out.println("- Requires Python coursework");
            }
            if (sweCW == 0) {
                System.out.println("- Requires Software Engineering coursework");
            }
            if (degree == 0) {
                System.out.println("- Requires a Bachelor in CS");
            }
        }
        System.out.println();
        Thread.sleep(1000);

        System.out.print("Python Engineer - ");
        if (pythonYears >= 3 && dataDevYears >= 1 && (agileYears > 0 || agileCW == 1) && (degree == 1 || degree == 2)) {
            System.out.println("Qualified");
            if (git == 1) {
                System.out.println("- It's helpful that you have used GitHub");
            }
        } else {
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
            if (degree == 0) {
                System.out.println("- Requires a Bachelor in CS");
            }
        }
        System.out.println();
        Thread.sleep(1000);

        System.out.print("Project Manager - ");
        if (managingYears >= 3 && agileYears >= 2 && pmiCert == 1) {
            System.out.println("Qualified");
        } else {
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

        System.out.print("Senior Knowledge Engineer - ");
        if (pythonYears >= 4 && expertSystemYears >= 2 && dataArchYears >= 2 && dataDevYears >= 2 && degree == 2) {
            System.out.println("Qualified");
        } else {
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
            if (degree == 0 || degree == 1) {
                System.out.println("- Requires a Masters in CS");
            }
        }
    }
}