package com.web.college;

import Utility.Utility;
import com.web.college.Student.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class CollegeApplicationTests {
	  Utility ut = new Utility();
	  @Autowired
	StudentService  studentservice;
		@Test
		void dateChecker(){
			assertTrue(ut.isYearFormat("1990-2023"));
		}
		@Test
		void saveDataUsingSQl(){
			String sql= "insert into internship values(?,?,?,?,?,?,?)";
//		int response = studentservice.saveSubData(sql,
//				"12345","Graduate testing inter",
//				"Google","23-09-2021","20-10-2021",
//				"19641a05m8","https://google.com");
//		 assertEquals(response,1);

		}
	@Test
	void contextLoads() {
	}

	@Test
	void testPostMethod() throws SQLException {
			String sql ="insert into internship values(?,?,?,?,?,?,?)";
//
//		int res = studentservice.saveObjectByQuery(sql,
//				"1111","jr developer","Microsoft",
//				"23-2-2022","23-2-2022","121231A123","https://google.com");
//		assertTrue(res>0);
	}
}
