package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.uz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC22288uz0 {
    public static final EnumC22288uz0 a = new EnumC22288uz0("CHAT_ACTION_BAR_ICON", 0);
    public static final EnumC22288uz0 b = new EnumC22288uz0("CHAT_MENU", 1);
    public static final EnumC22288uz0 c = new EnumC22288uz0("CALL_BUBBLE", 2);
    public static final EnumC22288uz0 d = new EnumC22288uz0("CALL_BUBBLE_OPTIONS", 3);
    public static final EnumC22288uz0 e = new EnumC22288uz0("BALE_CONTACTS", 4);
    public static final EnumC22288uz0 f = new EnumC22288uz0("PHONE_CONTACTS", 5);
    private static final /* synthetic */ EnumC22288uz0[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC22288uz0[] enumC22288uz0ArrA = a();
        g = enumC22288uz0ArrA;
        h = G92.a(enumC22288uz0ArrA);
    }

    private EnumC22288uz0(String str, int i) {
    }

    private static final /* synthetic */ EnumC22288uz0[] a() {
        return new EnumC22288uz0[]{a, b, c, d, e, f};
    }

    public static EnumC22288uz0 valueOf(String str) {
        return (EnumC22288uz0) Enum.valueOf(EnumC22288uz0.class, str);
    }

    public static EnumC22288uz0[] values() {
        return (EnumC22288uz0[]) g.clone();
    }
}
