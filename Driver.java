package pckg1;
import java.util.Scanner;

public class Driver {

	/**
	 * 
	 * @param sentence
	 * @param shift takes the non-negative integer (between 0 and 25) by which to shift
	 * @return
	 */
	public static String decipherCaesar(String sentence, int shift) {
		final int a = 65;
		final int z= 90;
		final int A = 97;
		final int Z = 122;
		final int d0 = 48;
		final int d9 = 57;

		String deciphered = ""; // initialize to "" for compiler
		int temp; // will hold value of each char

		for (int i = 0; i<sentence.length();i++) {

			temp = sentence.charAt(i); // parse through string

			if (temp >= a && temp <= z) // if is a lower-case letter
				temp = (temp - a + shift) % (z-a) + a; // perform shift

			if   (temp >= A && temp <= Z) // if is a upper-case letter
				temp = (temp - A + shift) % (Z-A) + A;			

			if (temp >= d0 && temp <= d9) // if is a digit
				temp = (temp - 48 + 3)  % 10 + 48;
			deciphered = deciphered+(char)temp; // place in string
		}

		return deciphered;
	}


	public static void main(String[] args) {

		// WELCOME
		System.out.println("****** Welcome to the Caesar Cipher Decoder ******"
				+ "\n\nThis program decodes text that has been encrypted using the Caesar cipher."
				+ "\nThe Caesar cipher (or shift cipher) is a simple encryption technique.\nIt consists of shifting all texts of the alphabet by a fixed "
				+ "number of places down the alphabet."
				+ "\n\nFor instance, with a shift set at 1, “ABC” becomes “BCD”."
				+ "\nWith a shift set at -1, “ABC” becomes “ZAB”, and so on and so forth."
				+ "\nTaking a full sentence as an example, “Attack at once” encrypted using a shift value of 4 becomes “Exxego Ex Srgi”."
				+ "\n\nThe Caesar cipher is an elementary cryptographic method that is simple to break."
				+ "\nHowever, manually decoding a simple text can still be a laborious task, considering the 25 possible shifts."
				+ "\n\nThis program takes text that has been encoded using the Caesar cipher as input."
				+ "\nIt then crosschecks all 25 possible shifts against a database of 400,000+ words."
				+ "\nThe program then only return matches that include english words."); // Introduction


		
		// STREAMS
		Scanner keyboard = new Scanner(System.in); // will get input from keyboard

		//USER INPUT
		System.out.println("\n\nPlease enter the cipher to analyze:"); // prompt user for input
		System.out.println("(Suggestion: Try \"Qrw vr vhfuhw\""); // user suggestion in case the user does not have ready text to try
		String cipherText = keyboard.nextLine(); // getting user input

		System.out.println("You entered: "+ cipherText);
		
		System.out.println("Analyzing...\n"); // user feedback
		Dictionary dictio = new Dictionary(); // this object will cross check against the database
		boolean matchWasFound = false; // this boolean becomes true if at least one match is found
		String deciphered; // string that will hold all shifted ciphers
		int[] nbrMatches = new int[26];	// declaring array that will hold number of word matches for each shift
		int max = 0;
		
		for (int i = 0; i<25; i++) { // all possible shifts
			deciphered = (decipherCaesar(cipherText, i)); // check all possible shifts
			nbrMatches[i] = dictio.findMatchText(deciphered); // storing number of matches
					if (nbrMatches[i]>max) { // compare 
						max = nbrMatches[i]; // update new max
						matchWasFound = true; // a match has been found
					} // if
		} // for
		
		for (int i = 0; matchWasFound && i < nbrMatches.length; i++) { // all possible shifts
			if (max == nbrMatches[i])
				System.out.println("Match found at shift +"+i+": "+"\""+decipherCaesar(cipherText, i)+"\""); // check all possible shifts
		} // for
		
		
		if (!matchWasFound) // if no match was found
			System.out.println("No match found.");
		
		
		
		
		keyboard.close();// closing stream
		
	}

}
