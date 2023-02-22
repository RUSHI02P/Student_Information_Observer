package studentRecordsBackupTree.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorCheck implements ErrorDisplayInterface {

    File errorFile;

    public void setErrorFile(File error) {
        errorFile = error;
    }

    public int intConverter(String num) {
        try {
			return Integer.parseInt(num);
			//debugValue = Integer.parseInt(args[3]);
		} catch (NumberFormatException err) {
			//System.out.println(err.toString());
			logError(errorFile, "Check command line argument for correct int value \n"+err.toString());
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            printError(errMessage.toString());
            return 0;
		}
    }

    public void logError(File errorFile, String errorMessage) {
        try {
            FileWriter fileWriter = new FileWriter(errorFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(errorMessage);
            bufferWriter.newLine();
            bufferWriter.close();
            fileWriter.close();

        } catch (IOException err) {
            System.out.println(err);
            String errMessage = err.toString() + " : " + err.getStackTrace()[4];
            printError(errMessage.toString());
        } finally {
            System.out.println("Error Occured: " + errorMessage);
        }
    }


    public void printError(String errMessage) {
        System.out.println("Program exited with error: " + errMessage);
        System.out.println("Check errors in the errorLog.txt");
        System.exit(0);
    }

}
