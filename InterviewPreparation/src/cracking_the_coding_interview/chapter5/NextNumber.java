package cracking_the_coding_interview.chapter5;

public class NextNumber {

	public int getNext(int num) {
		int c = num;
		int c0 = 0;
		int c1 = 0;
		// find the right most 0 that has 1 on it's right
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if ((c1 + c0 == 31) || (c1 + c0 == 0)) {
			return -1;
		}
		// find the position for 0 at p
		int p = c0 + c1;
		// flip 0 to 1 at p
		num |= (1 << p);
		// clear the bit on the right side of p
		num &= ~((1 << p) - 1);
		// add c1 - 1 to the end
		num |= (1 << (c1 - 1)) - 1;
		
		return num;
	}
	
	public int getPrev(int num) {
		// find right most 1 that has 0 on it's right
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c == 0) return -1;
		
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		// find the position of 1 at p
		int p = c0 + c1;
		
		// flip the 1 at p to 0 and clear the right side of p
		num &= (~0 << p + 1);
		// create mask with c1 + 1 1s
		int mask = (1 << c1 + 1) - 1;
		// insert mask right after p
		num |= mask << (c0 - 1);
		
		return num;
	}
}
