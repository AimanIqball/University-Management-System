package Project;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends UniPerson implements Serializable {
    private final static Long serialVersionUID = 8l;

    private ArrayList<StudentCourse> enrolledCourses;
    private String semester;
    private String path;

    public Student(String name, String id, int age, String address, String department, LoginCredentials a, ArrayList<StudentCourse> courses, String semester, String path) {
        super(name, id, age, address, department, a);
        this.enrolledCourses = (courses != null) ? new ArrayList<>(courses) : new ArrayList<>();
        this.semester = semester;
        this.path = path;
    }

    public void enrollInCourse(Course course) {
        for (StudentCourse sc : enrolledCourses) {
            if (sc.getCourse().equals(course)) {
                return;
            }
        }
        StudentMarks<Double> defaultMarks = new StudentMarks<Double>(0.0, 0.0, 0.0, 0.0);
        enrolledCourses.add(new StudentCourse(course, defaultMarks));
    }

    public String getPhotoPath() { return this.path; }
    
    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        for (StudentCourse sc : enrolledCourses) {
            courses.add(sc.getCourse());
        }
        return courses;
    }
    
    public StudentCourse getStudentCourse(String courseCode) {
        for (StudentCourse sc : enrolledCourses) {
            if (sc.getCourse().getCourseCode().equalsIgnoreCase(courseCode)) {
                return sc;
            }
        }
        return null;
    }
    
    public void updateCourseMarks(String courseCode, Double mark, String type) {
        StudentCourse sc = getStudentCourse(courseCode);
        if (sc != null) {
            sc.updateMarks(mark, type);
        }
    }
    
    public Double getCourseMarks(String courseCode) {
        StudentCourse sc = getStudentCourse(courseCode);
        return sc != null ? sc.getTotalMarks() : 0.0;
    }
    
    public void setEnrolledCourses(ArrayList<StudentCourse> courses) { 
        this.enrolledCourses = new ArrayList<>(courses); 
    }
    
    public void updateSemester(String semester) { this.semester = semester; }

    public double getTotalMarks() {
        double total = 0;
        for (StudentCourse sc : enrolledCourses) {
            total += sc.getTotalMarks();
        }
        return total;
    }

    public double calculateGpa() {
    if (enrolledCourses.isEmpty()) return 0.0;
    
    double totalGradePoints = 0.0;
    int totalCredits = 0;
    
    for (StudentCourse sc : enrolledCourses) {
        double courseMarks = sc.getTotalMarks();
        double gradePoint = convertMarksToGradePoint(courseMarks);
        int credits = sc.getCourse().getCredits();
        
        totalGradePoints += (gradePoint * credits);
        totalCredits += credits;
    }
    
    return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
}

    private double convertMarksToGradePoint(double marks) {
        if (marks >= 85) return 4.00;
        if (marks >= 80) return 3.66;
        if (marks >= 75) return 3.33;
        if (marks >= 70) return 3.00;
        if (marks >= 65) return 2.66;
        if (marks >= 60) return 2.33;
        if (marks >= 55) return 2.00;
        if (marks >= 50) return 1.66;
        return 1.33;
    }

    public char calculateGrade() {
        double gpa = calculateGpa();
        if (gpa >= 3.66) return 'A';
        if (gpa >= 3.00) return 'B';
        if (gpa >= 2.66) return 'C';
        if (gpa >= 2.00) return 'D';
        if (gpa >= 1.66) return 'E';
        return 'F';
    }


    public double calculateCourseGpa(String courseCode) {
        StudentCourse sc = getStudentCourse(courseCode);
        if (sc == null) return 0.0;
        
        double marks = sc.getTotalMarks();
        return convertMarksToGradePoint(marks);
    }

    public char calculateCourseGrade(String courseCode) {
        double gpa = calculateCourseGpa(courseCode);
        if (gpa >= 3.66) return 'A';
        if (gpa >= 3.00) return 'B';
        if (gpa >= 2.66) return 'C';
        if (gpa >= 2.00) return 'D';
        if (gpa >= 1.66) return 'E';
        return 'F';
    }
   
    public double overAllAttandance() {
        if (enrolledCourses.isEmpty()) return 0.0;
        double present = 0;
        for (StudentCourse sc : enrolledCourses) {
            present += sc.getCourse().CalculateAttandance();
        }
        return present / enrolledCourses.size();
    }

    public String getCourseDetails(String courseCode) {
        StudentCourse sc = getStudentCourse(courseCode);
        if (sc == null) return "Course not found";
        
        Course course = sc.getCourse();
        double marks = sc.getTotalMarks();
        double gpa = calculateCourseGpa(courseCode);
        char grade = calculateCourseGrade(courseCode);
        
        return String.format("Course: %s - %s\nMarks: %.2f\nGPA: %.2f\nGrade: %c\nCredits: %d",course.getCourseCode(), course.getCourseName(), marks, gpa, grade, course.getCredits());
    }


    public ArrayList<String> getAllCourseGrades() {
        ArrayList<String> courseGrades = new ArrayList<>();
        for (Course course : getCourses()) {
            String courseCode = course.getCourseCode();
            double marks = getCourseMarks(courseCode);
            double gpa = calculateCourseGpa(courseCode);
            char grade = calculateCourseGrade(courseCode);
            
            String gradeInfo = String.format("%s: %.2f marks (GPA: %.2f, Grade: %c)",course.getCourseCode(), marks, gpa, grade);
            courseGrades.add(gradeInfo);
        }
        return courseGrades;
}
}