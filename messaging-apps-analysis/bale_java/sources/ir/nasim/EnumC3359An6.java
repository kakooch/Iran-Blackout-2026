package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.An6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC3359An6 {
    public static final EnumC3359An6 a = new EnumC3359An6("Left", 0);
    public static final EnumC3359An6 b = new EnumC3359An6("Middle", 1);
    public static final EnumC3359An6 c = new EnumC3359An6("Right", 2);
    private static final /* synthetic */ EnumC3359An6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC3359An6[] enumC3359An6ArrA = a();
        d = enumC3359An6ArrA;
        e = G92.a(enumC3359An6ArrA);
    }

    private EnumC3359An6(String str, int i) {
    }

    private static final /* synthetic */ EnumC3359An6[] a() {
        return new EnumC3359An6[]{a, b, c};
    }

    public static EnumC3359An6 valueOf(String str) {
        return (EnumC3359An6) Enum.valueOf(EnumC3359An6.class, str);
    }

    public static EnumC3359An6[] values() {
        return (EnumC3359An6[]) d.clone();
    }
}
