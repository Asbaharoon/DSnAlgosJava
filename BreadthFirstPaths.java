// Algorithm 4.2 Breadth-first search to find paths in a graph

public class BreadthFirstPaths
{
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // Mark the source
        queue.enqueue(s); // and put it on the queue
        while (!q.isEmpty())
        {
            int v = queue.dequeue(); // Remove next vertex from the queue
            for (int w : G.adj(v))
                if (!marked[w]) // for every unmarked adjacent vertex
                {
                    edgeTo[w] = v; // save last edge on a shortest path
                    marked[w] = true; // mark it because path is known
                    queue.enqueue(w); // add it to the queue
                }
        }
    }

    private boolean hasPath(int v)
    {   return marked[v];   }
}