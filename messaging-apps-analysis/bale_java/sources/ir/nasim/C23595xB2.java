package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.M17;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xB2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23595xB2 extends E0 {
    public static final a m = new a(null);
    private static final C24948zU0 n = new C24948zU0(PJ6.m, C6432No4.p("Function"));
    private static final C24948zU0 o = new C24948zU0(PJ6.j, C6432No4.p("KFunction"));
    private final ON6 f;
    private final InterfaceC24340yS4 g;
    private final EnumC24185yB2 h;
    private final int i;
    private final b j;
    private final C24775zB2 k;
    private final List l;

    /* renamed from: ir.nasim.xB2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xB2$b */
    private final class b extends F0 {
        final /* synthetic */ C23595xB2 d;

        /* renamed from: ir.nasim.xB2$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC24185yB2.values().length];
                iArr[EnumC24185yB2.d.ordinal()] = 1;
                iArr[EnumC24185yB2.f.ordinal()] = 2;
                iArr[EnumC24185yB2.e.ordinal()] = 3;
                iArr[EnumC24185yB2.g.ordinal()] = 4;
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C23595xB2 c23595xB2) {
            super(c23595xB2.f);
            AbstractC13042fc3.i(c23595xB2, "this$0");
            this.d = c23595xB2;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return true;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            return this.d.l;
        }

        @Override // ir.nasim.AbstractC12686f2
        protected Collection h() {
            List listE;
            int i = a.a[this.d.T0().ordinal()];
            if (i == 1) {
                listE = AbstractC9766aX0.e(C23595xB2.n);
            } else if (i == 2) {
                listE = AbstractC10360bX0.p(C23595xB2.o, new C24948zU0(PJ6.m, EnumC24185yB2.d.p(this.d.P0())));
            } else if (i == 3) {
                listE = AbstractC9766aX0.e(C23595xB2.n);
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                listE = AbstractC10360bX0.p(C23595xB2.o, new C24948zU0(PJ6.d, EnumC24185yB2.e.p(this.d.P0())));
            }
            InterfaceC8507Wg4 interfaceC8507Wg4B = this.d.g.b();
            List<C24948zU0> list = listE;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C24948zU0 c24948zU0 : list) {
                InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4B, c24948zU0);
                if (interfaceC21331tU0A == null) {
                    throw new IllegalStateException(("Built-in class " + c24948zU0 + " not found").toString());
                }
                List listG1 = AbstractC15401jX0.g1(getParameters(), interfaceC21331tU0A.j().getParameters().size());
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listG1, 10));
                Iterator it = listG1.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new C4400Ey7(((InterfaceC22882vy7) it.next()).p()));
                }
                C4567Fr3 c4567Fr3 = C4567Fr3.a;
                arrayList.add(C4567Fr3.g(InterfaceC4356Eu.W.b(), interfaceC21331tU0A, arrayList2));
            }
            return AbstractC15401jX0.m1(arrayList);
        }

        @Override // ir.nasim.AbstractC12686f2
        protected M17 l() {
            return M17.a.a;
        }

        public String toString() {
            return t().toString();
        }

        @Override // ir.nasim.F0
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public C23595xB2 t() {
            return this.d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23595xB2(ON6 on6, InterfaceC24340yS4 interfaceC24340yS4, EnumC24185yB2 enumC24185yB2, int i) {
        super(on6, enumC24185yB2.p(i));
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC24340yS4, "containingDeclaration");
        AbstractC13042fc3.i(enumC24185yB2, "functionKind");
        this.f = on6;
        this.g = interfaceC24340yS4;
        this.h = enumC24185yB2;
        this.i = i;
        this.j = new b(this);
        this.k = new C24775zB2(on6, this);
        ArrayList arrayList = new ArrayList();
        C24411ya3 c24411ya3 = new C24411ya3(1, i);
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(c24411ya3, 10));
        Iterator it = c24411ya3.iterator();
        while (it.hasNext()) {
            J0(arrayList, this, KQ7.IN_VARIANCE, AbstractC13042fc3.q("P", Integer.valueOf(((AbstractC18386oa3) it).b())));
            arrayList2.add(C19938rB7.a);
        }
        J0(arrayList, this, KQ7.OUT_VARIANCE, TokenNames.R);
        this.l = AbstractC15401jX0.m1(arrayList);
    }

    private static final void J0(ArrayList arrayList, C23595xB2 c23595xB2, KQ7 kq7, String str) {
        arrayList.add(C23472wy7.Q0(c23595xB2, InterfaceC4356Eu.W.b(), false, kq7, C6432No4.p(str), arrayList.size(), c23595xB2.f));
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public /* bridge */ /* synthetic */ InterfaceC18329oU0 D() {
        return (InterfaceC18329oU0) X0();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return false;
    }

    public final int P0() {
        return this.i;
    }

    public Void Q0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public List k() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC14004hB1, ir.nasim.InterfaceC12795fB1
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public InterfaceC24340yS4 b() {
        return this.g;
    }

    public final EnumC24185yB2 T0() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public List y() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public W24.b m0() {
        return W24.b.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC6615Og4
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public C24775zB2 M(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return this.k;
    }

    public Void X0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        return AU0.INTERFACE;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return InterfaceC4356Eu.W.b();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = QI1.e;
        AbstractC13042fc3.h(ri1, "PUBLIC");
        return ri1;
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        JH6 jh6 = JH6.a;
        AbstractC13042fc3.h(jh6, "NO_SOURCE");
        return jh6;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public /* bridge */ /* synthetic */ InterfaceC21331tU0 n0() {
        return (InterfaceC21331tU0) Q0();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        return EnumC11067cg4.ABSTRACT;
    }

    public String toString() {
        String strH = getName().h();
        AbstractC13042fc3.h(strH, "name.asString()");
        return strH;
    }
}
