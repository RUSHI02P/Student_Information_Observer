package studentRecordsBackupTree.subject;

import studentRecordsBackupTree.observer.Observer;

public interface Subject {
    public void registerObserver(Observer node);
    public void unregisterObserver(Observer node);
    public void notifyObserver();
}
