package Bank.services.utilities.transfer_function;

import Bank.localdata.SlipPattern;

import java.util.Scanner;

abstract class Transfer implements SlipPattern {
    public Scanner kb = new Scanner(System.in);
    protected String bank;
    protected String acNumber;

    public String getbank(){
        return bank;
    }

    abstract void setacNumber(String accountNumber);

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return "             \033[0;93mTransfer Details\u001B[0m             \n" +
                "From\tUsername - \033[0;94m" + bundle[0] + "\u001B[0m (\033[0;90m" + bundle[2] +"\u001B[0m)\n" +
                "To  \tBank     - \033[0;94m" + bank + "\u001B[0m (\033[0;90m" + acNumber + "\u001B[0m)\n" +
                "Note :: " + note +
                "\n\033[40m                                              \u001B[0m\n";
    }


}