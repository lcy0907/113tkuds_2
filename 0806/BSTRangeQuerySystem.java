import java.util.*;

public class BSTRangeQuerySystem {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        TreeNode root = insert(null, 15);
        insert(root, 10);
        insert(root, 20);
        insert(root, 8);
        insert(root, 12);
        insert(root, 17);
        insert(root, 25);

        System.out.println("範圍內的節點: " + rangeQuery(root, 10, 20));
        System.out.println("範圍內節點數: " + countInRange(root, 10, 20));
        System.out.println("範圍總和: " + sumInRange(root, 10, 20));
        System.out.println("最接近 13 的值: " + closestValue(root, 13));
    }

    static TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val) node.left = insert(node.left, val);
        else node.right = insert(node.right, val);
        return node;
    }

    static List<Integer> rangeQuery(TreeNode node, int min, int max) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        if (node.val >= min && node.val <= max)
            result.add(node.val);
        if (node.val > min)
            result.addAll(rangeQuery(node.left, min, max));
        if (node.val < max)
            result.addAll(rangeQuery(node.right, min, max));
        return result;
    }

    static int countInRange(TreeNode node, int min, int max) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= min && node.val <= max) count = 1;
        return count + countInRange(node.left, min, max) + countInRange(node.right, min, max);
    }

    static int sumInRange(TreeNode node, int min, int max) {
        if (node == null) return 0;
        int sum = 0;
        if (node.val >= min && node.val <= max) sum = node.val;
        return sum + sumInRange(node.left, min, max) + sumInRange(node.right, min, max);
    }

    static int closestValue(TreeNode root, int target) {
        TreeNode node = root;
        int closest = root.val;
        while (node != null) {
            if (Math.abs(target - node.val) < Math.abs(target - closest))
                closest = node.val;
            node = (target < node.val) ? node.left : node.right;
        }
        return closest;
    }
}
