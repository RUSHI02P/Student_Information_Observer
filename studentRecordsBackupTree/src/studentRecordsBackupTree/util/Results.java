package studentRecordsBackupTree.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import studentRecordsBackupTree.bst.BST;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	ErrorCheck errorCheck = new ErrorCheck();
    File results;
    File errors;
    public void setResultsFile(File resultsFile) {
        results = resultsFile;
    }
    public void setErrorFile(File errorFile) {
        errors = errorFile;
    }

    public void clearFiles(File resultFile, File errorFile) {
        String errMessage;
        try {
            new FileWriter(resultFile, false).close();
            new FileWriter(errorFile, false).close();
        } catch (IOException err) {
            errMessage = err.toString() + " : " + err.getStackTrace()[4];
            errorCheck.printError(errMessage.toString());
        } finally {
            errMessage = null;
        }
    }

    public void printInorderBST(BST mBST, BST b1BST, BST b2BST) {
        System.out.print("// Inorder traversal \n");
        mBST.printInorder("BST: ");
		b1BST.printInorder("Backup1: ");
		b2BST.printInorder("Backup2: ");
        System.out.print("\n");
    } 

    public void printSum(BST mBST, BST b1BST, BST b2BST, boolean incremented) {
        if (incremented) {
            System.out.print("// Sum of all the B-Numbers in each tree after increment \n");
        } else {
            System.out.print("// Sum of all the B-Numbers in each tree \n");
        }
        System.out.println("SUM BST: "+mBST.sumNodes());
		System.out.println("SUM Backup1: "+b1BST.sumNodes());
		System.out.println("SUM Backup2: "+b2BST.sumNodes());
        System.out.print("\n");
    }

    public void writeSum(BST mBST, BST b1BST, BST b2BST, boolean incremented) {
        if(incremented) {
            writeResult("// Sum of all the B-Numbers in each tree after increment ");
        } else {
            writeResult("// Sum of all the B-Numbers in each tree ");
        }
        writeResult("SUM BST: "+mBST.sumNodes());
        writeResult("SUM Backup1: "+b1BST.sumNodes());
        writeResult("SUM Backup2: "+b2BST.sumNodes());
        writeResult("\n");
    }

    public void writeInorderBST(BST mBST, BST b1BST, BST b2BST) {
        writeResult("// Inorder traversal ");
        writeResult(mBST.writeInorder("BST: "));
        writeResult(mBST.writeInorder("Backup1: "));
        writeResult(mBST.writeInorder("Backup2: "));
        writeResult("\n");
    }

    public void writeResult(String resString) {
        try {
            FileWriter fileWriter = new FileWriter(results, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            //System.out.println(resString);
            bufferWriter.write(resString);
            bufferWriter.write("\n");
            bufferWriter.close();
            fileWriter.close();

        } catch (FileNotFoundException err) {
            errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            errorCheck.printError(errMessage.toString());
        } catch (IOException err) {
            errorCheck.logError(errors, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            errorCheck.printError(errMessage.toString());
        }

    }


}
