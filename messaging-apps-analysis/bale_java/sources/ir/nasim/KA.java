package ir.nasim;

/* loaded from: classes4.dex */
public enum KA {
    UNKNOWN(0),
    MAIN_TRANSACTION(1),
    SHARD(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    KA(int i) {
        this.a = i;
    }

    public static KA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : SHARD : MAIN_TRANSACTION : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
