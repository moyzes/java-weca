package com.munheca.weca.modelos;

import java.io.FileReader;

import org.springframework.stereotype.Service;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

@Service
@SuppressWarnings("serial")
public class ManualKMeans extends SimpleKMeans {
	
	public String runKmeans() throws Exception {
		
		FileReader reader = new FileReader("C:\\Program Files (x86)\\Weka-3-7\\data\\weather.nominal.arff");
		Instances instances = new Instances(reader);
		
		// We want to ignore the class of the data vectors.
		instances.deleteAttributeAt(2);
		
		// Create the cluster.
		ManualKMeans thisClusterer = new ManualKMeans();
		thisClusterer.setNumClusters(4);
		thisClusterer.buildClusterer(instances);
		System.out.println(thisClusterer.getSquaredError());
		
		// Try again with a different number of clusters.
		thisClusterer.setNumClusters(5);
		thisClusterer.buildClusterer(instances);
		System.out.println(thisClusterer.getSquaredError());
		
		System.out.println(thisClusterer);
		return thisClusterer.toString();
		
	}
}
