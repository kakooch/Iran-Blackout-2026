package ir.nasim;

import ir.nasim.PJ6;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.gm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13760gm3 extends AbstractC7068Qd1 {
    public static final a b = new a(null);

    /* renamed from: ir.nasim.gm3$a */
    public static final class a {
        private a() {
        }

        public final AbstractC7068Qd1 a(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "argumentType");
            if (AbstractC4816Gr3.a(abstractC4099Dr3)) {
                return null;
            }
            AbstractC4099Dr3 type = abstractC4099Dr3;
            int i = 0;
            while (AbstractC19738qr3.b0(type)) {
                type = ((InterfaceC3932Cy7) AbstractC15401jX0.V0(type.J0())).getType();
                AbstractC13042fc3.h(type, "type.arguments.single().type");
                i++;
            }
            MU0 mu0T = type.K0().t();
            if (mu0T instanceof InterfaceC21331tU0) {
                C24948zU0 c24948zU0H = PI1.h(mu0T);
                return c24948zU0H == null ? new C13760gm3(new b.a(abstractC4099Dr3)) : new C13760gm3(c24948zU0H, i);
            }
            if (!(mu0T instanceof InterfaceC22882vy7)) {
                return null;
            }
            C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.b.l());
            AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new C13760gm3(c24948zU0M, 0);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gm3$b */
    public static abstract class b {

        /* renamed from: ir.nasim.gm3$b$a */
        public static final class a extends b {
            private final AbstractC4099Dr3 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractC4099Dr3 abstractC4099Dr3) {
                super(null);
                AbstractC13042fc3.i(abstractC4099Dr3, "type");
                this.a = abstractC4099Dr3;
            }

            public final AbstractC4099Dr3 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* renamed from: ir.nasim.gm3$b$b, reason: collision with other inner class name */
        public static final class C1259b extends b {
            private final BU0 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1259b(BU0 bu0) {
                super(null);
                AbstractC13042fc3.i(bu0, "value");
                this.a = bu0;
            }

            public final int a() {
                return this.a.c();
            }

            public final C24948zU0 b() {
                return this.a.d();
            }

            public final BU0 c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1259b) && AbstractC13042fc3.d(this.a, ((C1259b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13760gm3(b bVar) {
        super(bVar);
        AbstractC13042fc3.i(bVar, "value");
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
        InterfaceC21331tU0 interfaceC21331tU0E = interfaceC8507Wg4.n().E();
        AbstractC13042fc3.h(interfaceC21331tU0E, "module.builtIns.kClass");
        return C4567Fr3.g(interfaceC4356EuB, interfaceC21331tU0E, AbstractC9766aX0.e(new C4400Ey7(c(interfaceC8507Wg4))));
    }

    public final AbstractC4099Dr3 c(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        b bVar = (b) b();
        if (bVar instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVar instanceof b.C1259b)) {
            throw new NoWhenBranchMatchedException();
        }
        BU0 bu0C = ((b.C1259b) b()).c();
        C24948zU0 c24948zU0A = bu0C.a();
        int iB = bu0C.b();
        InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, c24948zU0A);
        if (interfaceC21331tU0A == null) {
            XC6 xc6J = AbstractC14230ha2.j("Unresolved type: " + c24948zU0A + " (arrayDimensions=" + iB + ')');
            AbstractC13042fc3.h(xc6J, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return xc6J;
        }
        XC6 xc6P = interfaceC21331tU0A.p();
        AbstractC13042fc3.h(xc6P, "descriptor.defaultType");
        AbstractC4099Dr3 abstractC4099Dr3M = AbstractC7731Sy7.m(xc6P);
        for (int i = 0; i < iB; i++) {
            abstractC4099Dr3M = interfaceC8507Wg4.n().l(KQ7.INVARIANT, abstractC4099Dr3M);
            AbstractC13042fc3.h(abstractC4099Dr3M, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return abstractC4099Dr3M;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C13760gm3(BU0 bu0) {
        this(new b.C1259b(bu0));
        AbstractC13042fc3.i(bu0, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C13760gm3(C24948zU0 c24948zU0, int i) {
        this(new BU0(c24948zU0, i));
        AbstractC13042fc3.i(c24948zU0, "classId");
    }
}
