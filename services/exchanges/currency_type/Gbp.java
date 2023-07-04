package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Gbp extends Exchange {
    public Gbp(int index, Users current_user) {
        super(index, current_user);
    }
    public double exchange() {
        return 37.33;
    }

    public String Description() {
        return "United Kingdom";
    }
}
