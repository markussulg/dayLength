package com.internship.dayLength;

import com.internship.dayLength.api.ResponseBody;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MainApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void getDayLength() throws IOException, InterruptedException {
		final ResponseBody testResponse = MainApplication.getDayLength("36,72", "-4.42", "today");
		assertEquals(testResponse.getStatus(), "OK");
	}

}
