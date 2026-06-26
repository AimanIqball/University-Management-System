# University-Management-System
The University Management System (UMS) is a Java-based desktop application managing Students, Faculty, and Administrators. Built using Java Swing and Object Serialization (.bin files), it applies core OOP principles and supports academic operations for 30+ users and multiple courses with efficient data handling.
<br>
# System Architecture & Data Flow
The UMS follows a Model-View-Controller (MVC)-inspired pattern, though not strictly enforced, which cleanly separates concerns:
1.	Model (UniPerson, Course, data classes): Contains all business logic, data structures, and file I/O operations.
2.	View (Login, *Dashboard classes): Comprises the Swing-based GUI, responsible for presenting data and capturing user input.
3.	Controller (Logic within dashboard ActionListeners): Handles user events, validates input, and mediates between the View and the Model.
Data Flow:
1.	Initialization: UniversityManager checks for .bin files and populates them with sample data if missing.
2.	Authentication: The Login class reads the appropriate .bin file, deserializes the user list, and validates credentials.
3.	Session: Upon successful login, a role-specific dashboard (StudentDashboard, etc.) is instantiated, loading the user's object.
4.	Operations: User actions trigger controllers that read/write serialized ArrayLists from/to .bin files, ensuring data persistence across sessions.
