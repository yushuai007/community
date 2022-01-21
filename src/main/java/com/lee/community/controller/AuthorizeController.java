package com.lee.community.controller;

import com.lee.community.dto.AccessTokenDTO;
import com.lee.community.dto.GeeDTO;
import com.lee.community.dto.GeeUser;
import com.lee.community.provider.GeeProvider;
import com.lee.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("846e7f8a799522f4f925");
        accessTokenDTO.setClient_secret("6714a9cdb082ef41675525f3bcabc33eb1e597db");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8888/callback");
        try {
            String token = githubProvider.getAccessToken(accessTokenDTO);
            String name = githubProvider.getGithubUser(token);
            System.out.println("---"+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @Autowired
    private GeeProvider geeProvider;
    @Value("${gee.client_id}")
    private String client_id;
    @Value("${gee.client_secret}")
    private String client_secret;
    @Value("${gee.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/geecallback")
    public String geecallback(@RequestParam(name = "code") String code, Model model){
        //1.实例化gee对象
        GeeDTO geeDTO = new GeeDTO();
        geeDTO.setClient_id(client_id);
        geeDTO.setClient_secret(client_secret);
        geeDTO.setRedirect_uri(redirect_uri);
        geeDTO.setCode(code);
        System.out.println(code);
        //2.创建geeProvider，接收返回code，然后post请求申请token
        String token = geeProvider.getToken(geeDTO);
        //3.创建获取用户信息
        GeeUser geeUser = geeProvider.getUser(token);
        //4.跳转index.html页面
        model.addAttribute("name",geeUser.getName());
        return "index";
    }
}
