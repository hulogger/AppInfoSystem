package com.team.domain;

public class AppCondition extends PageParamater{

    private String querySoftwareName;
    private Long queryStatus;
    private Long queryFlatformId;
    private Long queryCategoryLevel1;
    private Long queryCategoryLevel2;
    private Long queryCategoryLevel3;
    private Long devid;



    public Long getId() {
        return devid;
    }

    public void setId(Long devid) {
        this.devid = devid;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public Long getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(Long queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Long getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Long queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Long getQueryCategoryLevel1() {
        return queryCategoryLevel1;
    }

    public void setQueryCategoryLevel1(Long queryCategoryLevel1) {
        this.queryCategoryLevel1 = queryCategoryLevel1;
    }

    public Long getQueryCategoryLevel2() {
        return queryCategoryLevel2;
    }

    public void setQueryCategoryLevel2(Long queryCategoryLevel2) {
        this.queryCategoryLevel2 = queryCategoryLevel2;
    }

    public Long getQueryCategoryLevel3() {
        return queryCategoryLevel3;
    }

    public void setQueryCategoryLevel3(Long queryCategoryLevel3) {
        this.queryCategoryLevel3 = queryCategoryLevel3;
    }

    @Override
    public String toString() {
        return "AppCondition{" +
                "querySoftwareName='" + querySoftwareName + '\'' +
                ", queryStatus=" + queryStatus +
                ", queryFlatformId=" + queryFlatformId +
                ", queryCategoryLevel1=" + queryCategoryLevel1 +
                ", queryCategoryLevel2=" + queryCategoryLevel2 +
                ", queryCategoryLevel3=" + queryCategoryLevel3 +
                ", devid=" + devid +
                '}';
    }
}
