package Bank.services.utilities.topup_function;

import Bank.localdata.SlipPattern;
import Bank.notations.ErrorNotation;
import Bank.services.commons.PayBill_Unit;

import java.util.Scanner;

abstract class TopUp implements SlipPattern {
    Scanner kb = new Scanner(System.in);
    protected String type;
    protected String phoneNumber;
    protected double minimum_TopUp; //---------------ตัวแปร กำหนดเงินขั้นต่ำในการเติม
    protected double max_TopUp;

    public abstract void setType(int choice);

    public String getType(){
        return type;
    }

    public void display_condition_MinimumMax(){
        if(!type.equals("Promptpay")){
            //พร้อมเพย์ไม่จำกัด
            System.out.print("""
                    
                    \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                    \033[0;90m| Current provider has a money request at the minimum and maximum.
                    """);
            System.out.println("\033[0;90m| \033[0;91mMinimum cost\u001B[0m " + minimum_TopUp +
                    " THB. - \033[0;91mMaximum cost\u001B[0m " + max_TopUp + " THB.");
        }

    }

    public void setPhoneNumber (String phone){
        if (phone.length() == 10 && phone.matches("\\d+")) {
            if (phone.indexOf("09") == 0 || phone.indexOf("08") == 0 || phone.indexOf("06") == 0) {
                phoneNumber = phone;
            }else {
                new ErrorNotation(106);
                String number = kb.nextLine();
                this.setPhoneNumber(number);//set เบอร์
            }
        } else {
            new ErrorNotation(106);
            String number = kb.nextLine();
            this.setPhoneNumber(number);//set เบอร์
        }
    }

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return "               \033[0;93mTopUp Details\u001B[0m               \n" +
                "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                "To  \tService Provider - \033[0;94m" + type + "\u001B[0m (\033[0;90m" + phoneNumber + "\u001B[0m)\n" +
                "Note :: " + note +
                "\n\033[40m                                              \u001B[0m\n";
    }

}