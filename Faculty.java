package Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Faculty extends UniPerson implements Serializable {
    private final static Long serialVersionUID = 6l;
    ArrayList<Course> teachCourses;
    private String path;

    public Faculty(String name, String id, int age, String address, String department, LoginCredentials a, ArrayList<Course> teach, String path) {
        super(name, id, age, address, department, a);
        this.teachCourses = (teach != null) ? new ArrayList<>(teach) : new ArrayList<>();
        this.path = path;
    }

    public String toString() {
        String[] courses = new String[teachCourses.size()];
        int x = 0;
        for (Course a : teachCourses) {
            courses[x] = a.getCourseCode();
            x++;
        }
        return super.toString() + " Teach Courses: " + Arrays.toString(courses);
    }

    @Override
    public String getPhotoPath() { return this.path; }
    public ArrayList<Course> getCourses() { return teachCourses; }
}
