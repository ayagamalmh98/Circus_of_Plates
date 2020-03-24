package model.pool;

public class ConnectionPool extends PoolObject<RondomShapes> {

	private final int MAXIMUM = 100; 
	
	public ConnectionPool(String ee) {
		System.out.println("conne"+ee);
		initialize(MAXIMUM,ee);
	}
	
}
