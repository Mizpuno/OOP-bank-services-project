package Bank.services.commons;

import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.services.utilities.paybill_function.PayBill;

import java.util.Scanner;

import static Bank.services.Client.*;

public class PayBill_Unit implements AuthorizeFunc {
    Scanner input = new Scanner(System.in);
    private String text;
    @Override
    public void runFunction() {
        System.out.println(text);
    }

    public void runUnit() {
        do {
            PayBill payBill = new PayBill(); //create obj
            int servicenum = 0;
            String error;

            do{ //ลูป หากใส่เลขผิด เช่น ไปใส่เป็นตัวอักษร ให้ใส่เลขใหม่
                System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mPayBill Services \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                                    Choose a bills type from the bill lists below.
                                    \033[0;93m01:\u001B[0m                                  Water Bill.
                                    \033[0;93m02:\u001B[0m                               Electric Bill.
                                    \033[0;93m03:\u001B[0m                                    Tax Bill.
                                    \033[0;93m04:\u001B[0m                              Telephone Bill.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-4 :\s""");
                String service = input.next();
                error = "none";

                try {
                    servicenum = Integer.parseInt(service); //แปลง String to int
                } catch (NumberFormatException e) { //หากเจอ error
                    error = "error";
                    new ErrorNotation(103); // Display an error message
                }
            }while(error.equals("error"));
            payBill.setType(servicenum);

            if (servicenum==1) {
                //Water Bill
                System.out.print("""
                                              
                                    \033[0;93mPayBill Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                System.out.println("\033[40m      Selected \" " + payBill.getType() + " \" as a target provider     \u001B[0m");
                System.out.print("""
                                    Please enter Water Bill References (8 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String acNumber = input.next();
                if(acNumber.equals("0")){
                    break;
                }
                payBill.waterBill(acNumber);
                String cost = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                try {
                    text = payBill.slip(note, cost, Client.getLasted_account_usage().getBundle());
                    callAuthorize(cost, 1, this);
                } catch (NullPointerException e) {
                    new ErrorNotation(301);
                }
                break;
            }


            else if (servicenum==2) {
                //Electric Bill
                System.out.print("""
                                              
                                    \033[0;93mPayBill Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                System.out.println("\033[40m      Selected \" " + payBill.getType() + " \" as a target provider     \u001B[0m");
                System.out.print("""
                                    Please enter Electric Bill References (9 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String contractnum = input.next();
                if (!contractnum.matches("[0-9]")) {
                    new ErrorNotation(103);
                    runUnit();
                }
                if(contractnum.equals("0")){
                    break;
                }
                payBill.electricBill(contractnum);
                String cost = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                try {
                    text = payBill.slip(note, cost, Client.getLasted_account_usage().getBundle());
                    callAuthorize(cost, 1, this);
                } catch (NullPointerException e) {
                    new ErrorNotation(301);
                }
                break;

            }
            else if (servicenum==3) {
                //Tax Bill
                System.out.print("""
                                              
                                    \033[0;93mPayBill Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                System.out.println("\033[40m      Selected \" " + payBill.getType() + " \" as a target provider     \u001B[0m");
                System.out.print("""
                                    Please enter Tax ID (13 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String tax = input.next();
                if(tax.equals("0")){
                    break;
                }
                System.out.print("""
                                    Please enter control code (15 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String code = input.next();
                if(code.equals("0")){
                    break;
                }
                try {
                    Double.parseDouble(tax);
                    Double.parseDouble(code);
                } catch (NumberFormatException e) {
                    new ErrorNotation(103);
                    runUnit();
                }
                payBill.taxBill(tax,code);
                String cost = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                try {
                    text = payBill.slip(note, cost, Client.getLasted_account_usage().getBundle());
                    callAuthorize(cost, 1, this);
                } catch (NullPointerException e) {
                    new ErrorNotation(301);
                }
                break;

            }
            else if (servicenum==4) {
                //Telephone Bill
                System.out.print("""
                                    Please enter phone number (10 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String phone = input.next();
                if (!phone.matches("[0-9]")) {
                    new ErrorNotation(103);
                    runUnit();
                }
                if(phone.equals("0")){
                    break;
                }
                payBill.telephoneBill(phone);
                String cost = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                try {
                    text = payBill.slip(note, cost, Client.getLasted_account_usage().getBundle());
                    callAuthorize(cost, 1, this);
                } catch (NullPointerException e) {
                    new ErrorNotation(301);
                }
                break;

            }

            else if (servicenum==0) {
                break;
            }
            else{
                new ErrorNotation(105);
            }

        }while(true);
    }
}
