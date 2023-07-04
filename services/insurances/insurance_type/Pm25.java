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
        return  " _______________________________________________________________________\n"+
                "|\t-being diagnosed by a doctor for the first time as a serious disease |\n" +
                "|\t-Severe COPD/end-stage lung disease                                  |\n" +
                "|\t-First myocardial infarction from ischemia                           |\n" +
                "|\t-Cerebrovascular disease or blockage                                 |\n" +
                "|\t-metastatic cancer                                                   |\n" +
                "|\t-Cardiovascular surgery                                              |\n" +
                "|\t-chronic kidney disease                                              |\n" +
                "|\t-liver failure                                                       |\n" +
                "|\t-to have a cell transplant or bone marrow transplant                 |\n" +
                "|\t-coma situation                                                      |\n" +
                "|\t-Total permanent disability in the event of an accident or injury    |\n" +
                " _______________________________________________________________________";

    }

    @Override
    public String detail() {
        return  " _______________________________________________________________________\n"+
                "|\t-being diagnosed by a doctor for the first time as a serious disease |\n" +
                "|\t-Severe COPD/end-stage lung disease                                  |\n" +
                "|\t-First myocardial infarction from ischemia                           |\n" +
                "|\t-Cerebrovascular disease or blockage                                 |\n" +
                "|\t-metastatic cancer                                                   |\n" +
                "|\t-Cardiovascular surgery                                              |\n" +
                "|\t-chronic kidney disease                                              |\n" +
                "|\t-liver failure                                                       |\n" +
                "|\t-to have a cell transplant or bone marrow transplant                 |\n" +
                "|\t-coma situation                                                      |\n" +
                "|\t-Total permanent disability in the event of an accident or injury    |\n" +
                "|\t(planA)--->50,000\t(planB)--->100,000\t(planC)--->200,000           |\n"+
                " _______________________________________________________________________";
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
