package com.exprivia.stage;

import static org.assertj.core.api.Assertions.assertThat;
import com.exprivia.stage.controller.UserController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StageApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception{
		assertThat(userController).isNotNull();
	}

}
