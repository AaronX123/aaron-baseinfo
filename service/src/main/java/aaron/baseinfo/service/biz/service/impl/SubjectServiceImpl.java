package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.*;
import aaron.baseinfo.service.biz.dao.SubjectDao;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.biz.service.SubjectService;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.common.utils.RandomTask;
import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import aaron.baseinfo.service.pojo.model.Subject;
import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import aaron.common.aop.annotation.FullCommonField;
import aaron.common.aop.enums.EnumOperation;
import aaron.common.utils.CommonUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xym
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {
    @Autowired
    SubjectAnswerService subjectAnswerService;

    /**
     * 保存试题
     *
     * @param dto
     * @param subjectAnswerDtoList
     * @return
     */
    @FullCommonField
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSubjectAndAnswer(SubjectDto dto, List<SubjectAnswerDto> subjectAnswerDtoList) {
        Subject subject = CommonUtils.copyProperties(dto,Subject.class);
        List<SubjectAnswer> answerList = CommonUtils.convertList(subjectAnswerDtoList,SubjectAnswer.class);
        return save(subject) && subjectAnswerService.saveBatch(answerList);
    }

    /**
     * 删除试题，同时删除答案
     *
     * @param subjectList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSubjectAndAnswer(List<Subject> subjectList) {
        return removeByIds(subjectList) && subjectAnswerService.removeBatchBySubjectId(subjectList.stream().map(Subject::getId).collect(Collectors.toList()));
    }

    /**
     * 首先删除原答案，然后更新题目信息，最后插入新增答案
     * @param subjectDto
     * @param answerDtoList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @FullCommonField(operation = EnumOperation.UPDATE)
    @Override
    public boolean updateSubject(SubjectDto subjectDto, List<SubjectAnswerDto> answerDtoList) {
        subjectAnswerService.removeBySubjectId(subjectDto.getId());
        List<SubjectAnswer> subjectAnswerList = CommonUtils.convertList(answerDtoList,SubjectAnswer.class);
        subjectAnswerService.saveBatch(subjectAnswerList);
        Subject subject = CommonUtils.copyProperties(subjectDto,Subject.class);
        updateById(subject);
        return true;
    }

    /**
     * @param subject
     * @return
     */
    @Override
    public List<Subject> listSubject(Subject subject) {
        return baseMapper.querySubject(subject);
    }

    @Override
    public SubjectPackage getSubject(List<CombExamConfigItem> itemList) {
        List<SubjectPackageDto> dtoList = new ArrayList<>();
        for (CombExamConfigItem item : itemList) {
            // 随机取题
            List<Long> subjectIdList = getAssignedIdList(item);
            // 获取试题
            List<Subject> subjectList = baseMapper.querySubjectByPrimaryKeyList(subjectIdList);
            // 获取答案
            List<SubjectAnswer> subjectAnswerList = subjectAnswerService.listAnswer(subjectList.stream().map(Subject::getId).collect(Collectors.toList()));
            if (CommonUtils.isEmpty(subjectList)){
                throw new BaseInfoException(BaseInfoError.GENERATE_FAIL);
            }
            if (CommonUtils.isEmpty(subjectAnswerList)){
                throw new BaseInfoException(BaseInfoError.GENERATE_FAIL);
            }
            for (Subject subject : subjectList) {
                SubjectPackageDto packageDto = new SubjectPackageDto();
                SubjectDto dto = CommonUtils.copyProperties(subject,SubjectDto.class);
                dto.setScore(item.getScore());
                packageDto.setSubjectDTO(dto);
                List<SubjectAnswerDto> subjectAnswerDtoList = subjectAnswerList.stream()
                        .filter(s -> s.getSubjectId().equals(subject.getId()))
                        .map(s -> CommonUtils.copyProperties(s,SubjectAnswerDto.class)).collect(Collectors.toList());
                packageDto.setSubjectAnswerDtoList(subjectAnswerDtoList);
                dtoList.add(packageDto);
            }
        }
        SubjectPackage subjectPackageList = new SubjectPackage();
        subjectPackageList.setDtoList(dtoList);
        return subjectPackageList;
    }

    @Override
    public SubjectPackage getSubjectById(List<Long> idList) {
        List<SubjectPackageDto> dtoList = new ArrayList<>();
        // 获取试题
        List<Subject> subjectList = baseMapper.querySubjectByPrimaryKeyList(idList);
        // 获取答案
        List<SubjectAnswer> subjectAnswerList = subjectAnswerService.listAnswer(subjectList.stream().map(Subject::getId).collect(Collectors.toList()));
        if (CommonUtils.isEmpty(subjectList)){
            throw new BaseInfoException(BaseInfoError.GENERATE_FAIL);
        }
        if (CommonUtils.isEmpty(subjectAnswerList)){
            throw new BaseInfoException(BaseInfoError.GENERATE_FAIL);
        }

        for (Subject subject : subjectList) {
            SubjectPackageDto packageDto = new SubjectPackageDto();
            SubjectDto dto = CommonUtils.copyProperties(subject,SubjectDto.class);
            packageDto.setSubjectDTO(dto);
            List<SubjectAnswerDto> subjectAnswerDtoList = subjectAnswerList.stream()
                    .filter(s -> s.getSubjectId().equals(subject.getId()))
                    .map(s -> CommonUtils.copyProperties(s,SubjectAnswerDto.class)).collect(Collectors.toList());
            packageDto.setSubjectAnswerDtoList(subjectAnswerDtoList);
            dtoList.add(packageDto);
        }
        return SubjectPackage.builder().dtoList(dtoList).build();
    }

    private List<Long> getAssignedIdList(CombExamConfigItem item){
        Subject subject = CommonUtils.copyProperties(item,Subject.class);
        List<Long> currentConfigId = baseMapper.querySubjectIdList(subject);
        if (currentConfigId.size() > item.getNum()){
            return new RandomTask(item.getNum(),currentConfigId).gen();
        }
        throw new BaseInfoException(BaseInfoError.ACQUIRE_ID_FAIL);
    }
}
