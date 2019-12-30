package com.moon.base.basic.annotation;

import com.moon.base.basic.classload.CheckParamUtils;

/**
 * @ClassName AnnotationTest
 * @Description
 * @Author lay
 * @Date 2019-10-18 10:45
 * @Version 1.0
 **/
public class AnnotationTest {
    public static void main(String[] args) throws Exception{
        TFqlTwoLoanApply tFqlTwoLoanApply = new TFqlTwoLoanApply();
        tFqlTwoLoanApply.setListId("1234");
        System.out.println(CheckParamUtils.checkParamPublic(tFqlTwoLoanApply));
    }
}
