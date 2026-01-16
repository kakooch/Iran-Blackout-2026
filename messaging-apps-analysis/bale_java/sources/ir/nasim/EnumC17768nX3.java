package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nX3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC17768nX3 {
    public static final EnumC17768nX3 a = new EnumC17768nX3("GIF", 0);
    public static final EnumC17768nX3 b = new EnumC17768nX3("UNKNOWN", 1);
    private static final /* synthetic */ EnumC17768nX3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC17768nX3[] enumC17768nX3ArrA = a();
        c = enumC17768nX3ArrA;
        d = G92.a(enumC17768nX3ArrA);
    }

    private EnumC17768nX3(String str, int i) {
    }

    private static final /* synthetic */ EnumC17768nX3[] a() {
        return new EnumC17768nX3[]{a, b};
    }

    public static EnumC17768nX3 valueOf(String str) {
        return (EnumC17768nX3) Enum.valueOf(EnumC17768nX3.class, str);
    }

    public static EnumC17768nX3[] values() {
        return (EnumC17768nX3[]) c.clone();
    }
}
