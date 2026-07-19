package com.example.oneToOne.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name="student_name", nullable = false)
    private String studentName;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "class_name")
    private String className;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)   // ở StudentCard có biến là student ánh xạ tới bảng này, cascade là tự động update giữa 2 bảng khi có thay đổi
    private StudentCard studentCard;       // Khai báo đối tượng StudentCard thuộc về student này

    public Student() {}

    public Student(Integer studentId, String studentName, LocalDateTime birthday, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.className = className;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }
}
