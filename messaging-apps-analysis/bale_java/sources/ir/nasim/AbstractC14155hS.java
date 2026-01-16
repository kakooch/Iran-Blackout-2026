package ir.nasim;

/* renamed from: ir.nasim.hS, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14155hS {
    public static final void a(AutoCloseable autoCloseable, Throwable th) throws Exception {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                AbstractC16632lc2.a(th, th2);
            }
        }
    }
}
