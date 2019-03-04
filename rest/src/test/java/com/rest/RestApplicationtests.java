package com.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.rest.controller.UserDtoRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestApplicationtests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRestCreatingNewUser() throws Exception {
		UserDtoRequest dtoRequest = new UserDtoRequest();
		dtoRequest.setApellido("mehdi");
		dtoRequest.setChangeBy("sadasd");
		dtoRequest.setEmail("sdasd@sadsad.com");
		dtoRequest.setEdad("17");
		dtoRequest.setNombre("redouane");
		dtoRequest.setTelefono("234098324");
		dtoRequest.setInscriptionDate("17/09/2019");

		Gson gson = new Gson();

		String json = gson.toJson(dtoRequest);
		this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isCreated());
		
		json = gson.toJson(dtoRequest.getEmail());
		this.mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isCreated());
	}

}