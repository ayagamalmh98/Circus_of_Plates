package model.pool;

import java.util.HashMap;

import model.logging;



public class FlyWeight {
	static HashMap<Integer, String> main_map = new HashMap<Integer, String>();
	static int value = 4;
	logging log = new logging ();
	public FlyWeight() {
		main_map.put(1, "black");
		main_map.put(2, "blue");
		main_map.put(3, "red");
	}

	@SuppressWarnings("unlikely-arg-type")
	public HashMap<Integer, String> get() {
		//FlySingle w=new FlySingle();
		return main_map;
	}
	public void set(HashMap<Integer, String> e) {
		main_map=e;
	}

	public HashMap<Integer, String> get2(String NewColor) {
		System.out.println("dsfgdhfj");
		System.out.println(NewColor);
		System.out.println(main_map.size());
		if (main_map.containsValue(NewColor)) {
			return main_map;
		} else if (NewColor.equals("")) {
			return main_map;
		} else {
			main_map.put(value, NewColor);
			value++;
		}
		log.help().info("Set color to be NewColor");
		return main_map;
	}
	/*public void set (String NewColor) {
		main_map.put(1, "black");
		main_map.put(2, "blue");
		main_map.put(3, "red");
		System.out.println("sxdfgh");
		if ((main_map.get(NewColor) == null)&&(!NewColor.isEmpty())) {
			main_map.put(value, NewColor);
			value++;
		}
		log.help().info("Set color to be NewColor");
	}*/
}
