// Algorithm 5.10 Huffman compression

public class Huffman 
{
    private static int R = 256; // ASCII alphabet

    private static class Node implements Comparable<Node>
    {
        // Huffman trie node
        private char ch; // unused for internal nodes
        private int freq; // unused for expand
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right)
        {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf()
        {   return left == null && right == null;   }

        public int compareTo(Node that)
        {   return this.freq - that.freq;   }
    }

    public static void expand()
    {
        Node root = readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++)
        {
            // Expand ith codeword
            Node x = root;
            while(!x.isLeaf())
                if (BinaryStdIn.readBoolean())
                    x = x.right;
                else x = x.left;
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }

    private static String[] buildCode(Node root)
    {
        // Make a lookup table from trie
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s)
    {
        // Make a lookup table from trie (recursive)
        if (x.isLeaf())
        {
            st[x.ch] = s; return.;
        }
        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }

    public static void compress()
    {
        // Read input
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        // Tabulate frequency counts
        int[] freq = new int[R];
        for(int i = 0; i < input.length; i++)
            freq[input[i]]++;
        
        // Build Huffman code trie
        Node root = buildTrie(freq);

        // Build code table (recursive)
        String[] st = new String[R];
        buildCode(st, root, "");

        // Print trie for decoder (recursive).
        writeTrie(root);

        // Print number of chars.
        BinaryStdOut.write(input.length);

        // Use Huffman code to encode input
        for (int i = 0; i < input.length; i++)
        {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++)
            if (code.charAt(j) == '1')
                BinaryStdOut.write(true);
            else BinaryStdOut.write(false);
        }
        BinaryStdOut.close();
    }
}
