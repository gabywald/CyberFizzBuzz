package gabywald.data.sirens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Basqic data analysis for SIREN (Corporate IDs). 
 * @author Gabriel Chandesris (2021)
 */
public class AnalysisOfSirensInput {
	/** Pattern to recognize correctly SIREN (corporation identification number). */
	private static Pattern siren = Pattern.compile("^([0-9]{9})$");
	
	/**
	 * Direct opening and analysis of file containing data. 
	 * <br />Attempted in file : a SIREN each line. 
	 * @param filePath Path to the file to analyze. 
	 * @return A Map with SIREN as key and count of it in value. (null if error about file. )
	 */
	public static Map<String, Integer> readAndAnalyseFile(String filePath) {
		Map<String, Integer> mapToReturn = new HashMap<String, Integer>();
		try {
			File currentFile = new File( filePath );
			Scanner myReader = new Scanner(currentFile);
			while (myReader.hasNextLine()) {
				String newLine = myReader.nextLine();
				Matcher m = AnalysisOfSirensInput.siren.matcher(newLine);
				if (m.matches()) {
					String siren = m.group(1);
					// if (siren.equals("177501111")) { System.out.println(siren); }
					// NOTE : Only if a SIREN is recognized !
					if (mapToReturn.containsKey(siren)) {
						mapToReturn.put(siren, mapToReturn.get(siren) + 1);
					} else {
						mapToReturn.put(siren, new Integer(1));
					}
				} // END "if (m.matches())"
			} // END "while (myReader.hasNextLine())"
			myReader.close();
		} catch (FileNotFoundException e) {
			return null;
		}

		return mapToReturn;
	}

}
