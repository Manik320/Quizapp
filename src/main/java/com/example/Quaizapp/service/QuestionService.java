package com.example.Quaizapp.service;

import com.example.Quaizapp.dao.QuestionDao;
import com.example.Quaizapp.entity.Question;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
     QuestionDao questionDao;

    public ResponseEntity<List<Question>> getQuestionBycategory(String category) {
        try {
            return  new ResponseEntity<>(questionDao.findQuestionBycategory(category),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(questionDao.findQuestionBycategory(category),HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String>addQuestion(Question question) {
        try {
              questionDao.save(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
