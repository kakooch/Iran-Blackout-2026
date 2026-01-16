package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Rd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC7306Rd5 {
    public static final EnumC7306Rd5 a = new EnumC7306Rd5("Pin", 0);
    public static final EnumC7306Rd5 b = new EnumC7306Rd5("UnPin", 1);
    public static final EnumC7306Rd5 c = new EnumC7306Rd5("None", 2);
    private static final /* synthetic */ EnumC7306Rd5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC7306Rd5[] enumC7306Rd5ArrA = a();
        d = enumC7306Rd5ArrA;
        e = G92.a(enumC7306Rd5ArrA);
    }

    private EnumC7306Rd5(String str, int i) {
    }

    private static final /* synthetic */ EnumC7306Rd5[] a() {
        return new EnumC7306Rd5[]{a, b, c};
    }

    public static EnumC7306Rd5 valueOf(String str) {
        return (EnumC7306Rd5) Enum.valueOf(EnumC7306Rd5.class, str);
    }

    public static EnumC7306Rd5[] values() {
        return (EnumC7306Rd5[]) d.clone();
    }
}
