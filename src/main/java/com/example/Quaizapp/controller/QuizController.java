package com.example.Quaizapp.controller;

import com.example.Quaizapp.entity.Question;
import com.example.Quaizapp.entity.Questionwrapper;
import com.example.Quaizapp.entity.Response;
import com.example.Quaizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
          return  quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<List<Questionwrapper>>setQuizquestion(@PathVariable Integer id){
        return quizService.getQuizquestion(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses){
        return quizService.calculateResult(id,responses);
    }



}
