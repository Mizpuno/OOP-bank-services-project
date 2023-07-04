package Bank.notations;

public class ErrorNotation {
    public ErrorNotation (int index) {
        switch (index) {
            case 0 -> {
                System.out.print("""
                            
                            \033[0;90m(0) \033[0;91mWrong Index!\u001B[0m
                            Your input doesn't matches any selector.
                            """);
            }

            case 1 -> System.out.print("""
                            
                            \033[0;90m(1) \033[0;91mSomthing Wrong!\u001B[0m
                            We've found some problem from your actions. please try again.
                            """);
            case 110 -> {
                System.out.print("""
                            
                            \033[0;90m(110) \033[0;91mInvalidated Key!\u001B[0m
                            It seems you fill in a wrong key access. please try again later.
                            """);
            }


            case 102 -> {
                System.out.print("""
                            
                            \033[0;90m(102) \033[0;91mUser Reference Not Found!\u001B[0m
                            We can't found your user reference. please try again later.
                            """);
            }

            case 112 -> System.out.print("""
                            
                            \033[0;90m(112) \033[0;91mAccumulative Not Found!\u001B[0m
                            you doesn't have an accumulative in your account right now. 
                            """);

            case 200 -> {
                System.out.print("""
                            
                            \033[0;90m(200) \033[0;91mTransaction Failed!\u001B[0m
                            We've found some problem when processing the transaction.
                            Maybe can't found account, wrong password, missing amount etc.
                            """);
            }
            case 201 -> {
                System.out.print("""
                            
                            \033[0;90m(201) \033[0;91mBalance Insufficient!\u001B[0m
                            Account money are less than the money that you're prefer before.
                            """);
            }

            case 202 -> System.out.print("""
                            
                            \033[0;90m(202) \033[0;91mWrong Amount To Do Transaction!\u001B[0m
                            You fill in below than 0 or hit the 0 baht in transaction.
                            """);

            case 203 -> System.out.print("""
                            
                            \033[0;90m(203) \033[0;91mAccount can't found\u001B[0m
                            we can't found the account that you prefer. Please try again
                            """);

            case 204 -> System.out.print("""
                            
                            \033[0;90m(204) \033[0;91mThis Item Can't Found\u001B[0m
                            It seem you didn't have this item in your account.
                            """);

            case 101 -> System.out.print("""
                            
                            \033[0;90m(101) \033[0;91mInvalidated Password!\u001B[0m
                            It seems you fill in a wrong password. please try again later.
                            """);

            case 103 -> System.out.print("""
                            
                            \033[0;90m(103) \033[0;91mInvalidated Number!\u001B[0m
                            You must fill in only the number. it can't contain text.
                            """);

            case 104 -> System.out.print("""
                            
                            \033[0;90m(104) \033[0;91mInvalidated Amount!\u001B[0m
                            You can't fill the money as any text or minus. it must contain only positive number.
                            """);

            case 105 -> System.out.print("""
                            
                            \033[0;90m(105) \033[0;91mInvalidated Input!\u001B[0m
                            You can't use number choice outer from the scope. Please enter a valid number.
                            """);

            case 106 -> System.out.print("""
                            
                            \033[0;90m(106) \033[0;91mInvalidated Phone Number!\u001B[0m
                            That is't a phone number. Please try again to fill in the phone number.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 107 -> System.out.print("""
                            
                            \033[0;90m(107) \033[0;91mInvalidated Tax ID!\u001B[0m
                            It seem that is not a serial of tax id. Please try again to fill in.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 108 -> System.out.print("""
                            
                            \033[0;90m(108) \033[0;91mInvalidated Control Code!\u001B[0m
                            It seem that is not a serial of control code. Please try again to fill in.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 109 -> System.out.print("""
                            
                            \033[0;90m(109) \033[0;91mInvalidated Account ID!\u001B[0m
                            It seem that is not a serial of account id. Please try again to fill in.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 111 -> System.out.print("""
                            
                            \033[0;90m(111) \033[0;91mInvalidated Lots!\u001B[0m
                            we can't found the lots. Please try again to fill in.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 300 -> System.out.print("""
                            
                            \033[0;90m(300) \033[0;91mDoesn't Meet Condition!\u001B[0m
                            The amount does not meet the specified conditions. Please enter a valid number.
                            \033[0;32m[USER]\u001B[0m fill up to complete:\s""");

            case 301 -> System.out.print("""
                            
                            \033[0;90m(301) \033[0;91mCan't Do Transaction!\u001B[0m
                            You just a new user! you must deposit first before use anyfunction.
                            """);

        }
    }
}
