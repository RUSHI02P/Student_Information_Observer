
package studentRecordsBackupTree.bst;


import java.util.ArrayList;

import studentRecordsBackupTree.observer.Observer;
import studentRecordsBackupTree.subject.Subject;


public class Node implements Observer, Subject {
	public int bNo;
    public String description;
    public Node left; 
    public Node right;

    private ArrayList<Observer> observers;

    public Node(int bNum, String stuDescription) {
        bNo=bNum;
        description=stuDescription;
        left = right = null;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer node) {
        observers.add(node);
    }

    @Override
    public void unregisterObserver(Observer node) {
        observers.remove(node);
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++) {
            Node prr = (Node)observers.get(i);
            //prr.bNo = bNo;
            prr.updateNode(bNo);
        }
    }

    @Override
    public void updateNode(int newBNo){
        //System.out.println("Observer: "+ bNo);
        bNo = newBNo;
    }
    
}
