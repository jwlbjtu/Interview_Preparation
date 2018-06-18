package cracking_the_coding_interview.chapter1;

public class StringRotation {

	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		String s1s1 = s1 + s1;
		return s1s1.indexOf(s2) >= 0;
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String s3 = "bottlewattr";
		System.out.println(isRotation(s1, s2));
		System.out.println(isRotation(s1, s3));
	}
}
