package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pc6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19000pc6 {
    public static final EnumC19000pc6 a = new EnumC19000pc6("FitInside", 0);
    public static final EnumC19000pc6 b = new EnumC19000pc6("Fill", 1);
    private static final /* synthetic */ EnumC19000pc6[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC19000pc6[] enumC19000pc6ArrA = a();
        c = enumC19000pc6ArrA;
        d = G92.a(enumC19000pc6ArrA);
    }

    private EnumC19000pc6(String str, int i) {
    }

    private static final /* synthetic */ EnumC19000pc6[] a() {
        return new EnumC19000pc6[]{a, b};
    }

    public static EnumC19000pc6 valueOf(String str) {
        return (EnumC19000pc6) Enum.valueOf(EnumC19000pc6.class, str);
    }

    public static EnumC19000pc6[] values() {
        return (EnumC19000pc6[]) c.clone();
    }
}
