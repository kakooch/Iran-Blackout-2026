package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Yh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9058Yh5 {
    public static final EnumC9058Yh5 a = new EnumC9058Yh5("MULTIPLE_CHOICE", 0);
    public static final EnumC9058Yh5 b = new EnumC9058Yh5("SINGLE_CHOICE", 1);
    private static final /* synthetic */ EnumC9058Yh5[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC9058Yh5[] enumC9058Yh5ArrA = a();
        c = enumC9058Yh5ArrA;
        d = G92.a(enumC9058Yh5ArrA);
    }

    private EnumC9058Yh5(String str, int i) {
    }

    private static final /* synthetic */ EnumC9058Yh5[] a() {
        return new EnumC9058Yh5[]{a, b};
    }

    public static EnumC9058Yh5 valueOf(String str) {
        return (EnumC9058Yh5) Enum.valueOf(EnumC9058Yh5.class, str);
    }

    public static EnumC9058Yh5[] values() {
        return (EnumC9058Yh5[]) c.clone();
    }
}
