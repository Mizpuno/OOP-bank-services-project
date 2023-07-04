package Bank;

import Bank.notations.CompleteNotation;
import Bank.notations.ErrorNotation;

import java.util.Vector;

public class Accounts {
    static String ACC_HOLDER;
    private final String ACC_TYPE, ACC_ID;
    private double acc_balance;

    public Accounts (String ACC_TYPE) {
        this.ACC_TYPE = ACC_TYPE;
        ACC_ID = generate_accID();
    }

    public Accounts (String ACC_TYPE, String ACC_HOLDER)  {
        this(ACC_TYPE);
        Accounts.ACC_HOLDER = ACC_HOLDER;
    }

    public void setAcc_balance(String acc_balance) {
        try {
            double balance_toDouble = Double.parseDouble(acc_balance);
            this.acc_balance += balance_toDouble;
        } catch (NumberFormatException e) {
            new ErrorNotation(104);
        }
    }

    public void setAcc_balance(String acc_balance, int index) {
        try {
            double balance_toDouble = Double.parseDouble(acc_balance);
            switch (index) {
                case 0 -> {
                    this.acc_balance += balance_toDouble;
                    new CompleteNotation(200);
                    new CompleteNotation(210);
                    System.out.print("         System Function \033[0;90m-- Deposit\033[0m\n" +
                                     "Transaction Amount :\t\t\t\033[0;92m" + balance_toDouble + "\033[0m Baht.\n" +
                            "\033[40m                                              \u001B[0m\n");
                }
                case 1 -> {
                    if (balance_toDouble <= this.acc_balance) {
                        this.acc_balance -= balance_toDouble;
                        new CompleteNotation(200);
                        new CompleteNotation(210);
                        System.out.print("         System Function \033[0;90m-- Withdraw\033[0m\n" +
                                         "Transaction Amount :\t\t\t\033[0;92m" + balance_toDouble + "\033[0m Baht.\n" +
                                "\033[40m                                              \u001B[0m\n");
                    }
                    else {
                        new ErrorNotation(201);
                    }
                }
                case 2 -> {

                }
            }
        } catch (NumberFormatException e) {
            new ErrorNotation(104);
        }

    }
    public double getAcc_balance() {
        return acc_balance;
    }
    public String getACC_ID() {
        return ACC_ID;
    }
    public String getACC_TYPE() {
        return ACC_TYPE;
    }
    public String getACC_HOLDER() {
        return ACC_HOLDER;
    }

    public String[] getBundle() {
        return new String[]{ACC_HOLDER, ACC_TYPE, ACC_ID ,Double.toString(acc_balance)};
    }
    private String generate_accID () {
        //generate collection of 10 digits.

        //long store 8-bytes of number value.
        long id = (long) (Math.random() * Math.pow(10, 10));
        char[] accID = Long.toString(id).toCharArray();

        //we use StringBuilder with .append() to avoid the problem of concat.
        StringBuilder text = new StringBuilder();
        for (int n = 1; n <= accID.length; n++) {
            if (n % 4 == 0) { text.append("-").append(accID[n - 1]); }
            else { text.append(accID[n - 1]); }
        }
        return text.toString();
    }
}
