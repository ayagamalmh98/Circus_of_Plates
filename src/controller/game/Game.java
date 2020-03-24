package controller.game;

import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import controller.state.IState;
import controller.strategy.Factory;
import controller.strategy.Strategy;
import model.pool.ConnectionPool;
import model.pool.FlySingle;
import model.Memento.*;
import controller.facade.Facade;
import controller.facade.ObjectFacade;
import controller.observer.ObserveScore;
import controller.state.*;
import model.*;

public class Game implements World {
    logging log = new logging ();
	private static int MAX_TIME;
	private ObserveScore score = new ObserveScore();
	private long startTime = System.currentTimeMillis();
	private final int width;
	private final int height;
	private List<GameObject> constant = new LinkedList<GameObject>();
	private List<GameObject> moving = new LinkedList<GameObject>();
	private List<GameObject> control = new LinkedList<GameObject>();
	
	private Strategy level;
	private IState State_1 = new State_1();
	
	boolean memento;
	String Newcolor;
	//private static ObjectFacade facade1 = new ObjectFacade();
	private static Facade facade = new Facade();
	FlySingle w=new FlySingle();
	public Game(int screenWidth, int screenHeight, Strategy level, boolean memento,String NewColor) {
		this.level = level;
		Game.MAX_TIME = this.level.getMaxTime();
		width = screenWidth;
		height = screenHeight;
		Newcolor=NewColor;
		System.out.println(Newcolor);
		//ConnectionPool son = new ConnectionPool(Newcolor);
		 Start Start = new Start(Newcolor);
		jarRead x = new jarRead();
		 
		//System.out.println("sd"+ex);
		List<Class<?>> listofClasses = x.getCrunchifyClassNamesFromJar("Shapes.jar");
		if (memento == false) {
			System.out.println("dfghjkl22222");
			//w.getInstance().set(Newcolor);
		    control = Start.getControl();
            moving = Start.getMoving();
            constant =Start.getConstant();
            System.out.println(control.size());
            System.out.println(moving.size());
            System.out.println(constant.size());
		}
		this.memento = memento;
	}

	public void moveToLimit() {
		if (this.control.get(0).getX() == 855) {
			this.control.get(2).setX(700);
			this.control.get(0).setX(855);
			this.control.get(1).setX(730);
		} else if (this.control.get(0).getX() > 855) {
			this.control.get(2).setX(700);
			this.control.get(0).setX(855);
			this.control.get(1).setX(730);
		}
		if (this.control.get(1).getX() == 35) {
			this.control.get(2).setX(5);
			this.control.get(0).setX(160);
			this.control.get(1).setX(35);
		} else if (this.control.get(1).getX() < 35) {
			this.control.get(2).setX(5);
			this.control.get(0).setX(160);
			this.control.get(1).setX(35);
		}

	}

	public void undo() {
	    ((State_1) State_1).undo(moving, control);
	}

	@Override
	public boolean refresh() {
	    log.help().info("Check if the clown reaches limits of the frame");
		moveToLimit();
		boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
		timeout = facade.currentState.State(State_1, constant, moving, control, null, null, null, level, timeout);
		return !timeout;
	}

	@Override
	public int getSpeed() {
		return level.speed();
	}

	@Override
	public int getControlSpeed() {
		return 20;
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return control;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getStatus() {
		return "Please Use Arrows To Move     |     " + "Score=" + score.GetScore() + "   |   Time="
				+ Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);
	}
}