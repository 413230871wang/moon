package com.moon.base.basic.collection;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Description TODO
 * @Author lay
 * @Date 2019-06-28 16:21
 * @Version 1.0
 **/
public class DateTest {
    public static void main(String[] args) throws ParseException {
//        Date end = getDateByString("yyyy-MM-dd","2019-11-16");
//        Date start = getDateByString("yyyy-MM-dd","2019-06-16");
//        long a = getDays(start,end);
//        System.out.println(a);
//
//        String str = "王磊"+"\n"+"很帅";
//        System.out.println(str);

        BigDecimal a = new BigDecimal(12.55);
        System.out.println(a.divide(new BigDecimal(1),1,BigDecimal.ROUND_HALF_UP));
    }

    public static long getDays(Date begin, Date end){
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        long endTime = cal.getTimeInMillis();
        cal.setTime(begin);
        long startTime = cal.getTimeInMillis();
        long time = endTime - startTime;
        return  time / (1000 * 24 * 3600);
    }

    public static Date getDateByString(String pattern,String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateStr);
        return date;
    }
}
