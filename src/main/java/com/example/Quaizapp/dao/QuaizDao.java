package com.example.Quaizapp.dao;

import com.example.Quaizapp.entity.Question;
import com.example.Quaizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface QuaizDao extends JpaRepository<Quiz,Integer> {

}
