package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ok0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC18483ok0 {
    public static final EnumC18483ok0 a = new EnumC18483ok0("Collapsed", 0);
    public static final EnumC18483ok0 b = new EnumC18483ok0("Expanded", 1);
    private static final /* synthetic */ EnumC18483ok0[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC18483ok0[] enumC18483ok0ArrA = a();
        c = enumC18483ok0ArrA;
        d = G92.a(enumC18483ok0ArrA);
    }

    private EnumC18483ok0(String str, int i) {
    }

    private static final /* synthetic */ EnumC18483ok0[] a() {
        return new EnumC18483ok0[]{a, b};
    }

    public static EnumC18483ok0 valueOf(String str) {
        return (EnumC18483ok0) Enum.valueOf(EnumC18483ok0.class, str);
    }

    public static EnumC18483ok0[] values() {
        return (EnumC18483ok0[]) c.clone();
    }
}
