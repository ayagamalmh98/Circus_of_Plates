package controller.iterator;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
public class LinkedListIterator implements Iiterator {
    List <GameObject> List;
    int cursor =0;
    public LinkedListIterator (List <GameObject> ArrayList) {
        this.List=ArrayList;
    }
    @Override
    public boolean hasNext() {
        if (cursor>= this.List.size()) {
            return false;
        }else {
        return true;
        }
    }

    @Override
    public GameObject Next() {
        GameObject temp = this.List.get(cursor);
        cursor++;
        return temp;
        
    }

}
