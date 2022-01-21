package com.lee.community;

import com.alibaba.fastjson.JSON;
import com.lee.community.dto.GeeUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
//        String geeUserStr = "{\"id\":10073041,\"login\":\"yushuai007\",\"name\":\"宇帅\",\"avatar_url\":\"https://gitee.com/assets/no_portrait.png\",\"url\":\"https://gitee.com/api/v5/users/yushuai007\",\"html_url\":\"https://gitee.com/yushuai007\",\"remark\":\"\",\"followers_url\":\"https://gitee.com/api/v5/users/yushuai007/followers\",\"following_url\":\"https://gitee.com/api/v5/users/yushuai007/following_url{/other_user}\",\"gists_url\":\"https://gitee.com/api/v5/users/yushuai007/gists{/gist_id}\",\"starred_url\":\"https://gitee.com/api/v5/users/yushuai007/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://gitee.com/api/v5/users/yushuai007/subscriptions\",\"organizations_url\":\"https://gitee.com/api/v5/users/yushuai007/orgs\",\"repos_url\":\"https://gitee.com/api/v5/users/yushuai007/repos\",\"events_url\":\"https://gitee.com/api/v5/users/yushuai007/events{/privacy}\",\"received_events_url\":\"https://gitee.com/api/v5/users/yushuai007/received_events\",\"type\":\"User\",\"blog\":null,\"weibo\":null,\"bio\":null,\"public_repos\":0,\"public_gists\":0,\"followers\":0,\"following\":0,\"stared\":0,\"watched\":0,\"created_at\":\"2021-11-23T16:07:33+08:00\",\"updated_at\":\"2022-01-21T09:02:54+08:00\",\"email\":null}";
//        GeeUser geeUser = JSON.parseObject(geeUserStr, GeeUser.class);
//        System.out.println(geeUser.getEmail()+"-"+geeUser.getName()+"-"+geeUser.getLogin());
    }

}
