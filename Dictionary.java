package pckg1;
import java.io.*;
import java.util.Scanner;

public class Dictionary {
	protected Scanner reader;

	/**
	 * CONSTRUCTOR
	 */
	public Dictionary() { 


	}

	/**
	 * FIND MATCH
	 * @param word
	 * @return
	 */
	public boolean findMatch(String word) {
		String compare; // hold each line to compare

		try {
			reader = new Scanner(new FileInputStream("engmix.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		while(reader.hasNextLine()) {
			compare = reader.nextLine();

			if (word.equalsIgnoreCase(compare)) {
				reader.close();// closing stream
				return true;
			} // if

		} // while

		return false; // if didn't find match
	}

	/**
	 * FIND MATCH TEXT
	 * @param text
	 * @return
	 */
	public int findMatchText(String text) {
		int nbrMatches = 0;
		String[] words = text.split("\\W+"); // splits string into words
	
			for (int i = 0; i<words.length; i++) {	
				if (this.findMatch(words[i]))
					nbrMatches++; // if finds match
		}
			
		return nbrMatches;	// if never matches
	}
}