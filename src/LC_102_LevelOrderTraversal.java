import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_102_LevelOrderTraversal {
    public static List<List<Integer>> levelOrderTraversal (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int queueLevelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i = 0; i< queueLevelSize; i++) {

                TreeNode currentNode = queue.poll();
                levelNodes.add(currentNode.val);

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelNodes);
        }
        return  result;
    }

    public static void main(String[] args) {
        // Construct a binary tree
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        List<List<Integer>> result = levelOrderTraversal(root);
        System.out.println(result);  // Output: [[3], [9, 20], [15, 7]]
    }
}
