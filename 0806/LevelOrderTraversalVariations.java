import java.util.*;

public class LevelOrderTraversalVariations {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("每層儲存:");
        List<List<Integer>> levels = levelOrder(root);
        levels.forEach(System.out::println);

        System.out.println("之字走訪:");
        zigzagOrder(root).forEach(System.out::println);

        System.out.println("每層最後節點:");
        lastNodeEachLevel(root).forEach(System.out::println);

        System.out.println("垂直走訪:");
        verticalOrder(root).forEach(System.out::println);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    static List<List<Integer>> zigzagOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    static List<Integer> lastNodeEachLevel(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                last = q.poll();
                if (last.left != null) q.offer(last.left);
                if (last.right != null) q.offer(last.right);
            }
            res.add(last.val);
        }
        return res;
    }

    static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root); cols.add(0);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            map.computeIfAbsent(col, x -> new ArrayList<>()).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
            }
        }
        return new ArrayList<>(map.values());
    }
}
