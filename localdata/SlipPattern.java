package Bank.localdata;

import java.util.Vector;

public interface SlipPattern {
    Vector<String> slipHistory = new Vector<String>();
    String details = "";

    abstract String slip(String note, String cost, String[] bundle);
}
