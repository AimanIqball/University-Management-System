package Project;

import java.io.Serializable;

public class StudentMarks<T extends Number> implements Serializable {
    private final static Long serialVersionUID = 7l;
    private T assignMarks;
    private T quizMarks;
    private T midMarks;
    private T finalMarks;

    public StudentMarks(T assignMarks, T quizMarks, T midMarks, T finalMarks) {
        this.assignMarks = assignMarks;
        this.quizMarks = quizMarks;
        this.midMarks = midMarks;
        this.finalMarks = finalMarks;
    }

    public T getAssignMarks() { return assignMarks; }
    public T getQuizMarks() { return quizMarks; }
    public T getMidMarks() { return midMarks; }
    public T getFinalMarks() { return finalMarks; }

    public void setAssignMarks(T assignMarks) { this.assignMarks = assignMarks; }
    public void setQuizMarks(T quizMarks) { this.quizMarks = quizMarks; }
    public void setMidMarks(T midMarks) { this.midMarks = midMarks; }
    public void setFinalMarks(T finalMarks) { this.finalMarks = finalMarks; }
}

