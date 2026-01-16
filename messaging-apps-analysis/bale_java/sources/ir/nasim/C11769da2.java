package ir.nasim;

import ir.nasim.CQ5;

/* renamed from: ir.nasim.da2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11769da2 implements CQ5, RP5 {
    private final Object a;
    private final CQ5 b;
    private volatile RP5 c;
    private volatile RP5 d;
    private CQ5.a e;
    private CQ5.a f;

    public C11769da2(Object obj, CQ5 cq5) {
        CQ5.a aVar = CQ5.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.a = obj;
        this.b = cq5;
    }

    private boolean l(RP5 rp5) {
        CQ5.a aVar;
        CQ5.a aVar2 = this.e;
        CQ5.a aVar3 = CQ5.a.FAILED;
        return aVar2 != aVar3 ? rp5.equals(this.c) : rp5.equals(this.d) && ((aVar = this.f) == CQ5.a.SUCCESS || aVar == aVar3);
    }

    private boolean m() {
        CQ5 cq5 = this.b;
        return cq5 == null || cq5.d(this);
    }

    private boolean n() {
        CQ5 cq5 = this.b;
        return cq5 == null || cq5.f(this);
    }

    private boolean o() {
        CQ5 cq5 = this.b;
        return cq5 == null || cq5.c(this);
    }

    @Override // ir.nasim.CQ5, ir.nasim.RP5
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.c.a() || this.d.a();
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public void b(RP5 rp5) {
        synchronized (this.a) {
            try {
                if (rp5.equals(this.c)) {
                    this.e = CQ5.a.SUCCESS;
                } else if (rp5.equals(this.d)) {
                    this.f = CQ5.a.SUCCESS;
                }
                CQ5 cq5 = this.b;
                if (cq5 != null) {
                    cq5.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.CQ5
    public boolean c(RP5 rp5) {
        boolean zO;
        synchronized (this.a) {
            zO = o();
        }
        return zO;
    }

    @Override // ir.nasim.RP5
    public void clear() {
        synchronized (this.a) {
            try {
                CQ5.a aVar = CQ5.a.CLEARED;
                this.e = aVar;
                this.c.clear();
                if (this.f != aVar) {
                    this.f = aVar;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.CQ5
    public boolean d(RP5 rp5) {
        boolean z;
        synchronized (this.a) {
            try {
                z = m() && rp5.equals(this.c);
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean e() {
        boolean z;
        synchronized (this.a) {
            try {
                CQ5.a aVar = this.e;
                CQ5.a aVar2 = CQ5.a.CLEARED;
                z = aVar == aVar2 && this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public boolean f(RP5 rp5) {
        boolean z;
        synchronized (this.a) {
            try {
                z = n() && l(rp5);
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean g() {
        boolean z;
        synchronized (this.a) {
            try {
                CQ5.a aVar = this.e;
                CQ5.a aVar2 = CQ5.a.SUCCESS;
                z = aVar == aVar2 || this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public CQ5 getRoot() {
        CQ5 root;
        synchronized (this.a) {
            try {
                CQ5 cq5 = this.b;
                root = cq5 != null ? cq5.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // ir.nasim.RP5
    public void h() {
        synchronized (this.a) {
            try {
                CQ5.a aVar = this.e;
                CQ5.a aVar2 = CQ5.a.RUNNING;
                if (aVar == aVar2) {
                    this.e = CQ5.a.PAUSED;
                    this.c.h();
                }
                if (this.f == aVar2) {
                    this.f = CQ5.a.PAUSED;
                    this.d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.RP5
    public void i() {
        synchronized (this.a) {
            try {
                CQ5.a aVar = this.e;
                CQ5.a aVar2 = CQ5.a.RUNNING;
                if (aVar != aVar2) {
                    this.e = aVar2;
                    this.c.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.RP5
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            try {
                CQ5.a aVar = this.e;
                CQ5.a aVar2 = CQ5.a.RUNNING;
                z = aVar == aVar2 || this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean j(RP5 rp5) {
        if (!(rp5 instanceof C11769da2)) {
            return false;
        }
        C11769da2 c11769da2 = (C11769da2) rp5;
        return this.c.j(c11769da2.c) && this.d.j(c11769da2.d);
    }

    @Override // ir.nasim.CQ5
    public void k(RP5 rp5) {
        synchronized (this.a) {
            try {
                if (rp5.equals(this.d)) {
                    this.f = CQ5.a.FAILED;
                    CQ5 cq5 = this.b;
                    if (cq5 != null) {
                        cq5.k(this);
                    }
                    return;
                }
                this.e = CQ5.a.FAILED;
                CQ5.a aVar = this.f;
                CQ5.a aVar2 = CQ5.a.RUNNING;
                if (aVar != aVar2) {
                    this.f = aVar2;
                    this.d.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p(RP5 rp5, RP5 rp52) {
        this.c = rp5;
        this.d = rp52;
    }
}
