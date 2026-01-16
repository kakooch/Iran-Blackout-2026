package ir.nasim;

import ir.nasim.C7488Rx7;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.c2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10688c2 extends AbstractC14602iB1 implements InterfaceC7722Sx7 {
    private final RI1 e;
    private List f;
    private final c g;

    /* renamed from: ir.nasim.c2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            MU0 mu0E = abstractC5284Ir3.e(AbstractC10688c2.this);
            if (mu0E == null) {
                return null;
            }
            return mu0E.p();
        }
    }

    /* renamed from: ir.nasim.c2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke(ir.nasim.AbstractC18174oC7 r3) {
            /*
                r2 = this;
                java.lang.String r0 = "type"
                ir.nasim.AbstractC13042fc3.h(r3, r0)
                boolean r0 = ir.nasim.AbstractC4816Gr3.a(r3)
                if (r0 != 0) goto L27
                ir.nasim.c2 r0 = ir.nasim.AbstractC10688c2.this
                ir.nasim.gy7 r3 = r3.K0()
                ir.nasim.MU0 r3 = r3.t()
                boolean r1 = r3 instanceof ir.nasim.InterfaceC22882vy7
                if (r1 == 0) goto L27
                ir.nasim.vy7 r3 = (ir.nasim.InterfaceC22882vy7) r3
                ir.nasim.fB1 r3 = r3.b()
                boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r0)
                if (r3 != 0) goto L27
                r3 = 1
                goto L28
            L27:
                r3 = 0
            L28:
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10688c2.b.invoke(ir.nasim.oC7):java.lang.Boolean");
        }
    }

    /* renamed from: ir.nasim.c2$c */
    public static final class c implements InterfaceC13882gy7 {
        c() {
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public InterfaceC13882gy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            return this;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public Collection b() {
            Collection collectionB = t().t0().K0().b();
            AbstractC13042fc3.h(collectionB, "declarationDescriptor.underlyingType.constructor.supertypes");
            return collectionB;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return true;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public InterfaceC7722Sx7 t() {
            return AbstractC10688c2.this;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            return AbstractC10688c2.this.L0();
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public AbstractC19738qr3 n() {
            return PI1.g(t());
        }

        public String toString() {
            return "[typealias " + t().getName().h() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC10688c2(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, JH6 jh6, RI1 ri1) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, jh6);
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(jh6, "sourceElement");
        AbstractC13042fc3.i(ri1, "visibilityImpl");
        this.e = ri1;
        this.g = new c();
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return AbstractC7497Ry7.c(t0(), new b());
    }

    protected final XC6 I0() {
        InterfaceC21331tU0 interfaceC21331tU0S = s();
        W24 w24W = interfaceC21331tU0S == null ? null : interfaceC21331tU0S.W();
        if (w24W == null) {
            w24W = W24.b.b;
        }
        XC6 xc6T = AbstractC7497Ry7.t(this, w24W, new a());
        AbstractC13042fc3.h(xc6T, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        return xc6T;
    }

    @Override // ir.nasim.AbstractC14602iB1
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public InterfaceC7722Sx7 a() {
        return (InterfaceC7722Sx7) super.a();
    }

    public final Collection K0() {
        InterfaceC21331tU0 interfaceC21331tU0S = s();
        if (interfaceC21331tU0S == null) {
            return AbstractC10360bX0.m();
        }
        Collection<InterfaceC18329oU0> collectionK = interfaceC21331tU0S.k();
        AbstractC13042fc3.h(collectionK, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (InterfaceC18329oU0 interfaceC18329oU0 : collectionK) {
            C7488Rx7.a aVar = C7488Rx7.Z;
            ON6 on6O = O();
            AbstractC13042fc3.h(interfaceC18329oU0, "it");
            InterfaceC7254Qx7 interfaceC7254Qx7B = aVar.b(on6O, this, interfaceC18329oU0);
            if (interfaceC7254Qx7B != null) {
                arrayList.add(interfaceC7254Qx7B);
            }
        }
        return arrayList;
    }

    protected abstract List L0();

    public final void M0(List list) {
        AbstractC13042fc3.i(list, "declaredTypeParameters");
        this.f = list;
    }

    protected abstract ON6 O();

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.NU0
    public List q() {
        List list = this.f;
        if (list != null) {
            return list;
        }
        AbstractC13042fc3.y("declaredTypeParametersImpl");
        throw null;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        AbstractC13042fc3.i(interfaceC15204jB1, "visitor");
        return interfaceC15204jB1.e(this, obj);
    }

    @Override // ir.nasim.AbstractC13413gB1
    public String toString() {
        return AbstractC13042fc3.q("typealias ", getName().h());
    }
}
