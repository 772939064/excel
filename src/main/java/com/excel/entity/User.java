package com.excel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class User {

    @Excel(name = "用户id", orderNum = "0")
    private Integer id;

    @Excel(name = "用户姓名", orderNum = "1")
    private String username;

    @Excel(name = "用户邮箱", orderNum = "3", width = 30)
    private String email;

    @Excel(name = "用户电话", orderNum = "4", width = 30)
    private String phone;

    public User() {
    }

    public User(Integer id, String username, String email, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

