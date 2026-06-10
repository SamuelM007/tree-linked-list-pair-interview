public class RedQ2 {
    /**
     * Returns which has a higher average value: a given linked list or a given tree.
     * 
     * Example:
     *   List:
     *      7 -> 8 -> -2 -> 9 -> 21
     *   Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  
     *       4   8  16  
     *   Expected Answer: "tree"
     * 
     *  Explanation:
     *   The average of the list is (7+8+-2+9+21)/5 = 8.6
     *   The average of the tree is (12+6+4+8+18+16)/6 ≈ 10.67
     *   The tree has the bigger average.
     * 
     * You can assume that both the list and the tree are non-null.
     * 
     * You can assume that the differences in averages will be large enough that
     * floating rounding error will not be an issue and that there will not be a tie.
     * 
     * @param head the head of the linked list
     * @param root the root of the tree
     * @return "list" if the list has a bigger average, "tree" if the tree has a bigger average
     */
    public static String biggerAverage(ListNode head, TreeNode root) {
        double headSum = 0;
        int headCount = 0;
        
        while(head != null){
            headSum += head.data;
            headCount++;
            head = head.next;
        }
        
        double rootAvg = treeSum(root)/treeSize(root);

        return (headSum/headCount > rootAvg)?"list":"tree";
    }

    public static int treeSize(TreeNode root){
        if(root == null) return 0;

        return 1+ treeSize(root.left) + treeSize(root.right);
    }

    public static double treeSum(TreeNode root){
        if(root == null) return 0;

        return root.data + treeSum(root.left) + treeSum(root.right);
    }
}
