package com.example.baitapkiemtrathu2.model;

import java.util.Date;

public class Model {
    Integer id;
    String name;
    String content;
    String description;
    String spn1;
    String spn2;
    String date;
    Integer isOK;

    public Integer getIsOK() {
        return isOK;
    }

    public void setIsOK(Integer isOK) {
        this.isOK = isOK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpn1() {
        return spn1;
    }

    public void setSpn1(String spn1) {
        this.spn1 = spn1;
    }

    public String getSpn2() {
        return spn2;
    }

    public void setSpn2(String spn2) {
        this.spn2 = spn2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", spn1='" + spn1 + '\'' +
                ", spn2='" + spn2 + '\'' +
                ", date=" + date +
                ", isOK=" + isOK +
                '}';
    }
}
