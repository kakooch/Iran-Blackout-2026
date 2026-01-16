package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ur4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC22216ur4 {
    public static final EnumC22216ur4 b = new EnumC22216ur4("WIFI", 0, "wifi");
    public static final EnumC22216ur4 c = new EnumC22216ur4("ETHERNET", 1, "ethernet");
    public static final EnumC22216ur4 d = new EnumC22216ur4("CELLULAR", 2, "cellular");
    public static final EnumC22216ur4 e = new EnumC22216ur4("VPN", 3, "vpn");
    public static final EnumC22216ur4 f = new EnumC22216ur4("BLUETOOTH", 4, "bluetooth");
    public static final EnumC22216ur4 g = new EnumC22216ur4("OTHER", 5, "other");
    public static final EnumC22216ur4 h = new EnumC22216ur4("UNKNOWN", 6, "");
    private static final /* synthetic */ EnumC22216ur4[] i;
    private static final /* synthetic */ F92 j;
    private final String a;

    static {
        EnumC22216ur4[] enumC22216ur4ArrA = a();
        i = enumC22216ur4ArrA;
        j = G92.a(enumC22216ur4ArrA);
    }

    private EnumC22216ur4(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC22216ur4[] a() {
        return new EnumC22216ur4[]{b, c, d, e, f, g, h};
    }

    public static EnumC22216ur4 valueOf(String str) {
        return (EnumC22216ur4) Enum.valueOf(EnumC22216ur4.class, str);
    }

    public static EnumC22216ur4[] values() {
        return (EnumC22216ur4[]) i.clone();
    }

    public final String j() {
        return this.a;
    }
}
