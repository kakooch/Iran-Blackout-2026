package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.iq4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC15002iq4 {
    public static final EnumC15002iq4 b = new EnumC15002iq4("CHAT", 0, 0);
    public static final EnumC15002iq4 c = new EnumC15002iq4("JARYAN", 1, 3);
    public static final EnumC15002iq4 d = new EnumC15002iq4("KHADAMAT", 2, 2);
    private static final /* synthetic */ EnumC15002iq4[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC15002iq4[] enumC15002iq4ArrA = a();
        e = enumC15002iq4ArrA;
        f = G92.a(enumC15002iq4ArrA);
    }

    private EnumC15002iq4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC15002iq4[] a() {
        return new EnumC15002iq4[]{b, c, d};
    }

    public static EnumC15002iq4 valueOf(String str) {
        return (EnumC15002iq4) Enum.valueOf(EnumC15002iq4.class, str);
    }

    public static EnumC15002iq4[] values() {
        return (EnumC15002iq4[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
