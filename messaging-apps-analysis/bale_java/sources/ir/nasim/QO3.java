package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class QO3 {
    public static final QO3 a = new QO3("UNKNOWN", 0);
    public static final QO3 b = new QO3("URL", 1);
    public static final QO3 c = new QO3("PEER", 2);
    public static final QO3 d = new QO3("MESSAGE_URL", 3);
    private static final /* synthetic */ QO3[] e;
    private static final /* synthetic */ F92 f;

    static {
        QO3[] qo3ArrA = a();
        e = qo3ArrA;
        f = G92.a(qo3ArrA);
    }

    private QO3(String str, int i) {
    }

    private static final /* synthetic */ QO3[] a() {
        return new QO3[]{a, b, c, d};
    }

    public static QO3 valueOf(String str) {
        return (QO3) Enum.valueOf(QO3.class, str);
    }

    public static QO3[] values() {
        return (QO3[]) e.clone();
    }
}
