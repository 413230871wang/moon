package com.moon.extension.poi.service;

import com.moon.extension.poi.mapper.*;
import com.moon.extension.poi.model.ApplicantEdu;
import com.moon.extension.poi.model.ApplicantFamily;
import com.moon.extension.poi.model.ApplicantWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/27 3:03 下午
 */
@Service
public class CondidatesService {
    @Autowired
    private ApplicantEduMapper applicantEduMapper;

    @Autowired
    private ApplicantFamilyMapper applicantFamilyMapper;

    @Autowired
    private ApplicantWorkMapper applicantWorkMapper;

    @Autowired
    private ApplicantMapper applicantMapper;

    @Autowired
    private ResultTestMapper resultTestMapper;

    @Transactional
    public void insertCondidates(Map<String, Object> requestMap) throws Exception{
        List<ApplicantEdu> eduList = (List<ApplicantEdu>) requestMap.get("edu");
        List<ApplicantFamily> familyList = (List<ApplicantFamily>) requestMap.get("family");
        List<ApplicantWork> workList = (List<ApplicantWork>) requestMap.get("job");

        applicantEduMapper.insertByList(eduList);
        applicantFamilyMapper.insertByList(familyList);
        applicantWorkMapper.insertByList(workList);
        applicantMapper.insertByMap(requestMap);
    }

    public Map<String, Object> selectResultMapByPrimaryKey(String s) {
        Map<String, Object> resultMap = resultTestMapper.selectMapByPrimaryKey(s);
        return resultMap;
    }

    public List<Map<String, Object>> selectEduMapByIdNo(String idNo) {
        List<Map<String, Object>> list = applicantEduMapper.selectEduMapByIdNo(idNo);
        return list;
    }

    public List<Map<String, Object>> selectWorkMapByIdNo(String idNo) {
        List<Map<String, Object>> list = applicantWorkMapper.selectWorkMapByIdNo(idNo);
        return list;
    }

    public List<Map<String, Object>> selectFamilyMapByIdNo(String idNo) {
        List<Map<String, Object>> list = applicantFamilyMapper.selectFamilyMapByIdNo(idNo);
        return list;
    }

    public void getContentMap(Map<String,Object> contentMap ,String idNo) throws ClassNotFoundException {
        Map<String,Object> condidatesResultMap = selectResultMapByPrimaryKey(idNo);
        List<Map<String,Object>> condidatesEduMap = selectEduMapByIdNo(idNo);
        List<Map<String,Object>> condidatesWorkMap = selectWorkMapByIdNo(idNo);
        List<Map<String,Object>> condidatesFamilyMap = selectFamilyMapByIdNo(idNo);

        Class applicantClazz = Class.forName("com.moon.extension.poi.model.Applicant");
        Class applicantEduClazz = Class.forName("com.moon.extension.poi.model.ApplicantEdu");
        Class applicantFamilyClazz = Class.forName("com.moon.extension.poi.model.ApplicantFamily");
        Class applicantWorkClazz = Class.forName("com.moon.extension.poi.model.ApplicantWork");
        Field[] applicantFields = applicantClazz.getDeclaredFields();
        for(Field field:applicantFields){
            contentMap.put(field.getName(),condidatesResultMap.get(field.getName()));
        }
        /**
         * 将教育、工作、家庭成员list放到map中
         */
        int i = 1;
        Field[] applicantEduFields = applicantEduClazz.getDeclaredFields();
        for(Map<String,Object> map:condidatesEduMap){
            for(Field field:applicantEduFields){
                contentMap.put(field.getName()+i,map.get(field.getName()));
            }
        }
        int j = 1;
        Field[] applicantWorkFields = applicantWorkClazz.getDeclaredFields();
        for(Map<String,Object> map:condidatesWorkMap){
            for(Field field:applicantWorkFields){
                contentMap.put(field.getName()+j,map.get(field.getName()));
            }
        }
        int m = 1;
        Field[] applicantFamilyFields = applicantFamilyClazz.getDeclaredFields();
        for(Map<String,Object> map:condidatesFamilyMap){
            for(Field field:applicantFamilyFields){
                contentMap.put(field.getName()+m,map.get(field.getName()));
            }
        }
    }
}
