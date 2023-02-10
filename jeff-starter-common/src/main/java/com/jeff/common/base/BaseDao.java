package com.jeff.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 基礎的 Dao 通用接口
 * @param <Pojo>
 */

public interface BaseDao<Pojo> extends BaseMapper<Pojo> {

}