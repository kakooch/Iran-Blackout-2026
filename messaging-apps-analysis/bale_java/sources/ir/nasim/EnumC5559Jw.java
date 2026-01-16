package ir.nasim;

/* renamed from: ir.nasim.Jw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC5559Jw {
    UNKNOWN(0),
    INTERNAL(1),
    SIP(2),
    SIP_AND_INTERNAL(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC5559Jw(int i) {
        this.a = i;
    }

    public static EnumC5559Jw p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : SIP_AND_INTERNAL : SIP : INTERNAL : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
