package com.example.demo.leetCode.p5;

public class huiwen {

    public static void main(String args[]){
        System.out.println(longestPalindrome("rytrydrfssssswtrsdfsdf"));
    }


    //计算最长回文字符串
    public static String longestPalindrome(String s) {
        if ("".equals(s) || s.length() == 1){
            return s;
        }

        char[] c = s.toCharArray();
        int max = 0;
        for (int i=0; i< c.length; i ++){
            int maxLength = getLength(max);
            if (maxLength >= ((c.length -(i+1))*2 +1)){
                return s.substring(getLeft(max),getRight(max)+1);
            }
            int one = checkOne(c,i);
            int two = checkTwo(c,i);
            int twoMax = getLength(one) > getLength(two) ? one : two;
            max = maxLength < getLength(twoMax) ? twoMax : max;
        }
        return s.substring(getLeft(max),getRight(max)+1);
    }

    private static int checkOne(char[] c, int i){
        int k = 1;
        while (true){
            if ((i-k < 0 || i+k == c.length) || c[i-k] != c[i+k]){
                return toTwoCode(i-k+1,i+k-1);
            }
            k++;
        }
    }

    private static int checkTwo(char[] c, int i){
        int m = i + 1;
        int k = 1;
        if (m == c.length || c[m] != c[i]){
            return 0;
        }
        while (true){
            if ((i-k < 0 || m+k == c.length) || c[i-k] != c[m+k]){
                return toTwoCode(i-k+1,m+k-1);
            }
            k++;
        }
    }

    private static int getLeft(int i){
        i = i>>16;
        return i;
    }

    private static int getRight(int i){
        return i & 0X0000FFFF;
    }

    private static int getLength(int i){
       return getRight(i) - getLeft(i) + 1;
    }

    private static int toTwoCode(int left, int right){
        left = left << 16;
        return left + right;
    }

}
