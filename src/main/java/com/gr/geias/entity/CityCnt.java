package com.gr.geias.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : CityCnt
 * @Description : 性别统计<city, cnt>
 * @Author : douyonghou
 * @Date: 2021-04-14 21:59
 */
@Data
public class CityCnt implements Serializable {
    String city;
    Integer cnt;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
