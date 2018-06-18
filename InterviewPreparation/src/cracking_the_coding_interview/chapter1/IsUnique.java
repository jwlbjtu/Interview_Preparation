package cracking_the_coding_interview.chapter1;


/**
 * June-15-2018
 * @author wenlongjiang
 *
 * 1.1 Is Unique
 *  
 */
public class IsUnique {
	
	public static boolean solution1(String str) {
		if (str.length() > 128) return false;
		boolean[] visited = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (visited[val]) {
				return false;
			}
			visited[val] = true;
		}
		
		return true;
	}
	
	public static boolean solution2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) != 0) {
				return false;
			}
			checker |= (1 << val);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "aabbcc";
		String str2 = "abcdef";
		
		System.out.println("Solution 1");
		System.out.println(solution1(str1));
		System.out.println(solution1(str2));
		
		System.out.println("Solution 2");
		System.out.println(solution2(str1));
		System.out.println(solution2(str2));
	}
}
