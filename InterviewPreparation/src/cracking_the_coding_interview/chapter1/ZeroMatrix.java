package cracking_the_coding_interview.chapter1;

public class ZeroMatrix {
	
	public static void s1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 ||
				matrix[0].length == 0) {
			return;
		}
		
		boolean[] rowHasZero = new boolean[matrix.length];
		boolean[] colHasZero = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rowHasZero[i] = true;
					colHasZero[j] = true;
				}
			}
		}
		
		for (int i = 0; i < rowHasZero.length; i++) {
			if (rowHasZero[i]) {
				nulltifyRow(matrix, i);
			}
		}
		
		for (int j = 0; j < colHasZero.length; j++) {
			if(colHasZero[j]) {
				nulltifyCol(matrix, j);
			}
		}
	}
	
	public static void s2(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nulltifyRow(matrix, i);
			}
		}
		
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				nulltifyCol(matrix, i);
			}
		}
		
		if (rowHasZero) {
			nulltifyRow(matrix, 0);
		}
		
		if (colHasZero) {
			nulltifyCol(matrix, 0);
		}
	}
	
	private static void nulltifyRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	private static void nulltifyCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[5][7];
		matrix[0] = new int[] {1, 0, 1, 1, 1, 1, 1};
		matrix[1] = new int[] {1, 1, 1, 1, 1, 1, 1};
		matrix[2] = new int[] {1, 1, 1, 0, 1, 1, 1};
		matrix[3] = new int[] {1, 1, 1, 1, 1, 0, 1};
		matrix[4] = new int[] {1, 1, 1, 0, 1, 1, 1};
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		s1(matrix);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		matrix[0] = new int[] {1, 0, 1, 1, 1, 1, 1};
		matrix[1] = new int[] {1, 1, 1, 1, 1, 1, 1};
		matrix[2] = new int[] {1, 1, 1, 0, 1, 1, 1};
		matrix[3] = new int[] {1, 1, 1, 1, 1, 0, 1};
		matrix[4] = new int[] {1, 1, 1, 0, 1, 1, 1};
		
		System.out.println();
		
		s2(matrix);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
