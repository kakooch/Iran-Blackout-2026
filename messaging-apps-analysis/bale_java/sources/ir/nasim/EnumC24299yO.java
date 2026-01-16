package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yO, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC24299yO {
    public static final EnumC24299yO b = new EnumC24299yO("TELEPHONE", 0, 12000);
    public static final EnumC24299yO c = new EnumC24299yO("SPEECH", 1, 24000);
    public static final EnumC24299yO d = new EnumC24299yO("MUSIC", 2, 48000);
    public static final EnumC24299yO e = new EnumC24299yO("MUSIC_STEREO", 3, 64000);
    public static final EnumC24299yO f = new EnumC24299yO("MUSIC_HIGH_QUALITY", 4, 96000);
    public static final EnumC24299yO g = new EnumC24299yO("MUSIC_HIGH_QUALITY_STEREO", 5, 128000);
    private static final /* synthetic */ EnumC24299yO[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    static {
        EnumC24299yO[] enumC24299yOArrA = a();
        h = enumC24299yOArrA;
        i = G92.a(enumC24299yOArrA);
    }

    private EnumC24299yO(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC24299yO[] a() {
        return new EnumC24299yO[]{b, c, d, e, f, g};
    }

    public static EnumC24299yO valueOf(String str) {
        return (EnumC24299yO) Enum.valueOf(EnumC24299yO.class, str);
    }

    public static EnumC24299yO[] values() {
        return (EnumC24299yO[]) h.clone();
    }

    public final int j() {
        return this.a;
    }
}
