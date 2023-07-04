package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public  class Usd extends Exchange {
    public Usd(int index, Users current_user) {
        super(index, current_user);
    }
    @Override
    public double exchange() {
        return 30.82;
    }

    public String Description() {
        return "United States";
    }
}
