package lab5;

import java.util.Arrays;

public class IntegerSet {
    private final boolean[] a = new boolean[101]; // 0..100

    public IntegerSet() {
        // всё false по умолчанию
    }

    public static IntegerSet union(IntegerSet s1, IntegerSet s2) {
        IntegerSet r = new IntegerSet();
        for (int i = 0; i <= 100; i++) r.a[i] = s1.a[i] || s2.a[i];
        return r;
    }

    public static IntegerSet intersection(IntegerSet s1, IntegerSet s2) {
        IntegerSet r = new IntegerSet();
        for (int i = 0; i <= 100; i++) r.a[i] = s1.a[i] && s2.a[i];
        return r;
    }

    public void insertElement(int k) {
        if (k >= 0 && k <= 100) a[k] = true;
    }

    public void deleteElement(int m) {
        if (m >= 0 && m <= 100) a[m] = false;
    }

    public boolean contains(int x) {
        return x >= 0 && x <= 100 && a[x];
    }

    public boolean isEqualTo(IntegerSet other) {
        return Arrays.equals(this.a, other.a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean empty = true;
        for (int i = 0; i <= 100; i++) {
            if (a[i]) {
                if (!empty) sb.append(' ');
                sb.append(i);
                empty = false;
            }
        }
        return empty ? "---" : sb.toString();
    }
}
