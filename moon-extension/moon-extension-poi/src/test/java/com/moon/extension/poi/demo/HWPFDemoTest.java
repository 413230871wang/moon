package com.moon.extension.poi.demo;

import com.moon.extension.poi.Application;
import com.moon.extension.poi.mapper.ApplicantMapper;
import com.moon.extension.poi.mapper.ResultTestMapper;
import com.moon.extension.poi.util.XWPFUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HWPFDemoTest {
    @Autowired
    private ApplicantMapper applicantMapper;
    @Autowired
    private ResultTestMapper resultTestMapper;

    @Test
    public void docxExportTest() throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //获取docx解析对象
            is = new FileInputStream("/Users/mfhj-dz-001-068/Desktop/beebank文档/poi下载文档/应聘人员登记表.docx");
            XWPFDocument document = new XWPFDocument(is);
            
            //组装参数
//            File seal = new File("F:\\imgtest\\1.jpg");
//            Map<String, Object> sealMap = new HashMap<String, Object>();
//            sealMap.put("width", 50);
//            sealMap.put("height", 50);
//            sealMap.put("type", "jpg");
//            sealMap.put("content", new FileInputStream(seal));

            Map<String,Object> resultMap = resultTestMapper.selectMapByPrimaryKey("123");

            Map<String, Object> contentMap = new HashMap<>();
            Class clazz = Class.forName("com.moon.extension.poi.model.ResultTest");
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                contentMap.put(field.getName(),resultMap.get(field.getName()));
            }

            //解析替换段落文本对象
            XWPFUtils.changeParagraph(document, contentMap);

            //生成新的word文档
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fileName = "性格测试题-" + sdf.format(new Date()) + ".docx";
            File file = new File("/Users/mfhj-dz-001-068/Desktop/beebank文档/poi下载文档/" + fileName);
            fos = new FileOutputStream(file);
            document.write(fos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}