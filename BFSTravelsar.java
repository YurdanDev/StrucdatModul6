import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int vertex;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;
    private Queue<Integer> queue;

    public BFSTraversal(int v) {
        vertex = v;
        adj = new LinkedList[vertex];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        visited = new boolean[vertex];
        queue = new LinkedList<>();
    }

    public void insertEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Tambahkan ini untuk menjadikan edge menjadi bidirectional
    }

    public void BFS(int startVertex) {
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> neighbors = adj[currentVertex];
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(2, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(3, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(5, 3);

        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0); // Ubah nilai argumen menjadi 0 (node awal) sesuai dengan output yang diinginkan
    }
}
