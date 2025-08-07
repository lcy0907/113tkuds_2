import java.util.Arrays;

public class MatrixCalculator {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        System.out.println("加法:");
        printMatrix(add(A, B));

        System.out.println("乘法:");
        printMatrix(multiply(A, B));

        System.out.println("轉置:");
        printMatrix(transpose(A));

        System.out.println("最大值與最小值:");
        int[] maxMin = findMaxMin(A);
        System.out.println("Max: " + maxMin[0] + ", Min: " + maxMin[1]);
    }

    public static int[][] add(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < A[0].length; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    public static int[][] transpose(int[][] A) {
        int[][] T = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                T[j][i] = A[i][j];
        return T;
    }

    public static int[] findMaxMin(int[][] A) {
        int max = A[0][0], min = A[0][0];
        for (int[] row : A)
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        return new int[]{max, min};
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
