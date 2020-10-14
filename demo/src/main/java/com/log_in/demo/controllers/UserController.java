package com.log_in.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.log_in.demo.model.UserModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.catalina.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    JdbcTemplate template;

    //根据id获取用户信息接口
    @CrossOrigin      //跨域问题
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String user(@RequestParam String id) throws JsonProcessingException {
        String sql = "SELECT* FROM user WHERE userid=?;";      //query语句
        Map map=template.queryForMap(sql,id);                  //map存一个对象
        UserModel customer=new UserModel();
        customer.setUserId(map.get("userid").toString());       //返回的属性
        customer.setUserName(map.get("username").toString());
        customer.setPassword(map.get("password").toString());
        //System.out.println(customer.password);
        //System.out.println(1);

      String json="{\"id\":\"" +  customer.userid + "\",\"username\":\"" +  customer.username + "\",\"password\":\"" +  customer.password + "\"}";
      return json;

    }

    //新增一个用户接口
    @CrossOrigin
    @RequestMapping(value="/signup", method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String order(@RequestParam String id,@RequestParam String nickname,@RequestParam String password) {



       String sql = "INSERT INTO is3test.user VALUES (?, ?, ?,?);";
        int insert = template.update(sql,id,nickname,password,500.0);
        if(insert == 0)
        {
            return "{\\\"result\\\":\\\"fail\\\"}";
        }

      return "{\\\"result\\\":\\\"success\\\"}";
        }


}

