package ir.nasim;

/* renamed from: ir.nasim.hx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC14458hx {
    PHONE(1),
    EMAIL(2),
    WEB(3),
    SOCIAL(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC14458hx(int i) {
        this.a = i;
    }

    public static EnumC14458hx p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : SOCIAL : WEB : EMAIL : PHONE;
    }

    public int j() {
        return this.a;
    }
}
