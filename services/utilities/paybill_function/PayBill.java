package Bank.services.utilities.paybill_function;

import Bank.localdata.SlipPattern;
import Bank.notations.ErrorNotation;
import Bank.services.commons.PayBill_Unit;
import java.util.Scanner;

public class PayBill implements SlipPattern {
    Scanner kb = new Scanner(System.in);
    private String type;
    private String phoneNumber; //Telephone Bill
    private String accountNumber; //Water Bill
    private String contractAccountNo; //Electric Bill
    private String taxID; //Tax Bill
    private String controlCode; //Tax Bill

    public String getType(){
        return type;
    }
    public void setType(int choice){
        if(choice == 1){
            type = "Water Bill";
        }else if(choice == 2){
            type = "Electric Bill";
        }else if(choice == 3){
            type = "Tax Bill";
        }else if(choice == 4){
            type = "Telephone Bill";
        }
    }

    public void waterBill(String accountNumber){
        if (accountNumber.length() == 8 && accountNumber.matches("\\d+")) {
            this.accountNumber = accountNumber;
        }
        else {
            new ErrorNotation(109);
            String number = kb.nextLine();
            this.waterBill(number);//set accountNumber
        }
    }


    public void electricBill(String contractAccountNo){
        if (contractAccountNo.length() == 9 && contractAccountNo.matches("\\d+")) {
            this.contractAccountNo = contractAccountNo;
        }
        else {
            new ErrorNotation(109);

            String number = kb.nextLine();
            this.electricBill(number);//set contractAccountNo
        }
    }


    public void taxBill(String taxID , String controlCode) {

        if (taxID.length() == 13 && taxID.matches("\\d+")) {
            this.taxID = taxID;
            if(controlCode.length() == 15 && controlCode.matches("\\d+")){
                this.controlCode = controlCode;
            }else {
                new ErrorNotation(108);

                String code = kb.nextLine();
                this.taxBill(taxID,code);//set Tax ID  and Control Code
            }
        }else {
            new ErrorNotation(107);//

            System.out.print("""
                                    Please enter Tax ID (13 digits) (do not enter - )  \033[0;90m[ Back to Menu press 0 ]
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            String id = kb.nextLine();
            System.out.print("""
                                    Please enter control code (15 digits) (do not enter - )
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
            String code = kb.nextLine();
            this.taxBill(id,code);//set Tax ID  and Control Code
        }
    }

    public void telephoneBill(String phone){
        if (phone.length() == 10 && phone.matches("\\d+")) {
            if (phone.indexOf("09") == 0 || phone.indexOf("08") == 0 || phone.indexOf("06") == 0) {
                phoneNumber = phone;
            }else {
                new ErrorNotation(106);
                String number = kb.nextLine();
                this.telephoneBill(number);//set เบอร์
            }
        } else {
            new ErrorNotation(106);
            String number = kb.nextLine();
            this.telephoneBill(number);//set เบอร์
        }
    }

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return switch (type) {
            case "Water Bill" -> "              \033[0;93mPayBill Details\u001B[0m              \n" +
                    "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                    "To  \tBill of - \033[0;94m" + type + "\u001B[0m (\033[0;90m" + accountNumber + "\u001B[0m)\n" +
                    "Note :: " + note +
                    "\n\033[40m                                              \u001B[0m\n";

            case "Electric Bill" -> "              \033[0;93mPayBill Details\u001B[0m              \n" +
                    "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                    "To  \tBill of - \033[0;94m" + type + "\u001B[0m (\033[0;90m" + contractAccountNo + "\u001B[0m)\n" +
                    "Note :: " + note +
                    "\n\033[40m                                              \u001B[0m\n";

            case "Tax Bill" ->  "              \033[0;93mPayBill Details\u001B[0m              \n" +
                    "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                    "To  \tBill of - \033[0;94m" + type + "\u001B[0m (\033[0;90m" + taxID + "\u001B[0m)\n" +
                    "    \tControl Code - \033[0;94m" + controlCode +
                    "\n\u001B[0mNote :: " + note +
                    "\n\033[40m                                              \u001B[0m\n";

            case "Telephone Bill" -> "              \033[0;93mPayBill Details\u001B[0m              \n" +
                    "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                    "To  \tBill of  - \033[0;94m" + type + "\u001B[0m (\033[0;90m" + phoneNumber + "\u001B[0m)\n" +
                    "Note :: " + note +
                    "\n\033[40m                                              \u001B[0m\n";

            default -> "";
        };
    }

}
