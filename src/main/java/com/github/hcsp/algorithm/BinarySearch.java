package com.github.hcsp.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb"));
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy"));
        System.out.println(recursiveBinarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb", 0, 4));
        System.out.println(recursiveBinarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy", 0, 4));

    }

    // 给定一个按照字符串升序升序排好序的用户数组，寻找目标字符串的位置，返回其索引值
    // 如果未找到，返回-1
    // 我们鼓励你使用递归和非递归两种方式
    public static int binarySearch(String[] strings, String target) {
        int start = 0;
        int end = strings.length - 1;

        while (start <= end) {
            int min = (start + end) / 2;
            String minValue = strings[min];
            if (target.compareTo(minValue) > 0) {
                start = min + 1;
            } else if (target.compareTo(minValue) < 0) {
                end = min - 1;
            } else if (target.equals(minValue)) {
                return min;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(String[] strings, String target, int start, int end) {
        int min = (start + end) / 2;
        String minValue = strings[min];

        while (start <= end) {
            if (target.compareTo(minValue) > 0) {
                start = min + 1;
                return recursiveBinarySearch(strings, target, start, end);
            } else if (target.compareTo(minValue) < 0) {
                end = min - 1;
                return recursiveBinarySearch(strings, target, start, end);
            } else if (target.equals(minValue)) {
                return min;
            }
        }
        return -1;
    }
}
