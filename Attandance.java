package Project;

import java.io.Serializable;

public class Attandance implements Serializable {
    private final static Long serialVersionUID = 9l;

    String attandace;

    public Attandance(String attandace) {
        if (attandace.equalsIgnoreCase("Present") || attandace.equalsIgnoreCase("Absent")) {
            this.attandace = attandace;
        } else {
            attandace = null;
        }
    }

    public String getAttandance() { return attandace; }
}

