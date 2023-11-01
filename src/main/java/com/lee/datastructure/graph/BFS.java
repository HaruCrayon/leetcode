package com.lee.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <h3>广度优先搜索 Breadth-first search</h3>
 */
public class BFS {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = Arrays.asList(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        );
        v2.edges = Arrays.asList(new Edge(v4, 15));
        v3.edges = Arrays.asList(
                new Edge(v4, 11),
                new Edge(v6, 2)
        );
        v4.edges = Arrays.asList(new Edge(v5, 6));
        v5.edges = Arrays.asList();
        v6.edges = Arrays.asList(new Edge(v5, 9));

        bfs(v1);
    }

    private static void bfs(Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        v.visited = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }

}
