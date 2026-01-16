package ir.nasim;

/* renamed from: ir.nasim.cp7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11333cp7 {
    private Throwable a;
    private final Object b = new Object();

    public final void a(Throwable th) {
        synchronized (this.b) {
            this.a = th;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void b() {
        synchronized (this.b) {
            Throwable th = this.a;
            if (th != null) {
                this.a = null;
                throw th;
            }
        }
    }
}
