package com.example.Quaizapp.controller;


import com.example.Quaizapp.entity.Question;
import com.example.Quaizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("Question")
public class Questioncontroller {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){

        return questionService.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionBycategory(@PathVariable String category){
        return  questionService.getQuestionBycategory(category);

    }
     @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);



     }





}
