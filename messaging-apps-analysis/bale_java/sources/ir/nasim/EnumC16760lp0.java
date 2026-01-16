package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC16760lp0 {
    public static final EnumC16760lp0 c = new EnumC16760lp0("ENABLED", 0, true, true);
    public static final EnumC16760lp0 d = new EnumC16760lp0("READ_ONLY", 1, true, false);
    public static final EnumC16760lp0 e = new EnumC16760lp0("WRITE_ONLY", 2, false, true);
    public static final EnumC16760lp0 f = new EnumC16760lp0("DISABLED", 3, false, false);
    private static final /* synthetic */ EnumC16760lp0[] g;
    private static final /* synthetic */ F92 h;
    private final boolean a;
    private final boolean b;

    static {
        EnumC16760lp0[] enumC16760lp0ArrA = a();
        g = enumC16760lp0ArrA;
        h = G92.a(enumC16760lp0ArrA);
    }

    private EnumC16760lp0(String str, int i, boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    private static final /* synthetic */ EnumC16760lp0[] a() {
        return new EnumC16760lp0[]{c, d, e, f};
    }

    public static EnumC16760lp0 valueOf(String str) {
        return (EnumC16760lp0) Enum.valueOf(EnumC16760lp0.class, str);
    }

    public static EnumC16760lp0[] values() {
        return (EnumC16760lp0[]) g.clone();
    }

    public final boolean j() {
        return this.a;
    }

    public final boolean p() {
        return this.b;
    }
}
