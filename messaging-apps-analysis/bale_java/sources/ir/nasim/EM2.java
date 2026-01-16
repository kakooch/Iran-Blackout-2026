package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class EM2 {
    public static final EM2 a = new EM2("PERMITTED", 0);
    public static final EM2 b = new EM2("NOT_PERMITTED_FOR_MEMBER", 1);
    public static final EM2 c = new EM2("NOT_PERMITTED_FOR_GROUP", 2);
    private static final /* synthetic */ EM2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EM2[] em2ArrA = a();
        d = em2ArrA;
        e = G92.a(em2ArrA);
    }

    private EM2(String str, int i) {
    }

    private static final /* synthetic */ EM2[] a() {
        return new EM2[]{a, b, c};
    }

    public static EM2 valueOf(String str) {
        return (EM2) Enum.valueOf(EM2.class, str);
    }

    public static EM2[] values() {
        return (EM2[]) d.clone();
    }
}
