package com.example.laba3.Controller;

import com.example.laba3.Model.StudentModel;
import com.example.laba3.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String homePage() {


        return studentService.showAllStudents();
    }

    @RequestMapping(value="/form", method= RequestMethod.GET)
    public String studentForm(Model model) {
        model.addAttribute("student", new StudentModel());
        return "addForm";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String studentSubmit(@ModelAttribute StudentModel student, Model model) {


        return studentService.addStudent(student, model);
//        model.addAttribute("student", student);
//        String info = String.format("Customer Submission: id = %d, name = %s, surname = %s",
//                student.getId(), student.getName(), student.getSurname());
//        log.info(info);
//
//        return "result";
    }


}