package com.moon.base.basic.leetcode;

import java.util.*;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/22 2:12 下午
 */
public class NoRepeatMaxString {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int getMaxByList(String str) {
        String s = "au";
        if (s != null && s.length() > 0 && s.trim() != "") {
            if ("".equals(s.trim())) {

            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String subStr = s.substring(i, j);
                    char x = s.charAt(j);
                    if (subStr.contains(String.valueOf(x))) {
                        list.add(subStr);
                        break;
                    }
                    if (j == s.length() - 1) {
                        list.add(s.substring(i, j + 1));
                        break;
                    }
                }
            }
            Comparator<String> comparable = (aStr, bStr) -> aStr.length() - bStr.length();

            Collections.sort(list, Comparator.comparing(String::length));
            String as = new String();
            if (list != null && list.size() > 0) {
                as = list.get(list.size() - 1);
            }
            return as.length();
        }else{
            return 0;
        }
    }
}
