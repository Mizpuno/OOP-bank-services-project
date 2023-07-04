package Bank.services.ecorisks;

import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.user_type.Users;
import java.util.Scanner;


import static Bank.services.Client.callAuthorize;

public class Investment implements AuthorizeFunc {


    Scanner sc = new Scanner(System.in);
    private final Users current_user;
    private int current_check;
    private double current_amount, PortLOW, PortMEDIUM, PortHIGH;

    public Investment(Users current_user) {
        this.current_user = current_user;
        PortLOW = current_user.getLotsLOW();
        PortMEDIUM = current_user.getLotsMEDIUM();
        PortHIGH = current_user.getLotsHIGH();
    }

    protected static double priceLO = 35.12;
    private static double priceME = 35.89;
    private static double priceHI = 37.41;
    private static double OldPriceLO = 35.12;
    private static double OldPriceME = 35.89;
    private static double OldPriceHI = 37.41;
    private int randomIndexL;
    private int randomIndexH;
    private int randomIndexM;
    private String input;

    @Override
    public void runFunction() {
        switch (current_check) {
            case 1 -> current_user.setLotsLOW(PortLOW-=current_amount); // function เพิ่มLotsLOW()ครับ
            case 2 -> current_user.setLotsMEDIUM(PortMEDIUM-=current_amount); // function เพิ่มLotsLOW()ครับ
            case 3 -> current_user.setLotsHIGH(PortHIGH-=current_amount); // function เพิ่มLotsHIGH()ครับ
        }
    }

