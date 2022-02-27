package com.example.demo.leetCode.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件描述
 * 力扣第 797 题
 *`题目输入一幅有向无环图，这个图包含n个节点，标号为0, 1, 2,..., n - 1，请你计算所有从节点0到节点n - 1的路径。
 * 输入的这个graph其实就是「邻接表」表示的一幅图，graph[i]存储这节点i的所有邻居节点。
 * 0---->1
 * |     |
 * |     |
 * 2---->3
 * @ProductName: Hundsun HEP
 * @ProjectName: ECCG
 * @Package: com.example.demo.leetCode.algorithm.graph
 * @Description: note
 * @Author: chenxy43169
 * @CreateDate: 2022/2/15 14:09
 * @UpdateUser: chenxy43169
 * @UpdateDate: 2022/2/15 14:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright  2022 Hundsun Technologies Inc. All Rights Reserved
 **/
public class AllPathsSourceTarget {

    static List<List<Integer>> allPathsResult = new ArrayList<>(20);
    static LinkedList<Integer> onPath = new LinkedList<>();

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget(0, graph);
        System.out.println(allPathsResult);
    }

    static void allPathsSourceTarget(int s , int[][] graph){
        onPath.add(s);
        if(s == graph.length - 1){
            allPathsResult.add(new LinkedList<>(onPath));
            onPath.removeLast();
            return;
        }
        int[] arr = graph[s];
        for(int i = 0; i < arr.length; i++){
            allPathsSourceTarget(arr[i], graph);
        }
        onPath.removeLast();
    }
}
