package com.jeff.core.controller;


import com.jeff.core.entity.UserEntity;
import com.jeff.core.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.jeff.common.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jeff
 * @since 2023-02-13
 */
@RestController
@RequestMapping("/user-entity")
public class UserController extends BaseController<UserService, UserEntity> {

}
