import java.util.ArrayList;

public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // #########################################################################
    // Building a BST
    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // #########################################################################
    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // #########################################################################
    // Search in BST
    public static void searchInBST(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.data == key) {
            System.out.println("found key");
            return;
        } else {
            if (root.data > key) {
                searchInBST(root.left, key);
            } else {
                searchInBST(root.right, key);
            }
        }
        System.out.println("key not found");

    }

    // #########################################################################
    // Print numbers in range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        if (root.data > k1) {
            printInRange(root.right, k1, k2);
        }

        if (root.data < k2) {
            printInRange(root.left, k1, k2);
        }
    }

    // #########################################################################
    // Path root to leaf
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);

        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // inorder(root);
        // searchInBST(root, 6);
        printInRange(root, 5, 95);

        printRoot2Leaf(root, new ArrayList<Integer>());
    }
}
