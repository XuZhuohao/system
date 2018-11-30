package com.yui.system.image.compare.service;

import java.io.File;

/**
 * 图片比较服务
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
public interface ImageCompareService {
    boolean isSame(File image01, File image02);
}
