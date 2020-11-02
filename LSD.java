// Algorithm 5.1 LSD (Least Significant Digit) sort

public class LSD 
{
    public static void sort(String[] a, int W)
    {
        // Sort a[] on leading W characters
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W-1; d >=0; d--)
        {
            // sort by key-indexed counting on dth char

            int[] count = new int[R + 1]; // compute frequency counts
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d)+ 1]++;

            for (int r = 0; r < R; r++) // Transform counts to indices
                count[r + 1] += count[r];
            
            for (int i = 0; i < N; i++) // Distribute
                aux[count[a[i].charAt(d)]++] = a[i];

            for (int i = 0; i < N; i++) // Copy back
                a[i] = aux[i];
        }
    }
    
}
