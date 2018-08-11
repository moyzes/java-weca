package com.munheca.weca.modelos;

import java.io.FileReader;

import org.springframework.stereotype.Service;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.j48.C45ModelSelection;
import weka.classifiers.trees.j48.C45PruneableClassifierTree;
import weka.core.Instance;
import weka.core.Instances;

@SuppressWarnings("serial")
@Service
public class ManualJ48 extends AbstractClassifier {

	// The tree
	private C45PruneableClassifierTree c45tree;

	// This method must be written since we extends the abstract class Classifier.
	public void buildClassifier(Instances instances) throws Exception {

		// Create a model selection for the tree (allowing the creation of subsets with
		// at least three instances)
		C45ModelSelection model = new C45ModelSelection(3, instances, false, false);

		// Create the classifier and build the tree using those instances.
		// The tree will be unpruned (therefore the confidence factor will be zero)
		// Subtree raising will not be performed (since tree will be unpruned)
		// What its cleanup data, anyway? Documentation is weak :-(
		c45tree = new C45PruneableClassifierTree(model, false, 0, false, true, false);
		c45tree.buildClassifier(instances);

	}

	// Prints the tree. 30
	public void printTree() {
		System.out.println(c45tree);
	}

	// We *must* implement this method otherwise the 
	// Evaluation instance will freak out.
	public double classifyInstance(Instance instance) throws Exception {
		return c45tree.classifyInstance(instance);
	}

	// The entry point on the app.
	public String doJ48() {

		try {

			// Read the instances from a file.
			FileReader reader = new FileReader("C:\\Program Files (x86)\\Weka-3-7\\data\\iris.arff");
			Instances instances = new Instances(reader);
			instances.setClassIndex(4);

			// Create the tree and classifier.
			ManualJ48 thisClassifier = new ManualJ48();
			thisClassifier.buildClassifier(instances);

			// Print the tree.
			thisClassifier.printTree();

			// Let’s evaluate the tree.
			Evaluation evaluation = new Evaluation(instances);
			evaluation.evaluateModel(thisClassifier, instances);
			
			// How many correct instances?
			System.out.print(evaluation.correct() + "/");
			
			// How many instances?
			System.out.println(instances.numInstances());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return c45tree.toString();
		
	}
}
