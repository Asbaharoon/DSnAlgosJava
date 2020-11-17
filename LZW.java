// Algorithm 5.11 LZW compression

public class LZW
{
    private static final int R = 256; // number of input chars
    private static final int L = 4096; // number of codewords 2^12
    private static final int W = 12; // codeword width

    public static void compress()
    {
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<Integer>();

        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R + 1; // R is codeword for EOF

        while (input.length() > 0)
        {
            String s = st.longestPrefixOf(input); // Find max prefix match
            BinaryStdOut.write(st.get(s), W); // Print s's encoding
            int t = s.length();
            if (t < input.length() && code < L) // Add s to symbol table.
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t); // scan past s in input
        }

        BinaryStdOut.write(R, W); // write EOF
        BinaryStdOut.close();
    }

    public static void expand()
    {
        
    }
    
}