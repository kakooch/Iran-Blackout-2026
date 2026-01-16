package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class I20 {
    public static final I20 a = new I20("NONE", 0);
    public static final I20 b = new I20("HEARTBEAT", 1);
    public static final I20 c = new I20("SHAKE", 2);
    public static final I20 d = new I20("BREATH", 3);
    public static final I20 e = new I20("ROTATE", 4);
    private static final /* synthetic */ I20[] f;
    private static final /* synthetic */ F92 g;

    static {
        I20[] i20ArrA = a();
        f = i20ArrA;
        g = G92.a(i20ArrA);
    }

    private I20(String str, int i) {
    }

    private static final /* synthetic */ I20[] a() {
        return new I20[]{a, b, c, d, e};
    }

    public static I20 valueOf(String str) {
        return (I20) Enum.valueOf(I20.class, str);
    }

    public static I20[] values() {
        return (I20[]) f.clone();
    }
}
