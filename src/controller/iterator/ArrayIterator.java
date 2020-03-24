package controller.iterator;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ArrayIterator implements Iiterator {
    GameObject [] Array;
    int cursor =0;
    public ArrayIterator (GameObject [] Array) {
        this.Array=Array;
    }
    @Override
    public boolean hasNext() {
        if (cursor>= this.Array.length) {
            return false;
        }else {
        return true;
        }
    }

    @Override
    public GameObject Next() {
        GameObject temp = this.Array[cursor];
        cursor++;
        return temp;
        
    }

}
