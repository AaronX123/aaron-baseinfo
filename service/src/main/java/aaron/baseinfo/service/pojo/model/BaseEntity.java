package aaron.baseinfo.service.pojo.model;


import aaron.common.data.common.CommonField;

import javax.persistence.Transient;

public class BaseEntity extends CommonField {
    /**
     *
     */
    @Transient
    protected Long judgeId;

    @Transient
    protected Long oldVersion;

    public Long getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Long judgeId) {
        this.judgeId = judgeId;
    }

    public Long getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(Long oldVersion) {
        this.oldVersion = oldVersion;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "judgeId=" + judgeId +
                ", oldVersion=" + oldVersion +
                ", id=" + id +
                ", orgId=" + orgId +
                ", companyId=" + companyId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
