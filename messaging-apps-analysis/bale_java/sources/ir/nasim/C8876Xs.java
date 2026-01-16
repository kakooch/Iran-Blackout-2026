package ir.nasim;

import java.util.concurrent.CountDownLatch;

/* renamed from: ir.nasim.Xs, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8876Xs implements InterfaceC23930xl2 {
    private CountDownLatch a;
    private AbstractC18106o57 b;
    private C24687z23 c;
    private Object d;
    private int e;
    private volatile boolean f;
    private final Object g = new Object();
    private boolean h;
    private int i;

    public C8876Xs(AbstractC18106o57 abstractC18106o57, C24687z23 c24687z23, Object obj, int i, boolean z, int i2) {
        this.b = abstractC18106o57;
        this.c = c24687z23;
        this.d = obj;
        this.e = i;
        this.h = z;
        this.i = i2;
        C4278El2.H(i).c0(this, this.b, this.c, this.d, 0L, this.h, i2);
    }

    private void b() {
        C4278El2.H(this.e).j(this.b);
        if (this.c != null) {
            C4278El2.H(this.e).m(this.c.f, "mp4");
        }
    }

    public void a(boolean z) {
        if (this.f) {
            return;
        }
        synchronized (this.g) {
            try {
                CountDownLatch countDownLatch = this.a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                    this.a = null;
                    if (z && !this.f && !this.h) {
                        C4278El2.H(this.e).d0(this.b, false, true);
                    }
                }
                Object obj = this.d;
                if (obj instanceof C10743c74) {
                    C10743c74 c10743c74 = (C10743c74) obj;
                    if (CX1.e(c10743c74.N).g(c10743c74.T())) {
                        z = false;
                    }
                }
                if (z) {
                    b();
                }
                this.f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC18106o57 c() {
        return this.b;
    }

    public C24687z23 d() {
        return this.c;
    }

    public Object e() {
        return this.b;
    }

    public boolean f() {
        return this.h;
    }

    public void g() {
        synchronized (this.g) {
            this.f = false;
        }
    }
}
