/* Algorithm 1.5 Union-Find implementation */

public class UF 
{
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public UF(int N)
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

    // Todo
    // public int find(int p)
    // public void union(int p, int q)

    public static void main(String[] args)
    { // Solve dynamic connectivity problem on StdIn 
        int N = StdIn.readInt();    // Read number of sites
        UF uf = new UF(N);  // Initialize N components
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
