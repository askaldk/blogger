package com.jeff.common.entity;

import lombok.Data;

/**
 * 分頁實體類
 */
@Data
public class BasePage {

    /**
     * 當前每頁顯示數
     */
    private Integer size;

    /**
     * 當前頁數
     */
    private Integer current;
}
