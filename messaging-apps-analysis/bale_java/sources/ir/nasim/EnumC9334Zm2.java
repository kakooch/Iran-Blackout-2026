package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Zm2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC9334Zm2 {
    public static final EnumC9334Zm2 a = new EnumC9334Zm2("TOP_DOWN", 0);
    public static final EnumC9334Zm2 b = new EnumC9334Zm2("BOTTOM_UP", 1);
    private static final /* synthetic */ EnumC9334Zm2[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC9334Zm2[] enumC9334Zm2ArrA = a();
        c = enumC9334Zm2ArrA;
        d = G92.a(enumC9334Zm2ArrA);
    }

    private EnumC9334Zm2(String str, int i) {
    }

    private static final /* synthetic */ EnumC9334Zm2[] a() {
        return new EnumC9334Zm2[]{a, b};
    }

    public static EnumC9334Zm2 valueOf(String str) {
        return (EnumC9334Zm2) Enum.valueOf(EnumC9334Zm2.class, str);
    }

    public static EnumC9334Zm2[] values() {
        return (EnumC9334Zm2[]) c.clone();
    }
}
