package com.emi2c.mybatis.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class BaseEntity {

    private Long id;

    private String description;

    private Integer isDelete;

    private Integer isActive;

    private LocalDateTime createTime;

    private LocalDateTime editTime;

    private String creator;

    private String editor;

    private String uda1;

    private String uda2;

    private String uda3;

    private String uda4;

    private String uda5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getUda1() {
        return uda1;
    }

    public void setUda1(String uda1) {
        this.uda1 = uda1;
    }

    public String getUda2() {
        return uda2;
    }

    public void setUda2(String uda2) {
        this.uda2 = uda2;
    }

    public String getUda3() {
        return uda3;
    }

    public void setUda3(String uda3) {
        this.uda3 = uda3;
    }

    public String getUda4() {
        return uda4;
    }

    public void setUda4(String uda4) {
        this.uda4 = uda4;
    }

    public String getUda5() {
        return uda5;
    }

    public void setUda5(String uda5) {
        this.uda5 = uda5;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDelete=" + isDelete +
                ", isActive=" + isActive +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", uda1='" + uda1 + '\'' +
                ", uda2='" + uda2 + '\'' +
                ", uda3='" + uda3 + '\'' +
                ", uda4='" + uda4 + '\'' +
                ", uda5='" + uda5 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(isDelete, that.isDelete) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(editTime, that.editTime) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(uda1, that.uda1) &&
                Objects.equals(uda2, that.uda2) &&
                Objects.equals(uda3, that.uda3) &&
                Objects.equals(uda4, that.uda4) &&
                Objects.equals(uda5, that.uda5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isDelete, isActive, createTime, editTime, creator, editor, uda1, uda2, uda3, uda4, uda5);
    }
}
