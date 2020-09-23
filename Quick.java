// Algorithm 2.5 Quicksort

public class Quick 
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a); // Eliminate dependance on input
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition
        sort(a, lo, j - 1); // Sort left part a[lo .. j - 1]
        sort(a, j + 1, hi); // sort right part a[j + 1 .. hi]

    }
    
}
