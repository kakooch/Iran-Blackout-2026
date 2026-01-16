package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Lb, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC5838Lb {
    public static final EnumC5838Lb a = new EnumC5838Lb("NONE", 0);
    public static final EnumC5838Lb b = new EnumC5838Lb("CLICK_ON_AD", 1);
    public static final EnumC5838Lb c = new EnumC5838Lb("CLICK_ON_DIALOG", 2);
    private static final /* synthetic */ EnumC5838Lb[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC5838Lb[] enumC5838LbArrA = a();
        d = enumC5838LbArrA;
        e = G92.a(enumC5838LbArrA);
    }

    private EnumC5838Lb(String str, int i) {
    }

    private static final /* synthetic */ EnumC5838Lb[] a() {
        return new EnumC5838Lb[]{a, b, c};
    }

    public static EnumC5838Lb valueOf(String str) {
        return (EnumC5838Lb) Enum.valueOf(EnumC5838Lb.class, str);
    }

    public static EnumC5838Lb[] values() {
        return (EnumC5838Lb[]) d.clone();
    }
}
