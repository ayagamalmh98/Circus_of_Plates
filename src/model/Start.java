package model;

import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.GameObject;
import controller.strategy.Factory;
import controller.strategy.Strategy;
import model.pool.ConnectionPool;
import model.Memento.*;
import controller.state.*;
import model.*;

public class Start {
    private static final List<GameObject> control = new LinkedList<GameObject>();
    private static final  List<GameObject> moving = new LinkedList<GameObject>();
    private static final  List<GameObject> constant = new LinkedList<GameObject>();
    static logging log = new logging ();
    private static  ConnectionPool son;
    static String colo;
    public Start(String ee) {
    	colo=ee;
    	System.out.println("start"+colo);
    	son=new ConnectionPool(colo);
    }
    
    private static State_1 State_1 = new State_1();
    
       public static  List<GameObject> getControl(){  
           log.help().info("Adding the control objects");
           control.clear();
           State_1.set();
           control.add(new StickRight(326,472,"/right.png",true));
           control.add(new StickLeft(200, 465, "/left.png", true));
           control.add(new Clown(170, 530, "/Clown.png", true));
           return control;
       }
       public static  List<GameObject> getMoving(){
           log.help().info("Adding the moving objects");
           moving.clear();
            for (int i = 3; i < 7; i++) {
                   moving.add((GameObject) son.checkOut());
                   moving.add((GameObject) son.checkOut());
                   moving.add((GameObject) son.checkOut());
            }
           return moving;
       }
       public static List<GameObject> getConstant(){ 
           log.help().info("Adding the constant objects");
           constant.clear();
           constant.add(new ImageObject((int)(900*0.005), (int)(750*0.005), "/background.png"));
           return constant;
       }
       public static void add(GameObject m){
           log.help().info("return the objects to the Pool");
           son.checkIn(m);         
      }
       public static void colorrr(String s){
          // log.help().info("return the objects to the Pool");
           //.checkIn(m);
    	   
      }
}
