package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.C3758Cf4;
import java.util.List;

/* renamed from: ir.nasim.hW4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14196hW4 {
    private String a;
    private C9348Zn7 b;
    private AbstractC9998au2.b c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private long h;
    private WH1 i;
    private InterfaceC10355bW4 j;
    private boolean k;
    private long l;
    private C3758Cf4 m;
    private InterfaceC12378eW4 n;
    private EnumC12613eu3 o;
    private long p;
    private int q;
    private int r;

    public /* synthetic */ C14196hW4(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, ED1 ed1) {
        this(str, c9348Zn7, bVar, i, z, i2, i3);
    }

    private final void i() {
        this.j = null;
        this.n = null;
        this.o = null;
        this.q = -1;
        this.r = -1;
        this.p = C17833ne1.b.c(0, 0);
        long j = 0;
        this.l = C4414Fa3.c((j & 4294967295L) | (j << 32));
        this.k = false;
    }

    private final boolean l(long j, EnumC12613eu3 enumC12613eu3) {
        InterfaceC12378eW4 interfaceC12378eW4;
        InterfaceC10355bW4 interfaceC10355bW4 = this.j;
        if (interfaceC10355bW4 == null || (interfaceC12378eW4 = this.n) == null || interfaceC12378eW4.a() || enumC12613eu3 != this.o) {
            return true;
        }
        if (C17833ne1.f(j, this.p)) {
            return false;
        }
        return C17833ne1.l(j) != C17833ne1.l(this.p) || C17833ne1.n(j) != C17833ne1.n(this.p) || ((float) C17833ne1.k(j)) < interfaceC10355bW4.getHeight() || interfaceC10355bW4.q();
    }

    private final InterfaceC12378eW4 n(EnumC12613eu3 enumC12613eu3) {
        InterfaceC12378eW4 interfaceC12378eW4A = this.n;
        if (interfaceC12378eW4A == null || enumC12613eu3 != this.o || interfaceC12378eW4A.a()) {
            this.o = enumC12613eu3;
            String str = this.a;
            C9348Zn7 c9348Zn7D = AbstractC10560bo7.d(this.b, enumC12613eu3);
            List listM = AbstractC10360bX0.m();
            WH1 wh1 = this.i;
            AbstractC13042fc3.f(wh1);
            interfaceC12378eW4A = AbstractC12987fW4.a(str, c9348Zn7D, listM, wh1, this.c, AbstractC10360bX0.m());
        }
        this.n = interfaceC12378eW4A;
        return interfaceC12378eW4A;
    }

    private final long q(long j, EnumC12613eu3 enumC12613eu3, C9348Zn7 c9348Zn7) {
        C3758Cf4.a aVar = C3758Cf4.h;
        C3758Cf4 c3758Cf4 = this.m;
        WH1 wh1 = this.i;
        AbstractC13042fc3.f(wh1);
        C3758Cf4 c3758Cf4A = aVar.a(c3758Cf4, enumC12613eu3, c9348Zn7, wh1, this.c);
        this.m = c3758Cf4A;
        return c3758Cf4A.c(j, this.g);
    }

    static /* synthetic */ long r(C14196hW4 c14196hW4, long j, EnumC12613eu3 enumC12613eu3, C9348Zn7 c9348Zn7, int i, Object obj) {
        if ((i & 4) != 0) {
            c9348Zn7 = c14196hW4.b;
        }
        return c14196hW4.q(j, enumC12613eu3, c9348Zn7);
    }

    public final WH1 a() {
        return this.i;
    }

    public final boolean b() {
        return this.k;
    }

    public final long c() {
        return this.l;
    }

    public final C19938rB7 d() {
        InterfaceC12378eW4 interfaceC12378eW4 = this.n;
        if (interfaceC12378eW4 != null) {
            interfaceC12378eW4.a();
        }
        return C19938rB7.a;
    }

    public final InterfaceC10355bW4 e() {
        return this.j;
    }

    public final int f(int i, EnumC12613eu3 enumC12613eu3) {
        int i2 = this.q;
        int i3 = this.r;
        if (i == i2 && i2 != -1) {
            return i3;
        }
        long jA = AbstractC19606qe1.a(0, i, 0, Integer.MAX_VALUE);
        if (this.g > 1) {
            jA = r(this, jA, enumC12613eu3, null, 4, null);
        }
        int iE = AbstractC23053wG5.e(AbstractC3815Cl7.a(g(jA, enumC12613eu3).getHeight()), C17833ne1.m(jA));
        this.q = i;
        this.r = iE;
        return iE;
    }

    public final InterfaceC10355bW4 g(long j, EnumC12613eu3 enumC12613eu3) {
        InterfaceC12378eW4 interfaceC12378eW4N = n(enumC12613eu3);
        return AbstractC13605gW4.c(interfaceC12378eW4N, AbstractC7930Tu3.a(j, this.e, this.d, interfaceC12378eW4N.c()), AbstractC7930Tu3.b(this.e, this.d, this.f), this.d);
    }

    public final boolean h(long j, EnumC12613eu3 enumC12613eu3) {
        boolean z = true;
        if (this.g > 1) {
            j = r(this, j, enumC12613eu3, null, 4, null);
        }
        boolean z2 = false;
        if (l(j, enumC12613eu3)) {
            InterfaceC10355bW4 interfaceC10355bW4G = g(j, enumC12613eu3);
            this.p = j;
            this.l = AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC3815Cl7.a(interfaceC10355bW4G.getWidth()) << 32) | (AbstractC3815Cl7.a(interfaceC10355bW4G.getHeight()) & 4294967295L)));
            if (!AbstractC23365wn7.g(this.d, AbstractC23365wn7.a.e()) && (((int) (r12 >> 32)) < interfaceC10355bW4G.getWidth() || ((int) (r12 & 4294967295L)) < interfaceC10355bW4G.getHeight())) {
                z2 = true;
            }
            this.k = z2;
            this.j = interfaceC10355bW4G;
            return true;
        }
        if (!C17833ne1.f(j, this.p)) {
            InterfaceC10355bW4 interfaceC10355bW4 = this.j;
            AbstractC13042fc3.f(interfaceC10355bW4);
            this.l = AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC3815Cl7.a(Math.min(interfaceC10355bW4.c(), interfaceC10355bW4.getWidth())) << 32) | (AbstractC3815Cl7.a(interfaceC10355bW4.getHeight()) & 4294967295L)));
            if (AbstractC23365wn7.g(this.d, AbstractC23365wn7.a.e()) || (((int) (r6 >> 32)) >= interfaceC10355bW4.getWidth() && ((int) (4294967295L & r6)) >= interfaceC10355bW4.getHeight())) {
                z = false;
            }
            this.k = z;
            this.p = j;
        }
        return false;
    }

    public final int j(EnumC12613eu3 enumC12613eu3) {
        return AbstractC3815Cl7.a(n(enumC12613eu3).c());
    }

    public final int k(EnumC12613eu3 enumC12613eu3) {
        return AbstractC3815Cl7.a(n(enumC12613eu3).e());
    }

    public final void m(WH1 wh1) {
        WH1 wh12 = this.i;
        long jD = wh1 != null ? S73.d(wh1) : S73.a.a();
        if (wh12 == null) {
            this.i = wh1;
            this.h = jD;
        } else if (wh1 == null || !S73.e(this.h, jD)) {
            this.i = wh1;
            this.h = jD;
            i();
        }
    }

    public final C13774gn7 o(C9348Zn7 c9348Zn7) {
        WH1 wh1;
        EnumC12613eu3 enumC12613eu3 = this.o;
        if (enumC12613eu3 == null || (wh1 = this.i) == null) {
            return null;
        }
        C13245fu c13245fu = new C13245fu(this.a, null, 2, null);
        if (this.j == null || this.n == null) {
            return null;
        }
        long jB = C17833ne1.b(this.p & (-8589934589L));
        return new C13774gn7(new C13183fn7(c13245fu, c9348Zn7, AbstractC10360bX0.m(), this.f, this.e, this.d, wh1, enumC12613eu3, this.c, jB, (ED1) null), new C24522yl4(new C25116zl4(c13245fu, c9348Zn7, AbstractC10360bX0.m(), wh1, this.c), jB, this.f, this.d, null), this.l, null);
    }

    public final void p(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3) {
        this.a = str;
        this.b = c9348Zn7;
        this.c = bVar;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = i3;
        i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParagraphLayoutCache(paragraph=");
        sb.append(this.j != null ? "<paragraph>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) S73.h(this.h));
        sb.append(')');
        return sb.toString();
    }

    private C14196hW4(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3) {
        this.a = str;
        this.b = c9348Zn7;
        this.c = bVar;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = i3;
        this.h = S73.a.a();
        long j = 0;
        this.l = C4414Fa3.c((j & 4294967295L) | (j << 32));
        this.p = C17833ne1.b.c(0, 0);
        this.q = -1;
        this.r = -1;
    }
}
