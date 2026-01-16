package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.hM2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14104hM2 extends CN7 {
    private float[] b;
    private final List c;
    private boolean d;
    private long e;
    private List f;
    private boolean g;
    private V05 h;
    private UA2 i;
    private final UA2 j;
    private String k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private boolean s;

    /* renamed from: ir.nasim.hM2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(CN7 cn7) {
            C14104hM2.this.n(cn7);
            UA2 ua2B = C14104hM2.this.b();
            if (ua2B != null) {
                ua2B.invoke(cn7);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((CN7) obj);
            return C19938rB7.a;
        }
    }

    public C14104hM2() {
        super(null);
        this.c = new ArrayList();
        this.d = true;
        this.e = C24381yX0.b.i();
        this.f = TQ7.d();
        this.g = true;
        this.j = new a();
        this.k = "";
        this.o = 1.0f;
        this.p = 1.0f;
        this.s = true;
    }

    private final boolean h() {
        return !this.f.isEmpty();
    }

    private final void k() {
        this.d = false;
        this.e = C24381yX0.b.i();
    }

    private final void l(AbstractC12520el0 abstractC12520el0) {
        if (this.d && abstractC12520el0 != null) {
            if (abstractC12520el0 instanceof CH6) {
                m(((CH6) abstractC12520el0).b());
            } else {
                k();
            }
        }
    }

    private final void m(long j) {
        if (this.d && j != 16) {
            long j2 = this.e;
            if (j2 == 16) {
                this.e = j;
            } else {
                if (TQ7.e(j2, j)) {
                    return;
                }
                k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(CN7 cn7) {
        if (cn7 instanceof C12682f15) {
            C12682f15 c12682f15 = (C12682f15) cn7;
            l(c12682f15.e());
            l(c12682f15.g());
        } else if (cn7 instanceof C14104hM2) {
            C14104hM2 c14104hM2 = (C14104hM2) cn7;
            if (c14104hM2.d && this.d) {
                m(c14104hM2.e);
            } else {
                k();
            }
        }
    }

    private final void x() {
        if (h()) {
            V05 v05A = this.h;
            if (v05A == null) {
                v05A = AbstractC21611tq.a();
                this.h = v05A;
            }
            AbstractC22313v15.c(this.f, v05A);
        }
    }

    private final void y() {
        float[] fArrC = this.b;
        if (fArrC == null) {
            fArrC = AV3.c(null, 1, null);
            this.b = fArrC;
        } else {
            AV3.h(fArrC);
        }
        AV3.o(fArrC, this.m + this.q, this.n + this.r, 0.0f, 4, null);
        AV3.j(fArrC, this.l);
        AV3.k(fArrC, this.o, this.p, 1.0f);
        AV3.o(fArrC, -this.m, -this.n, 0.0f, 4, null);
    }

    @Override // ir.nasim.CN7
    public void a(InterfaceC17460n02 interfaceC17460n02) {
        if (this.s) {
            y();
            this.s = false;
        }
        if (this.g) {
            x();
            this.g = false;
        }
        YZ1 yz1Z1 = interfaceC17460n02.z1();
        long jD = yz1Z1.d();
        yz1Z1.e().n();
        try {
            InterfaceC19824r02 interfaceC19824r02B = yz1Z1.b();
            float[] fArr = this.b;
            if (fArr != null) {
                interfaceC19824r02B.a(AV3.a(fArr).p());
            }
            V05 v05 = this.h;
            if (h() && v05 != null) {
                InterfaceC19824r02.e(interfaceC19824r02B, v05, 0, 2, null);
            }
            List list = this.c;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((CN7) list.get(i)).a(interfaceC17460n02);
            }
            yz1Z1.e().i();
            yz1Z1.g(jD);
        } catch (Throwable th) {
            yz1Z1.e().i();
            yz1Z1.g(jD);
            throw th;
        }
    }

    @Override // ir.nasim.CN7
    public UA2 b() {
        return this.i;
    }

    @Override // ir.nasim.CN7
    public void d(UA2 ua2) {
        this.i = ua2;
    }

    public final int f() {
        return this.c.size();
    }

    public final long g() {
        return this.e;
    }

    public final void i(int i, CN7 cn7) {
        if (i < f()) {
            this.c.set(i, cn7);
        } else {
            this.c.add(cn7);
        }
        n(cn7);
        cn7.d(this.j);
        c();
    }

    public final boolean j() {
        return this.d;
    }

    public final void o(List list) {
        this.f = list;
        this.g = true;
        c();
    }

    public final void p(String str) {
        this.k = str;
        c();
    }

    public final void q(float f) {
        this.m = f;
        this.s = true;
        c();
    }

    public final void r(float f) {
        this.n = f;
        this.s = true;
        c();
    }

    public final void s(float f) {
        this.l = f;
        this.s = true;
        c();
    }

    public final void t(float f) {
        this.o = f;
        this.s = true;
        c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VGroup: ");
        sb.append(this.k);
        List list = this.c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CN7 cn7 = (CN7) list.get(i);
            sb.append(Separators.HT);
            sb.append(cn7.toString());
            sb.append(Separators.RETURN);
        }
        return sb.toString();
    }

    public final void u(float f) {
        this.p = f;
        this.s = true;
        c();
    }

    public final void v(float f) {
        this.q = f;
        this.s = true;
        c();
    }

    public final void w(float f) {
        this.r = f;
        this.s = true;
        c();
    }
}
