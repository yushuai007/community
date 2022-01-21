package com.lee.community.service;

import com.lee.community.dto.QuestionDTO;
import com.lee.community.mapper.QuestionMapper;
import com.lee.community.mapper.UserMapper;
import com.lee.community.model.Question;
import com.lee.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    public List<QuestionDTO> getQuestions(){
        List<Question> questions = questionMapper.getQuestions();
        List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
        for(Question question:questions){
            User user = userMapper.getUserById(question.getCreator_login_id());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionList.add(questionDTO);
        }
        return questionList;
    }
}
