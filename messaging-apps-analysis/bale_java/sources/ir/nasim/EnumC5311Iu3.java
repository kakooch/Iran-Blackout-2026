package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Iu3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC5311Iu3 {
    public static final EnumC5311Iu3 a = new EnumC5311Iu3("Horizontal", 0);
    public static final EnumC5311Iu3 b = new EnumC5311Iu3("Vertical", 1);
    private static final /* synthetic */ EnumC5311Iu3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC5311Iu3[] enumC5311Iu3ArrA = a();
        c = enumC5311Iu3ArrA;
        d = G92.a(enumC5311Iu3ArrA);
    }

    private EnumC5311Iu3(String str, int i) {
    }

    private static final /* synthetic */ EnumC5311Iu3[] a() {
        return new EnumC5311Iu3[]{a, b};
    }

    public static EnumC5311Iu3 valueOf(String str) {
        return (EnumC5311Iu3) Enum.valueOf(EnumC5311Iu3.class, str);
    }

    public static EnumC5311Iu3[] values() {
        return (EnumC5311Iu3[]) c.clone();
    }
}
