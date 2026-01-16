package ir.nasim;

/* loaded from: classes4.dex */
public enum BB {
    PRIVATE(1),
    PUBLIC(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    BB(int i) {
        this.a = i;
    }

    public static BB p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : PUBLIC : PRIVATE;
    }

    public int j() {
        return this.a;
    }
}
