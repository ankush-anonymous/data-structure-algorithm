import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree1 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);

        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);

        }

        // level order traversal of a tree
        public static void leverOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data);
                    if (currNode.left != null) {
                        q.add(currNode.left);

                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }

        // to calculate height of a tree
        public static int HeightOfTree(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = HeightOfTree(root.left);
            int rightHeight = HeightOfTree(root.right);
            int totalHeight = Math.max(leftHeight, rightHeight);
            return totalHeight + 1;
        }

        // to calculate number of nodes
        public static int CountNoOfNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = CountNoOfNodes(root.left);
            int rightCount = CountNoOfNodes(root.right);

            return leftCount + rightCount + 1;
        }

        // sum of nodes
        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;

        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.inOrder(root);
        tree.leverOrder(root);
        System.out.println(tree.sumOfNodes(root));

    }
}
