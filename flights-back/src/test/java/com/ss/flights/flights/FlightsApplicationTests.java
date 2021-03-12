package com.ss.flights.flights;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(FlightsApplication.class)
class FlightsApplicationTests {


	@Autowired
	private MockMvc mvc;

	@MockBean
	private FlightsApplication flightsApplication;

	@Test
	public void shouldReturnOKDelete() throws Exception {
		MvcResult result = mvc
				.perform(delete("/admin/airport/iata_id/ZZZ").contentType(MediaType.APPLICATION_JSON).content("secret"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAddFlight() throws Exception {
		MvcResult result = mvc
				.perform(post("/admin/flight").contentType(MediaType.APPLICATION_JSON)
						.content("4,2,1,20210211102222,33,200"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAirport() throws Exception {
		MvcResult result = mvc
				.perform(post("/admin/airport").contentType(MediaType.APPLICATION_JSON).content("'airport','ZZZ'"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKPassanger() throws Exception {
		MvcResult result = mvc
				.perform(post("/admin/passenger").contentType(MediaType.APPLICATION_JSON)
						.content("9,2,'name','fam',19990222,'F','123 faker st'"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKBooking() throws Exception {
		MvcResult result = mvc
				.perform(post("/admin/booking").contentType(MediaType.APPLICATION_JSON).content("2,3,'45364"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}



	@Test
	public void shouldReturnOKAllAir() throws Exception {
		MvcResult result = mvc.perform(get("/admin/airport").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllFlights() throws Exception {
		MvcResult result = mvc.perform(get("/admin/flight").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllBookings() throws Exception {
		MvcResult result = mvc.perform(get("/admin/booking").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllPassengers() throws Exception {
		MvcResult result = mvc.perform(get("/admin/passenger").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllEmployees() throws Exception {
		MvcResult result = mvc.perform(get("/admin/employee").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllUsers() throws Exception {
		MvcResult result = mvc.perform(get("/admin/users").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllAirplanes() throws Exception {
		MvcResult result = mvc.perform(get("/admin/airplanes").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}


	@Test
	public void shouldReturnOKGetEmployee() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/admin/employee").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.employee").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.employee[*].employee_Id").isNotEmpty());
	}

	@Test
	public void shouldReturnOKGetAirport() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/admin/airport").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void tryThing() throws Exception {
		mvc.perform(get("/admin/airport")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}


}
