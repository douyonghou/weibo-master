package com.gr.geias.enums;

/**
 * @version 1.0
 * @date 2020-03-07 13:15
 */
public enum EnableStatusEnums {
    TEACHER(0,"用户"),PREXY(1,"管理员"),
    schoolmaster(2,"超级管理员")
    ;
    private int state;
    private String stateInfo;

    EnableStatusEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static EnableStatusEnums getEnableStatusEnums(int state) {
        for (EnableStatusEnums productSateEnum : values()) {
            if (productSateEnum.getState() == state) {
                return productSateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
