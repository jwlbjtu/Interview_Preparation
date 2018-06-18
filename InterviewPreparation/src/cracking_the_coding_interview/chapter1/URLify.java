package cracking_the_coding_interview.chapter1;

public class URLify {
	
	public static void s1(char[] text, int trueLength) {
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (text[i] == ' ') {
				spaceCount++;
			}
		}
		
		int index = trueLength + spaceCount * 2;
		for (int i = trueLength - 1; i >= 0; i--) {
			if (text[i] == ' ') {
				text[index - 1] = '0';
				text[index - 2] = '2';
				text[index - 3] = '%';
				index -= 3;
			} else {
				text[index - 1] = text[i];
				index--;
			}
		}
	}
	
	public static void main(String[] args) {
		char[] ch = new char[] {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		
		System.out.println("Solution 1");
		s1(ch, 13);
		System.out.println(ch);
	}
}
