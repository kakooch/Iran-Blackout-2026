package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nz1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC18040nz1 {
    public static final EnumC18040nz1 a = new EnumC18040nz1("RELIABLE", 0);
    public static final EnumC18040nz1 b = new EnumC18040nz1("LOSSY", 1);
    private static final /* synthetic */ EnumC18040nz1[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC18040nz1[] enumC18040nz1ArrA = a();
        c = enumC18040nz1ArrA;
        d = G92.a(enumC18040nz1ArrA);
    }

    private EnumC18040nz1(String str, int i) {
    }

    private static final /* synthetic */ EnumC18040nz1[] a() {
        return new EnumC18040nz1[]{a, b};
    }

    public static EnumC18040nz1 valueOf(String str) {
        return (EnumC18040nz1) Enum.valueOf(EnumC18040nz1.class, str);
    }

    public static EnumC18040nz1[] values() {
        return (EnumC18040nz1[]) c.clone();
    }
}
