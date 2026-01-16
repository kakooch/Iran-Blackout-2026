package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.up3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC22195up3 {
    public static final EnumC22195up3 a = new EnumC22195up3("PANEL", 0);
    public static final EnumC22195up3 b = new EnumC22195up3("KEYBOARD", 1);
    private static final /* synthetic */ EnumC22195up3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC22195up3[] enumC22195up3ArrA = a();
        c = enumC22195up3ArrA;
        d = G92.a(enumC22195up3ArrA);
    }

    private EnumC22195up3(String str, int i) {
    }

    private static final /* synthetic */ EnumC22195up3[] a() {
        return new EnumC22195up3[]{a, b};
    }

    public static EnumC22195up3 valueOf(String str) {
        return (EnumC22195up3) Enum.valueOf(EnumC22195up3.class, str);
    }

    public static EnumC22195up3[] values() {
        return (EnumC22195up3[]) c.clone();
    }
}
