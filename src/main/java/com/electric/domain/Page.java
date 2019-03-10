package com.electric.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于分页的类
 */
public class Page<T> implements Serializable {
    //每页起始
    private Integer index;

    //当前页
    private Integer currentPage;

    //当前页显示条数
    private Integer currentCount;

    //总条数
    private Integer totalCount;

    //总页数
    private Integer totalPage;

    //参数
    private Map<String, Object> params = new HashMap<String, Object>();

    //每页显示的数据
    private List<T> list = new ArrayList<T>();

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
        // set了每页显示条数的时候，一定set了当前页
        this.index = (this.currentPage - 1) * this.currentCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }
}
