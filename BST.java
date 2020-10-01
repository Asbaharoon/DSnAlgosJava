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
    }
}