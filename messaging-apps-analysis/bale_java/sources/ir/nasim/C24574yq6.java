package ir.nasim;

/* renamed from: ir.nasim.yq6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24574yq6 implements PG4, GV1 {
    final PG4 a;
    final boolean b;
    GV1 c;
    boolean d;
    C15238jF e;
    volatile boolean f;

    public C24574yq6(PG4 pg4) {
        this(pg4, false);
    }

    @Override // ir.nasim.PG4
    public void a(Throwable th) {
        if (this.f) {
            D76.d(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.f) {
                    if (this.d) {
                        this.f = true;
                        C15238jF c15238jF = this.e;
                        if (c15238jF == null) {
                            c15238jF = new C15238jF(4);
                            this.e = c15238jF;
                        }
                        Object objQ = EnumC24799zD4.q(th);
                        if (this.b) {
                            c15238jF.b(objQ);
                        } else {
                            c15238jF.d(objQ);
                        }
                        return;
                    }
                    this.f = true;
                    this.d = true;
                    z = false;
                }
                if (z) {
                    D76.d(th);
                } else {
                    this.a.a(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ir.nasim.PG4
    public void b(GV1 gv1) {
        if (OV1.s(this.c, gv1)) {
            this.c = gv1;
            this.a.b(this);
        }
    }

    @Override // ir.nasim.PG4
    public void c() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f) {
                    return;
                }
                if (!this.d) {
                    this.f = true;
                    this.d = true;
                    this.a.c();
                } else {
                    C15238jF c15238jF = this.e;
                    if (c15238jF == null) {
                        c15238jF = new C15238jF(4);
                        this.e = c15238jF;
                    }
                    c15238jF.b(EnumC24799zD4.p());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d() {
        C15238jF c15238jF;
        do {
            synchronized (this) {
                try {
                    c15238jF = this.e;
                    if (c15238jF == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!c15238jF.a(this.a));
    }

    @Override // ir.nasim.GV1
    public void dispose() {
        this.f = true;
        this.c.dispose();
    }

    @Override // ir.nasim.PG4
    public void e(Object obj) {
        if (this.f) {
            return;
        }
        if (obj == null) {
            this.c.dispose();
            a(AbstractC8226Vb2.a("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f) {
                    return;
                }
                if (!this.d) {
                    this.d = true;
                    this.a.e(obj);
                    d();
                } else {
                    C15238jF c15238jF = this.e;
                    if (c15238jF == null) {
                        c15238jF = new C15238jF(4);
                        this.e = c15238jF;
                    }
                    c15238jF.b(EnumC24799zD4.r(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C24574yq6(PG4 pg4, boolean z) {
        this.a = pg4;
        this.b = z;
    }
}
