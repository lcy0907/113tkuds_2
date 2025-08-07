public class BSTValidationAndRepair {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) &&
               isValidBST(node.right, node.val, max);
    }

    public static void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[2];
        TreeNode[] prev = new TreeNode[1];
        inorderRecover(root, prev, nodes);
        if (nodes[0] != null && nodes[1] != null) {
            int tmp = nodes[0].val;
            nodes[0].val = nodes[1].val;
            nodes[1].val = tmp;
        }
    }

    private static void inorderRecover(TreeNode root, TreeNode[] prev, TreeNode[] nodes) {
        if (root == null) return;
        inorderRecover(root.left, prev, nodes);
        if (prev[0] != null && root.val < prev[0].val) {
            if (nodes[0] == null) nodes[0] = prev[0];
            nodes[1] = root;
        }
        prev[0] = root;
        inorderRecover(root.right, prev, nodes);
    }
}