package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class VC2 {
    public static final VC2 a = new VC2("ALL", 0);
    public static final VC2 b = new VC2("VIDEOS", 1);
    public static final VC2 c = new VC2("IMAGES", 2);
    private static final /* synthetic */ VC2[] d;
    private static final /* synthetic */ F92 e;

    static {
        VC2[] vc2ArrA = a();
        d = vc2ArrA;
        e = G92.a(vc2ArrA);
    }

    private VC2(String str, int i) {
    }

    private static final /* synthetic */ VC2[] a() {
        return new VC2[]{a, b, c};
    }

    public static VC2 valueOf(String str) {
        return (VC2) Enum.valueOf(VC2.class, str);
    }

    public static VC2[] values() {
        return (VC2[]) d.clone();
    }
}
