package org.hmily.springboot.springdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {


    @Autowired
    JdbcTemplate db2JdbcTemplate;

    @RequestMapping("/addUser")
    public void insertUserInfo(){
        String sql = "INSERT INTO `user_info` ( `name`, `age`) VALUES ('hmily_2', '30')";
        db2JdbcTemplate.execute(sql);
        return;
    }



}
