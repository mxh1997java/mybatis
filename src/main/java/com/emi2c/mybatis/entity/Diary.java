package com.emi2c.mybatis.entity;

import com.emi2c.mybatis.excel.ExcelColumn;

import java.util.Objects;

/**
 * 日记
 */
public class Diary extends BaseEntity {

    @ExcelColumn(value = "标题", col = 1)
    private String title;

    @ExcelColumn(value = "内容", col = 2)
    private String content;

    @ExcelColumn(value = "图片地址", col = 3)
    private String imgUrl;

    @ExcelColumn(value = "类型", col = 4)
    private String type;

    private Long typeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Diary diary = (Diary) o;
        return Objects.equals(title, diary.title) &&
                Objects.equals(content, diary.content) &&
                Objects.equals(imgUrl, diary.imgUrl) &&
                Objects.equals(type, diary.type) &&
                Objects.equals(typeId, diary.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, content, imgUrl, type, typeId);
    }
}
