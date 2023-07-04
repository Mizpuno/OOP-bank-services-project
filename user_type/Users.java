package Bank.user_type;

import Bank.*;
import Bank.localdata.Databases;
import Bank.notations.*;
import Bank.services.Client;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Users extends Person implements Databases {
    static Scanner input = new Scanner(System.in);
    private Vector<Accounts> current_package = new Vector<>();
    private Accounts temporary;
    private boolean services, nextCall, onload;

    private double[] acc_balance_outside = new double[10];
    private double[] plan; // [0, 20, 30]
    private double[] plan2;
    private double[] plan3;
    private String check_detail = "0", check_detail1 = "0", check_detail2 = "0", confirm = null;

    private double loanR = 0, LotsHIGH = 0, LotsMEDIUM = 0, LotsLOW = 0;

    public Users(String pin, Accounts temporary) {
        super(pin);
        this.temporary = temporary;
    }

    @Override
    public String userInformation() {
        return null;
    }

    public static void userLoadData(String user_pin, String ref)  {
        HashMap<String, Users> getHash = Databases.users_package;
        if (getHash.containsKey(ref)) {
            getHash.get(ref).panel(user_pin);
        } else new ErrorNotation(102);
    }

    private void panel(String user_pin) {
        Accounts get_account = authorize(user_pin, temporary);

        if (services) {
            if (!nextCall) {
                current_package.add(get_account);
                Databases.accountsVector.add(get_account);
                nextCall = true;
            }
            new Client(current_package,this);
            new CompleteNotation(1);
            Client.runServices();
        }
    }

    private Accounts authorize(String user_pin, Accounts target) {
        this.services = getUser_pin().equals(user_pin);
        if (this.services) return target;
        else new ErrorNotation(101);
        return null;
    }

    public Accounts authorize(Vector<Accounts> current_package) {
        System.out.print("""
                                              
                            \033[0;93mTransaction \033[0;90m--- \u001B[0m(Step 2/3)
                            This is the available account lists for you.
                            """);
        for (int n = 0; n < current_package.size(); n++) {
            System.out.println("            [" + n + "] " + " " + current_package.get(n).getACC_ID());
        }
        System.out.print("\033[0;32m[USER]\u001B[0m fill up to complete: ");
        String select = input.next();
        try {
            int selectToInt = Integer.parseInt(select);
            if (selectToInt >= 0 && selectToInt < current_package.size()) {
                System.out.print("""
                                              
                            \033[0;93mTransaction \033[0;90m--- \u001B[0m(Step 3/3)
                            Please Input your password collectly.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                String user_pin = input.next();
                return this.authorize(user_pin, current_package.get(selectToInt));
            } else {
                new ErrorNotation(203);
                return authorize(current_package);
            }
        }
        catch (NumberFormatException e) {
            new ErrorNotation(203);
            return authorize(current_package);
        }
    }

    public void setAcc_balance_outside(int index, double balance) {
        acc_balance_outside[index] = balance;
    }
    public double[] getAcc_balance_outside() {
        return acc_balance_outside;
    }

    public void  setPlan(double[] plan) {
        this.plan = plan;
    }
    public double[] getPlan() {
        return plan;
    }

    public void  setPlan3(double[] plan3) {
        this.plan3 = plan3;
    }
    public double[] getPlan3() {
        return plan3;
    }

    public void  setPlan2(double[] plan2) {
        this.plan2 = plan2;
    }
    public double[] getPlan2() {
        return plan2;
    }

    public void setCheck_detail(String check_detail) {
        this.check_detail = check_detail;
    }
    public String getCheck_detail() {
        return check_detail;
    }

    public void setCheck_detail1(String check_detail1) {
        this.check_detail1 = check_detail1;
    }
    public String getCheck_detail1() {
        return check_detail1;
    }

    public void setCheck_detail2(String check_detail2) {
        this.check_detail2 = check_detail2;
    }
    public String getCheck_detail2() {
        return check_detail2;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    public String getConfirm() {
        return confirm;
    }

    public void setLotsHIGH(double lotsHIGH) {
        LotsHIGH = lotsHIGH;
    }
    public double getLotsHIGH() {
        return LotsHIGH;
    }

    public void setLotsMEDIUM(double lotsMEDIUM) {
        LotsMEDIUM = lotsMEDIUM;
    }
    public double getLotsMEDIUM() {
        return LotsMEDIUM;
    }

    public void setLotsLOW(double lotsLOW) {
        LotsLOW = lotsLOW;
    }
    public double getLotsLOW() {
        return LotsLOW;
    }

    public double getLoanR() {
        return loanR;
    }

    public void setLoanR(double loanR) {
        this.loanR = loanR;
    }
}
