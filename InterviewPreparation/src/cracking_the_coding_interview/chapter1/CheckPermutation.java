package cracking_the_coding_interview.chapter1;

import java.util.Arrays;

public class CheckPermutation {

	public static boolean s1(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		int[] count = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i)]++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			count[str2.charAt(i)]--;
			if (count[str2.charAt(i)] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean s2(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		String newStr1 = new String(str1Arr);
		String newStr2 = new String(str2Arr);
		
		return newStr1.equals(newStr2);
	}
	
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "cba";
		String str3 = "ccb";
		String str4 = "   abc";
		String str5 = "ABc";
		
		System.out.println("Solution 1");
		System.out.println(s1(str1, str2));
		System.out.println(s1(str1, str3));
		System.out.println(s1(str1, str4));
		System.out.println(s1(str1, str5));
		
		System.out.println("Solution 2");
		System.out.println(s2(str1, str2));
		System.out.println(s2(str1, str3));
		System.out.println(s2(str1, str4));
		System.out.println(s2(str1, str5));
	}
}
