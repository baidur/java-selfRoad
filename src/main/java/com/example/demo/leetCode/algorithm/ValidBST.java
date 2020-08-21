package com.example.demo.leetCode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * 说明:中序遍历，比较大小
 */
public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> tempList = new ArrayList<>();
        inorderTraversal(tempList,root);
        for(Integer i : tempList){
            boolean flag = true;
            for(Integer j : tempList){
                if(!i.equals(j) && flag){
                    if(j > i){
                        return false;
                    }
                }
                if(!flag){
                    if(j <= i){
                        return false;
                    }
                }

                if(i.equals(j)){
                    flag = false;
                }
            }
        }

        return true;
    }

    public static void inorderTraversal(List<Integer> tempList,TreeNode node){
        if(null != node){
            inorderTraversal(tempList,node.left);
            tempList.add(node.val);
            inorderTraversal(tempList,node.right);
        }
    }

    public static boolean inorderTraversal1(TreeNode root,List<Integer> endList) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        double i = - Double.MAX_VALUE;
        while (null != root || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                if(node.val <= i){
                    return false;
                }
                i = node.val;
                endList.add(node.val);
                root = node.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<Integer> tempList = new ArrayList<>();
        boolean f = inorderTraversal1(root,tempList);
        boolean flag = isValidBST(root);
    }

//    public boolean isValidBST(TreeNode root,boolean flag) {
//
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        if(flag || left.val >= root.val || right.val <= root.val){
//            return false;
//        }
//        isValidBST(left,flag);
//        isValidBST(right,flag);
//
//        return true;
//    }
}
