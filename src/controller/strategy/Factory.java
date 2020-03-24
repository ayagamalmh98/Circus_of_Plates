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
public class Factory {
    logging log = new logging ();
    Strategy level;
    public Strategy setLevel(int x) {
        if (x == 1) {
            level = new EasyLevel();
            log.help().info("Easy level object is returned");
        } else if (x == 2) {
            level = new MediumLevel();
            log.help().info("medium level object is returned");
        } else if (x == 3) {
            level = new HardLevel();
            log.help().info("hard level object is returned");
        }
        return level;      
    }
}
