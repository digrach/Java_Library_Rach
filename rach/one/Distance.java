package rach.one;

public class Distance {
	
	// Subtracts coordinate2 from coordinate 1
	// Returns a positive int
	public static int distanceBetweenCoordinates(int coordinate1, int coordinate2) {
		int distance = 0;
		distance = coordinate1 - coordinate2;
		if (distance < 0) {
			distance = Math.abs(coordinate1 - coordinate2);
		}
		return distance;
	}
	
	public static double getPercentageOf(double percentage, double total) {
		double percentagePortionOfTotal = 0;
		percentagePortionOfTotal = (percentage * total) / 100;
		return percentagePortionOfTotal;
	}
	
	


}
