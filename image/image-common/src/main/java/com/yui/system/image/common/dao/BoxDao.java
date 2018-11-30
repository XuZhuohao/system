package com.yui.system.image.common.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * 框的dao
 *
 * @author XuZhuohao
 * @date 2018/11/30
 */
@Getter
@Setter
public class BoxDao {
    private int startX;
    private int StartY;

    public BoxDao(int startX, int startY) {
        this.startX = startX;
        this.StartY = startY;
    }
}
