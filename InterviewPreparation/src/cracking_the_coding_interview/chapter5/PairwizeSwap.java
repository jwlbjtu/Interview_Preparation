package cracking_the_coding_interview.chapter5;

public class PairwizeSwap {

	public int swap(int num) {
		return ((num & 0Xaaaaaaaa) >>> 1) | ((num & 0X55555555) << 1);
	}
}
