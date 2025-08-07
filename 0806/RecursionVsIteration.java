public class RecursionVsIteration {
    // 遞迴 C(n, k)
    public static int combRecursive(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combRecursive(n - 1, k - 1) + combRecursive(n - 1, k);
    }

    // 迭代 C(n, k)
    public static int combIterative(int n, int k) {
        int res = 1;
        for (int i = 1; i <= k; i++) {
            res *= (n - i + 1);
            res /= i;
        }
        return res;
    }

    // 遞迴乘積
    public static int productRecursive(int[] arr, int n) {
        if (n == 0) return 1;
        return arr[n - 1] * productRecursive(arr, n - 1);
    }

    // 迭代乘積
    public static int productIterative(int[] arr) {
        int prod = 1;
        for (int val : arr) prod *= val;
        return prod;
    }

    // 遞迴計算元音數
    public static int countVowels(String s, int i) {
        if (i >= s.length()) return 0;
        char c = Character.toLowerCase(s.charAt(i));
        int add = "aeiou".indexOf(c) >= 0 ? 1 : 0;
        return add + countVowels(s, i + 1);
    }

    // 括號配對檢查（迭代）
    public static boolean isValidParentheses(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
