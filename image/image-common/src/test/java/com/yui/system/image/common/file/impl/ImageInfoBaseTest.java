package com.yui.system.image.common.file.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yui.system.image.common.dao.BoxDao;
import com.yui.system.image.common.dao.ImageRgbDao;
import com.yui.system.image.common.dao.RgbDao;
import com.yui.system.image.common.file.ImageInfo;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ImageInfoBaseTest {

    @Test
    public void getDifferentMatrix() throws IOException {
        ImageInfo imageInfo1 = new ImageInfoBase(new File("D:\\data\\image-util\\t11.jpg"));
        ImageInfo imageInfo2 = new ImageInfoBase(new File("D:\\data\\image-util\\t12.jpg"));
        List<ImageRgbDao> differentMatrix = imageInfo1.getDifferentMatrix(imageInfo2.getRgbMatrix());
        List<ImageRgbDao> differentBox = new ArrayList<>(16);
        int width = 200;
        System.out.println(differentMatrix.size());
        // sorted(Comparator.comparing(Icon::getId))
        differentMatrix.stream()
                .sorted(Comparator.comparing(imageRgbDao -> imageRgbDao.getX() + imageRgbDao.getY()))
                .collect(Collectors.toList())
                .forEach(imageRgbDao -> {
                    for (ImageRgbDao igd : differentBox) {
                        if (imageRgbDao.getX() > igd.getX() && imageRgbDao.getX() < (igd.getX() + width)
                                && imageRgbDao.getY() > igd.getY() && imageRgbDao.getY() < (igd.getY() + width))
                            return;
                    }
                    differentBox.add(imageRgbDao);
//                    System.out.println(differentBox.size())
                });

        differentBox.forEach(imageRgbDao -> {
            for (int i = imageRgbDao.getX(); i < imageRgbDao.getX() + width; i++) {
                imageInfo1.getBufferedImage().setRGB(i, imageRgbDao.getY(), 0);
                imageInfo1.getBufferedImage().setRGB(i, imageRgbDao.getY() + width, 0);
            }
            for (int i = imageRgbDao.getY(); i < imageRgbDao.getY() + width; i++) {
                imageInfo1.getBufferedImage().setRGB(imageRgbDao.getX(), i, 0);
                imageInfo1.getBufferedImage().setRGB(imageRgbDao.getX() + width, i, 0);
            }
        });

        imageInfo1.getBufferedImage();
        File file = new File("D:\\data\\image-util\\test.jpg");
        ImageIO.write(imageInfo1.getBufferedImage(), "jpg", file);

    }

    @Test
    public void getDifferentMatrix02() throws IOException {
        ImageInfo imageInfo1 = new ImageInfoBase(new File("D:\\data\\image-util\\t11.jpg"));
        ImageInfo imageInfo2 = new ImageInfoBase(new File("D:\\data\\image-util\\t12.jpg"));

        imageInfo1.buildRgbMatrix(10,10);
        imageInfo2.buildRgbMatrix(10,10);
        final List<ImageRgbDao> differentMatrix = imageInfo1.getDifferentMatrix(imageInfo2.getRgbMatrix());

        differentMatrix.forEach(imageRgbDao -> {
            drawBox(imageInfo1, imageRgbDao);
        });

        imageInfo1.getBufferedImage();
        File file = new File("D:\\data\\image-util\\test.jpg");
        ImageIO.write(imageInfo1.getBufferedImage(), "jpg", file);

    }

    private void drawBox(ImageInfo imageInfo1, ImageRgbDao imageRgbDao) {
        int width = imageInfo1.getMarginW();
        int height = imageInfo1.getMarginH();
        int x = (imageRgbDao.getX() + width) >= imageInfo1.getBufferedImage().getWidth()? (imageInfo1.getBufferedImage().getWidth() - 1) : (imageRgbDao.getX() + width);
        int y = (imageRgbDao.getY() + height) >= imageInfo1.getBufferedImage().getHeight()? (imageInfo1.getBufferedImage().getHeight() - 1) : (imageRgbDao.getY() + height);
        for (int i = imageRgbDao.getX(); i < imageRgbDao.getX() + width && i < imageInfo1.getBufferedImage().getWidth(); i++) {
            imageInfo1.getBufferedImage().setRGB(i, imageRgbDao.getY(), 0);
            imageInfo1.getBufferedImage().setRGB(i, y, 0);
        }
        for (int i = imageRgbDao.getY(); i < imageRgbDao.getY() + height && i < imageInfo1.getBufferedImage().getHeight(); i++) {
            imageInfo1.getBufferedImage().setRGB(imageRgbDao.getX(), i, 0);
            imageInfo1.getBufferedImage().setRGB(x, i, 0);
        }
    }


}