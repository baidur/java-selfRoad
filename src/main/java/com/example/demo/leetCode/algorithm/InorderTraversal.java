package com.example.demo.leetCode.algorithm;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 说明:
 * 二叉树是一种非常重要的数据结构，很多其它数据结构都是基于二叉树的基础演变而来的。对于二叉树，有深度遍历和广度遍历，深度遍历有前序、中序以及后序三种遍历方法，
 * 广度遍历即我们平常所说的层次遍历。因为树的定义本身就是递归定义，因此采用递归的方法去实现树的三种遍历不仅容易理解而且代码很简洁，而对于广度遍历来说，
 * 需要其他数据结构的支撑，比如堆了。所以，对于一段代码来说，可读性有时候要比代码本身的效率要重要的多。
 *
 * 四种主要的遍历思想为：
 *
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：只需按层次遍历即可
 */
public class InorderTraversal {

    /**
     * 中序遍历
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root,List<Integer> endList) {

        if(null != root){
            inorderTraversal(root.left,endList);
            endList.add(root.val);
            inorderTraversal(root.right,endList);
        }
        return endList;
    }

    /**
     * 后序遍历
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal4(TreeNode root,List<Integer> endList) {

        if(null != root){
            inorderTraversal(root.left,endList);
            inorderTraversal(root.right,endList);
            endList.add(root.val);
        }
        return endList;
    }

    /**
     * 前序遍历（递归）
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal5(TreeNode root,List<Integer> endList) {

        if(null != root){
            endList.add(root.val);
            inorderTraversal(root.left,endList);
            inorderTraversal(root.right,endList);
        }
        return endList;
    }

    /**
     * 二叉树中序遍历
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root,List<Integer> endList) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pNode = root;
        while (null != pNode || !stack.isEmpty()){
            if(pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            }else {
                TreeNode node = stack.pop();
                endList.add(node.val);
                pNode = node.right;
            }
        }
        return endList;
    }

    /**
     * 二叉树前序遍历
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root,List<Integer> endList) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pNode = root;
        while (null != pNode || !stack.isEmpty()){
            if(pNode != null){
                endList.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            }else {
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
        return endList;
    }

    /**
     * 二叉树后序遍历
     * @param root
     * @param endList
     * @return
     */
    public static List<Integer> inorderTraversal3(TreeNode root,List<Integer> endList) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pNode = root;
        TreeNode pre = null;
        while (null != pNode || !stack.isEmpty()){
            while (null != pNode){
                stack.push(pNode);
                pNode = pNode.left;
            }
            if(!stack.isEmpty()){
                pNode = stack.pop();
                if(pNode.right == null || pre == pNode.right){
                    endList.add(pNode.val);
                    pre = pNode;
                    pNode = null;
                }else {
                    stack.push(pNode);
                    pNode = pNode.right;
                }
            }
        }
        return endList;
    }

    public static void main(String[] args) {
        TreeNode headNode = new TreeNode(3);
        headNode.left = new TreeNode(1);
        headNode.right = new TreeNode(2);
        List<Integer> endList = new ArrayList<>();
        //inorderTraversal(headNode,endList);
       // inorderTraversal1(headNode,endList);
        //inorderTraversal2(headNode,endList);
        inorderTraversal3(headNode,endList);
       // inorderTraversal4(headNode,endList);
       // inorderTraversal5(headNode,endList);
    }
}
