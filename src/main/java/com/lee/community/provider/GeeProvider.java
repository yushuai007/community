package com.lee.community.provider;

import com.alibaba.fastjson.JSON;
import com.lee.community.dto.GeeDTO;
import com.lee.community.dto.GeeUser;
import com.lee.community.dto.GitbubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeeProvider {

    public static final MediaType mediaType
            = MediaType.get("application/json; charset=utf-8");

    public String getToken(GeeDTO geeDTO){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(geeDTO));
        Request request = new Request.Builder()
                .url("https://gitee.com/oauth/token?grant_type=authorization_code")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String token = JSON.parseObject(response.body().string()).getString("access_token");
            System.out.println("=================token=========:" + token);
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GeeUser getUser(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://gitee.com/api/v5/user?access_token=" + token)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String geeUserStr = response.body().string();
            GeeUser geeUser = JSON.parseObject(geeUserStr, GeeUser.class);
            System.out.println(geeUser.toString());
            return geeUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
