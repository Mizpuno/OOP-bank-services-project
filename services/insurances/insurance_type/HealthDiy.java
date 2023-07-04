package Bank.services.insurances.insurance_type;

import Bank.services.insurances.Accumulative;
import Bank.user_type.Users;

public class HealthDiy extends Accumulative {
    public HealthDiy (Users current_user) {
        super (current_user);
    }
    @Override
    public String name() {
        return "Health DIY";
    }

    @Override
    public String detail() {
        return  "\u001B[40m|=============================================================================================================================|\u001B[0m\n"+
                "\u001B[40m|  1. Inpatient medical treatment from injury or illness                                                                      |\u001B[0m\n" +
                "\u001B[40m|    1.1 room, board, and nursing service fees (Together up to 365 days)                                                      |\u001B[0m\n" +
                "\u001B[40m|        - Normal room rate per day                                                                                           |\u001B[0m\n"+
                "\u001B[40m|\u001B[32m                              (planA)->2,000    ||   (planB)->3,000   ||   (planC)->4,000                                    \u001B[0m|\n" +
                "\u001B[40m|        - intensive care unit fee ICU/CCU per day                                                                            |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                              (planA)->4,000    ||   (planB)->6,000   ||   (planC)->8,000                                    \u001B[0m|\n" +
                "\u001B[40m|    1.2 Medical expenses or general service charge                                                                           |\u001B[0m\n" +
                "\u001B[40m|        - general medical expenses Including continuing treatment within 30 days from the date of discharge from the hospital|\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                                ||   actual payment   ||                                                     \u001B[0m|\n" +
                "\u001B[40m|        - Medical expenses for emergency accidents due to injuries within 24 hours and continuous treatment within 15 days   |\u001B[0m\n"+
                "\u001B[40m|\u001B[32m                              (planA)->4,000    ||   (planB)->6,000   ||   (planC)->8,000                                    \u001B[0m|\n" +
                "\u001B[40m|        - Ambulance service charges                                                                                          |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                             (planA,B,C) -> actual payment                                                   \u001B[0m|\n" +
                //1.2 ค่ารักษาพยาบาล หรือค่าบริการทั่วไป\n" +
                // "- ค่ารักษาพยาบาลทั่วไป รวมการรักษาต่อเนื่องภายใน 30 วัน นับจากวันที่ออกจากโรงพยาบาล\tจ่ายตามจริง\n" +
                // "- ค่ารักษาพยาบาลอุบัติเหตุฉุกเฉินเนื่องจากการบาดเจ็บ ภายใน 24 ชั่วโมง และการรักษาต่อเนื่องภายใน 15 วัน\t4,000\t6,000\t8,000\n" +
                //  "- ค่าบริการรถพยาบาล\tจ่ายตามจริง\n" +
                "\u001B[40m|    1.3 Doctor's fee for surgical treatment                                                                                  |\u001B[0m\n" +
                "\u001B[40m|        - Surgical and procedure fees                                                                                        |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                             (planA,B,C) -> actual payment                                                   \u001B[0m|\n" +
                "\u001B[40m|        - Surgical Consultation Fee in case of surgery (included in the cost of surgeons and procedures)                     |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                             (planA,B,C) -> actual payment                                                   \u001B[0m|\n" +
                //"1.3 ค่าธรรมเนียมแพทย์สำหรับการรักษาโดยการผ่าตัด\n"
                // "- ค่าแพทย์ผ่าตัดและหัตถการ \tจ่ายตามจริง\n" +
                // "- ค่าปรึกษาทางการผ่าตัด กรณีมีการผ่าตัด (รวมอยู่ในค่าแพทย์ผ่าตัดและหัตถการ)\tจ่ายตามจริง\n" +
                "\u001B[40m|    1.4 Doctor visit fee or the cost of consulting a specialist specialist                                                   |\u001B[0m\n" +
                "\u001B[40m|        - Medical care fee 1 time/day (total up to 365 days)                                                                 |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                             (planA,B,C) -> actual payment                                                   \u001B[0m|\n" +
                "\u001B[40m|        - Surgical consultant fee in case of no surgery (Included in general medical expenses)                               |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                             (planA,B,C) -> actual payment                                                   \u001B[0m|\n" +
                //1.4 ค่าแพทย์เยี่ยมไข้ หรือค่าปรึกษาแพทย์ผู้เชี่ยวชาญเฉพาะโรค\n" +
                //"- ค่าดูแลโดยแพทย์เจ้าของไข้ 1 ครั้ง/วัน (รวมสูงสุด 365 วัน)\tจ่ายตามจริง\n" +
                //"- ค่าแพทย์ที่ปรึกษาทางการผ่าตัด กรณีไม่มีการผ่าตัด (รวมอยู่ในค่ารักษาพยาบาลทั่วไป)\tจ่ายตามจริง\n
                "\u001B[40m|  2. Personal accident insurance (Personal Accident)                                                                         |\u001B[0m\n" +
                "\u001B[40m|            Benefit in case of death loss of limbs, sight or total permanent disability as a result of an accident           |\u001B[0m\n" +
                "\u001B[40m|         Extend coverage for accidents from driving or being a passenger on a motorcycle                                     |\u001B[0m\n" +
                "\u001B[40m|\u001B[32m                                                (planA,B,C) -> 100,000                                                       \u001B[0m|\n" +
                "\u001B[40m|=============================================================================================================================|\u001B[0m\n";
        //"2. การประกันอุบัติเหตุส่วนบุคคล (Personal Accident)\n" +
        //"ผลประโยชน์กรณีการเสียชีวิต การสูญเสียอวัยวะ สายตา หรือทุพพลภาพถาวรสิ้นเชิงอันเนื่องมาจากอุบัติเหตุ ขยายความคุ้มครองอุบัติเหตุจากการขับขี่หรือโดยสารรถจักรยานยนต์\t100,000";
    }

