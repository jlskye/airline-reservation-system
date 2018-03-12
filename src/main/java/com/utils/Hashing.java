package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

//哈希加密算法
public class Hashing {


    public static String salt() {
        //随机一个盐化值
        Random r = new Random();
        String temp = "";
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        //盐化值转换为string
        temp = sb.toString();
        return temp;
    }


    public static String SHA(String strText, String strType) {
        String strResult = null;

        if (strText != null && strText.length() > 0) {
            try {
                //设置加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                //设置明文
                messageDigest.update(strText.getBytes());
                //得到密文byte数组
                byte byteBuffer[] = messageDigest.digest();
                //将byte转换为string
                StringBuffer strHexString = new StringBuffer();
                //遍历bytebuffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }
}

