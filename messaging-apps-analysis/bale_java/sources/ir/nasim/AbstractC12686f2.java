package ir.nasim;

import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.f2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12686f2 implements InterfaceC13882gy7 {
    private final InterfaceC23016wC4 a;
    private final boolean b;

    /* renamed from: ir.nasim.f2$a */
    private final class a implements InterfaceC13882gy7 {
        private final AbstractC5284Ir3 a;
        private final InterfaceC9173Yu3 b;
        final /* synthetic */ AbstractC12686f2 c;

        /* renamed from: ir.nasim.f2$a$a, reason: collision with other inner class name */
        static final class C1067a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractC12686f2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1067a(AbstractC12686f2 abstractC12686f2) {
                super(0);
                this.f = abstractC12686f2;
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return AbstractC5518Jr3.b(a.this.a, this.f.b());
            }
        }

        public a(AbstractC12686f2 abstractC12686f2, AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC12686f2, "this$0");
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            this.c = abstractC12686f2;
            this.a = abstractC5284Ir3;
            this.b = AbstractC13269fw3.b(EnumC4870Gx3.b, new C1067a(abstractC12686f2));
        }

        private final List g() {
            return (List) this.b.getValue();
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public InterfaceC13882gy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            return this.c.a(abstractC5284Ir3);
        }

        @Override // ir.nasim.InterfaceC13882gy7
        /* renamed from: d */
        public MU0 t() {
            return this.c.t();
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return this.c.e();
        }

        public boolean equals(Object obj) {
            return this.c.equals(obj);
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            List parameters = this.c.getParameters();
            AbstractC13042fc3.h(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public List b() {
            return g();
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public AbstractC19738qr3 n() {
            AbstractC19738qr3 abstractC19738qr3N = this.c.n();
            AbstractC13042fc3.h(abstractC19738qr3N, "this@AbstractTypeConstructor.builtIns");
            return abstractC19738qr3N;
        }

        public String toString() {
            return this.c.toString();
        }
    }

    /* renamed from: ir.nasim.f2$b */
    private static final class b {
        private final Collection a;
        private List b;

        public b(Collection collection) {
            AbstractC13042fc3.i(collection, "allSupertypes");
            this.a = collection;
            this.b = AbstractC9766aX0.e(AbstractC14230ha2.c);
        }

        public final Collection a() {
            return this.a;
        }

        public final List b() {
            return this.b;
        }

        public final void c(List list) {
            AbstractC13042fc3.i(list, "<set-?>");
            this.b = list;
        }
    }

    /* renamed from: ir.nasim.f2$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(AbstractC12686f2.this.h());
        }
    }

    /* renamed from: ir.nasim.f2$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final b a(boolean z) {
            return new b(AbstractC9766aX0.e(AbstractC14230ha2.c));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Boolean) obj).booleanValue());
        }
    }

    /* renamed from: ir.nasim.f2$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {

        /* renamed from: ir.nasim.f2$e$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC12686f2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC12686f2 abstractC12686f2) {
                super(1);
                this.e = abstractC12686f2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable invoke(InterfaceC13882gy7 interfaceC13882gy7) {
                AbstractC13042fc3.i(interfaceC13882gy7, "it");
                return this.e.g(interfaceC13882gy7, true);
            }
        }

        /* renamed from: ir.nasim.f2$e$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC12686f2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(AbstractC12686f2 abstractC12686f2) {
                super(1);
                this.e = abstractC12686f2;
            }

            public final void a(AbstractC4099Dr3 abstractC4099Dr3) {
                AbstractC13042fc3.i(abstractC4099Dr3, "it");
                this.e.p(abstractC4099Dr3);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC4099Dr3) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.f2$e$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC12686f2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(AbstractC12686f2 abstractC12686f2) {
                super(1);
                this.e = abstractC12686f2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable invoke(InterfaceC13882gy7 interfaceC13882gy7) {
                AbstractC13042fc3.i(interfaceC13882gy7, "it");
                return this.e.g(interfaceC13882gy7, false);
            }
        }

        /* renamed from: ir.nasim.f2$e$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC12686f2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(AbstractC12686f2 abstractC12686f2) {
                super(1);
                this.e = abstractC12686f2;
            }

            public final void a(AbstractC4099Dr3 abstractC4099Dr3) {
                AbstractC13042fc3.i(abstractC4099Dr3, "it");
                this.e.q(abstractC4099Dr3);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC4099Dr3) obj);
                return C19938rB7.a;
            }
        }

        e() {
            super(1);
        }

        public final void a(b bVar) {
            AbstractC13042fc3.i(bVar, "supertypes");
            List listA = AbstractC12686f2.this.l().a(AbstractC12686f2.this, bVar.a(), new c(AbstractC12686f2.this), new d(AbstractC12686f2.this));
            if (listA.isEmpty()) {
                AbstractC4099Dr3 abstractC4099Dr3I = AbstractC12686f2.this.i();
                List listE = abstractC4099Dr3I == null ? null : AbstractC9766aX0.e(abstractC4099Dr3I);
                if (listE == null) {
                    listE = AbstractC10360bX0.m();
                }
                listA = listE;
            }
            if (AbstractC12686f2.this.k()) {
                M17 m17L = AbstractC12686f2.this.l();
                AbstractC12686f2 abstractC12686f2 = AbstractC12686f2.this;
                m17L.a(abstractC12686f2, listA, new a(abstractC12686f2), new b(AbstractC12686f2.this));
            }
            AbstractC12686f2 abstractC12686f22 = AbstractC12686f2.this;
            List listM1 = listA instanceof List ? (List) listA : null;
            if (listM1 == null) {
                listM1 = AbstractC15401jX0.m1(listA);
            }
            bVar.c(abstractC12686f22.o(listM1));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((b) obj);
            return C19938rB7.a;
        }
    }

    public AbstractC12686f2(ON6 on6) {
        AbstractC13042fc3.i(on6, "storageManager");
        this.a = on6.h(new c(), d.e, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection g(InterfaceC13882gy7 interfaceC13882gy7, boolean z) {
        AbstractC12686f2 abstractC12686f2 = interfaceC13882gy7 instanceof AbstractC12686f2 ? (AbstractC12686f2) interfaceC13882gy7 : null;
        List listR0 = abstractC12686f2 != null ? AbstractC15401jX0.R0(((b) abstractC12686f2.a.invoke()).a(), abstractC12686f2.j(z)) : null;
        if (listR0 != null) {
            return listR0;
        }
        Collection collectionB = interfaceC13882gy7.b();
        AbstractC13042fc3.h(collectionB, "supertypes");
        return collectionB;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public InterfaceC13882gy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new a(this, abstractC5284Ir3);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: d */
    public abstract MU0 t();

    protected abstract Collection h();

    protected abstract AbstractC4099Dr3 i();

    protected Collection j(boolean z) {
        return AbstractC10360bX0.m();
    }

    protected boolean k() {
        return this.b;
    }

    protected abstract M17 l();

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public List b() {
        return ((b) this.a.invoke()).b();
    }

    protected List o(List list) {
        AbstractC13042fc3.i(list, "supertypes");
        return list;
    }

    protected void p(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
    }

    protected void q(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
    }
}
