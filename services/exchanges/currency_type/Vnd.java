package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Vnd extends Exchange {
    public Vnd(int index, Users current_user) {
        super(index, current_user);
    }
    @Override
    public double exchange() {
        return 0.00133;
    }
    public String Description() {
        return "Vietnam";
    }
}
