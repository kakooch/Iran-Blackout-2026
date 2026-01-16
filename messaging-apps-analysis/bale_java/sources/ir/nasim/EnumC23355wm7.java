package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC23355wm7 {
    public static final EnumC23355wm7 a = new EnumC23355wm7("Filled", 0);
    public static final EnumC23355wm7 b = new EnumC23355wm7("Outlined", 1);
    private static final /* synthetic */ EnumC23355wm7[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC23355wm7[] enumC23355wm7ArrA = a();
        c = enumC23355wm7ArrA;
        d = G92.a(enumC23355wm7ArrA);
    }

    private EnumC23355wm7(String str, int i) {
    }

    private static final /* synthetic */ EnumC23355wm7[] a() {
        return new EnumC23355wm7[]{a, b};
    }

    public static EnumC23355wm7 valueOf(String str) {
        return (EnumC23355wm7) Enum.valueOf(EnumC23355wm7.class, str);
    }

    public static EnumC23355wm7[] values() {
        return (EnumC23355wm7[]) c.clone();
    }
}
