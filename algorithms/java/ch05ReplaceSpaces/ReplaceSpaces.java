// Source : https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
// Author : cornprincess
// Date   : 2020-07-17

/***************************************************************************************************** 
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * 示例 1：
 * 
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 
 * 限制：
 * 
 * 0 <= s 的长度 <= 10000
 ******************************************************************************************************/

package ch05ReplaceSpaces;

public class ReplaceSpaces {
    /*
     * use support char array
     * time complexity O(n)
     * space complexity O(n)
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        int length = s.length();
        char[] chars = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }
        return new String(chars, 0, size);
    }

    /*
     * use two pointers, one point to the end of old string, one point to the end of new string
     * time complexity O(n)
     * space complexity O(n)
     */
    public String replaceSpace2(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        int numberOfBlank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                numberOfBlank++;
            }
        }

        int newLength = s.length() + numberOfBlank * 2;
        char[] tempChars = new char[newLength];
        for (int i = 0; i < s.length(); i++) {
            tempChars[i] = s.charAt(i);
        }

        int indexOfOriginal = s.length() - 1;
        int indexOfNew = newLength - 1;
        while (indexOfNew >= 0 && indexOfOriginal >= 0) {
            if (tempChars[indexOfOriginal] == ' ') {
                tempChars[indexOfNew--] = '0';
                tempChars[indexOfNew--] = '2';
                tempChars[indexOfNew--] = '%';
            } else {
                tempChars[indexOfNew--] = tempChars[indexOfOriginal];
            }
            indexOfOriginal--;
        }

        return new String(tempChars);
    }

    public String replaceSpace3(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        int numberOfBlank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                numberOfBlank++;
            }
        }
        // 如果是 c++ 可以直接使用resize 方法进行更改字符串长度，即c++的字符串是可变的
        // 因为是 Java，所以这里使用一个新的数组
        int newLength = s.length() + numberOfBlank * 2;
        char[] temp = new char[newLength];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i);
        }

        int indexOfOriginal = s.length() - 1;
        int indexOfNew = newLength - 1;

        while (indexOfOriginal >= 0) {
            if (temp[indexOfOriginal] == ' ') {
                temp[indexOfNew--] = '0';
                temp[indexOfNew--] = '2';
                temp[indexOfNew--] = '%';
            } else {
                temp[indexOfNew--] = temp[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return new String(temp);
    }
}
