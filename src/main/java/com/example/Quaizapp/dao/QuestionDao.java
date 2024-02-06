package com.example.Quaizapp.dao;

import com.example.Quaizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question>findQuestionBycategory(String category);

    @Query(value = "select * from Question Q where Q.category=:category ORDER BY RANDOM() LIMIT:numQ",nativeQuery = true)
    List<Question> findRandomQuestionBycategory(String category, int numQ);
}
