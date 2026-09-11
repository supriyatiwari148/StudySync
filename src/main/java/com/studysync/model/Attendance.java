package com.studysync.model;

public class Attendance {

    private int attendanceId;
    private int subjectId;
    private int totalClasses;
    private int attendedClasses;
    private String subjectName;

    public Attendance() {
    }

    public Attendance(int attendanceId, int subjectId,
                      int totalClasses, int attendedClasses) {
        this.attendanceId = attendanceId;
        this.subjectId = subjectId;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) {
            return 0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
