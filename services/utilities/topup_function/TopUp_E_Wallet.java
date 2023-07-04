package Bank.services.utilities.topup_function;

import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;

import static Bank.services.Client.callAuthorize;

public class TopUp_E_Wallet extends TopUp implements AuthorizeFunc {
    private String text;
    @Override
    public void runFunction() {
        System.out.println(text);
    }
    @Override
    public void setType(int choice){
        if(choice == 1){
            type = "TrueMoney wallet";
            minimum_TopUp = 100;
            max_TopUp = 5000;

        }else if(choice == 2){
            type = "Promptpay";  //ไม่มีขั้นต่ำ ไม่มีสูงสุด
            minimum_TopUp = 0;
            max_TopUp = Double.MAX_VALUE;

        }else if(choice == 3){
            type = "ShopeePay";
            minimum_TopUp = 200;
            max_TopUp = 5000;

        }else if(choice == 4){
            type = "Rabbit Line Pay";
            minimum_TopUp = 300;
            max_TopUp = 50000;

        }else if(choice == 5){
            type = "Kurry Wallet";
            minimum_TopUp = 100;
            max_TopUp = 50000;
        }
    }

    public void check_minimum_max(String note, String payment){
        double payToDouble = 0;

        try { payToDouble = Double.parseDouble(payment); }
        catch (NumberFormatException e) { new ErrorNotation(103); }
        if(payToDouble < minimum_TopUp || payToDouble > max_TopUp){ //ถ้าไม่ตรงตามเงื่อนไข
            new ErrorNotation(300);//จำนวนเงินไม่ตรงตามเงื่อนไขที่ระบุ & กรุณากรอกจำนวนเงินที่ต้องการชำระใหม่อีกครั้งค่ะ
            String pay = kb.next();
            check_minimum_max(note, pay); //เรียก method check_minimum
        }else{
            try {
                text = slip(note, payment, Client.getLasted_account_usage().getBundle());
                callAuthorize(payment, 1, this);
            } catch (NullPointerException e) {
                new ErrorNotation(301);
            }
        }
    }

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return super.slip(note, cost, bundle);
    }
}