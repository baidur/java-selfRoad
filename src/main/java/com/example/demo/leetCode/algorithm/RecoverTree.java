package com.example.demo.leetCode.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecoverTree {

    public static void recoverTree(TreeNode root) {
        List<Integer> endList = new ArrayList<>();
        inorderTraversal(endList,root);
        endList = endList.stream().sorted().collect(Collectors.toList());
        inorderTraversal1(endList,root);
    }

    public static void inorderTraversal(List<Integer> endList,TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(endList,node.left);
        endList.add(node.val);
        inorderTraversal(endList,node.right);
    }

    public static void inorderTraversal1(List<Integer> endList,TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal1(endList,node.left);
        node.val = endList.get(0);
        endList.remove(0);
        inorderTraversal1(endList,node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        recoverTree(root);
    }

}
