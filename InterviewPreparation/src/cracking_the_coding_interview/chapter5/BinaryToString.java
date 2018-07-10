package cracking_the_coding_interview.chapter5;

public class BinaryToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 0.125;
		System.out.println(binaryStr(num));
	}

	public static String binaryStr(double num) {
		if (num <= 0 || num >= 1) {
			return "ERROR";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while (num > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			
			double r = num * 2;
			if (r >= 1) {
				sb.append(1);
				num = r - 1;
			} else {
				sb.append(0);
				num = r;
			}
		}
		return sb.toString();
	}
	

}
