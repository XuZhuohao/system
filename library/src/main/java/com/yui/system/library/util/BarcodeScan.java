package com.yui.system.library.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

/**
 * 条形码扫描
 *
 * @author XuZhuohao
 * @date 2018-12-02 7:09
 */
public class BarcodeScan {

    private static final String CHAR_UTF8 = "utf-8";

    /**
     * 条形码扫描
     * @param filePath 文件路径
     * @return 条形码
     */
    public static String getQRresult(String filePath) {
        /**
         * 如果用的jdk是1.9，需要配置下面这一行。
         * System.setProperty("java.specification.version", "1.9")
         */
        Result result = null;
        try {
            File file = new File(filePath);

            BufferedImage bufferedImage = ImageIO.read(file);
            result = getResult(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return result.getText();
    }
    /**
     * 条形码扫描
     * @param is InputStream
     * @return 条形码
     */
    public static String getQRresult(InputStream is){
        Result result = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(is);
            result = getResult(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return result.getText();
    }

    private static Result getResult(BufferedImage bufferedImage) throws NotFoundException {
        Result result;
        BinaryBitmap bitmap = new BinaryBitmap(
                new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

        HashMap hints = new HashMap<>(16);
        hints.put(EncodeHintType.CHARACTER_SET, CHAR_UTF8);
        result = new MultiFormatReader().decode(bitmap, hints);
        return result;
    }
}
