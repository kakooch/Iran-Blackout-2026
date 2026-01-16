package ir.nasim;

/* loaded from: classes4.dex */
public enum SA {
    NONE(1),
    BALE_USER(2201),
    BALE_ORG(3301),
    IRDR(6681),
    UNSUPPORTED_VALUE(-1);

    private int a;

    SA(int i) {
        this.a = i;
    }

    public static SA p(int i) {
        return i != 1 ? i != 2201 ? i != 3301 ? i != 6681 ? UNSUPPORTED_VALUE : IRDR : BALE_ORG : BALE_USER : NONE;
    }

    public int j() {
        return this.a;
    }
}
