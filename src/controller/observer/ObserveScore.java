package controller.observer;
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

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class ObserveScore implements Observer{
    logging log = new logging();
	private static int score;
	public int GetScore() {
		return score;
	}
	@Override
	public void UpDate(List<Plate> c,List<GameObject> control) {
		// TODO Auto-generated method stub
		if(score==0) {
			score=1;
		}
		else {
			score++;
			
		}
		log.help().info("Score is updated");
	}
}
