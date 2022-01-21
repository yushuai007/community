package com.lee.community.provider;

import com.alibaba.fastjson.JSON;
import com.lee.community.dto.AccessTokenDTO;
import com.lee.community.dto.GitbubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    public static final MediaType mediaType
            = MediaType.get("application/json; charset=utf-8");
    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        System.out.println(body.toString());
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String bodyStr = response.body().string();
            System.out.println(bodyStr);
            String token = bodyStr.split("&")[0].split("=")[1];
            System.out.println("token="+token);
            return token;
        }
    }

    public String getGithubUser(String token) throws IOException {
        OkHttpClient client = new OkHttpClient();

//        Request request = new Request.Builder()
//                .url("https://api.github.com/user?access_token="+token)
//                .build();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + token)
                .build();

        try (Response bodyStr = client.newCall(request).execute()) {
            System.out.println("body"+bodyStr.body().toString());
            GitbubUser gitbubUser = JSON.parseObject(bodyStr.body().toString(),GitbubUser.class);
            return gitbubUser.getName();
        }

    }
}
