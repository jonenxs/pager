package com.nxs.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jonenxs on 2017/3/2.
 */
public class Pager<T> implements Serializable {
    private static final long serialVersionUID = 8145173341389078410L;

    private int pageSize;//每页显示多少条数数据

    private int currentPage;//当前第几页数据

    private int totalRecord;//一共多少条记录

    private int totalPage;//一共多少页记录

    private List<T> dateLIst;

    public Pager(int pageSize, int currentPage, int totalRecord, int totalPage, List<T> dateLIst) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dateLIst = dateLIst;
    }

    public Pager() {
    }

    public Pager(int pageNum, int pageSize,List<T> sourceList) {
        if(sourceList == null){
            return;
        }

        //总记录条数
        this.totalRecord = sourceList.size();
        //每页显示多少条记录
        this.pageSize = pageSize;
        //获取总页数
        this.totalPage = this.totalRecord/this.pageSize;
        if (this.totalRecord % this.pageSize == 0){
            this.pageSize += 1;
        }
        //当前第几页数据
        this.totalPage = this.totalPage < pageNum ? this.totalPage : pageNum;
        //获取dataList
        int fromIndx = this.pageSize * (this.currentPage - 1);//起始索引
        int toIndx = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord :this.pageSize * this.currentPage;//结束索引
        this.dateLIst = sourceList.subList(fromIndx, toIndx);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDateLIst() {
        return dateLIst;
    }

    public void setDateLIst(List<T> dateLIst) {
        this.dateLIst = dateLIst;
    }
}
