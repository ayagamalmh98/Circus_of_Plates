package controller.state;

import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import controller.state.IState;
import controller.strategy.Factory;
import controller.strategy.Strategy;
import model.pool.ConnectionPool;
import model.Memento.*;
import controller.facade.Facade;
import controller.music.Music;
import controller.observer.ObserveRemove;
import controller.observer.ObserveScore;
import controller.observer.Observer;
import controller.state.*;
import model.*;
public class State_3 implements IState {
    private List<Plate> R = new LinkedList<Plate>();
    private List<Plate> L = new LinkedList<Plate>();
    private Facade facade = new Facade();
    private List<Observer> observers = new LinkedList<Observer>();
    private Music music_catch=new Music();
    static int flag=0;
    static int cursorL;
    static int cursorR;
    logging log = new logging ();
    public State_3() {
        observers.add(new ObserveScore());
        observers.add(new ObserveRemove());
    }

    @Override
    public boolean checkState(List<GameObject> constant, List<GameObject> moving, List<GameObject> control, GameObject m,
            List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        R = r;
        L = l;
        if(R.size()>=3) {
            Color a1=R.get(R.size()-1).getColor();
            Color a2=R.get(R.size()-2).getColor();
            Color a3=R.get(R.size()-3).getColor();
            log.help().info("Check if there are 3 objects have the same color");
            if( (a1==a2)&&(a2==a3)) {
            	String ex=System.getProperty("user.dir");
            	music_catch.PlayMusic(ex+"\\MusicREs\\win.wav");
                flag=1;
                cursorR=R.size()-4;
                cursorL=L.size()-1;
                log.help().info("");
                log.help().info("There are 3 objects have the same color, so send them to the observers");
                Notify(R,control);
            }
        }
        
        if(L.size()>=3) {
            Color a1=L.get(L.size()-1).getColor();
            Color a2=L.get(L.size()-2).getColor();
            Color a3=L.get(L.size()-3).getColor();
            log.help().info("Check if there are 3 objects have the same color");
            if((a1==a2)&&(a2==a3)) {
            	String ex=System.getProperty("user.dir");
            	music_catch.PlayMusic(ex+"\\MusicREs\\win.wav");
                flag=1;
                cursorL=L.size()-4;
                cursorR=R.size()-1;
                log.help().info("There are 3 objects have the same color, so send them to the observers");
                Notify(L,control);
            }
        }
        if (level.maxHeightOfPlate() == R.size() || level.maxHeightOfPlate() == L.size()) {
            timeout = false;
        }
        return timeout;
    }

    public int flag () {
        return flag;
    }
    
    public void setCursorL (int x) {
        cursorL=x;
    }
    public int getCursorL () {
        return cursorL;
    }
    public void setCursorR (int x) {
        cursorR=x;
    }
    public int getCursorR() {
        return cursorR;
    }
    @Override
    public boolean State(IState state, List<GameObject> constant, List<GameObject> moving, List<GameObject> control,
            GameObject m, List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
        return facade.currentState.State(state, constant, moving, control, m, r, l, level, timeout);
    }

    public void Notify(List<Plate> c, List<GameObject> control) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).UpDate(c, control);
        }
    }

}
