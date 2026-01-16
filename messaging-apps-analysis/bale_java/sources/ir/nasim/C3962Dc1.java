package ir.nasim;

/* renamed from: ir.nasim.Dc1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3962Dc1 {
    private final NV0 a;
    private boolean b;

    public C3962Dc1() {
        this(NV0.a);
    }

    public synchronized void a() {
        while (!this.b) {
            wait();
        }
    }

    public synchronized boolean b(long j) {
        if (j <= 0) {
            return this.b;
        }
        long jElapsedRealtime = this.a.elapsedRealtime();
        long j2 = j + jElapsedRealtime;
        if (j2 < jElapsedRealtime) {
            a();
        } else {
            while (!this.b && jElapsedRealtime < j2) {
                wait(j2 - jElapsedRealtime);
                jElapsedRealtime = this.a.elapsedRealtime();
            }
        }
        return this.b;
    }

    public synchronized void c() {
        boolean z = false;
        while (!this.b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z;
        z = this.b;
        this.b = false;
        return z;
    }

    public synchronized boolean e() {
        return this.b;
    }

    public synchronized boolean f() {
        if (this.b) {
            return false;
        }
        this.b = true;
        notifyAll();
        return true;
    }

    public C3962Dc1(NV0 nv0) {
        this.a = nv0;
    }
}
