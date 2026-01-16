package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.C18145o96;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.QG4;
import ir.nasim.TI;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class r {
    static final Object k = new Object();
    final Object a;
    private C18145o96 b;
    int c;
    private boolean d;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (r.this.a) {
                obj = r.this.f;
                r.this.f = r.k;
            }
            r.this.p(obj);
        }
    }

    private class b extends d {
        b(QG4 qg4) {
            super(qg4);
        }

        @Override // androidx.lifecycle.r.d
        boolean e() {
            return true;
        }
    }

    class c extends d implements n {
        final InterfaceC18633oz3 e;

        c(InterfaceC18633oz3 interfaceC18633oz3, QG4 qg4) {
            super(qg4);
            this.e = interfaceC18633oz3;
        }

        @Override // androidx.lifecycle.r.d
        void b() {
            this.e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.r.d
        boolean d(InterfaceC18633oz3 interfaceC18633oz3) {
            return this.e == interfaceC18633oz3;
        }

        @Override // androidx.lifecycle.r.d
        boolean e() {
            return this.e.getLifecycle().b().j(j.b.STARTED);
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            j.b bVarB = this.e.getLifecycle().b();
            if (bVarB == j.b.DESTROYED) {
                r.this.o(this.a);
                return;
            }
            j.b bVar = null;
            while (bVar != bVarB) {
                a(e());
                bVar = bVarB;
                bVarB = this.e.getLifecycle().b();
            }
        }
    }

    private abstract class d {
        final QG4 a;
        boolean b;
        int c = -1;

        d(QG4 qg4) {
            this.a = qg4;
        }

        void a(boolean z) {
            if (z == this.b) {
                return;
            }
            this.b = z;
            r.this.c(z ? 1 : -1);
            if (this.b) {
                r.this.e(this);
            }
        }

        void b() {
        }

        boolean d(InterfaceC18633oz3 interfaceC18633oz3) {
            return false;
        }

        abstract boolean e();
    }

    public r(Object obj) {
        this.a = new Object();
        this.b = new C18145o96();
        this.c = 0;
        this.f = k;
        this.j = new a();
        this.e = obj;
        this.g = 0;
    }

    static void b(String str) {
        if (TI.g().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(d dVar) {
        if (dVar.b) {
            if (!dVar.e()) {
                dVar.a(false);
                return;
            }
            int i = dVar.c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            dVar.c = i2;
            dVar.a.a(this.e);
        }
    }

    void c(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i3 = this.c;
                if (i2 == i3) {
                    this.d = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    l();
                } else if (z2) {
                    m();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }
    }

    void e(d dVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (dVar != null) {
                d(dVar);
                dVar = null;
            } else {
                C18145o96.d dVarI = this.b.i();
                while (dVarI.hasNext()) {
                    d((d) ((Map.Entry) dVarI.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object f() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    int g() {
        return this.g;
    }

    public boolean h() {
        return this.c > 0;
    }

    public boolean i() {
        return this.e != k;
    }

    public void j(InterfaceC18633oz3 interfaceC18633oz3, QG4 qg4) {
        b("observe");
        if (interfaceC18633oz3.getLifecycle().b() == j.b.DESTROYED) {
            return;
        }
        c cVar = new c(interfaceC18633oz3, qg4);
        d dVar = (d) this.b.r(qg4, cVar);
        if (dVar != null && !dVar.d(interfaceC18633oz3)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        interfaceC18633oz3.getLifecycle().a(cVar);
    }

    public void k(QG4 qg4) {
        b("observeForever");
        b bVar = new b(qg4);
        d dVar = (d) this.b.r(qg4, bVar);
        if (dVar instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (dVar != null) {
            return;
        }
        bVar.a(true);
    }

    protected void l() {
    }

    protected void m() {
    }

    protected void n(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            TI.g().c(this.j);
        }
    }

    public void o(QG4 qg4) {
        b("removeObserver");
        d dVar = (d) this.b.t(qg4);
        if (dVar == null) {
            return;
        }
        dVar.b();
        dVar.a(false);
    }

    protected void p(Object obj) {
        b("setValue");
        this.g++;
        this.e = obj;
        e(null);
    }

    public r() {
        this.a = new Object();
        this.b = new C18145o96();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }
}
