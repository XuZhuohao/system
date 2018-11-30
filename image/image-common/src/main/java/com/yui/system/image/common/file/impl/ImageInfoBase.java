package com.yui.system.image.common.file.impl;

import com.alibaba.fastjson.JSON;
import com.yui.system.image.common.dao.BoxDao;
import com.yui.system.image.common.dao.ImageRgbDao;
import com.yui.system.image.common.file.ImageInfo;
import com.yui.system.image.common.util.Md5Util;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片信息
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
public class ImageInfoBase implements ImageInfo {
    @Getter
    BufferedImage bufferedImage;
    private boolean allMatrixTag = true;
    @Getter
    private int marginW;
    @Getter
    private int marginH;

    /**
     * 图片色彩的二维矩阵
     */
    List<List<ImageRgbDao>> rgbMatrix = new ArrayList<>();

    public ImageInfoBase(File file) {
        try {
            this.bufferedImage = ImageIO.read(file);
            // 构建RGB二维矩阵
            //this.buildRgbMatrix();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void buildRgbMatrix(int w, int h) {
        int width = this.bufferedImage.getWidth();
        int height = this.bufferedImage.getHeight();
        this.marginW = width / w;
        this.marginH = width / h;
        for (int y = 0; y < height; y += this.marginH) {
            List<ImageRgbDao> line = new ArrayList<>(16);
            for (int x = 0; x < width; x += this.marginW) {
                String md5 = getMd5(this.marginW, x, this.marginH, y);
                line.add(new ImageRgbDao(x, y, md5));
                System.out.println(md5);
            }
            this.rgbMatrix.add(line);
        }
        System.out.println("==========================");
        this.allMatrixTag = false;
    }

    private String getMd5(int marginW, int startW, int marginH, int startH) {
        StringBuffer result = new StringBuffer();
        for (int y = startH; y < startH + marginH && y < this.getBufferedImage().getHeight(); y++) {
            for (int x = startW; x < startW + marginW && x < this.getBufferedImage().getWidth(); x++) {
                result.append(this.bufferedImage.getRGB(x, y));
            }
        }
        return Md5Util.encodeByMD5(result.toString());
    }

    /**
     * 构建色彩的二维矩阵
     */
    @Override
    public void buildRgbMatrix() {
        int width = this.bufferedImage.getWidth();
        int height = this.bufferedImage.getHeight();
        System.out.printf("width:%d, height:%d \r\n", width, height);
        for (int y = 0; y < height; y++) {
            List<ImageRgbDao> line = new ArrayList<>(16);
            for (int x = 0; x < width; x++) {
                try {
                    line.add(new ImageRgbDao(x, y, this.bufferedImage.getRGB(x, y)));
                } catch (Exception e) {
                    System.out.printf("x:%d, y:%d", x, y);
                    e.printStackTrace();
                    throw new RuntimeException(e.getLocalizedMessage());
                }
            }
            this.rgbMatrix.add(line);
        }
        this.allMatrixTag = true;
    }

    @Override
    public List<List<ImageRgbDao>> getRgbMatrix() {

        return this.rgbMatrix;
    }

    @Override
    public List<ImageRgbDao> getDifferentMatrix(List<List<ImageRgbDao>> rgbMatrix) {
        List<ImageRgbDao> result = new ArrayList<>(16);
        for (int y = 0; y < this.rgbMatrix.size() && y < rgbMatrix.size(); y++) {
            List<ImageRgbDao> imageRgbDao = this.rgbMatrix.get(y);
            List<ImageRgbDao> otherImageRgbDao = rgbMatrix.get(y);
            for (int x = 0; x < imageRgbDao.size() && x < otherImageRgbDao.size(); x++) {
                if (this.allMatrixTag){
                    if (imageRgbDao.get(x).getRgb() != otherImageRgbDao.get(x).getRgb()) {
                        result.add(imageRgbDao.get(x));
                    }
                } else{
                    if (!imageRgbDao.get(x).getMd5().equals(otherImageRgbDao.get(x).getMd5())) {
                        result.add(imageRgbDao.get(x));
                    }
                }

            }
        }
        return result;
    }
}
