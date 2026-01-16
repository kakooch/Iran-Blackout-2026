package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nt6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC17988nt6 {
    public static final EnumC17988nt6 a = new EnumC17988nt6("Empty", 0);
    public static final EnumC17988nt6 b = new EnumC17988nt6("Shimmer", 1);
    public static final EnumC17988nt6 c = new EnumC17988nt6("Loaded", 2);
    private static final /* synthetic */ EnumC17988nt6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC17988nt6[] enumC17988nt6ArrA = a();
        d = enumC17988nt6ArrA;
        e = G92.a(enumC17988nt6ArrA);
    }

    private EnumC17988nt6(String str, int i) {
    }

    private static final /* synthetic */ EnumC17988nt6[] a() {
        return new EnumC17988nt6[]{a, b, c};
    }

    public static EnumC17988nt6 valueOf(String str) {
        return (EnumC17988nt6) Enum.valueOf(EnumC17988nt6.class, str);
    }

    public static EnumC17988nt6[] values() {
        return (EnumC17988nt6[]) d.clone();
    }
}
