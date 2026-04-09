/*
Problem 2: Client Risk Score Ranking
Sort clients by riskScore ascending using Bubble Sort.
Sort by riskScore descending using Insertion Sort.
Identify top 10 highest risk clients.
*/

class Client {
    String name;
    int risk;
    double bal;

    Client(String n, int r, double b) {
        name = n;
        risk = r;
        bal = b;
    }
}

class P2 {
    static void bubble(Client[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].risk > a[j + 1].risk) {
                    Client t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    static void insertion(Client[] a) {
        for (int i = 1; i < a.length; i++) {
            Client k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].risk < k.risk) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        Client[] a = {
                new Client("A",20,100),
                new Client("B",50,200),
                new Client("C",80,300)
        };

        bubble(a);
        insertion(a);

        for (int i = 0; i < Math.min(10, a.length); i++) {
            System.out.println(a[i].name + " " + a[i].risk);
        }
    }
}