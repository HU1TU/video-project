package com.tt.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 学科表，存储各个学科的名字(Subject)实体类
 *
 * @author makejava
 * @since 2020-10-20 10:54:21
 */
@Data
public class Subject {
    
    private Integer id;
    
    private String subjectName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}