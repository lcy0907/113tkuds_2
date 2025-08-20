import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry implements Comparable<Entry> {
        int time, listIdx, pos;
        Entry(int t, int li, int p) { time = t; listIdx = li; pos = p; }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < len; j++) l.add(sc.nextInt());
            lists.add(l);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new Entry(lists.get(i).get(0), i, 0));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry e = pq.poll();
            result.add(e.time);
            int nextPos = e.pos + 1;
            if (nextPos < lists.get(e.listIdx).size()) {
                pq.add(new Entry(lists.get(e.listIdx).get(nextPos), e.listIdx, nextPos));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }
    }
}
