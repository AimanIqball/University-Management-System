package Project;

import java.io.Serializable;

public class StudentCourse implements Serializable {
    private final static Long serialVersionUID = 13l;
    
    private Course course;
    private StudentMarks<Double> marks;
    
    public StudentCourse(Course course, StudentMarks<Double> marks) {
        this.course = course;
        this.marks = marks;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public StudentMarks<Double> getMarks() {
        return marks;
    }
    
    public void setMarks(StudentMarks<Double> marks) {
        this.marks = marks;
    }
    
    public double getTotalMarks() {
        if (marks == null) return 0.0;
        double quiz = marks.getQuizMarks() != null ? marks.getQuizMarks().doubleValue() : 0.0;
        double assign = marks.getAssignMarks() != null ? marks.getAssignMarks().doubleValue() : 0.0;
        double mids = marks.getMidMarks() != null ? marks.getMidMarks().doubleValue() : 0.0;
        double finalMarks = marks.getFinalMarks() != null ? marks.getFinalMarks().doubleValue() : 0.0;
        return quiz + assign + mids + finalMarks;
    }
    
    public void updateMarks(Double mark, String type) {
        if (marks == null) {
            marks = new StudentMarks<Double>(0.0, 0.0, 0.0, 0.0);
        }
        if (type.equalsIgnoreCase("mids")) {
            marks.setMidMarks(mark);
        } else if (type.equalsIgnoreCase("assignment")) {
            marks.setAssignMarks(mark);
        } else if (type.equalsIgnoreCase("quiz")) {
            marks.setQuizMarks(mark);
        } else if (type.equalsIgnoreCase("final")) {
            marks.setFinalMarks(mark);
        }
    }
}
