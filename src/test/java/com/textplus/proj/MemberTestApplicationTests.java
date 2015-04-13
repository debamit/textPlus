package com.textplus.proj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.textplus.proj.MemberTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MemberTestApplication.class)
@WebAppConfiguration
public class MemberTestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
