package studentRecordsBackupTree.util;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import studentRecordsBackupTree.bst.BST;

public class BSTBuilder {
    FileReader fileReader;
    BufferedReader bufferReader;
    FileProcessor fileProcessor = new FileProcessor();
    File errorFile;

    public void setErrorFile(File err) {
        errorFile = err;
        fileProcessor.setErrorFile(errorFile);
    }


    public ArrayList<BST> createTrees(File bstInput) {
        
        ArrayList<BST> allBSTrees = fileProcessor.importBNumber(bstInput);

        return allBSTrees;
    }
    

}
