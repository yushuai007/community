package com.lee.community;

import com.alibaba.fastjson.JSON;
import com.lee.community.dto.GeeUser;
import com.lee.community.mapper.QuestionMapper;
import com.lee.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }
}
