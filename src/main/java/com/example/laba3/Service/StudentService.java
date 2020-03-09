package com.example.laba3.Service;

import com.example.laba3.DAO.Interface.StudentRepository;
import com.example.laba3.Model.StudentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());


    public String showAllStudents (Model model) {

        List<StudentModel> students = findAll();
        model.addAttribute("students", students);

        return "home";
    }

    public String addStudent (StudentModel student, Model model) {

        model.addAttribute("student", student);
        createUsers(student);
//        String info = String.format("Customer Submission: id = %d, name = %s, surname = %s",
//                student.getId(), student.getName(), student.getSurname());
        //log.info(info);
//        List<StudentModel> test = findAll();
//        for (StudentModel tmp :
//                test) {
//            log.info(tmp.getName());
//        }

        return "result";
    }

    public List<StudentModel> findAll(){
        return studentRepository.findAll();
    }

    public void createUsers(StudentModel student) {
        studentRepository.save(student);
    }


}
