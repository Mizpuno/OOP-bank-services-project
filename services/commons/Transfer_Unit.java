package Bank.services.commons;

import Bank.Accounts;
import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.services.utilities.transfer_function.*;

import java.util.Scanner;

import static Bank.services.Client.*;

public class Transfer_Unit implements AuthorizeFunc {
    Scanner input = new Scanner(System.in);
    private String text;

    @Override
    public void runFunction() {
        System.out.println(text);
    }

    public void runUnit() {
        do{
            int selectToInt = 0;
            String errorX;
            do {
                System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mTransfer Services \033[0;90m>>     \033[0;93m(Page 1/2)\u001B[0m
                                    Choose a service that you prefer from list below.
                                    \033[0;93m01:\u001B[0m                                     My Bank.
                                    \033[0;93m02:\u001B[0m                                  Other Bank.
                                    \033[0;93m03:\u001B[0m                                  Prompt Pay.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-3 :\s""");
                String select = input.next();
                errorX = "none";

                try {
                    selectToInt = Integer.parseInt(select); //แปลง String to int
                } catch (NumberFormatException e) { //หากเจอ error
                    errorX = "error";
                    new ErrorNotation(103); // Display an error message
                }
            } while(errorX.equals("error"));


            if (selectToInt == 0) {
                break;
            }

// ----------- ธนาคารของฉัน
            label:
            do {
                switch (selectToInt) {
                    case 1 -> { //ธนาคารของฉัน
                        Transfer_My_Bank transfer = new Transfer_My_Bank(); //create obj
                        System.out.print("""
                                              
                                    \033[0;93mTransfer Service\033[0;90m--- \u001B[0mProcessing
                                    Please fill in the target account id from our bank.  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                        String get_id = input.next();
                        if (get_id.equals("0")) {
                            break label;
                        }

                        Accounts target = transfer.searchAcc_ID(get_id);
                        if (target != null) {
                            transfer.transferBalance(target);
                            break label;
                        } else System.out.println("Not Found.");
                    }
                    case 2 -> { //ธนาคารอื่น
                        int i = 0;
                        String error;

                        do { //ลูป หากใส่เลขผิด เช่น ไปใส่เป็นตัวอักษร ให้ใส่เลขใหม่
                            System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mTransfer Services \033[0;90m>>     \033[0;93m(Page 2/2)\u001B[0m
                                    Choose a bank that you prefer from list below.
                                    \033[0;93m01:\u001B[0m                                Bangkok Bank.
                                    \033[0;93m02:\u001B[0m                            Bank Of Ayudhaya.
                                    \033[0;93m03:\u001B[0m                               Kasikorn Bank.
                                    \033[0;93m04:\u001B[0m                             Krung Thai Bank.
                                    \033[0;93m05:\u001B[0m                        Siam Commercial Bank.
                                    \033[0;93m06:\u001B[0m                                    TMB Bank.
                                    \033[0;93m07:\u001B[0m                      Goverment Savings Bank.
                                    \033[0;93m08:\u001B[0m                         Union Overseas Bank.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-8 :\s""");
                            String bank = input.next();
                            error = "none";
                            try {
                                i = Integer.parseInt(bank); //แปลง String to int
                            } catch (NumberFormatException e) { //หากเจอ error
                                new ErrorNotation(103); // Display an error message
                                error = "error";
                            }
                            if (i < 0 || i > 8) {
                                new ErrorNotation(103); // Display an error message
                                error = "error";
                            }
                        } while (error.equals("error"));

                        if (i == 0) {
                            break label;
                        }

                        Transfer_Bank transfer = new Transfer_Bank(); //create obj


                        transfer.setType(i);
                        System.out.print("""
                                              
                                    \033[0;93mTransfer Service\033[0;90m--- \u001B[0mProcessing
                                    """);
                        System.out.println("\033[40m      Selected \" " + transfer.getbank() + " \" as a target provider     \u001B[0m");
                        if (transfer.getbank().equals("GOVERNMENT SAVINGS BANK")) {
                            System.out.print("""
                                    Please enter Account no. (12 or 15 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                        } else {
                            System.out.print("""
                                    Please enter Account no. (10 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                        }

                        String acNumber = input.next();
                        if (acNumber.equals("0")) {
                            break label;
                        }
                        transfer.setacNumber(acNumber);
                        System.out.print("Note : ");
                        String note = input.next();

                        String cost = callStepFirst();
                        try {
                            text = transfer.slip(note, cost, Client.getLasted_account_usage().getBundle());
                            callAuthorize(cost, 1, this);
                        } catch (NullPointerException e) {
                            new ErrorNotation(301);
                        }
                        break label;
//----------- PrompPay
                    }
                    case 3 -> { //PrompPay
                        Transfer_PromptPay transfer = new Transfer_PromptPay(); //create obj
                        transfer.setType();

                        System.out.print("""
                                              
                                    \033[0;93mTransfer Service\033[0;90m--- \u001B[0mProcessing
                                    """);
                        System.out.println("\033[40m      Selected \" " + transfer.getbank() + " \" as a target provider     \u001B[0m");
                        System.out.print("""
                                    Please enter Phone Number (10 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                        String acNumber = input.next();
                        if (acNumber.equals("0")) {
                            break label;
                        }
                        transfer.setacNumber(acNumber);
                        System.out.print("Note : ");
                        String note = input.next();

                        String cost = callStepFirst();
                        try {
                            text = transfer.slip(note, cost, Client.getLasted_account_usage().getBundle());
                            callAuthorize(cost, 1, this);
                        } catch (NullPointerException e) {
                            new ErrorNotation(301);
                        }
                        break label;
                    }
                    default -> {
                        new ErrorNotation(105);
                        break label;
                    }
                }
            }while (true);
        }while(true);
    }
}
