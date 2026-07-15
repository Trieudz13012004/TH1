package com.example.oneToOne.service;

import com.example.oneToOne.entity.Student;
import com.example.oneToOne.entity.StudentCard;
import com.example.oneToOne.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    //    GET BY ID
    public Student getStudentByID(int id ){
        return studentRepo.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found"
        ));
    }

    //    create new student
    public Student createStudent(Student student){
    //  Gán ngược
        if(student.getStudentCard() != null){
            student.getStudentCard().setStudent(student);
        }
        return studentRepo.save(student);
    }

    //    delete
    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }

    //    Updtate nhưng chưa update được user
    public Student updateStudent(int id, Student student){

        // Kiểm tra xem student cũ có tồn tại trong db ko
        Student oldStudent = studentRepo.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
        ));

        // Nếu student cũ có tồn tại thì set thuộc tính mới
        oldStudent.setStudentName(student.getStudentName());
        oldStudent.setBirthday(student.getBirthday());
        oldStudent.setClassName(student.getClassName());

        if(student.getStudentCard() != null){    // Nếu student đã có thẻ sv
            StudentCard card = student.getStudentCard();    // thì khởi tạo thẻ sv update mới
            if(card != null){   // Nếu có cardStudent rồi -> set thuộc tính mới cho card
                card.setCardNumber(student.getStudentCard().getCardNumber());
                card.setIssueDate(student.getStudentCard().getIssueDate());
                card.setExpireDate(student.getStudentCard().getExpireDate());
            }else {    // Chưa có thẻ sv thì tạo newCard cho sv
                StudentCard newCard = new StudentCard();
                newCard.setStudent(oldStudent);
                oldStudent.setStudentCard(newCard);
            }
        }
        return studentRepo.save(oldStudent);
    }
}
