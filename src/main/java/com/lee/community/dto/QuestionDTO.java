package com.lee.community.dto;

import com.lee.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create_time;
    private Long gmt_modified_time;
    private Integer creator_logion_id;
    private Integer view_count;
    private Integer comment_count;
    private Integer like_count;
    private User user;
}
