package Bank.services.insurances;

import Bank.user_type.Users;

public abstract class Accumulative {
    protected Users current_user;
    protected double anycost;

    public Accumulative (Users current_user) {
        this.current_user = current_user;
    }

    public void reset() {
        name();
        detail();
        protection();
        current_user.setPlan(new double[3]);

        anycost = 0;
    }

    public abstract String name();

    public abstract String shortdetail();

    public abstract String detail();

    public abstract String protection();

    public abstract double setAnyplan(double cost);

    public abstract double[] setPlan(String plan);

    public void display() {
        System.out.println("\n\t\t\t\t\t\t<---Detail--->\n"
                + detail() + "\n\n" + "\t\t<---How long Careful--->\n" + protection() + "\n");
    }



    public double getAnycost() {
        return anycost;
    }

    public void getshortdetail() {
        System.out.println(shortdetail());

    }

}
