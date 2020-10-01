/* Algorithm 3.3
A symbol table implemented using Binary Search Tree (BST)
*/

public class BST<Key extends Comparable<Key>, Value>
{
    private Node root; // root of the BST

    private class Node
    {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public Node(Key key, Value val, int N)
        {   this.key = key; this.val = val; this.N = N; }

    }

    public int size()
    {   return size(root);  }

    private int size(Node x)
    {
        if (x == null) return 0;
            else return x.N;
    }

        /*Todo
        public Value get(Key key)
        public void put(Key key, Value val)

        min(), max(), floor(), ceiling()
        select() rank()
        delete(), deleteMin(), deleteMax()
        keys()
        */
    public Value get(Key key)
    {   return get(root, key);  }

    private Value get(Node x, Key key)
    {
        // Return value associated with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val)
    {
        // Search for key. Update value if found; grow table if new
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val)
    {
        // Change key's value to val if key in subtree rooted at x
        // Otherwise, add new node to subtree associating key with val

        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val)
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public Key min()
    {
        return min(root).key;
    }

    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp == key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k)
    {
        return select(root, k).key;
    }

    private Node select(Node x, int k)
    {
        // Return Node containing key of rank k
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }

    public int rank(Key key)
    {   return rank(key, root);     }

    private int rank(Key key, Node x)
    {
        // Return number of keys less than x.key in the subtree rooted at x
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
}