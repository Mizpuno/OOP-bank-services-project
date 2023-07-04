package Bank.services.ecorisks;

import java.util.Scanner;

import Bank.localdata.AuthorizeFunc;
import Bank.notations.ErrorNotation;
import Bank.services.Client;
import Bank.user_type.Users;

import static Bank.services.Client.callAuthorize;
import static Bank.services.Client.callStepFirst;

public class Loan implements AuthorizeFunc {
    Scanner sc = new Scanner(System.in);
    Users current_user;
    protected String input;
    double loan, LoanR, ReLoan;
    private boolean loan_stats;
    private String note;

    public Loan (Users current_user) {
        this.current_user = current_user;
        LoanR = current_user.getLoanR();
    }

    @Override
    public void runFunction() {
        current_user.setLoanR(LoanR-ReLoan);

        if (current_user.getLoanR() <= 0) {
            System.out.println("You have paid over than at " + (ReLoan-LoanR) + " Baht.");
            System.out.println("Please carefully to choose your return account");
            System.out.println("[If it not contain choice the money will be remove !!!]");

            callAuthorize(Double.toString(ReLoan-LoanR), 0);
            current_user.setLoanR(0);
        }
    }

    public void runUnit(){//เช็คว่าเคยกู้ไปแล้วหรือยัง
        if(LoanR==0){//ไม่เคยกู้
            loan_stats = true;
            loanStart();

        }
        else{//ยังจ่ายไม่หมด
            loan_stats = false;
            loanReturn();
        }
    }
    public void loanStart() {
        double checkMinus = 0;
        do {
            System.out.print("""
                                                        
                                   \033[0;90m<< \033[0;93mLoan Services \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                    you can loan the money from our bank with low tax
                        just only 15% tax per years. and easy to do
                    \033[0;93m00:\u001B[0m                               Back to menu.
                    \033[0;32m[USER]\u001B[0m Enter loan amount that you need :\s""");
            input = sc.nextLine();

            try {
                checkMinus = Double.parseDouble(input);
                if (checkMinus < 0) {
                    new ErrorNotation(104);
                }
                if (checkMinus == 0) {
                    System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                    break;
                }
            } catch (NumberFormatException e) {
                new ErrorNotation(104);
                loanStart();
            }

                loan = checkMinus;
                //ใส่เงินกู้มากกว่าศูนย์
                if (loan > 0) {
                    System.out.print("Note : ");
                    note = sc.next();

                    System.out.print("""
                                      
                            \033[0;93mLoan Service\033[0;90m--- \u001B[0mProcessing
                            """);

                    System.out.println("\033[40m      This is the amount you need? \" " + loan + " Baht. \"   \u001B[0m");
                    System.out.print("And return the loan with interest 15% : \033[0;93m" + Math.round((loan * 1.15) * 100.0) / 100.0 + "\u001B[0m Baht.\n");
                    System.out.print("""
                                                
                            \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                            \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    input = sc.nextLine();
                    input = sc.nextLine();
                    if (input.matches("[0-9]+")) {
                        int x = Integer.parseInt(input);
                        //ยืนยันจะกู้
                        if (x == 1) {
                            current_user.setLoanR(Math.round((loan * 1.15) * 100.0) / 100.0);
                            callAuthorize(Double.toString(loan), 0); //เอาเงินเข้าจ้าา เอาที่ยังไม่ได้คูณเข้าเด้ออออ
                            break;
                        }
                        if (x == 2) {

                        }
                    } else {
                        new ErrorNotation(104);
                    }
                }
        }while (checkMinus != 0);
    }


    public void loanReturn() {//หน้าจ่ายเงิน
        System.out.print("""
                                    
                                                   \033[0;90m<< \033[0;93mLoan Services \033[0;90m>>     \033[0;93m(Page 1/1)\u001B[0m
                                                   """);
        System.out.println("Now you have return the loan is " + LoanR + " Baht");//แสดงว่ายังค้างเงินเท่าไหร่
        System.out.println("       You need to return the loan NOW?");
        System.out.print("""
                    
                    \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                    \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                    \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

        input = sc.nextLine();
        if (input.matches("[0-9]+")) {
            int x1 = Integer.parseInt(input);
            if (x1 == 1) {
                try {
                    ReLoan = Double.parseDouble(callStepFirst());
                } catch (NumberFormatException e) {
                    new ErrorNotation(104);
                }

                if (ReLoan <= Client.getLasted_account_usage().getAcc_balance()) {//เงินในบัญชีต้องมีมากกว่าหรือเท่ากับ
                    System.out.print("""
                                                
                            \033[0;90m| \033[0;93mRequirement request.\u001B[0m
                            \033[0;90m| \u001B[0mPlease Enter 1 For \033[0;102mConfirm\u001B[0m or 2 For \033[0;101mCancel\u001B[0m.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");
                    input = sc.next();
                    if (input.matches("[0-9]+")) {
                        int x = Integer.parseInt(input);
                        if (x == 1) {
                            callAuthorize(Double.toString(ReLoan), 1, this); //หักเงินในบัญชี
                        }
                        if (x == 2) {
                            System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
                        }
                    } else {
                        new ErrorNotation(105);
                        loanStart();
                    }
                } else {
                    new ErrorNotation(201);
                }
            }
            else if (x1 == 2) {
                System.out.println("\u001B[41m     == EXIT ==     \u001B[0m ");
            }
        }else {
            new ErrorNotation(105);
            loanStart();
        }
    }

}