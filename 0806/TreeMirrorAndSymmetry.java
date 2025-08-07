public class TreeMirrorAndSymmetry {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root1));

        TreeNode mirror = mirrorTree(root1);
        System.out.println("是否互為鏡像: " + isMirror(root1, mirror));

        TreeNode sub = new TreeNode(2);
        sub.right = new TreeNode(3);
        System.out.println("是否為子樹: " + isSubtree(root1, sub));
    }

    static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    static boolean isSubtree(TreeNode root, TreeNode sub) {
        if (root == null) return false;
        if (isSame(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
