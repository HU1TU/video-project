package com.tt.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2020-10-20 10:54:20
 */
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = -43774745626830038L;
    
    private Integer id;
    
    private String courseTitle;
    
    private String courseDesc;
    
    private Integer subjectId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

}