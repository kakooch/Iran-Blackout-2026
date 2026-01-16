package ir.nasim;

/* renamed from: ir.nasim.go8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC13785go8 implements Runnable {
    final /* synthetic */ No8 a;

    RunnableC13785go8(No8 no8) {
        this.a = no8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.b) {
            try {
                No8 no8 = this.a;
                if (no8.c != null) {
                    no8.c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
