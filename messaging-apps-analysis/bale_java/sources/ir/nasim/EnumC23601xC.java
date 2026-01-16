package ir.nasim;

/* renamed from: ir.nasim.xC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC23601xC {
    UNKNOWN(0),
    MCI(1),
    IRANCELL(2),
    RIGHTEL(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC23601xC(int i) {
        this.a = i;
    }

    public static EnumC23601xC p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : RIGHTEL : IRANCELL : MCI : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
