package controller.observer;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import controller.state.IState;
import controller.strategy.Factory;
import controller.strategy.Strategy;
import model.pool.ConnectionPool;
import model.Memento.*;
import controller.state.*;
import model.*;

public class ObserveRemove implements Observer{
    logging log = new logging();
	@Override
	public void UpDate(List<Plate> L,List<GameObject> control) {
		control.remove(L.get(L.size()-1));
		control.remove(L.get(L.size()-2));
		control.remove(L.get(L.size()-3));
		L.get(L.size()-1).setVisible(false);
		L.get(L.size()-2).setVisible(false);
		L.get(L.size()-3).setVisible(false);
		L.remove(L.size()-1);
		L.remove(L.size()-1);
		L.remove(L.size()-1);
		log.help().info("The 3 plates have the same color were removed");
	}

}
