package com.yui.system.image.common.util;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * 图片流工具
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
public class ImageStreamUtil {
    /**
     * 获取图片字节流
     * @param imageFile 图片文件
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream getImageByteArrayStream(File imageFile){
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try(ImageInputStream iis = new FileImageInputStream(imageFile)){
            int length;
            byte[] bytes = new byte[1024];
            while((length = iis.read(bytes)) != -1){
                bao.write(bytes,0,length);
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("ImageStreamUtil.getImageStream() 出错\r\n"
                    + e.getLocalizedMessage());
        }
        return bao;
    }
    /**
     * 获取图片字节流
     * @param path 图片文件路径
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream getImageByteArrayStream(String path){
        File imageFile = new File(path);
        return getImageByteArrayStream(imageFile);
    }

}
