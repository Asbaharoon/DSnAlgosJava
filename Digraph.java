// Graph data type

public class Digraph 
{
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public Digraph(int V)
    {
        this.V = V; this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // create array of lists
        for (int v = 0; v < V; v++) // initialize all lists
            adj[v] = new Bag<Integer>(); // to empty
    }

    public int V() {    return V;   }
    public int E() {    return E;   }

    public void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list
        E++;
    }

    public Iterable<Integer> adj(int v)
    {   return adj[v];  }

    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(W, v);
        return R;
    }
}
