package Project;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class StudentDashboard extends JFrame implements Serializable {
    private final static Long serialVersionUID = 10L;
    private Student student;

    public StudentDashboard(Student student) {
        this.student = student;

        this.setTitle("COMSATS University - Student Portal");
        this.setSize(700, 650); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(240, 248, 255));
        this.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 51, 102));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel headerLabel = new JLabel("COMSATS UNIVERSITY ISLAMABAD", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        this.add(headerPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel(new BorderLayout(20, 0));
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Name: " + student.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel regLabel = new JLabel("Registration: " + student.getId());
        regLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel deptLabel = new JLabel("Department: " + student.getDepartment());
        deptLabel.setFont(new Font("Arial", Font.BOLD, 12));

        leftPanel.add(nameLabel);
        leftPanel.add(Box.createVerticalStrut(15)); 
        leftPanel.add(regLabel);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(deptLabel);


        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ImageIcon icon = null;
        try {
            String imageName = student.getPhotoPath();
            
            icon = new ImageIcon(StudentDashboard.class.getResource(imageName));
            
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                icon = new ImageIcon(StudentDashboard.class.getResource("Project/" + imageName));
            }
            
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                icon = new ImageIcon(StudentDashboard.class.getResource("/Project/" + imageName));
            }
            
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Image not found: " + imageName);
                Image placeholder = new ImageIcon(createDefaultImage()).getImage();
                Image scaledImg = placeholder.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            } else {
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            }
            
        } catch (Exception e) {
            System.out.println("Error loading image: " + student.getPhotoPath() + " - " + e.getMessage());
            Image placeholder = new ImageIcon(createDefaultImage()).getImage();
            Image scaledImg = placeholder.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImg);
        }

        JLabel photoLabel = new JLabel(icon, SwingConstants.CENTER);
        rightPanel.add(photoLabel, BorderLayout.CENTER);

        centerPanel.add(leftPanel, BorderLayout.WEST);
        centerPanel.add(rightPanel, BorderLayout.CENTER);
        this.add(centerPanel, BorderLayout.CENTER);

 
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 0));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        buttonPanel.setPreferredSize(new Dimension(700, 80)); 


        JButton b1 = new JButton("Enrolled Courses");
        JButton b2 = new JButton("View Marks");
        JButton b3 = new JButton("Attendance");
        JButton b4 = new JButton("Result");
        JButton b5= new JButton("Enroll in course");


        JButton[] buttons = {b1, b2, b3, b4, b5};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 12));
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(0, 51, 102));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createRaisedBevelBorder());
        }


        b1.addActionListener(e-> {
            JFrame frame = new JFrame("Enrolled Courses");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);

            ArrayList<Course> courses = student.getCourses();

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(184, 235, 208));
            mainPanel.setLayout(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            JLabel titleLabel = new JLabel("Enrolled Courses - " + student.getName());
            titleLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mainPanel.add(titleLabel, BorderLayout.NORTH);


            String[] columnNames = {"Course Code", "Course Name", "Department", "Credits", "Semester"};
            Object[][] data = new Object[courses.size()][5];
            
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                data[i][0] = course.getCourseCode();
                data[i][1] = course.getCourseName();
                data[i][2] = course.getDepartment();
                data[i][3] = course.getCredits();
                data[i][4] = course.getSemester();
            }
            
            JTable courseTable = new JTable(data, columnNames);
            courseTable.setRowHeight(30);
            courseTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
            courseTable.setFont(new Font("Arial", Font.PLAIN, 11));
            courseTable.setGridColor(Color.LIGHT_GRAY);
            courseTable.setShowGrid(true);
            courseTable.setEnabled(false); 
            
            JScrollPane scrollPane = new JScrollPane(courseTable);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Current Semester Courses"));
            

            JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            summaryPanel.setBackground(new Color(184, 235, 208));
            JLabel summaryLabel = new JLabel("Total Courses: " + courses.size() + " | ");

            int totalCredits = 0;
            for (Course course : courses) {
                totalCredits += course.getCredits();
            }
            summaryLabel.setText(summaryLabel.getText() + "Total Credits: " + totalCredits);
            summaryLabel.setFont(new Font("Arial", Font.BOLD, 12));
            summaryPanel.add(summaryLabel);
            
            mainPanel.add(scrollPane, BorderLayout.CENTER);
            mainPanel.add(summaryPanel, BorderLayout.SOUTH);
            
            frame.add(mainPanel);
            frame.setVisible(true);
        });
        
        b2.addActionListener(e->{
             JFrame frame = new JFrame("Marks");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            
            ArrayList<Course> courses = student.getCourses();

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(184, 235, 208));
            mainPanel.setLayout(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel headerrPanel = new JPanel();
            headerrPanel.setBackground(new Color(0, 102, 51));
            JLabel titleLabel = new JLabel("Academic Marks");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            headerrPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerrPanel.add(titleLabel);

            String[] columnNames = {"Course Code", "Course Name", "Marks", "Out of"};
            Object[][] data = new Object[courses.size()][4];
            
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                double marks = student.getCourseMarks(course.getCourseCode());
                data[i][0] = course.getCourseCode();
                data[i][1] = course.getCourseName();
                data[i][2] = String.format("%.2f", marks);
                data[i][3] = "100.00";
            }
            
            JTable marksTable = new JTable(data, columnNames);
            marksTable.setRowHeight(30);
            marksTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
            marksTable.setFont(new Font("Arial", Font.PLAIN, 11));
            marksTable.setGridColor(Color.LIGHT_GRAY);
            marksTable.setShowGrid(true);
            marksTable.setEnabled(false);
            
            JScrollPane scrollPane = new JScrollPane(marksTable);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Course-wise Marks"));

            JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 5));
            summaryPanel.setBackground(new Color(184, 235, 208));
            summaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            double totalMarks = student.getTotalMarks();
            double averageMarks = courses.size() > 0 ? totalMarks / courses.size() : 0;
            
            JLabel totalLabel = new JLabel("Total Marks: " + String.format("%.2f", totalMarks));
            JLabel averageLabel = new JLabel("Average: " + String.format("%.2f", averageMarks));
            JLabel coursesLabel = new JLabel("Courses: " + courses.size());
            
            totalLabel.setFont(new Font("Arial", Font.BOLD, 12));
            averageLabel.setFont(new Font("Arial", Font.BOLD, 12));
            coursesLabel.setFont(new Font("Arial", Font.BOLD, 12));
            
            summaryPanel.add(totalLabel);
            summaryPanel.add(averageLabel);
            summaryPanel.add(coursesLabel);
            
            mainPanel.add(headerrPanel, BorderLayout.NORTH);
            mainPanel.add(scrollPane, BorderLayout.CENTER);
            mainPanel.add(summaryPanel, BorderLayout.SOUTH);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
        
        b3.addActionListener(e->{
            JFrame frame = new JFrame("Attendance");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 450);
            frame.setLocationRelativeTo(null);
            
            ArrayList<Course> courses = student.getCourses();

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(184, 235, 208));
            mainPanel.setLayout(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel headerrPanel = new JPanel();
            headerrPanel.setBackground(new Color(102, 0, 51));
            JLabel titleLabel = new JLabel("Attendance Record");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            headerrPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            headerrPanel.add(titleLabel);


            String[] columnNames = {"Course Code", "Course Name", "Attendance %", "Status", "Final Eligible"};
            Object[][] data = new Object[courses.size()][5];
            
            double totalAttendance = 0;
            
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                double attendancePercent = course.CalculateAttandance();
                boolean canSit = course.canSitInFinal();
                String status = attendancePercent >= 85 ? "Good" : attendancePercent >= 75 ? "Fair" : "Poor";
                
                data[i][0] = course.getCourseCode();
                data[i][1] = course.getCourseName();
                data[i][2] = String.format("%.1f%%", attendancePercent);
                data[i][3] = status;
                data[i][4] = canSit ? "Eligible" : "Not Eligible";
                
                totalAttendance += attendancePercent;
            }
            
            JTable attTable = new JTable(data, columnNames) {
                @Override
                public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                    Component c = super.prepareRenderer(renderer, row, column);
                    

                    String status = (String) getValueAt(row, 3);
                    
                    if (status.equals("Good")) {
                        c.setBackground(new Color(200, 255, 200)); 
                    } else if (status.equals("Fair")) {
                        c.setBackground(new Color(255, 255, 200)); 
                    } else {
                        c.setBackground(new Color(255, 200, 200)); 
                    }
                    
                    if (column == 4) {
                        String eligible = (String) getValueAt(row, 4);
                        if (eligible.contains("Eligible")) {
                            c.setForeground(Color.GREEN.darker());
                        } else {
                            c.setForeground(Color.RED);
                        }
                        c.setFont(c.getFont().deriveFont(Font.BOLD));
                    }
                    
                    return c;
                }
        };
        
        attTable.setRowHeight(30);
        attTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        attTable.setFont(new Font("Arial", Font.PLAIN, 11));
        attTable.setGridColor(Color.LIGHT_GRAY);
        attTable.setShowGrid(true);
        attTable.setEnabled(false);
        attTable.setOpaque(true);
        
        JScrollPane scrollPane = new JScrollPane(attTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Course-wise Attendance"));
        
        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        summaryPanel.setBackground(new Color(184, 235, 208));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        double avgAttendance = courses.size() > 0 ? totalAttendance / courses.size() : 0;
        int eligibleCount = 0;
        for (Course course : courses) {
            if (course.canSitInFinal()) eligibleCount++;
        }
        
        JLabel avgLabel = new JLabel("Average Attendance: " + String.format("%.1f%%", avgAttendance));
        JLabel eligibleLabel = new JLabel("Eligible for Final: " + eligibleCount + "/" + courses.size());
        JLabel coursesLabel = new JLabel("Total Courses: " + courses.size());
        
        avgLabel.setFont(new Font("Arial", Font.BOLD, 12));
        eligibleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        coursesLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        if (avgAttendance >= 85) {
            avgLabel.setForeground(Color.GREEN.darker());
        } else if (avgAttendance >= 75) {
            avgLabel.setForeground(Color.ORANGE.darker());
        } else {
            avgLabel.setForeground(Color.RED);
        }
        
        summaryPanel.add(avgLabel);
        summaryPanel.add(eligibleLabel);
        summaryPanel.add(coursesLabel);
        
        mainPanel.add(headerrPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(summaryPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
});
        
        b4.addActionListener(e->{
            JFrame frame = new JFrame("Result");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);


            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(184, 235, 208));
            mainPanel.setLayout(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            JPanel headerrPanel = new JPanel(new GridLayout(3, 2, 10, 5));
            headerrPanel.setBackground(new Color(184, 235, 208));
            headerrPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));
            
            headerrPanel.add(new JLabel("Name:"));
            headerrPanel.add(new JLabel(student.getName()));
            headerrPanel.add(new JLabel("Registration No:"));
            headerrPanel.add(new JLabel(student.getId()));
            headerrPanel.add(new JLabel("Department:"));
            headerrPanel.add(new JLabel(student.getDepartment()));
            
            mainPanel.add(headerrPanel, BorderLayout.NORTH);


            ArrayList<Course> courses = student.getCourses();
            String[] columnNames = {"Course Code", "Course Name", "Marks", "Grade Point", "Grade", "Credits"};
            Object[][] data = new Object[courses.size()][6];
            
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                double marks = student.getCourseMarks(course.getCourseCode());
                double gpa = student.calculateCourseGpa(course.getCourseCode());
                char grade = student.calculateCourseGrade(course.getCourseCode());
                
                data[i][0] = course.getCourseCode();
                data[i][1] = course.getCourseName();
                data[i][2] = String.format("%.2f", marks);
                data[i][3] = String.format("%.2f", gpa);
                data[i][4] = grade;
                data[i][5] = course.getCredits();
            }
            
            JTable resultTable = new JTable(data, columnNames);
            resultTable.setRowHeight(25);
            resultTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
            resultTable.setFont(new Font("Arial", Font.PLAIN, 11));
            resultTable.setGridColor(Color.GRAY);
            resultTable.setShowGrid(true);
            resultTable.setEnabled(false); 

            JScrollPane scrollPane = new JScrollPane(resultTable);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Course-wise Results"));
            mainPanel.add(scrollPane, BorderLayout.CENTER);


            JPanel summaryPanel = new JPanel(new GridLayout(2, 3, 10, 5));
            summaryPanel.setBackground(new Color(184, 235, 208));
            summaryPanel.setBorder(BorderFactory.createTitledBorder("Academic Summary"));
            
            double totalMarks = student.getTotalMarks();
            double overallGpa = student.calculateGpa();
            char overallGrade = student.calculateGrade();
            

            int totalCredits = 0;
            for (Course course : courses) {
                totalCredits += course.getCredits();
            }
            
            JLabel totalMarksLabel = new JLabel("Total Marks: " + String.format("%.2f", totalMarks));
            JLabel totalCreditsLabel = new JLabel("Total Credits: " + totalCredits);
            JLabel coursesCountLabel = new JLabel("Courses: " + courses.size());
            JLabel gpaLabel = new JLabel("Overall GPA: " + String.format("%.2f", overallGpa));
            JLabel gradeLabel = new JLabel("Overall Grade: " + overallGrade);
            

            Font summaryFont = new Font("Arial", Font.BOLD, 12);
            totalMarksLabel.setFont(summaryFont);
            totalCreditsLabel.setFont(summaryFont);
            coursesCountLabel.setFont(summaryFont);
            gpaLabel.setFont(summaryFont);
            gradeLabel.setFont(summaryFont);
            
 
            if (overallGpa >= 3.66) {
                gpaLabel.setForeground(Color.GREEN.darker());
                gradeLabel.setForeground(Color.GREEN.darker());
            } else if (overallGpa >= 3.00) {
                gpaLabel.setForeground(Color.BLUE);
                gradeLabel.setForeground(Color.BLUE);
            } else if (overallGpa >= 2.00) {
                gpaLabel.setForeground(Color.ORANGE.darker());
                gradeLabel.setForeground(Color.ORANGE.darker());
            } else {
                gpaLabel.setForeground(Color.RED);
                gradeLabel.setForeground(Color.RED);
            }
            
            summaryPanel.add(totalMarksLabel);
            summaryPanel.add(totalCreditsLabel);
            summaryPanel.add(coursesCountLabel);
            summaryPanel.add(gpaLabel);
            summaryPanel.add(gradeLabel);
            
            mainPanel.add(summaryPanel, BorderLayout.SOUTH);

            frame.add(mainPanel);
            frame.setVisible(true);
        });

         b5.addActionListener(e -> {
    JFrame enrollFrame = new JFrame("Enroll in Course");
    enrollFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    enrollFrame.setSize(500, 400);
    enrollFrame.setLocationRelativeTo(null);
    
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(new Color(184, 235, 208));
    mainPanel.setLayout(new BorderLayout(10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    JLabel titleLabel = new JLabel("Available Courses for Enrollment");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    mainPanel.add(titleLabel, BorderLayout.NORTH);
    
    ArrayList<Course> availableCourses = new ArrayList<>();
    try {
        File coursesFile = new File("Courses.bin");
        if (coursesFile.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(coursesFile))) {
                availableCourses = (ArrayList<Course>) in.readObject();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Courses file not found!");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading courses: " + ex.getMessage());
        return; 
    }
    
    if (availableCourses.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No courses available for enrollment!");
        return;
    }
    
    ArrayList<Course> studentCourses = student.getCourses();
    ArrayList<Course> enrollableCourses = new ArrayList<>();
    for (Course course : availableCourses) {
        boolean alreadyEnrolled = false;
        for (Course enrolledCourse : studentCourses) {
            if (enrolledCourse.getCourseCode().equals(course.getCourseCode())) {
                alreadyEnrolled = true;
                break;
            }
        }
        if (!alreadyEnrolled) {
            enrollableCourses.add(course);
        }
    }
    
    if (enrollableCourses.isEmpty()) {
        JOptionPane.showMessageDialog(this, "You are already enrolled in all available courses!");
        return;
    }
    
    String[] columnNames = {"Course Code", "Course Name", "Department", "Credits", "Semester", "Select"};
    Object[][] data = new Object[enrollableCourses.size()][6];
    
    for (int i = 0; i < enrollableCourses.size(); i++) {
        Course course = enrollableCourses.get(i);
        data[i][0] = course.getCourseCode();
        data[i][1] = course.getCourseName();
        data[i][2] = course.getDepartment();
        data[i][3] = course.getCredits();
        data[i][4] = course.getSemester();
        data[i][5] = Boolean.FALSE; 
    }
    
    JTable coursesTable = new JTable(data, columnNames) {
        @Override
        public Class<?> getColumnClass(int column) {
            return column == 5 ? Boolean.class : String.class;
        }
    };
    
    coursesTable.setRowHeight(30);
    coursesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
    coursesTable.setFont(new Font("Arial", Font.PLAIN, 11));
    coursesTable.setGridColor(Color.LIGHT_GRAY);
    coursesTable.setShowGrid(true);
    
    JScrollPane scrollPane = new JScrollPane(coursesTable);
    mainPanel.add(scrollPane, BorderLayout.CENTER);
    
    JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    buttonPanel2.setBackground(new Color(184, 235, 208));
    
    JButton enrollButton = new JButton("Enroll in Selected Courses");
    enrollButton.setFont(new Font("Arial", Font.BOLD, 12));
    enrollButton.setForeground(Color.WHITE);
    enrollButton.setBackground(new Color(0, 102, 51));
    enrollButton.setFocusPainted(false);
    
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
    cancelButton.setForeground(Color.WHITE);
    cancelButton.setBackground(new Color(102, 0, 0));
    cancelButton.setFocusPainted(false);
    cancelButton.addActionListener(ev -> enrollFrame.dispose());
    
    enrollButton.addActionListener(ev -> {
        boolean anySelected = false;
        ArrayList<Course> selectedCourses = new ArrayList<>();
        
        for (int i = 0; i < enrollableCourses.size(); i++) {
            if ((Boolean) coursesTable.getValueAt(i, 5)) {
                anySelected = true;
                selectedCourses.add(enrollableCourses.get(i));
            }
        }
        
        if (!anySelected) {
            JOptionPane.showMessageDialog(enrollFrame, "Please select at least one course to enroll!");
            return;
        }
        
       
        for (Course course : selectedCourses) {
            student.enrollInCourse(course);
        }

        try {
            File studentFile = new File("Student.bin");
            if (studentFile.exists()) {
                ArrayList<Student> allStudents = new ArrayList<>();
                

                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
                    allStudents = (ArrayList<Student>) in.readObject();
                }
                

                boolean studentFound = false;
                for (int i = 0; i < allStudents.size(); i++) {
                    if (allStudents.get(i).getId().equals(student.getId())) {

                        Student updatedStudent = student;

                        StudentCourse[] studentCourseArray = new StudentCourse[student.getCourses().size()];
                        for (int j = 0; j < student.getCourses().size(); j++) {
                            Course c = student.getCourses().get(j);
                            studentCourseArray[j] = new StudentCourse(c, null);
                        }
                        
                        allStudents.set(i, student); 
                        studentFound = true;
                        break;
                    }
                }
                
                if (!studentFound) {
                    JOptionPane.showMessageDialog(enrollFrame, "Student not found in records!");
                    return;
                }
                

                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentFile))) {
                    out.writeObject(allStudents);
                }
                
                JOptionPane.showMessageDialog(enrollFrame, "Successfully enrolled in " + selectedCourses.size() + " course(s)!");
                enrollFrame.dispose();
                

                JOptionPane.showMessageDialog(StudentDashboard.this,"Enrollment successful! Please check 'Enrolled Courses' to see your updated course list.");
                
            } else {
                JOptionPane.showMessageDialog(enrollFrame, "Student data file not found!");
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(enrollFrame, "Error updating student data: " + ex.getMessage());
        }
    });
    buttonPanel2.add(enrollButton);
    buttonPanel2.add(cancelButton);
    mainPanel.add(buttonPanel2, BorderLayout.SOUTH);

    enrollFrame.add(mainPanel);
    enrollFrame.setVisible(true);
        });

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);

        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    private Image createDefaultImage() {
        Image img = new ImageIcon(new byte[0]).getImage();
        try {
            java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(180, 180, java.awt.image.BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            
            g2d.setColor(new Color(220, 220, 220));
            g2d.fillRect(0, 0, 180, 180);
            
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(0, 0, 179, 179);
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            String text = "No Image";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (180 - fm.stringWidth(text)) / 2;
            int y = 90;
            g2d.drawString(text, x, y);
            
            g2d.dispose();
            return bufferedImage;
        } catch (Exception e) {
            return img;
        }
    }

    public static void main(String[] args) {
        LoginCredentials a = new LoginCredentials("sp25-bse-005", "aiman");
        
        ArrayList<Attandance> attendance = new ArrayList<>(Arrays.asList(
            new Attandance("PRESENT"), new Attandance("Absent"), new Attandance("Present"),
            new Attandance("PRESENT"), new Attandance("Absent"), new Attandance("Present"),
            new Attandance("PRESENT"), new Attandance("Absent"), new Attandance("Present")
        ));
        
        Course c1 = new Course("oop", "csc-102", "cs", 4, "2nd", attendance);
        Course c2 = new Course("calculus", "math-101", "cs", 3, "2nd", attendance);
        
        ArrayList<StudentCourse> studentCourses = new ArrayList<>();
        studentCourses.add(new StudentCourse(c1, new StudentMarks<Double>(15.00, 15.00, 23.00, 40.00)));
        studentCourses.add(new StudentCourse(c2, new StudentMarks<Double>(12.00, 14.00, 25.00, 38.00)));

        Student s = new Student(
            "Aiman",
            "SP25-BSE-005",
            20,
            "g15",
            "Computer Science",
            a,
            studentCourses,
            "Second",
            "IMG-20251207-WA0045.jpg"  
        );
        new StudentDashboard(s);
    }
}