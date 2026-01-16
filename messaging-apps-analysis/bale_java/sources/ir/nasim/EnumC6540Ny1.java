package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Ny1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC6540Ny1 {
    public static final EnumC6540Ny1 c = new EnumC6540Ny1("MAIN", 0, "_main", "NASIM");
    public static final EnumC6540Ny1 d = new EnumC6540Ny1("DIALOG", 1, "_dialogs.db", "temp_testing_database");
    public static final EnumC6540Ny1 e = new EnumC6540Ny1("ROOM", 2, "_room", "ir_nasim");
    private static final /* synthetic */ EnumC6540Ny1[] f;
    private static final /* synthetic */ F92 g;
    private final String a;
    private final String b;

    static {
        EnumC6540Ny1[] enumC6540Ny1ArrA = a();
        f = enumC6540Ny1ArrA;
        g = G92.a(enumC6540Ny1ArrA);
    }

    private EnumC6540Ny1(String str, int i, String str2, String str3) {
        this.a = str2;
        this.b = str3;
    }

    private static final /* synthetic */ EnumC6540Ny1[] a() {
        return new EnumC6540Ny1[]{c, d, e};
    }

    public static EnumC6540Ny1 valueOf(String str) {
        return (EnumC6540Ny1) Enum.valueOf(EnumC6540Ny1.class, str);
    }

    public static EnumC6540Ny1[] values() {
        return (EnumC6540Ny1[]) f.clone();
    }

    public final String getValue() {
        return this.a;
    }

    public final String j() {
        return this.b;
    }
}
