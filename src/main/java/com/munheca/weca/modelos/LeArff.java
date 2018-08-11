package com.munheca.weca.modelos;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class LeArff {
	
	public void arffReader() throws IOException {
		
		FileReader reader = new FileReader("C:\\Program Files (x86)\\Weka-3-7\\data\\iris.arff");
		Instances instances = new Instances(reader);
		
		// Get the relation name.
		System.out.println(instances.relationName());
		
		// Get the number of attributes. 
		System.out.println(instances.numAttributes() + " attributes");
		
		// Show the attributes. 
		for(int i=0; i<instances.numAttributes(); i++) {
			
			String name = instances.attribute(i).name(); 
			int type = instances.attribute(i).type(); 
			String typeName = "";
			
			switch(type) {
				case Attribute.NUMERIC: typeName = "Numeric";
					break;
				case Attribute.NOMINAL: typeName = "Nominal";
					break;
				case Attribute.STRING: typeName = "String";
					break;
			}
			
			System.out.println(name + " type " + typeName); 
		}
		
		for(int i=0; i<instances.numInstances(); i++) { 
			
			Instance instance = instances.instance(i); 
			
			// ugh 
			System.out.println((i+1) + ": " 
					+ instance + " missing? " 
					+ instance.hasMissingValue()); 
		} 
	}
}
