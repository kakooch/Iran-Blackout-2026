package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC18627oy6 {
    public static final EnumC18627oy6 a = new EnumC18627oy6("DOCUMENT_AUDIO", 0);
    public static final EnumC18627oy6 b = new EnumC18627oy6("DOCUMENT_VIDEO", 1);
    public static final EnumC18627oy6 c = new EnumC18627oy6("DOCUMENT_PHOTO", 2);
    public static final EnumC18627oy6 d = new EnumC18627oy6("DOCUMENT", 3);
    public static final EnumC18627oy6 e = new EnumC18627oy6("DOCUMENT_VOICE", 4);
    public static final EnumC18627oy6 f = new EnumC18627oy6("UNKNOWN", 5);
    private static final /* synthetic */ EnumC18627oy6[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC18627oy6[] enumC18627oy6ArrA = a();
        g = enumC18627oy6ArrA;
        h = G92.a(enumC18627oy6ArrA);
    }

    private EnumC18627oy6(String str, int i) {
    }

    private static final /* synthetic */ EnumC18627oy6[] a() {
        return new EnumC18627oy6[]{a, b, c, d, e, f};
    }

    public static EnumC18627oy6 valueOf(String str) {
        return (EnumC18627oy6) Enum.valueOf(EnumC18627oy6.class, str);
    }

    public static EnumC18627oy6[] values() {
        return (EnumC18627oy6[]) g.clone();
    }
}
