package ir.nasim;

import ir.nasim.AbstractC9998au2;
import java.util.List;

/* renamed from: ir.nasim.Al7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3342Al7 {
    public static final a l = new a(null);
    private final C13245fu a;
    private final C9348Zn7 b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final WH1 g;
    private final AbstractC9998au2.b h;
    private final List i;
    private C25116zl4 j;
    private EnumC12613eu3 k;

    /* renamed from: ir.nasim.Al7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C3342Al7(C13245fu c13245fu, C9348Zn7 c9348Zn7, int i, int i2, boolean z, int i3, WH1 wh1, AbstractC9998au2.b bVar, List list, ED1 ed1) {
        this(c13245fu, c9348Zn7, i, i2, z, i3, wh1, bVar, list);
    }

    private final C25116zl4 f() {
        C25116zl4 c25116zl4 = this.j;
        if (c25116zl4 != null) {
            return c25116zl4;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    private final C24522yl4 n(long j, EnumC12613eu3 enumC12613eu3) {
        m(enumC12613eu3);
        int iN = C17833ne1.n(j);
        int iL = ((this.e || AbstractC23365wn7.g(this.f, AbstractC23365wn7.a.b())) && C17833ne1.h(j)) ? C17833ne1.l(j) : Integer.MAX_VALUE;
        int i = (this.e || !AbstractC23365wn7.g(this.f, AbstractC23365wn7.a.b())) ? this.c : 1;
        if (iN != iL) {
            iL = AbstractC23053wG5.m(c(), iN, iL);
        }
        return new C24522yl4(f(), C17833ne1.b.b(0, iL, 0, C17833ne1.k(j)), i, this.f, null);
    }

    public final WH1 a() {
        return this.g;
    }

    public final AbstractC9998au2.b b() {
        return this.h;
    }

    public final int c() {
        return AbstractC3815Cl7.a(f().c());
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final int g() {
        return this.f;
    }

    public final List h() {
        return this.i;
    }

    public final boolean i() {
        return this.e;
    }

    public final C9348Zn7 j() {
        return this.b;
    }

    public final C13245fu k() {
        return this.a;
    }

    public final C13774gn7 l(long j, EnumC12613eu3 enumC12613eu3, C13774gn7 c13774gn7) {
        if (c13774gn7 != null && AbstractC12547en7.a(c13774gn7, this.a, this.b, this.i, this.c, this.e, this.f, this.g, enumC12613eu3, this.h, j)) {
            return c13774gn7.a(new C13183fn7(c13774gn7.l().j(), this.b, c13774gn7.l().g(), c13774gn7.l().e(), c13774gn7.l().h(), c13774gn7.l().f(), c13774gn7.l().b(), c13774gn7.l().d(), c13774gn7.l().c(), j, (ED1) null), AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC3815Cl7.a(c13774gn7.w().h()) & 4294967295L) | (AbstractC3815Cl7.a(c13774gn7.w().D()) << 32))));
        }
        return new C13774gn7(new C13183fn7(this.a, this.b, this.i, this.c, this.e, this.f, this.g, enumC12613eu3, this.h, j, (ED1) null), n(j, enumC12613eu3), AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC3815Cl7.a(r0.h()) & 4294967295L) | (AbstractC3815Cl7.a(r0.D()) << 32))), null);
    }

    public final void m(EnumC12613eu3 enumC12613eu3) {
        C25116zl4 c25116zl4 = this.j;
        if (c25116zl4 == null || enumC12613eu3 != this.k || c25116zl4.a()) {
            this.k = enumC12613eu3;
            c25116zl4 = new C25116zl4(this.a, AbstractC10560bo7.d(this.b, enumC12613eu3), this.i, this.g, this.h);
        }
        this.j = c25116zl4;
    }

    private C3342Al7(C13245fu c13245fu, C9348Zn7 c9348Zn7, int i, int i2, boolean z, int i3, WH1 wh1, AbstractC9998au2.b bVar, List list) {
        this.a = c13245fu;
        this.b = c9348Zn7;
        this.c = i;
        this.d = i2;
        this.e = z;
        this.f = i3;
        this.g = wh1;
        this.h = bVar;
        this.i = list;
        if (!(i > 0)) {
            P73.a("no maxLines");
        }
        if (!(i2 > 0)) {
            P73.a("no minLines");
        }
        if (i2 <= i) {
            return;
        }
        P73.a("minLines greater than maxLines");
    }

    public /* synthetic */ C3342Al7(C13245fu c13245fu, C9348Zn7 c9348Zn7, int i, int i2, boolean z, int i3, WH1 wh1, AbstractC9998au2.b bVar, List list, int i4, ED1 ed1) {
        this(c13245fu, c9348Zn7, (i4 & 4) != 0 ? Integer.MAX_VALUE : i, (i4 & 8) != 0 ? 1 : i2, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? AbstractC23365wn7.a.a() : i3, wh1, bVar, (i4 & 256) != 0 ? AbstractC10360bX0.m() : list, null);
    }
}
