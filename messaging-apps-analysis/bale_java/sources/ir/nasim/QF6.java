package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class QF6 {
    public static final QF6 b = new QF6("Emoji", 0, KB5.icon_emoji);
    public static final QF6 c = new QF6("Sticker", 1, KB5.smiles_sticker);
    public static final QF6 d = new QF6("Gif", 2, KB5.smiles_gif);
    private static final /* synthetic */ QF6[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        QF6[] qf6ArrA = a();
        e = qf6ArrA;
        f = G92.a(qf6ArrA);
    }

    private QF6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ QF6[] a() {
        return new QF6[]{b, c, d};
    }

    public static QF6 valueOf(String str) {
        return (QF6) Enum.valueOf(QF6.class, str);
    }

    public static QF6[] values() {
        return (QF6[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
