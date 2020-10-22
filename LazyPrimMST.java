// Lazy version of Prim's MST algorithm

public class LazyPrimMST 
{
    private boolean[] marked; // MST vertices
    private Queue<Edge> mst; // MST edges
    private MinPQ<Edge> pq; // crossing (and ineligible) edges

    public LazyPrimMST(EdgeWeightedGraph G)
    {
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();

        visit(G, 0); // assume G is connected
        while (!pq.isEmpty())
        {
            Edge e = pq.delMin(); // get lowest weight
            int v = e.either(), w = e.other(v); // edge from pq
            if (marked[v] && marked[w]) continue; // skip if ineligible
            mst.enqueue(e); // add edge to tree
            if (!marked[v]) visit(G, v); // a vertex to tree
            if (!marked[w]) visit(G, w); // either v or w
        }
    }

    private void visit(EdgeWeightedGraph G, int v)
    {
        // mark v and add to pq all edges from v to unmarked vertices
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    public Iterable<Edge> edges()
    {   return mst; }
}
