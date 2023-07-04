package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Sgd extends Exchange {
    public Sgd(int index, Users current_user) {
        super(index, current_user);
    }
    @Override
    public double exchange() {
        return 22.267;
    }
    public String Description() {
        return "Singapore";
    }
}
