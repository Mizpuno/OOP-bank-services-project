package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Aud extends Exchange {
    public Aud(int index, Users current_user) {
        super(index, current_user);
    }

    @Override
    public double exchange() {
        return 20.904;
    }
    public String Description() {
        return "Australia";
    }
}
