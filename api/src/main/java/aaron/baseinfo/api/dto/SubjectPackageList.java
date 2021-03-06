package aaron.baseinfo.api.dto;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-16
 */
public class SubjectPackageList {
    List<SubjectPackageDto> packageDTOList;

    public SubjectPackageList() {
    }

    public List<SubjectPackageDto> getPackageDTOList() {
        return packageDTOList;
    }

    public void setPackageDTOList(List<SubjectPackageDto> packageDTOList) {
        this.packageDTOList = packageDTOList;
    }

    @Override
    public String toString() {
        return "SubjectPackageList{" +
                "packageDTOList=" + packageDTOList+
                '}';
    }
}
