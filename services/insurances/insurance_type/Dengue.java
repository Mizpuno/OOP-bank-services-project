package Bank.services.insurances.insurance_type;

import Bank.services.insurances.Accumulative;
import Bank.user_type.Users;

public class Dengue extends Accumulative {
    public Dengue (Users current_user) {
        super (current_user);
    }
    @Override
    public String detail() {
        return  "\u001B[40m|===========================================================================================================================================|\u001B[0m\n"+
                "\u001B[40m|    1.Illness with coma or disease caused by dengue fever*                                                                                 |\u001B[0m\n" +
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|\u001B[32m                        (Plan A)->100,000 ||  (Plan B)->200,000  ||  (Plan C)->300,000                                                     \u001B[0m|\n" +//1.การเจ็บป่วยด้วยภาวะโคม่า หรือโรคร้ายแรงที่มีสาเหตุมาจากโรคไข้เลือดออก*
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|    2.Medical treatment for in-patient cases (IPD) and out-patient cases (OPD) due to dengue fever per episode                             |\u001B[0m\n" +
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|\u001B[32m                        (Plan A)->20,000  ||  (Plan B)->50,000   ||  (Plan C)->75,000                                                      \u001B[0m|\n" +//2.การรักษาพยาบาลกรณีผู้ป่วยใน (IPD) และกรณีผู้ป่วยนอก (OPD) อันเนื่องมาจากโรคไข้เลือดออก ต่อครั้ง
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|    3.Daily compensation during inpatient treatment in a hospital or medical facility due to dengue fever per day (up to 30 days/time)     |\u001B[0m\n" +
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|\u001B[32m                        (Plan A)->1,000   ||  (Plan B)->1,500    ||  (Plan C)->2,000                                                       \u001B[0m|\n" +//3.เงินชดเชยรายวันระหว่างรักษาตัวเป็นผู้ป่วยใน ในโรงพยาบาลหรือสถานพยาบาลเวชกรรม อันเนื่องมาจากโรคไข้เลือดออก ต่อวัน (สูงสุดไม่เกิน 30 วัน/ครั้ง)
                "\u001B[40m|                                                                                                                                           |\u001B[0m\n"+
                "\u001B[40m|===========================================================================================================================================|\u001B[0m";
    }

    @Override
    public String protection() {
        return "1-99 years of age at the date of applying for insurance";
    }

    @Override
    public String name() {
        return "Dengue insurance";
    }//ประกันไข้เลือดออก


    @Override
    public double[] setPlan(String plan) {
        if (plan.equals("1")) {
            current_user.setPlan(new double[]{100000, 20000, 1000});
        } else if (plan.equals("2")) {
            current_user.setPlan(new double[]{200000, 50000, 1500});
        } else if (plan.equals("3")) {
            current_user.setPlan(new double[]{300000, 75000, 2000});
        }

        return current_user.getPlan();
    }

    @Override
    public String shortdetail() {
        return "1.Illness with coma or disease caused by dengue fever*" +
                //1.การเจ็บป่วยด้วยภาวะโคม่า หรือโรคร้ายแรงที่มีสาเหตุมาจากโรคไข้เลือดออก*
                "\n2.Medical treatment for in-patient cases (IPD) and out-patient cases (OPD) due to dengue fever per episode" +
                //2.การรักษาพยาบาลกรณีผู้ป่วยใน (IPD) และกรณีผู้ป่วยนอก (OPD) อันเนื่องมาจากโรคไข้เลือดออก ต่อครั้ง
                "\n3.Daily compensation during inpatient treatment in a hospital or medical facility due to dengue fever per day (up to 30 days/time)" +
                "\n4.Back"
                //3.เงินชดเชยรายวันระหว่างรักษาตัวเป็นผู้ป่วยใน ในโรงพยาบาลหรือสถานพยาบาลเวชกรรม อันเนื่องมาจากโรคไข้เลือดออก ต่อวัน (สูงสุดไม่เกิน 30 วัน/ครั้ง)
                ;
    }
    @Override
    public void getshortdetail() {
        super.getshortdetail();
    }
    @Override
    public double setAnyplan(double cost) {
        return this.anycost = this.anycost + cost;
    }

    public void getdetail1(String check) {
        System.out.println("1.Illness with coma or disease caused by dengue fever*");

        //plan[0]เอาตรงนี้ไปบวกตรงประกันได้
        if (check.equals("1")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan()[0]);
            setAnyplan(current_user.getPlan()[0]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan(new double[]{0, current_user.getPlan()[1], current_user.getPlan()[2]});
        }
    }

    public void getdetail2(String check) {
        System.out.println("2.Medical treatment for in-patient cases (IPD) and out-patient cases (OPD) due to dengue fever per episode");

        //เอาตรงนี้ไปบวกตรงประกันได้
        if (check.equals("1")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan()[1]);
            setAnyplan(current_user.getPlan()[1]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan(new double[]{current_user.getPlan()[0], 0, current_user.getPlan()[2]});
        }
    }

    public void getdetail3(String check) {
        System.out.println("3.Daily compensation during inpatient treatment in a hospital or medical facility due to dengue fever per day (up to 30 days/time)");

        //เอาตรงนี้ไปบวกตรงประกันได้
        if (check.equals("1")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan()[2]);
            setAnyplan(current_user.getPlan()[2]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan(new double[]{current_user.getPlan()[0], current_user.getPlan()[1], 0});
        }
    }
}