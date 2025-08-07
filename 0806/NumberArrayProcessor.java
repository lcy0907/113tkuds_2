import java.util.*;

public class NumberArrayProcessor {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 4, 5};
        System.out.println("移除重複: " + Arrays.toString(removeDuplicates(array)));

        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        System.out.println("合併排序: " + Arrays.toString(mergeSorted(a, b)));

        System.out.println("最常出現: " + findMostFrequent(array));

        int[] split = {1, 2, 3, 4, 5, 6};
        splitArray(split);
    }

    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static int[] mergeSorted(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            result[k++] = a[i] < b[j] ? a[i++] : b[j++];
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    public static int findMostFrequent(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void splitArray(int[] arr) {
        int total = Arrays.stream(arr).sum();
        int half = total / 2;
        List<Integer> part1 = new ArrayList<>();
        int sum = 0;
        for (int num : arr) {
            if (sum + num <= half) {
                part1.add(num);
                sum += num;
            }
        }
        System.out.println("Part 1: " + part1);
    }
}
