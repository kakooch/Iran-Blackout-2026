package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cT2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC10942cT2 {
    public static final EnumC10942cT2 a = new EnumC10942cT2("Cursor", 0);
    public static final EnumC10942cT2 b = new EnumC10942cT2("SelectionStart", 1);
    public static final EnumC10942cT2 c = new EnumC10942cT2("SelectionEnd", 2);
    private static final /* synthetic */ EnumC10942cT2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC10942cT2[] enumC10942cT2ArrA = a();
        d = enumC10942cT2ArrA;
        e = G92.a(enumC10942cT2ArrA);
    }

    private EnumC10942cT2(String str, int i) {
    }

    private static final /* synthetic */ EnumC10942cT2[] a() {
        return new EnumC10942cT2[]{a, b, c};
    }

    public static EnumC10942cT2 valueOf(String str) {
        return (EnumC10942cT2) Enum.valueOf(EnumC10942cT2.class, str);
    }

    public static EnumC10942cT2[] values() {
        return (EnumC10942cT2[]) d.clone();
    }
}
