package cracking_the_coding_interview.chapter5;

public class Conversion {

	public static int s1 (int a, int b) {
		int count = 0;
		for (int i = a ^ b; i != 0; i >>>= 1) {
			count += (i & 1);
		}
		return count;
	}
	
	public static int s2 (int a, int b) {
		int count = 0;
		for (int i = a ^ b; i != 0; i = (i & (i - 1))) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(s1(29, 15));
		System.out.println(s2(29, 15));
	}
}
