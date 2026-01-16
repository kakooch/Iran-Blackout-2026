package ir.nasim;

/* renamed from: ir.nasim.Lv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6017Lv {
    THISDEVICE(1),
    OTHERDEVICE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6017Lv(int i) {
        this.a = i;
    }

    public static EnumC6017Lv p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : OTHERDEVICE : THISDEVICE;
    }

    public int j() {
        return this.a;
    }
}
