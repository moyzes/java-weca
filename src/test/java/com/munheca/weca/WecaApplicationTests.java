package com.munheca.weca;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.munheca.weca.modelos.LeArff;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WecaApplicationTests {
	
	@Autowired
	LeArff leArff;
	
	@Test
	public void contextLoads() throws IOException {
		leArff.arffReader();
	}

}
