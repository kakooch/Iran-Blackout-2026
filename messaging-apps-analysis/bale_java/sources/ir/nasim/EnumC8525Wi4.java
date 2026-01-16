package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Wi4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC8525Wi4 {
    public static final EnumC8525Wi4 a = new EnumC8525Wi4("WARNING", 0);
    public static final EnumC8525Wi4 b = new EnumC8525Wi4("ERROR", 1);
    public static final EnumC8525Wi4 c = new EnumC8525Wi4("FATAL", 2);
    private static final /* synthetic */ EnumC8525Wi4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC8525Wi4[] enumC8525Wi4ArrA = a();
        d = enumC8525Wi4ArrA;
        e = G92.a(enumC8525Wi4ArrA);
    }

    private EnumC8525Wi4(String str, int i) {
    }

    private static final /* synthetic */ EnumC8525Wi4[] a() {
        return new EnumC8525Wi4[]{a, b, c};
    }

    public static EnumC8525Wi4 valueOf(String str) {
        return (EnumC8525Wi4) Enum.valueOf(EnumC8525Wi4.class, str);
    }

    public static EnumC8525Wi4[] values() {
        return (EnumC8525Wi4[]) d.clone();
    }
}
