package com.example.demo.leetCode.algorithm;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：1,4,7,10,13
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Convert {
    public static String convert(String s, int numRows) {
        int length = s.length() < numRows ? 1 : s.length() / 2;
        char[] items = s.toCharArray();
        char[][] array = new char[numRows][length];
        int x = 0,y = 0;
        boolean flag = true;
        for(int i = 0;i < s.length();i++){
            array[x][y] = items[i];
            x = flag ? x + 1 : x - 1;
            y= flag ? y : y + 1;
            if(x == numRows -1){
                flag = false;
            }
            if(x == 0){
                flag = true;
            }
        }

        StringBuilder sBuilder = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0;j < array[i].length;j++){
                sBuilder.append(array[i][j]);
            }
        }

        return sBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
