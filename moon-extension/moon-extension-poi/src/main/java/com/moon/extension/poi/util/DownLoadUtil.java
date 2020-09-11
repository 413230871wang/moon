package com.moon.extension.poi.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/27 4:31 下午
 */
public class DownLoadUtil {
public static String downloadFile(String downloadFilePath,String fileName,HttpServletResponse response){
   File file = new File(downloadFilePath);
    if (file.exists()) {
      response.setContentType("application/force-download");// 设置强制下载不打开      
      response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
      byte[] buffer = new byte[1024];
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      try {
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream outputStream = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
          outputStream.write(buffer, 0, i);
          i = bis.read(buffer);
        }
       
        return "下载成功";
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (bis != null) {
          try {
            bis.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (fis != null) {
          try {
            fis.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  return "下载失败";
  }
}
