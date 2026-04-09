/*
Problem 5: Account ID Lookup in Transaction Logs
Implement Linear Search.
Implement Binary Search.
Handle duplicates and count occurrences.
*/

class P5 {
    static int lin(String[] a, String t) {
        for (int i = 0; i < a.length; i++)
            if (a[i].equals(t)) return i;
        return -1;
    }

    static int bin(String[] a, String t) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            int c = a[m].compareTo(t);
            if (c == 0) return m;
            if (c < 0) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] a = {"accA","accB","accC"};
        System.out.println(lin(a,"accB"));
        System.out.println(bin(a,"accB"));
    }
}