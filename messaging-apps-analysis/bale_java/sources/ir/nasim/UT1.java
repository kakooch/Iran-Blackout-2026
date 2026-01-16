package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class UT1 {
    public static final UT1 a = new UT1("UNKNOWN_REASON", 0);
    public static final UT1 b = new UT1("CLIENT_INITIATED", 1);
    public static final UT1 c = new UT1("DUPLICATE_IDENTITY", 2);
    public static final UT1 d = new UT1("SERVER_SHUTDOWN", 3);
    public static final UT1 e = new UT1("PARTICIPANT_REMOVED", 4);
    public static final UT1 f = new UT1("ROOM_DELETED", 5);
    public static final UT1 g = new UT1("STATE_MISMATCH", 6);
    public static final UT1 h = new UT1("JOIN_FAILURE", 7);
    public static final UT1 i = new UT1("MIGRATION", 8);
    public static final UT1 j = new UT1("SIGNAL_CLOSE", 9);
    public static final UT1 k = new UT1("ROOM_CLOSED", 10);
    public static final UT1 l = new UT1("USER_UNAVAILABLE", 11);
    public static final UT1 m = new UT1("USER_REJECTED", 12);
    public static final UT1 n = new UT1("SIP_TRUNK_FAILURE", 13);
    public static final UT1 o = new UT1("CONNECTION_TIMEOUT", 14);
    public static final UT1 p = new UT1("MEDIA_FAILURE", 15);
    private static final /* synthetic */ UT1[] q;
    private static final /* synthetic */ F92 r;

    static {
        UT1[] ut1ArrA = a();
        q = ut1ArrA;
        r = G92.a(ut1ArrA);
    }

    private UT1(String str, int i2) {
    }

    private static final /* synthetic */ UT1[] a() {
        return new UT1[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
    }

    public static UT1 valueOf(String str) {
        return (UT1) Enum.valueOf(UT1.class, str);
    }

    public static UT1[] values() {
        return (UT1[]) q.clone();
    }
}
