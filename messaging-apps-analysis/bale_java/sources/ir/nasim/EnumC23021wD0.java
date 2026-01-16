package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wD0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC23021wD0 {
    public static final EnumC23021wD0 a = new EnumC23021wD0("FRONT", 0);
    public static final EnumC23021wD0 b = new EnumC23021wD0("BACK", 1);
    private static final /* synthetic */ EnumC23021wD0[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC23021wD0[] enumC23021wD0ArrA = a();
        c = enumC23021wD0ArrA;
        d = G92.a(enumC23021wD0ArrA);
    }

    private EnumC23021wD0(String str, int i) {
    }

    private static final /* synthetic */ EnumC23021wD0[] a() {
        return new EnumC23021wD0[]{a, b};
    }

    public static EnumC23021wD0 valueOf(String str) {
        return (EnumC23021wD0) Enum.valueOf(EnumC23021wD0.class, str);
    }

    public static EnumC23021wD0[] values() {
        return (EnumC23021wD0[]) c.clone();
    }
}
