package com.zzq.springboot.mybatis.util.tag;

import com.zzq.springboot.mybatis.util.HrmConstants;

/**
 * 分页实体
 * Created by qqqqqqq on 17-8-29.
 */
public class PageModel {
    //分页总数据条数
    private int recordCount;

    //当前页面
    private int pageIndex;

    //每页分多少数据
    private int pageSize = HrmConstants.PAGE_DEFAULT_SIZE;

    //总页数
    private int totalSize;

    public int getRecordCount() {
        this.recordCount = this.recordCount <= 0 ? 0 : this.recordCount;
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        //如果索引过大就设为最后一页或者第一页，否则就是当前
        this.pageIndex = this.pageIndex <= 0 ? 1 : this.pageIndex;
        this.pageIndex = this.pageIndex >= this.getTotalSize() ? this.getTotalSize() : this.pageIndex;
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE ? HrmConstants.PAGE_DEFAULT_SIZE : this.pageSize;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        if (this.getRecordCount() <= 0) {
            totalSize = 0;
        } else {
            //总页数 = 总数据/每页条数
            totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
        }
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getFirstLimitParam() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }
}
