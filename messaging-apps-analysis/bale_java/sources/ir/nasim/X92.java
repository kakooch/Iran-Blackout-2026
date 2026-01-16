package ir.nasim;

/* loaded from: classes3.dex */
public enum X92 {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final X92[] f;
    private final int a;

    static {
        X92 x92 = L;
        X92 x922 = M;
        X92 x923 = Q;
        f = new X92[]{x922, x92, H, x923};
    }

    X92(int i) {
        this.a = i;
    }

    public static X92 a(int i) {
        if (i >= 0) {
            X92[] x92Arr = f;
            if (i < x92Arr.length) {
                return x92Arr[i];
            }
        }
        throw new IllegalArgumentException();
    }

    public int j() {
        return this.a;
    }
}
