package com.log_in.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET, produces = "application/json")
    public String hello(@PathVariable String id) {

        String sql = "SELECT username FROM user WHERE userid = ?";

        // 通过jdbcTemplate查询数据库
        String username = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { id }, String.class);

        return "Hello " + username + id;
    }
}