import java.util.ArrayList;

public class BinaryTree3 {
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

    // ###########################################################################################################################
    // KthLevel
    public static void kthLevel(Node node, int level, int k) {
        if (node == null) {
            return;
        }
        if (level == k) {
            System.out.print(node.data + " ");
            return;
        }

        kthLevel(node.left, level + 1, k);
        kthLevel(node.right, level + 1, k);
    }

    // ###########################################################################################################################
    // Lowest Common ancestor Approach-1

    public static boolean getPath(Node node, ArrayList<Node> path, int n) {
        if (node == null) {
            return false;
        }
        path.add(node);
        if (node.data == n) {
            return true;
        }

        boolean leftPath = getPath(node.left, path, n);
        boolean rightPath = getPath(node.right, path, n);

        if (leftPath || rightPath) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;

    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, path1, n1);
        getPath(root, path2, n2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;

    }

    // ###########################################################################################################################
    // Lowest Common ancestor Approach-2
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        if (leftLCA == null) {
            return rightLCA;
        }
        if (rightLCA == null) {
            return leftLCA;
        }

        return root;
    }

    // ###########################################################################################################################
    // Minimum Distance between two nodes
    public static int findDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDistance = findDist(root.left, n);
        int rightDistance = findDist(root.right, n);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        } else if (leftDistance == -1) {
            return rightDistance + 1;
        } else {
            return leftDistance + 1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = findDist(lca, n1);
        int dist2 = findDist(lca, n2);
        return dist1 + dist2;
    }

    // ###########################################################################################################################
    // kth Ancestor
    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftAncestor = kAncestor(root.left, n, k);
        int rightAncestor = kAncestor(root.right, n, k);

        if (leftAncestor == -1 && rightAncestor == -1) {
            return -1;
        }

        int max = Math.max(leftAncestor, rightAncestor);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // ###########################################################################################################################
    // Transform to sum tree

    // public static int sumTree(Node root) {
    // if (root == null) {
    // return 0;
    // }
    // int leftChild = sumTree(root.left);
    // int rightChild = sumTree(root.right);

    // int data = root.data;
    // int newLeft = root.left == null ? 0 : root.left.data;
    // int newRight = root.right == null ? 0 : root.right.data;
    // root.data = newLeft + leftChild + newRight + rightChild;
    // return data;
    // }

    public static int sumTree(Node root) {
        if (root == null)
            return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int data = root.data;

        root.data = leftSum + rightSum;
        return leftSum + rightSum + data;

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

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

        // kthLevel(root, 1, 3);
        // System.out.println(lca(root, 4, 7).data);
        // System.out.println(lca2(root, 4, 5).data);
        // System.out.println(minDistance(root, 3, 7));
        sumTree(root);
        preOrder(root);
    }
}
