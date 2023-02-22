package studentRecordsBackupTree.util;

import java.io.File;
import java.util.ArrayList;

import studentRecordsBackupTree.bst.BST;

public interface FileProcessorInterface {
    public ArrayList<BST> importBNumber(File bstInput);
}
