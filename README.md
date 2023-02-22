-----------------------------------------------------------------------
## Instruction to clean:

#### Command: ant -buildfile studentRecordsBackupTree/src/build.xml clean

~~~
ant -buildfile studentRecordsBackupTree/src/build.xml clean
~~~

Description: It cleans up all the .class files that were generated when you compiled your code.

-----------------------------------------------------------------------
## compile:

#### Command: ant -buildfile studentRecordsBackupTree/src/build.xml all

~~~
ant -buildfile studentRecordsBackupTree/src/build.xml all
~~~

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Command: ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=<fileName.txt> -Darg1=<fileName.txt> -Darg2=<fileName.txt> -Darg3=<Int> -Darg4=<Int>

## Replace <fileName.txt> with real file names. For example, if the files are available in the path, 
## Replace <Int> with positive integer values to set Debug level and Increment value.
## you can run it in the following manner:

### Example
~~~
ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=1 -Darg4=5
~~~

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------

## Description:

### Data Structures used
~~~

ArrayList: It is dynamic, and since I wanted to return 3 Binary Search Trees after creating and inserting nodes from FileProcessor and then from BSTBuilder, so in future if we wanted to add more backups for the BST then only need to run more .add function at the importBNumber function. Adding and getting element from the ArrayList and array is same in performance. The add() takes O(1) time, when new array is created and copied to it, it takes O(n) time. Also, the get() takes O(1) time.

~~~

### Design Pattern

~~~

In this project, I have used Observer Pattern to create a Node Subject and Node Observer of a Binary Search Tree. Using this pattern, we can keep backups of BST, whenever any changes are made to any node, backup tree nodes are also updated without going chaning them manually. BSTBuilder uses FileProcessor Api to create three BSTs in which nodes are assigned as subject and observers and added to the respective subjects. When we increment values of mainBST tree, the subjects nodes in that call the notify function and updates the values of other backup trees.

~~~

### Program Structure

 - Driver.java: This file checks the correct arguments and BSTBuilder to get the 3 BSTs created. Then it uses update_value to increment the nodes. Displaying and writing the results are done in this file.
 - BST.java: This class file contains methods to insert, print, increment and calculate total sum of the BST nodes.
 - Node.java: This class file implements Subject and Observer interface for adapting Observer design pattern. This contains the methods to add-remove observers, notify observers and update the nodes.
 - BSTBuilder.java: This class file has a method to use FileProcessor Api to create 3 BSTs.
 - ErrorCheck.java: This class file implements ErrorDisplayInterface to log error in the errorLog.txt and print errors in the terminal. Also has a method to check if the string num can be converted to Int.
 - FileProcessor.java: This class file implements FileProcessorInterface to create three binary search trees with subject and observer nodes.
 - Results.java: This class implements FileDisplayInterface and StdoutDisplayInterface to print and write results to the bstOutput.txt file.
