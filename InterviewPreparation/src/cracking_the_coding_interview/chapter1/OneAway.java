package cracking_the_coding_interview.chapter1;

public class OneAway {
	
	public static boolean s1(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 == len2) {
			return checkReplace(str1, str2);
		} else if (len1 + 1 == len2) {
			return checkInsert(str1, str2);
		} else if (len1 - 1 == len2) {
			return checkInsert(str2, str1);
		}
		
		return false;
	}
	
	public static boolean checkReplace(String first, String sec) {
		boolean foundDiff = false;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != sec.charAt(i)) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}
	
	public static boolean checkInsert(String first, String sec) {
		int i = 0;
		int j = 0;
		while (i < first.length() && j < sec.length()) {
			if (first.charAt(i) != sec.charAt(j)) {
				if (i != j) {
					return false;
				}
				j++;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "pale";
		String str2 = "pae";
		String str3 = "bae";
		String str4 = "pale";
		String str5 = "bale";
		String str6 = "balb";
		String str7 = "pales";
		String str8 = "palesss";
		String str9 = "a";
		
		System.out.println(s1(str1, str2));
		System.out.println(s1(str1, str3));
		System.out.println(s1(str1, str4));
		System.out.println(s1(str1, str5));
		System.out.println(s1(str1, str6));
		System.out.println(s1(str1, str7));
		System.out.println(s1(str1, str8));
		System.out.println(s1(str1, str9));
	}
}
