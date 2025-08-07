import java.util.*;

public class MultiWayTreeAndDecisionTree {

    static class Node {
        String label;
        List<Node> children = new ArrayList<>();

        Node(String label) {
            this.label = label;
        }

        void addChild(Node child) {
            children.add(child);
        }
    }

    public static void printTree(Node root, String indent) {
        if (root == null) return;
        System.out.println(indent + root.label);
        for (Node child : root.children) {
            printTree(child, indent + "  ");
        }
    }

    public static boolean evaluateDecisionTree(Node node, Map<String, Boolean> decisions) {
        if (node.children.isEmpty()) {
            return Boolean.parseBoolean(node.label);
        }
        for (Node child : node.children) {
            if (decisions.getOrDefault(node.label, false)) {
                return evaluateDecisionTree(child, decisions);
            }
        }
        return false;
    }
}