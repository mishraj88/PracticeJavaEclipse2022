package com.mishrjyo.files;


//package crunchify.com.tutorials;

import java.io.*;
import java.util.*;
 
public class CrunchifyFindMaxOccurrence {
	
	/**
	 * @author Crunchify.com
	 * In Java How to Find Maximum Occurrence of Words from Text File?
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// File: An abstract representation of file and directory pathnames.
		// User interfaces and operating systems use system-dependent pathname strings to name files and directories.
		// This class presents an abstract, system-independent view of hierarchical pathnames.
		File file = new File("/Users/app/Download/crunchify.txt");
		
		// BufferedReader: Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
		// The buffer size may be specified, or the default size may be used.
		// The default is large enough for most purposes.
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(file));
		String inputLine = null;
		
		// Map: An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
		Map<String, Integer> crunchifyMap = new HashMap<>();
		
		try {
			while ((inputLine = bufferedReader.readLine()) != null) {
				
				// split(): Splits this string around matches of the given regular expression.
				// This method works as if by invoking the two-argument split method with the given expression and a limit argument of zero.
				// Trailing empty strings are therefore not included in the resulting array.
				String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
				
				for (String word : words) {
					String key = word.toLowerCase(); // remove .toLowerCase for Case Sensitive result.
					if (key.length() > 0) {
						if (crunchifyMap.get(key) == null) {
							crunchifyMap.put(key, 1);
						} else {
							int value = crunchifyMap.get(key).intValue();
							value++;
							crunchifyMap.put(key, value);
						}
					}
				}
			}
			
			// Set: A collection that contains no duplicate elements.
			// More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2),
			// and at most one null element. As implied by its name, this interface models the mathematical set abstraction.
			Set<Map.Entry<String, Integer>> entrySet = crunchifyMap.entrySet();
			crunchifyPrint("Words" + "\t\t" + "# of Occurances");
			
			for (Map.Entry<String, Integer> entry : entrySet) {
				crunchifyPrint(entry.getKey() + "\t\t" + entry.getValue());
			}
			List<String> myTopOccurrence = crunchifyFindMaxOccurrence(crunchifyMap, 1);
			crunchifyPrint("\nMaximum Occurrence of Word in file: ");
			
			for (String result : myTopOccurrence) {
				crunchifyPrint("==> " + result);
			}
			
			// IOException: Signals that an I/O exception of some sort has occurred.
			// This class is the general class of exceptions produced by failed or interrupted I/O operations.
		} catch (IOException error) {
			crunchifyPrint("Invalid File");
		} finally {
			bufferedReader.close();
		}
		
	}
	
	private static void crunchifyPrint(String s) {
		System.out.println(s);
	}
	
	/**
	 * @param map = All Words in map
	 * @param n   = How many top elements you want to print? If n=1 it will print the highest occurrence word. If n=2 it
	 *            will print top 2 highest occurrence words.
	 * @returns list of String
	 */
	public static List<String> crunchifyFindMaxOccurrence(Map<String, Integer> map, int n) {
		List<CrunchifyComparable> l = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet())
			l.add(new CrunchifyComparable(entry.getKey(), entry.getValue()));
		
		// sort(): Sorts the specified list into ascending order, according to the natural ordering of its elements.
		// All elements in the list must implement the Comparable interface. Furthermore, all elements in the list must be mutually comparable
		// (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and e2 in the list).
		Collections.sort(l);
		List<String> list = new ArrayList<>();
		
		// subList(): Returns a view of the portion of this list between the specified fromIndex,
		// inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.)
		// The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
		// The returned list supports all of the optional list operations supported by this list.
		for (CrunchifyComparable w : l.subList(0, n))
			list.add(w.wordFromFile + ":" + w.numberOfOccurrence);
		return list;
	}
}
 
class CrunchifyComparable implements Comparable<CrunchifyComparable> {
	public String wordFromFile;
	public int numberOfOccurrence;
	
	public CrunchifyComparable(String wordFromFile, int numberOfOccurrence) {
		super();
		this.wordFromFile = wordFromFile;
		this.numberOfOccurrence = numberOfOccurrence;
	}
	
	@Override
	public int compareTo(CrunchifyComparable arg0) {
		int crunchifyCompare = Integer.compare(arg0.numberOfOccurrence, this.numberOfOccurrence);
		return crunchifyCompare != 0 ? crunchifyCompare : wordFromFile.compareTo(arg0.wordFromFile);
	}
	
	@Override
	public int hashCode() {
		final int uniqueNumber = 19;
		int crunchifyResult = 9;
		crunchifyResult = uniqueNumber * crunchifyResult + numberOfOccurrence;
		
		// hasCode(): Returns a hash code for this string. The hash code for a String object is computed as
		//       s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		//
		// using int arithmetic, where s[i] is the ith character of the string, n is the length of the string,
		// and ^ indicates exponentiation. (The hash value of the empty string is zero.)
		crunchifyResult = uniqueNumber * crunchifyResult + ((wordFromFile == null) ? 0 : wordFromFile.hashCode());
		return crunchifyResult;
	}
	
	// Override: Indicates that a method declaration is intended to override a method declaration in a supertype.
	// If a method is annotated with this annotation type compilers are required
	// to generate an error message unless at least one of the following conditions hold:
	// The method does override or implement a method declared in a supertype.
	// The method has a signature that is override-equivalent to that of any public method declared in Object.
	@Override
	public boolean equals(Object crunchifyObj) {
		if (this == crunchifyObj)
			return true;
		if (crunchifyObj == null)
			return false;
		if (getClass() != crunchifyObj.getClass())
			return false;
		CrunchifyComparable other = (CrunchifyComparable) crunchifyObj;
		if (numberOfOccurrence != other.numberOfOccurrence)
			return false;
		if (wordFromFile == null) {
			if (other.wordFromFile != null)
				return false;
		} else if (!wordFromFile.equals(other.wordFromFile))
			return false;
		return true;
	}
	
}
