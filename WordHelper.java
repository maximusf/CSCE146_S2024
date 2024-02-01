/*
 * Written by Maximus Fernandez
 * Sorting Various Words by Various Properties
 * due 02/02/2024 by 11:55PM
 */

public class WordHelper {

	public static String[] sortByVowels(String words[]) {
		String[] sorted = copyArray(words);
		//sorts words from smallest to largest by # of vowels
		//a,e,i,o,u
		for(int i=0;i<words.length-1;i++) {
			for(int j=0;j<words.length-1;j++) {
				if(countVowels(words[j]) > countVowels(words[j + 1])) 
				{
					String temp = words[j];
					words[j] = words[j + 1];
					words[j + 1] = temp;
					
					
				}
			}
		}
		
		
		return sorted;
	}

	public static String[] sortByConsonants(String words[]) {
		String[] sorted = copyArray(words);

		//sorts from smallest to largest by # of consonants
		//b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,y,z
		
		
		
		return sorted;
	}

	//Good
	public static String[] sortByLength(String words[]) {
		String[] sorted = copyArray(words);

		//sorts from smallest to largest by # of letters
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0;i<sorted.length-1; i++) {
				if(sorted[i].length() > sorted[i+1].length())
				{
					//Swap
					String temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		
		return sorted;

	}

	//Good
	private static String[] copyArray(String[] words) {
		String[] sorted = new String[words.length];
		
		for(int i=0; i<words.length-1; i++)
		{
			sorted[i] = words[i];
		}
		
		return sorted;
	}
	//good
	private static int hasVowel(String words[]) {
		int totalV = 0;
		String vowels = "aeiou";
		
		for(int i=0; i<words.length; ++i) {
			for (int j=0; j<words[i].length(); ++j) {
				char c = Character.toLowerCase(words[i].charAt(j));
				if (vowels.indexOf(c) != -1) {
					++totalV;
				}}}
		
		return totalV;
	}
	//good
	private static int hasConsonant(String words[]) {
		int totalC = 0;
		String consonants = "bcdefghjklmnpqrstvwxyz";
		
		for(int i=0; i<words.length; ++i) {
			for (int j=0; j<words[i].length(); ++j) {
				char c = Character.toLowerCase(words[i].charAt(j));
				if (consonants.indexOf(c) != -1) {
					++totalC;
				}}}
		
		return totalC;
	}
	 

}
