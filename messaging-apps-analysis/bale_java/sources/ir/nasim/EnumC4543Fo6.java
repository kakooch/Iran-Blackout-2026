package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Fo6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC4543Fo6 {
    public static final EnumC4543Fo6 a = new EnumC4543Fo6("UNKNOWN", 0);
    public static final EnumC4543Fo6 b = new EnumC4543Fo6("PHOTO", 1);
    public static final EnumC4543Fo6 c = new EnumC4543Fo6("VIDEO", 2);
    public static final EnumC4543Fo6 d = new EnumC4543Fo6("VOICE", 3);
    public static final EnumC4543Fo6 e = new EnumC4543Fo6("AUDIO", 4);
    public static final EnumC4543Fo6 f = new EnumC4543Fo6("DOCUMENT", 5);
    private static final /* synthetic */ EnumC4543Fo6[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC4543Fo6[] enumC4543Fo6ArrA = a();
        g = enumC4543Fo6ArrA;
        h = G92.a(enumC4543Fo6ArrA);
    }

    private EnumC4543Fo6(String str, int i) {
    }

    private static final /* synthetic */ EnumC4543Fo6[] a() {
        return new EnumC4543Fo6[]{a, b, c, d, e, f};
    }

    public static EnumC4543Fo6 valueOf(String str) {
        return (EnumC4543Fo6) Enum.valueOf(EnumC4543Fo6.class, str);
    }

    public static EnumC4543Fo6[] values() {
        return (EnumC4543Fo6[]) g.clone();
    }
}
