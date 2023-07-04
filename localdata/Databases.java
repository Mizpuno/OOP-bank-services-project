package Bank.localdata;

import Bank.Accounts;
import Bank.user_type.Users;
import java.util.HashMap;
import java.util.Vector;

public interface Databases {
    HashMap<String, Users> users_package = new HashMap<>();
    Vector<Accounts> accountsVector = new Vector<>();
}



