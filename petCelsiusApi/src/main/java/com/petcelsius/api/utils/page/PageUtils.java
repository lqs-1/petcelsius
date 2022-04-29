package com.petcelsius.api.utils.page;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

public class PageUtils implements Serializable {

    private int currentPage;
    private int pageSize;
    private int totalSize;
    private int totalPage;
    private List<?> resultList;


    public PageUtils(IPage<?> page) {
        this.currentPage = (int) page.getCurrent();
        this.pageSize = (int) page.getSize();
        this.totalPage = (int) page.getPages();
        this.totalSize = (int) page.getTotal();
        this.resultList = page.getRecords();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<?> getResultList() {
        return resultList;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setResultList(List<?> resultList) {
        this.resultList = resultList;
    }
}
