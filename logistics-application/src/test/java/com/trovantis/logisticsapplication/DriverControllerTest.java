
package com.trovantis.logisticsapplication;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.driver.Driver;
import com.trovantis.logisticsapplication.driver.DriverService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

@AutoConfigureMockMvc
public class DriverControllerTest {

	@MockBean
	DriverService driverService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void post_addDriver() throws Exception {
		Driver driver = new Driver();
		driver.setGivenName("dsdsfsdf");
		driver.setFamilyName("dssgs");
		driver.setPhoneNo("124567891");
		driver.setVehicleNo("fsdfsd456");
		driver.setData(Base64.encodeBase64(FileUtils.readFileToByteArray(new File("C:/Users/srikanth/Desktop/logistics-application/logistics-application/src/test/java/com/trovantis/logisticsapplication/bags.jpg"))));
		driver.setOrderId(1);
		
		Mockito.when(driverService.saveDriver(driver)).thenReturn(driver);

		mockMvc.perform(post("/add-driver").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(driver)))
				.andExpect(status().isOk());


	}

}
