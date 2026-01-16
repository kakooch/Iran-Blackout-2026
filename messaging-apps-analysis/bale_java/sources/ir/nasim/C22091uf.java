package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC16345l7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.HashSet;
import java.util.List;

/* renamed from: ir.nasim.uf, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22091uf {
    public static final a p = new a(null);
    public static final int q = 8;
    private static final HashSet r = AbstractC4597Fu6.e(270066638, 11, 10);
    private final C6071Mb a;
    private final C6287Mz b;
    private final C9615aG2 c;
    private final C18656p16 d;
    private final C14970in2 e;
    private final C10299bQ2 f;
    private final SA2 g;
    private final AbstractC13778go1 h;
    private int i;
    private long j;
    private long k;
    private long l;
    private int m;
    private InterfaceC20315ro1 n;
    private boolean o;

    /* renamed from: ir.nasim.uf$a */
    public static final class a {
        private a() {
        }

        public final HashSet a() {
            return C22091uf.r;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uf$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC16345l7.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC16345l7.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22091uf.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9615aG2 c9615aG2 = C22091uf.this.c;
                String strF = this.d.f();
                this.b = 1;
                obj = c9615aG2.e(strF, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.uf$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.uf$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.uf$c$a$a, reason: collision with other inner class name */
            public static final class C1637a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1637a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C22091uf.c.a.C1637a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.uf$c$a$a r0 = (ir.nasim.C22091uf.c.a.C1637a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.uf$c$a$a r0 = new ir.nasim.uf$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.util.List r5 = (java.util.List) r5
                    boolean r5 = r5.isEmpty()
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22091uf.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uf$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.uf$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C22091uf a;

            /* renamed from: ir.nasim.uf$d$a$a, reason: collision with other inner class name */
            static final class C1638a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C1638a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C22091uf c22091uf) {
                this.a = c22091uf;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C19938rB7 r4, ir.nasim.InterfaceC20295rm1 r5) {
                /*
                    r3 = this;
                    boolean r4 = r5 instanceof ir.nasim.C22091uf.d.a.C1638a
                    if (r4 == 0) goto L13
                    r4 = r5
                    ir.nasim.uf$d$a$a r4 = (ir.nasim.C22091uf.d.a.C1638a) r4
                    int r0 = r4.d
                    r1 = -2147483648(0xffffffff80000000, float:-0.0)
                    r2 = r0 & r1
                    if (r2 == 0) goto L13
                    int r0 = r0 - r1
                    r4.d = r0
                    goto L18
                L13:
                    ir.nasim.uf$d$a$a r4 = new ir.nasim.uf$d$a$a
                    r4.<init>(r5)
                L18:
                    java.lang.Object r5 = r4.b
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r4.d
                    r2 = 1
                    if (r1 == 0) goto L35
                    if (r1 != r2) goto L2d
                    java.lang.Object r4 = r4.a
                    ir.nasim.uf$d$a r4 = (ir.nasim.C22091uf.d.a) r4
                    ir.nasim.AbstractC10685c16.b(r5)
                    goto L4a
                L2d:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L35:
                    ir.nasim.AbstractC10685c16.b(r5)
                    ir.nasim.uf r5 = r3.a
                    ir.nasim.Mb r5 = ir.nasim.C22091uf.c(r5)
                    r4.a = r3
                    r4.d = r2
                    java.lang.Object r4 = r5.b(r4)
                    if (r4 != r0) goto L49
                    return r0
                L49:
                    r4 = r3
                L4a:
                    ir.nasim.uf r4 = r4.a
                    boolean r5 = ir.nasim.C22091uf.g(r4)
                    if (r5 == 0) goto L54
                    r5 = -1
                    goto L55
                L54:
                    r5 = 0
                L55:
                    ir.nasim.C22091uf.h(r4, r5)
                    ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22091uf.d.a.a(ir.nasim.rB7, ir.nasim.rm1):java.lang.Object");
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22091uf.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(C22091uf.this.l, 0L, null, null, 12, null));
                a aVar = new a(C22091uf.this);
                this.b = 1;
                if (interfaceC4557Fq2R.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.uf$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC16345l7.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC16345l7.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22091uf.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18656p16 c18656p16 = C22091uf.this.d;
                FileReference fileReferenceE = this.d.e();
                InterfaceC20315ro1 interfaceC20315ro1 = C22091uf.this.n;
                this.b = 1;
                obj = c18656p16.b(fileReferenceE, interfaceC20315ro1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22091uf(C6071Mb c6071Mb, C6287Mz c6287Mz, C9615aG2 c9615aG2, C18656p16 c18656p16, SettingsModule settingsModule, C14970in2 c14970in2, C10299bQ2 c10299bQ2, SA2 sa2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6071Mb, "dataSource");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c9615aG2, "getLinkActionUseCase");
        AbstractC13042fc3.i(c18656p16, "retrieveCustomAdImageUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(sa2, "currentTimeMillis");
        AbstractC13042fc3.i(abstractC13778go1, "coroutineDispatcher");
        this.a = c6071Mb;
        this.b = c6287Mz;
        this.c = c9615aG2;
        this.d = c18656p16;
        this.e = c14970in2;
        this.f = c10299bQ2;
        this.g = sa2;
        this.h = abstractC13778go1;
        this.k = 90000L;
        this.l = 300000L;
        this.m = 1;
        this.n = AbstractC20906so1.a(abstractC13778go1);
        if (C8386Vt0.u8() || C8386Vt0.D5()) {
            return;
        }
        this.k = settingsModule.N1() * 1000;
        this.l = settingsModule.M1() * 1000;
        l();
    }

    private final void i(AbstractC16345l7.a aVar) {
        if (aVar.a() == null) {
            aVar.k(AbstractC10533bm0.b(this.n, null, null, new b(aVar, null), 3, null));
            int size = ((List) this.a.a().getValue()).size();
            List list = (List) this.a.a().getValue();
            q((AbstractC16345l7.a) list.get(this.i));
            q((AbstractC16345l7.a) list.get((this.i + 1) % size));
            q((AbstractC16345l7.a) list.get((this.i + 2) % size));
        }
    }

    private final void l() {
        AbstractC10533bm0.d(this.n, null, null, new d(null), 3, null);
        this.m = 1;
        this.j = ((Number) this.g.invoke()).longValue();
    }

    private final AbstractC16345l7.a m() {
        AbstractC16345l7.a aVar = (AbstractC16345l7.a) ((List) this.a.a().getValue()).get(n());
        i(aVar);
        return aVar;
    }

    private final int n() {
        if (((List) this.a.a().getValue()).isEmpty()) {
            return 0;
        }
        int i = this.i + 1;
        this.i = i;
        int size = i % ((List) this.a.a().getValue()).size();
        this.i = size;
        return size;
    }

    private final void q(AbstractC16345l7.a aVar) {
        if (aVar.d() != null) {
            return;
        }
        aVar.l(AbstractC10533bm0.b(this.n, null, null, new e(aVar, null), 3, null));
    }

    public final AbstractC16345l7 j(boolean z) {
        if (((List) this.a.a().getValue()).isEmpty()) {
            return AbstractC16345l7.b.a;
        }
        if (!this.o) {
            this.o = true;
            this.j = ((Number) this.g.invoke()).longValue();
            Object objQ0 = AbstractC15401jX0.q0((List) this.a.a().getValue());
            i((AbstractC16345l7.a) objQ0);
            return (AbstractC16345l7) objQ0;
        }
        long jLongValue = ((Number) this.g.invoke()).longValue() - this.j;
        if (z && this.m == 1) {
            this.m = 2;
            return null;
        }
        if (z && this.m == 2) {
            this.j = ((Number) this.g.invoke()).longValue();
            this.m = 1;
            return m();
        }
        if (jLongValue < this.k) {
            return null;
        }
        this.j = ((Number) this.g.invoke()).longValue();
        this.m = 1;
        return m();
    }

    public final InterfaceC10258bL6 k() {
        return AbstractC6459Nq2.o0(new c(this.a.a()), this.n, InterfaceC16863lz6.a.c(), Boolean.TRUE);
    }

    public final void o(String str) {
        AbstractC13042fc3.i(str, "id");
        this.f.g1(str);
    }

    public final void p(String str) {
        AbstractC13042fc3.i(str, "id");
        this.f.i1(str, null);
    }
}
