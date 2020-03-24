package controller.strategy;

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
public class HardLevel implements Strategy {
logging log = new logging ();
	@Override
	public int speed() {
	    log.help().info("Speed of hard level is set to be 10");
		return 10;
	}

	public int time() {
	    log.help().info("Time of hard level is set to be 1000 ms");
		return 1000;
	}

	@Override
	public int maxHeightOfPlate() {
	    log.help().info("Max Height Of Plate of hard level is set to be 5");
		return 5;
	}

	@Override
	public int getMaxTime() {
	    log.help().info("Max Time of hard level is set to be 60000 ms");
		return 1 * 60000;
	}

}
