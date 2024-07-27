public class isSymmetric {
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

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return false;

        if (isSymmetricUtil(root.left, root.right)) {
            return true;
        }

        return false;
    }

    public static boolean isSymmetricUtil(Node p, Node q) {
        if (p == null && q == null)
            return true;

        // if (p.data == q.data)
        // return true;

        if (p == null || q == null || p.data != q.data)
            return false;

        boolean left = isSymmetricUtil(p.left, q.right);
        boolean right = isSymmetricUtil(p.right, q.left);

        return left && right;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes[] = { 1, 2, 3, -1, -1, 5, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        Node root = tree.buildTree(nodes);

        System.out.println(isSymmetric(root));
    }
}
