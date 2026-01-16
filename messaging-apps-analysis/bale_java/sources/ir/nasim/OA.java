package ir.nasim;

/* loaded from: classes4.dex */
public enum OA {
    UNKNOWN(0),
    WITHNOCHILD(1),
    WITHCHILD(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    OA(int i) {
        this.a = i;
    }

    public static OA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : WITHCHILD : WITHNOCHILD : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
