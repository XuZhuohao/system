package com.yui.system.image.common.file;

import com.yui.system.image.common.dao.BoxDao;
import com.yui.system.image.common.dao.ImageRgbDao;
import com.yui.system.image.common.dao.RgbDao;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 图片信息
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
public interface ImageInfo {
    /**
     * 获取文件buffered
     * @return BufferedImage
     */
    BufferedImage getBufferedImage();
    int getMarginW();
    int getMarginH();
    /**
     * 获取文件的rgb矩阵
     * @return RgbMatrix
     */
    List<List<ImageRgbDao>> getRgbMatrix();

    /**
     * 获取差异的矩阵
     * @param rgbMatrix 对比的矩阵
     * @return 差异矩阵对象集合
     */
    List<ImageRgbDao> getDifferentMatrix(List<List<ImageRgbDao>> rgbMatrix);

    void buildRgbMatrix(int w, int h);

    void buildRgbMatrix();

}
