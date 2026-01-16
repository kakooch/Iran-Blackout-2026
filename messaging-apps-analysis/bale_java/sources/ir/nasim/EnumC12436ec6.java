package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ec6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class EnumC12436ec6 {
    public static final EnumC12436ec6 a = new EnumC12436ec6("TopBar", 0);
    public static final EnumC12436ec6 b = new EnumC12436ec6("MainContent", 1);
    public static final EnumC12436ec6 c = new EnumC12436ec6("Snackbar", 2);
    public static final EnumC12436ec6 d = new EnumC12436ec6("Fab", 3);
    public static final EnumC12436ec6 e = new EnumC12436ec6("BottomBar", 4);
    private static final /* synthetic */ EnumC12436ec6[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC12436ec6[] enumC12436ec6ArrA = a();
        f = enumC12436ec6ArrA;
        g = G92.a(enumC12436ec6ArrA);
    }

    private EnumC12436ec6(String str, int i) {
    }

    private static final /* synthetic */ EnumC12436ec6[] a() {
        return new EnumC12436ec6[]{a, b, c, d, e};
    }

    public static EnumC12436ec6 valueOf(String str) {
        return (EnumC12436ec6) Enum.valueOf(EnumC12436ec6.class, str);
    }

    public static EnumC12436ec6[] values() {
        return (EnumC12436ec6[]) f.clone();
    }
}
