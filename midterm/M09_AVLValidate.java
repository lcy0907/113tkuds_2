import java.util.*;

public class M09_AVLValidate {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static boolean isBSTValid = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = buildTree(arr, 0);
        if (!checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }

        if (checkAVL(root) == -2) {
            System.out.println("Invalid AVL");
            return;
        }

        System.out.println("Valid");
    }

    static Node buildTree(int[] arr, int i) {
        if (i >= arr.length || arr[i] == -1) return null;
        Node node = new Node(arr[i]);
        node.left = buildTree(arr, 2 * i + 1);
        node.right = buildTree(arr, 2 * i + 2);
        return node;
    }

    // 檢查 BST 性質
    static boolean checkBST(Node root, long min, long max) {
        if (root == null) return true;
        if (!(min < root.val && root.val < max)) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    // 回傳高度，若不合法回傳 -2
    static int checkAVL(Node root) {
        if (root == null) return -1;
        int lh = checkAVL(root.left);
        if (lh == -2) return -2;
        int rh = checkAVL(root.right);
        if (rh == -2) return -2;
        if (Math.abs(lh - rh) > 1) return -2;
        return Math.max(lh, rh) + 1;
    }
}

/*
時間複雜度：
- checkBST: O(n)
- checkAVL: O(n)
總合 O(n)。

空間複雜度：O(h)，h=樹高。
*/
