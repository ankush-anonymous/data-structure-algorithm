import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending order
            // return p2.cost - this.cost; //descending order
        }
    }

    public static void findMST(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));

                }

            }
        }
        System.out.println("min cost=" + finalCost);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        findMST(graph);
    }
}
