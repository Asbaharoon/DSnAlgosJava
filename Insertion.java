/* Algorithm 2.2 Insertion sort */

public class Insertion {
    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            // Insert a[i] among a[i - 1], a[i - 2],a[i - 3] .....
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - i);
        }
    }

    
}
