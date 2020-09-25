/* Quicksort with 3-way partitioning
This sort code partitions to put keys equal to the partitioning
element in place and thus does not have to include those keys in the
subarray for the recursive calls. it is far more efficient than
the standard quicksort implementation for arrays with large numbers of duplicate
*/

public class Quick3way
{
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
