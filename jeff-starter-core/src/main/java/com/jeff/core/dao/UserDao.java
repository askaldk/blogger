package com.jeff.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.core.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jeff
 * @since 2023-02-03
 */
@Repository
public interface UserDao extends BaseMapper<User> {


}
