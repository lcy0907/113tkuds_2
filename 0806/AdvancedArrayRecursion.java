public class AdvancedArrayRecursion {
    // 快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }

    // 合併兩排序陣列
    public static int[] merge(int[] a, int[] b, int i, int j) {
        if (i == a.length) return java.util.Arrays.copyOfRange(b, j, b.length);
        if (j == b.length) return java.util.Arrays.copyOfRange(a, i, a.length);
        if (a[i] < b[j]) {
            return prepend(a[i], merge(a, b, i + 1, j));
        } else {
            return prepend(b[j], merge(a, b, i, j + 1));
        }
    }

    private static int[] prepend(int val, int[] arr) {
        int[] res = new int[arr.length + 1];
        res[0] = val;
        System.arraycopy(arr, 0, res, 1, arr.length);
        return res;
    }

    // 找第 k 小元素
    public static int kthSmallest(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    // 是否存在子序列和等於目標
    public static boolean subsetSum(int[] arr, int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (arr[n - 1] > target)
            return subsetSum(arr, n - 1, target);
        return subsetSum(arr, n - 1, target) || subsetSum(arr, n - 1, target - arr[n - 1]);
    }
}
