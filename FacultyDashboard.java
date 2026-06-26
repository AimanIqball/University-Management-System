package Project;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class FacultyDashboard extends JFrame implements Serializable {
    private final static Long serialVersionUID = 11l;
    private Faculty faculty;

    public FacultyDashboard(Faculty faculty){
        this.faculty = faculty;

        this.setTitle("COMSATS University - Faculty Portal");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(240, 248, 255));
        this.setLayout(new BorderLayout(20, 20));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 51, 102));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel headerLabel = new JLabel("COMSATS UNIVERSITY ISLAMABAD", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel nameLabel = new JLabel("Name: " + faculty.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 51, 102));

        JLabel regLabel = new JLabel("Faculty ID: " + faculty.getId());
        regLabel.setFont(new Font("Arial", Font.BOLD, 14));
        regLabel.setForeground(new Color(0, 51, 102));

        JLabel deptLabel = new JLabel("Department: " + faculty.getDepartment());
        deptLabel.setFont(new Font("Arial", Font.BOLD, 14));
        deptLabel.setForeground(new Color(0, 51, 102));

        leftPanel.add(nameLabel);
        leftPanel.add(Box.createVerticalStrut(20)); 
        leftPanel.add(regLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(deptLabel);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(StudentDashboard.class.getResource("/Project/" + faculty.getPhotoPath()));
        } catch (Exception e) {
            System.out.println("Image not found: " + faculty.getPhotoPath());
        }

        if (icon != null) {
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImg);
        }

        JLabel photoLabel = new JLabel(icon);
        rightPanel.add(photoLabel);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        buttonPanel.setBackground(new Color(240, 248, 255));

        JRadioButton b1 = new JRadioButton("Attendance");
        b1.setFont(new Font("Arial", Font.BOLD, 12));
        b1.setForeground(new Color(0, 51, 102));
        b1.setBackground(new Color(240, 248, 255));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(e->{
            
            JFrame frame = new JFrame("Attendance");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ArrayList<Course> courses = faculty.getCourses();

            JPanel panel1 = new JPanel();
            panel1.setBackground(new Color(0, 51, 102));
            JLabel l1 = new JLabel("Course Attendance");
            l1.setFont(new Font("Arial", Font.BOLD, 24));
            l1.setForeground(Color.WHITE);
            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            panel1.add(l1);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2, 15, 15));
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            for (Course c : courses) {
                JLabel courseLabel = new JLabel(c.getCourseCode());
                courseLabel.setFont(new Font("Arial", Font.BOLD, 12));
                String attendance = String.format("%.1f%%", c.CalculateAttandance());
                JLabel attLabel = new JLabel(attendance);
                attLabel.setFont(new Font("Arial", Font.BOLD, 12));
                
                double attValue = c.CalculateAttandance();
                if (attValue >= 85) {
                    attLabel.setForeground(Color.GREEN.darker());
                } else if (attValue >= 75) {
                    attLabel.setForeground(Color.ORANGE);
                } else {
                    attLabel.setForeground(Color.RED);
                }
                
                panel.add(courseLabel);
                panel.add(attLabel);
            }
            
            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(240, 248, 255));
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(panel1, BorderLayout.NORTH);
            mainPanel.add(new JScrollPane(panel), BorderLayout.CENTER);

            frame.add(mainPanel);
            frame.setSize(450, 350);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        
        JRadioButton b2 = new JRadioButton("Add Marks");
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setForeground(new Color(0, 51, 102));
        b2.setBackground(new Color(240, 248, 255));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(e -> {
            JFrame frame = new JFrame("Add Marks");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 400);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel regLabel2 = new JLabel("Student Registration:");
            regLabel2.setFont(new Font("Arial", Font.BOLD, 12));
            regLabel2.setForeground(new Color(0, 51, 102));
            panel.add(regLabel2);
            JTextField regField = new JTextField();
            regField.setMaximumSize(new Dimension(300, 30));
            panel.add(regField);
            panel.add(Box.createVerticalStrut(15));

            JLabel courseLabel = new JLabel("Course Code:");
            courseLabel.setFont(new Font("Arial", Font.BOLD, 12));
            courseLabel.setForeground(new Color(0, 51, 102));
            panel.add(courseLabel);
            JTextField courseField = new JTextField();
            courseField.setMaximumSize(new Dimension(300, 30));
            panel.add(courseField);
            panel.add(Box.createVerticalStrut(15));

            JLabel typeLabel = new JLabel("Marks Type (quiz/assignment/mids/final):");
            typeLabel.setFont(new Font("Arial", Font.BOLD, 12));
            typeLabel.setForeground(new Color(0, 51, 102));
            panel.add(typeLabel);
            JTextField typeField = new JTextField();
            typeField.setMaximumSize(new Dimension(300, 30));
            panel.add(typeField);
            panel.add(Box.createVerticalStrut(15));

            JLabel marksLabel = new JLabel("Marks:");
            marksLabel.setFont(new Font("Arial", Font.BOLD, 12));
            marksLabel.setForeground(new Color(0, 51, 102));
            panel.add(marksLabel);
            JTextField marksField = new JTextField();
            marksField.setMaximumSize(new Dimension(300, 30));
            panel.add(marksField);
            panel.add(Box.createVerticalStrut(20));
            

            JButton submit = new JButton("Submit");
            submit.setFont(new Font("Arial", Font.BOLD, 12));
            submit.setForeground(Color.WHITE);
            submit.setBackground(new Color(0, 51, 102));
            submit.setFocusPainted(false);
            submit.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(submit);

            frame.add(panel);
            frame.setVisible(true);

            submit.addActionListener(ev -> {
                try {
                    String reg = regField.getText().trim();
                    String type = typeField.getText().trim().toLowerCase();
                    String course = courseField.getText().trim();
                    double marks = Double.parseDouble(marksField.getText().trim());

                    if(reg.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered Student id");
                        return;
                    }
                    if(type.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered Type of marks");
                        return;
                    }
                    if(course.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered course id");
                        return;
                    }
                    if(marksField.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered marks");
                        return;
                    }
                    if(!(type.equalsIgnoreCase("quiz") || type.equalsIgnoreCase("assignment")|| type.equalsIgnoreCase("mid")|| type.equalsIgnoreCase("final"))){
                        JOptionPane.showMessageDialog(frame, "You have not entered correct type opf marks");
                        return;
                    }
                    File file = new File("Student.bin");
                    if(!file.exists()){
                        JOptionPane.showMessageDialog(frame, "Student data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ArrayList<Student> students = new ArrayList<>();
                    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                        students = (ArrayList<Student>) in.readObject();
                        boolean found = false;
                        
                        for(Student student : students){
                            if(student.getId().equalsIgnoreCase(reg)){
                                student.updateCourseMarks(course, marks, type);
                                JOptionPane.showMessageDialog(frame, "Marks added successfully!\n" +"Student: " + student.getName() + "\n" +"Course: " + course + "\n" +"Type: " + type + "\n" + "Marks: " + marks, "Success", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                break;
                            }
                        }
                        
                        if(!found){
                            JOptionPane.showMessageDialog(frame, "Student not found with registration: " + reg,"Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
                            out.writeObject(students);
                        }
                    } catch(ClassNotFoundException | IOException ex){
                        JOptionPane.showMessageDialog(frame, "Error accessing student data: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for marks!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        
        JRadioButton b3 = new JRadioButton("Add Attendance");
        b3.setFont(new Font("Arial", Font.BOLD, 12));
        b3.setForeground(new Color(0, 51, 102));
        b3.setBackground(new Color(240, 248, 255));
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(e -> {
            JFrame frame = new JFrame("Add Attendance");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 350);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel regLabel2 = new JLabel("Student Registration:");
            regLabel2.setFont(new Font("Arial", Font.BOLD, 12));
            regLabel2.setForeground(new Color(0, 51, 102));
            panel.add(regLabel2);
            JTextField regField = new JTextField();
            regField.setMaximumSize(new Dimension(300, 30));
            panel.add(regField);
            panel.add(Box.createVerticalStrut(15));

            JLabel courseLabel = new JLabel("Course Code:");
            courseLabel.setFont(new Font("Arial", Font.BOLD, 12));
            courseLabel.setForeground(new Color(0, 51, 102));
            panel.add(courseLabel);
            JTextField courseField = new JTextField();
            courseField.setMaximumSize(new Dimension(300, 30));
            panel.add(courseField);
            panel.add(Box.createVerticalStrut(15));

            JLabel attLabel = new JLabel("Attendance (Present/Absent):");
            attLabel.setFont(new Font("Arial", Font.BOLD, 12));
            attLabel.setForeground(new Color(0, 51, 102));
            panel.add(attLabel);
            JTextField attendanceField = new JTextField();
            attendanceField.setMaximumSize(new Dimension(300, 30));
            panel.add(attendanceField);
            panel.add(Box.createVerticalStrut(20));

            JButton submit = new JButton("Submit");
            submit.setFont(new Font("Arial", Font.BOLD, 12));
            submit.setForeground(Color.WHITE);
            submit.setBackground(new Color(0, 51, 102));
            submit.setFocusPainted(false);
            submit.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(submit);

            frame.add(panel);
            frame.setVisible(true);

            submit.addActionListener(ev -> {
                try {
                    String reg = regField.getText().trim();
                    String course = courseField.getText().trim();
                    String attendance = attendanceField.getText().trim();

                      if(reg.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered Student id");
                        return;
                    }
                    if(attendance.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered Type of marks");
                        return;
                    }
                    if(course.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered course id");
                        return;
                    }
                    
                    if(!attendance.equalsIgnoreCase("Present") && !attendance.equalsIgnoreCase("Absent")){
                        JOptionPane.showMessageDialog(frame, "Attendance must be 'Present' or 'Absent'!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    File file = new File("Student.bin");
                    if(!file.exists()){
                        JOptionPane.showMessageDialog(frame, "Student data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ArrayList<Student> students = new ArrayList<>();
                    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                        students = (ArrayList<Student>) in.readObject();
                        boolean found = false;
                        
                        for(Student student : students){
                            if(student.getId().equalsIgnoreCase(reg)){
                                StudentCourse sc = student.getStudentCourse(course);
                                if(sc != null){
                                    sc.getCourse().setAttandance(new Attandance(attendance));
                                    JOptionPane.showMessageDialog(frame, "Attendance added successfully!\n" +"Student: " + student.getName() + "\n" +"Course: " + course + "\n" +"Attendance: " + attendance, "Success", JOptionPane.INFORMATION_MESSAGE);
                                    found = true;
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Student is not enrolled in course: " + course,"Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                break;
                            }
                        }
                        
                        if(!found){
                            JOptionPane.showMessageDialog(frame, "Student not found with registration: " + reg,"Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
                            out.writeObject(students);
                        }
                    } catch(ClassNotFoundException | IOException ex){
                        JOptionPane.showMessageDialog(frame, "Error accessing student data: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        
        JRadioButton b4 = new JRadioButton("Student GPA");
        b4.setFont(new Font("Arial", Font.BOLD, 12));
        b4.setForeground(new Color(0, 51, 102));
        b4.setBackground(new Color(240, 248, 255));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.addActionListener(e -> {
            JFrame frame = new JFrame("Student GPA");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel regLabel2 = new JLabel("Student Registration:");
            regLabel2.setFont(new Font("Arial", Font.BOLD, 12));
            regLabel2.setForeground(new Color(0, 51, 102));
            panel.add(regLabel2);
            JTextField regField = new JTextField();
            regField.setMaximumSize(new Dimension(300, 30));
            panel.add(regField);
            panel.add(Box.createVerticalStrut(20));

            JButton submit = new JButton("Get GPA");
            submit.setFont(new Font("Arial", Font.BOLD, 12));
            submit.setForeground(Color.WHITE);
            submit.setBackground(new Color(0, 51, 102));
            submit.setFocusPainted(false);
            submit.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(submit);

            frame.add(panel);
            frame.setVisible(true);

            submit.addActionListener(ev -> {
                try {
                    String reg = regField.getText().trim();
                    if(reg.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered Student id");
                        return;
                    }
                    
                    
                    File file = new File("Student.bin");
                    if(!file.exists()){
                        JOptionPane.showMessageDialog(frame, "Student data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                        ArrayList<Student> students = (ArrayList<Student>) in.readObject();
                        boolean found = false;
                        
                        for(Student student : students){
                            if(student.getId().equalsIgnoreCase(reg)){
                                double gpa = student.calculateGpa();
                                double totalMarks = student.getTotalMarks();
                                char grade = student.calculateGrade();
                                
                                JOptionPane.showMessageDialog(frame, "Student: " + student.getName() + "\n" + "Registration: " + student.getId() + "\n" +
                                    "Total Marks: " + totalMarks + "\n" +
                                    "GPA: " + String.format("%.2f", gpa) + "\n" +
                                    "Grade: " + grade, "Student GPA", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                break;
                            }
                        }
                        
                        if(!found){
                            JOptionPane.showMessageDialog(frame, "Student not found with registration: " + reg,
                                "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error accessing student data: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        
        JRadioButton b5 = new JRadioButton("View Top Performers");
        b5.setFont(new Font("Arial", Font.BOLD, 12));
        b5.setForeground(new Color(0, 51, 102));
        b5.setBackground(new Color(240, 248, 255));
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.addActionListener(e->{
            JFrame frame = new JFrame("Top Performers");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel courseLabel = new JLabel("Course Code:");
            courseLabel.setFont(new Font("Arial", Font.BOLD, 12));
            courseLabel.setForeground(new Color(0, 51, 102));
            panel.add(courseLabel);
            JTextField courseField = new JTextField();
            courseField.setMaximumSize(new Dimension(300, 30));
            panel.add(courseField);
            panel.add(Box.createVerticalStrut(20));

            JButton submit = new JButton("Find Top Performers");
            submit.setFont(new Font("Arial", Font.BOLD, 12));
            submit.setForeground(Color.WHITE);
            submit.setBackground(new Color(0, 51, 102));
            submit.setFocusPainted(false);
            submit.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(submit);

            frame.add(panel);
            frame.setVisible(true);

            submit.addActionListener(ev -> {
                try {
                    String courseCode = courseField.getText().trim();
                    if(courseCode.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "You have not entered the course code");
                    }
                    File file = new File("Student.bin");
                    if(!file.exists()){
                        JOptionPane.showMessageDialog(frame, "Student data file not found!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                        ArrayList<Student> students = (ArrayList<Student>) in.readObject();
                        
                        
                        ArrayList<String> studentNames = new ArrayList<>();
                        ArrayList<String> studentIds = new ArrayList<>();
                        ArrayList<Double> studentMarks = new ArrayList<>();
                        
                        
                        for(Student student : students){
                            Double marks = student.getCourseMarks(courseCode);
                            if(marks != null && marks > 0){
                                studentNames.add(student.getName());
                                studentIds.add(student.getId());
                                studentMarks.add(marks);
                            }
                        }
                        
                        
                        for(int i = 0; i < studentMarks.size(); i++){
                            for(int j = i + 1; j < studentMarks.size(); j++){
                                if(studentMarks.get(i) < studentMarks.get(j)){
                                    
                                    double tempMark = studentMarks.get(i);
                                    studentMarks.set(i, studentMarks.get(j));
                                    studentMarks.set(j, tempMark);
                                    
                                    
                                    String tempName = studentNames.get(i);
                                    studentNames.set(i, studentNames.get(j));
                                    studentNames.set(j, tempName);
                                    
                                
                                    String tempId = studentIds.get(i);
                                    studentIds.set(i, studentIds.get(j));
                                    studentIds.set(j, tempId);
                                }
                            }
                        }
                        
                        StringBuilder result = new StringBuilder("Top 3 Performers for Course: " + courseCode + "\n\n");
                        
                        if(studentMarks.isEmpty()){
                            result.append("No students found with marks in this course.");
                        } else {
                            
                            int count = Math.min(3, studentMarks.size());
                            for(int i = 0; i < count; i++){
                                result.append(i + 1)
                                    .append(". ")
                                    .append(studentNames.get(i))
                                    .append(" (")
                                    .append(studentIds.get(i))
                                    .append("): ")
                                    .append(String.format("%.2f", studentMarks.get(i)))
                                    .append(" marks\n");
                            }
                        }
                        
                        JOptionPane.showMessageDialog(frame, result.toString(), "Top Performers", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error accessing student data: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
    });
        });

        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);
        group.add(b5);

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
          
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginCredentials a = new LoginCredentials("F001", "pass123");
        
        ArrayList<Attandance> attendance = new ArrayList<>(Arrays.asList(
            new Attandance("PRESENT"), new Attandance("Absent"), new Attandance("Present")
        ));
        
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", attendance));
        courses.add(new Course("Data Structures", "CSC102", "CS", 4, "second", attendance));

        Faculty s = new Faculty("Dr. John Doe", "F001", 40, "Faculty Quarters", "Computer Science", a, courses, "faculty.jpeg");
        new FacultyDashboard(s);
    }
}