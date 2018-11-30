package com.yui.system.image.compare.service.impl;

import com.yui.system.image.common.dao.ImageRgbDao;
import com.yui.system.image.common.file.ImageInfo;
import com.yui.system.image.common.file.impl.ImageInfoBase;
import com.yui.system.image.compare.service.ImageCompareService;

import java.io.File;
import java.util.List;

/**
 * @author XuZhuohao
 * @date 2018/11/30
 */
public class ImageCompareServiceImpl implements ImageCompareService {
    @Override
    public boolean isSame(File imageFile01, File imageFile02) {
        ImageInfo image01 = new ImageInfoBase(imageFile01);
        ImageInfoBase image02 = new ImageInfoBase(imageFile02);
        List<ImageRgbDao> differentMatrix = image01.getDifferentMatrix(image02.getRgbMatrix());

        return false;
    }
}
