package com.yui.system.image.common.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片rgb Dao
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
@Getter
public class ImageRgbDao extends RgbDao {
    private int x ;
    private int y;
    private String md5;
    public ImageRgbDao(int x, int y, int pixel) {
        super(pixel);
        this.x = x;
        this.y = y;
    }
    public ImageRgbDao(int x, int y, String md5) {
        super(0);
        this.x = x;
        this.y = y;
        this.md5 = md5;
    }

    public ImageRgbDao(int x, int y, int rad, int green, int blue) {
        super(rad, green, blue);
        this.x = x;
        this.y = y;
    }
}
