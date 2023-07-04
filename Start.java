package Bank;

import Bank.localdata.Databases;
import Bank.notations.ErrorNotation;
import Bank.user_type.Users;

import java.util.Scanner;

public class Start {
    public static void run() {
        Scanner input = new Scanner(System.in);
        boolean condition = false;

        do {
            int choiceToInt = 0;
            System.out.print("""
                            
                                 \033[0;93mThe DII Bank Services\u001B[0m
                    Greetings from DII Bank! Here, you can conduct
                    any transactions in private that you desire.
                    
                    \033[0;93m01 :\u001B[0m                  Login with User Account.
                    \033[0;93m02 :\u001B[0m                      Create User Account.
                    \033[0;93m03 :\u001B[0m                            Databases Log.
                    \033[0;93m00 :\u001B[0m                                     Exit.
                   \033[0;32m[USER]\u001B[0m Please select your choice:\s""");
            String choice = input.next();
            try {
                choiceToInt = Integer.parseInt(choice);
            } catch(NumberFormatException e) {
                new ErrorNotation(103);
                run();
            }

            switch(choiceToInt) {
                case 0 -> condition = true;
                case 1 -> {
                    System.out.print("""
                                              
                            \033[0;93mLoging In \033[0;90m--- \u001B[0m(Step 1/2)
                            Please Input your user reference to login.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    String in1 = input.next();

                    System.out.print("""
                                              
                            \033[0;93mLoging In \033[0;90m--- \u001B[0m(Step 2/2)
                            Please Input your password collectly.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    String in2 = input.next();
                    Users.userLoadData(in2, in1);
                }

                case 2 -> {
                    System.out.print("""
                                              
                            \033[0;93mCreate Account \033[0;90m--- \u001B[0m(Step 1/2)
                            You must complete your name to open new accounts.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    String in1 = input.next();

                    System.out.print("""
                                                       
                            \033[0;93mCreate Account \033[0;90m--- \u001B[0m(Step 2/2)
                            You must create your own password to make it secure.               \s
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    String in2 = input.next();

                    Users newUser = new Users(in2,
                            new Accounts("Current Account", in1));

                    Databases.users_package.put(newUser.getUser_reference(), newUser);
                    System.out.print("""
                            
                            \033[40m                                              \u001B[0m
                                    \033[0;93mCreate new account complete!\u001B[0m
                            This is your new account in DII services and
                            the content below will show the details of acc.
                            """);
                    System.out.println("      \033[0;32mUser References : \u001B[0m" + newUser.getUser_reference());
                    System.out.println("      \033[0;32mUser Passwords  : \u001B[0m" + newUser.getUser_pin());
                    System.out.println("      \033[0;32mHolder Name     : \u001B[0m" + in1 +
                            "\n\033[40m                                               \u001B[0m");
                }

                case 3 -> {
                    System.out.print("""
                                              
                            \033[0;93mDatabases Log \033[0;90m--- \u001B[0mVerifying
                            Please input the admin key access.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    String in1 = input.next();

                    if (in1.equals("adminDiiGen4")) {
                        System.out.print("""
                            
                            \033[40m                                                       \u001B[0m
                                                \033[0;93mDatabases Log\u001B[0m
                            Here is a databases of every user who use or register
                            in this services (we use this to develop our services).
                            """);
                        System.out.println("\n\033[0;90m" + Databases.users_package);
                    } else new ErrorNotation(110);
                }
                default -> new ErrorNotation(0);
            }
        } while (!condition);

    }

    public static void main(String[] args) { run();}
}
