package com.studysync.database;

import com.studysync.dao.StudentDAO;
import com.studysync.model.Student;

import java.util.List;

public class StudentDAOTest {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        List<Student> students = studentDAO.getAllStudents();

        System.out.println("\n--- Students from StudySync Database ---");

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " | " +
                            student.getName() + " | " +
                            student.getEmail() + " | " +
                            student.getCourse() + " | Semester: " +
                            student.getSemester()
            );
        }
    }
}
