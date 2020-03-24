package model.Memento;

import java.util.ArrayList;

public class CareTaker {
    private int cursor;
    private ArrayList<Memento> history = new ArrayList<Memento>();
    public void addMemento (Memento m) {
        cursor =history.size();
        history.add(m);
    }
    
    public Memento getMemento (int index) {
        return history.get(index);
    }
    public Memento undo () {
        Memento m = null;
        if (cursor>=0) {
            m =history.get(cursor);
        cursor--;}
        return m;
    }
    public Memento redo () {
        Memento m = null;
        if (cursor==-1)
            cursor=0; 
        if (cursor<history.size()) {
            m =history.get(cursor);
        cursor++;}
        return m;
    }
    
}