package controller.observer;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import model.Plate;

public interface Observer {
 
	public void UpDate(List<Plate> c,List<GameObject> control);
}
