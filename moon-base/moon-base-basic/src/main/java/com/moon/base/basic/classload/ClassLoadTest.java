package com.moon.base.basic.classload;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @ClassName ClassLoadTest
 * @Description
 * @Author lay
 * @Date 2019-10-12 11:53
 * @Version 1.0
 **/
public class ClassLoadTest {
    public static void main(String[] args) {
        System.out.println(getExtDirs());
    }

    private static File[] getExtDirs() {
        String var0 = System.getProperty("java.ext.dirs");
        File[] var1;
        if (var0 != null) {
            StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
            int var3 = var2.countTokens();
            var1 = new File[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
                var1[var4] = new File(var2.nextToken());
            }
        } else {
            var1 = new File[0];
        }

        return var1;
    }
}
