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
        createStudents(student);
        return "result";
    }

    public List<StudentModel> findAll(){
        return studentRepository.findAll();
    }

    public void createStudents(StudentModel student) {
        studentRepository.save(student);
    }

    public String deleteStudent (StudentModel student, Model model) {
        model.addAttribute("student", student);
        studentRepository.delete(student);
        return "deleteScreen";
    }


}
