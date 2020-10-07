// Algorithm 3.6 Hashing with linear probing

public class LinearProbingHashST<Key, Value>
{
    private int N; // number of key-value pairs in the table
    private int M = 16; // size of the linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    public LinearProbingHashST()
    {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key)
    {   return (key.hashCode() & 0x7777777) % M;    }

    // Todo
    // private void resize() 

    public void put(Key key, Value val)
    {
        if (N >= M/2) resize(2 * M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) { vals[i] = val; return; }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
    
}