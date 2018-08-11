package com.munheca.weca;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.munheca.weca.modelos.CriarArff;
import com.munheca.weca.modelos.LeArff;
import com.munheca.weca.modelos.ManualJ48;
import com.munheca.weca.modelos.ManualKMeans;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WecaApplicationTests {
	
	@Autowired
	LeArff leArff;
	
	@Autowired
	CriarArff criarArff;
	
	@Autowired
	ManualJ48 manualJ48;
	
	@Autowired
	ManualKMeans manualKMeans;
	
	@Test
	public void rodarLeArff() throws IOException {
		leArff.arffReader();
	}
	
	@Test
	public void rodarCriarArff() throws IOException {
		criarArff.arffCreator();
	}
	
	@Test
	public void rodarManualJ48() throws IOException {
		manualJ48.doJ48();
	}
	
	@Test
	public void rodarManualKmeans() throws Exception {
		manualKMeans.runKmeans();
	}

}
