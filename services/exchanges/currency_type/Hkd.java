package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Hkd extends Exchange {
    public Hkd(int index, Users current_user) {
        super(index, current_user);
    }
    public double exchange() {
        return  3.944;
    }

    @Override
    public String Description() {
        return "Hongkong";
    }
}
