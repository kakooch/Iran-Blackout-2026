package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class VF3 {
    public static final VF3 a = new VF3("LoadingForward", 0);
    public static final VF3 b = new VF3("LoadingBackward", 1);
    public static final VF3 c = new VF3("LoadingBoth", 2);
    public static final VF3 d = new VF3("NotNeedToLoadHistory", 3);
    public static final VF3 e = new VF3("LadHistoryFinished", 4);
    private static final /* synthetic */ VF3[] f;
    private static final /* synthetic */ F92 g;

    static {
        VF3[] vf3ArrA = a();
        f = vf3ArrA;
        g = G92.a(vf3ArrA);
    }

    private VF3(String str, int i) {
    }

    private static final /* synthetic */ VF3[] a() {
        return new VF3[]{a, b, c, d, e};
    }

    public static VF3 valueOf(String str) {
        return (VF3) Enum.valueOf(VF3.class, str);
    }

    public static VF3[] values() {
        return (VF3[]) f.clone();
    }
}
