package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.rM6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC20036rM6 {
    public static final EnumC20036rM6 a = new EnumC20036rM6("SUCCESS", 0);
    public static final EnumC20036rM6 b = new EnumC20036rM6("ERROR", 1);
    public static final EnumC20036rM6 c = new EnumC20036rM6("EMPTY_LOADING", 2);
    public static final EnumC20036rM6 d = new EnumC20036rM6("START_PROCESS_LOADING", 3);
    public static final EnumC20036rM6 e = new EnumC20036rM6("END_PROCESS_LOADING", 4);
    private static final /* synthetic */ EnumC20036rM6[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC20036rM6[] enumC20036rM6ArrA = a();
        f = enumC20036rM6ArrA;
        g = G92.a(enumC20036rM6ArrA);
    }

    private EnumC20036rM6(String str, int i) {
    }

    private static final /* synthetic */ EnumC20036rM6[] a() {
        return new EnumC20036rM6[]{a, b, c, d, e};
    }

    public static EnumC20036rM6 valueOf(String str) {
        return (EnumC20036rM6) Enum.valueOf(EnumC20036rM6.class, str);
    }

    public static EnumC20036rM6[] values() {
        return (EnumC20036rM6[]) f.clone();
    }
}
