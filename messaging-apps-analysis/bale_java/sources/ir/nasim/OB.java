package ir.nasim;

/* loaded from: classes4.dex */
public enum OB {
    GROUPS(1),
    CONTACTS(2),
    PUBLIC(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    OB(int i) {
        this.a = i;
    }

    public static OB p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : PUBLIC : CONTACTS : GROUPS;
    }

    public int j() {
        return this.a;
    }
}
