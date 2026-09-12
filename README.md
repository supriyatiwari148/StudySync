# 📚 StudySync

> A JavaFX-based Student Timetable and Reminder System designed to help students manage their academic activities in one place.

StudySync is a desktop-based student management application developed using **Java, JavaFX, FXML, CSS, Maven, and MySQL**.

The application provides a centralized platform where students can manage their **weekly timetable, assignments, attendance, examinations, and reminders** through an attractive and user-friendly interface.

---

## ✨ Features

### 📅 Timetable Management
- View weekly class schedules
- Display subjects with their respective timings
- Organize academic activities in an easy-to-read format

### 📝 Assignment Management
- Add new assignments
- View assignment details
- Track academic tasks
- Store assignment information in the database

### 🎓 Attendance Management
- Manage attendance records
- View subject-wise attendance
- Store attendance information using MySQL

### 🧾 Examination Management
- View upcoming examinations
- Display subject names and examination dates
- Helps students keep track of important exam schedules

### 🔔 Reminder Management
- Create and manage academic reminders
- View important reminders
- Helps students remember upcoming academic activities

### 👤 Student Information
- Store student details
- Manage student-related information
- Connect student information with the application database

### 🎨 User-Friendly Interface
- JavaFX-based graphical user interface
- FXML for UI structure
- CSS for application styling
- Dashboard-based navigation
- Clean and modern student-focused design

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| ☕ Java | Core application development |
| 🎨 JavaFX | Desktop graphical user interface |
| 🧩 FXML | UI layout and component structure |
| 🎨 CSS | UI styling and customization |
| 🗄️ MySQL | Database management |
| 🔗 JDBC | Java-MySQL database connectivity |
| 📦 Maven | Dependency and project management |
| 💻 IntelliJ IDEA | Development environment |

---

## 🏗️ Project Architecture

StudySync follows a structured architecture separating the user interface, application logic, database operations, and data models.

```text
StudySync
│
├── Controller
│   ├── DashboardController
│   ├── TimetableController
│   ├── AssignmentsController
│   ├── AddAssignmentController
│   ├── AttendanceController
│   ├── ExamsController
│   ├── RemindersController
│   └── SubjectController
│
├── DAO
│   ├── StudentDAO
│   ├── SubjectDAO
│   ├── TimetableDAO
│   ├── AssignmentDAO
│   ├── AttendanceDAO
│   ├── ExamDAO
│   └── ReminderDAO
│
├── Model
│   ├── Student
│   ├── Subject
│   ├── Timetable
│   ├── Assignment
│   ├── Attendance
│   ├── Exam
│   └── Reminder
│
├── Database
│   └── DBConnection
│
└── Resources
    ├── FXML
    └── CSS
