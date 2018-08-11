package com.munheca.weca.modelos;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class LeArff {
	
	public String arffReader() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		FileReader reader = new FileReader("C:\\Program Files (x86)\\Weka-3-7\\data\\iris.arff");
		Instances instances = new Instances(reader);
		
		// Get the relation name.
		sb.append(instances.relationName() + "\n");
		System.out.println(instances.relationName());
		
		// Get the number of attributes.
		sb.append(instances.numAttributes() + " attributes \n");
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
			
			sb.append(name + " type " + typeName + "\n");
			System.out.println(name + " type " + typeName);
			
		}
		
		for(int i=0; i<instances.numInstances(); i++) { 
			
			Instance instance = instances.instance(i); 
			
			// ugh
			sb.append((i+1) + ": " 
					+ instance + " missing? " 
					+ instance.hasMissingValue() + "\n");
			System.out.println((i+1) + ": " 
					+ instance + " missing? " 
					+ instance.hasMissingValue()); 
		}
		
		return sb.toString(); 
	}
}
