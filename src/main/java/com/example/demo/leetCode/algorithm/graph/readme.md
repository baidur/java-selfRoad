#图论算法基础
一幅图是由节点和边构成的，逻辑结构如下：
![](C:/Users/HSPCAD~1/AppData/Local/Temp/640.webp)

1.图真的没啥高深的，就是高级点的多叉树而已

2.逻辑结构,我们可以认为每个节点的实现如下：
```
/* 图节点的逻辑结构 */
class Vertex {
int id;
Vertex[] neighbors;
}
```
3.实现方式

邻接表和邻接矩阵来实现

![](C:/Users/hspcadmin/Desktop/650.webp)

a.邻接表很直观，我把每个节点x的邻居都存到一个列表里，然后把x和这个列表关联起来，这样就可以通过一个节点x找到它的所有相邻节点。

b.邻接矩阵则是一个二维布尔数组，我们权且称为matrix，如果节点x和y是相连的，那么就把matrix[x][y]设为true（上图中绿色的方格代表true）。如果想找节点x的邻居，去扫一圈matrix[x][..]就行了。

如果用代码的形式来表现，邻接表和邻接矩阵大概长这样：
```
// 邻接矩阵
// graph[x] 存储 x 的所有邻居节点
List<Integer>[] graph;

// 邻接矩阵
// matrix[x][y] 记录 x 是否有一条指向 y 的边
boolean[][] matrix;
```
## BFS算法
让你从一个起点，走到终点，问最短路径

框架:
```
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
Queue<Node> q; // 核心数据结构
Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```