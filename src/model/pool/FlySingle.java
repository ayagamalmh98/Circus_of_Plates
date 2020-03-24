package model.pool;

import java.util.HashMap;

import controller.facade.Facade;

public class FlySingle {
	// private static FlyWeight flight=new FlyWeight();
	 private static HashMap<Integer, String> main_map;
	 static int value = 4;
	    public  HashMap<Integer, String> getInstance (String x) {
	        if (main_map == null) {
	        	main_map= new HashMap<Integer, String>();
	        	main_map.put(1, "black");
	    		main_map.put(2, "blue");
	    		main_map.put(3, "red");
	        }
	        else if(!x.isEmpty())
	        {
	        	main_map.put(value, x);
				value++;
	        	//main_map.put(1, "black");
	        }
	            return main_map;
	        
	    }

}
