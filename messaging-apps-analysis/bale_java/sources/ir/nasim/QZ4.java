package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class QZ4 {
    public static final QZ4 b = new QZ4("ERROR", 0, LD5.error_received_info_toast_message);
    private static final /* synthetic */ QZ4[] c;
    private static final /* synthetic */ F92 d;
    private final int a;

    static {
        QZ4[] qz4ArrA = a();
        c = qz4ArrA;
        d = G92.a(qz4ArrA);
    }

    private QZ4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ QZ4[] a() {
        return new QZ4[]{b};
    }

    public static QZ4 valueOf(String str) {
        return (QZ4) Enum.valueOf(QZ4.class, str);
    }

    public static QZ4[] values() {
        return (QZ4[]) c.clone();
    }

    public final int j() {
        return this.a;
    }
}
