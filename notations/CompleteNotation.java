package Bank.notations;

public class CompleteNotation {
    public CompleteNotation(int index) {
        switch (index) {
            case 1 -> {
                System.out.print("""
                                                    
                        \033[0;96mLogin Success!\u001B[0m
                        Welcome to DII Bank services, We are ready to serve you.
                        """);
            }

            case 2 -> {
                System.out.print("""
                                                    
                        \033[0;96mLogout See ya!\u001B[0m
                        Thank for using our services. see you later.
                        """);
            }

            case 200 -> {
                System.out.print("""
                                                    
                        \033[0;96mTransacton Completed\u001B[0m
                        Your transaction is completely without any problem.
                        """);
            }

            case 201 -> {
                System.out.print("""
                                                    
                        \033[0;33mTransacton Cancel!\u001B[0m
                        You're cancel the transaction, we're sorry if we can't serve you an advice.
                        """);
            }

            case 210 -> {
                System.out.print("""
                            
                            \033[40m                                              \u001B[0m
                                         \033[0;93mTransaction Evidence\u001B[0m
                            This is the evidence for transaction, and it 
                            will show about all of the details below. 
                            
                            """);
            }
        }
    }
}
