package model.pool;

import java.util.LinkedList;
import java.util.Queue;

import model.logging;



public abstract class PoolObject<GameObject> {
	private Queue<GameObject> ObjectShape=new LinkedList<>(); 
	logging log = new logging ();
    public void checkIn(eg.edu.alexu.csd.oop.game.GameObject m) {
		if (m == null) {
			return;
		}
	   this.ObjectShape.offer((GameObject) m);
	   log.help().info("A GameObject is added to the list");
	}
    public GameObject checkOut() {
    	GameObject t;
		t =  ObjectShape.poll();
		log.help().info("A GameObject is remved from the list");
		return (t);
	}
    @SuppressWarnings("unchecked")
	protected void initialize(final int minObjects,String ee) {
    	RondomShapes x =new RondomShapes(ee);
		for (int i = 0; i < minObjects; i++) {
			ObjectShape.add( (GameObject) x.get());
			log.help().info("A new GameObject is added to the list");
		}
	}
}
