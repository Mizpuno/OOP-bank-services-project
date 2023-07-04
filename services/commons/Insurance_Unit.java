package Bank.services.commons;

import Bank.notations.ErrorNotation;
import Bank.services.insurances.Accumulative;
import Bank.services.insurances.insurance_type.Dengue;
import Bank.services.insurances.insurance_type.HealthDiy;
import Bank.services.insurances.insurance_type.Pm25;
import Bank.user_type.Users;

import java.util.Scanner;

import static Bank.services.Client.callAuthorize;

public class Insurance_Unit {
    Users current_user;

    public Insurance_Unit(Users current_user) {
        this.current_user = current_user;
    }

    public void runUnit() {
        Scanner inputAcc = new Scanner(System.in);
        Accumulative accumulative;
        Dengue dengue = new Dengue(current_user);
        HealthDiy healthDiy = new HealthDiy(current_user);
        Pm25 pm25 = new Pm25(current_user);
        String checkAcc;
        String error = "none";
        String check_item;
        String select_number;
        double moneynum = 0;
        double total = 0;
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        while (true) {
            System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mInsurance Services \033[0;90m>>     \033[0;93m(Page 1/2)\u001B[0m
                                    Choose type of transaction from list below.
                                    \033[0;93m01:\u001B[0m                                Accumulative.
                                    \033[0;93m02:\u001B[0m                                Disbursement.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-2 :\s""");
            String select_option = inputAcc.next();

            if (select_option.equals("1")||select_option.equals("01")) {
                while (true) {

                    System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mInsurance Services \033[0;90m>>     \033[0;93m(Page 2/2)\u001B[0m
                                    Choose type of accumulative from list below.
                                    \033[0;93m01:\u001B[0m                                      Dengue.
                                    \033[0;93m02:\u001B[0m                                   HealthDiy.
                                    \033[0;93m03:\u001B[0m                                       PM2.5.
                                    \033[0;93m04:\u001B[0m                                 See Details.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-3 :\s""");
                    checkAcc = inputAcc.next();


                    if (checkAcc.equals("1") || checkAcc.equals("01")) {       //Dengue
                        accumulative = new Dengue(current_user);
                        accumulative.display();
                        while (true) {
                            System.out.print("""
                                              
                                    \033[0;93mInsurance Service\033[0;90m--- \u001B[0mProcessing
                                    You can choose plan from the instruction A, B, and C  \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    Enter 1 for A, 2 for B, 3 for C Plan that you prefer.
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            String selectplan = inputAcc.next();

                            if (selectplan.equals("1") || selectplan.equals("2") || selectplan.equals("3")) {
                                while (true) {
                                    System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                    current_user.setConfirm(inputAcc.next());

                                    if (current_user.getConfirm().equals("1")) {
                                        System.out.println("you buy accumulative " + accumulative.name());
                                        System.out.println("Thank you for pay");
                                        dengue.setPlan(selectplan);

                                        current_user.setCheck_detail("1");
                                        break;
                                    }
                                    if (current_user.getConfirm().equals("2")) {
                                        System.out.println("you cancel");
                                        System.out.println("Thank for wathcing");
                                        break;
                                    } else {
                                        new ErrorNotation(1);
                                    }
                                }
                                break;
                            } else if (selectplan.equals("0")) {
                                System.out.println("Thanks");
                                break;

                            } else {
                                new ErrorNotation(1);
                            }
                        }


                    } else if (checkAcc.equals("2") || checkAcc.equals("02")) {//Healty
                        accumulative = new HealthDiy(current_user);
                        accumulative.display();

                        while (true) {
                            System.out.print("""
                                              
                                    \033[0;93mInsurance Service\033[0;90m--- \u001B[0mProcessing
                                    You can choose plan from the instruction A, B, and C  \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    Enter 1 for A, 2 for B, 3 for C Plan that you prefer.
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            String selectplan = inputAcc.next();

                            if (selectplan.equals("1") || selectplan.equals("2") || selectplan.equals("3")) {
                                while (true) {
                                    System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                    current_user.setConfirm(inputAcc.next());
                                    if (current_user.getConfirm().equals("1")) {
                                        System.out.println("you buy accumulative " + accumulative.name());
                                        System.out.println("Thank you for pay");
                                        healthDiy.setPlan(selectplan);
                                        current_user.setCheck_detail1("2");
                                        break;
                                    } else if (current_user.getConfirm().equals("2")) {
                                        System.out.println("you cancel");
                                        System.out.println("Thank for wathcing");

                                        break;
                                    } else {
                                        new ErrorNotation(1);
                                    }
                                }
                                break;
                            } else if (selectplan.equals("0")) {
                                System.out.println("Thanks");

                                break;

                            } else {
                                new ErrorNotation(1);
                            }


                        }


                    } else if (checkAcc.equals("3") || checkAcc.equals("03")) {//PM2.5
                        accumulative = new Pm25(current_user);
                        accumulative.display();

                        while (true) {
                            System.out.print("""
                                              
                                    \033[0;93mInsurance Service\033[0;90m--- \u001B[0mProcessing
                                    You can choose plan from the instruction A, B, and C  \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    Enter 1 for A, 2 for B, 3 for C Plan that you prefer.
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            String selectplan = inputAcc.next();

                            if (selectplan.equals("1") || selectplan.equals("2") || selectplan.equals("3")) {
                                while (true) {
                                    System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                    current_user.setConfirm(inputAcc.next());
                                    if (current_user.getConfirm().equals("1")) {
                                        System.out.println("you buy accumulative " + accumulative.name());
                                        System.out.println("Thank you for pay");
                                        pm25.setPlan(selectplan);
                                        current_user.setCheck_detail2("3");
                                        break;
                                    }
                                    if (current_user.getConfirm().equals("2")) {
                                        System.out.println("you cancel");
                                        System.out.println("Thank for wathcing");
                                        break;
                                    } else {
                                        new ErrorNotation(1);
                                    }
                                }
                                break;
                            } else if (selectplan.equals("0")) {
                                break;

                            } else {
                                new ErrorNotation(1);
                            }
                        }

                    } else if (checkAcc.equals("4") || checkAcc.equals("04")) {
                        if (current_user.getCheck_detail().equals("1")) {
                            dengue.getshortdetail();
                            for (int i = 0; i < current_user.getPlan().length; i++) {
                                System.out.println(this.current_user.getPlan()[i]);
                            }
                        }
                        if (current_user.getCheck_detail1().equals("2")) {
                            healthDiy.getshortdetail();

                            for (int i = 0; i < current_user.getPlan2().length; i++) {

                                System.out.println(this.current_user.getPlan2()[i]);
                            }
                        }
                        if (current_user.getCheck_detail2().equals("3")) {
                            pm25.getshortdetail();
                            for (int i = 0; i < current_user.getPlan3().length; i++) {

                                System.out.println(this.current_user.getPlan3()[i]);
                            }
                        } else if (current_user.getCheck_detail2().equals("0") && current_user.getCheck_detail1().equals("0") && current_user.getCheck_detail().equals("0")) {
                            new ErrorNotation(112);
                        }

                    } else if (checkAcc.equals("0") || checkAcc.equals("00")) {
                        break;
                    } else {
                        new ErrorNotation(105);
                    }


                }
            }

            else if (select_option.equals("2")||select_option.equals("02")) {
                //กรณีอยากเบิก(ลบได้)------------------------------------------------------------------------------------------
                while (true) {
                    System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mInsurance Services \033[0;90m>>     \033[0;93m(Page 2/2)\u001B[0m
                                    Choose type of disbursement from list below.
                                    \033[0;93m01:\u001B[0m                                      Dengue.
                                    \033[0;93m02:\u001B[0m                                   HealthDiy.
                                    \033[0;93m03:\u001B[0m                                       PM2.5.
                                    \033[0;93m04:\u001B[0m                            Total & Withdraw.
                                    \033[0;93m00:\u001B[0m                                Back to menu.
                                    \033[0;32m[USER]\u001B[0m select only 0-4 :\s""");
                    checkAcc = inputAcc.next();
                    if (checkAcc.equals("1") || checkAcc.equals("01")) {
                        if (current_user.getCheck_detail().equals("1")) {
                            while (true) {
                                dengue.getshortdetail();
                                System.out.print("""
                                              
                                    \033[0;93mInsurance Service\033[0;90m--- \u001B[0mProcessing
                                    Enter the item that you want to disbursement  \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                check_item = inputAcc.next();
                                if (check_item.equals("1")) {
                                    dengue.getdetail1("2");
                                    while (true) {
                                        System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                        current_user.setConfirm(inputAcc.next());
                                        if (current_user.getConfirm().equals("1")) {
                                            dengue.getdetail1(current_user.getConfirm());
                                            break;
                                        } else if (current_user.getConfirm().equals("2")) {
                                            System.out.println("You Cancel order");
                                            break;
                                        } else {
                                            new ErrorNotation(105);
                                        }
                                    }
                                    break;
                                } else if (check_item.equals("2")) {
                                    dengue.getdetail2("2");
                                    while (true) {
                                        System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                        current_user.setConfirm(inputAcc.next());
                                        if (current_user.getConfirm().equals("1")) {
                                            dengue.getdetail2(current_user.getConfirm());
                                            break;
                                        } else if (current_user.getConfirm().equals("2")) {
                                            System.out.println("You Cancel order");
                                            break;
                                        } else {
                                            new ErrorNotation(105);
                                        }
                                    }
                                    break;
                                } else if (check_item.equals("3")) {
                                    dengue.getdetail3("3");
                                    while (true) {
                                        System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                        current_user.setConfirm(inputAcc.next());
                                        if (current_user.getConfirm().equals("1")) {
                                            dengue.getdetail3(current_user.getConfirm());
                                            break;
                                        } else if (current_user.getConfirm().equals("2")) {
                                            System.out.println("You Cancel order");
                                            break;
                                        } else {
                                            new ErrorNotation(105);
                                        }
                                    }
                                    break;
                                } else if (check_item.equals("0")) {
                                    break;
                                } else {
                                    new ErrorNotation(1);
                                }
                            }

                        } else {
                            new ErrorNotation(204);
                        }
                    }
                    //healty
                    else if (checkAcc.equals("2") || checkAcc.equals("02")) {
                        if (current_user.getCheck_detail1().equals("2")) {
                            while (true) {
                                healthDiy.getshortdetail();
                                System.out.print("""
                                              
                                    \033[0;93mInsurance Service\033[0;90m--- \u001B[0mProcessing
                                    Enter the item that you want to disbursement  \033[0;90m[ Back to Menu press 0 ]\u001B[0m
                                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                check_item = inputAcc.next();

                                if (check_item.equals("1")) {
                                    healthDiy.getdetail1("4");
                                    while (true) {
                                        System.out.println("Enter 1 For 1.1 || 2 For 1.2 || 3 For 1.3 || 4 For 1.4 || 5 For Back");
                                        System.out.println("Select number : ");
                                        String select_number01 = inputAcc.next();
                                        if (select_number01.equals("1") || select_number01.equals("1.1")) {
                                            System.out.println("1. Normal room rate per day\n" +
                                                    "2. intensive care unit fee ICU/CCU per day");
                                            System.out.println("Select number : ");
                                            select_number = inputAcc.next();
                                            if (select_number.equals("1")) {
                                                while (true) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.getdetail1(select_number);
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }
                                            if (select_number.equals("2")) {
                                                while (true) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.getdetail1(select_number);
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }

                                        }
                                        //ข้อ 1
                                        if (select_number01.equals("2") || select_number01.equals("1.2")) {
                                            System.out.println(
                                                    "1.2 Medical expenses or general service charge\n" +
                                                            "1. general medical expenses Including continuing treatment within 30 days from " +
                                                            "the date of discharge from the hospital\n" +
                                                            "2. Medical expenses for emergency accidents due to injuries within 24 hours and " +
                                                            "continuous treatment within 15 days\n" +
                                                            "3. Ambulance service charges\n");
                                            System.out.println("Select number : ");
                                            select_number = inputAcc.next();
                                            if (select_number.equals("2")) {
                                                while (true) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.getdetail1("3");
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }
                                            if (select_number.equals("1") || select_number.equals("3")) {
                                                error = "none";
                                                System.out.println("Input money : ");
                                                String money = inputAcc.next();
                                                try {
                                                    moneynum = Double.parseDouble(money); //แปลง String to int
                                                    if (moneynum < 0) new ErrorNotation(104);

                                                } catch (NumberFormatException e) { //หากเจอ error
                                                    error = "error";
                                                    new ErrorNotation(103); // Display an error message
                                                }
                                                while (error.equals("none")) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.setAnyplan(moneynum);
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }

                                        }
//ข้อ2
                                        if (select_number01.equals("3") || select_number01.equals("1.3")) {
                                            error = "none";
                                            System.out.println(
                                                    "1.3 Doctor's fee for surgical treatment\n" +
                                                            "1. Surgical and procedure fees \n" +
                                                            "2. Surgical Consultation Fee in case of surgery (included in the cost of surgeons and procedures)\n");
                                            System.out.println("Select number : ");
                                            select_number = inputAcc.next();
                                            if (select_number.equals("1") || select_number.equals("2")) {
                                                System.out.println("Input money : ");
                                                String money = inputAcc.next();
                                                try { moneynum = Double.parseDouble(money); //แปลง String to int
                                                    if (moneynum < 0) new ErrorNotation(104);
                                                } catch (NumberFormatException e) { //หากเจอ error
                                                    error = "error";
                                                    new ErrorNotation(103); // Display an error message
                                                }
                                                while (error.equals("none")) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.setAnyplan(moneynum);
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }

                                        }
                                        //ข้อ3
                                        if (select_number01.equals("4") || select_number01.equals("1.4")) {
                                            error = "none";
                                            System.out.println(
                                                    "1.4 Doctor visit fee or the cost of consulting a specialist specialist\n" +
                                                            "1. Medical care fee 1 time/day (total up to 365 days)\n" +
                                                            "2. Surgical consultant fee in case of no surgery (Included in general medical expenses)\n ");
                                            System.out.println("Select number : ");
                                            select_number = inputAcc.next();
                                            if (select_number.equals("1") || select_number.equals("2")) {
                                                System.out.println("Input money : ");
                                                String money = inputAcc.next();
                                                try { moneynum = Double.parseDouble(money); //แปลง String to int
                                                    if (moneynum < 0) new ErrorNotation(104);
                                                } catch (NumberFormatException e) { //หากเจอ error
                                                    error = "error";
                                                    new ErrorNotation(103); // Display an error message
                                                }
                                                while (error.equals("none")) {
                                                    System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                                    current_user.setConfirm(inputAcc.next());
                                                    if (current_user.getConfirm().equals("1")) {
                                                        healthDiy.setAnyplan(moneynum);
                                                        break;
                                                    } else if (current_user.getConfirm().equals("2")) {
                                                        System.out.println("You Cancel order");
                                                        break;
                                                    } else {
                                                        System.out.println(ANSI_RED + "Again Plz" + ANSI_RESET);
                                                    }
                                                }
                                                break;
                                            }

                                        }
                                        //ข้อ4
                                        else if (select_number01.equals("5")) {
                                            System.out.println("Thank you see you later");
                                            break;
                                        } else {
                                            System.out.println(ANSI_RED + "You don't have this" + ANSI_RESET);
                                        }
                                    }
                                } else if (check_item.equals("2")) {
                                    healthDiy.getdetail2();

                                    while (true) {
                                        System.out.print("""
                    
                                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                        current_user.setConfirm(inputAcc.next());
                                        if (current_user.getConfirm().equals("1")) {
                                            healthDiy.setAnyplan(100000);
                                            break;
                                        } else if (current_user.getConfirm().equals("2")) {
                                            System.out.println("You Cancel order");
                                            break;
                                        } else {
                                            System.out.println("Enter error \nPlease enter again");
                                        }
                                    }
                                } else if (check_item.equals("3")) {
                                    break;
                                } else {
                                    System.out.println(ANSI_RED + "Error \nPlease enter again!!" + ANSI_RESET);
                                }
                                break;
                            }

                        } else {
                            System.out.println(ANSI_RED + "You don't have this" + ANSI_RESET);
                        }

                    }
                    //PM2.5
                    else if (checkAcc.equals("3") || checkAcc.equals("03")) {
                        if (current_user.getCheck_detail2().equals("3")) {
                            pm25.getshortdetail();

                            while (true) {
                                System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                                current_user.setConfirm(inputAcc.next());
                                if (current_user.getConfirm().equals("1")) {
                                    pm25.getPlans();

                                    break;
                                } else if (current_user.getConfirm().equals("2")) {
                                    System.out.println("You Cancel order");
                                    break;
                                } else {
                                    new ErrorNotation(105);
                                }
                            }
                        } else {
                            new ErrorNotation(204);
                        }
                    }
                    else if (checkAcc.equals("4")||checkAcc.equals("04")) {

                        total = dengue.getAnycost() + pm25.getAnycost() + healthDiy.getAnycost();

                        while (true) {
                            System.out.println("Total : " + total);
                            System.out.println("Do you want to withdraw money");
                            System.out.print("""
                    
                                        \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                                        \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                                        \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                            current_user.setConfirm(inputAcc.next());
                            if (current_user.getConfirm().equals("1")) {
                                callAuthorize(Double.toString(total), 0);
                                break;
                            } else if (current_user.getConfirm().equals("2")) {
                                System.out.println("You Cancel order");
                                break;
                            } else {
                                new ErrorNotation(105);
                            }
                        }

                    }else if (checkAcc.equals("0") || checkAcc.equals("00")) {
                        break;
                    } else {
                        new ErrorNotation(105);
                    }

                }

            }  else if (select_option.equals("0")||select_option.equals("00")) {
                break;
            } else {
                new ErrorNotation(105);
            }

        }
    }
}