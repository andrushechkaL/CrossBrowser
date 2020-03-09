package com.example.laba3.DAO.Interface;

import com.example.laba3.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    List<StudentModel> findAll();//просто правильное название метода даст возможность
    //избежать запросов на SQL


}
