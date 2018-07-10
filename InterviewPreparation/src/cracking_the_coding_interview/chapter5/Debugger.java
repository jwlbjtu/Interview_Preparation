package cracking_the_coding_interview.chapter5;

public class Debugger {

	public boolean isPowerOf2(int num) {
		return (num & (num - 1)) == 0;
	}
}
