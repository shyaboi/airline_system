package com.ss.flights.flights;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ss.flights.DBConnection.DeleteRow.DelWR;
import com.ss.flights.flights.AdminRoutes.DeleteRoutes.DeleteRoutes;
import com.ss.flights.flights.AdminRoutes.UpdateRoutes.UpdateRoutes;

@WebMvcTest(DeleteRoutes.class)
class FlightsApplicationTests {

	// Post tests
	// =================================================================================================

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ApplicationContext applicationContext;

	@MockBean
	private FlightsApplication flightsApplication;

	@Test
	public void shouldReturnOKDelete() throws Exception {
		MvcResult result = mockMvc
				.perform(delete("/admin/airport/iata_id/ZZZ").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAddFlight() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/admin/addFlight").contentType(MediaType.APPLICATION_JSON)
						.content("4,2,1,20210211102222,33,200"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAirport() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/admin/addAirport").contentType(MediaType.APPLICATION_JSON)
						.content("airport,iata_id='ZZZ'"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKUpdate() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/admin/updateRow").contentType(MediaType.APPLICATION_JSON)
						.content("ariport,iata_id='ZZZ',city=Lingenberry"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKPassanger() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/admin/addPassenger").contentType(MediaType.APPLICATION_JSON)
						.content("9,2,'name','fam',19990222,'F','123 faker st'"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKBooking() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/admin/addBooking").contentType(MediaType.APPLICATION_JSON).content("2,3,'45364"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}


	// END Post tests
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	// Get tests
	// =================================================================================================

	@Test
	public void shouldReturnOKAllAir() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allAirports").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllFlights() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allFlights").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllBookings() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allBookings").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllPassengers() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allPassengers").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllEmployees() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allEmployees").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllUsers() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allUsers").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllAirplanes() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allAirplanes").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllAirplaneTypes() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allAirplaneTypes").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void shouldReturnOKAllRoutes() throws Exception {
		MvcResult result = mockMvc.perform(get("/admin/allRoutes").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	// END Get tests
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}

	// @Test
	// void exceptionTesting(ArrayList<String> airports) {
	// // set up user
	// GetAllDataTable getAll = new GetAllDataTable();
	// String[] dataList = { "iata_id", "city" };

	// Throwable exception = assertThrows(IllegalArgumentException.class, () ->
	// getAll.getTableData(airports, "ai",dataList));
	// assertEquals("Age must be an Integer.", exception.getMessage());
	// }

}
