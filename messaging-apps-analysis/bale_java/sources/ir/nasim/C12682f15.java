package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.f15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12682f15 extends CN7 {
    private String b;
    private AbstractC12520el0 c;
    private float d;
    private List e;
    private int f;
    private float g;
    private float h;
    private AbstractC12520el0 i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private C23815xZ6 s;
    private final V05 t;
    private V05 u;
    private final InterfaceC9173Yu3 v;

    /* renamed from: ir.nasim.f15$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18064o15 invoke() {
            return AbstractC20924sq.a();
        }
    }

    public C12682f15() {
        super(null);
        this.b = "";
        this.d = 1.0f;
        this.e = TQ7.d();
        this.f = TQ7.a();
        this.g = 1.0f;
        this.j = TQ7.b();
        this.k = TQ7.c();
        this.l = 4.0f;
        this.n = 1.0f;
        this.p = true;
        this.q = true;
        V05 v05A = AbstractC21611tq.a();
        this.t = v05A;
        this.u = v05A;
        this.v = AbstractC13269fw3.b(EnumC4870Gx3.c, a.e);
    }

    private final InterfaceC18064o15 f() {
        return (InterfaceC18064o15) this.v.getValue();
    }

    private final void v() {
        AbstractC22313v15.c(this.e, this.t);
        w();
    }

    private final void w() {
        if (this.m == 0.0f && this.n == 1.0f) {
            this.u = this.t;
            return;
        }
        if (AbstractC13042fc3.d(this.u, this.t)) {
            this.u = AbstractC21611tq.a();
        } else {
            int iQ = this.u.q();
            this.u.t();
            this.u.h(iQ);
        }
        f().b(this.t, false);
        float length = f().getLength();
        float f = this.m;
        float f2 = this.o;
        float f3 = ((f + f2) % 1.0f) * length;
        float f4 = ((this.n + f2) % 1.0f) * length;
        if (f3 <= f4) {
            f().a(f3, f4, this.u, true);
        } else {
            f().a(f3, length, this.u, true);
            f().a(0.0f, f4, this.u, true);
        }
    }

    @Override // ir.nasim.CN7
    public void a(InterfaceC17460n02 interfaceC17460n02) {
        if (this.p) {
            v();
        } else if (this.r) {
            w();
        }
        this.p = false;
        this.r = false;
        AbstractC12520el0 abstractC12520el0 = this.c;
        if (abstractC12520el0 != null) {
            InterfaceC17460n02.G0(interfaceC17460n02, this.u, abstractC12520el0, this.d, null, null, 0, 56, null);
        }
        AbstractC12520el0 abstractC12520el02 = this.i;
        if (abstractC12520el02 != null) {
            C23815xZ6 c23815xZ6 = this.s;
            if (this.q || c23815xZ6 == null) {
                c23815xZ6 = new C23815xZ6(this.h, this.l, this.j, this.k, null, 16, null);
                this.s = c23815xZ6;
                this.q = false;
            }
            InterfaceC17460n02.G0(interfaceC17460n02, this.u, abstractC12520el02, this.g, c23815xZ6, null, 0, 48, null);
        }
    }

    public final AbstractC12520el0 e() {
        return this.c;
    }

    public final AbstractC12520el0 g() {
        return this.i;
    }

    public final void h(AbstractC12520el0 abstractC12520el0) {
        this.c = abstractC12520el0;
        c();
    }

    public final void i(float f) {
        this.d = f;
        c();
    }

    public final void j(String str) {
        this.b = str;
        c();
    }

    public final void k(List list) {
        this.e = list;
        this.p = true;
        c();
    }

    public final void l(int i) {
        this.f = i;
        this.u.h(i);
        c();
    }

    public final void m(AbstractC12520el0 abstractC12520el0) {
        this.i = abstractC12520el0;
        c();
    }

    public final void n(float f) {
        this.g = f;
        c();
    }

    public final void o(int i) {
        this.j = i;
        this.q = true;
        c();
    }

    public final void p(int i) {
        this.k = i;
        this.q = true;
        c();
    }

    public final void q(float f) {
        this.l = f;
        this.q = true;
        c();
    }

    public final void r(float f) {
        this.h = f;
        this.q = true;
        c();
    }

    public final void s(float f) {
        this.n = f;
        this.r = true;
        c();
    }

    public final void t(float f) {
        this.o = f;
        this.r = true;
        c();
    }

    public String toString() {
        return this.t.toString();
    }

    public final void u(float f) {
        this.m = f;
        this.r = true;
        c();
    }
}
