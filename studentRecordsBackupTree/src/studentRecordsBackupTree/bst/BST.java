
package studentRecordsBackupTree.bst;

public class BST {
    Node root;

    public BST(){
        root = null;
    }

    public void insert(Node newNode, int insertbNo) {
        root = insertNode(root, newNode ,insertbNo);
    }

    Node insertNode(Node root, Node newNode ,int bNo){
        if(root==null){
            //String desc = String.format("BNumber %d student record", bNo);
            root = newNode;
            return root;
        } else if (bNo < root.bNo) {
            root.left = insertNode(root.left, newNode , bNo);
        } else {
            root.right = insertNode(root.right, newNode , bNo);
        }

        return root;
    }

    public void printInorder(String bstName) {
        System.out.print(bstName+" ");
        inorderPrintBST(root);
        System.out.print("\n");
    }

    void inorderPrintBST(Node node) {
        if(node != null) {
            inorderPrintBST(node.left);
            System.out.print(node.bNo + ", ");
            inorderPrintBST(node.right);
        }
    }

    public String writeInorder(String bstName) {
        String output = bstName+" ";
        output += inorderWriteBST(root);
        //output += "\n";
        return output;
    }

    String inorderWriteBST(Node node) {
        String bNum = "";
        if(node != null) {
            bNum += inorderWriteBST(node.left);
            bNum += node.bNo + ", ";
            bNum += inorderWriteBST(node.right);
        }

        return bNum;
    }

    public void incrementNode(int numToAdd) {
        //System.out.println(" Incremented nodes ");
        increment(root, numToAdd);
    }

    void increment(Node nodeToAdd, int numToAdd) {
        if(nodeToAdd != null) {
            increment(nodeToAdd.left, numToAdd);
            nodeToAdd.bNo += numToAdd;
            nodeToAdd.notifyObserver();
            increment(nodeToAdd.right, numToAdd);
        }
    }

    public int sumNodes(){
        return totalSum(root);
    }

    int totalSum(Node sumNode) {
        int sum = 0;
        if(sumNode != null) {
            sum += totalSum(sumNode.left);
            sum += sumNode.bNo;
            sum += totalSum(sumNode.right);
        }

        return sum;
    }

}
