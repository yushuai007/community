package com.lee.community.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String account_id;
    private String name;
    private String token;
    private long gmt_create_time;
    private long gmt_modified_time;
    private String email;
    private String avatar_url;
}
