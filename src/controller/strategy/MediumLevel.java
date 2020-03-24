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

public class MediumLevel implements Strategy {
logging log = new logging ();
	public int speed() {
	    log.help().info("Speed of hard level is set to be 15");
		return 15;
	}

	public int time() {
	    log.help().info("Time of hard level is set to be 2000 ms");
		return 2000;
	}

	@Override
	public int maxHeightOfPlate() {
	    log.help().info("Max Height Of Plate of hard level is set to be 7");
		return 7;
	}

	@Override
	public int getMaxTime() {
	       log.help().info("Max Time of hard level is set to be 2*60000 ms");
		return 2 * 60000;
	}

}
