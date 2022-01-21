package com.lee.community.mapper;

import com.lee.community.model.Question;
import com.lee.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(account_id,name,token,gmt_create_time,gmt_modified_time,email,avatar_url) values" +
            "(#{account_id},#{name},#{token},#{gmt_create_time},#{gmt_modified_time},#{email},#{avatar_url})")
    void addUser(User user);

    @Select("select * from user where token = #{token}")
    User getUserByToken(@Param("token") String token);

    @Select("select * from user where account_id = #{creator_logion_id}")
    User getUserById(@Param("creator_logion_id") Integer creator_logion_id);
}
