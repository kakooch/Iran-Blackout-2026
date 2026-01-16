package ir.nasim;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21430te5;
import java.util.List;

/* renamed from: ir.nasim.xv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24031xv3 implements InterfaceC16823lv3, InterfaceC24630yw3 {
    private final int a;
    private final Object b;
    private final boolean c;
    private final int d;
    private final boolean e;
    private final EnumC12613eu3 f;
    private final int g;
    private final int h;
    private final List i;
    private final long j;
    private final Object k;
    private final LazyLayoutItemAnimator l;
    private final long m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private final long u;
    private long v;
    private int w;
    private int x;
    private boolean y;

    public /* synthetic */ C24031xv3(int i, Object obj, boolean z, int i2, int i3, boolean z2, EnumC12613eu3 enumC12613eu3, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7, ED1 ed1) {
        this(i, obj, z, i2, i3, z2, enumC12613eu3, i4, i5, list, j, obj2, lazyLayoutItemAnimator, j2, i6, i7);
    }

    private final int q(long j) {
        return i() ? C22045ua3.l(j) : C22045ua3.k(j);
    }

    private final int s(AbstractC21430te5 abstractC21430te5) {
        return i() ? abstractC21430te5.A0() : abstractC21430te5.P0();
    }

    @Override // ir.nasim.InterfaceC16823lv3
    public long a() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC16823lv3
    public int b() {
        return this.x;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int c() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public long d() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int e() {
        return this.i.size();
    }

    @Override // ir.nasim.InterfaceC16823lv3
    public int f() {
        return this.w;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public void g(boolean z) {
        this.y = z;
    }

    @Override // ir.nasim.InterfaceC16823lv3, ir.nasim.InterfaceC24630yw3
    public int getIndex() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public Object getKey() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public boolean h() {
        return this.y;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public boolean i() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public void j(int i, int i2, int i3, int i4) {
        u(i, i2, i3, i4, -1, -1);
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int k() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public Object l(int i) {
        return ((AbstractC21430te5) this.i.get(i)).h();
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public long m(int i) {
        return o();
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int n() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC16823lv3
    public long o() {
        return this.v;
    }

    public final void p(int i, boolean z) {
        if (h()) {
            return;
        }
        long jO = o();
        int iK = i() ? C22045ua3.k(jO) : C22045ua3.k(jO) + i;
        boolean zI = i();
        int iL = C22045ua3.l(jO);
        if (zI) {
            iL += i;
        }
        this.v = C22045ua3.f((iK << 32) | (iL & 4294967295L));
        if (z) {
            int iE = e();
            for (int i2 = 0; i2 < iE; i2++) {
                androidx.compose.foundation.lazy.layout.c cVarE = this.l.e(getKey(), i2);
                if (cVarE != null) {
                    long jS = cVarE.s();
                    int iK2 = i() ? C22045ua3.k(jS) : Integer.valueOf(C22045ua3.k(jS) + i).intValue();
                    boolean zI2 = i();
                    int iL2 = C22045ua3.l(jS);
                    if (zI2) {
                        iL2 = Integer.valueOf(iL2 + i).intValue();
                    }
                    cVarE.J(C22045ua3.f((iL2 & 4294967295L) | (iK2 << 32)));
                }
            }
        }
    }

    public final int r() {
        return this.p;
    }

    public final void t(AbstractC21430te5.a aVar, boolean z) {
        C21226tK2 c21226tK2P;
        if (!(this.r != Integer.MIN_VALUE)) {
            P73.a("position() should be called first");
        }
        int iE = e();
        for (int i = 0; i < iE; i++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) this.i.get(i);
            int iS = this.s - s(abstractC21430te5);
            int i2 = this.t;
            long jO = o();
            androidx.compose.foundation.lazy.layout.c cVarE = this.l.e(getKey(), i);
            if (cVarE != null) {
                if (z) {
                    cVarE.F(jO);
                } else {
                    long jO2 = C22045ua3.o(!C22045ua3.j(cVarE.q(), androidx.compose.foundation.lazy.layout.c.s.a()) ? cVarE.q() : jO, cVarE.r());
                    if ((q(jO) <= iS && q(jO2) <= iS) || (q(jO) >= i2 && q(jO2) >= i2)) {
                        cVarE.n();
                    }
                    jO = jO2;
                }
                c21226tK2P = cVarE.p();
            } else {
                c21226tK2P = null;
            }
            if (this.e) {
                jO = C22045ua3.f(((i() ? (this.r - C22045ua3.l(jO)) - s(abstractC21430te5) : C22045ua3.l(jO)) & 4294967295L) | ((i() ? C22045ua3.k(jO) : (this.r - C22045ua3.k(jO)) - s(abstractC21430te5)) << 32));
            }
            long jO3 = C22045ua3.o(jO, this.j);
            if (!z && cVarE != null) {
                cVarE.E(jO3);
            }
            if (i()) {
                if (c21226tK2P != null) {
                    AbstractC21430te5.a.z(aVar, abstractC21430te5, jO3, c21226tK2P, 0.0f, 4, null);
                } else {
                    AbstractC21430te5.a.y(aVar, abstractC21430te5, jO3, 0.0f, null, 6, null);
                }
            } else if (c21226tK2P != null) {
                AbstractC21430te5.a.t(aVar, abstractC21430te5, jO3, c21226tK2P, 0.0f, 4, null);
            } else {
                AbstractC21430te5.a.s(aVar, abstractC21430te5, jO3, 0.0f, null, 6, null);
            }
        }
    }

    public final void u(int i, int i2, int i3, int i4, int i5, int i6) {
        this.r = i() ? i4 : i3;
        if (!i()) {
            i3 = i4;
        }
        if (i() && this.f == EnumC12613eu3.b) {
            i2 = (i3 - i2) - this.d;
        }
        this.v = i() ? C22045ua3.f((i2 << 32) | (4294967295L & i)) : C22045ua3.f((i2 & 4294967295L) | (i << 32));
        this.w = i5;
        this.x = i6;
        this.s = -this.g;
        this.t = this.r + this.h;
    }

    public final void v(int i) {
        this.r = i;
        this.t = i + this.h;
    }

    private C24031xv3(int i, Object obj, boolean z, int i2, int i3, boolean z2, EnumC12613eu3 enumC12613eu3, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7) {
        this.a = i;
        this.b = obj;
        this.c = z;
        this.d = i2;
        this.e = z2;
        this.f = enumC12613eu3;
        this.g = i4;
        this.h = i5;
        this.i = list;
        this.j = j;
        this.k = obj2;
        this.l = lazyLayoutItemAnimator;
        this.m = j2;
        this.n = i6;
        this.o = i7;
        this.r = RecyclerView.UNDEFINED_DURATION;
        int size = list.size();
        int iMax = 0;
        for (int i8 = 0; i8 < size; i8++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list.get(i8);
            iMax = Math.max(iMax, i() ? abstractC21430te5.A0() : abstractC21430te5.P0());
        }
        this.p = iMax;
        this.q = AbstractC23053wG5.e(iMax + i3, 0);
        this.u = i() ? C4414Fa3.c((iMax & 4294967295L) | (this.d << 32)) : C4414Fa3.c((this.d & 4294967295L) | (iMax << 32));
        this.v = C22045ua3.b.b();
        this.w = -1;
        this.x = -1;
    }
}
