package ir.nasim;

import ir.nasim.AbstractC5284Ir3;
import ir.nasim.AbstractC7955Tx1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class PI1 {
    private static final C6432No4 a;

    static final class a implements AbstractC7955Tx1.c {
        public static final a a = new a();

        a() {
        }

        @Override // ir.nasim.AbstractC7955Tx1.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable a(InterfaceC24919zQ7 interfaceC24919zQ7) {
            Collection collectionD = interfaceC24919zQ7.d();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionD, 10));
            Iterator it = collectionD.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC24919zQ7) it.next()).a());
            }
            return arrayList;
        }
    }

    /* synthetic */ class b extends DB2 implements UA2 {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(InterfaceC24919zQ7.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(y((InterfaceC24919zQ7) obj));
        }

        public final boolean y(InterfaceC24919zQ7 interfaceC24919zQ7) {
            AbstractC13042fc3.i(interfaceC24919zQ7, "p0");
            return interfaceC24919zQ7.y0();
        }
    }

    static final class c implements AbstractC7955Tx1.c {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC7955Tx1.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable a(InterfaceC15194jA0 interfaceC15194jA0) {
            if (this.a) {
                interfaceC15194jA0 = interfaceC15194jA0 == null ? null : interfaceC15194jA0.a();
            }
            Collection collectionD = interfaceC15194jA0 != null ? interfaceC15194jA0.d() : null;
            return collectionD == null ? AbstractC10360bX0.m() : collectionD;
        }
    }

    public static final class d extends AbstractC7955Tx1.b {
        final /* synthetic */ C12889fL5 a;
        final /* synthetic */ UA2 b;

        d(C12889fL5 c12889fL5, UA2 ua2) {
            this.a = c12889fL5;
            this.b = ua2;
        }

        @Override // ir.nasim.AbstractC7955Tx1.b, ir.nasim.AbstractC7955Tx1.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "current");
            if (this.a.a == null && ((Boolean) this.b.invoke(interfaceC15194jA0)).booleanValue()) {
                this.a.a = interfaceC15194jA0;
            }
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "current");
            return this.a.a == null;
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public InterfaceC15194jA0 a() {
            return (InterfaceC15194jA0) this.a.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC12795fB1 invoke(InterfaceC12795fB1 interfaceC12795fB1) {
            AbstractC13042fc3.i(interfaceC12795fB1, "it");
            return interfaceC12795fB1.b();
        }
    }

    static {
        C6432No4 c6432No4P = C6432No4.p("value");
        AbstractC13042fc3.h(c6432No4P, "identifier(\"value\")");
        a = c6432No4P;
    }

    public static final boolean a(InterfaceC24919zQ7 interfaceC24919zQ7) {
        AbstractC13042fc3.i(interfaceC24919zQ7, "<this>");
        Boolean boolE = AbstractC7955Tx1.e(AbstractC9766aX0.e(interfaceC24919zQ7), a.a, b.a);
        AbstractC13042fc3.h(boolE, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolE.booleanValue();
    }

    public static final AbstractC7068Qd1 b(InterfaceC21651tu interfaceC21651tu) {
        AbstractC13042fc3.i(interfaceC21651tu, "<this>");
        return (AbstractC7068Qd1) AbstractC15401jX0.r0(interfaceC21651tu.j().values());
    }

    public static final InterfaceC15194jA0 c(InterfaceC15194jA0 interfaceC15194jA0, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return (InterfaceC15194jA0) AbstractC7955Tx1.b(AbstractC9766aX0.e(interfaceC15194jA0), new c(z), new d(new C12889fL5(), ua2));
    }

    public static /* synthetic */ InterfaceC15194jA0 d(InterfaceC15194jA0 interfaceC15194jA0, boolean z, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(interfaceC15194jA0, z, ua2);
    }

    public static final C9424Zw2 e(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        C10027ax2 c10027ax2J = j(interfaceC12795fB1);
        if (!c10027ax2J.f()) {
            c10027ax2J = null;
        }
        if (c10027ax2J == null) {
            return null;
        }
        return c10027ax2J.l();
    }

    public static final InterfaceC21331tU0 f(InterfaceC21651tu interfaceC21651tu) {
        AbstractC13042fc3.i(interfaceC21651tu, "<this>");
        MU0 mu0D = interfaceC21651tu.getType().K0().d();
        if (mu0D instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0D;
        }
        return null;
    }

    public static final AbstractC19738qr3 g(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        return l(interfaceC12795fB1).n();
    }

    public static final C24948zU0 h(MU0 mu0) {
        InterfaceC12795fB1 interfaceC12795fB1B;
        C24948zU0 c24948zU0H;
        if (mu0 == null || (interfaceC12795fB1B = mu0.b()) == null) {
            return null;
        }
        if (interfaceC12795fB1B instanceof InterfaceC24340yS4) {
            return new C24948zU0(((InterfaceC24340yS4) interfaceC12795fB1B).e(), mu0.getName());
        }
        if (!(interfaceC12795fB1B instanceof NU0) || (c24948zU0H = h((MU0) interfaceC12795fB1B)) == null) {
            return null;
        }
        return c24948zU0H.d(mu0.getName());
    }

    public static final C9424Zw2 i(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        C9424Zw2 c9424Zw2N = OI1.n(interfaceC12795fB1);
        AbstractC13042fc3.h(c9424Zw2N, "getFqNameSafe(this)");
        return c9424Zw2N;
    }

    public static final C10027ax2 j(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        C10027ax2 c10027ax2M = OI1.m(interfaceC12795fB1);
        AbstractC13042fc3.h(c10027ax2M, "getFqName(this)");
        return c10027ax2M;
    }

    public static final AbstractC5284Ir3 k(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        C13507gL5 c13507gL5 = (C13507gL5) interfaceC8507Wg4.a0(AbstractC5518Jr3.a());
        AbstractC5284Ir3 abstractC5284Ir3 = c13507gL5 == null ? null : (AbstractC5284Ir3) c13507gL5.a();
        return abstractC5284Ir3 == null ? AbstractC5284Ir3.a.a : abstractC5284Ir3;
    }

    public static final InterfaceC8507Wg4 l(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        InterfaceC8507Wg4 interfaceC8507Wg4G = OI1.g(interfaceC12795fB1);
        AbstractC13042fc3.h(interfaceC8507Wg4G, "getContainingModule(this)");
        return interfaceC8507Wg4G;
    }

    public static final InterfaceC23384wp6 m(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        return AbstractC11342cq6.o(n(interfaceC12795fB1), 1);
    }

    public static final InterfaceC23384wp6 n(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        return AbstractC9962aq6.j(interfaceC12795fB1, e.e);
    }

    public static final InterfaceC15194jA0 o(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        if (!(interfaceC15194jA0 instanceof InterfaceC19199pw5)) {
            return interfaceC15194jA0;
        }
        InterfaceC20989sw5 interfaceC20989sw5V = ((InterfaceC19199pw5) interfaceC15194jA0).V();
        AbstractC13042fc3.h(interfaceC20989sw5V, "correspondingProperty");
        return interfaceC20989sw5V;
    }

    public static final InterfaceC21331tU0 p(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
        for (AbstractC4099Dr3 abstractC4099Dr3 : interfaceC21331tU0.p().K0().b()) {
            if (!AbstractC19738qr3.a0(abstractC4099Dr3)) {
                MU0 mu0D = abstractC4099Dr3.K0().d();
                if (OI1.w(mu0D)) {
                    if (mu0D != null) {
                        return (InterfaceC21331tU0) mu0D;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    public static final boolean q(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        C13507gL5 c13507gL5 = (C13507gL5) interfaceC8507Wg4.a0(AbstractC5518Jr3.a());
        return (c13507gL5 == null ? null : (AbstractC5284Ir3) c13507gL5.a()) != null;
    }

    public static final InterfaceC21331tU0 r(InterfaceC8507Wg4 interfaceC8507Wg4, C9424Zw2 c9424Zw2, IJ3 ij3) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        AbstractC13042fc3.i(c9424Zw2, "topLevelClassFqName");
        AbstractC13042fc3.i(ij3, "location");
        c9424Zw2.d();
        C9424Zw2 c9424Zw2E = c9424Zw2.e();
        AbstractC13042fc3.h(c9424Zw2E, "topLevelClassFqName.parent()");
        W24 w24O = interfaceC8507Wg4.z0(c9424Zw2E).o();
        C6432No4 c6432No4G = c9424Zw2.g();
        AbstractC13042fc3.h(c6432No4G, "topLevelClassFqName.shortName()");
        MU0 mu0E = w24O.e(c6432No4G, ij3);
        if (mu0E instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0E;
        }
        return null;
    }
}
