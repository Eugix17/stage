package com.exprivia.stage;

import com.exprivia.stage.entities.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class UserControllerTest extends AbstractTest{

	@BeforeEach
	@Override
	public void setUp() {
	   super.setUp();
	}

	@Test
	public void getUsersList() throws Exception {
		String url = "/user/getusers";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User[] userList = super.mapFromJson(content, User[].class);
		assertTrue(userList.length > 0);
	}

	@Test
	public void createUser() throws Exception {
		String url = "/user/createuser";
		User user = new User("test", "test", "test", "test");

		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "User is created successfully");
	}

	@Test
	public void updateUser() throws Exception {
		String url = "/user/updateuser/1";
		User user = new User("test", "test", "test", "test");

		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "User is updated successfully");
	}

	@Test
	public void deleteUser() throws Exception {
		String url = "/user/deleteuser/1";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "User is deleted successfully");
	}
}
