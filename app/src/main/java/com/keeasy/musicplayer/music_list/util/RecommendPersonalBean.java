package com.keeasy.musicplayer.music_list.util;

/**
 * Created by Administrator on 2017/9/19.
 */

import java.io.Serializable;

public class RecommendPersonalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String customerName;
    private String customerNo;
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}