package com.yui.system.image.common.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * rgb样式
 * 以(255, 254, 253)为例
 * Hex表示为 0xfffefd 其中 ff表示红色的值，fe表示绿色的值， fd表示蓝色的值
 * 16进制表示，每一个16进制的值为四个二进制位，每8个二进制位为一个色值
 * 计算 红色 rad = pixel >> 16; 表示把 0xfffefd 向有移动16个二进制位(4位16进制)，变为 0xff 则为 红色的值
 * 计算 蓝色 green = (pixel & 0xff00) >> 8 ; 其中 pixel & 0xff00 === pixel & 0x00ff00，表示先去除其他位的值的影响，主要是去除
 *      红色的值的影响，因为红色的值在蓝色的左边。
 * 计算 绿色 同理
 * @author XuZhuohao
 * @date 2018/11/30
 */
@Getter
public class RgbDao {
    @Setter
    int rad;
    @Setter
    int green;
    @Setter
    int blue;

    public RgbDao(int pixel) {
//        this.rad = (pixel & 0xff0000) >> 16
        this.rad = pixel >> 16;
        this.green = (pixel & 0xff00) >> 8;
        this.blue = (pixel & 0xff);
    }

    public RgbDao(int rad, int green, int blue) {
        this.rad = rad;
        this.green = green;
        this.blue = blue;
    }

    public int getRgb(){
        return (this.rad << 16) + (this.green << 8) + this.blue ;
    }

}
