package Bank;
public abstract class Person {
    private final String user_reference;
    private String user_pin;

    public Person(String user_pin) {
        this.user_reference = generateID();
        this.user_pin = user_pin;
    }

    public abstract String userInformation();

    private String generateID() {
        //long store 8-bytes of number value.
        long id = (long) (Math.random() * Math.pow(10, 10));
        return "UID" + Long.toString(id);
    }

    protected String getUser_pin() {
        return user_pin;
    }

    public String getUser_reference() {
        return user_reference;
    }

}