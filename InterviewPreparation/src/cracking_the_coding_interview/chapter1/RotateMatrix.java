package cracking_the_coding_interview.chapter1;

public class RotateMatrix {

	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 ||
				matrix.length != matrix[0].length) {
			return;
		}
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int last = n - 1 - layer;
			for (int i = layer; i < last; i++) {
				int x = layer;
				int y = i;
				for (int k = 0; k < 3; k++) {
					int newX = y;
					int newY = n - x - 1;
					int temp = matrix[layer][i];
					matrix[layer][i] = matrix[newX][newY];
					matrix[newX][newY] = temp;
					x = newX;
					y = newY;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		matrix[0] = new int[]{1, 2, 3, 4, 5};
		matrix[1] = new int[]{6, 7, 8, 9, 10};
		matrix[2] = new int[]{11, 12, 13, 14, 15};
		matrix[3] = new int[]{16, 17, 18, 19, 20};
		matrix[4] = new int[]{21, 22, 23, 24, 25};
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		rotate(matrix);
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
