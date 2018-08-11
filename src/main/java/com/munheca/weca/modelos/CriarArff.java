package com.munheca.weca.modelos;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

@Service
public class CriarArff {

	public void arffCreator() {

		// First let’s create the attributes.
		Attribute x = new Attribute("x");
		Attribute y = new Attribute("y");
		
		// Third attribute is nominal.
		ArrayList<String> classesLabels = new ArrayList<String>();
		classesLabels.add("A");
		classesLabels.add("B");
		classesLabels.add("C");
		classesLabels.add("D");
		classesLabels.add("E");
		Attribute classes = new Attribute("classes", classesLabels);

		// Create a vector of attributes information.
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(x);
		attributes.add(y);
		attributes.add(classes);

		// Create an empty set of instances.
		Instances instances = new Instances("random", attributes, 0);

		// Create 200 instances of more-or-less random data.
		for (int i = 0; i < 40; i++) {
			
			DenseInstance inst = new DenseInstance(3);

			// For class A.
			inst.setValue(x, 0.2 + 0.2 * Math.random());
			inst.setValue(y, 0.6 + 0.2 * Math.random());
			inst.setValue(classes, "A");
			instances.add(inst);

			// For class B.
			inst.setValue(x, 0.6 + 0.2 * Math.random());
			inst.setValue(y, 0.6 + 0.2 * Math.random());
			inst.setValue(classes, "B");
			instances.add(inst);

			// For class C.
			inst.setValue(x, 0.6 + 0.2 * Math.random());
			inst.setValue(y, 0.2 + 0.2 * Math.random());
			inst.setValue(classes, "C");
			instances.add(inst);

			// For classes D and E.
			inst.setValue(x, 0.2 + 0.2 * Math.random());
			inst.setValue(y, 0.2 + 0.2 * Math.random());
			inst.setValue(classes, "D");
			instances.add(inst);
			inst.setValue(x, 0.2 + 0.2 * Math.random());
			inst.setValue(y, 0.2 + 0.2 * Math.random());
			inst.setValue(classes, "E");
			instances.add(inst);
		}

		// Here is the ARFF file contents. Redirect it or use
		// BufferedWriter.write() to save it to a file.
		System.out.println(instances);
		
	}
}
