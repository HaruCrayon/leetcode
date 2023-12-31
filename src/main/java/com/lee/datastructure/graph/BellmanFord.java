package com.lee.datastructure.graph;

import java.util.Arrays;
import java.util.List;

/**
 * <h3>Bellman-Ford 单源最短路径算法，可以处理负边</h3>
 */
public class BellmanFord {

    public static void main(String[] args) {
        // 正常情况
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = Arrays.asList(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = Arrays.asList(new Edge(v4, 15));
        v3.edges = Arrays.asList(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = Arrays.asList(new Edge(v5, 6));
        v5.edges = Arrays.asList();
        v6.edges = Arrays.asList(new Edge(v5, 9));

        List<Vertex> graph = Arrays.asList(v4, v5, v6, v1, v2, v3);

        // 负边情况
        /*Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = Arrays.asList(new Edge(v2, 2), new Edge(v3, 1));
        v2.edges = Arrays.asList(new Edge(v3, -2));
        v3.edges = Arrays.asList(new Edge(v4, 1));
        v4.edges = Arrays.asList();
        List<Vertex> graph = Arrays.asList(v1, v2, v3, v4);*/

        // 负环情况
        /*Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = Arrays.asList(new Edge(v2, 2));
        v2.edges = Arrays.asList(new Edge(v3, -4));
        v3.edges = Arrays.asList(new Edge(v4, 1), new Edge(v1, 1));
        v4.edges = Arrays.asList();
        List<Vertex> graph = Arrays.asList(v1, v2, v3, v4);*/

        bellmanFord(graph, v1);
    }

    private static void bellmanFord(List<Vertex> graph, Vertex source) {
        source.dist = 0;
        int size = graph.size();
        boolean flag = false;
        // 1. 进行 顶点个数 - 1 轮处理 , 最后再加一轮检测负环
        for (int i = 0; i < size; i++) {
            // 2. 遍历所有的边
            for (Vertex s : graph) {
                for (Edge edge : s.edges) {
                    // 3. 处理每一条边
                    Vertex e = edge.linked;
                    if (s.dist != Integer.MAX_VALUE && s.dist + edge.weight < e.dist) {
                        // 如果在【顶点个数-1】轮处理完成后，还能继续找到更短距离，表示发现了负环
                        if (i == size - 1) {
                            flag = true;
                            break;
                        }
                        e.dist = s.dist + edge.weight;
                        e.prev = s;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        if (!flag) {
            for (Vertex v : graph) {
                System.out.println(v);
            }
        } else {
            throw new RuntimeException("发现了负环，最短路径无解");
        }
    }

}
