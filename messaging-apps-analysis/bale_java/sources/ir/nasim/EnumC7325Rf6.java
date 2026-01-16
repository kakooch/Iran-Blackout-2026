package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Rf6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC7325Rf6 {
    public static final EnumC7325Rf6 a = new EnumC7325Rf6("PHOTOS", 0);
    public static final EnumC7325Rf6 b = new EnumC7325Rf6("VIDEOS", 1);
    public static final EnumC7325Rf6 c = new EnumC7325Rf6("DOCUMENTS", 2);
    public static final EnumC7325Rf6 d = new EnumC7325Rf6("AUDIOS", 3);
    public static final EnumC7325Rf6 e = new EnumC7325Rf6("VOICES", 4);
    private static final /* synthetic */ EnumC7325Rf6[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC7325Rf6[] enumC7325Rf6ArrA = a();
        f = enumC7325Rf6ArrA;
        g = G92.a(enumC7325Rf6ArrA);
    }

    private EnumC7325Rf6(String str, int i) {
    }

    private static final /* synthetic */ EnumC7325Rf6[] a() {
        return new EnumC7325Rf6[]{a, b, c, d, e};
    }

    public static EnumC7325Rf6 valueOf(String str) {
        return (EnumC7325Rf6) Enum.valueOf(EnumC7325Rf6.class, str);
    }

    public static EnumC7325Rf6[] values() {
        return (EnumC7325Rf6[]) f.clone();
    }
}
