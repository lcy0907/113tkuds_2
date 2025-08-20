import java.util.*;

public class M03_TopKConvenience {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();
        sc.nextLine();

        // 使用最小堆維護 Top-K
        PriorityQueue<Item> heap = new PriorityQueue<>(K);

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            sc.nextLine();

            if (heap.size() < K) {
                heap.add(new Item(name, qty));
            } else if (heap.peek().compareTo(new Item(name, qty)) < 0) {
                heap.poll();
                heap.add(new Item(name, qty));
            }
        }

        List<Item> res = new ArrayList<>(heap);
        // 按銷量大到小，若同數量再比字典序
        res.sort((a, b) -> b.qty != a.qty ? b.qty - a.qty : a.name.compareTo(b.name));

        for (Item it : res) {
            System.out.println(it.name + " " + it.qty);
        }
    }

    static class Item implements Comparable<Item> {
        String name;
        int qty;
        Item(String n, int q) { name = n; qty = q; }

        // 小根堆：銷量小優先；若同 qty，用字典序反比，確保字典序大會被替換
        public int compareTo(Item o) {
            if (this.qty != o.qty) return this.qty - o.qty;
            return o.name.compareTo(this.name);
        }
    }
}

/*
時間複雜度：
- 每筆資料 O(log K)，總共 O(n log K)，因為 K << n 很快。
空間複雜度：O(K) 儲存最小堆。
*/
