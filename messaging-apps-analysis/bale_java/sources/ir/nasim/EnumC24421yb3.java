package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yb3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC24421yb3 {
    public static final EnumC24421yb3 b = new EnumC24421yb3("INLINE_BUTTONS", 0, 1);
    public static final EnumC24421yb3 c = new EnumC24421yb3("KEYBOARD_MARKUP", 1, 2);
    public static final EnumC24421yb3 d = new EnumC24421yb3("MAIN_MENU", 2, 3);
    public static final EnumC24421yb3 e = new EnumC24421yb3("SEND_MESSAGE", 3, 4);
    private static final /* synthetic */ EnumC24421yb3[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC24421yb3[] enumC24421yb3ArrA = a();
        f = enumC24421yb3ArrA;
        g = G92.a(enumC24421yb3ArrA);
    }

    private EnumC24421yb3(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC24421yb3[] a() {
        return new EnumC24421yb3[]{b, c, d, e};
    }

    public static EnumC24421yb3 valueOf(String str) {
        return (EnumC24421yb3) Enum.valueOf(EnumC24421yb3.class, str);
    }

    public static EnumC24421yb3[] values() {
        return (EnumC24421yb3[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
