package controller.state;

import java.util.LinkedList;
import java.util.List;

import controller.facade.Facade;
import controller.iterator.Iiterator;
import controller.music.Music;
import controller.strategy.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import model.Plate;
import model.logging;

public class Sup_State1 {
	 private static Facade facade = new Facade();
	 private static Music music_catch=new Music();
	 static logging log = new logging ();
	 private static IState State_2 = new State_2();
	 private static IState State_1 = new State_1();
	 public static boolean intersect(GameObject o1, GameObject o2) {
	        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())
	                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
	 
	    }
	public static LinkedList  help(Iiterator j , List<Plate> R ,List<Plate> L ,List<GameObject> constant, List<GameObject> moving, List<GameObject> control ,Strategy level,  boolean timeout ) {
		LinkedList array=new LinkedList();
		 while (j.hasNext()) {
	            Plate m = (Plate) j.Next();
	            boolean flag = false;
	            if (R.isEmpty()) {
	                if (intersect(control.get(0), m) && control.get(0).getY() == m.getY() + m.getHeight()) {
	                    m.setX(control.get(0).getX());
	                    m.setY(m.getY());
	                    R.add(m);
	                    R.get(R.size()-1).horizontalOnly = true;
	                    facade.Originator.setGameObject(m);
	                    facade.CareTaker.addMemento(facade.Originator.createMemento());
	                    log.help().info("Moving object is added to memento");
	                
	                    flag = true;
	                }
	            } else if ((!R.isEmpty()) && (intersect(R.get(R.size() - 1), m))) {
	                m.setX(R.get(R.size() - 1).getX());
	                m.setY(R.get(R.size() - 1).getY() - m.getHeight());
	              
	                R.add(m);
	                R.get(R.size()-1).horizontalOnly = true;
	                facade.Originator.setGameObject(m);
	                facade.CareTaker.addMemento(facade.Originator.createMemento());
	                log.help().info("Moving object is added to memento");
	                flag = true;
	            }
	            if (L.isEmpty()) {
	                if (intersect(control.get(1), m) && control.get(0).getY() == m.getY() + m.getHeight()) {
	                    m.setX(control.get(1).getX() - 15);
	                    m.setY(m.getY());
	                    L.add(m);
	                    L.get(L.size()-1).horizontalOnly = true;
	                    facade.Originator.setGameObject(m);
	                    facade.CareTaker.addMemento(facade.Originator.createMemento());
	                    log.help().info("Moving object is added to memento");
	                 
	                    m.setY(m.getY() - 5);
	                    flag = true;
	                }
	            } else if (!L.isEmpty() && intersect(L.get(L.size() - 1), m)) {
	                m.setX(L.get(L.size() - 1).getX() - 15);
	                m.setY(L.get(L.size() - 1).getY() - m.getHeight());
	             
	                L.add(m);
	                L.get(L.size()-1).horizontalOnly = true;
	                facade.Originator.setGameObject(m);
	                facade.CareTaker.addMemento(facade.Originator.createMemento());
	                log.help().info("Moving object is added to memento");
	                flag = true;
	 
	            }
	            if (flag == true) {
	                log.help().info("There was an intersection");
	                music_catch.PlayMusic("C:\\eclipse-workspace\\final42\\MusicREs\\matchSound.wav");
	                State(State_2, constant, moving, control, m, R, L, level, timeout);
	            }
	        }
		 array.add(R);
		 array.add(L);
		 return array;
	}
	 public static boolean State(IState state, List<GameObject> constant, List<GameObject> moving, List<GameObject> control,
	            GameObject m, List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
	        return facade.currentState.State(state, constant, moving, control, m, r, l, level, timeout);
	    }
}
