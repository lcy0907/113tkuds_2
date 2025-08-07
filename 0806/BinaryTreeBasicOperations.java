import java.util.*;

public class BinaryTreeBasicOperations {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        System.out.println("總和: " + sum(root));
        System.out.println("平均: " + (sum(root) / (double) count(root)));
        System.out.println("最大值: " + maxValue(root));
        System.out.println("最小值: " + minValue(root));
        System.out.println("樹寬度: " + maxWidth(root));
        System.out.println("是否為完全二元樹: " + isCompleteTree(root));
    }

    static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(20);
        return root;
    }

    static int sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    static int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }

    static int maxValue(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.val, Math.max(maxValue(node.left), maxValue(node.right)));
    }

    static int minValue(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(node.val, Math.min(minValue(node.left), minValue(node.right)));
    }

    static int maxWidth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            max = Math.max(max, levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return max;
    }

    static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean foundNull = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
    }
}
