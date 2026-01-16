package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Qj2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC7123Qj2 {
    public static final EnumC7123Qj2 e = new EnumC7123Qj2("VeryBad", 0, 1, AbstractC12217eE5.feedback_rate_1, BD5.feedback_rate_1_hint, BD5.feedback_emoji_rate_1);
    public static final EnumC7123Qj2 f = new EnumC7123Qj2("Bad", 1, 2, AbstractC12217eE5.feedback_rate_2, BD5.feedback_rate_2_hint, BD5.feedback_emoji_rate_2);
    public static final EnumC7123Qj2 g = new EnumC7123Qj2("Normal", 2, 3, AbstractC12217eE5.feedback_rate_3, BD5.feedback_rate_3_hint, BD5.feedback_emoji_rate_3);
    public static final EnumC7123Qj2 h = new EnumC7123Qj2("Good", 3, 4, AbstractC12217eE5.feedback_rate_4, BD5.feedback_rate_4_hint, BD5.feedback_emoji_rate_4);
    public static final EnumC7123Qj2 i = new EnumC7123Qj2("Excellent", 4, 5, AbstractC12217eE5.feedback_rate_5, BD5.feedback_rate_5_hint, BD5.feedback_emoji_rate_5);
    private static final /* synthetic */ EnumC7123Qj2[] j;
    private static final /* synthetic */ F92 k;
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    static {
        EnumC7123Qj2[] enumC7123Qj2ArrA = a();
        j = enumC7123Qj2ArrA;
        k = G92.a(enumC7123Qj2ArrA);
    }

    private EnumC7123Qj2(String str, int i2, int i3, int i4, int i5, int i6) {
        this.a = i3;
        this.b = i4;
        this.c = i5;
        this.d = i6;
    }

    private static final /* synthetic */ EnumC7123Qj2[] a() {
        return new EnumC7123Qj2[]{e, f, g, h, i};
    }

    public static EnumC7123Qj2 valueOf(String str) {
        return (EnumC7123Qj2) Enum.valueOf(EnumC7123Qj2.class, str);
    }

    public static EnumC7123Qj2[] values() {
        return (EnumC7123Qj2[]) j.clone();
    }

    public final int j() {
        return this.c;
    }

    public final int p() {
        return this.d;
    }

    public final int q() {
        return this.a;
    }

    public final int r() {
        return this.b;
    }
}
