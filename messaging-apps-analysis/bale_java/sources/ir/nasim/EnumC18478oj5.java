package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oj5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC18478oj5 {
    public static final EnumC18478oj5 a = new EnumC18478oj5("EXACT", 0);
    public static final EnumC18478oj5 b = new EnumC18478oj5("INEXACT", 1);
    public static final EnumC18478oj5 c = new EnumC18478oj5("AUTOMATIC", 2);
    private static final /* synthetic */ EnumC18478oj5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC18478oj5[] enumC18478oj5ArrA = a();
        d = enumC18478oj5ArrA;
        e = G92.a(enumC18478oj5ArrA);
    }

    private EnumC18478oj5(String str, int i) {
    }

    private static final /* synthetic */ EnumC18478oj5[] a() {
        return new EnumC18478oj5[]{a, b, c};
    }

    public static EnumC18478oj5 valueOf(String str) {
        return (EnumC18478oj5) Enum.valueOf(EnumC18478oj5.class, str);
    }

    public static EnumC18478oj5[] values() {
        return (EnumC18478oj5[]) d.clone();
    }
}
