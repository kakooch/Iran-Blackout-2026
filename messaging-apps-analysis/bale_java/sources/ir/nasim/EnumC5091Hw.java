package ir.nasim;

/* renamed from: ir.nasim.Hw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC5091Hw {
    UNKNOWN(0),
    MISSED(1),
    DISCONNECT(2),
    HANGUP(3),
    BUSY(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC5091Hw(int i) {
        this.a = i;
    }

    public static EnumC5091Hw p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : BUSY : HANGUP : DISCONNECT : MISSED : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
