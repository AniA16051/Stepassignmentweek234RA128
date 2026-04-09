/*
Problem 6: Risk Threshold Binary Lookup
Perform Linear Search for threshold.
Perform Binary Search to find insertion point.
Find floor and ceiling values.
*/

class P6 {
    static void fc(int[] a, int t) {
        int l = 0, h = a.length - 1;
        int f = -1, c = -1;

        while (l <= h) {
            int m = (l + h) / 2;
            if (a[m] == t) {
                f = c = a[m];
                break;
            }
            if (a[m] < t) {
                f = a[m];
                l = m + 1;
            } else {
                c = a[m];
                h = m - 1;
            }
        }
        System.out.println(f + " " + c);
    }

    public static void main(String[] args) {
        int[] a = {10,25,50,100};
        fc(a,30);
    }
}