package com.gr.geias.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : dtCnt
 * @Description : 性别统计<dt, cnt>
 * @Author : douyonghou
 * @Date: 2021-04-14 21:59
 */
@Data
public class TimeCnt implements Serializable {
    String dt;
    Integer cnt;

    public String getDt() {
        return dt;
    }

    public void setDt (String dt) {
        this.dt = dt;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
