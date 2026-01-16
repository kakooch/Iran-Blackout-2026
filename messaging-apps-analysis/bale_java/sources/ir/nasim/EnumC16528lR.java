package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lR, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC16528lR {
    public static final EnumC16528lR b = new EnumC16528lR("MONEY_REQUEST", 0, 1);
    public static final EnumC16528lR c = new EnumC16528lR("BOT_MESSAGE", 1, 2);
    public static final EnumC16528lR d = new EnumC16528lR("WEB_APP", 2, 3);
    public static final EnumC16528lR e = new EnumC16528lR("INLINE_BUTTON", 3, 4);
    private static final /* synthetic */ EnumC16528lR[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC16528lR[] enumC16528lRArrA = a();
        f = enumC16528lRArrA;
        g = G92.a(enumC16528lRArrA);
    }

    private EnumC16528lR(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC16528lR[] a() {
        return new EnumC16528lR[]{b, c, d, e};
    }

    public static EnumC16528lR valueOf(String str) {
        return (EnumC16528lR) Enum.valueOf(EnumC16528lR.class, str);
    }

    public static EnumC16528lR[] values() {
        return (EnumC16528lR[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
