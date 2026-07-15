package com.example.oneToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_cards")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "student_id", unique = true)  // student_id: tên khóa ngoại ở bảng StudentCard trỏ đến bảng này
    private Student student;

    public StudentCard() {}

    public StudentCard(int id, String cardNumber, LocalDateTime issueDate, LocalDateTime expireDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}