package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public static String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String newAcronym = ""; //first, create a string for the new acronym we're making
		char[] holder;		//this char array is used to test the letters of the phrase given.
		holder = phrase.toCharArray();
		for(int i = 0; i <= holder.length - 1; i++) { //this for loop iterates through each character of the string
			if(Character.isLetter(holder[i]) == false){//if the letter at the index is not a letter, continue until hitting a letter
				//do nothing if this is not a letter
			} else { //do this when the array hits a letter
				newAcronym += holder[i];     //once we hit a letter, add it to the acronym.
				while(i <= holder.length - 1) {//however, we don't want every letter in a word to add to the new acronym.
					//while we're still within the scope of the array's length
					if(Character.isLetter(holder[i])) { //if the array is still on a letter, that means there are multiple letters in a row.  We only want the first letter, so we increment and keep searching
						i++;
					} else {//the array is not viewing a letter at this point.  That means the next letter we hit will be the beginning of a new word, and we can break out of this while loop.
						break;
					}//end of if else
					
				}//end of while
			
			}//end of if else
		}//end of for loop
		return newAcronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			boolean equBool = false; //this is the boolean we'll return at the end
			
			//we only need two if statements here as opposed to three, because if one side matches the other two, we know that the other two also match each other.
			if(sideOne == sideTwo) { //first, are sides 1 and 2 equal
				if(sideOne == sideThree) { //if 1 and 2 are equal, we can check side 3.  If sides 1 and 3 are equal, all three sides are equal
					equBool = true; //if all 3 sides are equal, we can set the bool to true
				}
			}
			
			return equBool;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean isoBool = false; //this is the boolean we'll return at the end
			
			//if any two sides are equal, the triangle is isosceles.  We just need to compare each side with each other side.
			if(sideOne == sideTwo) {//if side 1 matches side 2
				isoBool = true;
			} else if(sideOne == sideThree) {//if side 1 matches side 3
				isoBool = true;
			} else if(sideTwo == sideThree) {//if side 2 matches side 3
				isoBool = true;
			}
			
			
			return isoBool;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			boolean scalBool = true; //this is the boolean we'll return at the end
			
			//this code functions opposite of isoceles.  Basically, if any side matches length, then the triangle is not scalene.
			if(sideOne == sideTwo) {//if side 1 matches side 2
				scalBool = false;
			} else if(sideOne == sideThree) {//if side 1 matches side 3
				scalBool = false;
			} else if(sideTwo == sideThree) {//if side 2 matches side 3
				scalBool = false;
			}
			
			return scalBool;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0; //this is the score value we'll return at the end
		char [] holder = string.toCharArray(); //holder contains a char array of everything in the string passed in
		
		for(char a : holder) { //this for each loop iterates through each letter in the char array
			a = Character.toLowerCase(a); //this ensures that all letters give points, because the following switch has no uppercase letters
			switch (a) { //this switch goes through different letters to determine how many points to add to the score
				case 'a':
					score += 1;
					break;
				case 'b':
					score += 3;
					break;
				case 'c':
					score += 3;
					break;
				case 'd':
					score += 2;
					break;	
				case 'e':
					score += 1;
					break;
				case 'f':
					score += 4;
					break;
				case 'g':
					score += 2;
					break;
				case 'h':
					score += 4;
					break;
				case 'i':
					score += 1;
					break;
				case 'j':
					score += 8;
					break;
				case 'k':
					score += 5;
					break;
				case 'l':
					score += 1;
					break;
				case 'm':
					score += 3;
					break;
				case 'n':
					score += 1;
					break;
				case 'o':
					score += 1;
					break;
				case 'p':
					score += 3;
					break;
				case 'q':
					score += 10;
					break;
				case 'r':
					score += 1;
					break;
				case 's':
					score += 1;
					break;
				case 't':
					score += 1;
					break;
				case 'u':
					score += 1;
					break;
				case 'v':
					score += 4;
					break;
				case 'w':
					score += 4;
					break;
				case 'x':
					score += 8;
					break;
				case 'y':
					score += 4;
					break;
				case 'z':
					score += 10;
					break;
			}//end of switch on a
				
		}//end of for each loop.  The score should be calculated based on every letter in the char array
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		// TODO Write an implementation for this method declaration
		char [] firstPassArray = string.toCharArray(); //first, get the string as a char array so it is easier to iterate through
		String onlyNumbers = ""; //this string will hold only the numbers from the input
		
		for(char a : firstPassArray) { //this for each loop checks to see whether the char array contains anything that is not a number, and if it does, it discards it
			if(Character.isDigit(a)) {//if the character is a digit
				onlyNumbers += Character.toString(a); //the onlynumbers string will only hold numbers
			}
		} //this loop is useful because it automatically discards any letters, spaces, or special characters
		
		//it may seem like we're only checking length with this if if else statement.
		//However, since we discarded letters, spaces, and special characters, the remaining number of digits is very likely to be more than 11 or less than 10.
		//Those characters are still accounted for with these illegal argument throws.
		if(onlyNumbers.length() > 11) { //next we check length.  If the number is longer than 11, throw an exception
			throw new IllegalArgumentException();
		} else if (onlyNumbers.length() < 10) {  //similarly, if the number is shorter than 10, throw an exception
			throw new IllegalArgumentException();
		}
		
		if(onlyNumbers.length() == 11) {//if the number is 11 digits long, we need to remove the country code
			onlyNumbers = onlyNumbers.substring(1);		
		}
		
		return onlyNumbers;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
		string = string.replace("\n", ""); //first, I remove the new line string occurences completely.
		string = string.replace(",", " "); //here, I replace commas with spaces.  This ensures that there are only words and spaces left in the input before we start to fill in the map
		
		Map<String, Integer> wordMap = new HashMap<>(); //this is the map we'll return at the end
		
		while(string.length() > 0) {
			int spaceIndex = string.indexOf(" "); //here, we look for any spaces
			if(spaceIndex != -1) { //if this index is not -1, then we found a space
				String holder = string.substring(0, spaceIndex); //so we fill a placeholder string with the word we just found
				string = string.substring(spaceIndex + 1);		//and we cut the string input we received to the next word
				addToMap(wordMap, holder);						//this addToMap method adds the key to the map based on whether it is a duplicate or not
			} else {				//this block runs when there are no spaces left
				String holder = string;		//we set the placeholder to be the rest of the string
				string = "";				//we empty the string so the while loop stops running
				addToMap(wordMap, holder);	//we add the final key to the map
			}
			
		}
		
		return wordMap;
	}
	
	private void addToMap(Map<String, Integer> m, String s) { //this method adds keys and values to our map
		
		if(m.containsKey(s)) { //if the map already has that key, we can't add it again
			int val = m.get(s); //instead, we get the value held in the map
			val++;				//and we increase it by one
			m.replace(s, val);  //and replace the value of the key with the new value
		} else {				//if the map doesn't have that key
			m.put(s, 1);		//we put in a new entry and set the value to one
		}
		
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int first = 0;	//this integer will always hold the first index of the search area
			int last = sortedList.size() - 1; //this integer will always hold the last index of the search area
			int checkedIndex = (first + last)/2;		  //this integer will hold the index that we search at, the middle
			Object returnedVal = checkAtIndex(sortedList, checkedIndex); //this object holds the item that we find from the list
			
			System.out.println(checkedIndex);
			//checkAtIndex() looks in the list at the provided index
			String tStrConv = t.toString();					//in order to ensure we can compare the values of the input and what we found in the search
			int tIntConv = Integer.parseInt(tStrConv);		//we need to convert the input to a string, which is something most objects can do
			String rvStrConv = returnedVal.toString();		//and then convert that string into an integer, using Integer.parseInt
			int rvIntConv = Integer.parseInt(rvStrConv);	//once both values are integers, we can safely compare them to determine the new search parameters
			
			while(tIntConv != rvIntConv) { //if the returned value doesn't match the input t, we need to keep running the search
				
				if(rvIntConv > tIntConv) {		//if the returned value is greater than the input
					last = checkedIndex;		//we need to reduce the last index to the place we checked
				} else {						//if the returned value is less than the input
					first = checkedIndex;		//we need to increase the first index to the place we checked
				}
				checkedIndex = (first + last)/2;
				
				returnedVal = checkAtIndex(sortedList, checkedIndex);
				
				rvStrConv = returnedVal.toString();		//and then convert that string into an integer, using Integer.parseInt
				rvIntConv = Integer.parseInt(rvStrConv);	//once both values are integers, we can safely compare them to determine the new search parameters
				
				if(last - first == 1) {							   //this check prevents infinite loops. Because of rounding, sometimes
					returnedVal = checkAtIndex(sortedList, first); //this loop would never check the end of the array.
					rvStrConv = returnedVal.toString();			   //this method specifically makes sure the ends get checked
					rvIntConv = Integer.parseInt(rvStrConv);	   //we check both the first and last indices of the search
					if(rvIntConv == tIntConv) {					   //and return whichever index has the value we need
						return first;
					}
					returnedVal = checkAtIndex(sortedList, last);
					rvStrConv = returnedVal.toString();
					rvIntConv = Integer.parseInt(rvStrConv);
					if(rvIntConv == tIntConv) {
						return last;
					}
					return -1;									  //if the value is not in the first or last index when they're next to each other, its not in the list
				}
				
				
				if(first == last && tIntConv != rvIntConv) {	//if the first and last indices match and we haven't found the input 
					return -1;							//then the value does not exist in the list. return a -1 to indicate this
				}
				
			}
			
			return checkedIndex; //we return the index once we find the value that matches t
		}
		
		private synchronized Object checkAtIndex(List l, int i) {//this method searches the list at the specified index		
			Object T; //we use a generic object because different datatypes could be in the list
			T = l.get(i);	//here we get the object that is at the given index
			return T;		//and we return it as an object
		}
		
		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String retStr = ""; //this is the string we will return at the end
		List<String> strList = new ArrayList<>(); //this list will hold each individual word for us to check
		
		while(string.length() > 0) { //here I borrow the code I wrote for Question 6's wordCount() method
			int spaceIndex = string.indexOf(" "); //here, we look for any spaces
			if(spaceIndex != -1) { //if this index is not -1, then we found a space
				strList.add(string.substring(0, spaceIndex));   //so we fill the string arraylist with the word we just found
				string = string.substring(spaceIndex + 1);		//and we cut the string input we received to the next word
			} else {				//this block runs when there are no spaces left
				strList.add(string);		//we add the rest of the string the arraylist
				string = "";				//we empty the string so the while loop stops running
			}
		}
		
		for(String word : strList) { //now we need to check every word to apply rules to it
			retStr += checkVowel(word); //and we add the results to our return string
		}
		
		retStr = retStr.trim();	//here we remove any trailing spaces
		
		return retStr;
	}
	
	private String checkVowel(String w) {
		char firstLetter = w.charAt(0);	//here we get the first letter of the word to see if it is a vowel
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};	//this char array contains all of the vowels
		for(char check : vowels) {		//this for loop iterates through every vowel
			if(firstLetter == check) {	//if the first letter of a given word is a vowel
				return (w + "ay ");		//we return the word with "ay " at the end. We add a space in case this is not the last word
			}
		}
		
		return checkConsonant(w);	//if the for loop didn't return a value, that means the first letter is a consonant, so we'll return the results from a new method
	}
	
	private String checkConsonant(String w) {
		String endString = "";	//this string will hold the letters we put at the end of the word
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};	//this char array contains all of the vowels
		
		for(int i = 0; i <= w.length() - 1; i++) { //this for loop checks two conditions: one, is the current letter a vowel?
												   //two, is the current letter a 'q'? both of these are important to determine
			for(char check : vowels) {	//if the current character is a vowel
				if(w.charAt(i) == check) {
					endString += "ay ";   //then we've reached the end of the consonants, so we add ay to the end of our end string
					w = w.substring(i); //we remove all the letters before our current one in the word
					return (w + endString);	//and return the word plus the endstring
				}
			}
			
			if(w.charAt(i) == 'q') { //if the current character is a q
				endString += "quay "; //then we know the next letter is a u, based on most English language words
				w = w.substring(i + 2); //since the letter after q is a vowel, we know that we need to stop removing letters, so we immediately substring from the 3rd remaining letter on
				return (w + endString); //we return the rest of the word plus "quay"
			}
			
			endString += w.charAt(i); //If the loop is still going, the current letter is not a vowel or a q, and we can safely add it to our endstring, and do another loop
		}
		
		return (w + "ay "); //If we reached this point, that means the word has no vowels or qs.  Thus, we simply return the input word + "ay ".
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		boolean armBool = false; //this is the boolean we will return at the end if the number is an armstrong number
		double addedUp = 0; //this double will keep track of the total value as we add the digits up
		int numToMod = input; //this integer will start the same as input, then gradually go down to zero as we pull numbers from it
		
		List<Integer> intArr = new ArrayList<>(); //this int arraylist will hold all the integers as we pull them using modulus
		
		while (numToMod > 0) {			//this while loop adds all of the digits from the input into the int arraylist.
			intArr.add(numToMod % 10);  //By getting the remainder of modulus 10, we can get the digit for each place of the number
			numToMod /= 10;				//Then we actually divide by 10 so we can move on to the next digit on the next loop
			//System.out.println(numToMod);
		}
		
		for(int i = 0; i <= intArr.size() - 1; i++) { //this for loop uses Math.pow to raise each index in the arraylist to the power of the size of the arraylist.
			addedUp = addedUp + (Math.pow(intArr.get(i), intArr.size()));
		}
		
		double doubInput = input; //math.pow doesnt accept integers, so to compare the values, we use a double version of the input
		
		if (addedUp == doubInput) { //if the addedUp total from the loop equals the input, return true. else, return false
			armBool = true;
		} else {
			armBool = false;
		}
		
		return armBool;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		long [] primeNumbersUpTo500 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
										113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
										241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379,
										383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499};
										//this long array contains all of the prime numbers up to 500.
										//Before anything else, we're going to check and see if the input l is prime.
		for (long prime : primeNumbersUpTo500) { //for each number in the array of primes
			
			if(l == prime) { //if l is a prime number
				return Arrays.asList(l);	//return l as a list 
			} else if(prime > l) {//if the prime number is greater than l
				break; //then we need to break out of the loop, there's no need to check the rest of the array
			}
			
		}
		
		List<Long> factors = new ArrayList<Long>(); //this array list will hold all of the factors we find
		
		while(l != 1L) { //if the long isn't equal to one, do this loop
			
			for (long prime : primeNumbersUpTo500) { //this for each loop checks each prime in the long array
				if(l % prime == 0) { //if there is no remainder from dividing l by the prime number
					l = l / prime;	 //then divide l by that prime number
					factors.add(prime); //and add that number as a factor
					break;
				} else if(prime > l) { //again, if the prime number is greater than l
					break; //we need to break out of the loop, no need to check every number
				} //although, in theory, this else if should never run.
			}
			
		}
		
		
		
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			
			//note, ascii codes 65-90 are uppercase letters, 97-122 are lowercase letters
			
			
			char [] holder = string.toCharArray(); //first, create a char array to iterate through the characters more easily
			boolean [] uppArr = new boolean[holder.length]; //this array will hold whether the character was capital or not
			
			for (int i = 0; i < holder.length; i++) { //here, we iterate through the char array
				if(Character.isUpperCase(holder[i])) {	//if a character is uppercase, we convert it lowercase
					uppArr[i] = true;					//but we also store that the char was upper in our bool array
					holder[i] = Character.toLowerCase(holder[i]);
				} else {
					uppArr[i] = false;					//if the character is lowercase, we put false in our bool array
				}
			}
			
			int i = 0;		//this int will be used to keep track of the index in the boolean array
			string = "";	//here we clear out the string, so we can insert letters as we do key operations on them
			
			for (char c : holder) {	//for each character in the char array
				
				if(Character.isLetter(c)) { //we only care about letters, not numbers or punctuation
				
					c = (char)(c + key);	//we increase the char by the key. we use a char cast because key is an int
					while(c > 122) {		//if c is greater than 122, it isn't a letter anymore
						c = (char)(c - 26); //so we subtract 26 to bring c back into the alphabet
					}
					if(uppArr[i] == true) { //additionally, if the letter was supposed to be uppercase
						c = (char)(c - 32); //we subtract 32 to get the equivalent uppercase letter
					}
				}
				i++;			//finally, we increment i for our uppArr
				string += c;	//and we add to char back into our string
			}
			
			string = string.trim();	//we trim any whitespace before or after the string
			
			return string;	//we return the value contained in string
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException{
		// TODO Write an implementation for this method declaration
		List<Integer> primeArr = new ArrayList<>(); //first, we make an array to hold all of the prime numbers we find
		
		if(i <= 0) {	//if looking for the 0th or negative prime integer, throw an exception
			throw new IllegalArgumentException();
		}
		
		for(int j = 0; i != primeArr.size(); j++) { //here, j will be the number we're checking to see if it is prime
													//as long as i is not equal to the size of the array, we'll keep checking
													//each time we loop, we increase j so we can check a new int
			
			if(primeArr.isEmpty()) {	//first, if the prime array is empty
				primeArr.add(2);		//we add 2
				j = 2;					//and we set j to be 2
			} else {
				for(int prime : primeArr) {	//otherwise, we're going to iterate through the array of prime numbers
					
					if(j % prime == 0) {	//if j can be divided by the prime numbers with no remainder,
						break;				//break out of this loop, the number is not prime
					} else {
						if(prime == primeArr.get(primeArr.size() - 1)) { //if j cannot be divided by the prime numbers, and we've reached the end of the prime array.
							primeArr.add(j);	//if j wasnt divisible by anything in the prime array, j is prime, so we add it to the array
							break;
						}

						//if we aren't on the last prime, we keep going through this loop
						
					}
				}
				
			}
			
			if(i == primeArr.size()) { //if the prime number array is big enough to hold the index we're looking for
				return primeArr.get(i - 1);	//return the prime number at that index
			}
			
			

			
		}
		
		
		return 0;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			//note, ascii codes 65-90 are uppercase letters, 97-122 are lowercase letters
			
			char [] holder = string.toCharArray();
			String retStr = "";
			int i = 0;
			for (char c : holder) {
				c = Character.toLowerCase(c);
				if(c >= 97 && c <= 122) {
					
					if(c <= 109) {
						c = (char)(110 +(109 - c));	
					} else {//c >= 110
						c = (char)(109 +(110 - c));
					}
					
					
				}else if(c >= 48 && c <= 57) {
					
					//do no calculations
					
				} else {
					continue; //if c isn't a letter or number, we need to escape this loop, we can't use punctuation or special chars
				}
				
				if(i % 5 == 0 && i != 0) {
					retStr += " ";
				}
				
				retStr += c;
				i++;
			}
			
			retStr.trim();
			
			return retStr;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//note, ascii codes 65-90 are uppercase letters, 97-122 are lowercase letters
			//this method works almost exactly like encode.  The only difference is we don't add " " every 5 characters
			char [] holder = string.toCharArray();
			String retStr = "";
			int i = 0;
			for (char c : holder) {
				c = Character.toLowerCase(c);
				if(c >= 97 && c <= 122) {
					
					if(c <= 109) {
						c = (char)(110 +(109 - c));	
					} else {//c >= 110
						c = (char)(109 +(110 - c));
					}
					
					
				}else if(c >= 48 && c <= 57) {
					
					//do no calculations
					
				} else {
					continue; //if c isn't a letter or number, we need to escape this loop, we can't use punctuation or special chars
				}
				
				retStr += c;
				i++;
			}
			
			retStr.trim();
			
			return retStr;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		char[] holder = string.toCharArray();
		int[] intArr = new int[holder.length - 3];
		int i = 0;
		for(char c : holder) {
			if(Character.isDigit(c)) {
				intArr[i] = c - 48; //minus 48 because 0 in the ascii table is 48
				i++;
			} else if(c == 88) { //88 is the ascii code for X
				if(i == 9) {
					intArr[i] = 10;
					i++;
				} else { //if X isn't in the last position, return false
					return false;
				}
			} else if(c == 45) { //45 is the ascii code for -
				
			} else { //if the character isn't a digit, hypen, or X
				return false;
			}
			
		}
		
		int total = 0;
		
		for(int x : intArr) {
			total += x * (i);
			i--;
		}
		
		return (total % 11 == 0);
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		Set<Character> strSet = new TreeSet<>();
		for(char c : string.toCharArray()) {
			if(c >= 97 && c <= 122) {
				strSet.add(c);
			}
		}
		
		string = "";
		for(char c : strSet) {
			string += c;
		}
		
		if(string.equals("abcdefghijklmnopqrstuvwxyz")) {
			return true;
		}
		
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
		int days = 0;
		int months = 0;
		int years = 0;
		
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		
		try{
			days = ((LocalDateTime) given).getDayOfMonth();
			months = ((LocalDateTime) given).getMonthValue();
			years = ((LocalDateTime) given).getYear();
			seconds = ((LocalDateTime) given).getSecond();
			minutes = ((LocalDateTime) given).getMinute();
			hours = ((LocalDateTime) given).getHour();
		}catch (ClassCastException e) {
			//e.printStackTrace();
			days = ((LocalDate) given).getDayOfMonth();
			months = ((LocalDate) given).getMonthValue();
			years = ((LocalDate) given).getYear();
		}
		
		int totalSeconds = 0;
		final int secondsPerDay = 24 * 60 * 60;
		final int secondsPerMinute = 60;
		final int secondsPerHour = 60 * 60;
		final int secondsPerYear = 365 * 24 * 60 * 60;

		
		while(totalSeconds < 1000000000) { //get into right year
			if(years % 4 == 0) {
				totalSeconds += secondsPerDay;
			}
			years++;
			totalSeconds += secondsPerYear;
		}
		
		if(totalSeconds > 1000000000) { //subtract a year if over
			years--;
			totalSeconds -= secondsPerYear;
		}
		
		while(totalSeconds < 1000000000) { //get into right month
			
			if(months == 2) { //if february
				if(years % 4 == 0) { 
					totalSeconds += 29 * secondsPerDay; //if a leap year
				} else {
					totalSeconds += 28 * secondsPerDay; //if not a leap year
				}
			} else if(months == 4 || months == 6 || months == 9 || months == 11) {
				totalSeconds += 30 * secondsPerDay; //if april, june, september, november
			} else {
				totalSeconds += 31 * secondsPerDay; //if any other month
			}
				
			months++;
			if(months == 13) { //if we go over 12 months, add a year
				months = 1;
				years++;
			}
		}
		
		if(totalSeconds > 1000000000) { //subtract a month if over
			
			if(months == 3) { //if we're going back to february
				if(years % 4 == 0) { 
					totalSeconds -= 29 * secondsPerDay; //if a leap year
				} else {
					totalSeconds -= 28 * secondsPerDay; //if not a leap year
				}
			} else if(months == 5 || months == 7 || months == 10 || months == 12) {
				totalSeconds -= 30 * secondsPerDay; //if going back to april, june, september, november
			} else {
				totalSeconds -= 31 * secondsPerDay; //if going back to any other month
			}
								
			months--;
			if(months == 0) { //if we go under 1 month, subtract a year
				months = 12;
				years--;
			}
		}
		
		while(totalSeconds < 1000000000) {//get into right day
			days++;
			totalSeconds += secondsPerDay;
			if(days == 29 && months == 2 && years % 4 != 0) { //if february and not a leap year
				days = 1;
				months++;
			} else if(days == 30 && months == 2 && years % 4 == 0) { //if february and a leap year
				days =  1;
				months++;
			} else if(days == 31) {
				if(months == 4 ||months == 6 ||months == 9 ||months == 11) {
					days = 1;
					months++; //if the month is april, june, september, november
				}				
			} else if(days == 32) {
				days = 1;
				months++; //if the month is any other month
				if(months == 13) {
					months = 1;
					years++; //if we cross from december into january
				}
			}
		}
		
		if(totalSeconds > 1000000000) { //subtract a day if over
			days--;
			totalSeconds -=secondsPerDay;
			if(days == 0) {
				if(months == 3) {
					if(years % 4 == 0) {
						days = 29;
					} else {
						days = 28;
					}
					months--;
				} else if(months == 5 ||months == 7 ||months == 10 ||months == 12) {
					days = 30;
					months--;
				} else {
					days = 31;
					months--;
					if(months == 0) {
						months = 12;
						years--;
					}
				}
			}
		}
		
		while(totalSeconds < 1000000000) { //set to correct hour
			hours++;
			totalSeconds += secondsPerHour;
			if(hours == 24) { //if hit 24 hours, set to 0
				hours = 0;
				days++;
				if(days == 29 && months == 2 && years % 4 != 0) { //if february and not a leap year
					days = 1;
					months++;
				} else if(days == 30 && months == 2 && years % 4 == 0) { //if february and a leap year
					days =  1;
					months++;
				} else if(days == 31) {
					if(months == 4 ||months == 6 ||months == 9 ||months == 11) {
						days = 1;
						months++; //if the month is april, june, september, november
					}				
				} else if(days == 32) {
					days = 1;
					months++; //if the month is any other month
					if(months == 13) {
						months = 1;
						years++; //if we cross from december into january
					}
				}
			}
		}
		
		if(totalSeconds > 1000000000) { //if over, go back an hour
			hours--;
			totalSeconds -= secondsPerHour;
			if(hours == -1) {
				hours = 23;
				days--;
				if(days == 0) {
					if(months == 3) {
						if(years % 4 == 0) {
							days = 29;
						} else {
							days = 28;
						}
						months--;
					} else if(months == 5 ||months == 7 ||months == 10 ||months == 12) {
						days = 30;
						months--;
					} else {
						days = 31;
						months--;
						if(months == 0) {
							months = 12;
							years--;
						}
					}
				}				
			}
		}
		
		while(totalSeconds < 1000000000) { //set to correct minutes
			minutes++;
			totalSeconds += secondsPerMinute;
			if(minutes == 60) {
				minutes = 0;
				hours++;
				if(hours == 24) { //if hit 24 hours, set to 0
					hours = 0;
					days++;
					if(days == 29 && months == 2 && years % 4 != 0) { //if february and not a leap year
						days = 1;
						months++;
					} else if(days == 30 && months == 2 && years % 4 == 0) { //if february and a leap year
						days =  1;
						months++;
					} else if(days == 31) {
						if(months == 4 ||months == 6 ||months == 9 ||months == 11) {
							days = 1;
							months++; //if the month is april, june, september, november
						}				
					} else if(days == 32) {
						days = 1;
						months++; //if the month is any other month
						if(months == 13) {
							months = 1;
							years++; //if we cross from december into january
						}
					}
				}
			}
		}
		
		if(totalSeconds > 1000000000) { //if over by a minute, go back a minute
			minutes--;
			totalSeconds -= secondsPerMinute;
			if(minutes == -1) {
				minutes = 59;
				hours--;
				if(hours == -1) {
					hours = 23;
					days--;
					if(days == 0) {
						if(months == 3) {
							if(years % 4 == 0) {
								days = 29;
							} else {
								days = 28;
							}
							months--;
						} else if(months == 5 ||months == 7 ||months == 10 ||months == 12) {
							days = 30;
							months--;
						} else {
							days = 31;
							months--;
							if(months == 0) {
								months = 12;
								years--;
							}
						}
					}				
				}
			}
		}
		
		while(totalSeconds < 1000000000) {
			seconds++;
			totalSeconds++;
			if(seconds == 60) {
				seconds = 0;
				minutes++;
				if(minutes == 60) {
					minutes = 0;
					hours++;
					if(hours == 24) { //if hit 24 hours, set to 0
						hours = 0;
						days++;
						if(days == 29 && months == 2 && years % 4 != 0) { //if february and not a leap year
							days = 1;
							months++;
						} else if(days == 30 && months == 2 && years % 4 == 0) { //if february and a leap year
							days =  1;
							months++;
						} else if(days == 31) {
							if(months == 4 ||months == 6 ||months == 9 ||months == 11) {
								days = 1;
								months++; //if the month is april, june, september, november
							}				
						} else if(days == 32) {
							days = 1;
							months++; //if the month is any other month
							if(months == 13) {
								months = 1;
								years++; //if we cross from december into january
							}
						}
					}
				}
			}
		}
		
		return LocalDateTime.of(years, months, days, hours, minutes, seconds);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
				int total = 0;
				Set<Integer> multSet = new HashSet<>();
				
				int lastVal = 0;
				int counter = 1;
				
				for(int s : set) {
					while(lastVal < i) {
						lastVal = s * counter;
						counter++;
						if(lastVal < i) {
							multSet.add(lastVal);
						}
					}
					counter = 1;
					lastVal = 0;
				}
				
				for(int m : multSet) {
					total += m;
				}
				
				return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
				List<Integer> intList = new ArrayList<>();
				
				for(char c : string.toCharArray()) {
					if(Character.isDigit(c)) {
						intList.add(c - 48);
					} else if (c == ' ') {
						//don't add it to the int list
					} else { //if the char is not a digit or a space
						return false;
					}
				}
				
				Set<Integer> indexSet = new HashSet<>();
				int counter = 2;
				int size = intList.size();
				while(counter <= size) {
					indexSet.add(size - counter);
					counter += 2;
				}
				
				for(int i : indexSet) {
					int newVal = intList.get(i) * 2;
					if(newVal > 9) {
						newVal = newVal - 9;
					}
					intList.set(i, newVal);
				}
				
				int total = 0;
				for(int j : intList) {
					total += j;
				}
				
				
				return (total % 10 == 0);
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toLowerCase();
		string = string.replace("?", "");
		string = string.replace("what", "");
		string = string.replace("is", "");
				
		int firstVal = 0;
		int secondVal = 0;
		int result = 0;
		String operation = "";
				
		List<String> strList = new ArrayList<>();
				
		while(string.length() > 0) {
			int spaceIndex = string.indexOf(" ");
			if(spaceIndex != -1) {
				strList.add(string.substring(0, spaceIndex));
				string = string.substring(spaceIndex + 1);
			} else {
				strList.add(string);
				string = "";
			}
		}
				
		for(int i = 0; i < strList.size(); i++) {
			if(strList.get(i).isEmpty()) {
				strList.remove(i);
				i--;
			}
		}
				
		firstVal = Integer.parseInt(strList.get(0));
		strList.remove(0);
		secondVal = Integer.parseInt(strList.get(strList.size()-1));
		strList.remove(strList.size()-1);
			
				
		for(String s : strList) {
			operation += s + " ";
		}
				
		operation = operation.trim();
				
		switch(operation) {
			case "plus":
				result = firstVal + secondVal;
				break;
			case "minus":
				result = firstVal - secondVal;
				break;
			case "multiplied by":
				result = firstVal * secondVal;
				break;
			case "divided by":
				result = firstVal / secondVal;
				break;
		}
				
		return result;
	}

}
