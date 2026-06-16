/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer>adj=new ArrayList<>();
        solve(root,adj);
        return adj;

    }
    public static void solve(TreeNode root,ArrayList<Integer>adj){
        if(root==null){
            return;
        }
        adj.add(root.val);
        solve(root.left,adj);
        solve(root.right,adj);
    }
}