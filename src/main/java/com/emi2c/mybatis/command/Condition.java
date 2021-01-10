package com.emi2c.mybatis.command;

import java.time.LocalDateTime;

/**
 * 查询条件
 */
public class Condition {

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 分页参数：页面显示条数
     */
    private Integer pageSize;

    /**
     * 分页参数： 页码
     */
    private Integer index;

    /**
     * 删除标记：未删除
     */
    private Integer isDelete = 0;

    /**
     * 激活标记：已激活
     */
    private Integer isActive = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
