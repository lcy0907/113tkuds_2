import java.util.*;

public class M01_BuildHeap {
    static boolean isMax;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next(); // max 或 min
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        isMax = type.equals("max");

        // 從最後一個非葉節點開始做 heapifyDown
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + (i == n - 1 ? "" : " "));
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int target = i;
        int left = 2 * i + 1, right = 2 * i + 2;

        if (isMax) {
            if (left < n && arr[left] > arr[target]) target = left;
            if (right < n && arr[right] > arr[target]) target = right;
        } else {
            if (left < n && arr[left] < arr[target]) target = left;
            if (right < n && arr[right] < arr[target]) target = right;
        }

        if (target != i) {
            int tmp = arr[i]; arr[i] = arr[target]; arr[target] = tmp;
            heapify(arr, n, target);
        }
    }
}

/*
時間複雜度：
建堆 Bottom-up = O(n)，因為大部分節點在樹底層，平均 heapify 次數少。
逐一插入會是 O(n log n)，但這裡避免超時。

空間複雜度：O(1)（原地建堆）。
*/