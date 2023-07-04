package Bank.services.exchanges.currency_type;
import Bank.services.exchanges.Exchange;
import Bank.user_type.Users;

public class Krw extends Exchange {
    public Krw(int index, Users current_user) {
        super(index, current_user);
    }
    @Override
    public double exchange() {
        return  0.0254;
    }
    public String Description() {
        return "West Korea";
    }
}
