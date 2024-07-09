import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    // ###############################################################################################################################
    // To find diameter of a tree
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        // subcase 1: if diameter passes through root
        int selfDiameter = leftHeight + rightHeight + 1;

        // subcase 2: if diameter doesnot passes through root
        return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
    }

    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // ###############################################################################################################################
    // Second approach to find diameter of tree
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);

    }

    // ###################################################################################################################################
    // to find if subtree exists in a tree
    public static boolean isSubtree(Node rootNode, Node subRootNode) {
        if (rootNode == null) {
            return false;
        }

        if (rootNode.data == subRootNode.data) {
            if (isIdentical(rootNode, subRootNode)) {
                return true;
            }
        }

        return isSubtree(rootNode.left, subRootNode) || isSubtree(rootNode.right, subRootNode);
    }

    public static boolean isIdentical(Node node, Node subNode) {
        if (node == null && subNode == null) {
            return true;
        } else if (node == null || subNode == null || node.data != subNode.data) {
            return false;
        }

        if (!isIdentical(node.left, subNode.left)) {
            return false;
        }

        if (!isIdentical(node.right, subNode.right)) {
            return false;
        }

        return true;
    }

    // ###############################################################################################################################
    // Top view of a tree
    static class TopViewInfo {
        Node node;
        int hd;

        public TopViewInfo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topViewOfTree(Node rootNode) {
        // Level Order Traversal
        Queue<TopViewInfo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0;
        int max = 0;

        q.add(new TopViewInfo(rootNode, 0));
        q.add(null);

        while (!q.isEmpty()) {
            TopViewInfo current = q.remove();

            if (current == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(current.hd)) {
                    map.put(current.hd, current.node);
                }

                if (current.node.left != null) {
                    q.add(new TopViewInfo(current.node.left, current.hd - 1));
                    min = Math.min(min, current.hd - 1);
                }

                if (current.node.right != null) {
                    q.add(new TopViewInfo(current.node.right, current.hd + 1));
                    max = Math.max(max, current.hd + 1);
                }
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(3);
        subRoot.left = new Node(6);
        subRoot.right = new Node(7);

        // System.out.println(diameterOfTree(root));
        // System.out.println(diameter(root).diameter);

        // System.out.println(isSubtree(root, subRoot));
        topViewOfTree(root);
    }

}
