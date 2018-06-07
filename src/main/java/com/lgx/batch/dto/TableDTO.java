package com.lgx.batch.dto;

public class TableDTO {
    private Integer pageSize;       //每页要显示的数据条数
    private Integer pageNumber;     //每页显示数据的开始行号
    private String sortName;        //要排序的字段
    private String sortOrder;       //排序规则

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "TableDTO{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
