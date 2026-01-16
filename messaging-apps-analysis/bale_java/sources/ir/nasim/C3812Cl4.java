package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.C3758Cf4;
import java.util.List;

/* renamed from: ir.nasim.Cl4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3812Cl4 {
    private C13245fu a;
    private AbstractC9998au2.b b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private List g;
    private C3758Cf4 h;
    private long i;
    private WH1 j;
    private C9348Zn7 k;
    private C25116zl4 l;
    private EnumC12613eu3 m;
    private C13774gn7 n;
    private int o;
    private int p;
    private a q;

    /* renamed from: ir.nasim.Cl4$a */
    private final class a implements WH1 {
    }

    public /* synthetic */ C3812Cl4(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, List list, InterfaceC8312Vk7 interfaceC8312Vk7, ED1 ed1) {
        this(c13245fu, c9348Zn7, bVar, i, z, i2, i3, list, interfaceC8312Vk7);
    }

    private final C24522yl4 e(long j, EnumC12613eu3 enumC12613eu3) {
        C25116zl4 c25116zl4M = m(enumC12613eu3);
        return new C24522yl4(c25116zl4M, AbstractC7930Tu3.a(j, this.d, this.c, c25116zl4M.c()), AbstractC7930Tu3.b(this.d, this.c, this.e), this.c, null);
    }

    private final void g() {
        this.l = null;
        this.n = null;
        this.p = -1;
        this.o = -1;
    }

    private final void h() {
        this.l = null;
        this.n = null;
        this.p = -1;
        this.o = -1;
    }

    private final boolean k(C13774gn7 c13774gn7, long j, EnumC12613eu3 enumC12613eu3) {
        if (c13774gn7 == null || c13774gn7.w().j().a() || enumC12613eu3 != c13774gn7.l().d()) {
            return true;
        }
        if (C17833ne1.f(j, c13774gn7.l().a())) {
            return false;
        }
        return C17833ne1.l(j) != C17833ne1.l(c13774gn7.l().a()) || C17833ne1.n(j) != C17833ne1.n(c13774gn7.l().a()) || ((float) C17833ne1.k(j)) < c13774gn7.w().h() || c13774gn7.w().f();
    }

    private final C25116zl4 m(EnumC12613eu3 enumC12613eu3) {
        C25116zl4 c25116zl4 = this.l;
        if (c25116zl4 == null || enumC12613eu3 != this.m || c25116zl4.a()) {
            this.m = enumC12613eu3;
            C13245fu c13245fu = this.a;
            C9348Zn7 c9348Zn7D = AbstractC10560bo7.d(this.k, enumC12613eu3);
            WH1 wh1 = this.j;
            AbstractC13042fc3.f(wh1);
            AbstractC9998au2.b bVar = this.b;
            List listM = this.g;
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            c25116zl4 = new C25116zl4(c13245fu, c9348Zn7D, listM, wh1, bVar);
        }
        this.l = c25116zl4;
        return c25116zl4;
    }

    private final void n(C9348Zn7 c9348Zn7) {
        boolean zG = c9348Zn7.G(this.k);
        this.k = c9348Zn7;
        if (zG) {
            return;
        }
        h();
    }

    private final C13774gn7 o(EnumC12613eu3 enumC12613eu3, long j, C24522yl4 c24522yl4) {
        float fMin = Math.min(c24522yl4.j().c(), c24522yl4.D());
        C13245fu c13245fu = this.a;
        C9348Zn7 c9348Zn7 = this.k;
        List listM = this.g;
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        int i = this.e;
        boolean z = this.d;
        int i2 = this.c;
        WH1 wh1 = this.j;
        AbstractC13042fc3.f(wh1);
        return new C13774gn7(new C13183fn7(c13245fu, c9348Zn7, list, i, z, i2, wh1, enumC12613eu3, this.b, j, (ED1) null), c24522yl4, AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC3815Cl7.a(c24522yl4.h()) & 4294967295L) | (AbstractC3815Cl7.a(fMin) << 32))), null);
    }

    private final long q(long j, EnumC12613eu3 enumC12613eu3) {
        C3758Cf4.a aVar = C3758Cf4.h;
        C3758Cf4 c3758Cf4 = this.h;
        C9348Zn7 c9348Zn7 = this.k;
        WH1 wh1 = this.j;
        AbstractC13042fc3.f(wh1);
        C3758Cf4 c3758Cf4A = aVar.a(c3758Cf4, enumC12613eu3, c9348Zn7, wh1, this.b);
        this.h = c3758Cf4A;
        return c3758Cf4A.c(j, this.f);
    }

    public final WH1 a() {
        return this.j;
    }

    public final C13774gn7 b() {
        return this.n;
    }

    public final C13774gn7 c() {
        C13774gn7 c13774gn7 = this.n;
        if (c13774gn7 != null) {
            return c13774gn7;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    public final int d(int i, EnumC12613eu3 enumC12613eu3) {
        int i2 = this.o;
        int i3 = this.p;
        if (i == i2 && i2 != -1) {
            return i3;
        }
        long jA = AbstractC19606qe1.a(0, i, 0, Integer.MAX_VALUE);
        if (this.f > 1) {
            jA = q(jA, enumC12613eu3);
        }
        int iE = AbstractC23053wG5.e(AbstractC3815Cl7.a(e(jA, enumC12613eu3).h()), C17833ne1.m(jA));
        this.o = i;
        this.p = iE;
        return iE;
    }

    public final boolean f(long j, EnumC12613eu3 enumC12613eu3) {
        if (this.f > 1) {
            j = q(j, enumC12613eu3);
        }
        if (k(this.n, j, enumC12613eu3)) {
            this.n = o(enumC12613eu3, j, e(j, enumC12613eu3));
            return true;
        }
        C13774gn7 c13774gn7 = this.n;
        AbstractC13042fc3.f(c13774gn7);
        if (C17833ne1.f(j, c13774gn7.l().a())) {
            return false;
        }
        C13774gn7 c13774gn72 = this.n;
        AbstractC13042fc3.f(c13774gn72);
        this.n = o(enumC12613eu3, j, c13774gn72.w());
        return true;
    }

    public final int i(EnumC12613eu3 enumC12613eu3) {
        return AbstractC3815Cl7.a(m(enumC12613eu3).c());
    }

    public final int j(EnumC12613eu3 enumC12613eu3) {
        return AbstractC3815Cl7.a(m(enumC12613eu3).e());
    }

    public final void l(WH1 wh1) {
        WH1 wh12 = this.j;
        long jD = wh1 != null ? S73.d(wh1) : S73.a.a();
        if (wh12 == null) {
            this.j = wh1;
            this.i = jD;
        } else if (wh1 == null || !S73.e(this.i, jD)) {
            this.j = wh1;
            this.i = jD;
            g();
        }
    }

    public final void p(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, List list, InterfaceC8312Vk7 interfaceC8312Vk7) {
        this.a = c13245fu;
        n(c9348Zn7);
        this.b = bVar;
        this.c = i;
        this.d = z;
        this.e = i2;
        this.f = i3;
        this.g = list;
        g();
    }

    private C3812Cl4(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, List list, InterfaceC8312Vk7 interfaceC8312Vk7) {
        this.a = c13245fu;
        this.b = bVar;
        this.c = i;
        this.d = z;
        this.e = i2;
        this.f = i3;
        this.g = list;
        this.i = S73.a.a();
        this.k = c9348Zn7;
        this.o = -1;
        this.p = -1;
    }
}
