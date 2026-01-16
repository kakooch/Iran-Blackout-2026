package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC14254hc6 {
    public static final EnumC14254hc6 a = new EnumC14254hc6("FILL", 0);
    public static final EnumC14254hc6 b = new EnumC14254hc6("FIT", 1);
    private static final /* synthetic */ EnumC14254hc6[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC14254hc6[] enumC14254hc6ArrA = a();
        c = enumC14254hc6ArrA;
        d = G92.a(enumC14254hc6ArrA);
    }

    private EnumC14254hc6(String str, int i) {
    }

    private static final /* synthetic */ EnumC14254hc6[] a() {
        return new EnumC14254hc6[]{a, b};
    }

    public static EnumC14254hc6 valueOf(String str) {
        return (EnumC14254hc6) Enum.valueOf(EnumC14254hc6.class, str);
    }

    public static EnumC14254hc6[] values() {
        return (EnumC14254hc6[]) c.clone();
    }
}
