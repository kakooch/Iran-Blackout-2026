package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wX4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC23205wX4 {
    public static final EnumC23205wX4 b = new EnumC23205wX4("OPEN_PASSPORT", 0, 1);
    public static final EnumC23205wX4 c = new EnumC23205wX4("SUBMIT_TO_BOT", 1, 2);
    public static final EnumC23205wX4 d = new EnumC23205wX4("SUBMIT_TO_SETTING", 2, 3);
    public static final EnumC23205wX4 e = new EnumC23205wX4("CLOSE", 3, 4);
    public static final EnumC23205wX4 f = new EnumC23205wX4("DELETE_PASSPORT", 4, 5);
    private static final /* synthetic */ EnumC23205wX4[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    static {
        EnumC23205wX4[] enumC23205wX4ArrA = a();
        g = enumC23205wX4ArrA;
        h = G92.a(enumC23205wX4ArrA);
    }

    private EnumC23205wX4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC23205wX4[] a() {
        return new EnumC23205wX4[]{b, c, d, e, f};
    }

    public static EnumC23205wX4 valueOf(String str) {
        return (EnumC23205wX4) Enum.valueOf(EnumC23205wX4.class, str);
    }

    public static EnumC23205wX4[] values() {
        return (EnumC23205wX4[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
