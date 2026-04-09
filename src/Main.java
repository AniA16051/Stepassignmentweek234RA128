import java.util.*;

/*
Problem 1: Transaction Fee Sorting for Audit Compliance
Sort transactions by fee using Bubble Sort.
Sort by fee + timestamp using Insertion Sort.
Handle duplicates (stable).
Flag high-fee outliers (>50).
*/

class Transaction {
    String id;
    double fee;
    String ts;

    Transaction(String id, double fee, String ts) {
        this.id = id;
        this.fee = fee;
        this.ts = ts;
    }
}

class TransactionProblemStatement1 {
    static void bubble(List<Transaction> a) {
        int n = a.size();
        for (int i = 0; i < n - 1; i++) {
            boolean s = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a.get(j).fee > a.get(j + 1).fee) {
                    Collections.swap(a, j, j + 1);
                    s = true;
                }
            }
            if (!s) break;
        }
    }

    static void insertion(List<Transaction> a) {
        for (int i = 1; i < a.size(); i++) {
            Transaction k = a.get(i);
            int j = i - 1;
            while (j >= 0 && (a.get(j).fee > k.fee ||
                    (a.get(j).fee == k.fee && a.get(j).ts.compareTo(k.ts) > 0))) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j + 1, k);
        }
    }

    public static void main(String[] args) {
        List<Transaction> a = new ArrayList<>();
        a.add(new Transaction("id1",10.5,"10:00"));
        a.add(new Transaction("id2",25.0,"09:30"));
        a.add(new Transaction("id3",5.0,"10:15"));

        bubble(a);
        insertion(a);

        for (Transaction t : a) {
            System.out.println(t.id + " " + t.fee);
            if (t.fee > 50) System.out.println("HIGH");
        }
    }
}