package Bank.services.utilities.topup_function;

public class TopUp_ServiceProvider extends TopUp {
    @Override
    public void setType(int choice) {
        if (choice == 1) {
            type = "AIS";
        } else if (choice == 3) {
            type = "Truemove H";
        } else if (choice == 2) {
            type = "Dtac";
        }
    }

    @Override
    public String slip(String note, String cost, String[] bundle) {
        return super.slip(note, cost, bundle);
    }
}
