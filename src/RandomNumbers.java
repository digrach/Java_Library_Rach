import java.util.Random;


/**
 * @author colleyr
 *
 */
public class RandomNumbers {
	
	
	
	public static int randomNum(int inclusiveMax) {
		int num = 0;
		Random r = new Random();
		num = r.nextInt(inclusiveMax + 1);
		return num;
	}
	
	public static int randomIntInRange(int min, int max) {
		int num = 0;
		Random r = new Random();
		num = r.nextInt(max - min + 1) + min;
		return num;
	}
	
	public static double randomDouble() {
		double num = 0;
		Random r = new Random();
		num = r.nextDouble();
		return num;
	}
	
	public static double randomDoubleInRange() {
		double num = 0;
		Random r = new Random();
		double d = r.nextDouble();
		num = d * 100;
		
		return num;
	}
	
	
	
	

}
