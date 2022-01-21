package com.lee.community.mapper;

import com.lee.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select * from question")
    List<Question> getQuestions();
    @Insert("insert into question (title,description,tag,gmt_create_time,gmt_modified_time,creator_login_id,view_count,comment_count,like_count) values " +
            "(#{title},#{description},#{tag},#{gmt_create_time},#{gmt_modified_time},#{creator_login_id},#{view_count},#{comment_count},#{like_count})")
    void insertQuestion(Question question);
}
