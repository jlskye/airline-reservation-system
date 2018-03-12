package com.bean;

import java.io.Serializable;

//用在完善乘机人页面
public class Passagebean implements Serializable{
    private static final long serialVersionUID = 1L;

    private String passage_name;//乘客姓名
    private String passage_id;//乘客身份证
    private String passage_type;//乘客买的票的价格
    private String passage_phone;//联系人电话

    public String getPassage_name() {
        return passage_name;
    }

    public void setPassage_name(String passage_name) {
        this.passage_name = passage_name;
    }

    public String getPassage_id() {
        return passage_id;
    }

    public void setPassage_id(String passage_id) {
        this.passage_id = passage_id;
    }

    public String getPassage_type() {
        return passage_type;
    }

    public void setPassage_type(String passage_type) {
        this.passage_type = passage_type;
    }

    public String getPassage_phone() {
        return passage_phone;
    }

    public void setPassage_phone(String passage_phone) {
        this.passage_phone = passage_phone;
    }
}
