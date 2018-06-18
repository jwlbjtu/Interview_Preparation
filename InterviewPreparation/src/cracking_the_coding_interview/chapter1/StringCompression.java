package cracking_the_coding_interview.chapter1;

public class StringCompression {

	public static String compress(String str) {
		if (str == null || str.length() < 3) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char cur = str.charAt(i);
			char prev = str.charAt(i - 1);
			if (cur == prev) {
				count++;
			} else {
				sb.append(count);
				sb.append(cur);
				count = 1;
			}
		}
		sb.append(count);
		return sb.length() < str.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		String str1 = "aabcccccaaaa";
		String str2 = "abc";
		
		System.out.println(compress(str1));
		System.out.println(compress(str2));
	}
}
