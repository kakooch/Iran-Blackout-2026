package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Yk2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC9082Yk2 {
    public static final EnumC9082Yk2 b = new EnumC9082Yk2("PHOTO", 0, "photos");
    public static final EnumC9082Yk2 c = new EnumC9082Yk2("VIDEO", 1, "videos");
    public static final EnumC9082Yk2 d = new EnumC9082Yk2("DOCUMENT", 2, "documents");
    public static final EnumC9082Yk2 e = new EnumC9082Yk2("AUDIO", 3, "audios");
    public static final EnumC9082Yk2 f = new EnumC9082Yk2("AVATAR", 4, "avatars");
    public static final EnumC9082Yk2 g = new EnumC9082Yk2("STORY", 5, "stories");
    public static final EnumC9082Yk2 h = new EnumC9082Yk2("OTHER", 6, "others");
    private static final /* synthetic */ EnumC9082Yk2[] i;
    private static final /* synthetic */ F92 j;
    private final String a;

    static {
        EnumC9082Yk2[] enumC9082Yk2ArrA = a();
        i = enumC9082Yk2ArrA;
        j = G92.a(enumC9082Yk2ArrA);
    }

    private EnumC9082Yk2(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC9082Yk2[] a() {
        return new EnumC9082Yk2[]{b, c, d, e, f, g, h};
    }

    public static EnumC9082Yk2 valueOf(String str) {
        return (EnumC9082Yk2) Enum.valueOf(EnumC9082Yk2.class, str);
    }

    public static EnumC9082Yk2[] values() {
        return (EnumC9082Yk2[]) i.clone();
    }

    public final String j() {
        return this.a;
    }
}
