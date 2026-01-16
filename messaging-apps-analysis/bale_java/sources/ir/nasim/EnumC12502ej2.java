package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ej2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC12502ej2 {
    public static final EnumC12502ej2 b = new EnumC12502ej2("UNKNOWN", 0, 0);
    public static final EnumC12502ej2 c = new EnumC12502ej2("TEXT", 1, 1);
    public static final EnumC12502ej2 d = new EnumC12502ej2("PHOTO", 2, 2);
    public static final EnumC12502ej2 e = new EnumC12502ej2("VIDEO", 3, 3);
    public static final EnumC12502ej2 f = new EnumC12502ej2("ALBUM", 4, 4);
    public static final EnumC12502ej2 g = new EnumC12502ej2("GIF", 5, 5);
    private static final /* synthetic */ EnumC12502ej2[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    static {
        EnumC12502ej2[] enumC12502ej2ArrA = a();
        h = enumC12502ej2ArrA;
        i = G92.a(enumC12502ej2ArrA);
    }

    private EnumC12502ej2(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC12502ej2[] a() {
        return new EnumC12502ej2[]{b, c, d, e, f, g};
    }

    public static EnumC12502ej2 valueOf(String str) {
        return (EnumC12502ej2) Enum.valueOf(EnumC12502ej2.class, str);
    }

    public static EnumC12502ej2[] values() {
        return (EnumC12502ej2[]) h.clone();
    }

    public final int j() {
        return this.a;
    }
}
