import java.util.*;

public class M04_TieredTaxSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long total = 0;
        for (int i = 0; i < n; i++) {
            long income = sc.nextLong();
            long tax = calcTax(income);
            total += tax;
            System.out.println("Tax: " + tax);
        }
        System.out.println("Average: " + (total / n));
    }

    static long calcTax(long income) {
        long tax = 0;
        if (income > 1000000) {
            tax += (income - 1000000) * 30 / 100;
            income = 1000000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 20 / 100;
            income = 500000;
        }
        if (income > 120000) {
            tax += (income - 120000) * 12 / 100;
            income = 120000;
        }
        tax += income * 5 / 100;
        return tax;
    }
}

/*
時間複雜度：O(1) 計算每筆收入的稅額，總共 O(n)。
空間複雜度：O(1)。
*/
