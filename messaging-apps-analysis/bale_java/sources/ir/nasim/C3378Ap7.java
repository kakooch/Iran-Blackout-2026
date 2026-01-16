package ir.nasim;

import ir.nasim.CQ5;

/* renamed from: ir.nasim.Ap7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3378Ap7 implements CQ5, RP5 {
    private final CQ5 a;
    private final Object b;
    private volatile RP5 c;
    private volatile RP5 d;
    private CQ5.a e;
    private CQ5.a f;
    private boolean g;

    public C3378Ap7(Object obj, CQ5 cq5) {
        CQ5.a aVar = CQ5.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.b = obj;
        this.a = cq5;
    }

    private boolean l() {
        CQ5 cq5 = this.a;
        return cq5 == null || cq5.d(this);
    }

    private boolean m() {
        CQ5 cq5 = this.a;
        return cq5 == null || cq5.f(this);
    }

    private boolean n() {
        CQ5 cq5 = this.a;
        return cq5 == null || cq5.c(this);
    }

    @Override // ir.nasim.CQ5, ir.nasim.RP5
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.a() || this.c.a();
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public void b(RP5 rp5) {
        synchronized (this.b) {
            try {
                if (rp5.equals(this.d)) {
                    this.f = CQ5.a.SUCCESS;
                    return;
                }
                this.e = CQ5.a.SUCCESS;
                CQ5 cq5 = this.a;
                if (cq5 != null) {
                    cq5.b(this);
                }
                if (!this.f.j()) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.CQ5
    public boolean c(RP5 rp5) {
        boolean z;
        synchronized (this.b) {
            try {
                z = n() && (rp5.equals(this.c) || this.e != CQ5.a.SUCCESS);
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            CQ5.a aVar = CQ5.a.CLEARED;
            this.e = aVar;
            this.f = aVar;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // ir.nasim.CQ5
    public boolean d(RP5 rp5) {
        boolean z;
        synchronized (this.b) {
            try {
                z = l() && rp5.equals(this.c) && this.e != CQ5.a.PAUSED;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == CQ5.a.CLEARED;
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public boolean f(RP5 rp5) {
        boolean z;
        synchronized (this.b) {
            try {
                z = m() && rp5.equals(this.c) && !a();
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean g() {
        boolean z;
        synchronized (this.b) {
            z = this.e == CQ5.a.SUCCESS;
        }
        return z;
    }

    @Override // ir.nasim.CQ5
    public CQ5 getRoot() {
        CQ5 root;
        synchronized (this.b) {
            try {
                CQ5 cq5 = this.a;
                root = cq5 != null ? cq5.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // ir.nasim.RP5
    public void h() {
        synchronized (this.b) {
            try {
                if (!this.f.j()) {
                    this.f = CQ5.a.PAUSED;
                    this.d.h();
                }
                if (!this.e.j()) {
                    this.e = CQ5.a.PAUSED;
                    this.c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.RP5
    public void i() {
        synchronized (this.b) {
            try {
                this.g = true;
                try {
                    if (this.e != CQ5.a.SUCCESS) {
                        CQ5.a aVar = this.f;
                        CQ5.a aVar2 = CQ5.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f = aVar2;
                            this.d.i();
                        }
                    }
                    if (this.g) {
                        CQ5.a aVar3 = this.e;
                        CQ5.a aVar4 = CQ5.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.e = aVar4;
                            this.c.i();
                        }
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ir.nasim.RP5
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == CQ5.a.RUNNING;
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean j(RP5 rp5) {
        if (!(rp5 instanceof C3378Ap7)) {
            return false;
        }
        C3378Ap7 c3378Ap7 = (C3378Ap7) rp5;
        if (this.c == null) {
            if (c3378Ap7.c != null) {
                return false;
            }
        } else if (!this.c.j(c3378Ap7.c)) {
            return false;
        }
        if (this.d == null) {
            if (c3378Ap7.d != null) {
                return false;
            }
        } else if (!this.d.j(c3378Ap7.d)) {
            return false;
        }
        return true;
    }

    @Override // ir.nasim.CQ5
    public void k(RP5 rp5) {
        synchronized (this.b) {
            try {
                if (!rp5.equals(this.c)) {
                    this.f = CQ5.a.FAILED;
                    return;
                }
                this.e = CQ5.a.FAILED;
                CQ5 cq5 = this.a;
                if (cq5 != null) {
                    cq5.k(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(RP5 rp5, RP5 rp52) {
        this.c = rp5;
        this.d = rp52;
    }
}
