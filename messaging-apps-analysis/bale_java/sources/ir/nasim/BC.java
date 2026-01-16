package ir.nasim;

/* loaded from: classes4.dex */
public enum BC {
    UNKOWN(1),
    PRE_PAID(2),
    POST_PAID(3),
    DATA(4),
    ANARESTAN(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    BC(int i) {
        this.a = i;
    }

    public static BC p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : ANARESTAN : DATA : POST_PAID : PRE_PAID : UNKOWN;
    }

    public int j() {
        return this.a;
    }
}
