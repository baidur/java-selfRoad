package com.example.demo.leetCode.algorithm.graph;

import com.example.demo.leetCode.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 文件描述
 * 二叉树的最小深度,使用BFS算法或者DFS算法
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ECCG
 * @Package: com.example.demo.leetCode.algorithm.graph
 * @Description: note
 * @Author: chenxy43169
 * @CreateDate: 2022/2/16 15:16
 * @UpdateUser: chenxy43169
 * @UpdateDate: 2022/2/16 15:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright  2022 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MinDepth {
    static int min = Integer.MAX_VALUE;
    static LinkedList<TreeNode> list = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode headNode = new TreeNode(3);
        headNode.left = new TreeNode(1);
        headNode.right = new TreeNode(2);
        headNode.right.left = new TreeNode(2);
        inorderTraversal(headNode);
        System.out.println(min);
        System.out.println(minDepth(headNode));
    }

    /**
     * DFS算法，递归树
     * @param root
     */
    public static void inorderTraversal(TreeNode root) {
        if(null != root){
            if(!list.contains(root)){
                list.add(root);
            }
            if(root.left == null && root.right == null){
                if(list.size() < min){
                    min = list.size();
                }
            }
            inorderTraversal(root.left);
            inorderTraversal(root.right);
            list.remove(root);
        }
    }

    /**
     * BFS算法,一层一层往下走，发现一个节点没有子节点则返回
     * @param root
     * @return
     */
   static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

}
