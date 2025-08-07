import java.util.*;

public class BSTKthElement {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int v : values) root = insert(root, v);

        System.out.println("第3小元素: " + kthSmallest(root, 3));
        System.out.println("第2大元素: " + kthLargest(root, 2));
        System.out.println("第3到5小: " + rangeKth(root, 3, 5));
    }

    static TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val) node.left = insert(node.left, val);
        else node.right = insert(node.right, val);
        return node;
    }

    static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(list.size() - k);
    }

    static List<Integer> rangeKth(TreeNode root, int k, int j) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.subList(k - 1, j);
    }

    static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
