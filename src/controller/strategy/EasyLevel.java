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
public class EasyLevel implements Strategy {
    logging log = new logging ();
	public int speed() {
	    log.help().info("Speed of easy level is set to be 25");
		return 25;
	}

	public int time() {
	    log.help().info("Time of easy level is set to be 3000 ms");
		return 3000;
	}

	@Override
	public int maxHeightOfPlate() {
	    log.help().info("Max Height Of Plate of easy level is set to be 10");
		return 10;
	}

	@Override
	public int getMaxTime() {
	    log.help().info("Max Time of easy level is set to be 3 * 60000 ms");
		return 3 * 60000;
	}

}
