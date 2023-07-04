package Bank.services;

import java.util.Scanner;
import java.util.Vector;

import Bank.Accounts;
import Bank.localdata.AuthorizeFunc;
import Bank.localdata.Databases;
import Bank.notations.*;
import Bank.services.commons.*;
import Bank.services.ecorisks.*;
import Bank.services.reports.Contact;
import Bank.user_type.Users;

public class Client implements AuthorizeFunc {
    static Scanner input = new Scanner(System.in);
    static private Vector<Accounts> current_package;
    static private Users current_user;
    static private Accounts lasted_account_usage;

    public Client (Vector<Accounts> current_package, Users current_user) {
        Client.current_package = current_package;
        Client.current_user = current_user;
    }

    public static Accounts getLasted_account_usage() {
        return lasted_account_usage;
    }

    public static String callStepFirst() {
        System.out.print("""
                                              
                            \033[0;93mTransaction \033[0;90m--- \u001B[0m(Step 1/3)
                            Fill in your amount of money that you prefer.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
        String in = input.next();
        try {
            Double inTODouble = Double.parseDouble(in);
            if (inTODouble >= 0) return in;
            else {
                new ErrorNotation(104);
                return callStepFirst();
            }
        } catch (NumberFormatException e) {
            new ErrorNotation(104);
            return callStepFirst();
        }
    }

    public static String callAuthorize(String income , int index) {
        Accounts target = current_user.authorize(current_package);
        if (target != null) {
            target.setAcc_balance(income, index);
            lasted_account_usage = target;
        } else new ErrorNotation(200);
        return income;
    }

    public static String callAuthorize(String income , int index, AuthorizeFunc function) {
        Accounts target = current_user.authorize(current_package);
        if (target != null) {
            switch (index) {
                case 1 -> {
                    if (target.getAcc_balance() >= Double.parseDouble(income)) {
                        target.setAcc_balance(income, index);
                        lasted_account_usage = target;

                        function.runFunction();
                    } else new ErrorNotation(201);
                }
                case 0 -> {
                    target.setAcc_balance(income, index);
                    lasted_account_usage = target;
                    function.runFunction();
                }
            }
        } else new ErrorNotation(200);
        return income;
    }

    public static String callTransaction(int index) {
        String income = callStepFirst();
        callAuthorize(income, index);
        return income;
    }

    static String display() {
        return """
                
                \033[0;93mServices information\u001B[0m
                Select the services below to do some transactions.
                \033[0;93m01 :\u001B[0m              Deposit.  | \033[0;93m 07 :\u001B[0m                Insurances.
                \033[0;93m02 :\u001B[0m             Withdraw.  | \033[0;93m 08 :\u001B[0m                Investment.
                \033[0;93m03 :\u001B[0m             Transfer.  | \033[0;93m 09 :\u001B[0m                      Loan.
                \033[0;93m04 :\u001B[0m                Topup.  | \033[0;93m 10 :\u001B[0m                   Contact.
                \033[0;93m05 :\u001B[0m            Pay Bills.  | \033[0;93m100 :\u001B[0m       Create more account.
                \033[0;93m06 :\u001B[0m             Exchange.  | \033[0;93m102 :\u001B[0m                    Logout.
                """;
    }



    public static void runServices() {
        boolean endServices = false;
        do {
            System.out.print("""
                            
                                       \033[0;93mDII Bank Services\u001B[0m
                    the content below will show your available accounts.
                    \033[0;32mAccount IDs          Types                   Balances\u001B[0m
                    """);
            for (Accounts accounts : current_package) {
                System.out.println(accounts.getACC_ID() + "         "
                        + accounts.getACC_TYPE() + "         "
                        +accounts.getAcc_balance() + " Baht.");
            }

            System.out.print("""
                    
                    we've an alternative functions to see other wallets.
                    \033[0;32mF1:\u001B[0m                    \033[0;90m(see) --- \033[0;93mInternational Wallet.\u001B[0m
                    """);

            System.out.println(display());
            String choice = input.next();

            switch (choice) {
                case "f1","F1" -> {
                    String[] inter_currency = {"USD", "GBP", "JYP", "HKD", "KRW",
                            "SGD", "VND", "CNY", "TWD", "AUD"};

                    double[] exchange_rate = {30.82, 37.33, 0.291, 3.944, 0.0254,
                            22.267, 0.00133, 4.322, 0.982, 20.904};

                    double[] current_wallet = current_user.getAcc_balance_outside();

                    System.out.print("""
                            \033[0;93mInternational Wallet \033[0;90m--- \u001B[0mResult
                            this is the overview of your international wallet balances.
                            
                            \033[0;32mTypes               Values \033[0;90m[THB sample]\u001B[0m
                            """);
                    for (int n = 0; n < 10; n++) {
                        System.out.println(inter_currency[n] + "\t\t\t\t\t" + current_wallet[n] +
                                "   (\033[0;90m" + (current_wallet[n] * exchange_rate[n]) + "\u001B[0m)");
                    }
                }
                case "1","01" -> callTransaction(0);
                case "2","02" -> callTransaction(1);
                case "3","03" -> new Transfer_Unit().runUnit();
                case "4","04" -> new TopUp_Unit().runUnit();
                case "5","05" -> new PayBill_Unit().runUnit();
                case "6","06" -> new Exchange_Unit(current_user).runUnit();
                case "7","07" -> new Insurance_Unit(current_user).runUnit();
                case "8","08" -> new Investment(current_user).runUnit();
                case "9","09" -> new Loan(current_user).runUnit();
                case "10" -> new Contact().runUnit();
                case "100" -> {
                    Accounts newAcc = new Accounts("Current Account");
                    Databases.accountsVector.add(newAcc);
                    current_package.add(newAcc);
                }
                case "102" -> {
                    new CompleteNotation(2);
                    endServices = true;
                }
            }
        } while (!endServices);

    }

    @Override
    public void runFunction() {}
}


