package com.github.yanbin.common.vo;

/**
 * TODO: Rest响应对象
 *
 * Author: kai
 * CreateDate: 2017/9/4
 * CreateTime: 19:21
 */
public class ObjectRestResponse<T> extends BaseResponse {
    T data;
    boolean rel;


    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }



    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }



    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
