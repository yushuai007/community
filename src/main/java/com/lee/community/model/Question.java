package com.lee.community.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create_time;
    private Long gmt_modified_time;
    private Integer creator_login_id;
    private Integer view_count;
    private Integer comment_count;
    private Integer like_count;
}
