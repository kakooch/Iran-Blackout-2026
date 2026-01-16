package ir.nasim;

/* loaded from: classes4.dex */
public enum UA {
    NULL(1),
    INCREASE(2),
    DECREASE(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    UA(int i) {
        this.a = i;
    }

    public static UA p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : DECREASE : INCREASE : NULL;
    }

    public int j() {
        return this.a;
    }
}
