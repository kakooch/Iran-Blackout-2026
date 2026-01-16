package ir.nasim;

import ir.nasim.InterfaceC13485gJ1;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.nJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17640nJ1 extends AbstractC10688c2 implements InterfaceC13485gJ1 {
    private final ON6 h;
    private final C11410cx5 i;
    private final InterfaceC6692Oo4 j;
    private final C7029Py7 k;
    private final C10938cS7 l;
    private final InterfaceC12258eJ1 m;
    private Collection n;
    private XC6 o;
    private XC6 p;
    private List q;
    private XC6 r;
    private InterfaceC13485gJ1.a s;

    /* JADX WARN: Illegal instructions before constructor call */
    public C17640nJ1(ON6 on6, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, RI1 ri1, C11410cx5 c11410cx5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ri1, "visibility");
        AbstractC13042fc3.i(c11410cx5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(c10938cS7, "versionRequirementTable");
        JH6 jh6 = JH6.a;
        AbstractC13042fc3.h(jh6, "NO_SOURCE");
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, jh6, ri1);
        this.h = on6;
        this.i = c11410cx5;
        this.j = interfaceC6692Oo4;
        this.k = c7029Py7;
        this.l = c10938cS7;
        this.m = interfaceC12258eJ1;
        this.s = InterfaceC13485gJ1.a.COMPATIBLE;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C7029Py7 E() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC7722Sx7
    public XC6 G() {
        XC6 xc6 = this.p;
        if (xc6 != null) {
            return xc6;
        }
        AbstractC13042fc3.y("expandedType");
        throw null;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public List G0() {
        return InterfaceC13485gJ1.b.a(this);
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C10938cS7 I() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC6692Oo4 K() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC12258eJ1 L() {
        return this.m;
    }

    @Override // ir.nasim.AbstractC10688c2
    protected List L0() {
        List list = this.q;
        if (list != null) {
            return list;
        }
        AbstractC13042fc3.y("typeConstructorParameters");
        throw null;
    }

    public InterfaceC13485gJ1.a N0() {
        return this.s;
    }

    @Override // ir.nasim.AbstractC10688c2
    protected ON6 O() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public C11410cx5 g0() {
        return this.i;
    }

    public final void P0(List list, XC6 xc6, XC6 xc62, InterfaceC13485gJ1.a aVar) {
        AbstractC13042fc3.i(list, "declaredTypeParameters");
        AbstractC13042fc3.i(xc6, "underlyingType");
        AbstractC13042fc3.i(xc62, "expandedType");
        AbstractC13042fc3.i(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        M0(list);
        this.o = xc6;
        this.p = xc62;
        this.q = AbstractC3459Ay7.d(this);
        this.r = I0();
        this.n = K0();
        this.s = aVar;
    }

    @Override // ir.nasim.InterfaceC19829r07
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public InterfaceC7722Sx7 c(C5585Jy7 c5585Jy7) {
        AbstractC13042fc3.i(c5585Jy7, "substitutor");
        if (c5585Jy7.k()) {
            return this;
        }
        ON6 on6O = O();
        InterfaceC12795fB1 interfaceC12795fB1B = b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "containingDeclaration");
        InterfaceC4356Eu annotations = getAnnotations();
        AbstractC13042fc3.h(annotations, "annotations");
        C6432No4 name = getName();
        AbstractC13042fc3.h(name, "name");
        C17640nJ1 c17640nJ1 = new C17640nJ1(on6O, interfaceC12795fB1B, annotations, name, getVisibility(), g0(), K(), E(), I(), L());
        List listQ = q();
        XC6 xc6T0 = t0();
        KQ7 kq7 = KQ7.INVARIANT;
        AbstractC4099Dr3 abstractC4099Dr3N = c5585Jy7.n(xc6T0, kq7);
        AbstractC13042fc3.h(abstractC4099Dr3N, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        XC6 xc6A = AbstractC5351Iy7.a(abstractC4099Dr3N);
        AbstractC4099Dr3 abstractC4099Dr3N2 = c5585Jy7.n(G(), kq7);
        AbstractC13042fc3.h(abstractC4099Dr3N2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        c17640nJ1.P0(listQ, xc6A, AbstractC5351Iy7.a(abstractC4099Dr3N2), N0());
        return c17640nJ1;
    }

    @Override // ir.nasim.MU0
    public XC6 p() {
        XC6 xc6 = this.r;
        if (xc6 != null) {
            return xc6;
        }
        AbstractC13042fc3.y("defaultTypeImpl");
        throw null;
    }

    @Override // ir.nasim.InterfaceC7722Sx7
    public InterfaceC21331tU0 s() {
        if (AbstractC4816Gr3.a(G())) {
            return null;
        }
        MU0 mu0T = G().K0().t();
        if (mu0T instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0T;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC7722Sx7
    public XC6 t0() {
        XC6 xc6 = this.o;
        if (xc6 != null) {
            return xc6;
        }
        AbstractC13042fc3.y("underlyingType");
        throw null;
    }
}
