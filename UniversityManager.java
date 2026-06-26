package Project;
import java.io.*;
import java.util.ArrayList;

public class UniversityManager implements Serializable {
    private final static Long serialVersionUID = 12l;

    private static final String StudentFileName = "Student.bin";
    private static final String AdminFileName = "Admin.bin";
    private static final String FacultyFileName = "Faculty.bin";
    private static final String CourseFileName = "Courses.bin";

    File adminFile = new File(AdminFileName);
    File StudentFile = new File(StudentFileName);
    File FacultyFile = new File(FacultyFileName);
    File CourseFile = new File(CourseFileName);

    public UniversityManager() {
        if (!(adminFile.exists())) {
            try {
                adminFile.createNewFile();
                ArrayList<Admin> adminArr = new ArrayList<>();

                Admin admin1 = new Admin("Dr. Farah Khan", "F021", 46, "Lahore", "Computer Science",
                        new LoginCredentials("F021", "pass123"), "IMG-20251207-WA0031.jpg");

                // 10 more admins
                Admin admin2 = new Admin("Prof. Ahmed Raza", "A101", 52, "Karachi", "Mathematics",
                        new LoginCredentials("A101", "ahmed2025"), "admin2.jpg");

                Admin admin3 = new Admin("Ms. Sana Iqbal", "S876", 39, "Islamabad", "Physics",
                        new LoginCredentials("S876", "sana876"), "admin3.jpg");

                Admin admin4 = new Admin("Dr. Bilal Haider", "B332", 48, "Rawalpindi", "Chemistry",
                        new LoginCredentials("B332", "bilal332"), "admin4.jpg");

                Admin admin5 = new Admin("Mrs. Ayesha Malik", "A554", 44, "Multan", "Biology",
                        new LoginCredentials("A554", "ayesha554"), "admin5.jpg");

                Admin admin6 = new Admin("Mr. Kashif Mehmood", "K221", 41, "Faisalabad", "IT",
                        new LoginCredentials("K221", "kashif221"), "admin6.jpg");

                Admin admin7 = new Admin("Dr. Zainab Ali", "Z190", 50, "Quetta", "English",
                        new LoginCredentials("Z190", "zainab190"), "admin7.jpg");

                Admin admin8 = new Admin("Prof. Hamza Javed", "H765", 55, "Peshawar", "Statistics",
                        new LoginCredentials("H765", "hamza765"), "admin8.jpg");

                Admin admin9 = new Admin("Ms. Rabia Noor", "R459", 36, "Hyderabad", "Psychology",
                        new LoginCredentials("R459", "rabia459"), "admin9.jpg");

                Admin admin10 = new Admin("Dr. Imran Siddiqui", "I909", 49, "Sialkot", "Management",
                        new LoginCredentials("I909", "imran909"), "admin10.jpg");

                Admin admin11 = new Admin("Mr. Salman Tariq", "S552", 42, "Gujranwala", "Economics",
                        new LoginCredentials("S552", "salman552"), "admin11.jpg");

                // Adding all to ArrayList
                adminArr.add(admin1);
                adminArr.add(admin2);
                adminArr.add(admin3);
                adminArr.add(admin4);
                adminArr.add(admin5);
                adminArr.add(admin6);
                adminArr.add(admin7);
                adminArr.add(admin8);
                adminArr.add(admin9);
                adminArr.add(admin10);
                adminArr.add(admin11);



                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(adminFile))) {
                        out.writeObject(adminArr);
                }
            } catch (Exception e) {
            }
        }

        if (!(StudentFile.exists())) {
            try {
                StudentFile.createNewFile();

                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(StudentFile))) {
                    ArrayList<Student> students = new ArrayList<>();

                    // ---------- STUDENT 1 ----------
                    ArrayList<Attandance> aOOP = createAttendance(6);
                    ArrayList<Attandance> aEnglish = createAttendance(5);
                    ArrayList<Attandance> aPF = createAttendance(4);
                    ArrayList<Attandance> aICT = createAttendance(3);
                    ArrayList<Attandance> aCivics = createAttendance(7);
                    ArrayList<Attandance> aTechWriting = createAttendance(6);
                    ArrayList<Attandance> aDSA = createAttendance(5);
                    ArrayList<Attandance> aCalculus = createAttendance(4);

                    Course courseOOP = new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", aOOP);
                    Course courseEnglish = new Course("English", "ENG101", "Arts", 3, "second", aEnglish);
                    Course coursePF = new Course("Physical Fitness", "PF101", "Sports", 2, "second", aPF);
                    Course courseICT = new Course("ICT", "ICT101", "CS", 3, "second", aICT);
                    Course courseCivics = new Course("Civics", "CIV101", "Arts", 2, "second", aCivics);
                    Course courseTechWriting = new Course("Technical Writing", "TW101", "CS", 3, "second", aTechWriting);
                    Course courseDSA = new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", aDSA);
                    Course courseCalculus = new Course("Calculus", "CAL101", "Math", 4, "second", aCalculus);

                    ArrayList<StudentCourse> studentCourses1 = new ArrayList<>();
                    studentCourses1.add(new StudentCourse(courseOOP, new StudentMarks<Double>(12.0, 10.0, 20.0, 0.0)));
                    studentCourses1.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 18.0, 1.0)));
                    studentCourses1.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 20.0, 0.0)));
                    studentCourses1.add(new StudentCourse(courseICT, new StudentMarks<Double>(14.0, 12.0, 17.0, 1.0)));
                    studentCourses1.add(new StudentCourse(courseCivics, new StudentMarks<Double>(13.0, 11.0, 15.0, 2.0)));
                    studentCourses1.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 18.0, 1.0)));
                    studentCourses1.add(new StudentCourse(courseDSA, new StudentMarks<Double>(17.0, 15.0, 20.0, 0.0)));
                    studentCourses1.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(18.0, 16.0, 22.0, 1.0)));

                    students.add(new Student("Ayesha", "SP25-BSE-001", 20, "Lahore", "Computer Science", 
                            new LoginCredentials("SP25-BSE-001", "user123"), studentCourses1, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 2 ----------
                    ArrayList<StudentCourse> studentCourses2 = new ArrayList<>();
                    studentCourses2.add(new StudentCourse(courseOOP, new StudentMarks<Double>(14.0, 12.0, 18.0, 1.0)));
                    studentCourses2.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(13.0, 11.0, 17.0, 2.0)));
                    studentCourses2.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 14.0, 19.0, 1.0)));
                    studentCourses2.add(new StudentCourse(courseICT, new StudentMarks<Double>(15.0, 13.0, 18.0, 0.0)));
                    studentCourses2.add(new StudentCourse(courseCivics, new StudentMarks<Double>(12.0, 10.0, 15.0, 3.0)));
                    studentCourses2.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 18.0, 1.0)));
                    studentCourses2.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 15.0, 21.0, 0.0)));
                    studentCourses2.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(17.0, 14.0, 20.0, 2.0)));

                    students.add(new Student("Fatima", "SP25-BSE-002", 21, "Karachi", "Computer Science",
                            new LoginCredentials("SP25-BSE-002", "user123"), studentCourses2, "second", "IMG-20251207-WA0046.jpg"));

                    // ---------- STUDENT 3 ----------
                    ArrayList<StudentCourse> studentCourses3 = new ArrayList<>();
                    studentCourses3.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses3.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses3.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 20.0, 1.0)));
                    studentCourses3.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 14.0, 22.0, 1.0)));
                    studentCourses3.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 19.0, 2.0)));
                    studentCourses3.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses3.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 15.0, 23.0, 0.0)));
                    studentCourses3.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 16.0, 24.0, 1.0)));

                    students.add(new Student("Zainab", "SP25-BSE-003", 19, "Islamabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-003", "user123"), studentCourses3, "second", "IMG-20251207-WA0047.jpg"));

                    // ---------- STUDENT 4 ----------
                    ArrayList<StudentCourse> studentCourses4 = new ArrayList<>();
                    studentCourses4.add(new StudentCourse(courseOOP, new StudentMarks<Double>(13.0, 11.0, 18.0, 1.0)));
                    studentCourses4.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 12.0, 19.0, 1.0)));
                    studentCourses4.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 20.0, 1.0)));
                    studentCourses4.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 22.0, 0.0)));
                    studentCourses4.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 18.0, 2.0)));
                    studentCourses4.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses4.add(new StudentCourse(courseDSA, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses4.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));

                    students.add(new Student("Hania", "SP25-BSE-004", 22, "Rawalpindi", "Computer Science",
                            new LoginCredentials("SP25-BSE-004", "user123"), studentCourses4, "second", "IMG-20251207-WA0048.jpg"));

                    // ---------- STUDENT 5 ----------
                    ArrayList<StudentCourse> studentCourses5 = new ArrayList<>();
                    studentCourses5.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 13.0, 21.0, 0.0)));
                    studentCourses5.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 14.0, 20.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 12.0, 18.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(14.0, 13.0, 20.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseDSA, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses5.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));

                    students.add(new Student("Laiba", "SP25-BSE-005", 20, "Multan", "Computer Science",
                            new LoginCredentials("SP25-BSE-005", "user123"), studentCourses5, "second", "IMG-20251207-WA0049.jpg"));

                    // ---------- STUDENT 6 ----------
                    ArrayList<StudentCourse> studentCourses6 = new ArrayList<>();
                    studentCourses6.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses6.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses6.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 22.0, 0.0)));
                    studentCourses6.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses6.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 13.0, 19.0, 1.0)));
                    studentCourses6.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 14.0, 21.0, 0.0)));
                    studentCourses6.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses6.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Iqra", "SP25-BSE-006", 18, "Faisalabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-006", "user123"), studentCourses6, "second", "IMG-20251207-WA0055.jpg"));

                    // ---------- STUDENT 7 ----------
                    ArrayList<StudentCourse> studentCourses7 = new ArrayList<>();
                    studentCourses7.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 14.0, 22.0, 1.0)));
                    studentCourses7.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 13.0, 21.0, 0.0)));
                    studentCourses7.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 1.0)));
                    studentCourses7.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses7.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses7.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses7.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 23.0, 1.0)));
                    studentCourses7.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 24.0, 0.0)));

                    students.add(new Student("Maham", "SP25-BSE-007", 22, "Sialkot", "Computer Science",
                            new LoginCredentials("SP25-BSE-007", "user123"), studentCourses7, "second", "IMG-20251207-WA0056.jpg"));

                    // ---------- STUDENT 8 ----------
                    ArrayList<StudentCourse> studentCourses8 = new ArrayList<>();
                    studentCourses8.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses8.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses8.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses8.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses8.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses8.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 22.0, 0.0)));
                    studentCourses8.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses8.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));

                    students.add(new Student("Sadia", "SP25-BSE-008", 19, "Hyderabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-008", "user123"), studentCourses8, "second", "IMG-20251207-WA0057.jpg"));

                    // ---------- STUDENT 9 ----------
                    ArrayList<StudentCourse> studentCourses9 = new ArrayList<>();
                    studentCourses9.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses9.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses9.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses9.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses9.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses9.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses9.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses9.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));

                    students.add(new Student("Aiman", "SP25-BSE-009", 21, "Islamabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-009", "user123"), studentCourses9, "second", "IMG-20251207-WA0059.jpg"));

                    // ---------- STUDENT 10 ----------
                    ArrayList<StudentCourse> studentCourses10 = new ArrayList<>();
                    studentCourses10.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses10.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses10.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 22.0, 0.0)));
                    studentCourses10.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses10.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses10.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 22.0, 1.0)));
                    studentCourses10.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses10.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));

                    students.add(new Student("Maryam", "SP25-BSE-010", 20, "Peshawar", "Computer Science",
                            new LoginCredentials("SP25-BSE-010", "user123"), studentCourses10, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 11 ----------
                    ArrayList<StudentCourse> studentCourses11 = new ArrayList<>();
                    studentCourses11.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses11.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(14.0, 11.0, 19.0, 2.0)));
                    studentCourses11.add(new StudentCourse(coursePF, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses11.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses11.add(new StudentCourse(courseCivics, new StudentMarks<Double>(13.0, 11.0, 18.0, 2.0)));
                    studentCourses11.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses11.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 15.0, 23.0, 1.0)));
                    studentCourses11.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 16.0, 24.0, 1.0)));

                    students.add(new Student("Hira", "SP25-BSE-011", 20, "Lahore", "Computer Science",
                            new LoginCredentials("SP25-BSE-011", "user123"), studentCourses11, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 12 ----------
                    ArrayList<StudentCourse> studentCourses12 = new ArrayList<>();
                    studentCourses12.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 13.0, 21.0, 0.0)));
                    studentCourses12.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses12.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 14.0, 22.0, 1.0)));
                    studentCourses12.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses12.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 19.0, 2.0)));
                    studentCourses12.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses12.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses12.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Sara", "SP25-BSE-012", 21, "Karachi", "Computer Science",
                            new LoginCredentials("SP25-BSE-012", "user123"), studentCourses12, "second", "IMG-20251207-WA0061.jpg"));

                    // ---------- STUDENT 13 ----------
                    ArrayList<StudentCourse> studentCourses13 = new ArrayList<>();
                    studentCourses13.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses13.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(14.0, 12.0, 19.0, 1.0)));
                    studentCourses13.add(new StudentCourse(coursePF, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses13.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses13.add(new StudentCourse(courseCivics, new StudentMarks<Double>(13.0, 11.0, 18.0, 2.0)));
                    studentCourses13.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 14.0, 21.0, 1.0)));
                    studentCourses13.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses13.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 24.0, 1.0)));

                    students.add(new Student("Zoya", "SP25-BSE-013", 20, "Islamabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-013", "user123"), studentCourses13, "second", "IMG-20251207-WA0061.jpg"));

                    // ---------- STUDENT 14 ----------
                    ArrayList<StudentCourse> studentCourses14 = new ArrayList<>();
                    studentCourses14.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 13.0, 21.0, 1.0)));
                    studentCourses14.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 12.0, 20.0, 1.0)));
                    studentCourses14.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 14.0, 22.0, 0.0)));
                    studentCourses14.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses14.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 19.0, 2.0)));
                    studentCourses14.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses14.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses14.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 24.0, 1.0)));

                    students.add(new Student("Anaya", "SP25-BSE-014", 21, "Faisalabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-014", "user123"), studentCourses14, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 15 ----------
                    ArrayList<StudentCourse> studentCourses15 = new ArrayList<>();
                    studentCourses15.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 14.0, 22.0, 0.0)));
                    studentCourses15.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 13.0, 21.0, 1.0)));
                    studentCourses15.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 15.0, 23.0, 1.0)));
                    studentCourses15.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 14.0, 22.0, 0.0)));
                    studentCourses15.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 12.0, 20.0, 2.0)));
                    studentCourses15.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses15.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 24.0, 0.0)));
                    studentCourses15.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 25.0, 1.0)));

                    students.add(new Student("Noor", "SP25-BSE-015", 20, "Karachi", "Computer Science",
                            new LoginCredentials("SP25-BSE-015", "user123"), studentCourses15, "second", "IMG-20251207-WA0057.jpg"));

                    // ---------- STUDENT 16 ----------
                    ArrayList<StudentCourse> studentCourses16 = new ArrayList<>();
                    studentCourses16.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 12.0, 21.0, 1.0)));
                    studentCourses16.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(14.0, 11.0, 20.0, 1.0)));
                    studentCourses16.add(new StudentCourse(coursePF, new StudentMarks<Double>(16.0, 13.0, 22.0, 0.0)));
                    studentCourses16.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses16.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 12.0, 21.0, 2.0)));
                    studentCourses16.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses16.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses16.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Areeba", "SP25-BSE-016", 21, "Islamabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-016", "user123"), studentCourses16, "second", "IMG-20251207-WA0057.jpg"));

                    // ---------- STUDENT 17 ----------
                    ArrayList<StudentCourse> studentCourses17 = new ArrayList<>();
                    studentCourses17.add(new StudentCourse(courseOOP, new StudentMarks<Double>(18.0, 15.0, 23.0, 1.0)));
                    studentCourses17.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses17.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses17.add(new StudentCourse(courseICT, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses17.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 12.0, 21.0, 2.0)));
                    studentCourses17.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses17.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses17.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Sadia", "SP25-BSE-017", 20, "Sialkot", "Computer Science",
                            new LoginCredentials("SP25-BSE-017", "user123"), studentCourses17, "second", "IMG-20251207-WA0057.jpg"));

                    // ---------- STUDENT 18 ----------
                    ArrayList<StudentCourse> studentCourses18 = new ArrayList<>();
                    studentCourses18.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses18.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses18.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses18.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses18.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 21.0, 2.0)));
                    studentCourses18.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses18.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses18.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Maham", "SP25-BSE-018", 21, "Lahore", "Computer Science",
                            new LoginCredentials("SP25-BSE-018", "user123"), studentCourses18, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 19 ----------
                    ArrayList<StudentCourse> studentCourses19 = new ArrayList<>();
                    studentCourses19.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 14.0, 22.0, 0.0)));
                    studentCourses19.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 13.0, 21.0, 1.0)));
                    studentCourses19.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses19.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses19.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 13.0, 21.0, 2.0)));
                    studentCourses19.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses19.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 24.0, 0.0)));
                    studentCourses19.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 25.0, 1.0)));

                    students.add(new Student("Iqra", "SP25-BSE-019", 20, "Karachi", "Computer Science",
                            new LoginCredentials("SP25-BSE-019", "user123"), studentCourses19, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 20 ----------
                    ArrayList<StudentCourse> studentCourses20 = new ArrayList<>();
                    studentCourses20.add(new StudentCourse(courseOOP, new StudentMarks<Double>(18.0, 15.0, 23.0, 1.0)));
                    studentCourses20.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses20.add(new StudentCourse(coursePF, new StudentMarks<Double>(19.0, 16.0, 24.0, 0.0)));
                    studentCourses20.add(new StudentCourse(courseICT, new StudentMarks<Double>(18.0, 16.0, 23.0, 1.0)));
                    studentCourses20.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses20.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses20.add(new StudentCourse(courseDSA, new StudentMarks<Double>(20.0, 18.0, 25.0, 0.0)));
                    studentCourses20.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(21.0, 19.0, 26.0, 1.0)));

                    students.add(new Student("Zoya", "SP25-BSE-020", 21, "Rawalpindi", "Computer Science",
                            new LoginCredentials("SP25-BSE-020", "user123"), studentCourses20, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 21 ----------
                    ArrayList<StudentCourse> studentCourses21 = new ArrayList<>();
                    studentCourses21.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 22.0, 0.0)));
                    studentCourses21.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses21.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses21.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses21.add(new StudentCourse(courseCivics, new StudentMarks<Double>(14.0, 12.0, 21.0, 2.0)));
                    studentCourses21.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(15.0, 13.0, 22.0, 1.0)));
                    studentCourses21.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses21.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Hira", "SP25-BSE-021", 20, "Multan", "Computer Science",
                            new LoginCredentials("SP25-BSE-021", "user123"), studentCourses21, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 22 ----------
                    ArrayList<StudentCourse> studentCourses22 = new ArrayList<>();
                    studentCourses22.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses22.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 22.0, 0.0)));
                    studentCourses22.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses22.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses22.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses22.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses22.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses22.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Sadia", "SP25-BSE-022", 21, "Islamabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-022", "user123"), studentCourses22, "second", "IMG-20251207-WA0060.jpg"));

                    // ---------- STUDENT 23 ----------
                    ArrayList<StudentCourse> studentCourses23 = new ArrayList<>();
                    studentCourses23.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses23.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses23.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses23.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses23.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 13.0, 22.0, 2.0)));
                    studentCourses23.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 23.0, 1.0)));
                    studentCourses23.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses23.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Alina", "SP25-BSE-023", 20, "Faisalabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-023", "user123"), studentCourses23, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 24 ----------
                    ArrayList<StudentCourse> studentCourses24 = new ArrayList<>();
                    studentCourses24.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 14.0, 22.0, 1.0)));
                    studentCourses24.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses24.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses24.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses24.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses24.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses24.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses24.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Anum", "SP25-BSE-024", 21, "Rawalpindi", "Computer Science",
                            new LoginCredentials("SP25-BSE-024", "user123"), studentCourses24, "second", "IMG-20251207-WA0044.jpg"));

                    // ---------- STUDENT 25 ----------
                    ArrayList<StudentCourse> studentCourses25 = new ArrayList<>();
                    studentCourses25.add(new StudentCourse(courseOOP, new StudentMarks<Double>(18.0, 15.0, 23.0, 1.0)));
                    studentCourses25.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(17.0, 15.0, 22.0, 0.0)));
                    studentCourses25.add(new StudentCourse(coursePF, new StudentMarks<Double>(19.0, 17.0, 24.0, 0.0)));
                    studentCourses25.add(new StudentCourse(courseICT, new StudentMarks<Double>(18.0, 16.0, 23.0, 1.0)));
                    studentCourses25.add(new StudentCourse(courseCivics, new StudentMarks<Double>(17.0, 15.0, 22.0, 2.0)));
                    studentCourses25.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(18.0, 16.0, 23.0, 1.0)));
                    studentCourses25.add(new StudentCourse(courseDSA, new StudentMarks<Double>(20.0, 18.0, 25.0, 0.0)));
                    studentCourses25.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(21.0, 19.0, 26.0, 1.0)));

                    students.add(new Student("Fatima", "SP25-BSE-025", 20, "Multan", "Computer Science",
                            new LoginCredentials("SP25-BSE-025", "user123"), studentCourses25, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 26 ----------
                    ArrayList<StudentCourse> studentCourses26 = new ArrayList<>();
                    studentCourses26.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses26.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 0.0)));
                    studentCourses26.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses26.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses26.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses26.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses26.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses26.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Zunaira", "SP25-BSE-026", 19, "Faisalabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-026", "user123"), studentCourses26, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 27 ----------
                    ArrayList<StudentCourse> studentCourses27 = new ArrayList<>();
                    studentCourses27.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses27.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses27.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses27.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses27.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses27.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses27.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses27.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Hiba", "SP25-BSE-027", 21, "Hyderabad", "Computer Science",
                            new LoginCredentials("SP25-BSE-027", "user123"), studentCourses27, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 28 ----------
                    ArrayList<StudentCourse> studentCourses28 = new ArrayList<>();
                    studentCourses28.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses28.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(14.0, 12.0, 20.0, 1.0)));
                    studentCourses28.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 23.0, 0.0)));
                    studentCourses28.add(new StudentCourse(courseICT, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses28.add(new StudentCourse(courseCivics, new StudentMarks<Double>(15.0, 13.0, 21.0, 2.0)));
                    studentCourses28.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses28.add(new StudentCourse(courseDSA, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses28.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(19.0, 17.0, 25.0, 1.0)));

                    students.add(new Student("Aneeqa", "SP25-BSE-028", 20, "Sialkot", "Computer Science",
                            new LoginCredentials("SP25-BSE-028", "user123"), studentCourses28, "second", "IMG-20251207-WA0045.jpg"));

                    // ---------- STUDENT 29 ----------
                    ArrayList<StudentCourse> studentCourses29 = new ArrayList<>();
                    studentCourses29.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 22.0, 1.0)));
                    studentCourses29.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 21.0, 1.0)));
                    studentCourses29.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 23.0, 0.0)));
                    studentCourses29.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses29.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 21.0, 2.0)));
                    studentCourses29.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses29.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses29.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Shanza", "SP25-BSE-029", 21, "Quetta", "Computer Science",
                            new LoginCredentials("SP25-BSE-029", "user123"), studentCourses29, "second", "IMG-20251207-WA0044.jpg"));

                    // ---------- STUDENT 30 ----------
                    ArrayList<StudentCourse> studentCourses30 = new ArrayList<>();
                    studentCourses30.add(new StudentCourse(courseOOP, new StudentMarks<Double>(17.0, 15.0, 22.0, 1.0)));
                    studentCourses30.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses30.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses30.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses30.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses30.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses30.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses30.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Javeria", "SP25-BSE-030", 21, "Gujrat", "Computer Science",
                            new LoginCredentials("SP25-BSE-030", "user123"), studentCourses30, "second", "IMG-20251207-WA0061.jpg"));

                    // ---------- STUDENT 31 ----------
                    ArrayList<StudentCourse> studentCourses31 = new ArrayList<>();
                    studentCourses31.add(new StudentCourse(courseOOP, new StudentMarks<Double>(16.0, 14.0, 21.0, 1.0)));
                    studentCourses31.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(15.0, 13.0, 20.0, 1.0)));
                    studentCourses31.add(new StudentCourse(coursePF, new StudentMarks<Double>(18.0, 16.0, 24.0, 0.0)));
                    studentCourses31.add(new StudentCourse(courseICT, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses31.add(new StudentCourse(courseCivics, new StudentMarks<Double>(16.0, 14.0, 22.0, 2.0)));
                    studentCourses31.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(17.0, 15.0, 23.0, 1.0)));
                    studentCourses31.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 25.0, 0.0)));
                    studentCourses31.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 26.0, 1.0)));

                    students.add(new Student("Fiza", "SP25-BSE-031", 20, "Bahawalpur", "Computer Science",
                            new LoginCredentials("SP25-BSE-031", "user123"), studentCourses31, "second", "IMG-20251207-WA0044.jpg"));

                    // ---------- STUDENT 32 ----------
                    ArrayList<StudentCourse> studentCourses32 = new ArrayList<>();
                    studentCourses32.add(new StudentCourse(courseOOP, new StudentMarks<Double>(15.0, 13.0, 22.0, 1.0)));
                    studentCourses32.add(new StudentCourse(courseEnglish, new StudentMarks<Double>(16.0, 14.0, 23.0, 1.0)));
                    studentCourses32.add(new StudentCourse(coursePF, new StudentMarks<Double>(17.0, 15.0, 24.0, 0.0)));
                    studentCourses32.add(new StudentCourse(courseICT, new StudentMarks<Double>(18.0, 16.0, 25.0, 1.0)));
                    studentCourses32.add(new StudentCourse(courseCivics, new StudentMarks<Double>(17.0, 15.0, 23.0, 2.0)));
                    studentCourses32.add(new StudentCourse(courseTechWriting, new StudentMarks<Double>(18.0, 16.0, 24.0, 1.0)));
                    studentCourses32.add(new StudentCourse(courseDSA, new StudentMarks<Double>(19.0, 17.0, 26.0, 0.0)));
                    studentCourses32.add(new StudentCourse(courseCalculus, new StudentMarks<Double>(20.0, 18.0, 27.0, 1.0)));

                    students.add(new Student("Sahar", "SP25-BSE-032", 21, "Lahore", "Computer Science",
                            new LoginCredentials("SP25-BSE-032", "user123"), studentCourses32, "second", "IMG-20251207-WA0061.jpg"));

                    out.writeObject(students);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!(FacultyFile.exists())) {
            try {
                FacultyFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Exception in creating faculty file");
            }

            ArrayList<Faculty> faculties = new ArrayList<>();


            ArrayList<Attandance> facAttendance = new ArrayList<>();
            for (int i = 0; i < 35; i++) facAttendance.add(new Attandance("present"));

            // ---------- FACULTY 1 ----------
            ArrayList<Course> fCourses1 = new ArrayList<>();
            fCourses1.add(new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", facAttendance));
            fCourses1.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", facAttendance));
            faculties.add(new Faculty("Mr. Saif Ullah Ijaz", "F001", 35, "Islamabad", "Computer Science",
                    new LoginCredentials("F001", "pass123"), fCourses1, "WhatsApp Image 2025-12-10 at 12.29.45_735ceb13.jpg"));

            // ---------- FACULTY 2 ----------
            ArrayList<Course> fCourses2 = new ArrayList<>();
            fCourses2.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses2.add(new Course("Linear Algebra", "MATH102", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Farhan Ali", "F002", 50, "Karachi", "Mathematics",
                    new LoginCredentials("F002", "pass123"), fCourses2, "IMG-20251207-WA0024.jpg"));

            // ---------- FACULTY 3 ----------
            ArrayList<Course> fCourses3 = new ArrayList<>();
            fCourses3.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses3.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Sana Iqbal", "F003", 38, "Islamabad", "English",
                    new LoginCredentials("F003", "pass123"), fCourses3, "IMG-20251207-WA0041.jpg"));

            // ---------- FACULTY 4 ----------
            ArrayList<Course> fCourses4 = new ArrayList<>();
            fCourses4.add(new Course("Civics", "CIV101", "Arts", 2, "second", facAttendance));
            fCourses4.add(new Course("History", "HIS101", "Arts", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Imran Sheikh", "F004", 42, "Rawalpindi", "Social Studies",
                    new LoginCredentials("F004", "pass123"), fCourses4, "IMG-20251207-WA0030.jpg"));

            // ---------- FACULTY 5 ----------
            ArrayList<Course> fCourses5 = new ArrayList<>();
            fCourses5.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            fCourses5.add(new Course("Networking", "NET101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Hira Raza", "F005", 35, "Multan", "Computer Science",
                    new LoginCredentials("F005", "pass123"), fCourses5, "IMG-20251207-WA0037.jpg"));

            // ---------- FACULTY 6 ----------
            ArrayList<Course> fCourses6 = new ArrayList<>();
            fCourses6.add(new Course("Physical Fitness", "PF101", "Sports", 2, "second", facAttendance));
            fCourses6.add(new Course("Health Education", "HE101", "Sports", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Bilal Ahmad", "F006", 48, "Faisalabad", "Physical Education",
                    new LoginCredentials("F006", "pass123"), fCourses6, "IMG-20251207-WA0038.jpg"));

            // ---------- FACULTY 7 ----------
            ArrayList<Course> fCourses7 = new ArrayList<>();
            fCourses7.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", facAttendance));
            fCourses7.add(new Course("Software Engineering", "SE101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Nida Aslam", "F007", 40, "Sialkot", "Computer Science",
                    new LoginCredentials("F007", "pass123"), fCourses7, "IMG-20251207-WA0036.jpg"));

            // ---------- FACULTY 8 ----------
            ArrayList<Course> fCourses8 = new ArrayList<>();
            fCourses8.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses8.add(new Course("Statistics", "STAT101", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Saad Malik", "F008", 37, "Hyderabad", "Mathematics",
                    new LoginCredentials("F008", "pass123"), fCourses8, "IMG-20251207-WA0024.jpg"));

            // ---------- FACULTY 9 ----------
            ArrayList<Course> fCourses9 = new ArrayList<>();
            fCourses9.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses9.add(new Course("Public Speaking", "PS101", "Arts", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Hania Tariq", "F009", 41, "Peshawar", "English",
                    new LoginCredentials("F009", "pass123"), fCourses9, "IMG-20251207-WA0022.jpg"));

            // ---------- FACULTY 10 ----------
            ArrayList<Course> fCourses10 = new ArrayList<>();
            fCourses10.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            fCourses10.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Zainab Shah", "F010", 39, "Quetta", "Computer Science",
                    new LoginCredentials("F010", "pass123"), fCourses10, "IMG-20251207-WA0027.jpg"));

            // ---------- FACULTY 11 ----------
            ArrayList<Course> fCourses11 = new ArrayList<>();
            fCourses11.add(new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", facAttendance));
            fCourses11.add(new Course("Software Engineering", "SE101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Adeel Khan", "F011", 46, "Lahore", "Computer Science",
                    new LoginCredentials("F011", "pass123"), fCourses11, "IMG-20251207-WA0028.jpg"));

            // ---------- FACULTY 12 ----------
            ArrayList<Course> fCourses12 = new ArrayList<>();
            fCourses12.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses12.add(new Course("Linear Algebra", "MATH102", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Maryam Rafiq", "F012", 38, "Karachi", "Mathematics",
                    new LoginCredentials("F012", "pass123"), fCourses12, "IMG-20251207-WA0029.jpg"));

            // ---------- FACULTY 13 ----------
            ArrayList<Course> fCourses13 = new ArrayList<>();
            fCourses13.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses13.add(new Course("Public Speaking", "PS101", "Arts", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Hina Siddiqui", "F013", 42, "Islamabad", "English",
                    new LoginCredentials("F013", "pass123"), fCourses13, "IMG-20251207-WA0027.jpg"));

            // ---------- FACULTY 14 ----------
            ArrayList<Course> fCourses14 = new ArrayList<>();
            fCourses14.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            fCourses14.add(new Course("Networking", "NET101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Usman Ali", "F014", 40, "Rawalpindi", "Computer Science",
                    new LoginCredentials("F014", "pass123"), fCourses14, "IMG-20251207-WA0026.jpg"));

            // ---------- FACULTY 15 ----------
            ArrayList<Course> fCourses15 = new ArrayList<>();
            fCourses15.add(new Course("Civics", "CIV101", "Arts", 2, "second", facAttendance));
            fCourses15.add(new Course("History", "HIS101", "Arts", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Samina Iqbal", "F015", 43, "Multan", "Social Studies",
                    new LoginCredentials("F015", "pass123"), fCourses15, "IMG-20251207-WA0026.jpg"));

            // ---------- FACULTY 16 ----------
            ArrayList<Course> fCourses16 = new ArrayList<>();
            fCourses16.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", facAttendance));
            fCourses16.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Hassan Raza", "F016", 39, "Faisalabad", "Computer Science",
                    new LoginCredentials("F016", "pass123"), fCourses16, "IMG-20251207-WA0024.jpg"));

            // ---------- FACULTY 17 ----------
            ArrayList<Course> fCourses17 = new ArrayList<>();
            fCourses17.add(new Course("Physical Fitness", "PF101", "Sports", 2, "second", facAttendance));
            fCourses17.add(new Course("Health Education", "HE101", "Sports", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Nadia Tariq", "F017", 45, "Sialkot", "Physical Education",
                    new LoginCredentials("F017", "pass123"), fCourses17, "IMG-20251207-WA0025.jpg"));

            // ---------- FACULTY 18 ----------
            ArrayList<Course> fCourses18 = new ArrayList<>();
            fCourses18.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses18.add(new Course("Statistics", "STAT101", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Salman Javed", "F018", 41, "Hyderabad", "Mathematics",
                    new LoginCredentials("F018", "pass123"), fCourses18, "IMG-20251207-WA0028.jpg"));

            // ---------- FACULTY 19 ----------
            ArrayList<Course> fCourses19 = new ArrayList<>();
            fCourses19.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses19.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Zunaira Malik", "F019", 37, "Peshawar", "English",
                    new LoginCredentials("F019", "pass123"), fCourses19, "IMG-20251207-WA0035.jpg"));

            // ---------- FACULTY 20 ----------
            ArrayList<Course> fCourses20 = new ArrayList<>();
            fCourses20.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            fCourses20.add(new Course("Networking", "NET101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Imran Shah", "F020", 44, "Quetta", "Computer Science",
                    new LoginCredentials("F020", "pass123"), fCourses20, "IMG-20251207-WA0040.jpg"));

            // ---------- FACULTY 21 ----------
            ArrayList<Course> fCourses21 = new ArrayList<>();
            fCourses21.add(new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", facAttendance));
            fCourses21.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", facAttendance));
            faculties.add(new Faculty("Dr. Farah Khan", "F021", 46, "Lahore", "Computer Science",
                    new LoginCredentials("F021", "pass123"), fCourses21, "IMG-20251207-WA0031.jpg"));

            // ---------- FACULTY 22 ----------
            ArrayList<Course> fCourses22 = new ArrayList<>();
            fCourses22.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses22.add(new Course("Linear Algebra", "MATH102", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Arslan Ahmed", "F022", 40, "Karachi", "Mathematics",
                    new LoginCredentials("F022", "pass123"), fCourses22, "IMG-20251207-WA0039.jpg"));

            // ---------- FACULTY 23 ----------
            ArrayList<Course> fCourses23 = new ArrayList<>();
            fCourses23.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses23.add(new Course("Public Speaking", "PS101", "Arts", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Mahnoor Riaz", "F023", 38, "Islamabad", "English",
                    new LoginCredentials("F023", "pass123"), fCourses23, "IMG-20251207-WA0034.jpg"));

            // ---------- FACULTY 24 ----------
            ArrayList<Course> fCourses24 = new ArrayList<>();
            fCourses24.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            fCourses24.add(new Course("Networking", "NET101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Usama Tariq", "F024", 42, "Rawalpindi", "Computer Science",
                    new LoginCredentials("F024", "pass123"), fCourses24, "IMG-20251207-WA0038.jpg"));

            // ---------- FACULTY 25 ----------
            ArrayList<Course> fCourses25 = new ArrayList<>();
            fCourses25.add(new Course("Civics", "CIV101", "Arts", 2, "second", facAttendance));
            fCourses25.add(new Course("History", "HIS101", "Arts", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Nida Hassan", "F025", 43, "Multan", "Social Studies",
                    new LoginCredentials("F025", "pass123"), fCourses25, "IMG-20251207-WA0031.jpg"));

            // ---------- FACULTY 26 ----------
            ArrayList<Course> fCourses26 = new ArrayList<>();
            fCourses26.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", facAttendance));
            fCourses26.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Shahbaz Ali", "F026", 39, "Faisalabad", "Computer Science",
                    new LoginCredentials("F026", "pass123"), fCourses26, "IMG-20251207-WA0038.jpg"));

            // ---------- FACULTY 27 ----------
            ArrayList<Course> fCourses27 = new ArrayList<>();
            fCourses27.add(new Course("Physical Fitness", "PF101", "Sports", 2, "second", facAttendance));
            fCourses27.add(new Course("Health Education", "HE101", "Sports", 2, "second", facAttendance));
            faculties.add(new Faculty("Dr. Fariha Khan", "F027", 45, "Sialkot", "Physical Education",
                    new LoginCredentials("F027", "pass123"), fCourses27, "IMG-20251207-WA0034.jpg"));

            // ---------- FACULTY 28 ----------
            ArrayList<Course> fCourses28 = new ArrayList<>();
            fCourses28.add(new Course("Calculus", "CAL101", "Math", 4, "second", facAttendance));
            fCourses28.add(new Course("Statistics", "STAT101", "Math", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Saima Malik", "F028", 41, "Hyderabad", "Mathematics",
                    new LoginCredentials("F028", "pass123"), fCourses28, "IMG-20251207-WA0022.jpg"));

            // ---------- FACULTY 29 ----------
            ArrayList<Course> fCourses29 = new ArrayList<>();
            fCourses29.add(new Course("English", "ENG101", "Arts", 3, "second", facAttendance));
            fCourses29.add(new Course("Technical Writing", "TW101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Dr. Humaira Shah", "F029", 37, "Peshawar", "English",
                    new LoginCredentials("F029", "pass123"), fCourses29, "IMG-20251207-WA0026.jpg"));

            // ---------- FACULTY 30 ----------
            ArrayList<Course> fCourses30 = new ArrayList<>();
            fCourses30.add(new Course("ICT", "ICT101", "CS", 3, "second", facAttendance));
            fCourses30.add(new Course("Networking", "NET101", "CS", 3, "second", facAttendance));
            faculties.add(new Faculty("Prof. Tariq Mehmood", "F030", 44, "Quetta", "Computer Science",
                    new LoginCredentials("F030", "pass123"), fCourses30, "IMG-20251207-WA0038.jpg"));

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FacultyFile))) {
                out.writeObject(faculties);
            } catch (Exception e) {
                System.out.println("Error writing faculty data: " + e.getMessage());
            }
        }
        if (!(CourseFile.exists())) {
            try {
                CourseFile.createNewFile();
            } catch (Exception e) {
            }
            ArrayList<Course> courses = new ArrayList<>();

            ArrayList<Attandance> sampleAttendance = new ArrayList<>();
            for (int i = 0; i < 35; i++) sampleAttendance.add(new Attandance("present"));

            courses.add(new Course("Object Oriented Programming", "CSC101", "CS", 4, "second", sampleAttendance));
            courses.add(new Course("Data Structures & Algorithms", "DSA101", "CS", 4, "second", sampleAttendance));
            courses.add(new Course("English", "ENG101", "Arts", 3, "second", sampleAttendance));
            courses.add(new Course("Calculus", "CAL101", "Math", 4, "second", sampleAttendance));
            courses.add(new Course("Physical Fitness", "PF101", "Sports", 2, "second", sampleAttendance));
            courses.add(new Course("ICT", "ICT101", "CS", 3, "second", sampleAttendance));
            courses.add(new Course("Civics", "CIV101", "Arts", 2, "second", sampleAttendance));
            courses.add(new Course("Technical Writing", "TW101", "CS", 3, "second", sampleAttendance));
            courses.add(new Course("Linear Algebra", "MATH102", "Math", 3, "second", sampleAttendance));
            courses.add(new Course("Networking", "NET101", "CS", 3, "second", sampleAttendance));

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CourseFile))) {
                out.writeObject(courses);
            } catch (Exception e) {
                System.out.println("Error writing course data: " + e.getMessage());
            }
        }
    }
    private ArrayList<Attandance> createAttendance(int absentInterval) {
        ArrayList<Attandance> attendance = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            attendance.add(new Attandance(i % absentInterval == 0 ? "absent" : "present"));
        }
        return attendance;
    }
}
