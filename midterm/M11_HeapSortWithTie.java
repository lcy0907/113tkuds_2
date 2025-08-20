import java.util.*;

public class M11_HeapSortWithTie {
    static class Student {
        int score, idx;
        Student(int s, int i) { score = s; idx = i; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Student(sc.nextInt(), i);
        }

        // Heap Sort: 建立 max-heap (score, index)，取出時放到結果尾端
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);
            heapify(arr, end, 0);
        }

        // 輸出排序結果（遞增）
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].score + (i == n - 1 ? "" : " "));
        }
    }

    // Max-Heap，比較規則：分數大者優先；同分時 index 小者優先
    static void heapify(Student[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && greater(arr[l], arr[largest])) largest = l;
        if (r < n && greater(arr[r], arr[largest])) largest = r;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    static boolean greater(Student a, Student b) {
        if (a.score != b.score) return a.score > b.score;
        return a.idx < b.idx; // tie: index 小者當作「大」
    }

    static void swap(Student[] arr, int i, int j) {
        Student tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}

/*
時間複雜度：
- 建堆：O(n)
- Heap sort：n 次取最大，每次 heapify O(log n)，總共 O(n log n)
總合 O(n log n)。

空間複雜度：O(1)（原地排序）。
*/
