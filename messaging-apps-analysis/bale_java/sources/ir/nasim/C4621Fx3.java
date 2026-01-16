package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Fx3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4621Fx3 extends AbstractC6615Og4 {
    private final AbstractC6615Og4 b;
    private final C5585Jy7 c;
    private C5585Jy7 d;
    private List e;
    private List f;
    private InterfaceC13882gy7 g;

    /* renamed from: ir.nasim.Fx3$a */
    class a implements UA2 {
        a() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(InterfaceC22882vy7 interfaceC22882vy7) {
            return Boolean.valueOf(!interfaceC22882vy7.S());
        }
    }

    public C4621Fx3(AbstractC6615Og4 abstractC6615Og4, C5585Jy7 c5585Jy7) {
        this.b = abstractC6615Og4;
        this.c = c5585Jy7;
    }

    private C5585Jy7 I0() {
        if (this.d == null) {
            if (this.c.k()) {
                this.d = this.c;
            } else {
                List parameters = this.b.j().getParameters();
                this.e = new ArrayList(parameters.size());
                this.d = MI1.b(parameters, this.c.j(), this, this.e);
                this.f = AbstractC15401jX0.m0(this.e, new a());
            }
        }
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void i0(int r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4621Fx3.i0(int):void");
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return this.b.A();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return this.b.D();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return this.b.F0();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 H(AbstractC5117Hy7 abstractC5117Hy7) {
        if (abstractC5117Hy7 == null) {
            i0(10);
        }
        W24 w24X = x(abstractC5117Hy7, PI1.k(OI1.g(this)));
        if (w24X == null) {
            i0(11);
        }
        return w24X;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public ZI5 H0() {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.InterfaceC19829r07
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public InterfaceC21331tU0 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            i0(22);
        }
        return c5585Jy7.k() ? this : new C4621Fx3(this, C5585Jy7.h(c5585Jy7.j(), I0().j()));
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 M(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            i0(13);
        }
        W24 w24M = this.b.M(abstractC5284Ir3);
        if (!this.c.k()) {
            return new C22305v07(w24M, I0());
        }
        if (w24M == null) {
            i0(14);
        }
        return w24M;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 U() {
        W24 w24U = this.b.U();
        if (w24U == null) {
            i0(27);
        }
        return w24U;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 W() {
        W24 w24M = M(PI1.k(OI1.g(this.b)));
        if (w24M == null) {
            i0(12);
        }
        return w24M;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return this.b.Y();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC14004hB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        InterfaceC12795fB1 interfaceC12795fB1B = this.b.b();
        if (interfaceC12795fB1B == null) {
            i0(21);
        }
        return interfaceC12795fB1B;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return this.b.b0();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        AU0 au0F = this.b.f();
        if (au0F == null) {
            i0(24);
        }
        return au0F;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        return this.b.f0();
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        InterfaceC4356Eu annotations = this.b.getAnnotations();
        if (annotations == null) {
            i0(18);
        }
        return annotations;
    }

    @Override // ir.nasim.InterfaceC7638So4
    public C6432No4 getName() {
        C6432No4 name = this.b.getName();
        if (name == null) {
            i0(19);
        }
        return name;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 visibility = this.b.getVisibility();
        if (visibility == null) {
            i0(26);
        }
        return visibility;
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        JH6 jh6 = JH6.a;
        if (jh6 == null) {
            i0(28);
        }
        return jh6;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return this.b.isExternal();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return this.b.isInline();
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        InterfaceC13882gy7 interfaceC13882gy7J = this.b.j();
        if (this.c.k()) {
            if (interfaceC13882gy7J == null) {
                i0(0);
            }
            return interfaceC13882gy7J;
        }
        if (this.g == null) {
            C5585Jy7 c5585Jy7I0 = I0();
            Collection collectionB = interfaceC13882gy7J.b();
            ArrayList arrayList = new ArrayList(collectionB.size());
            Iterator it = collectionB.iterator();
            while (it.hasNext()) {
                arrayList.add(c5585Jy7I0.p((AbstractC4099Dr3) it.next(), KQ7.INVARIANT));
            }
            this.g = new GU0(this, this.e, arrayList, C14671iI3.e);
        }
        InterfaceC13882gy7 interfaceC13882gy7 = this.g;
        if (interfaceC13882gy7 == null) {
            i0(1);
        }
        return interfaceC13882gy7;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection k() {
        Collection<InterfaceC18329oU0> collectionK = this.b.k();
        ArrayList arrayList = new ArrayList(collectionK.size());
        for (InterfaceC18329oU0 interfaceC18329oU0 : collectionK) {
            arrayList.add(((InterfaceC18329oU0) interfaceC18329oU0.t().k(interfaceC18329oU0.a()).s(interfaceC18329oU0.r()).g(interfaceC18329oU0.getVisibility()).q(interfaceC18329oU0.f()).o(false).a()).c(I0()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        return this.b.k0();
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return this.b.l0();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 m0() {
        W24 w24M0 = this.b.m0();
        if (w24M0 == null) {
            i0(15);
        }
        return w24M0;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return this.b.n0();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.MU0
    public XC6 p() {
        XC6 xc6J = C4567Fr3.j(getAnnotations(), j(), AbstractC7497Ry7.g(j().getParameters()), false, W());
        if (xc6J == null) {
            i0(16);
        }
        return xc6J;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        I0();
        List list = this.f;
        if (list == null) {
            i0(29);
        }
        return list;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.a(this, obj);
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4R = this.b.r();
        if (enumC11067cg4R == null) {
            i0(25);
        }
        return enumC11067cg4R;
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 x(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5117Hy7 == null) {
            i0(5);
        }
        if (abstractC5284Ir3 == null) {
            i0(6);
        }
        W24 w24X = this.b.x(abstractC5117Hy7, abstractC5284Ir3);
        if (!this.c.k()) {
            return new C22305v07(w24X, I0());
        }
        if (w24X == null) {
            i0(7);
        }
        return w24X;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection y() {
        Collection collectionY = this.b.y();
        if (collectionY == null) {
            i0(30);
        }
        return collectionY;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC21331tU0 a() {
        InterfaceC21331tU0 interfaceC21331tU0A = this.b.a();
        if (interfaceC21331tU0A == null) {
            i0(20);
        }
        return interfaceC21331tU0A;
    }
}
