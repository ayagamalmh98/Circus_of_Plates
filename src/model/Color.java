package model;
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

public enum Color {
	Red,
	Blue,
	Black,
	White;
	static logging log = new logging();
	public static Color Name(String x) {
		
		if(x.equalsIgnoreCase("Red")) {
		    log.help().info("Set color to be red");
			return Red;
		}
		else if(x.equalsIgnoreCase("Blue")) {
		    log.help().info("Set color to be blue");
			return Blue;
		}
		else if(x.equalsIgnoreCase("Black")) {
		    log.help().info("Set color to be black");
			return Black;
		}
		else if(x.equalsIgnoreCase("White")) {
		    log.help().info("Set color to be White");
			return White;
		}
		return null;
	}

}
