package ir.nasim;

/* loaded from: classes3.dex */
abstract class Cm8 implements Runnable {
    final long a;
    final long b;
    final boolean c;
    final /* synthetic */ C15566jn8 d;

    Cm8(C15566jn8 c15566jn8, boolean z) {
        this.d = c15566jn8;
        this.a = c15566jn8.b.currentTimeMillis();
        this.b = c15566jn8.b.elapsedRealtime();
        this.c = z;
    }

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d.g) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            this.d.h(e, false, this.c);
            b();
        }
    }

    protected void b() {
    }
}
