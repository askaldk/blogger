package com.jeff.core.service.impl;

import com.jeff.core.entity.UserEntity;
import com.jeff.core.dao.UserDao;
import com.jeff.core.service.UserService;
import com.jeff.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jeff
 * @since 2023-02-13
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {

}
