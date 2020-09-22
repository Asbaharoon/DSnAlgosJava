/* Algorithm 2.3 Shellsort */

public class Shell
{
    public static void sort(Comparable[] a)
    {
        // Sort a[] into increasing order
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1; // 1, 4, 13, 40, 121...
        while (h >= 1)
        {
            // h-sort the array.
            for (int i = h; i < N; i++)
            {
                // Insert a[i] among a[i - h], a[i - 2*h], a[i - 3*h]....
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h/3;
        }
    }

    /* Todo 
    less(), exch(), isSorted(), main()
    */
}
