package androidx.compose.ui.graphics;

import ir.nasim.AbstractC10274bN4;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23676xK2;
import ir.nasim.C24381yX0;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.MK5;
import ir.nasim.OD6;
import ir.nasim.ON5;
import ir.nasim.WH1;
import ir.nasim.YH1;

/* loaded from: classes2.dex */
public final class d implements c {
    private int a;
    private float e;
    private float f;
    private float g;
    private float j;
    private float k;
    private float l;
    private boolean p;
    private AbstractC10274bN4 u;
    private float b = 1.0f;
    private float c = 1.0f;
    private float d = 1.0f;
    private long h = AbstractC23676xK2.a();
    private long i = AbstractC23676xK2.a();
    private float m = 8.0f;
    private long n = f.b.a();
    private InterfaceC10031ax6 o = MK5.a();
    private int q = a.a.a();
    private long r = OD6.b.a();
    private WH1 s = YH1.b(1.0f, 0.0f, 2, null);
    private EnumC12613eu3 t = EnumC12613eu3.a;

    @Override // androidx.compose.ui.graphics.c
    public float A() {
        return this.b;
    }

    @Override // androidx.compose.ui.graphics.c
    public void B(float f) {
        if (this.g == f) {
            return;
        }
        this.a |= 32;
        this.g = f;
    }

    public final AbstractC10274bN4 C() {
        return this.u;
    }

    @Override // androidx.compose.ui.graphics.c
    public void C0(long j) {
        if (f.e(this.n, j)) {
            return;
        }
        this.a |= 4096;
        this.n = j;
    }

    public ON5 E() {
        return null;
    }

    public float F() {
        return this.g;
    }

    @Override // androidx.compose.ui.graphics.c
    public float G() {
        return this.f;
    }

    @Override // androidx.compose.ui.graphics.c
    public float H() {
        return this.e;
    }

    @Override // androidx.compose.ui.graphics.c
    public float I() {
        return this.j;
    }

    public InterfaceC10031ax6 J() {
        return this.o;
    }

    @Override // androidx.compose.ui.graphics.c
    public float K() {
        return this.c;
    }

    public long M() {
        return this.i;
    }

    public final void N() {
        g(1.0f);
        m(1.0f);
        c(1.0f);
        n(0.0f);
        e(0.0f);
        B(0.0f);
        v(AbstractC23676xK2.a());
        y(AbstractC23676xK2.a());
        j(0.0f);
        k(0.0f);
        l(0.0f);
        i(8.0f);
        C0(f.b.a());
        V(MK5.a());
        x(false);
        f(null);
        q(a.a.a());
        S(OD6.b.a());
        this.u = null;
        this.a = 0;
    }

    public final void O(WH1 wh1) {
        this.s = wh1;
    }

    public final void P(EnumC12613eu3 enumC12613eu3) {
        this.t = enumC12613eu3;
    }

    public void S(long j) {
        this.r = j;
    }

    @Override // androidx.compose.ui.graphics.c
    public void V(InterfaceC10031ax6 interfaceC10031ax6) {
        if (AbstractC13042fc3.d(this.o, interfaceC10031ax6)) {
            return;
        }
        this.a |= 8192;
        this.o = interfaceC10031ax6;
    }

    public final void W() {
        this.u = J().a(d(), this.t, this.s);
    }

    public float b() {
        return this.d;
    }

    @Override // androidx.compose.ui.graphics.c
    public void c(float f) {
        if (this.d == f) {
            return;
        }
        this.a |= 4;
        this.d = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public long d() {
        return this.r;
    }

    @Override // androidx.compose.ui.graphics.c
    public void e(float f) {
        if (this.f == f) {
            return;
        }
        this.a |= 16;
        this.f = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void f(ON5 on5) {
        if (AbstractC13042fc3.d(null, on5)) {
            return;
        }
        this.a |= 131072;
    }

    @Override // androidx.compose.ui.graphics.c
    public void g(float f) {
        if (this.b == f) {
            return;
        }
        this.a |= 1;
        this.b = f;
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.s.getDensity();
    }

    public long h() {
        return this.h;
    }

    @Override // androidx.compose.ui.graphics.c
    public void i(float f) {
        if (this.m == f) {
            return;
        }
        this.a |= 2048;
        this.m = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void j(float f) {
        if (this.j == f) {
            return;
        }
        this.a |= 256;
        this.j = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void k(float f) {
        if (this.k == f) {
            return;
        }
        this.a |= 512;
        this.k = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void l(float f) {
        if (this.l == f) {
            return;
        }
        this.a |= 1024;
        this.l = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void m(float f) {
        if (this.c == f) {
            return;
        }
        this.a |= 2;
        this.c = f;
    }

    @Override // androidx.compose.ui.graphics.c
    public void n(float f) {
        if (this.e == f) {
            return;
        }
        this.a |= 8;
        this.e = f;
    }

    public boolean o() {
        return this.p;
    }

    public int p() {
        return this.q;
    }

    @Override // androidx.compose.ui.graphics.c
    public void q(int i) {
        if (a.e(this.q, i)) {
            return;
        }
        this.a |= 32768;
        this.q = i;
    }

    @Override // androidx.compose.ui.graphics.c
    public float r() {
        return this.k;
    }

    @Override // androidx.compose.ui.graphics.c
    public float s() {
        return this.l;
    }

    public final WH1 t() {
        return this.s;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.s.t1();
    }

    public final EnumC12613eu3 u() {
        return this.t;
    }

    @Override // androidx.compose.ui.graphics.c
    public void v(long j) {
        if (C24381yX0.q(this.h, j)) {
            return;
        }
        this.a |= 64;
        this.h = j;
    }

    @Override // androidx.compose.ui.graphics.c
    public float w() {
        return this.m;
    }

    @Override // androidx.compose.ui.graphics.c
    public void x(boolean z) {
        if (this.p != z) {
            this.a |= 16384;
            this.p = z;
        }
    }

    @Override // androidx.compose.ui.graphics.c
    public void y(long j) {
        if (C24381yX0.q(this.i, j)) {
            return;
        }
        this.a |= 128;
        this.i = j;
    }

    public final int z() {
        return this.a;
    }

    @Override // androidx.compose.ui.graphics.c
    public long z0() {
        return this.n;
    }
}
