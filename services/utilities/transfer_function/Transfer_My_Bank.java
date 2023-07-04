package Bank.services.utilities.transfer_function;
import Bank.Accounts;
import Bank.localdata.AuthorizeFunc;
import Bank.localdata.Databases;
import Bank.notations.ErrorNotation;
import Bank.services.Client;

import java.util.Scanner;

import static Bank.services.Client.*;

public class Transfer_My_Bank extends Transfer implements AuthorizeFunc {
    Scanner input = new Scanner(System.in);
    private String text, cost;
    private Accounts target;

    @Override
    public void runFunction() {
        target.setAcc_balance(cost);
        System.out.println(text);
    }
    @Override
    void setacNumber(String accountNumber) {
        //หมายเลขบช
        acNumber = accountNumber;
    }

    public Accounts searchAcc_ID(String param) {
        for (Accounts x : Databases.accountsVector) {
            String[] temp = x.getACC_ID().split("-");
            StringBuilder acc_id = new StringBuilder();

            for (String n : temp) acc_id.append(n);
            if (acc_id.toString().equals(param)) {
                return x;
            }
        }
        return null;
    }

    public void transferBalance(Accounts target) {
        bank = "Dii Bank";
        setacNumber(target.getACC_ID());
        cost = callStepFirst();

        System.out.print("Note : ");
        String note = input.next();
        try {
            this.target = target;
            text = slip(note, cost, Client.getLasted_account_usage().getBundle());
            callAuthorize(cost, 1, this);
        } catch (NullPointerException e) {
            new ErrorNotation(301);
        }

    }
    @Override
    public String slip(String note, String cost, String[] bundle) {
        return "             \033[0;93mTransfer Details\u001B[0m             \n" +
                "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                "To  \tBank     - \033[0;94m" + bank + "\u001B[0m (\033[0;90m" + acNumber + "\u001B[0m)\n" +
                "Note :: " + note +
                "\n\033[40m                                              \u001B[0m\n";
    }
}