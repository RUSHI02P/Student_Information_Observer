package studentRecordsBackupTree.driver;

import java.io.File;
import java.util.ArrayList;

import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.util.BSTBuilder;
import studentRecordsBackupTree.util.ErrorCheck;
import studentRecordsBackupTree.util.MyLogger;
import studentRecordsBackupTree.util.Results;

public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		File bstInput = new File(args[0]);
		File resultsFile = new File(args[1]);
		File errorFile = new File(args[2]);

		// if(!bstInput.exists() || !resultsFile.exists() || !errorFile.exists()) {
		// 	System.err.println("Error: All or one of the files does not exist. Please check and try again.");
		// 	System.exit(0);
		// }

		Results results = new Results();
		BSTBuilder bstBuilder = new BSTBuilder();
		ErrorCheck errorCheck = new ErrorCheck();

		ArrayList<BST> alltrees = new ArrayList<>();

		results.setResultsFile(resultsFile);
		bstBuilder.setErrorFile(errorFile);
		errorCheck.setErrorFile(errorFile);
		results.clearFiles(resultsFile, errorFile);		

		int updateValue =  errorCheck.intConverter(args[4]);
		int debugValue = errorCheck.intConverter(args[3]);
		MyLogger.setDebugValue(debugValue);
		
		alltrees = bstBuilder.createTrees(bstInput);

		BST mainTree = alltrees.get(0);
		BST backup1 = alltrees.get(1);
		BST backup2 = alltrees.get(2);


		results.printInorderBST(mainTree, backup1, backup2);
		results.writeInorderBST(mainTree, backup1, backup2);
		results.printSum(mainTree, backup1, backup2, false);
		results.writeSum(mainTree, backup1, backup2, false);

		if(updateValue != 0) {
			mainTree.incrementNode(updateValue);
		}		

		results.printInorderBST(mainTree, backup1, backup2);
		results.writeInorderBST(mainTree, backup1, backup2);
		results.printSum(mainTree, backup1, backup2, true);
		results.writeSum(mainTree, backup1, backup2, true);

	}
}
