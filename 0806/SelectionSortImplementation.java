import java.util.Arrays;

public class SelectionSortImplementation {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("�Ƨǵ��G: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                swaps++;
            }
            System.out.println("�� " + (i + 1) + " ��: " + Arrays.toString(arr));
        }
        System.out.println("�������: " + comparisons + ", �洫����: " + swaps);
    }
}
