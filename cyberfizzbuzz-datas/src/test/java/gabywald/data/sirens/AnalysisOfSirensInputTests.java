package gabywald.data.sirens;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalysisOfSirensInputTests {
	
	private static void sampleReadAndAnalysisFile(String pathToFile, int attemptedOnce, int attemptedMore, int attemptedTotal) {
		Map<String, Integer> mapSirenCounters = AnalysisOfSirensInput.readAndAnalyseFile(pathToFile);
		Assertions.assertNotNull(mapSirenCounters);
		int singleSIREN = 0;
		int moreThanOneSIRENS = 0;
		for (String siren : mapSirenCounters.keySet()) {
			// System.out.println( siren + "/" + mapSirenCounters.get(siren) );
			// if (siren.equals("177501111")) { System.out.println("**" + siren); }
			if (mapSirenCounters.get(siren) == 1) {
				singleSIREN++;
			} else {
				moreThanOneSIRENS++;
			}
		}
		
		System.out.println("SIREN present once: [" + singleSIREN + "]");
		System.out.println("SIREN present more: [" + moreThanOneSIRENS + "]");
		System.out.println("SIREN present total: [" + mapSirenCounters.size() + "]");
		
		Assertions.assertEquals(attemptedOnce, singleSIREN);
		Assertions.assertEquals(attemptedMore, moreThanOneSIRENS);
		Assertions.assertEquals(attemptedTotal, mapSirenCounters.size());
	}
	
	@Test
	void testBadFile01() {
		Map<String, Integer> mapSirenCounters = AnalysisOfSirensInput.readAndAnalyseFile("");
		Assertions.assertNull(mapSirenCounters);
	}
	
	@Test
	void testBadFile02() {
		Map<String, Integer> mapSirenCounters = AnalysisOfSirensInput.readAndAnalyseFile("yolo.txt");
		Assertions.assertNull(mapSirenCounters);
	}

	@Test
	void testReadAndAnalyseFileAttempted() {
		AnalysisOfSirensInputTests.sampleReadAndAnalysisFile(
				"src/test/resources/sirens_fxt.txt", 
				77442, 2256, 77442 + 2256); // 79698
	}
	
	@Test
	void testReadAndAnalyseFileLittleTest01() {
		AnalysisOfSirensInputTests.sampleReadAndAnalysisFile(
				"src/test/resources/sirens_littleTest01.txt", 
				2, 1, 3);
	}
	
	@Test
	void testReadAndAnalyseFileLittleTest02() {
		AnalysisOfSirensInputTests.sampleReadAndAnalysisFile(
				"src/test/resources/sirens_littleTest02.txt", 
				2, 5, 7);
	}

}
