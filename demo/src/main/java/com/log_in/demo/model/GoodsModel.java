package com.log_in.demo.model;


public class GoodsModel {




    private String goodid;
    private String goodname;
    private Float goodprice;



    /*获取商品id*/
    public String getId() {
        return goodid;
    }

    /*获取商品名称*/
    public String getName() {
        return goodname;
    }
    /*获取商品价格*/
    public Float getPrice() {
        return goodprice;
    }

    public void setId(String id) {
        goodid = id;
    }

    public void setName(String name) {
        goodname =name;
    }

    public void setPrice(Float price) {
        goodprice =price;
    }









}
