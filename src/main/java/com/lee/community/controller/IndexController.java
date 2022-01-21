package com.lee.community.controller;

import com.lee.community.dto.QuestionDTO;
import com.lee.community.mapper.QuestionMapper;
import com.lee.community.mapper.UserMapper;
import com.lee.community.model.Question;
import com.lee.community.model.User;
import com.lee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionMapper questionMapper;

    public void doInsert(){
        for(int i = 0;i<10;i++){
            Question question = new Question();
            question.setTitle("学习SpringBoot" + i);
            question.setTag("Spring Boot,Java" + i);
            question.setDescription("好好学习，天天向上" + i);
            question.setCreator_login_id(10073041);
            question.setGmt_create_time(System.currentTimeMillis());
            question.setGmt_modified_time(question.getGmt_create_time());
            question.setLike_count(3 + i);
            question.setView_count(10 + i);
            question.setComment_count(2 + i);
            questionMapper.insertQuestion(question);
            System.out.println("数据插入完成");
        }
    }


    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        //1.访问index页，看是否cookie中有token，如果有，就取出user，放入session中
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    //如果去到token就放入session，页面上就不显示登录按钮
                    User user = userMapper.getUserByToken(cookie.getValue());
                    if (user != null) {
                        request.getSession().setAttribute("user", user);

                    }
                    break;
                }
            }
        }

        //查询问题列表
        List<QuestionDTO> questions = questionService.getQuestions();
        model.addAttribute("questions",questions);
        return "index";
    }
}
