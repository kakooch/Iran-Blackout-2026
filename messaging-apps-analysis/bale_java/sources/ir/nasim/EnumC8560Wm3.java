package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Wm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC8560Wm3 {
    public static final EnumC8560Wm3 a = new EnumC8560Wm3("PUBLIC", 0);
    public static final EnumC8560Wm3 b = new EnumC8560Wm3("PROTECTED", 1);
    public static final EnumC8560Wm3 c = new EnumC8560Wm3("INTERNAL", 2);
    public static final EnumC8560Wm3 d = new EnumC8560Wm3("PRIVATE", 3);
    private static final /* synthetic */ EnumC8560Wm3[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC8560Wm3[] enumC8560Wm3ArrA = a();
        e = enumC8560Wm3ArrA;
        f = G92.a(enumC8560Wm3ArrA);
    }

    private EnumC8560Wm3(String str, int i) {
    }

    private static final /* synthetic */ EnumC8560Wm3[] a() {
        return new EnumC8560Wm3[]{a, b, c, d};
    }

    public static EnumC8560Wm3 valueOf(String str) {
        return (EnumC8560Wm3) Enum.valueOf(EnumC8560Wm3.class, str);
    }

    public static EnumC8560Wm3[] values() {
        return (EnumC8560Wm3[]) e.clone();
    }
}
