package com.moon.base.basic.leetcode;

import java.util.Arrays;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/23 11:20 上午
 */
public class FindMedian {
    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
        int num1Len = num1.length;
        int num2Len = num2.length;
        num1 = Arrays.copyOf(num1,num1Len+num2Len);
        System.arraycopy(num2,0,num1,num1Len,num2Len);
        Arrays.sort(num1);
        int endLength = num1.length;
        double median;
        if(endLength % 2 != 0){
            median = num1[endLength/2];
        }else{
            median = (double)(num1[endLength/2-1]+num1[endLength/2])/2;
        }

        System.out.println(median);
//        System.out.println(Math.(9,5));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
