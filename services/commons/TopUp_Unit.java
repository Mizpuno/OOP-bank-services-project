package Bank.services.commons;

import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.services.utilities.topup_function.*;

import java.util.Scanner;

import static Bank.services.Client.*;

public class TopUp_Unit implements AuthorizeFunc {
    Scanner input = new Scanner(System.in);
    private String text;

    @Override
    public void runFunction() {
        System.out.println(text);
    }

    public void runUnit() {
        do {
            int i = 0;
            String error;

            do{ //ลูป หากใส่เลขผิด เช่น ไปใส่เป็นตัวอักษร ให้ใส่เลขใหม่
                System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mTopUp Services \033[0;90m>>     \033[0;93m(Page 1/2)\u001B[0m
                                    Choose the top-up target that you interested in
                                    \033[0;93m01:\u001B[0m                                Phone Number.
                                    \033[0;93m02:\u001B[0m                                    E-Wallet.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-2 :\s""");
                String service = input.next();
                error = "none";

                try {
                    i = Integer.parseInt(service); //แปลง String to int
                } catch (NumberFormatException e) { //หากเจอ error
                    error = "error";
                    new ErrorNotation(103); // Display an error message
                }
            }while(error.equals("error"));

            if (i == 1) {
                TopUp_ServiceProvider topup = new TopUp_ServiceProvider(); //create obj

                int service_provider = 0;

                do{ //ลูป หากใส่เลขผิด เช่น ไปใส่เป็นตัวอักษร ให้ใส่เลขใหม่
                    System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mTopUp Services \033[0;90m>>     \033[0;93m(Page 2/2)\u001B[0m
                                    Choose a service provider from this list below.
                                    \033[0;93m01:\u001B[0m                                         AIS.
                                    \033[0;93m02:\u001B[0m                                        Dtac.
                                    \033[0;93m03:\u001B[0m                                  Truemove H.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-3 :\s""");
                    String service = input.next();
                    error = "none";

                    try {
                        service_provider = Integer.parseInt(service); //แปลง String to int
                    } catch (NumberFormatException e) { //หากเจอ error
                        error = "error";
                        new ErrorNotation(103); // Display an error message
                    }
                    if(service_provider < 0 || service_provider > 3){ //เช็ควา่ใส่เลขถูกมั้ย
                        error = "error";
                        new ErrorNotation(103); // Display an error message
                    }
                }while(error.equals("error"));

                if (service_provider == 0) break;
                topup.setType(service_provider);

                System.out.print("""
                                              
                                    \033[0;93mTopUp Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                System.out.println("\033[40m      Selected \" " + topup.getType() + " \" as a target provider     \u001B[0m");
                System.out.print("""
                                    Please enter Phone Number (10 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

                String phone = input.next();
                if(phone.equals("0")){
                    break;
                }
                topup.setPhoneNumber(phone);
                String cost = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                try {
                    text = topup.slip(note, cost, Client.getLasted_account_usage().getBundle());
                    callAuthorize(cost, 1, this);
                } catch (NullPointerException e) {
                    new ErrorNotation(301);
                }
                break;

            } else if(i==2){
                TopUp_E_Wallet topup = new TopUp_E_Wallet(); //create obj

                int service_provider = 0;

                do{ //ลูป หากใส่เลขผิด เช่น ไปใส่เป็นตัวอักษร ให้ใส่เลขใหม่
                    System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mTopUp Services \033[0;90m>>     \033[0;93m(Page 2/2)\u001B[0m
                                    Choose a service provider from this list below.
                                    \033[0;93m01:\u001B[0m                            TrueMoney Wallet.
                                    \033[0;93m02:\u001B[0m                                   PromptPay.
                                    \033[0;93m03:\u001B[0m                                   ShopeePay.
                                    \033[0;93m04:\u001B[0m                             Rabbit Line Pay.
                                    \033[0;93m05:\u001B[0m                                Kurry Wallet.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-5 :\s""");
                    String service = input.next();
                    error = "none";

                    try {
                        service_provider = Integer.parseInt(service); //แปลง String to int
                    } catch (NumberFormatException e) { //หากเจอ error
                        error = "error";
                        new ErrorNotation(103); // Display an error message
                    }
                    if(service_provider < 0 || service_provider > 5){ //เช็ควา่ใส่เลขถูกมั้ย
                        error = "error";
                        new ErrorNotation(103); // Display an error message
                    }
                }while(error.equals("error"));

                if (service_provider == 0) break;
                topup.setType(service_provider);

                System.out.print("""
                                              
                                    \033[0;93mTopUp Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                System.out.println("\033[40m      Selected \" " + topup.getType() + " \" as a target provider     \u001B[0m");
                System.out.print("""
                                    Please enter Phone Number (10 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String phone = input.next();

                if(phone.equals("0")){
                    break;
                }
                topup.setPhoneNumber(phone);
                topup.display_condition_MinimumMax();
                String payment = callStepFirst();

                System.out.print("Note : ");
                String note = input.next();
                topup.check_minimum_max(note, payment);
                break; //ออกลูป menu top up

            }else if(i==0){
                break; //ออกลูป menu top up
            }
            else {
                new ErrorNotation(105);
            }
        }while(true);
    }
}
