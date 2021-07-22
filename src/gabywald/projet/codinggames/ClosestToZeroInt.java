package gabywald.projet.codinggames;

/*
 * 
 * @author Gabriel Chandesris (2021)
 */
public class ClosestToZeroInt {

	static int closestToZero(int[] ints) {
       int toReturn = ( (ints == null) || (ints.length > 0))? Integer.MAX_VALUE : 0;

		boolean negative = false;
		boolean negativeTMP = false;

		for (int i = 0 ; i < ints.length ; i++) {
			negativeTMP = (ints[i] < 0);
			int temp = Math.abs(ints[i]);

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
		int[] ts = { 7, -10, 13, 8, 4, 5, -5, 2, 7 }; // int[] ints = { -9, 8, 2, -5, 7 };
		
		double result = ClosestToZeroInt.closestToZero(ts);
		
		System.out.println( "Result: [" + result + "]" );
	}

}
