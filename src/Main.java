/*
Problem 4: Portfolio Return Sorting
Sort assets using Merge Sort (ascending return).
Sort using Quick Sort (descending return).
*/

class Asset {
    String n;
    double r;
    double v;

    Asset(String n, double r, double v) {
        this.n = n;
        this.r = r;
        this.v = v;
    }
}

class P4 {
    static void merge(Asset[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++) L[i] = a[l + i];
        for (int j = 0; j < n2; j++) R[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i].r <= R[j].r) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    static void ms(Asset[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            ms(a, l, m);
            ms(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static int part(Asset[] a, int l, int h) {
        double p = a[h].r;
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j].r > p) {
                i++;
                Asset t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        Asset t = a[i + 1];
        a[i + 1] = a[h];
        a[h] = t;
        return i + 1;
    }

    static void qs(Asset[] a, int l, int h) {
        if (l < h) {
            int pi = part(a, l, h);
            qs(a, l, pi - 1);
            qs(a, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        Asset[] a = {
                new Asset("AAPL",12,2),
                new Asset("TSLA",8,3),
                new Asset("GOOG",15,1)
        };

        ms(a,0,a.length-1);
        qs(a,0,a.length-1);

        for (Asset x : a) System.out.println(x.n + " " + x.r);
    }
}