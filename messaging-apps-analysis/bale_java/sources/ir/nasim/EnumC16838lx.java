package ir.nasim;

/* renamed from: ir.nasim.lx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC16838lx {
    INPROGRESS(1),
    DONE(2),
    STOPPED(3),
    EXPIRED(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC16838lx(int i) {
        this.a = i;
    }

    public static EnumC16838lx p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : EXPIRED : STOPPED : DONE : INPROGRESS;
    }

    public int j() {
        return this.a;
    }
}
