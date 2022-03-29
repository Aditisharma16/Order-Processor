package com.orderprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderProcessorApplicationTests {

	@Test
	void contextLoads() {
		
		String obj1="Junit";
		String obj2="Junit";
		assertEquals(obj1,obj2);
	}

}
