package graphs;

import java.util.*;

/**
 *
 * http://algs4.cs.princeton.edu/43mst/LazyPrimMST.java.html
 *
 * UNIDIRECTED
 *
 *
 * <p>
 * <p>
 * Created by gs on 2016-06-19.
 */
public class primMST {

    static final String input = "5 6\n" +
            "1 2 3\n" +
            "1 3 4\n" +
            "4 2 6\n" +
            "5 2 2\n" +
            "2 3 5\n" +
            "3 5 7\n" +
            "1";

    public static void main(String[] args) {
        Scanner in = new Scanner(input);


            int numV = in.nextInt();
            int numE = in.nextInt();

            Graph graph = new Graph(numV);

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int w = in.nextInt();
                System.out.println("edge "+a + " " + b + " " + w);
                graph.addEdge(a, b, w);
                graph.addEdge(b, a, w);
            }

            int start = in.nextInt()-1;

            graph.primMST(start);

        in.close();
    }



    static class GraphEdge {
        int from;
        int to;
        int w;
        GraphEdge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
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

        void addEdge(int from, int to, int w) {
            adj[from].add(new GraphEdge(from, to, w));
        }

        void primMST(int vStart) {
            boolean[] inMST = new boolean[adj.length];

            PriorityQueue<GraphEdge> q = new PriorityQueue<>(new Comparator<GraphEdge>() {
                @Override
                public int compare(GraphEdge p1, GraphEdge p2) {
                    if(p1.w < p2.w) {
                        return -1;
                    } else if(p1.w > p2.w){
                        return 1;
                    }
                    return 0;
                }
            });

            int sum = 0;

            scan(0, inMST, q);

            while (!q.isEmpty()) {
                GraphEdge pair = q.remove();

                if(inMST[pair.from] && inMST[pair.to]) {
                    continue;
                }
                sum += pair.w;
                if(!inMST[pair.from]) scan(pair.from, inMST, q);
                if(!inMST[pair.to]) scan(pair.to, inMST, q );
            }

            System.out.print(sum);
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
