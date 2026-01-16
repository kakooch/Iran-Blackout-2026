package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Jz7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC5594Jz7 {
    public static final EnumC5594Jz7 b = new EnumC5594Jz7("EXTRA_SLOW", 0, 800);
    public static final EnumC5594Jz7 c = new EnumC5594Jz7("SLOW", 1, 500);
    public static final EnumC5594Jz7 d = new EnumC5594Jz7("NORMAL", 2, 200);
    public static final EnumC5594Jz7 e = new EnumC5594Jz7("FAST", 3, 90);
    public static final EnumC5594Jz7 f = new EnumC5594Jz7("EXTRA_FAST", 4, 10);
    private static final /* synthetic */ EnumC5594Jz7[] g;
    private static final /* synthetic */ F92 h;
    private final long a;

    static {
        EnumC5594Jz7[] enumC5594Jz7ArrA = a();
        g = enumC5594Jz7ArrA;
        h = G92.a(enumC5594Jz7ArrA);
    }

    private EnumC5594Jz7(String str, int i, long j) {
        this.a = j;
    }

    private static final /* synthetic */ EnumC5594Jz7[] a() {
        return new EnumC5594Jz7[]{b, c, d, e, f};
    }

    public static EnumC5594Jz7 valueOf(String str) {
        return (EnumC5594Jz7) Enum.valueOf(EnumC5594Jz7.class, str);
    }

    public static EnumC5594Jz7[] values() {
        return (EnumC5594Jz7[]) g.clone();
    }

    public final long j() {
        return this.a;
    }
}
