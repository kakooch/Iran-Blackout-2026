package ir.nasim;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

/* renamed from: ir.nasim.Bt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C3645Bt {
    public static final ThreadLocal g = new ThreadLocal();
    private c d;
    private final C24792zC6 a = new C24792zC6();
    final ArrayList b = new ArrayList();
    private final a c = new a();
    long e = 0;
    private boolean f = false;

    /* renamed from: ir.nasim.Bt$a */
    class a {
        a() {
        }

        void a() {
            C3645Bt.this.e = SystemClock.uptimeMillis();
            C3645Bt c3645Bt = C3645Bt.this;
            c3645Bt.c(c3645Bt.e);
            if (C3645Bt.this.b.size() > 0) {
                C3645Bt.this.e().a();
            }
        }
    }

    /* renamed from: ir.nasim.Bt$b */
    interface b {
        boolean a(long j);
    }

    /* renamed from: ir.nasim.Bt$c */
    static abstract class c {
        final a a;

        c(a aVar) {
            this.a = aVar;
        }

        abstract void a();
    }

    /* renamed from: ir.nasim.Bt$d */
    private static class d extends c {
        private final Choreographer b;
        private final Choreographer.FrameCallback c;

        /* renamed from: ir.nasim.Bt$d$a */
        class a implements Choreographer.FrameCallback {
            a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                d.this.a.a();
            }
        }

        d(a aVar) {
            super(aVar);
            this.b = Choreographer.getInstance();
            this.c = new a();
        }

        @Override // ir.nasim.C3645Bt.c
        void a() {
            this.b.postFrameCallback(this.c);
        }
    }

    C3645Bt() {
    }

    private void b() {
        if (this.f) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size) == null) {
                    this.b.remove(size);
                }
            }
            this.f = false;
        }
    }

    public static C3645Bt d() {
        ThreadLocal threadLocal = g;
        if (threadLocal.get() == null) {
            threadLocal.set(new C3645Bt());
        }
        return (C3645Bt) threadLocal.get();
    }

    private boolean f(b bVar, long j) {
        Long l = (Long) this.a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j) {
        if (this.b.size() == 0) {
            e().a();
        }
        if (!this.b.contains(bVar)) {
            this.b.add(bVar);
        }
        if (j > 0) {
            this.a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    void c(long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.b.size(); i++) {
            b bVar = (b) this.b.get(i);
            if (bVar != null && f(bVar, jUptimeMillis)) {
                bVar.a(j);
            }
        }
        b();
    }

    c e() {
        if (this.d == null) {
            this.d = new d(this.c);
        }
        return this.d;
    }

    public void g(b bVar) {
        this.a.remove(bVar);
        int iIndexOf = this.b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.b.set(iIndexOf, null);
            this.f = true;
        }
    }
}
