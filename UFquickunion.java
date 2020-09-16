public class UFquickunion {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public UFquickunion(int N)
    {  // Initialize component id array
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count()
    {   return count;   }
    public boolean connected(int p, int q)
    {   return find(p) == find(q);  }

    public int find(int p)
    {
        // find component name
        while (p != id[p]) p = id[p];
        return p;
    }

    // Quick union
    public void union(int p, int q)
    {
        // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;

    }

    public static void main(String[] args)
    { // Solve dynamic connectivity problem on StdIn 
        int N = StdIn.readInt();    // Read number of sites
        UFquickfind uf = new UFquickfind(N);  // Initialize N components
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect.

            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOUt.println(uf.count() + " components");
    }

    
}
