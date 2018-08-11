package com.munheca.weca.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munheca.weca.modelos.CriarArff;
import com.munheca.weca.modelos.LeArff;
import com.munheca.weca.modelos.ManualJ48;
import com.munheca.weca.modelos.ManualKMeans;

@RestController
public class RestAPI {
	
	@Autowired
	LeArff leArff;
	
	@Autowired
	CriarArff criarArff;
	
	@Autowired
	ManualJ48 manualJ48;
	
	@Autowired
	ManualKMeans manualKMeans;
	
	@RequestMapping(value = "/leArff", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
    public String leArff() throws IOException {
        return leArff.arffReader();
    }
	
	@RequestMapping(value = "/manualJ48", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
    public String manualJ48() throws IOException {
        return manualJ48.doJ48();
    }
	
	@RequestMapping(value = "/manualKMeans", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE)
    public String manualKMeans() throws Exception {
        return manualKMeans.runKmeans();
    }
	
}
