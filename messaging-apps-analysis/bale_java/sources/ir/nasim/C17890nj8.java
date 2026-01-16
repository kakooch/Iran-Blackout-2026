package ir.nasim;

/* renamed from: ir.nasim.nj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17890nj8 {
    private final Object b = new Object();
    private long c = Long.MIN_VALUE;
    private final long a = Math.round(30000.0d);

    public C17890nj8(double d) {
    }

    public final boolean a() {
        synchronized (this.b) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.c + this.a > jCurrentTimeMillis) {
                    return false;
                }
                this.c = jCurrentTimeMillis;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
