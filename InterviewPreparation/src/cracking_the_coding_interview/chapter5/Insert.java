package cracking_the_coding_interview.chapter5;

public class Insert {

	public int insert(int n, int m, int i, int j) {
		// get all 1s e.g 1111111111
		int ones = ~0;
		// shift left j + 1 e.g 1110000000
		int left = ones << j + 1;
		// get right part e.g 011
		int right = (1 << i) - 1;
		// merge left and right e.g 1110000011
		int mask = left | right;
		// clear n
		int n_clear = n & mask;
		// shift m
		int m_shifted = m << i;
		// insert m into n
		return n_clear | m_shifted;
	}
}
