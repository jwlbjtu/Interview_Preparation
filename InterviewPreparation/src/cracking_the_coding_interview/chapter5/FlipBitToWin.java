package cracking_the_coding_interview.chapter5;

import java.util.*;

public class FlipBitToWin {

	// O(b) O(b)
	public int s1(int num) {
		if (num == -1) return Integer.BYTES * 8;
		List<Integer> counts = getCounts(num);
		return longestSeq(counts);
	}
	
	List<Integer> getCounts(int num) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int target = 0;
		int count = 0;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((num & 1) != target) {
				res.add(count);
				target = num & 1;
				count = 0;
			}
			count++;
			num >>>= 1;
		}
		res.add(count);
		return res;
	}
	
	int longestSeq(List<Integer> counts) {
		int max = 1;
		
		for (int i = 0; i < counts.size(); i += 2) {
			int zeroSeq = counts.get(i);
			int leftSeq = i + 1 < counts.size() ? counts.get(i + 1) : 0;
			int rightSeq = i - 1 >= 0? counts.get(i - 1) : 0;
			
			int size = 0;
			if (zeroSeq == 1) {
				size = leftSeq + 1 + rightSeq;
			} else if (zeroSeq > 1) {
				size = Math.max(leftSeq, rightSeq) + 1;
			} else if (zeroSeq == 0) {
				size = Math.max(leftSeq,  rightSeq);
			}
			max = Math.max(max, size);
		}
		return max;
	}
	
	// O(b) O(1)
	public int s2(int num) {
		if (num == -1) return Integer.BYTES * 8;
		
		int prevLen = 0;
		int curLen = 0;
		int max = 1;
		while (num != 0) {
			if ((num & 1) == 1) {
				curLen++;
			} else if((num & 1) == 0) {
				prevLen = (num & 2) == 0 ? 0 : curLen;
				curLen = 0;
			}
			max = Math.max(max, prevLen + 1 + curLen);
			num >>>= 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.BYTES * 8);
		System.out.println(Integer.BYTES);
	}
}
