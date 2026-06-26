package Project;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class Login extends JFrame implements Serializable {
    private final static Long serialVersionUID = 4l;

    public Login() {
       
        ImageIcon icon = new ImageIcon(Login.class.getResource("Comsats.jpg"));
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(400, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        JLabel l1 = new JLabel(icon);
        l1.setHorizontalAlignment(SwingConstants.CENTER);


        this.setTitle("LOGIN");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.getContentPane().setBackground(new Color(174, 198, 207));
        this.setLayout(new BorderLayout(10, 10));

   
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        centerPanel.setOpaque(false);

        String[] options = {"Student", "Faculty", "Admin"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSelectedIndex(0);

        JTextField usernameField = new JTextField(10);
        usernameField.setBorder(BorderFactory.createEtchedBorder());

        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBorder(BorderFactory.createEtchedBorder());

        centerPanel.add(usernameField);
        centerPanel.add(comboBox);
        centerPanel.add(passwordField);

     
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setOpaque(false);

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        loginButton.setBackground(new Color(255, 182, 193));

        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        exitButton.setBackground(new Color(255, 182, 193));
        exitButton.addActionListener(e -> System.exit(0));


        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            int selectedIndex = comboBox.getSelectedIndex();

            switch (selectedIndex) {
                case 0 -> { 
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.bin"))) {
                        ArrayList<Student> students = (ArrayList<Student>) in.readObject();
                        boolean found = false;
                        for (Student s : students) {
                            if (s.getLogin() != null && s.getId().equalsIgnoreCase(username)
                                    && password.equals(s.getLogin().getPassword())) {
                                new StudentDashboard(s);
                                found = true;
                                break;
                            }
                        }
                        if (found) dispose();
                        else JOptionPane.showMessageDialog(this, "Invalid Student credentials");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error reading Student data");
                    }
                }
                case 1 -> { 
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Faculty.bin"))) {
                        ArrayList<Faculty> faculties = (ArrayList<Faculty>) in.readObject();
                        boolean found = false;
                        for (Faculty f : faculties) {
                            if (f.getLogin() != null && f.getId().equalsIgnoreCase(username)&& password.equals(f.getLogin().getPassword())) {
                                new FacultyDashboard(f);
                                found = true;
                                break;
                            }
                        }
                        if (found) dispose();
                        else JOptionPane.showMessageDialog(this, "Invalid Faculty credentials");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error reading Faculty data");
                    }
                }
                case 2 -> { 
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Admin.bin"))) {
                        ArrayList<Admin> admins = (ArrayList<Admin>) in.readObject();
                        boolean found = false;
                        for (Admin a : admins) {
                            if (a.getLogin() != null && a.getId().equalsIgnoreCase(username)
                                    && password.equals(a.getLogin().getPassword())) {
                                new AdminDashboard(a);
                                found = true;
                                break;
                            }
                        }
                        if (found) dispose();
                        else JOptionPane.showMessageDialog(this, "Invalid Admin credentials");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error reading Admin data");
                    }
                }
            }
        });

        bottomPanel.add(loginButton);
        bottomPanel.add(exitButton);

        this.add(l1, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UniversityManager();
        new Login();
    }
}