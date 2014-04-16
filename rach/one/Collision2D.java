package rach.one;

public class Collision2D {
	
	public static boolean isXCollision(int x1, int x2, int collisionSpan) {
		boolean bool = false;
		if(x1 >= x2 - collisionSpan && x1 <= x2 + collisionSpan) {
			return true;
		}
		return false;
	}
	
	public static boolean isYCollision(int y1, int y2, int collisionSpan) {
		boolean bool = false;
		if(y1 >= y2 - collisionSpan && y1 <= y2 + collisionSpan) {
			return true;
		}
		return false;
	}
	
	
	

}
