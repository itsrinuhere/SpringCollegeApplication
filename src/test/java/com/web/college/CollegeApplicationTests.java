package com.web.college;

import Utility.Utility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class CollegeApplicationTests {
	  Utility ut = new Utility();
		@Test
		void dateChecker(){
			assertTrue(ut.isYearFormat("1990-2023"));
		}
//	@Test
//	void contextLoads() {
//	}

}
