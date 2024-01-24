/*
 * Written by Maximus Fernandez
 * Sorting Various Words by Various Properties
 * due 02/02/2024 by 11:55PM
 */

public class WordHelper {

	public static String[] sortByVowels(String words[]) {
		String[] sorted = new String[words.length];
		
		//sorts words from smallest to largest by # of vowels
		//a,e,i,o,u
		
		for (int i=0;i<words.length;i++)
		{
			if(words[i].substring(0,1).equalsIgnoreCase("a"))
			{
				
			}
		}
		
		
		return sorted;
	}

	public static String[] sortByConsonants(String words[]) {
		String[] sorted = new String[words.length];

		//sorts from smallest to largest by # of consonants
		//b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,y,z
		
		return sorted;
	}

	public static String[] sortByLength(String words[]) {
		String[] sorted = new String[words.length];

		//sorts from smallest to largest by # of letters
		
		
		return sorted;

	}

}
