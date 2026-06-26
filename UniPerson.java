package Project;

import java.io.Serializable;
import java.util.Objects;

public abstract class UniPerson implements Serializable {
    private final static Long serialVersionUID = 1l;
    private LoginCredentials login;
    private final String name;
    private final String id;
    private int age;
    private String address;
    private String department;

    public UniPerson(String name, String id, int age, String address, String department, LoginCredentials a) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
        this.department = department;
        this.login = new LoginCredentials(a.getUsername(), a.getPassword());
    }

    @Override
    public String toString() {
        return "Person Details:\n" + "  ID: " + id + "\n" + "  Name: " + name + "\n" + "  Department: " + department + "\n";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof UniPerson) {
            UniPerson a = (UniPerson) obj;
            return this.id.equals(a.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getPasword() {
        return login.getPassword();
    }

    public LoginCredentials getLogin() {
        return login;
    }
    abstract String getPhotoPath();
}
