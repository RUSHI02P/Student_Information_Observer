package studentRecordsBackupTree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.Node;
import studentRecordsBackupTree.util.MyLogger.DebugLevel;

public class FileProcessor implements FileProcessorInterface {
	FileReader fileReader;
    BufferedReader bufferReader;
    LineNumberReader lineNumReader;
    BST mainBST = new BST();
    BST backup1= new BST();
    BST backup2 = new BST();
    ArrayList<BST> allTrees = new ArrayList<>();
    ErrorCheck errorCheck = new ErrorCheck();
    File errorFile;

    public void setErrorFile(File err) {
        errorFile = err;
    }

    @Override
    public ArrayList<BST> importBNumber(File bstInput) {
        String line;
        try {
            fileReader = new FileReader(bstInput);
            bufferReader = new BufferedReader(fileReader);
            while((line = bufferReader.readLine()) != null) {
                String desc = String.format("BNumber:%d student record", Integer.parseInt(line));
                Node nodeSubject = new Node(Integer.parseInt(line), desc);
                Node nodeObserver1 = new Node(Integer.parseInt(line), desc);
                Node nodeObserver2 = new Node(Integer.parseInt(line), desc);

                nodeSubject.registerObserver(nodeObserver1);
                nodeSubject.registerObserver(nodeObserver2);

                mainBST.insert(nodeSubject ,Integer.parseInt(line));
                backup1.insert(nodeObserver1, Integer.parseInt(line));
                backup2.insert(nodeObserver2, Integer.parseInt(line));

            }

            String loggerString = "Inside FileProcessor class.importBNumber function try block: Successfully created the three BSTs with registered observers\n";
                
            MyLogger.writeMessage(loggerString, DebugLevel.FILE_PROCESSOR);

            bufferReader.close();
        } catch (FileNotFoundException err) {
            errorCheck.logError(errorFile, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            errorCheck.printError(errMessage.toString());
            MyLogger.writeMessage(errMessage, DebugLevel.FILE_PROCESSOR);
        } catch (IOException err) {
            errorCheck.logError(errorFile, err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            errorCheck.printError(errMessage.toString());
            MyLogger.writeMessage(errMessage, DebugLevel.FILE_PROCESSOR);
        } finally {
            line = null;
            allTrees.add(mainBST);
            allTrees.add(backup1);
            allTrees.add(backup2);
        }


        return allTrees;
    }

}
