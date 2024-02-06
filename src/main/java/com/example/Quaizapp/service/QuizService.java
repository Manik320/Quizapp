package com.example.Quaizapp.service;

import com.example.Quaizapp.dao.QuaizDao;
import com.example.Quaizapp.dao.QuestionDao;
import com.example.Quaizapp.entity.Question;
import com.example.Quaizapp.entity.Questionwrapper;
import com.example.Quaizapp.entity.Quiz;
import com.example.Quaizapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuaizDao quaizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question>questions=questionDao.findRandomQuestionBycategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);quaizDao.save(quiz);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);

    }


    public ResponseEntity<List<Questionwrapper>> getQuizquestion(Integer id) {
        Optional<Quiz>quiz =quaizDao.findById(id);
        List<Question>questionDb=quiz.get().getQuestions();
        List<Questionwrapper>questionforuser=new ArrayList<>();
        for(Question q:questionDb){
            Questionwrapper qw=new Questionwrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionforuser.add(qw);
        }
        return  new ResponseEntity<>(questionforuser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quaizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;

        }
    return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
