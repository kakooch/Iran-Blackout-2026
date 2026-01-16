package ir.nasim;

/* loaded from: classes2.dex */
public abstract class QM7 {
    private static QM7 a;

    public static QM7 a() {
        if (a == null) {
            a = new RM7();
        }
        return a;
    }
}
