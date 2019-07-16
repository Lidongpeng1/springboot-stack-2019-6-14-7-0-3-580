package com.tw.apistackbase;

import org.junit.Test;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class ApiStackBaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void contextLoads() throws Exception{
		this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("helloworld")));

	}

}
