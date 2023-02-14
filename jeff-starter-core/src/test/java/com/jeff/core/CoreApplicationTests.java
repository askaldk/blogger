package com.jeff.core;

import com.jeff.core.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CoreApplicationTests {

	@Resource
	private UserDao userDao;

	@Test
	void testSelectAll(){


	}


}
