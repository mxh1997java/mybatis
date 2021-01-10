package com.emi2c.mybatis.common.entity;

import com.emi2c.mybatis.common.annotation.Column;
import com.emi2c.mybatis.common.annotation.Id;
import com.emi2c.mybatis.common.annotation.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(value = "system_document")
public class Document {

    private Long id;

    private String code;

    private String name;

    private String description;

    private String creator;

    private LocalDateTime createTime;

    private String editor;

    private LocalDateTime editTime;

    @Id(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(value = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(value = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(value = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(value = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(value = "createTime")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Column(value = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Column(value = "editTime")
    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(code, document.code) &&
                Objects.equals(name, document.name) &&
                Objects.equals(description, document.description) &&
                Objects.equals(creator, document.creator) &&
                Objects.equals(createTime, document.createTime) &&
                Objects.equals(editor, document.editor) &&
                Objects.equals(editTime, document.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, creator, createTime, editor, editTime);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", editor='" + editor + '\'' +
                ", editTime=" + editTime +
                '}';
    }
}
