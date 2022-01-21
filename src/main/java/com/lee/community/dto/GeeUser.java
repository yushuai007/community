package com.lee.community.dto;

import lombok.Data;

@Data
public class GeeUser {
    private String id;
    private String name;
    private String login;
    private String email;
    private String avatar_url;

    @Override
    public String toString() {
        return "GeeUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
