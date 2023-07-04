package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Jyp extends Exchange {
    public Jyp(int index, Users current_user) {
        super(index, current_user);
    }
    public double exchange() {
        return  0.291;
    }

    public String Description() {
        return "Japan";
    }
}
