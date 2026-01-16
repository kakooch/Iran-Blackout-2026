package com.google.android.exoplayer2;

import ir.nasim.AbstractC20011rK;
import ir.nasim.InterfaceC22009uW3;
import ir.nasim.KJ6;
import ir.nasim.NV0;

/* renamed from: com.google.android.exoplayer2.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2033i implements InterfaceC22009uW3 {
    private final KJ6 a;
    private final a b;
    private D0 c;
    private InterfaceC22009uW3 d;
    private boolean e = true;
    private boolean f;

    /* renamed from: com.google.android.exoplayer2.i$a */
    public interface a {
        void B(y0 y0Var);
    }

    public C2033i(a aVar, NV0 nv0) {
        this.b = aVar;
        this.a = new KJ6(nv0);
    }

    private boolean f(boolean z) {
        D0 d0 = this.c;
        return d0 == null || d0.d() || (!this.c.h() && (z || this.c.j()));
    }

    private void j(boolean z) {
        if (f(z)) {
            this.e = true;
            if (this.f) {
                this.a.b();
                return;
            }
            return;
        }
        InterfaceC22009uW3 interfaceC22009uW3 = (InterfaceC22009uW3) AbstractC20011rK.e(this.d);
        long jY = interfaceC22009uW3.y();
        if (this.e) {
            if (jY < this.a.y()) {
                this.a.d();
                return;
            } else {
                this.e = false;
                if (this.f) {
                    this.a.b();
                }
            }
        }
        this.a.a(jY);
        y0 y0VarC = interfaceC22009uW3.c();
        if (y0VarC.equals(this.a.c())) {
            return;
        }
        this.a.e(y0VarC);
        this.b.B(y0VarC);
    }

    public void a(D0 d0) {
        if (d0 == this.c) {
            this.d = null;
            this.c = null;
            this.e = true;
        }
    }

    public void b(D0 d0) throws ExoPlaybackException {
        InterfaceC22009uW3 interfaceC22009uW3;
        InterfaceC22009uW3 interfaceC22009uW3E = d0.E();
        if (interfaceC22009uW3E == null || interfaceC22009uW3E == (interfaceC22009uW3 = this.d)) {
            return;
        }
        if (interfaceC22009uW3 != null) {
            throw ExoPlaybackException.m(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = interfaceC22009uW3E;
        this.c = d0;
        interfaceC22009uW3E.e(this.a.c());
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public y0 c() {
        InterfaceC22009uW3 interfaceC22009uW3 = this.d;
        return interfaceC22009uW3 != null ? interfaceC22009uW3.c() : this.a.c();
    }

    public void d(long j) {
        this.a.a(j);
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public void e(y0 y0Var) {
        InterfaceC22009uW3 interfaceC22009uW3 = this.d;
        if (interfaceC22009uW3 != null) {
            interfaceC22009uW3.e(y0Var);
            y0Var = this.d.c();
        }
        this.a.e(y0Var);
    }

    public void g() {
        this.f = true;
        this.a.b();
    }

    public void h() {
        this.f = false;
        this.a.d();
    }

    public long i(boolean z) {
        j(z);
        return y();
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public long y() {
        return this.e ? this.a.y() : ((InterfaceC22009uW3) AbstractC20011rK.e(this.d)).y();
    }
}
