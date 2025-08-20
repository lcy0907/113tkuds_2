import java.util.*;

public class M02_YouBikeNextArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = toMinutes(sc.nextLine().trim());
        }
        int query = toMinutes(sc.nextLine().trim());

        // 二分搜尋第一個大於 query 的位置
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (times[mid] > query) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", times[ans] / 60, times[ans] % 60);
        }
    }

    static int toMinutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}