package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.vK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC22491vK3 {
    public static final EnumC22491vK3 a = new EnumC22491vK3("Immediately", 0);
    public static final EnumC22491vK3 b = new EnumC22491vK3("OnIterationFinish", 1);
    private static final /* synthetic */ EnumC22491vK3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC22491vK3[] enumC22491vK3ArrA = a();
        c = enumC22491vK3ArrA;
        d = G92.a(enumC22491vK3ArrA);
    }

    private EnumC22491vK3(String str, int i) {
    }

    private static final /* synthetic */ EnumC22491vK3[] a() {
        return new EnumC22491vK3[]{a, b};
    }

    public static EnumC22491vK3 valueOf(String str) {
        return (EnumC22491vK3) Enum.valueOf(EnumC22491vK3.class, str);
    }

    public static EnumC22491vK3[] values() {
        return (EnumC22491vK3[]) c.clone();
    }
}
