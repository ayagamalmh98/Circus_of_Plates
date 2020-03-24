package controller.facade;

import controller.state.IState;
import controller.strategy.Factory;
import controller.strategy.Strategy;
import model.pool.ConnectionPool;
import model.pool.FlySingle;
import model.pool.FlyWeight;
import model.Memento.*;
//import controller.game.prinate;
import controller.state.*;
import model.*;

public class Facade {
    public Strategy level;
    public IState currentState = new currentState();
   // public ConnectionPool son = new ConnectionPool();
    public Originator Originator = new Originator();
    public CareTaker CareTaker = new CareTaker();
    public currentState currentState1 = new currentState();
    public Factory factory= new Factory();
    //public Start Start = new Start();
    private FlySingle fly1=new FlySingle();
   // public FlyWeight fly=fly1.getInstance();
}
