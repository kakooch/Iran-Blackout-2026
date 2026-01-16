package ir.nasim;

/* loaded from: classes4.dex */
public enum CA {
    UNKNOWN(0),
    PRIVATE(1),
    GROUP(2),
    ENCRYPTEDPRIVATE(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    CA(int i) {
        this.a = i;
    }

    public static CA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : ENCRYPTEDPRIVATE : GROUP : PRIVATE : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
