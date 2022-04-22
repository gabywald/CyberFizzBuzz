package gabywald.projet.classics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Aim of exercise : do / redo method "extractChunks", do not touch other. 
 * @author Gabriel Chandesris (2022)
 */
public class Chunks {

	/**
	 * Extract chunks from a list of non-breakable strings (items), according to a max chunk size.
	 *
	 * <p>Rules:
	 *
	 * <ul>
	 *   <li>You cannot split an item (e.g. cannot transform "foobar" into "foo" and "bar")
	 *   <li>If an item size is already greater than or equal maxChunkSize, consider it as a chunk (ok
	 *       for its size to be bigger than max one, e.g. "foobar" will be a chunk when maxChunkSize
	 *       is less than 6)
	 *   <li>You must put the maximal number of items in a chunk, while the global chunk size remains
	 *       less than or equal maxChunkSize
	 * </ul>
	 *
	 * <p>Samples:
	 *
	 * <ul>
	 *   <li>["1", "22", "333"], maxChunkSize=4 -> [["1", "22"], ["333"]]
	 *   <li>["22", "333", "1"], maxChunkSize=4 -> [["22"], ["333", "1"]]
	 *   <li>["333", "1", "22"], maxChunkSize=4 -> [["333", "1"], ["22"]]
	 *   <li>See unit tests in main method for more samples
	 * </ul>
	 *
	 * @param listToChunk list of items to chunk
	 * @param maxChunkSize max size of the item lengths sum of a chunk
	 * @return list of "list of" items
	 */
	public static List<List<String>> extractChunks(List<String> listToChunk, int maxChunkSize) {
		
		if (listToChunk == null) { return null; }
		
		List<List<String> > toReturn = new ArrayList<List<String> >();
		List<String> tmpsChunks = new ArrayList<String>();
		int tmpsLength = 0;
		
		for (String chunk : listToChunk) {
			if ( (tmpsLength + chunk.length()) > maxChunkSize ) {
				toReturn.add(tmpsChunks);
				tmpsChunks = new ArrayList<String>();
				tmpsLength = 0;
			}
			tmpsChunks.add(chunk);
			tmpsLength += chunk.length();
		}
		
		if ( ! tmpsChunks.isEmpty()) { 
			toReturn.add(tmpsChunks);
		}

		return toReturn;
	}
	
	private static void assertEqual(List<List<String>> actual, List<List<String>> expected) {

		String actualStr = Optional.ofNullable(actual).orElseGet(ArrayList::new).toString();
		String expectedStr = Optional.ofNullable(expected).orElseGet(ArrayList::new).toString();

		if (!Objects.equals(actualStr, expectedStr)) {
			throw new AssertionError(
					String.format(
							"Chunked lists are not equal [actual=%s, expected=%s]", actualStr, expectedStr));
		}
	}

	/**
	 * Implement the extractChunks method, and run this main maethod to validate your implementation.
	 *
	 * <p>No need to modify assertEqual method.
	 *
	 * @param args ignored params
	 */
	public static void main(String[] args) {

		// Sample from extractChunks javadoc
		Chunks.assertEqual(
				Chunks.extractChunks(Arrays.asList("1", "22", "333"), 4), Arrays.asList(Arrays.asList("1", "22"), Arrays.asList("333")));
		Chunks.assertEqual(
				Chunks.extractChunks(Arrays.asList("22", "333", "1"), 4), Arrays.asList(Arrays.asList("22"), Arrays.asList("333", "1")));
		Chunks.assertEqual(
				Chunks.extractChunks(Arrays.asList("333", "1", "22"), 4), Arrays.asList(Arrays.asList("333", "1"), Arrays.asList("22")));

		// Bigger samples
		List<String> reference = Arrays.asList("1", "22", "333", "4444", "ccc", "bb", "a");

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 1),
				Arrays.asList(
						Arrays.asList("1"),
						Arrays.asList("22"),
						Arrays.asList("333"),
						Arrays.asList("4444"),
						Arrays.asList("ccc"),
						Arrays.asList("bb"),
						Arrays.asList("a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 2),
				Arrays.asList(
						Arrays.asList("1"),
						Arrays.asList("22"),
						Arrays.asList("333"),
						Arrays.asList("4444"),
						Arrays.asList("ccc"),
						Arrays.asList("bb"),
						Arrays.asList("a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 3),
				Arrays.asList(
						Arrays.asList("1", "22"),
						Arrays.asList("333"),
						Arrays.asList("4444"),
						Arrays.asList("ccc"),
						Arrays.asList("bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 4),
				Arrays.asList(
						Arrays.asList("1", "22"),
						Arrays.asList("333"),
						Arrays.asList("4444"),
						Arrays.asList("ccc"),
						Arrays.asList("bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 5),
				Arrays.asList(
						Arrays.asList("1", "22"),
						Arrays.asList("333"),
						Arrays.asList("4444"),
						Arrays.asList("ccc", "bb"),
						Arrays.asList("a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 6),
				Arrays.asList(Arrays.asList("1", "22", "333"), Arrays.asList("4444"), Arrays.asList("ccc", "bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 7),
				Arrays.asList(Arrays.asList("1", "22", "333"), Arrays.asList("4444", "ccc"), Arrays.asList("bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 8),
				Arrays.asList(Arrays.asList("1", "22", "333"), Arrays.asList("4444", "ccc"), Arrays.asList("bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 9),
				Arrays.asList(Arrays.asList("1", "22", "333"), Arrays.asList("4444", "ccc", "bb"), Arrays.asList("a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 10),
				Arrays.asList(Arrays.asList("1", "22", "333", "4444"), Arrays.asList("ccc", "bb", "a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 15),
				Arrays.asList(Arrays.asList("1", "22", "333", "4444", "ccc", "bb"), Arrays.asList("a")));

		Chunks.assertEqual(
				Chunks.extractChunks(reference, 16), Arrays.asList(Arrays.asList("1", "22", "333", "4444", "ccc", "bb", "a")));

		Chunks.assertEqual(extractChunks(Arrays.asList("1"), 42), Arrays.asList(Arrays.asList("1")));

		Chunks.assertEqual(extractChunks(Collections.emptyList(), 42), Collections.emptyList());

		Chunks.assertEqual(extractChunks(null, 42), null);
	}
}
