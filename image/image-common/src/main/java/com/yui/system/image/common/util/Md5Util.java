package com.yui.system.image.common.util;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 算法工具
 *
 * @author XuZhuohao
 * @date 2018/11/23
 */
public class Md5Util {
    public static void main(String[] args) {

    }

    /**
     * 十六进制下数字到字符的映射数组
     */
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String encodeByMD5(File file) {
        try (InputStream is = new FileInputStream(file)) {
            return encodeByMD5(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    public static String encodeByMD5(InputStream is){
        // 创建具有指定算法名称的信息摘要
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[1024];
            int length;
            // 更新算法数据
            while ((length = is.read(bytes)) != -1) {
                md5.update(bytes, 0, length);
            }
            return byteArrayToHexString(md5.digest());
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    /**
     * 字节数组进行MD5编码
     *
     * @param bytes
     * @return
     */
    public static String encodeByMD5(byte[] bytes) {
        try {
            //创建具有指定算法名称的信息摘要
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            byte[] results = md5.digest(bytes);
            //将得到的字节数组变成字符串返回
            return byteArrayToHexString(results);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    /**
     * 对字符串进行MD5编码
     */
    public static String encodeByMD5(String originString) {
        if (originString != null) {
            return encodeByMD5(originString.getBytes());
        }
        return null;
    }

    /**
     * 轮换字节数组为十六进制字符串
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

}
