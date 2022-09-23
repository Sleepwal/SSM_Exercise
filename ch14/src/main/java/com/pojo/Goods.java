package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Goods {
    private String gname;
    private String gdescription;
    private double gprice;
    //日期格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gdate;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdescription() {
        return gdescription;
    }

    public void setGdescription(String gdescription) {
        this.gdescription = gdescription;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }
}
