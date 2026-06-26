package Project;
import java.io.Serializable;


public class Admin extends UniPerson implements Serializable{
    private final static Long serialVersionUID=3l;
    String path;

   public Admin(String name, String id, int age, String address, String department,LoginCredentials a, String path) {
        super(name, id, age, address, department, a);
        this.path=path;
    }

    public String toString(){
        return super.toString();
    }
    @Override
    public String getPhotoPath() { return this.path; }

}
