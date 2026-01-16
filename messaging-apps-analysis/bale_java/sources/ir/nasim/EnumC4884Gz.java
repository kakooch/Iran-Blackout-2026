package ir.nasim;

/* renamed from: ir.nasim.Gz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC4884Gz {
    SENT(1),
    RECEIVED(2),
    READ(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC4884Gz(int i) {
        this.a = i;
    }

    public static EnumC4884Gz p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : READ : RECEIVED : SENT;
    }

    public int j() {
        return this.a;
    }
}
