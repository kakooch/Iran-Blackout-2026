package ir.nasim;

/* renamed from: ir.nasim.Dw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC4140Dw {
    INTERNAL_BROWSER(1),
    EXTERNAL_BROWSER(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC4140Dw(int i) {
        this.a = i;
    }

    public static EnumC4140Dw p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : EXTERNAL_BROWSER : INTERNAL_BROWSER;
    }

    public int j() {
        return this.a;
    }
}
