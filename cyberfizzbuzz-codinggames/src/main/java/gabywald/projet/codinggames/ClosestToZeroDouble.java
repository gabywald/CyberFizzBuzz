package gabywald.projet.codinggames;

/*
 * 
 * @author Gabriel Chandesris (2021)
 */
public class ClosestToZeroDouble {

	static double closestToZero(double[] doubles) {
	     double toReturn = ( (doubles == null) || (doubles.length > 0))? Double.MAX_VALUE : 0.0;

		boolean negative = false;
		boolean negativeTMP = false;

		for (int i = 0 ; i < doubles.length ; i++) {
			negativeTMP = (doubles[i] < 0);
			double temp = Math.abs(doubles[i]);

			System.out.println(temp);

			if (temp < toReturn) {
				toReturn = temp;
				negative = negativeTMP;
			} else if (temp == toReturn) {
				if ( ! negative) {
					negative = false;
				} else {
					negative = negativeTMP;
				}
			}

			System.out.println(toReturn + ":" + (negative?"true":"false"));
		}

		return ((negative)?-1:1) * toReturn;
	}

	public static void main(String[] args) {
		double[] ts = { 7, -10, 13, 8, 4, -7.2, -12, -3.7, 3.5, -9.6, 6.5, -1.7, -6.2, 7 };
		
		double result = ClosestToZeroDouble.closestToZero(ts);
		
		System.out.println( "Result: [" + result + "]" );
	}
	
}
