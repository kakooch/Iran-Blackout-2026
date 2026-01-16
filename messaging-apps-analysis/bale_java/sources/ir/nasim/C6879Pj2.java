package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C17448mz0;
import ir.nasim.core.modules.settings.SettingsModule;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Pj2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6879Pj2 {
    public static final C6879Pj2 a = new C6879Pj2();
    private static final InterfaceC20315ro1 b;
    private static InterfaceC13730gj3 c;
    private static final SettingsModule d;
    private static final InterfaceC9336Zm4 e;
    private static XV4 f;
    private static final InterfaceC17639nJ0 g;
    private static final InterfaceC4557Fq2 h;
    private static long i;
    private static boolean j;
    private static boolean k;
    private static SA2 l;
    public static final int m;

    /* renamed from: ir.nasim.Pj2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return (C17448mz0) this.c;
        }

        public final Object n(C17448mz0 c17448mz0, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
            aVar.c = c17448mz0;
            return aVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((C17448mz0) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.Pj2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ boolean c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = ((Boolean) obj).booleanValue();
            return bVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                boolean z = this.c;
                C19406qI3.a("FeedbackManager", "observed calculated STATE is " + z + " and currentCllConditions is " + C6879Pj2.f.e() + Separators.SP + C6879Pj2.f.f(), new Object[0]);
                InterfaceC17639nJ0 interfaceC17639nJ0 = C6879Pj2.g;
                Boolean boolA = AbstractC6392Nk0.a(z);
                this.b = 1;
                if (interfaceC17639nJ0.o(boolA, this) == objE) {
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

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pj2$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C17448mz0.a.values().length];
            try {
                iArr[C17448mz0.a.o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C17448mz0.a.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C17448mz0.a.n.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Pj2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Pj2$d$a */
        static final class a implements InterfaceC4806Gq2 {
            public static final a a = new a();

            a() {
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).doubleValue(), interfaceC20295rm1);
            }

            public final Object b(double d, InterfaceC20295rm1 interfaceC20295rm1) {
                C6879Pj2.f = AbstractC4616Fw7.a(C6879Pj2.f.e(), AbstractC6392Nk0.a(d > 30.0d));
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4A = C18039nz0.a.a();
                a aVar = a.a;
                this.b = 1;
                if (interfaceC9336Zm4A.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pj2$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Pj2$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Pj2$e$a$a, reason: collision with other inner class name */
            public static final class C0581a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0581a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C6879Pj2.e.a.C0581a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Pj2$e$a$a r0 = (ir.nasim.C6879Pj2.e.a.C0581a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Pj2$e$a$a r0 = new ir.nasim.Pj2$e$a$a
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
                    r2 = r5
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    r2 = r2 ^ r3
                    if (r2 == 0) goto L49
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6879Pj2.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Pj2$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Pj2$f$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Pj2$f$a$a, reason: collision with other inner class name */
            public static final class C0582a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0582a(InterfaceC20295rm1 interfaceC20295rm1) {
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

            /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    Method dump skipped, instructions count: 309
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6879Pj2.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static {
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(C12366eV1.a().X(P17.b(null, 1, null)));
        b = interfaceC20315ro1A;
        d = ((InterfaceC9291Zh4) C92.a(C5721Ko.a.d(), InterfaceC9291Zh4.class)).b1();
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        e = interfaceC9336Zm4A;
        f = AbstractC4616Fw7.a(bool, bool);
        InterfaceC17639nJ0 interfaceC17639nJ0B = DJ0.b(2, null, null, 6, null);
        g = interfaceC17639nJ0B;
        h = AbstractC6459Nq2.f0(interfaceC17639nJ0B);
        AbstractC6459Nq2.o0(AbstractC6459Nq2.b0(AbstractC6459Nq2.w(new f(AbstractC6459Nq2.S(AbstractC6459Nq2.x(C18039nz0.a.h(), new UA2() { // from class: ir.nasim.Nj2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6879Pj2.c((C17448mz0) obj);
            }
        }), new e(interfaceC9336Zm4A), new a(null))), new InterfaceC14603iB2() { // from class: ir.nasim.Oj2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(C6879Pj2.d(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue()));
            }
        }), new b(null)), interfaceC20315ro1A, InterfaceC16863lz6.a.c(), bool);
        i = -1L;
        m = 8;
    }

    private C6879Pj2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17448mz0.a c(C17448mz0 c17448mz0) {
        AbstractC13042fc3.i(c17448mz0, "it");
        return c17448mz0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(boolean z, boolean z2) {
        return z == z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 q() {
        return AbstractC10533bm0.d(b, null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(AbstractC7031Pz0 abstractC7031Pz0) {
        k = abstractC7031Pz0 instanceof AbstractC7031Pz0.k ? ((AbstractC7031Pz0.k) abstractC7031Pz0).b() : abstractC7031Pz0 instanceof AbstractC7031Pz0.i ? ((AbstractC7031Pz0.i) abstractC7031Pz0).b() : false;
    }

    public final InterfaceC4557Fq2 p() {
        return h;
    }

    public final void r() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = e;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
    }

    public final void s(String str, int i2) {
        AbstractC13042fc3.i(str, "opinion");
        AbstractC5969Lp4.d().Y().X().U(i, str, j, i2, k);
        SA2 sa2 = l;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void t(SA2 sa2) {
        l = sa2;
    }
}
