// Algorithm 5.10 Huffman compression

public class Huffman 
{
    private static int R = 256; // ASCII alphabet

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