    @Override
    public String protection() {
        return "The insured age ranges from 15 to 70 years old and can be renewed until the age of 80 years old, provided that they are in good health. not have any part of the body disabled or insane";
    }

    @Override
    public double[] setPlan(String plan) {
        if (plan.equals("1")) {
            current_user.setPlan2(new double[]{2000, 4000, 4000});
        } else if (plan.equals("2")) {
            current_user.setPlan2(new double[]{3000, 6000, 8000});
        } else if (plan.equals("3")) {
            current_user.setPlan2(new double[]{4000, 6000, 8000});
        }
        return current_user.getPlan2();
    }

    @Override
    public void getshortdetail() {
        super.getshortdetail();
    }
    @Override
    public double setAnyplan(double cost) {
        return this.anycost = this.anycost + cost;
    }

    @Override
    public String shortdetail() {
        return "1. Inpatient medical treatment from injury or illness\n" +
                "2. Personal accident insurance (Personal Accident)\n" +
                "3. Back";
    }


    public void getdetail1(String check) {
        if (check.equals("1")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan2()[0]);
            setAnyplan(current_user.getPlan2()[0]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan2(new double[]{0, current_user.getPlan()[1], current_user.getPlan()[2]});
        } else if (check.equals("2")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan2()[1]);
            setAnyplan(current_user.getPlan2()[1]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan2(new double[]{current_user.getPlan()[0], 0, current_user.getPlan()[2]});
        } else if (check.equals("3")) {
            System.out.println("Able to withdraw money :" + current_user.getPlan2()[2]);
            setAnyplan(current_user.getPlan2()[2]);
            System.out.println("Total : "+getAnycost());
            current_user.setPlan2(new double[]{current_user.getPlan()[0], current_user.getPlan()[2],0});
        } else {
            System.out.println("1. Inpatient medical treatment from injury or illness\n" +
                    "1.1 room, board, and nursing service fees (Together up to 365 days)\n" +
                    "- Normal room rate per day\n" +
                    "- intensive care unit fee ICU/CCU per day\n" +
                    "1.2 Medical expenses or general service charge\n" +
                    "- general medical expenses Including continuing treatment within 30 days from " +
                    "the date of discharge from the hospital\n" +
                    "- Medical expenses for emergency accidents due to injuries within 24 hours and " +
                    "continuous treatment within 15 days\n" +
                    "- Ambulance service charges\n" +
                    //1.2 ค่ารักษาพยาบาล หรือค่าบริการทั่วไป\n" +
                    // "- ค่ารักษาพยาบาลทั่วไป รวมการรักษาต่อเนื่องภายใน 30 วัน นับจากวันที่ออกจากโรงพยาบาล\tจ่ายตามจริง\n" +
                    // "- ค่ารักษาพยาบาลอุบัติเหตุฉุกเฉินเนื่องจากการบาดเจ็บ ภายใน 24 ชั่วโมง และการรักษาต่อเนื่องภายใน 15 วัน\t4,000\t6,000\t8,000\n" +
                    //  "- ค่าบริการรถพยาบาล\tจ่ายตามจริง\n" +
                    "1.3 Doctor's fee for surgical treatment\n" +
                    "- Surgical and procedure fees \tactually paid\n" +
                    "- Surgical Consultation Fee in case of surgery (included in the cost of surgeons and procedures)\tactually paid\n" +
                    //"1.3 ค่าธรรมเนียมแพทย์สำหรับการรักษาโดยการผ่าตัด\n"
                    // "- ค่าแพทย์ผ่าตัดและหัตถการ \tจ่ายตามจริง\n" +
                    // "- ค่าปรึกษาทางการผ่าตัด กรณีมีการผ่าตัด (รวมอยู่ในค่าแพทย์ผ่าตัดและหัตถการ)\tจ่ายตามจริง\n" +
                    "1.4 Doctor visit fee or the cost of consulting a specialist specialist\n" +
                    "- Medical care fee 1 time/day (total up to 365 days)\tactual payment\n" +
                    "- Surgical consultant fee in case of no surgery (Included in general medical expenses)\tactually paid\n");
        }
        //plan[0]เอาตรงนี้ไปบวกตรงประกันได้

    }

    public void getdetail2() {
        System.out.println("2. Personal accident insurance (Personal Accident)\n" +
                "Benefit in case of death loss of limbs, sight or total permanent disability as a result of an accident Extend coverage " +
                "for accidents from driving or being a passenger on a motorcycle");
    }


}