    public void BuyInvest(double Amount, double Type , int Check) {


        do {
            double Price = Amount * Type;
            Price = Math.round(Price * 100.0) / 100.0;
            System.out.print("""
                                              
                                 \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

            System.out.println("\033[40mAmount to be paid in buy \033[0;92m " + Amount + "\u001B[0m Lots is. \033[0;94m" + Price + "\u001B[0m Baht.");
            System.out.print("""
                    
                    \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                    \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
            input = sc.nextLine();
            if (input.matches("[0-9]")) {
                int x = Integer.parseInt(input);
                if (x == 1) {

                    callAuthorize(Double.toString(Price), 1); // function ลดเงินจ้าาา
                    if (Client.getLasted_account_usage().getAcc_balance() >= Price) { // function เช็คเงินจ้าาา

                        switch (Check) {
                            case 1 -> current_user.setLotsLOW(PortLOW += Amount);

                            case 2 -> current_user.setLotsMEDIUM(PortMEDIUM += Amount);
                            case 3 -> current_user.setLotsHIGH(PortHIGH += Amount);

                        }
                        break;
                    }
                    //else {
                    //    new ErrorNotation(201); // balance insufficient.
                    //}
                    break;

                } else if (x == 2) {
                    break;
                } else {
                    new ErrorNotation(105);
                    //System.out.println("PLEASE TRY AGAIN");
                }
            }else {new ErrorNotation(103);}
        } while (!input.equals("0"));
    }

    public void SellInvest(double Amount, double Type, int Check) {
        do {
            current_check = Check;
            current_amount = Amount;

            double Price = Amount * Type;
            Price = Math.round(Price * 100.0) / 100.0;
            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

            System.out.println("\033[40mAmount of money recieved from sale \033[0;92m " + Amount + "\u001B[0m Lots is. \033[0;94m" + Price + "\u001B[0m Baht.");
            System.out.print("""
                    
                    \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                    \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
            input = sc.nextLine();
            if (input.matches("[0-9]")) {
                int x = Integer.parseInt(input);
                if (x == 1) {
                    switch (Check) {
                        case 1 -> {
                            if (PortLOW >= Amount) {
                                callAuthorize(Double.toString(Price), 0, this);
                            } else new ErrorNotation(111);

                        }
                        case 2 -> {
                            if (PortMEDIUM >= Amount) {
                                callAuthorize(Double.toString(Price), 0, this);

                            } else new ErrorNotation(111);
                        }
                        case 3 -> {
                            if (PortHIGH >= Amount) {
                                callAuthorize(Double.toString(Price), 0, this);

                            } else new ErrorNotation(111);
                        }
                    }
                    break;
                } else if (x == 2) {
                    break;

                } else {
                    new ErrorNotation(105);}

            } else {
                new ErrorNotation(103);
                //System.out.println("PLEASE TRY AGAIN");
            }
        } while (!input.equals("0"));
    }


    public void investHi() {
        int[] IndexHI = {-14, -10, -5, -2, 2, 3, 5, 20};
        int Index = (int) (Math.random() * IndexHI.length);
        randomIndexH = IndexHI[Index];
        priceHI += (randomIndexH*0.01) * priceHI;
        priceHI = Math.round(priceHI * 100.0) / 100.0;

    }

    public void investLo() {
        int[] IndexLO = {-2, -1, -1,  0, 0, 0, 0, 0, 1, 1, 2};
        int Index = (int) (Math.random() * IndexLO.length);
        randomIndexL = IndexLO[Index];
        priceLO +=(randomIndexL*0.01) * priceLO;
        priceLO = Math.round(priceLO * 100.0) / 100.0;


    }

    public void investMe() {
        int[] IndexME = {-4, -4, -3, -2, -2, 0, 2, 2, 3, 4, 4};
        int Index = (int) (Math.random() * IndexME.length);
        randomIndexM = IndexME[Index];
        priceME += (randomIndexM*0.01) * priceME;
        priceME = Math.round(priceME * 100.0) / 100.0;

    }

    public void displayInvest() {

        String Color1;
        String Color2;
        String Color3;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\u001B[40m#Board====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====| \u001B[0m");
        String RESET_Colors = "\u001B[0m";
        if (priceLO > OldPriceLO) {
            Color1 = "\u001B[32m";
        } else if (priceLO == OldPriceLO) {
            Color1 = "\u001B[33m";
        } else {
            Color1 = "\u001B[31m";
        }
        if (priceME > OldPriceME) {
            Color2 = "\u001B[32m";
        } else if (priceME == OldPriceME) {
            Color2 = "\u001B[33m";
        } else {
            Color2 = "\u001B[31m";
        }
        if (priceHI > OldPriceHI) {
            Color3 = "\u001B[32m";
        } else if (priceHI == OldPriceHI) {
            Color3 = "\u001B[33m";
        } else {
            Color3 = "\u001B[31m";
        }


//LOW-RISK
        System.out.print("\u001B[40mGBF-L: ");
        int i1;
        int i2;
        int i3;

        for (i1 = 3; i1 < priceLO ; i1++) {
            System.out.print(" ");
        }
        System.out.print(Color1 + "X" +RESET_Colors);
        System.out.print("\u001B[40m");
        for (int a=0; a < 90-i1 ; a++) {

            System.out.print(" ");
        }
        System.out.print("| \u001B[0m");
        System.out.println(" ");
//MEDIUM-RISK
        System.out.print("\u001B[40mBF-M : ");
        for ( i2 = 3; i2 < priceME ; i2++) {
            System.out.print(" ");
        }
        System.out.print(Color2 + "X"+RESET_Colors);
        System.out.print("\u001B[40m");
        for (int a=0; a < 90-i2 ; a++) {

            System.out.print(" ");
        }
        System.out.print("| \u001B[0m");
        System.out.println(" ");
//HIGH-RISK
        System.out.print("\u001B[40mSF-H : ");
        for (i3 = 3; i3 < priceHI ; i3++) {
            System.out.print(" ");
        }
        System.out.print(Color3 + "X"+RESET_Colors);
        System.out.print("\u001B[40m");
        for (int a=0; a < 90-i3 ; a++) {
            System.out.print(" ");
        }
        System.out.print("| \u001B[0m");
        System.out.println(" ");
        System.out.println("\u001B[40mPrice:====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====|====| "+RESET_Colors);
        System.out.println("\u001B[40m\u001B[35m     ^         ^         ^         ^         ^         ^         ^         ^         ^           "+RESET_Colors);
        System.out.println("\u001B[40m\u001B[35m     0         10        20        30        40        50        60        70        80          "+RESET_Colors);
        System.out.println(" ");


        System.out.println(Color1 + "                      PrizeL = " + priceLO + "  \u001B[0m| " + Color1 + "IndexL = " + randomIndexL + RESET_Colors);
        System.out.println(Color2 + "                      PrizeM = " + priceME + "  \u001B[0m| " + Color2 + "IndexM = " + randomIndexM + RESET_Colors);
        System.out.println(Color3 + "                      PrizeH = " + priceHI + "  \u001B[0m| " + Color3 + "IndexH = " + randomIndexH + RESET_Colors);

        OldPriceME = priceME;
        OldPriceLO = priceLO;
        OldPriceHI = priceHI;


    }

    public void runUnit() {
        String choose;
        int chooseToInt = 0;
        investHi();
        investMe();
        investLo();

        do {
            displayInvest();
            do {
                System.out.print("""
                                                            
                                       \033[0;90m<< \033[0;93mInvestment Services \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                        Choose a service provider from this list below.
                        \033[0;93m01:\u001B[0m                    GovernmentBondFund <LOW>.
                        \033[0;93m02:\u001B[0m                      Balanced Fund <Medium>.
                        \033[0;93m03:\u001B[0m                          Sector Fund <HIGH>.
                        \033[0;93m04:\u001B[0m                             INVESTMENT PORT
                        \033[0;93m00:\u001B[0m                                Back to menu.
                        \033[0;32m[USER]\u001B[0m select only 0-4 :\s""");

                choose = sc.nextLine();
                try {
                    chooseToInt = Integer.parseInt(choose);
                } catch (NumberFormatException e) {
                    new ErrorNotation(105);
                }
            }while (chooseToInt<0);

            String CASE;
            switch (chooseToInt) {
                case 1 -> {
                    System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                    System.out.println("\033[40m      Selected \" GovernmentBondFund <LOW> \" as a target provider     \u001B[0m\n" +
                            "Now prices is " + priceLO + " (" + randomIndexL + ")");
                    System.out.print("""
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \u001B[42m\t\t1.BUY\t\t\u001B[0m     \u001B[41m\t\t2.SALE\t\t\u001B[0m
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    CASE = sc.nextLine();
                    switch (CASE) {
                        case "1" -> {
                            //System.out.println("Balanced in Account : "+ balance);
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    Please Enter the Amount of BUY GovernmentBondFund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                BuyInvest(amount, priceLO, 1);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        case "2"  -> {
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                            System.out.println("\033[40m      PORT-LOW Amount : \" " + PortLOW + " \"      \u001B[0m");
                            System.out.print("""
                                    Please Enter the Amount of BUY GovernmentBondFund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                SellInvest(amount, priceLO, 1);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        default -> new ErrorNotation(105); // doesn't match choices.
                    }
                }
                case 2 -> {
                    System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                    System.out.println("\033[40m      Selected \" Balanced Fund <Medium> \" as a target provider     \u001B[0m\n" +
                            "Now prices is " + priceME + " (" + randomIndexM + ")");
                    System.out.print("""
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \u001B[42m\t\t1.BUY\t\t\u001B[0m     \u001B[41m\t\t2.SALE\t\t\u001B[0m
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    CASE = sc.nextLine();
                    switch (CASE) {
                        case "1" -> {
                            //System.out.println("Balanced in Account : "+ balance);
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    Please Enter the Amount of BUY Balanced Fund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                BuyInvest(amount, priceME, 2);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        case "2" -> {
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                            System.out.println("\033[40m      PORT-MEDIUM Amount : \" " + PortMEDIUM + " \"      \u001B[0m");
                            System.out.print("""
                                    Please Enter the Amount of BUY Balanced Fund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                SellInvest(amount, priceME, 2);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        default -> new ErrorNotation(105); // doesn't match choices.
                    }
                }
                case 3 -> {
                    System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                    System.out.println("\033[40m      Selected \" Sector Fund <HIGH> \" as a target provider     \u001B[0m\n" +
                            "Now prices is " + priceHI + " (" + randomIndexH + ")");
                    System.out.print("""
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \u001B[42m\t\t1.BUY\t\t\u001B[0m     \u001B[41m\t\t2.SALE\t\t\u001B[0m
                            \u001B[42m\t\t     \t\t\u001B[0m     \u001B[41m\t\t      \t\t\u001B[0m
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    CASE = sc.nextLine();
                    switch (CASE) {
                        case "1" -> {
                            //System.out.println("Balanced in Account : "+ balance);
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    Please Enter the Amount of BUY Sector Fund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                BuyInvest(amount, priceHI, 3);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        case "2" -> {
                            System.out.print("""
                                              
                                    \033[0;93mInvestment Service\033[0;90m--- \u001B[0mProcessing
                                    """);

                            System.out.println("\033[40m      PORT-HIGH Amount : \" " + PortHIGH + " \"      \u001B[0m");
                            System.out.print("""
                                    Please Enter the Amount of BUY Sector Fund.   \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            input = sc.nextLine();
                            if (input.equals("0")) {
                                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                            } else if (input.matches("[0-9]+")) {
                                double amount = Double.parseDouble(input);
                                SellInvest(amount, priceHI, 3);
                            } else {
                                new ErrorNotation(104); // doesn't money.
                            }
                        }
                        default -> new ErrorNotation(105); // doesn't match choices.
                    }
                }
                case 4 -> {
                    System.out.print("""
                            
                            \033[0;93mStock wallet \033[0;90m--- \u001B[0mResult
                            this is the overview of your stock wallet balances.
                            
                            \033[0;32mTypes               Values \033[0;90m[Coin Unit]\u001B[0m
                            """);
                    System.out.println("PORT-LOW            " + PortLOW);
                    System.out.println("PORT-MEDIUM         " + PortMEDIUM);
                    System.out.println("PORT-HIGH           " + PortHIGH + "\n");
                }
                case 0 -> {

                }
                default ->
                        new ErrorNotation(105);
            }

        } while (chooseToInt != 0);

    }
}