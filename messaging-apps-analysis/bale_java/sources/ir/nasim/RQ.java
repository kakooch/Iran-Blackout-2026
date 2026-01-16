package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class RQ {
    public static final RQ a = new RQ("CREATE_PASSWORD", 0);
    public static final RQ b = new RQ("OTP", 1);
    public static final RQ c = new RQ("VALIDATE_PASSWORD", 2);
    private static final /* synthetic */ RQ[] d;
    private static final /* synthetic */ F92 e;

    static {
        RQ[] rqArrA = a();
        d = rqArrA;
        e = G92.a(rqArrA);
    }

    private RQ(String str, int i) {
    }

    private static final /* synthetic */ RQ[] a() {
        return new RQ[]{a, b, c};
    }

    public static RQ valueOf(String str) {
        return (RQ) Enum.valueOf(RQ.class, str);
    }

    public static RQ[] values() {
        return (RQ[]) d.clone();
    }
}
