package com.moon.base.basic.classload;


import com.moon.base.basic.annotation.IgnoreParam;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CheckParamUtils
 * @Description TODO 判断参数是否为空
 * @Author lay
 * @Date 2019-04-24 14:53
 * @Version 1.0
 **/
public class CheckParamUtils {
    public static String checkParam(Object obj) {
        List<String> arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.getAnnotation(IgnoreParam.class) != null) {
                    continue;
                }
                //get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
                if (f.get(obj) == null) {
                    arrayList.add(f.getName());
                } else {
                    //如果需要判断空字符串
                    if (StringUtils.isBlank(String.valueOf(f.get(obj)))) {
                        arrayList.add(f.getName());
                    }
                }
            }
            //拼接返回信息
            for (String param : arrayList) {
                stringBuffer.append("参数" + param + "缺失;");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String checkParamPublic(Object obj) {
        List<String> arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                //如果对公，value为yes的被忽略;如果为私，有注解的被忽略
                    if (f.getAnnotation(IgnoreParam.class) != null) {
                        String annValue = f.getAnnotation(IgnoreParam.class).value();
                        if("yes".equals(annValue)) {
                            continue;
                        }
                    }
                //get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
                if (f.get(obj) == null) {
                    arrayList.add(f.getName());
                } else {
                    //如果需要判断空字符串
                    if (StringUtils.isBlank(String.valueOf(f.get(obj)))) {
                        arrayList.add(f.getName());
                    }
                }
            }
            //拼接返回信息
            for (String param : arrayList) {
                stringBuffer.append("参数" + param + "缺失;");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}

