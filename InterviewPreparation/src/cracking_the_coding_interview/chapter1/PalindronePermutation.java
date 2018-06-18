package cracking_the_coding_interview.chapter1;

public class PalindronePermutation {

	public static boolean s1(String phrase) {
		if (phrase == null) return false;
		
		int[] count = new int[26];
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ') continue;
			int val = phrase.charAt(i) - 'a';
			count[val]++;
		}
		
	    boolean oddChar = false;
	    for (int num : count) {
	    	if (num % 2 != 0) {
	    		if (oddChar) {
	    			return false;
	    		}
	    		oddChar = true;
	    	}
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		String str1 = "toca cot";
		String str2 = "ab";
		
		System.out.println(s1(str1));
		System.out.println(s1(str2));
	}
}
