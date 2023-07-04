package Bank.services.utilities.transfer_function;

import Bank.notations.ErrorNotation;
import Bank.services.commons.PayBill_Unit;

public class Transfer_PromptPay extends Transfer{

    public void setType(){
        bank = "Prompt Pay"; //Prompt Pay 10 tel
    }

    @Override
    public void setacNumber(String accountNumber) {
        if (accountNumber.length() == 10 && accountNumber.matches("\\d+")) {
            if (accountNumber.indexOf("09") == 0 || accountNumber.indexOf("08") == 0 || accountNumber.indexOf("06") == 0) {
                acNumber = accountNumber;
            } else {
                new ErrorNotation(106);
                String number = kb.nextLine();
                this.setacNumber(number);//set เบอร์
            }
        }else {
            new ErrorNotation(106);
            String number = kb.nextLine();
            this.setacNumber(number);//set เบอร์
        }
    }
}
