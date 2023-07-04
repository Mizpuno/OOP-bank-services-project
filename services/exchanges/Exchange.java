package Bank.services.exchanges;

import Bank.localdata.AuthorizeFunc;
import Bank.localdata.SlipPattern;
import Bank.notations.CompleteNotation;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.user_type.Users;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import static Bank.services.Client.callAuthorize;

public abstract class Exchange implements AuthorizeFunc, SlipPattern {
    private int index = 0;
    private String money, note;
    private double outside_balance;
    Users current_user;
    Scanner input = new Scanner(System.in);

    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");//แปลงวันที่
    String formattedDate = myDateObj.format(myFormatObj);//เอาตัวนี้ไปใช้ add statement ได้

    public Exchange(int index, Users current_user) {
        this.current_user = current_user;
        this.index = index;
    }

    @Override
    public void runFunction() {
        current_user.setAcc_balance_outside(index, outside_balance);
        System.out.println(slip(note, money, Client.getLasted_account_usage().getBundle()));
    }

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return "               \033[0;93mExchange Details\u001B[0m               \n" +
                "From\tOur Currency   - \033[0;94mThai\u001B[0m : " + cost + "\n" +
                "To  \tOther Currency - \033[0;94m" + exchange() + "\u001B[0m : " + outside_balance + "\n" +
                "Note :: " + note +
                "\n\033[40m                                              \u001B[0m\n";
    }

    public abstract double exchange();

    public abstract String Description();

    public void Calculate(String money) {
        try {
            double moneyToDouble = Double.parseDouble(money);
            outside_balance += moneyToDouble;
            this.money = Double.toString(moneyToDouble * exchange());
        } catch (NumberFormatException e) {
            new ErrorNotation(104);
        }

    }

    public String getCalculate() {
        return this.money;
    }

    public void display() {
        System.out.print("""
                                              
                                    \033[0;93mExchange Service\033[0;90m--- \u001B[0mProcessing
                                    """);

        System.out.println("\033[40m      From \" Thai Baht. \" To \" " + Description() + " \"     \u001B[0m");
        System.out.print("This is the summary cost : \033[0;93m" + getCalculate() + "\u001B[0m Baht.\n");
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    
                    \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                    \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            String confirm = scanner.next();
            if (confirm.equals("1")) {
                //เอา getCalculate มาใช้ ในการส่งค่าลบเงิน
                System.out.print("Note : ");
                note = input.next();

                callAuthorize(getCalculate(), 1, this);

                break;
            } else if (confirm.equals("2")) {
                new CompleteNotation(201);
                break;
            } else {
                new ErrorNotation(105);
            }
        }
    }

}
