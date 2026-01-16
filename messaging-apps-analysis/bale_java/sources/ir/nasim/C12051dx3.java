package ir.nasim;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC12529em;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.dx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12051dx3 implements InterfaceC7948Tw3, InterfaceC24630yw3 {
    private final int a;
    private final List b;
    private final boolean c;
    private final InterfaceC12529em.b d;
    private final InterfaceC12529em.c e;
    private final EnumC12613eu3 f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final long k;
    private final Object l;
    private final Object m;
    private final LazyLayoutItemAnimator n;
    private final long o;
    private int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private final int[] z;

    public /* synthetic */ C12051dx3(int i, List list, boolean z, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, EnumC12613eu3 enumC12613eu3, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, ED1 ed1) {
        this(i, list, z, bVar, cVar, enumC12613eu3, z2, i2, i3, i4, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    private final int o(long j) {
        return i() ? C22045ua3.l(j) : C22045ua3.k(j);
    }

    private final int p(AbstractC21430te5 abstractC21430te5) {
        return i() ? abstractC21430te5.A0() : abstractC21430te5.P0();
    }

    public final void a(int i, boolean z) {
        int iIntValue;
        int iL;
        if (h()) {
            return;
        }
        this.p = getOffset() + i;
        int length = this.z.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 & 1;
            if ((i() && i3 != 0) || (!i() && i3 == 0)) {
                int[] iArr = this.z;
                iArr[i2] = iArr[i2] + i;
            }
        }
        if (z) {
            int iE = e();
            for (int i4 = 0; i4 < iE; i4++) {
                androidx.compose.foundation.lazy.layout.c cVarE = this.n.e(getKey(), i4);
                if (cVarE != null) {
                    long jS = cVarE.s();
                    if (i()) {
                        iIntValue = C22045ua3.k(jS);
                        iL = Integer.valueOf(C22045ua3.l(jS) + i).intValue();
                    } else {
                        iIntValue = Integer.valueOf(C22045ua3.k(jS) + i).intValue();
                        iL = C22045ua3.l(jS);
                    }
                    cVarE.J(C22045ua3.f((iIntValue << 32) | (4294967295L & iL)));
                }
            }
        }
    }

    public final int b() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int c() {
        return this.s;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public long d() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int e() {
        return this.b.size();
    }

    @Override // ir.nasim.InterfaceC7948Tw3
    public int f() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public void g(boolean z) {
        this.v = z;
    }

    @Override // ir.nasim.InterfaceC7948Tw3
    public Object getContentType() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC7948Tw3, ir.nasim.InterfaceC24630yw3
    public int getIndex() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC7948Tw3, ir.nasim.InterfaceC24630yw3
    public Object getKey() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC7948Tw3
    public int getOffset() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public boolean h() {
        return this.v;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public boolean i() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public void j(int i, int i2, int i3, int i4) {
        r(i, i3, i4);
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int k() {
        return this.t;
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public Object l(int i) {
        return ((AbstractC21430te5) this.b.get(i)).h();
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public long m(int i) {
        int[] iArr = this.z;
        int i2 = i * 2;
        return C22045ua3.f((iArr[i2] << 32) | (iArr[i2 + 1] & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC24630yw3
    public int n() {
        return this.r;
    }

    public final void q(AbstractC21430te5.a aVar, boolean z) {
        C21226tK2 c21226tK2P;
        if (!(this.w != Integer.MIN_VALUE)) {
            P73.a("position() should be called first");
        }
        int iE = e();
        for (int i = 0; i < iE; i++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) this.b.get(i);
            int iP = this.x - p(abstractC21430te5);
            int i2 = this.y;
            long jM = m(i);
            androidx.compose.foundation.lazy.layout.c cVarE = this.n.e(getKey(), i);
            if (cVarE != null) {
                if (z) {
                    cVarE.F(jM);
                } else {
                    if (!C22045ua3.j(cVarE.q(), androidx.compose.foundation.lazy.layout.c.s.a())) {
                        jM = cVarE.q();
                    }
                    long jO = C22045ua3.o(jM, cVarE.r());
                    if ((o(jM) <= iP && o(jO) <= iP) || (o(jM) >= i2 && o(jO) >= i2)) {
                        cVarE.n();
                    }
                    jM = jO;
                }
                c21226tK2P = cVarE.p();
            } else {
                c21226tK2P = null;
            }
            if (this.g) {
                jM = C22045ua3.f(i() ? (((this.w - C22045ua3.l(jM)) - p(abstractC21430te5)) & 4294967295L) | (C22045ua3.k(jM) << 32) : (((this.w - C22045ua3.k(jM)) - p(abstractC21430te5)) << 32) | (4294967295L & C22045ua3.l(jM)));
            }
            long jO2 = C22045ua3.o(jM, this.k);
            if (!z && cVarE != null) {
                cVarE.E(jO2);
            }
            if (i()) {
                if (c21226tK2P != null) {
                    AbstractC21430te5.a.z(aVar, abstractC21430te5, jO2, c21226tK2P, 0.0f, 4, null);
                } else {
                    AbstractC21430te5.a.y(aVar, abstractC21430te5, jO2, 0.0f, null, 6, null);
                }
            } else if (c21226tK2P != null) {
                AbstractC21430te5.a.t(aVar, abstractC21430te5, jO2, c21226tK2P, 0.0f, 4, null);
            } else {
                AbstractC21430te5.a.s(aVar, abstractC21430te5, jO2, 0.0f, null, 6, null);
            }
        }
    }

    public final void r(int i, int i2, int i3) {
        int iP0;
        this.p = i;
        this.w = i() ? i3 : i2;
        List list = this.b;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list.get(i4);
            int i5 = i4 * 2;
            if (i()) {
                int[] iArr = this.z;
                InterfaceC12529em.b bVar = this.d;
                if (bVar == null) {
                    P73.b("null horizontalAlignment when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                iArr[i5] = bVar.a(abstractC21430te5.P0(), i2, this.f);
                this.z[i5 + 1] = i;
                iP0 = abstractC21430te5.A0();
            } else {
                int[] iArr2 = this.z;
                iArr2[i5] = i;
                int i6 = i5 + 1;
                InterfaceC12529em.c cVar = this.e;
                if (cVar == null) {
                    P73.b("null verticalAlignment when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                iArr2[i6] = cVar.a(abstractC21430te5.A0(), i3);
                iP0 = abstractC21430te5.P0();
            }
            i += iP0;
        }
        this.x = -this.h;
        this.y = this.w + this.i;
    }

    public final void s(int i) {
        this.w = i;
        this.y = i + this.i;
    }

    private C12051dx3(int i, List list, boolean z, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, EnumC12613eu3 enumC12613eu3, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2) {
        this.a = i;
        this.b = list;
        this.c = z;
        this.d = bVar;
        this.e = cVar;
        this.f = enumC12613eu3;
        this.g = z2;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = j;
        this.l = obj;
        this.m = obj2;
        this.n = lazyLayoutItemAnimator;
        this.o = j2;
        this.s = 1;
        this.w = RecyclerView.UNDEFINED_DURATION;
        int size = list.size();
        int iA0 = 0;
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list.get(i5);
            iA0 += i() ? abstractC21430te5.A0() : abstractC21430te5.P0();
            iMax = Math.max(iMax, !i() ? abstractC21430te5.A0() : abstractC21430te5.P0());
        }
        this.q = iA0;
        this.t = AbstractC23053wG5.e(f() + this.j, 0);
        this.u = iMax;
        this.z = new int[this.b.size() * 2];
    }
}
