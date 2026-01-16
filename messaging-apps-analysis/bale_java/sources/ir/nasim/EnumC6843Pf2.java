package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Pf2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC6843Pf2 {
    public static final EnumC6843Pf2 b = new EnumC6843Pf2("EMPTY_STATE_DIALOG", 0, 0);
    public static final EnumC6843Pf2 c = new EnumC6843Pf2("EMPTY_STATE_CALL", 1, 1);
    public static final EnumC6843Pf2 d = new EnumC6843Pf2("DIALOG_FAB", 2, 2);
    public static final EnumC6843Pf2 e = new EnumC6843Pf2("CALL_FAB", 3, 3);
    private static final /* synthetic */ EnumC6843Pf2[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC6843Pf2[] enumC6843Pf2ArrA = a();
        f = enumC6843Pf2ArrA;
        g = G92.a(enumC6843Pf2ArrA);
    }

    private EnumC6843Pf2(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC6843Pf2[] a() {
        return new EnumC6843Pf2[]{b, c, d, e};
    }

    public static EnumC6843Pf2 valueOf(String str) {
        return (EnumC6843Pf2) Enum.valueOf(EnumC6843Pf2.class, str);
    }

    public static EnumC6843Pf2[] values() {
        return (EnumC6843Pf2[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
