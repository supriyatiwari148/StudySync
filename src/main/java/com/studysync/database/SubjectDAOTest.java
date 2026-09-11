package com.studysync.database;

import com.studysync.dao.SubjectDAO;
import com.studysync.model.Subject;

import java.util.List;

public class SubjectDAOTest {

    public static void main(String[] args) {

        SubjectDAO subjectDAO = new SubjectDAO();

        List<Subject> subjects = subjectDAO.getAllSubjects();

        System.out.println("\n--- Subjects from StudySync Database ---");

        for (Subject subject : subjects) {

            System.out.println(
                    subject.getSubjectId() + " | " +
                            subject.getSubjectName() + " | " +
                            subject.getSubjectCode() + " | " +
                            subject.getTeacherName() + " | Semester: " +
                            subject.getSemester()
            );
        }
    }
}