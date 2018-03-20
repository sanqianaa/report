package com.netease.cloud.nce.dto;

/**
 * Created by hzzhouxiang on 2018/1/24.
 */
public class DescDTO {

	private long id;				//主键id
    private String uniqueId;
    private String version;         //测试执行测试版本
    private String beginTest;       //开始测试时间
    private String endTest;         //完成测试时间
    private String smokeUrl;        //冒烟测试
    private String reviewUrl;       //用例评审
    private String executeUrl;      //用例执行
    private String costTime;        //耗时
    private String qualityDesc;     //版本质量
    private String otherDetails;    //其他

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBeginTest() {
        return beginTest;
    }

    public void setBeginTest(String beginTest) {
        this.beginTest = beginTest;
    }

    public String getEndTest() {
        return endTest;
    }

    public void setEndTest(String endTest) {
        this.endTest = endTest;
    }

    public String getSmokeUrl() {
        return smokeUrl;
    }

    public void setSmokeUrl(String smokeUrl) {
        this.smokeUrl = smokeUrl;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public String getExecuteUrl() {
        return executeUrl;
    }

    public void setExecuteUrl(String executeUrl) {
        this.executeUrl = executeUrl;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public String getQualityDesc() {
        return qualityDesc;
    }

    public void setQualityDesc(String qualityDesc) {
        this.qualityDesc = qualityDesc;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
