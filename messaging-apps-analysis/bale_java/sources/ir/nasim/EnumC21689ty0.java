package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ty0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC21689ty0 {
    public static final EnumC21689ty0 a = new EnumC21689ty0("LIKE", 0);
    public static final EnumC21689ty0 b = new EnumC21689ty0("NONE", 1);
    private static final /* synthetic */ EnumC21689ty0[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC21689ty0[] enumC21689ty0ArrA = a();
        c = enumC21689ty0ArrA;
        d = G92.a(enumC21689ty0ArrA);
    }

    private EnumC21689ty0(String str, int i) {
    }

    private static final /* synthetic */ EnumC21689ty0[] a() {
        return new EnumC21689ty0[]{a, b};
    }

    public static EnumC21689ty0 valueOf(String str) {
        return (EnumC21689ty0) Enum.valueOf(EnumC21689ty0.class, str);
    }

    public static EnumC21689ty0[] values() {
        return (EnumC21689ty0[]) c.clone();
    }
}
