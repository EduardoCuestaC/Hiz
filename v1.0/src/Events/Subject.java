package Events;

public  interface Subject {
    void subscribe(Observer observer);
    void notifyObservers();

}
