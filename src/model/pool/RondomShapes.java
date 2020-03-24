package model.pool;

import java.util.HashMap;

import controller.facade.Facade;
import controller.facade.ObjectFacade;
import view.*;
import model.Color;
import model.Plate;
import model.Shape;
import model.logging;


public class RondomShapes {
	HashMap<Integer, String> main_map_color = new HashMap<Integer, String>();
	HashMap<Integer, String> main_map_shape = new HashMap<Integer, String>();
	//private static ObjectFacade facade1 = new ObjectFacade();
	//private static Facade facade = facade1.getInstance();
	//FlySingle w=new FlySingle();
	FlyWeight ElementColor = new FlyWeight();
	logging log = new logging ();
	String zeft_Color; 
	public RondomShapes(String ee) {
		zeft_Color=ee;
		System.out.println("zeft_Color"+zeft_Color);
	}
	
	public Plate get() {
		//System.out.println(ElementColor.get2(zeft_Color).size());
		main_map_color = ElementColor.get2(zeft_Color);
		int random_color = (int) (Math.random() * (main_map_color.size() + 1));
		while (random_color == 0) {
			random_color = (int) (Math.random() * (main_map_color.size() + 1));

		}
		String path = main_map_color.get(random_color);
		String path_Crown = "/Crown-" + path + ".png";
		main_map_shape.put(1, path_Crown);
		String path_Lantern = "/Lantern-" + path + ".png";
		main_map_shape.put(2, path_Lantern);
		int random_shape = (int) (Math.random() * (main_map_shape.size() + 1));
		while (random_shape == 0) {
			random_shape = (int) (Math.random() * (main_map_shape.size() + 1));

		}
		System.out.println(path_Crown);
		System.out.println(Color.Name(path));
		Plate x = null;
		switch (random_shape) {
		case 1:
			x = new Plate((int) (Math.random() * 900), -1 * (int) (Math.random() * 800), path_Crown, Color.Name(path),
					Shape.Crown);
			break;
		case 2:
			x = new Plate((int) (Math.random() * 900), -1 * (int) (Math.random() * 800), path_Lantern, Color.Name(path),
					Shape.Lantern);
			break;
		}
		log.help().info("An object of GameObjects is returned");
		return x;
	}

	public void  set_zift()
	{
		
	}
}