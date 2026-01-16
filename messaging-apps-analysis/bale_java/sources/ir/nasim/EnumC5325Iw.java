package ir.nasim;

/* renamed from: ir.nasim.Iw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC5325Iw {
    UKNOWN(1),
    PRIVATE(2),
    GROUP(3),
    MULTIPEER(4),
    CHANNEL_LIVE(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC5325Iw(int i) {
        this.a = i;
    }

    public static EnumC5325Iw p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : CHANNEL_LIVE : MULTIPEER : GROUP : PRIVATE : UKNOWN;
    }

    public int j() {
        return this.a;
    }
}
