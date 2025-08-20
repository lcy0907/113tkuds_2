import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int val;
        char color; // 'R' or 'B'
        int idx;
        Node left, right;
        Node(int v, char c, int i) { val = v; color = c; idx = i; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        char[] colors = new char[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
            colors[i] = sc.next().charAt(0);
        }

        Node root = buildTree(vals, colors, 0);

        if (root != null && root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }

        String res = check(root);
        if (res == null) System.out.println("RB Valid");
        else System.out.println(res);
    }

    static Node buildTree(int[] vals, char[] colors, int i) {
        if (i >= vals.length || vals[i] == -1) return null;
        Node node = new Node(vals[i], colors[i], i);
        node.left = buildTree(vals, colors, 2 * i + 1);
        node.right = buildTree(vals, colors, 2 * i + 2);
        return node;
    }

    // 回傳黑高度，或錯誤訊息存於 static
    static String check(Node node) {
        if (node == null) return null;
        return helper(node).err;
    }

    static class Result {
        int blackHeight;
        String err;
        Result(int h, String e) { blackHeight = h; err = e; }
    }

    static Result helper(Node node) {
        if (node == null) return new Result(1, null); // NIL 節點黑高度=1

        Result L = helper(node.left);
        if (L.err != null) return L;
        Result R = helper(node.right);
        if (R.err != null) return R;

        // 性質 2: 不得有紅紅相鄰
        if (node.color == 'R') {
            if ((node.left != null && node.left.color == 'R') ||
                (node.right != null && node.right.color == 'R')) {
                return new Result(-1, "RedRedViolation at index " + node.idx);
            }
        }

        // 性質 3: 黑高度一致
        if (L.blackHeight != R.blackHeight) {
            return new Result(-1, "BlackHeightMismatch");
        }

        int bh = L.blackHeight + (node.color == 'B' ? 1 : 0);
        return new Result(bh, null);
    }
}

/*
時間複雜度：O(n)，遍歷一次樹檢查性質。
空間複雜度：O(h)，h=樹高。
*/
