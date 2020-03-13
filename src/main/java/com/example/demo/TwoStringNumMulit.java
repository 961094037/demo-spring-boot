package com.example.demo;

import java.util.Scanner;

public class TwoStringNumMulit {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        if ("0".equals(num1) || "0".equals(num2)){
            System.out.println("0");
        }else {
            char[] ac = num1.toCharArray();
            char[] bc = num2.toCharArray();
            int[] all = new int[ac.length + bc.length];

            for (int i = num1.length()-1; i >= 0; i--){
                int aNum = ac[i] - '0';
                int abit = num1.length() - i;
                for (int k = num2.length()-1; k >= 0; k--){
                    int bNum = bc[k] - '0';
                    int bbit = num2.length() - k;
                    int bit = abit + bbit - 2;
                    int mulitNum = aNum * bNum;
                    if (mulitNum > 9){
                        //加小
                        add(all, mulitNum%10, bit);
                        //加大
                        add(all, mulitNum/10, bit+1);
                    }else if (mulitNum > 0){
                        //加小
                        add(all, mulitNum%10, bit);
                    }
                }
            }

            int num = all.length;
            if (all[all.length -1] == 0){
                num -= 1;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < num; i++){
                stringBuilder.append(all[i]);
            }
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }
    }

    private static void add(int[] all, int num, int bit){
        int addnum = all[bit] + num;
        all[bit] = addnum%10;
        if (addnum > 9){
            add(all, addnum/10, bit+1);
        }
    }
}
