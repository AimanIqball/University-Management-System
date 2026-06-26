package Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Course implements Serializable {
    private final static Long serialVersionUID = 5l;
    private String name;
    private final String code;
    private String department;
    private int credits;
    private String semester;
    ArrayList<Attandance> attendance;

    public Course(String name, String code, String department, int credits, String semester, ArrayList<Attandance> a) {
        this.name = name;
        this.code = code;
        this.department = department;
        this.credits = credits;
        this.semester = semester;
        this.attendance = a;
    }

    public String getCourseCode() { return code; }
    public String getCourseName() { return name; }
    public void setCourseName(String courseName) { this.name = courseName; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Code: ").append(code).append("\n")
          .append("Course Name: ").append(name).append("\n")
          .append("Department: ").append(department).append("\n")
          .append("Credits: ").append(credits).append("\n")
          .append("Semester: ").append(semester);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Course) {
            Course a = (Course) obj;
            return this.code.equals(a.code);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(name, code);
    }

    public double CalculateAttandance() {
        int presentCount = 0;
        for (Attandance a : attendance) {
            if (a.getAttandance().equalsIgnoreCase("Present")) {
                presentCount += 1;
            }
        }
        Double a = ((double) presentCount / TotalAttandance()) * 100;
        return Math.round(a);
    }

    public boolean canSitInFinal() {
        double present = CalculateAttandance();
        if (present >= 85.00) {
            return true;
        }
        return false;
    }

    public int TotalAttandance() {
        return attendance.size();
    }

    public void setAttandance(Attandance a) {
        if (this.attendance == null) {
            this.attendance = new ArrayList<>();
        }
        this.attendance.add(a);
    }
}
