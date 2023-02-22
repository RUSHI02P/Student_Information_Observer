package studentRecordsBackupTree.util;

import java.io.File;

public interface FileDisplayInterface {
	public void clearFiles(File resultFile, File errorFile);
	public void writeResult(String resString); 
}
