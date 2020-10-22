package com.tt.pojo;


import lombok.Data;

/**
 * (Speaker)实体类
 *
 * @author makejava
 * @since 2020-10-20 10:48:01
 */
@Data
public class Speaker {

    private Integer id;
    /**
    * 主讲人姓名
    */
    private String speakerName;
    /**
    * 主讲人简介
    */
    private String speakerDesc;
    /**
    * 职位
    */
    private String speakerJob;
    
    private String headImgUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerDesc() {
        return speakerDesc;
    }

    public void setSpeakerDesc(String speakerDesc) {
        this.speakerDesc = speakerDesc;
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

}