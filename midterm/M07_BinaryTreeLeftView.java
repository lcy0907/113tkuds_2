import java.util.*;

public class M07_BinaryTreeLeftView {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("LeftView:");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = buildTree(arr, 0);
        if (root == null) {
            System.out.println("LeftView:");
            return;
        }

        List<Integer> view = leftView(root);
        System.out.print("LeftView:");
        for (int v : view) System.out.print(" " + v);
    }

    static Node buildTree(int[] arr, int i) {
        if (i >= arr.length || arr[i] == -1) return null;
        Node node = new Node(arr[i]);
        node.left = buildTree(arr, 2 * i + 1);
        node.right = buildTree(arr, 2 * i + 2);
        return node;
    }

    static List<Integer> leftView(Node root) {
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == 0) res.add(cur.val); // 每層第一個
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}
