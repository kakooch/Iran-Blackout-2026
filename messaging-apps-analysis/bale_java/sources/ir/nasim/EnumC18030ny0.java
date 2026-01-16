package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ny0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18030ny0 {
    public static final EnumC18030ny0 a = new EnumC18030ny0("JoinLink", 0);
    public static final EnumC18030ny0 b = new EnumC18030ny0("StartCall", 1);
    public static final EnumC18030ny0 c = new EnumC18030ny0("None", 2);
    private static final /* synthetic */ EnumC18030ny0[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC18030ny0[] enumC18030ny0ArrA = a();
        d = enumC18030ny0ArrA;
        e = G92.a(enumC18030ny0ArrA);
    }

    private EnumC18030ny0(String str, int i) {
    }

    private static final /* synthetic */ EnumC18030ny0[] a() {
        return new EnumC18030ny0[]{a, b, c};
    }

    public static EnumC18030ny0 valueOf(String str) {
        return (EnumC18030ny0) Enum.valueOf(EnumC18030ny0.class, str);
    }

    public static EnumC18030ny0[] values() {
        return (EnumC18030ny0[]) d.clone();
    }
}
