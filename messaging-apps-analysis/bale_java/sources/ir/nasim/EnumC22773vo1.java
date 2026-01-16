package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.vo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC22773vo1 {
    public static final EnumC22773vo1 a = new EnumC22773vo1("COROUTINE_SUSPENDED", 0);
    public static final EnumC22773vo1 b = new EnumC22773vo1("UNDECIDED", 1);
    public static final EnumC22773vo1 c = new EnumC22773vo1("RESUMED", 2);
    private static final /* synthetic */ EnumC22773vo1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC22773vo1[] enumC22773vo1ArrA = a();
        d = enumC22773vo1ArrA;
        e = G92.a(enumC22773vo1ArrA);
    }

    private EnumC22773vo1(String str, int i) {
    }

    private static final /* synthetic */ EnumC22773vo1[] a() {
        return new EnumC22773vo1[]{a, b, c};
    }

    public static EnumC22773vo1 valueOf(String str) {
        return (EnumC22773vo1) Enum.valueOf(EnumC22773vo1.class, str);
    }

    public static EnumC22773vo1[] values() {
        return (EnumC22773vo1[]) d.clone();
    }
}
