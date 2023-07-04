package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Cny extends Exchange {
    public Cny(int index, Users current_user) {
        super(index, current_user);
    }

    @Override
    public double exchange() {
        return 4.322;
    }

    public String Description() {
        return "China";
    }


}
