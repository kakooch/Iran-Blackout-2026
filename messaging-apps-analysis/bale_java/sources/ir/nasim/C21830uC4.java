package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.uC4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21830uC4 {
    private final ON6 a;
    private final InterfaceC8507Wg4 b;
    private final I34 c;
    private final I34 d;

    /* renamed from: ir.nasim.uC4$a */
    private static final class a {
        private final C24948zU0 a;
        private final List b;

        public a(C24948zU0 c24948zU0, List list) {
            AbstractC13042fc3.i(c24948zU0, "classId");
            AbstractC13042fc3.i(list, "typeParametersCount");
            this.a = c24948zU0;
            this.b = list;
        }

        public final C24948zU0 a() {
            return this.a;
        }

        public final List b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.uC4$b */
    public static final class b extends AbstractC21988uU0 {
        private final boolean i;
        private final List j;
        private final GU0 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ON6 on6, InterfaceC12795fB1 interfaceC12795fB1, C6432No4 c6432No4, boolean z, int i) {
            super(on6, interfaceC12795fB1, c6432No4, JH6.a, false);
            AbstractC13042fc3.i(on6, "storageManager");
            AbstractC13042fc3.i(interfaceC12795fB1, "container");
            AbstractC13042fc3.i(c6432No4, "name");
            this.i = z;
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i);
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c24411ya3Y, 10));
            Iterator it = c24411ya3Y.iterator();
            while (it.hasNext()) {
                int iB = ((AbstractC18386oa3) it).b();
                arrayList.add(C23472wy7.Q0(this, InterfaceC4356Eu.W.b(), false, KQ7.INVARIANT, C6432No4.p(AbstractC13042fc3.q(TokenNames.T, Integer.valueOf(iB))), iB, on6));
            }
            this.j = arrayList;
            this.k = new GU0(this, AbstractC3459Ay7.d(this), AbstractC4363Eu6.c(PI1.l(this).n().i()), on6);
        }

        @Override // ir.nasim.NU0
        public boolean A() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC21331tU0
        public InterfaceC18329oU0 D() {
            return null;
        }

        @Override // ir.nasim.InterfaceC21331tU0
        public boolean F0() {
            return false;
        }

        @Override // ir.nasim.InterfaceC21331tU0
        /* renamed from: J0, reason: merged with bridge method [inline-methods] */
        public W24.b m0() {
            return W24.b.b;
        }

        @Override // ir.nasim.MU0
        /* renamed from: K0, reason: merged with bridge method [inline-methods] */
        public GU0 j() {
            return this.k;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC6615Og4
        /* renamed from: L0, reason: merged with bridge method [inline-methods] */
        public W24.b M(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            return W24.b.b;
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
            return AU0.CLASS;
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

        @Override // ir.nasim.AbstractC21988uU0, ir.nasim.InterfaceC21058t24
        public boolean isExternal() {
            return false;
        }

        @Override // ir.nasim.InterfaceC21331tU0
        public boolean isInline() {
            return false;
        }

        @Override // ir.nasim.InterfaceC21331tU0
        public Collection k() {
            return AbstractC4597Fu6.d();
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
        public InterfaceC21331tU0 n0() {
            return null;
        }

        @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
        public List q() {
            return this.j;
        }

        @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
        public EnumC11067cg4 r() {
            return EnumC11067cg4.FINAL;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // ir.nasim.InterfaceC21331tU0
        public Collection y() {
            return AbstractC10360bX0.m();
        }
    }

    /* renamed from: ir.nasim.uC4$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21331tU0 invoke(a aVar) {
            AbstractC13042fc3.i(aVar, "$dstr$classId$typeParametersCount");
            C24948zU0 c24948zU0A = aVar.a();
            List listB = aVar.b();
            if (c24948zU0A.k()) {
                throw new UnsupportedOperationException(AbstractC13042fc3.q("Unresolved local class: ", c24948zU0A));
            }
            C24948zU0 c24948zU0G = c24948zU0A.g();
            DU0 du0D = c24948zU0G == null ? null : C21830uC4.this.d(c24948zU0G, AbstractC15401jX0.k0(listB, 1));
            if (du0D == null) {
                I34 i34 = C21830uC4.this.c;
                C9424Zw2 c9424Zw2H = c24948zU0A.h();
                AbstractC13042fc3.h(c9424Zw2H, "classId.packageFqName");
                du0D = (DU0) i34.invoke(c9424Zw2H);
            }
            DU0 du0 = du0D;
            boolean zL = c24948zU0A.l();
            ON6 on6 = C21830uC4.this.a;
            C6432No4 c6432No4J = c24948zU0A.j();
            AbstractC13042fc3.h(c6432No4J, "classId.shortClassName");
            Integer num = (Integer) AbstractC15401jX0.s0(listB);
            return new b(on6, du0, c6432No4J, zL, num == null ? 0 : num.intValue());
        }
    }

    /* renamed from: ir.nasim.uC4$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC24340yS4 invoke(C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            return new A72(C21830uC4.this.b, c9424Zw2);
        }
    }

    public C21830uC4(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        this.a = on6;
        this.b = interfaceC8507Wg4;
        this.c = on6.e(new d());
        this.d = on6.e(new c());
    }

    public final InterfaceC21331tU0 d(C24948zU0 c24948zU0, List list) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        AbstractC13042fc3.i(list, "typeParametersCount");
        return (InterfaceC21331tU0) this.d.invoke(new a(c24948zU0, list));
    }
}
