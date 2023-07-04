package Bank.services.utilities.transfer_function;

import Bank.notations.ErrorNotation;
import Bank.services.commons.PayBill_Unit;

public class Transfer_Bank extends Transfer{
    public void setType(int choice) {
        if (choice == 1) {
            bank = "BANGKOK BANK"; //กรุงเทพ 10
        } else if (choice == 2) {
            bank = "BANK OF AYUDHYA"; //กรุงศรีอยุธยา 10
        } else if (choice == 3) {
            bank = "KASIKORNBANK"; //กสิกรทย 10
        } else if (choice == 4) {
            bank = "KRUNG THAI BANK"; //กรุงไทย 10
        } else if (choice == 5) {
            bank = "SIAM COMMERCIAL BANK"; //ไทยพาณิชย์ 10
        } else if (choice == 6) {
            bank = "TMB BANK"; //ทหารไทย 10
        } else if (choice == 7) {
            bank = "GOVERNMENT SAVINGS BANK"; //ออมสิน 12 หรือ 15 หลัก
        } else if (choice == 8) {
            bank = "UNION OVERSEAS BANK"; //ยูโอบี 10
        }else if (choice == 9) {
            bank = "DII BANKING"; //DII 10
        }
    }

    @Override
    public void setacNumber(String accountNumber) {
        if (bank.equals("GOVERNMENT SAVINGS BANK")) { //ออมสิน 12 หรือ 15 หลัก
            if (accountNumber.length() == 12 || accountNumber.length() == 15 && accountNumber.matches("\\d+")) {
                acNumber = accountNumber;
            } else {
                new ErrorNotation(109);
                String number = kb.nextLine();
                this.setacNumber(number);//set เบอร์
            }
        } else if (accountNumber.length() == 10 && accountNumber.matches("\\d+")) { //ธนาคารอื่น 10หลัก
            acNumber = accountNumber;

        }else {
            new ErrorNotation(109);
            String number = kb.nextLine();
            this.setacNumber(number);//set เบอร์
        }
    }



}