# CaesarCipher
This program decodes text that has been encrypted using the Caesar cipher.
The Caesar cipher (or shift cipher) is a simple encryption technique.\nIt consists of shifting all texts of the alphabet by a fixed
number of places down the alphabet.
For instance, with a shift set at 1, “ABC” becomes “BCD”.
With a shift set at -1, “ABC” becomes “ZAB”, and so on and so forth.
Taking a full sentence as an example, “Attack at once” encrypted using a shift value of 4 becomes “Exxego Ex Srgi”.
The Caesar cipher is an elementary cryptographic method that is simple to break.
However, manually decoding a simple text can still be a laborious task, considering the 25 possible shifts.
This program takes text that has been encoded using the Caesar cipher as input.
It then crosschecks all 25 possible shifts against a database of 400,000+ words.
The program then only return matches that include english words.
