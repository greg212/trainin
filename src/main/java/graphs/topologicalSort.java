package graphs;

import java.util.*;

/**
 * http://www.geeksforgeeks.org/topological-sorting/
 * <p>
 * <p>
 * Created by gs on 2016-06-19.
 */
public class topologicalSort {

    static final String input = "6 6\n" +
            "5 2\n" +
            "5 0\n" +
            "4 0\n" +
            "4 1\n" +
            "2 3\n" +
            "3 1\n";

    public static void main(String[] args) {
        Scanner in = new Scanner(input);
            int numV = in.nextInt();
            int numE = in.nextInt();

            Graph graph = new Graph(numV);

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt();
                int b = in.nextInt();
                graph.addEdge(a, b);
            }

            graph.printTopologicalOrder();

        in.close();
    }

    static class GraphEdge {
        int from;
        int to;
        GraphEdge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static class Graph {
        LinkedList<GraphEdge>[] adj;

        Graph(int V) {
            this.adj = (LinkedList<GraphEdge>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<GraphEdge>();
            }
        }

        void addEdge(int from, int to) {
            adj[from].add(new GraphEdge(from, to));
        }
        

        void printTopologicalOrder() {
            boolean[] visited = new boolean[adj.length];

            Deque<Integer> stack = new ArrayDeque<Integer>();

            for(int i=0;i <adj.length;i++) {
                if(visited[i]==false) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            while(!stack.isEmpty()) {
                System.out.println(stack.pop() + " ");
            }
        }

        private void topologicalSortUtil(int i, boolean[] visited, Deque<Integer> stack) {
            visited[i] = true;
            for(GraphEdge e : adj[i]) {
                if(!visited[e.to]) {
                    topologicalSortUtil(e.to, visited, stack);
                }
            }

            stack.push(i);
        }

        private void scan(int v, boolean[] inMST, PriorityQueue<GraphEdge> pq) {
            inMST[v] = true;
            for(GraphEdge e : adj[v]) {
                if(!inMST[e.to]) {
                    pq.add(e);
                }
            }
        }
    }
}
