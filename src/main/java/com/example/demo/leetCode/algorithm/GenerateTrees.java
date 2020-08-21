package com.example.demo.leetCode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *说明:我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
 *
 * 2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
 *
 * 3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 *
 * 4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 *
 * ...
 *
 * n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
 */
public class GenerateTrees {

    public static List<TreeNode> generateTrees(int n) {

        return generateTrees(1 ,n);
    }

    public static List<TreeNode> generateTrees(int start ,int end) {
        List<TreeNode> nodeList = new ArrayList<>();
        if(start > end){
            nodeList.add(null);
            return nodeList;
        }
        if(start == end){
            TreeNode node = new TreeNode(start);
            nodeList.add(node);
            return nodeList;
        }

        for(int i = start;i <= end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1,end);
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }

    public static void main(String[] args) {
        List<TreeNode> nodeList = generateTrees(3);
    }
}
