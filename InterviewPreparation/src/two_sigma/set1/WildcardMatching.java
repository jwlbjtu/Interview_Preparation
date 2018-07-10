package two_sigma.set1;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean recursive(String s, String p) {
		if (s == null || p == null) return false;
		int n = s.length();
		int m = p.length();
		
		if (n == 0) {
			int count = 0;
			for (int i = 0; i < m; i++) {
				if (p.charAt(i) == '*') {
					count++;
				}
			}
			return count == m;
		}
		
		if (m == 0) return false;
		
		if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
			return recursive(s.substring(0, n - 1), p.substring(0, m - 1));
		} else if (p.charAt(m - 1) == '*') {
			return recursive(s, p.substring(0, m - 1)) || recursive(s.substring(0, n - 1), p);
		} else {
			return false;
		}
	}
	
	public static boolean isMathDP(String s, String p) {
		if (s == null || p == null) return false;
		int n = s.length();
		int m = p.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		
		for (int i = 0; i < n; i++) {
			dp[0][i + 1] = false;
		}
		
		for (int i = 0; i < m; i++) {
			if (p.charAt(i) == '*') {
				dp[i + 1][0] = dp[i][0];
			} else {
				dp[i + 1][0] = false;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(i) == '*') {
					dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
				}
			}
		}
		
		return dp[m][n];
	}
	
	public static boolean backtracking(String s, String p) {
		int sp = 0;
		int pp = 0;
		int match = 0;
		int star = -1;
		
		while (sp < s.length()) {
			if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
				sp++;
				pp++;
			} else if (pp < p.length() && p.charAt(pp) == '*') {
				star = pp;
				match = sp;
				pp++;
			} else if (star != -1) {
				pp = star + 1;
				match++;
				sp = match;
			} else {
				return false;
			}
		}
		
		while (pp < p.length() && p.charAt(pp) == '*') {
			pp++;
		}
		
		return pp == p.length();
	}

}
