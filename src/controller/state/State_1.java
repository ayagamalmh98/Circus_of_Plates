package controller.state;

/*import java.util.LinkedList;
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
import controller.facade.Facade;
import controller.iterator.ArrayIterator;
import controller.iterator.Iiterator;
import controller.iterator.LinkedListIterator;
import controller.music.Music;
import controller.state.*;
import model.*;
 
public class State_1 implements IState {
    private static List<Plate> R = new LinkedList<Plate>();
    private static List<Plate> L = new LinkedList<Plate>();
    private Facade facade = new Facade();
    private IState State_3 = new State_3();
    private IState State_2 = new State_2();
    private Music music_catch=new Music();
    private Sup_State1 sub=new Sup_State1();
    logging log = new logging ();
   
 
    public boolean checkState(List<GameObject> constant, List<GameObject> moving, List<GameObject> control, GameObject c,
            List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        Iiterator j = new LinkedListIterator(moving);
        while (j.hasNext()) {
            GameObject m = j.Next();
            m.setY((m.getY() + 1));
            if (m.getY() == 800) {
                m.setY(-1 * (int) (Math.random() * 800));
                m.setX((int) (Math.random() * 900));
            }
            m.setX(m.getX());
        }
        log.help().info("Moving objects are positoned on their places");
        if (!L.isEmpty()) {
            L.get(0).setX(control.get(1).getX());
            for (int i = 1; i < L.size(); i++)
                L.get(i).setX(L.get(i - 1).getX());
        }
        if (!R.isEmpty()) {
            R.get(0).setX(control.get(0).getX());
            for (int i = 1; i < R.size(); i++)
                R.get(i).setX(R.get(i - 1).getX());
        }
        j = new ArrayIterator(moving.toArray(new Plate[moving.size()]));
        LinkedList array=new LinkedList();
        array=sub.help(j,R,L,constant,moving,control, level, timeout);
        R=(List<Plate>) array.get(0);
        L=(List<Plate>) array.get(1);
        if (moving.size() < 3) {
            Start.getMoving();
        }
        if (level.maxHeightOfPlate() == R.size() || level.maxHeightOfPlate() == L.size()) {
            log.help().warning("Height of plates exceeds limit");
            timeout = true;
        }
        return timeout;
 
    }
 
    int temp1=-1,temp2=-1;
    static int first=-1,flag=1;
    int change1=0,change2=0;
    public void undo(List<GameObject> moving, List<GameObject> control) {
        int cursorL =L.size()-1;
        int cursorR =R.size()-1;
        int flag = ((State_3)State_3).flag();
        if (flag==1) {
            temp1=((State_3)State_3).getCursorL();
            temp2=((State_3)State_3).getCursorR();
        }
        if (((cursorL>temp1&&cursorR>temp2)||((cursorL<=0||cursorR<=0)&&flag==0)||((cursorL>temp1||cursorR>temp2)))&&!((first==-1)&&(R.size()==0&&L.size()==0))) {  
            first=0;
       Memento m= facade.CareTaker.undo();
       if(L.size()>0) {
       if (L.get(cursorL).getX()==m.getGameObject().getX()) {
           L.get(cursorL).setVisible(false);
           L.remove(cursorL);
       }}
       if (R.size()>0){
           if (R.get(cursorR).getX()==m.getGameObject().getX()) {
           R.get(cursorR).setVisible(false);
           R.remove(cursorR);
           }
       }
       change1=L.size();
       change2=R.size();
       log.help().info("Undo is done");
    }else {
        log.help().warning("Undo is not available now!");
    }
    }
 
   
    public boolean State(IState state, List<GameObject> constant, List<GameObject> moving, List<GameObject> control,
            GameObject m, List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        return facade.currentState.State(state, constant, moving, control, m, r, l, level, timeout);
    }
    public void set() {
    	R.clear();
    	L.clear();
    }
 
}*/



//package controller.state;

import java.util.LinkedList;
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
import controller.facade.Facade;
import controller.iterator.ArrayIterator;
import controller.iterator.Iiterator;
import controller.iterator.LinkedListIterator;
import controller.music.Music;
import controller.state.*;
import model.*;
 
public class State_1 implements IState {
    private static List<Plate> R = new LinkedList<Plate>();
    private static List<Plate> L = new LinkedList<Plate>();
    private Facade facade = new Facade();
    private IState State_3 = new State_3();
    private IState State_2 = new State_2();
    private Music music_catch=new Music();
    logging log = new logging ();
    public static boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())
                && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
 
    }
 
    public boolean checkState(List<GameObject> constant, List<GameObject> moving, List<GameObject> control, GameObject c,
            List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        Iiterator j = new LinkedListIterator(moving);
        while (j.hasNext()) {
            GameObject m = j.Next();
            m.setY((m.getY() + 1));
            if (m.getY() == 800) {
                m.setY(-1 * (int) (Math.random() * 800));
                m.setX((int) (Math.random() * 900));
            }
            m.setX(m.getX());
        }
        log.help().info("Moving objects are positoned on their places");
        if (!L.isEmpty()) {
            L.get(0).setX(control.get(1).getX());
            for (int i = 1; i < L.size(); i++)
                L.get(i).setX(L.get(i - 1).getX());
        }
        if (!R.isEmpty()) {
            R.get(0).setX(control.get(0).getX());
            for (int i = 1; i < R.size(); i++)
                R.get(i).setX(R.get(i - 1).getX());
        }
        j = new ArrayIterator(moving.toArray(new Plate[moving.size()]));
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
                String ex=System.getProperty("user.dir");
                music_catch.PlayMusic(ex+"\\MusicREs\\matchSound.wav");
                State(State_2, constant, moving, control, m, R, L, level, timeout);
            }
        }
        if (moving.size() < 3) {
            Start.getMoving();
        }
        if (level.maxHeightOfPlate() == R.size() || level.maxHeightOfPlate() == L.size()) {
            log.help().warning("Height of plates exceeds limit");
            timeout = true;
        }
        return timeout;
 
    }
 
    int temp1=-1,temp2=-1;
    static int first=-1,flag=1;
    int change1=0,change2=0;
    public void undo(List<GameObject> moving, List<GameObject> control) {
        int cursorL =L.size()-1;
        int cursorR =R.size()-1;
        int flag = ((State_3)State_3).flag();
        if (flag==1) {
            temp1=((State_3)State_3).getCursorL();
            temp2=((State_3)State_3).getCursorR();
        }
        if (((cursorL>temp1&&cursorR>temp2)||((cursorL<=0||cursorR<=0)&&flag==0)||((cursorL>temp1||cursorR>temp2)))&&!((first==-1)&&(R.size()==0&&L.size()==0))) {  
            first=0;
       Memento m= facade.CareTaker.undo();
       if(L.size()>0) {
       if (L.get(cursorL).getX()==m.getGameObject().getX()) {
           L.get(cursorL).setVisible(false);
           L.remove(cursorL);
       }}
       if (R.size()>0){
           if (R.get(cursorR).getX()==m.getGameObject().getX()) {
           R.get(cursorR).setVisible(false);
           R.remove(cursorR);
           }
       }
       change1=L.size();
       change2=R.size();
       log.help().info("Undo is done");
    }else {
        log.help().warning("Undo is not available now!");
    }
    }
 
   
    public boolean State(IState state, List<GameObject> constant, List<GameObject> moving, List<GameObject> control,
            GameObject m, List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        return facade.currentState.State(state, constant, moving, control, m, r, l, level, timeout);
    }
    public void set() {
    	R.clear();
    	L.clear();
    }
 
}