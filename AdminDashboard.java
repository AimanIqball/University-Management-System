package Project;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class AdminDashboard extends JFrame implements Serializable{
    private static final long serialVersionUID = 20L;
    private Admin admin;

    public AdminDashboard(Admin admin) {
        this.admin = admin;
   
        this.setTitle("COMSATS University - Admin Portal");
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

        JLabel nameLabel = new JLabel("Name: " + admin.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 51, 102));

        JLabel idLabel = new JLabel("Admin ID: " + admin.getId());
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        idLabel.setForeground(new Color(0, 51, 102));

        JLabel deptLabel = new JLabel("Department: " + admin.getDepartment());
        deptLabel.setFont(new Font("Arial", Font.BOLD, 14));
        deptLabel.setForeground(new Color(0, 51, 102));

        leftPanel.add(nameLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(idLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(deptLabel);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        ImageIcon icon = null;
        try {
            String imageName = admin.getPhotoPath();

            icon = new ImageIcon(AdminDashboard.class.getResource(imageName));
            
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                icon = new ImageIcon(AdminDashboard.class.getResource("/Project/" + imageName));
            }
            
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                icon = new ImageIcon(AdminDashboard.class.getResource("Project/" + imageName));
            }
 
            if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Image not found in classpath: " + imageName);
                Image placeholder = createDefaultImage();
                Image scaledImg = placeholder.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            } else {
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            }
            
        } catch (Exception e) {
            System.out.println("Error loading image: " + admin.getPhotoPath() + " - " + e.getMessage());
            Image placeholder = createDefaultImage();
            Image scaledImg = placeholder.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImg);
        }

        JLabel photoLabel = new JLabel(icon);
        rightPanel.add(photoLabel);


        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);

 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        buttonPanel.setBackground(new Color(240, 248, 255));

      
        JRadioButton b1 = new JRadioButton("Add new Course");
        styleRadioButton(b1);
        
        JRadioButton b2 = new JRadioButton("Add students");
        styleRadioButton(b2);
        
        JRadioButton b3 = new JRadioButton("Add faculty");
        styleRadioButton(b3);
        
 
        JRadioButton b4 = new JRadioButton("Delete Student");
        styleRadioButton(b4);
        
        JRadioButton b5 = new JRadioButton("Delete Faculty");
        styleRadioButton(b5);

        b1.addActionListener(e -> {
            JFrame frame = new JFrame("Add New Course");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 500);
            frame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel titleLabel = new JLabel("Add New Course");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(0, 51, 102));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(titleLabel);
            mainPanel.add(Box.createVerticalStrut(20));


            String[] labels = {"Course Name:", "Course Code:", "Department:", "Credits:", "Semester:"};
            JTextField[] fields = new JTextField[5];
            
            for (int i = 0; i < labels.length; i++) {
                JLabel label = new JLabel(labels[i]);
                label.setFont(new Font("Arial", Font.BOLD, 12));
                label.setForeground(new Color(0, 51, 102));
                mainPanel.add(label);
                
                fields[i] = new JTextField();
                fields[i].setMaximumSize(new Dimension(350, 30));
                mainPanel.add(fields[i]);
                if (i < labels.length - 1) {
                    mainPanel.add(Box.createVerticalStrut(15));
                }
            }

            mainPanel.add(Box.createVerticalStrut(25));

            JButton submitButton = new JButton("Add Course");
            submitButton.setFont(new Font("Arial", Font.BOLD, 12));
            submitButton.setForeground(Color.WHITE);
            submitButton.setBackground(new Color(0, 51, 102));
            submitButton.setFocusPainted(false);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setPreferredSize(new Dimension(120, 35));
            mainPanel.add(submitButton);

            frame.add(mainPanel);
            frame.setVisible(true);

            submitButton.addActionListener(ev -> {
                try {
                    String name = fields[0].getText().trim();
                    String code = fields[1].getText().trim();
                    String department = fields[2].getText().trim();
                    int credits = Integer.parseInt(fields[3].getText().trim());
                    String semester = fields[4].getText().trim();

                    if (name.isEmpty() || code.isEmpty() || department.isEmpty() || semester.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    File file = new File("Courses.bin");
                    ArrayList<Course> courses = new ArrayList<>();
                    
                    if (file.exists()) {
                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                            courses = (ArrayList<Course>) in.readObject();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    courses.add(new Course(name, code, department, credits, semester, null));

                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                        out.writeObject(courses);
                        JOptionPane.showMessageDialog(frame, "Course added successfully!\n" +"Name: " + name + "\n" +"Code: " + code + "\n" +
                            "Department: " + department, "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for credits!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        
        b2.addActionListener(e -> {
            JFrame frame = new JFrame("Add Student");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500, 600);
            frame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

 
            JLabel titleLabel = new JLabel("Add New Student");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(0, 51, 102));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(titleLabel);
            mainPanel.add(Box.createVerticalStrut(20));

            String[] labels = {"Student Name:", "Student ID:", "Age:", "Address:", "Department:", "Password:", "Photo Path:", "Semester:"};
            
            JTextField[] fields = new JTextField[labels.length];
            
            for (int i = 0; i < labels.length; i++) {
                JLabel label = new JLabel(labels[i]);
                label.setFont(new Font("Arial", Font.BOLD, 12));
                label.setForeground(new Color(0, 51, 102));
                mainPanel.add(label);
                
                fields[i] = new JTextField();
                fields[i].setMaximumSize(new Dimension(350, 30));
                mainPanel.add(fields[i]);
                mainPanel.add(Box.createVerticalStrut(10));
            }

            mainPanel.add(Box.createVerticalStrut(20));

            JButton submitButton = new JButton("Add Student");
            submitButton.setFont(new Font("Arial", Font.BOLD, 12));
            submitButton.setForeground(Color.WHITE);
            submitButton.setBackground(new Color(0, 51, 102));
            submitButton.setFocusPainted(false);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setPreferredSize(new Dimension(120, 35));
            mainPanel.add(submitButton);

            frame.add(mainPanel);
            frame.setVisible(true);

            submitButton.addActionListener(ev -> {
                try {
                    String name = fields[0].getText().trim();
                    String id = fields[1].getText().trim();
                    int age = Integer.parseInt(fields[2].getText().trim());
                    String address = fields[3].getText().trim();
                    String department = fields[4].getText().trim();
                    String password = fields[5].getText().trim();
                    String photoPath = fields[6].getText().trim();
                    String semester = fields[7].getText().trim();

                    if (name.isEmpty() || id.isEmpty() || address.isEmpty() || 
                        department.isEmpty() || password.isEmpty() || semester.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    File file = new File("Student.bin");
                    ArrayList<Student> students = new ArrayList<>();
                    
                    if (file.exists()) {
                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                            students = (ArrayList<Student>) in.readObject();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        JOptionPane.showMessageDialog(frame, "File not exit");
                        return;
                    }

                    LoginCredentials credentials = new LoginCredentials(id, password);
                    students.add(new Student(name, id, age, address, department, 
                        credentials, null, semester, photoPath));

                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                        out.writeObject(students);
                        JOptionPane.showMessageDialog(frame, "Student added successfully!\n" +
                            "Name: " + name + "\n" +
                            "ID: " + id + "\n" +
                            "Department: " + department, "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for age!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        
        b3.addActionListener(e -> {
            JFrame frame = new JFrame("Add Faculty");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500, 550);
            frame.setLocationRelativeTo(null);


            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel titleLabel = new JLabel("Add New Faculty");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(0, 51, 102));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(titleLabel);
            mainPanel.add(Box.createVerticalStrut(20));

            String[] labels = {"Faculty Name:", "Faculty ID:", "Age:", "Address:", "Department:", "Password:", "Photo Path:"};
            
            JTextField[] fields = new JTextField[labels.length];
            
            for (int i = 0; i < labels.length; i++) {
                JLabel label = new JLabel(labels[i]);
                label.setFont(new Font("Arial", Font.BOLD, 12));
                label.setForeground(new Color(0, 51, 102));
                mainPanel.add(label);
                
                fields[i] = new JTextField();
                fields[i].setMaximumSize(new Dimension(350, 30));
                mainPanel.add(fields[i]);
                mainPanel.add(Box.createVerticalStrut(10));
            }

            mainPanel.add(Box.createVerticalStrut(20));

            JButton submitButton = new JButton("Add Faculty");
            submitButton.setFont(new Font("Arial", Font.BOLD, 12));
            submitButton.setForeground(Color.WHITE);
            submitButton.setBackground(new Color(0, 51, 102));
            submitButton.setFocusPainted(false);
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setPreferredSize(new Dimension(120, 35));
            mainPanel.add(submitButton);

            frame.add(mainPanel);
            frame.setVisible(true);

            submitButton.addActionListener(ev -> {
                try {
                    String name = fields[0].getText().trim();
                    String id = fields[1].getText().trim();
                    int age = Integer.parseInt(fields[2].getText().trim());
                    String address = fields[3].getText().trim();
                    String department = fields[4].getText().trim();
                    String password = fields[5].getText().trim();
                    String photoPath = fields[6].getText().trim();

                    if (name.isEmpty() || id.isEmpty() || address.isEmpty() || 
                        department.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all required fields!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    File file = new File("Faculty.bin");
                    ArrayList<Faculty> facultyList = new ArrayList<>();
                    
                    if (file.exists()) {
                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                            facultyList = (ArrayList<Faculty>) in.readObject();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        JOptionPane.showMessageDialog(frame, "File not exit");
                        return;
                    }

                    LoginCredentials credentials = new LoginCredentials(id, password);
                    facultyList.add(new Faculty(name, id, age, address, department, 
                        credentials, null, photoPath));

                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                        out.writeObject(facultyList);
                        JOptionPane.showMessageDialog(frame, "Faculty added successfully!\n" +"Name: " + name + "\n" +"ID: " + id + "\n" +"Department: " + department, "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for age!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
        

        b4.addActionListener(e -> {
            JFrame frame = new JFrame("Delete/Disqualify Student");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 300);
            frame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel titleLabel = new JLabel("Delete Student Record");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(204, 0, 0)); 
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(titleLabel);
            mainPanel.add(Box.createVerticalStrut(10));
            
            JLabel warningLabel = new JLabel("!!This action cannot be undone!");
            warningLabel.setFont(new Font("Arial", Font.BOLD, 12));
            warningLabel.setForeground(new Color(204, 0, 0));
            warningLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(warningLabel);
            mainPanel.add(Box.createVerticalStrut(20));

            JLabel iLabel = new JLabel("Enter Student ID to delete:");
            iLabel.setFont(new Font("Arial", Font.BOLD, 12));
            iLabel.setForeground(new Color(0, 51, 102));
            mainPanel.add(iLabel);
            
            JTextField idField = new JTextField();
            idField.setMaximumSize(new Dimension(300, 30));
            mainPanel.add(idField);
            mainPanel.add(Box.createVerticalStrut(25));

            JButton deleteButton = new JButton("Delete Student");
            deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setBackground(new Color(204, 0, 0)); 
            deleteButton.setFocusPainted(false);
            deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            deleteButton.setPreferredSize(new Dimension(140, 35));
            mainPanel.add(deleteButton);

            frame.add(mainPanel);
            frame.setVisible(true);

            deleteButton.addActionListener(ev -> {
                String studentId = idField.getText().trim();
                
                if (studentId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a Student ID!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to delete student with ID: " + studentId + "?\nThis action cannot be undone!",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        File file = new File("Student.bin");
                        if (!file.exists()) {
                            JOptionPane.showMessageDialog(frame, "Student data file not found!", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        ArrayList<Student> students = new ArrayList<>();
                        boolean found = false;
                        String deletedStudentName = "";
                        

                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                            students = (ArrayList<Student>) in.readObject();
                            
                           
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                                    deletedStudentName = students.get(i).getName();
                                    students.remove(i);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        
                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Student not found with ID: " + studentId,
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    
                        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                            out.writeObject(students);
                            JOptionPane.showMessageDialog(frame, "Student deleted successfully!\n" +"Name: " + deletedStudentName + "\n" +"ID: " + studentId + "\n" +"Total students remaining: " + students.size(),"Success", JOptionPane.INFORMATION_MESSAGE);
                            frame.dispose();
                        }
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        });
        

        b5.addActionListener(e -> {
            JFrame frame = new JFrame("Delete/Disqualify Faculty");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(450, 300);
            frame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.WHITE);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));


            JLabel titleLabel = new JLabel("Delete Faculty Record");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setForeground(new Color(204, 0, 0)); 
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(titleLabel);
            mainPanel.add(Box.createVerticalStrut(10));
            
            JLabel warningLabel = new JLabel("!!This action cannot be undone!");
            warningLabel.setFont(new Font("Arial", Font.BOLD, 12));
            warningLabel.setForeground(new Color(204, 0, 0));
            warningLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(warningLabel);
            mainPanel.add(Box.createVerticalStrut(20));

            JLabel iddLabel = new JLabel("Enter Faculty ID to delete:");
            iddLabel.setFont(new Font("Arial", Font.BOLD, 12));
            iddLabel.setForeground(new Color(0, 51, 102));
            mainPanel.add(iddLabel);
            
            JTextField idField = new JTextField();
            idField.setMaximumSize(new Dimension(300, 30));
            mainPanel.add(idField);
            mainPanel.add(Box.createVerticalStrut(25));


            JButton deleteButton = new JButton("Delete Faculty");
            deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setBackground(new Color(204, 0, 0));
            deleteButton.setFocusPainted(false);
            deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            deleteButton.setPreferredSize(new Dimension(140, 35));
            mainPanel.add(deleteButton);

            frame.add(mainPanel);
            frame.setVisible(true);

            deleteButton.addActionListener(ev -> {
                String facultyId = idField.getText().trim();
                
                if (facultyId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a Faculty ID!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to delete faculty with ID: " + facultyId + "?\nThis action cannot be undone!",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        File file = new File("Faculty.bin");
                        if (!file.exists()) {
                            JOptionPane.showMessageDialog(frame, "Faculty data file not found!", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        ArrayList<Faculty> facultyList = new ArrayList<>();
                        boolean found = false;
                        String deletedFacultyName = "";
                        

                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                            facultyList = (ArrayList<Faculty>) in.readObject();
     
                            for (int i = 0; i < facultyList.size(); i++) {
                                if (facultyList.get(i).getId().equalsIgnoreCase(facultyId)) {
                                    deletedFacultyName = facultyList.get(i).getName();
                                    facultyList.remove(i);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        
                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "Faculty not found with ID: " + facultyId,
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        

                        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                            out.writeObject(facultyList);
                            JOptionPane.showMessageDialog(frame, "Faculty deleted successfully!\n" + "Name: " + deletedFacultyName + "\n" +"ID: " + facultyId + "\n" +"Total faculty remaining: " + facultyList.size(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            frame.dispose();
                        }
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
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

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void styleRadioButton(JRadioButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(new Color(0, 51, 102));
        button.setBackground(new Color(240, 248, 255));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
    }

   
    private Image createDefaultImage() {
       
        Image img = new ImageIcon(new byte[0]).getImage(); 
        try {
            
            java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage( 150, 150, java.awt.image.BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            
           
            g2d.setColor(new Color(220, 220, 220)); 
            g2d.fillRect(0, 0, 150, 150);
            
           
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(0, 0, 149, 149);
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            String text = "No Image";
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int x = (150 - textWidth) / 2;
            int y = 75;
            g2d.drawString(text, x, y);
            
            g2d.dispose();
            return bufferedImage;
        } catch (Exception e) {
            return img;
        }
    }
    public static void main(String[] args) {
         Admin admin1 = new Admin("Dr. Farah Khan", "F021", 46, "Lahore", "Computer Science",
                        new LoginCredentials("F021", "pass123"), "IMG-20251207-WA0031.jpg");

                        new AdminDashboard(admin1);
    }
}