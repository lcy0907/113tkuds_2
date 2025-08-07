import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode buildTreeFromInPre(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int ri = map.get(pre[ps]);
        int len = ri - is;
        root.left = build(pre, ps + 1, ps + len, in, is, ri - 1, map);
        root.right = build(pre, ps + len + 1, pe, in, ri + 1, ie, map);
        return root;
    }
}
