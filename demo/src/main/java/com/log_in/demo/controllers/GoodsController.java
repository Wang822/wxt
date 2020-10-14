package com.log_in.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.log_in.demo.model.GoodsModel;
import com.log_in.demo.model.Cart;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class GoodsController {
    @Autowired
    JdbcTemplate template;

    @RequestMapping(value="/good", method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String good() {

        String sql = "SELECT * FROM goods;";
        //用一个list储存数据库中查询根据goodid得到的good
        List<Map<String, Object>> list = template.queryForList(sql);

        List<GoodsModel> goodList = new ArrayList<GoodsModel>();
        //遍历list
        for (Map<String, Object> map : list) {
            GoodsModel good=new GoodsModel();
            good.setId(map.get("goodid").toString());
            good.setPrice(Float.parseFloat(map.get("goodprice").toString()));
            good.setName(map.get("goodname").toString());
            goodList.add(good);
        }


        JSONArray json = new JSONArray(goodList);
        if (json==null) {
            return  "{wrong!!}";
        }

        return json.toString();
    }



    @RequestMapping(value="/addToCart/{json}", method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String addToCart(@PathVariable String json) {
//            //创建一个good用于储存待加购商品信息
//           GoodsModel good=new GoodsModel();
//           CartModel cart=new CartModel();
//
//           //根据id获取商品信息，存入good中
//           good.setId(id);
//           good.setName(good.getName());
//           good.setPrice(good.getPrice());

        Cart cart = JSONObject.parseObject(json, Cart.class);
        System.out.println(cart.id);
        //将good加入cart中
        String sql = "INSERT INTO is3test.cart VALUES (?, ?, ?, ?);";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int insert = template.update(sql,cart.userid,df.format(System.currentTimeMillis()),cart.id,cart.amount);
        if(insert == 0)
        {
            return "{\\\"result\\\":\\\"fail\\\"}";
        }
        return "{\\\"result\\\":\\\"success\\\"}";
    }



}




