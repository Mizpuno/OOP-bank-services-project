package Bank.services.insurances.insurance_type;

import Bank.notations.ErrorNotation;
import Bank.services.insurances.Accumulative;
import Bank.user_type.Users;

public class Pm25 extends Accumulative {
    public Pm25 (Users current_user) {
        super (current_user);
    }
    @Override
    public String name() {
        return "PM2.5";
    }

    @Override
    public String shortdetail() {
        return  "\u001B[40m|========================================================================|\u001B[0m\n"+
                "\u001B[40m|  -being diagnosed by a doctor for the first time as a serious disease  |\u001B[0m\n" +
                "\u001B[40m|  -Severe COPD/end-stage lung disease                                   |\u001B[0m\n" +
                "\u001B[40m|  -First myocardial infarction from ischemia                            |\u001B[0m\n" +
                "\u001B[40m|  -Cerebrovascular disease or blockage                                  |\u001B[0m\n" +
                "\u001B[40m|  -metastatic cancer                                                    |\u001B[0m\n" +
                "\u001B[40m|  -Cardiovascular surgery                                               |\u001B[0m\n" +
                "\u001B[40m|  -chronic kidney disease                                               |\u001B[0m\n" +
                "\u001B[40m|  -liver failure                                                        |\u001B[0m\n" +
                "\u001B[40m|  -to have a cell transplant or bone marrow transplant                  |\u001B[0m\n" +
                "\u001B[40m|  -coma situation                                                       |\u001B[0m\n" +
                "\u001B[40m|  -Total permanent disability in the event of an accident or injury     |\u001B[0m\n" +
                "\u001B[40m|========================================================================|\u001B[0m\n";

    }

    @Override
    public String detail() {
        return  "\u001B[40m|========================================================================|\u001B[0m\n"+
                "\u001B[40m|  -being diagnosed by a doctor for the first time as a serious disease  |\u001B[0m\n" +
                "\u001B[40m|  -Severe COPD/end-stage lung disease                                   |\u001B[0m\n" +
                "\u001B[40m|  -First myocardial infarction from ischemia                            |\u001B[0m\n" +
                "\u001B[40m|  -Cerebrovascular disease or blockage                                  |\u001B[0m\n" +
                "\u001B[40m|  -metastatic cancer                                                    |\u001B[0m\n" +
                "\u001B[40m|  -Cardiovascular surgery                                               |\u001B[0m\n" +
                "\u001B[40m|  -chronic kidney disease                                               |\u001B[0m\n" +
                "\u001B[40m|  -liver failure                                                        |\u001B[0m\n" +
                "\u001B[40m|  -to have a cell transplant or bone marrow transplant                  |\u001B[0m\n" +
                "\u001B[40m|  -coma situation                                                       |\u001B[0m\n" +
                "\u001B[40m|  -Total permanent disability in the event of an accident or injury     |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m     (planA)->50,000   ||   (planB)->100,000   ||   (planC)->200,000    \u001B[0m|\n" +
                "\u001B[40m|========================================================================|\u001B[0m\n";
    }

    @Override
    public String protection() {
        return "20 years - 60 years on the date of applying for insurance (Can be renewed up to 64 years old)";
    }

    @Override
    public double[] setPlan(String plan) {
        if (plan.equals("1")) {
            current_user.setPlan3(new double[]{50000});
        }
        else if (plan.equals("2")) {
            current_user.setPlan3(new double[]{100000});
        }
        else if (plan.equals("3")) {
            current_user.setPlan3(new double[]{200000});
        }
        return current_user.getPlan3();
    }

    @Override
    public double setAnyplan(double cost) {
        return this.anycost=this.anycost+cost;
    }

    public void getPlans() {
        if(current_user.getPlan3()[0]==0)
        {
            new ErrorNotation(105);
        }
        System.out.println("Able to withdraw money :" + current_user.getPlan3()[0]);
        setAnyplan(current_user.getPlan3()[0]);
        System.out.println("Total : "+getAnycost());
        current_user.setPlan3(new double[]{0});

    }
}
