package controller.state;

import java.util.List;
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

public class State_2 implements IState {
	private IState State_3 = (IState) new State_3();
	currentState currentState = new currentState();
	logging log = new logging ();
	@Override
	public boolean checkState(List<GameObject> constant, List<GameObject> moving, List<GameObject> control, GameObject m,
			List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
		moving.remove(m);
		control.add(m);
		Start.add(m);
		log.help().info("Remove the intersected plate from moving to control");
		State(State_3, constant, moving, control, m, r, l, level, timeout);
		return timeout;
	}

	@Override
	public boolean State(IState state, List<GameObject> constant, List<GameObject> moving, List<GameObject> control,
			GameObject m, List<Plate> r, List<Plate> l, Strategy level, boolean timeout) {
		return currentState.State(state, constant, moving, control, m, r, l, level, timeout);
	}

}