package Bank.services.commons;

import Bank.notations.ErrorNotation;
import Bank.services.exchanges.Exchange;
import Bank.services.exchanges.currency_type.*;
import Bank.user_type.Users;

import java.util.Scanner;

import static Bank.services.Client.callStepFirst;

public class Exchange_Unit {
    Scanner input = new Scanner(System.in);
    Users current_user;

    public Exchange_Unit (Users current_user) {
        this.current_user = current_user;
    }
    public void runUnit() {
        String check = "";
        String money;
        Exchange tranfer = null;
        String error = "none";
        int moneynum = 0;
        while (true) {
            System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mExchange Services \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                                    Choose a country currency that you prefer from the list below.\tExchange Rate (Baht.)
                                    \033[0;93m01:\u001B[0m                                United State.\t\t\t\t\t\033[0;90m30.82\u001B[0m
                                    \033[0;93m02:\u001B[0m                              United Kingdom.\t\t\t\t\t\033[0;90m37.33\u001B[0m
                                    \033[0;93m03:\u001B[0m                                       Japan.\t\t\t\t\t\033[0;90m37.33\u001B[0m
                                    \033[0;93m04:\u001B[0m                                   Hong Kong.\t\t\t\t\t\033[0;90m3.944\u001B[0m
                                    \033[0;93m05:\u001B[0m                                       Korea.\t\t\t\t\t\033[0;90m0.0254\u001B[0m
                                    \033[0;93m06:\u001B[0m                                   Singapore.\t\t\t\t\t\033[0;90m22.267\u001B[0m
                                    \033[0;93m07:\u001B[0m                                     Vietnam.\t\t\t\t\t\033[0;90m0.00133\u001B[0m
                                    \033[0;93m08:\u001B[0m                                       China.\t\t\t\t\t\033[0;90m4.322\u001B[0m
                                    \033[0;93m09:\u001B[0m                                      Taiwan.\t\t\t\t\t\033[0;90m0.982\u001B[0m
                                    \033[0;93m10:\u001B[0m                                   Australia.\t\t\t\t\t\033[0;90m20.904\u001B[0m
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-10 :\s""");
            check = input.next();

            if (check.equals("00")||check.equals("0")) {
                break;
            } else {
                money = callStepFirst();

                if (money.matches("[0-9]+")) {
                    if (check.equals("01")||check.equals("1")) {
                        tranfer = new Usd(0, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();

                    } else if (check.equals("02")||check.equals("2")) {
                        tranfer = new Gbp(1, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check(); //add statement

                    } else if (check.equals("03")||check.equals("3")) {
                        tranfer = new Jyp(2, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();//add statement

                    } else if (check.equals("04")||check.equals("4")) {
                        tranfer = new Hkd(3, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();   //add statement

                    } else if (check.equals("05")||check.equals("5")) {
                        tranfer = new Krw(4, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();//add statement

                    } else if (check.equals("06")||check.equals("6")) {
                        tranfer = new Sgd(5, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check(); //add statement

                    } else if (check.equals("07")||check.equals("7")) {
                        tranfer = new Vnd(6, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();  //add statement

                    } else if (check.equals("08")||check.equals("8")) {
                        tranfer = new Cny(7, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();  //add statement

                    } else if (check.equals("09")||check.equals("9")) {
                        tranfer = new Twd(8, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();//add statement

                    } else if (check.equals("10")) {
                        tranfer = new Aud(9, current_user);
                        tranfer.Calculate(money);
                        tranfer.display();
                        tranfer.check();//add statement
                    }
                } else {
                    new ErrorNotation(104);
                    runUnit();
                }

            }
        }
    }
}