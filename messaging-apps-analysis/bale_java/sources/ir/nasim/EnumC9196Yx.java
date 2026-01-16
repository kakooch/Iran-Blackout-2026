package ir.nasim;

/* renamed from: ir.nasim.Yx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC9196Yx {
    UNKNOWN(0),
    PRIVATE(1),
    GROUP(2),
    CHANNEL(3),
    BOT(4),
    SUPERGROUP(5),
    THREAD(6),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC9196Yx(int i) {
        this.a = i;
    }

    public static EnumC9196Yx p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return PRIVATE;
            case 2:
                return GROUP;
            case 3:
                return CHANNEL;
            case 4:
                return BOT;
            case 5:
                return SUPERGROUP;
            case 6:
                return THREAD;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
