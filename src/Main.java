/*
Problem 3: Historical Trade Volume Analysis
Sort trades by volume using Merge Sort.
Sort by volume descending using Quick Sort.
Merge lists and compute total volume.
*/

class Trade {
    String id;
    int v;

    Trade(String i, int v) {
        id = i;
        this.v = v;
    }
}

class P3 {
    static void merge(Trade[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++) L[i] = a[l + i];
        for (int j = 0; j < n2; j++) R[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i].v <= R[j].v) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    static void ms(Trade[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            ms(a, l, m);
            ms(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static int part(Trade[] a, int l, int h) {
        int p = a[h].v;
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j].v > p) {
                i++;
                Trade t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        Trade t = a[i + 1];
        a[i + 1] = a[h];
        a[h] = t;
        return i + 1;
    }

    static void qs(Trade[] a, int l, int h) {
        if (l < h) {
            int pi = part(a, l, h);
            qs(a, l, pi - 1);
            qs(a, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        Trade[] a = {
                new Trade("t1",500),
                new Trade("t2",100),
                new Trade("t3",300)
        };

        ms(a,0,a.length-1);
        qs(a,0,a.length-1);

        int sum = 0;
        for (Trade t : a) {
            sum += t.v;
            System.out.println(t.id + " " + t.v);
        }
        System.out.println(sum);
    }
}