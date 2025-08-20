import java.util.*;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        long g = gcd(a, b);
        long l = (a / g) * b; // 先除後乘避免溢位
        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

/*
時間複雜度：
- GCD: O(log min(a,b))（歐幾里得演算法）。
- LCM: O(1)。
總合：O(log n)。

空間複雜度：
- 遞迴深度 O(log n)。
*/
