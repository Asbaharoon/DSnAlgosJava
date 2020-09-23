/* Algorithm 2.4 Top-down mergesort */

public class Merge {

    private static Comparable[] aux; // auxiliary array for merges
    private static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length]; // allocate space just once
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        // Sort a[lo..hi]
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // sort left half
        sort(a, mid+1, hi); // sort right half.
        // Todo
        // merge(a, lo, mid, hi);
    }
    
}
