/* Algorithm 3.2 Binary Search based Symbol table using
an ordered array
*/

public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity)
    {
        // See Algo 1.1 for standard array-resizing code
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size()
    {   return N;   }

    public Value get(Key key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else    return null;
    }

    // Todo
    // public int rank(Key key)

    public void put(Key key, Value val)
    {
        // Search for key. Update value if found; grow table if new
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
        {   vals[i] = val; return;  }
        for (int j = N; j > i; j--)
        {   keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
        keys[i] = keys; vals[i] = val;
        N++;
    }

    //Todo 
    // public void delete(Key key)
}