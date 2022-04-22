package gabywald.projet.classics;

import java.util.Objects;

/**
 * Aim of exercise : do / redo method "fib", do not touch other. 
 * @author Gabriel Chandesris (2022)
 */
public class Fibonacci {

	public static long fib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n < 0");
		}
		if (n == 0) { return 0; }
		if (n == 1) { return 1; }
		// prevN1 = "fib (n-1)"
		// prevN2 = "fib (n-2)"
		// if (n > 1) { return fib(n-1) + fib(n-2); }
		if (n > 1) {
			long sum = 0;
			long prevN1 = 1;
			long prevN2 = 0;
			for (int i = 2 ; i <= n ; i++) {
				sum = prevN1 + prevN2;
				prevN2 = prevN1;
				prevN1 = sum;
			}
			return sum;
		}
		
		
		return -1;
	}

	private static void assertEqual(Long actual, Long expected) {
		if (!Objects.equals(actual, expected)) {
			throw new AssertionError(
					String.format("Longs are not equal [actual=%s, expected=%s]", actual, expected));
		}
	}

	public static void main(String[] args) throws Exception {

		/*
		 * Fibonacci suite:
		 * - fib(0) = 0
		 * - fib(1) = 1
		 * - fib(n) = fib(n - 1) + fib(n -2)
		 */

		// tests
		Fibonacci.assertEqual(fib(0), 0L);
		Fibonacci.assertEqual(fib(1), 1L);
		Fibonacci.assertEqual(fib(2), 1L);
		Fibonacci.assertEqual(fib(3), 2L);
		Fibonacci.assertEqual(fib(4), 3L);
		Fibonacci.assertEqual(fib(5), 5L);
		Fibonacci.assertEqual(fib(6), 8L);
		Fibonacci.assertEqual(fib(10), 55L);
		System.out.println("Dummy tests passed.");

		try {
			fib(-1);
			throw new SecurityException("Expected exception wasn't thrown");
		} catch (IllegalArgumentException ex) {
			// Expect exception
		}
		System.out.println("Negative test passed.");

		System.out.println("Will check big value");
		Fibonacci.assertEqual(fib(80), 23416728348467685L);

		System.out.println("All tests passed.");
	}
}
