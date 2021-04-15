package com.gr.geias.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : SexCnt
 * @Description : 性别统计<sex, cnt>
 * @Author : douyonghou
 * @Date: 2021-04-14 21:59
 */
@Data
public class SexCnt implements Serializable {
    String sex;
    Integer cnt;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
