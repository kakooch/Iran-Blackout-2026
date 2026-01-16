package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Dg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC4002Dg5 {
    public static final EnumC4002Dg5 a = new EnumC4002Dg5("Initial", 0);
    public static final EnumC4002Dg5 b = new EnumC4002Dg5("Main", 1);
    public static final EnumC4002Dg5 c = new EnumC4002Dg5("Final", 2);
    private static final /* synthetic */ EnumC4002Dg5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4002Dg5[] enumC4002Dg5ArrA = a();
        d = enumC4002Dg5ArrA;
        e = G92.a(enumC4002Dg5ArrA);
    }

    private EnumC4002Dg5(String str, int i) {
    }

    private static final /* synthetic */ EnumC4002Dg5[] a() {
        return new EnumC4002Dg5[]{a, b, c};
    }

    public static EnumC4002Dg5 valueOf(String str) {
        return (EnumC4002Dg5) Enum.valueOf(EnumC4002Dg5.class, str);
    }

    public static EnumC4002Dg5[] values() {
        return (EnumC4002Dg5[]) d.clone();
    }
}
