public class KthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) {
        int[] counter = {0};
        int[] result = {0};
        inorderTraversal(root, k, counter, result);
        return result[0];
    }

    private static void inorderTraversal(TreeNode node, int k, int[] counter, int[] result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, k, counter, result);
        counter[0]++;
        if (counter[0] == k) {
            result[0] = node.val;
            return;
        }
        inorderTraversal(node.right, k, counter, result);
    }

    public static void main(String[] args) {
        /*
         * Example:
         *        3
         *       / \
         *      1   4
         *       \
         *        2
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 6;
        System.out.println("The " + k + "th smallest element in the BST: " + kthSmallest(root, k)); // Output should be 1
    }
}

