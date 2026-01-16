package ir.nasim;

/* renamed from: ir.nasim.nw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18011nw {
    UNKNOWN(0),
    MIDTERM(1),
    ENDTERM(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18011nw(int i) {
        this.a = i;
    }

    public static EnumC18011nw p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : ENDTERM : MIDTERM : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
