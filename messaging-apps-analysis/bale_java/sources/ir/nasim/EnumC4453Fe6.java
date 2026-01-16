package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Fe6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC4453Fe6 {
    public static final EnumC4453Fe6 a = new EnumC4453Fe6("CLOSE", 0);
    public static final EnumC4453Fe6 b = new EnumC4453Fe6("CLEAR_SEARCH", 1);
    private static final /* synthetic */ EnumC4453Fe6[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC4453Fe6[] enumC4453Fe6ArrA = a();
        c = enumC4453Fe6ArrA;
        d = G92.a(enumC4453Fe6ArrA);
    }

    private EnumC4453Fe6(String str, int i) {
    }

    private static final /* synthetic */ EnumC4453Fe6[] a() {
        return new EnumC4453Fe6[]{a, b};
    }

    public static EnumC4453Fe6 valueOf(String str) {
        return (EnumC4453Fe6) Enum.valueOf(EnumC4453Fe6.class, str);
    }

    public static EnumC4453Fe6[] values() {
        return (EnumC4453Fe6[]) c.clone();
    }
}
