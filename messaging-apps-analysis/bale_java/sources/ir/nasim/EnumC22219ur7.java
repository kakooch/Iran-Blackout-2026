package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ur7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC22219ur7 {
    public static final EnumC22219ur7 a = new EnumC22219ur7("On", 0);
    public static final EnumC22219ur7 b = new EnumC22219ur7("Off", 1);
    public static final EnumC22219ur7 c = new EnumC22219ur7("Indeterminate", 2);
    private static final /* synthetic */ EnumC22219ur7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC22219ur7[] enumC22219ur7ArrA = a();
        d = enumC22219ur7ArrA;
        e = G92.a(enumC22219ur7ArrA);
    }

    private EnumC22219ur7(String str, int i) {
    }

    private static final /* synthetic */ EnumC22219ur7[] a() {
        return new EnumC22219ur7[]{a, b, c};
    }

    public static EnumC22219ur7 valueOf(String str) {
        return (EnumC22219ur7) Enum.valueOf(EnumC22219ur7.class, str);
    }

    public static EnumC22219ur7[] values() {
        return (EnumC22219ur7[]) d.clone();
    }
}
