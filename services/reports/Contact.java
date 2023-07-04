package Bank.services.reports;

import Bank.notations.ErrorNotation;

import java.util.Scanner;

// Bank class representing a bank
class Report {
    private String name;
    private String phoneNumber;
    private String email;

    public Report(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

// Main class to choose the way to contact the bank
public class Contact {
    public void runUnit() {
        // Create a bank instance
        Report bank = new Report("My Bank", "123-456-7890", "bank@example.com");

        // Prompt the user to choose the contact method
        System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mContact Us \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                                    Choose a service provider from this list below.
                                    \033[0;93m01:\u001B[0m                               Phone Contact.
                                    \033[0;93m02:\u001B[0m                               Email Contact.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-2 :\s""");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Determine the chosen contact method
        switch (choice) {
            case 1:
                System.out.print("""
                                              
                                    \033[0;93mContact Us\033[0;90m--- \u001B[0mDetails
                                    """);
                System.out.println("Please call us to this number - Tel. " + bank.getPhoneNumber());
                break;
            case 2:
                System.out.print("""
                                              
                                    \033[0;93mContact Us\033[0;90m--- \u001B[0mDetails
                                    """);
                System.out.println("Please mail us to this email - " + bank.getEmail());
                break;
            default:
                new ErrorNotation(105);
                break;
        }
    }
}