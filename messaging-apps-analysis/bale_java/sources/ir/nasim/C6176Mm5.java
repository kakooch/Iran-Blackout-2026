package ir.nasim;

import ai.bale.proto.PremiumOuterClass$ResponseIsPremium;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19670qk5;

/* renamed from: ir.nasim.Mm5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6176Mm5 implements InterfaceC5943Lm5 {
    private static final a d = new a(null);
    private static final AbstractC19670qk5.a e = AbstractC21557tk5.a("IS_PREMIUM_FEATURE_ARG");
    private static final AbstractC19670qk5.a f = AbstractC21557tk5.e("PREMIUM_REMAIN_FEATURE_ARG");
    private static final AbstractC19670qk5.a g = AbstractC21557tk5.e("MY_BADGE_ID_ARG");
    private static final AbstractC19670qk5.a h = AbstractC21557tk5.f("MY_BADGE_URL_ARG");
    private final C5709Km5 a;
    private final InterfaceC20728sW b;
    private final InterfaceC23475wz1 c;

    /* renamed from: ir.nasim.Mm5$a */
    private static final class a {
        private a() {
        }

        public final AbstractC19670qk5.a a() {
            return C6176Mm5.e;
        }

        public final AbstractC19670qk5.a b() {
            return C6176Mm5.g;
        }

        public final AbstractC19670qk5.a c() {
            return C6176Mm5.h;
        }

        public final AbstractC19670qk5.a d() {
            return C6176Mm5.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Mm5$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = C6176Mm5.this.i(0L, null, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    /* renamed from: ir.nasim.Mm5$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        int d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C6176Mm5.this.d(0L, null, 0, this);
        }
    }

    /* renamed from: ir.nasim.Mm5$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C6176Mm5.this.f(this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.Mm5$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C6176Mm5.this.n(0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Mm5$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mm5$f$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mm5$f$a$a, reason: collision with other inner class name */
            public static final class C0503a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0503a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C6176Mm5.f.a.C0503a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Mm5$f$a$a r0 = (ir.nasim.C6176Mm5.f.a.C0503a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mm5$f$a$a r0 = new ir.nasim.Mm5$f$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.Jk5 r5 = (ir.nasim.C5457Jk5) r5
                    if (r5 == 0) goto L45
                    byte[] r5 = r5.b()
                    if (r5 == 0) goto L45
                    java.lang.String r5 = ir.nasim.AbstractC14836iZ6.A(r5)
                    goto L46
                L45:
                    r5 = 0
                L46:
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    /* renamed from: ir.nasim.Mm5$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objM = C6176Mm5.this.m(this);
            return objM == AbstractC14862ic3.e() ? objM : C9475a16.a(objM);
        }
    }

    /* renamed from: ir.nasim.Mm5$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objK = C6176Mm5.this.k(0, false, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    /* renamed from: ir.nasim.Mm5$i */
    static final class i extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C6176Mm5.this.e(null, false, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.Mm5$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C6176Mm5.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Mm5$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ PremiumOuterClass$ResponseIsPremium d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumOuterClass$ResponseIsPremium;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.d, interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.a(), AbstractC6392Nk0.a(this.d.getUserStatus().getIsPremium()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ PremiumOuterClass$ResponseIsPremium d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumOuterClass$ResponseIsPremium;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(this.d, interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.d(), AbstractC6392Nk0.e(this.d.getUserStatus().getExpirationTime()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ PremiumOuterClass$ResponseIsPremium d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumOuterClass$ResponseIsPremium;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = new m(this.d, interfaceC20295rm1);
            mVar.c = obj;
            return mVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.b(), AbstractC6392Nk0.e(this.d.getUserStatus().getDetail().getBadge().getBadgeId()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ PremiumOuterClass$ResponseIsPremium d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumOuterClass$ResponseIsPremium;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = new n(this.d, interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.c(), this.d.getUserStatus().getDetail().getBadge().getMediaUrl());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$o */
    static final class o extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objJ = C6176Mm5.this.j(0L, null, this);
            return objJ == AbstractC14862ic3.e() ? objJ : C9475a16.a(objJ);
        }
    }

    /* renamed from: ir.nasim.Mm5$p */
    static final class p extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C6176Mm5.this.b(0L, null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.Mm5$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = new q(this.d, interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.b(), AbstractC6392Nk0.e(this.d));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            r rVar = new r(this.d, interfaceC20295rm1);
            rVar.c = obj;
            return rVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(C6176Mm5.d.c(), this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mm5$s */
    public static final class s implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mm5$s$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mm5$s$a$a, reason: collision with other inner class name */
            public static final class C0504a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0504a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r9, ir.nasim.InterfaceC20295rm1 r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof ir.nasim.C6176Mm5.s.a.C0504a
                    if (r0 == 0) goto L13
                    r0 = r10
                    ir.nasim.Mm5$s$a$a r0 = (ir.nasim.C6176Mm5.s.a.C0504a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mm5$s$a$a r0 = new ir.nasim.Mm5$s$a$a
                    r0.<init>(r10)
                L18:
                    java.lang.Object r10 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto L5e
                L29:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L31:
                    ir.nasim.AbstractC10685c16.b(r10)
                    ir.nasim.Gq2 r10 = r8.a
                    r2 = r9
                    ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
                    java.lang.Object r4 = r2.e()
                    java.lang.Number r4 = (java.lang.Number) r4
                    long r4 = r4.longValue()
                    r6 = -1
                    int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r4 == 0) goto L5e
                    java.lang.Object r2 = r2.f()
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    int r2 = r2.length()
                    if (r2 <= 0) goto L5e
                    r0.b = r3
                    java.lang.Object r9 = r10.a(r9, r0)
                    if (r9 != r1) goto L5e
                    return r1
                L5e:
                    ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.s.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public s(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mm5$t */
    public static final class t implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mm5$t$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mm5$t$a$a, reason: collision with other inner class name */
            public static final class C0505a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0505a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C6176Mm5.t.a.C0505a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Mm5$t$a$a r0 = (ir.nasim.C6176Mm5.t.a.C0505a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mm5$t$a$a r0 = new ir.nasim.Mm5$t$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L57
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.qk5$a r2 = ir.nasim.C6176Mm5.p()
                    java.lang.Object r5 = r5.b(r2)
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    if (r5 == 0) goto L49
                    boolean r5 = r5.booleanValue()
                    goto L4a
                L49:
                    r5 = 0
                L4a:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L57
                    return r1
                L57:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.t.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public t(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mm5$u */
    public static final class u implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mm5$u$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mm5$u$a$a, reason: collision with other inner class name */
            public static final class C0506a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0506a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C6176Mm5.u.a.C0506a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Mm5$u$a$a r0 = (ir.nasim.C6176Mm5.u.a.C0506a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mm5$u$a$a r0 = new ir.nasim.Mm5$u$a$a
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
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.qk5$a r2 = ir.nasim.C6176Mm5.s()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.u.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public u(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mm5$v */
    public static final class v implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mm5$v$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mm5$v$a$a, reason: collision with other inner class name */
            public static final class C0507a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0507a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C6176Mm5.v.a.C0507a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Mm5$v$a$a r0 = (ir.nasim.C6176Mm5.v.a.C0507a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mm5$v$a$a r0 = new ir.nasim.Mm5$v$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L6a
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.qk5 r7 = (ir.nasim.AbstractC19670qk5) r7
                    ir.nasim.qk5$a r2 = ir.nasim.C6176Mm5.q()
                    java.lang.Object r2 = r7.b(r2)
                    java.lang.Long r2 = (java.lang.Long) r2
                    if (r2 == 0) goto L49
                    long r4 = r2.longValue()
                    goto L4b
                L49:
                    r4 = -1
                L4b:
                    java.lang.Long r2 = ir.nasim.AbstractC6392Nk0.e(r4)
                    ir.nasim.qk5$a r4 = ir.nasim.C6176Mm5.r()
                    java.lang.Object r7 = r7.b(r4)
                    java.lang.String r7 = (java.lang.String) r7
                    if (r7 != 0) goto L5d
                    java.lang.String r7 = ""
                L5d:
                    ir.nasim.XV4 r7 = ir.nasim.AbstractC4616Fw7.a(r2, r7)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L6a
                    return r1
                L6a:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.v.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public v(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C6176Mm5(C5709Km5 c5709Km5, InterfaceC20728sW interfaceC20728sW, InterfaceC23475wz1 interfaceC23475wz1) {
        AbstractC13042fc3.i(c5709Km5, "remoteDataSource");
        AbstractC13042fc3.i(interfaceC20728sW, "badgeDao");
        AbstractC13042fc3.i(interfaceC23475wz1, "dataStore");
        this.a = c5709Km5;
        this.b = interfaceC20728sW;
        this.c = interfaceC23475wz1;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(long r10, java.lang.String r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof ir.nasim.C6176Mm5.p
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.Mm5$p r0 = (ir.nasim.C6176Mm5.p) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.Mm5$p r0 = new ir.nasim.Mm5$p
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L61
            if (r2 == r5) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r10 = r0.a
            ir.nasim.AbstractC10685c16.b(r13)
            goto Laf
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            java.lang.Object r10 = r0.c
            java.lang.Object r11 = r0.b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.a
            ir.nasim.Mm5 r12 = (ir.nasim.C6176Mm5) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L99
        L49:
            long r10 = r0.d
            java.lang.Object r12 = r0.b
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r2 = r0.a
            ir.nasim.Mm5 r2 = (ir.nasim.C6176Mm5) r2
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
            java.lang.Object r13 = r13.l()
            r8 = r13
            r13 = r12
            r12 = r2
            r2 = r8
            goto L78
        L61:
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.Km5 r13 = r9.a
            r0.a = r9
            r0.b = r12
            r0.d = r10
            r0.g = r5
            java.lang.Object r13 = r13.i(r10, r0)
            if (r13 != r1) goto L75
            return r1
        L75:
            r2 = r13
            r13 = r12
            r12 = r9
        L78:
            boolean r5 = ir.nasim.C9475a16.j(r2)
            if (r5 == 0) goto Lb0
            r5 = r2
            ir.nasim.rB7 r5 = (ir.nasim.C19938rB7) r5
            ir.nasim.wz1 r5 = r12.c
            ir.nasim.Mm5$q r7 = new ir.nasim.Mm5$q
            r7.<init>(r10, r6)
            r0.a = r12
            r0.b = r13
            r0.c = r2
            r0.g = r4
            java.lang.Object r10 = ir.nasim.AbstractC22147uk5.a(r5, r7, r0)
            if (r10 != r1) goto L97
            return r1
        L97:
            r11 = r13
            r10 = r2
        L99:
            ir.nasim.wz1 r12 = r12.c
            ir.nasim.Mm5$r r13 = new ir.nasim.Mm5$r
            r13.<init>(r11, r6)
            r0.a = r10
            r0.b = r6
            r0.c = r6
            r0.g = r3
            java.lang.Object r11 = ir.nasim.AbstractC22147uk5.a(r12, r13, r0)
            if (r11 != r1) goto Laf
            return r1
        Laf:
            r2 = r10
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.b(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5943Lm5
    public InterfaceC4557Fq2 c() {
        return AbstractC6459Nq2.v(AbstractC6459Nq2.F(new u(this.c.getData())));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(long r11, java.lang.String r13, int r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof ir.nasim.C6176Mm5.c
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.Mm5$c r0 = (ir.nasim.C6176Mm5.c) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.Mm5$c r0 = new ir.nasim.Mm5$c
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r15)
            goto Lb4
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            int r11 = r0.d
            long r12 = r0.c
            java.lang.Object r14 = r0.b
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.a
            ir.nasim.Mm5 r2 = (ir.nasim.C6176Mm5) r2
            ir.nasim.AbstractC10685c16.b(r15)
            r8 = r11
            r5 = r12
            r7 = r14
            goto L9b
        L4b:
            int r14 = r0.d
            long r11 = r0.c
            java.lang.Object r13 = r0.b
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.a
            ir.nasim.Mm5 r2 = (ir.nasim.C6176Mm5) r2
            ir.nasim.AbstractC10685c16.b(r15)
            goto L72
        L5b:
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.sW r15 = r10.b
            r0.a = r10
            r0.b = r13
            r0.c = r11
            r0.d = r14
            r0.g = r5
            java.lang.Object r15 = r15.a(r11, r13, r0)
            if (r15 != r1) goto L71
            return r1
        L71:
            r2 = r10
        L72:
            ir.nasim.Jk5 r15 = (ir.nasim.C5457Jk5) r15
            if (r15 == 0) goto L85
            byte[] r5 = r15.b()
            if (r5 == 0) goto L85
            byte[] r15 = r15.b()
            if (r15 == 0) goto Lb4
            int r15 = r15.length
            if (r15 != 0) goto Lb4
        L85:
            ir.nasim.Km5 r15 = r2.a
            r0.a = r2
            r0.b = r13
            r0.c = r11
            r0.d = r14
            r0.g = r4
            java.lang.Object r15 = r15.c(r13, r0)
            if (r15 != r1) goto L98
            return r1
        L98:
            r5 = r11
            r7 = r13
            r8 = r14
        L9b:
            r9 = r15
            byte[] r9 = (byte[]) r9
            ir.nasim.sW r11 = r2.b
            ir.nasim.Jk5 r12 = new ir.nasim.Jk5
            r4 = r12
            r4.<init>(r5, r7, r8, r9)
            r13 = 0
            r0.a = r13
            r0.b = r13
            r0.g = r3
            java.lang.Object r11 = r11.c(r12, r0)
            if (r11 != r1) goto Lb4
            return r1
        Lb4:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.d(long, java.lang.String, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f4, code lost:
    
        r5 = r2;
        r2 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ed -> B:33:0x00f0). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.util.List r13, boolean r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.e(java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C6176Mm5.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.Mm5$d r0 = (ir.nasim.C6176Mm5.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mm5$d r0 = new ir.nasim.Mm5$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.Km5 r5 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.d(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.f(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5943Lm5
    public InterfaceC4557Fq2 g() {
        return AbstractC6459Nq2.v(new t(this.c.getData()));
    }

    @Override // ir.nasim.InterfaceC5943Lm5
    public InterfaceC4557Fq2 h() {
        return AbstractC6459Nq2.v(new s(new v(this.c.getData())));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(long r5, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C6176Mm5.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Mm5$b r0 = (ir.nasim.C6176Mm5.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mm5$b r0 = new ir.nasim.Mm5$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Km5 r8 = r4.a
            r0.c = r3
            java.lang.Object r5 = r8.b(r5, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.i(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(long r5, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C6176Mm5.o
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Mm5$o r0 = (ir.nasim.C6176Mm5.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mm5$o r0 = new ir.nasim.Mm5$o
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Km5 r8 = r4.a
            r0.c = r3
            java.lang.Object r5 = r8.h(r5, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.j(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(int r8, boolean r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ir.nasim.C6176Mm5.h
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.Mm5$h r0 = (ir.nasim.C6176Mm5.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Mm5$h r0 = new ir.nasim.Mm5$h
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L49
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r6.a
            ir.nasim.AbstractC10685c16.b(r10)
            goto Lc1
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r6.a
            ir.nasim.Mm5 r8 = (ir.nasim.C6176Mm5) r8
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r9 = r10.l()
            r1 = r8
            r8 = r9
            goto L5a
        L49:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Km5 r10 = r7.a
            r6.a = r7
            r6.d = r3
            java.lang.Object r8 = r10.f(r8, r9, r6)
            if (r8 != r0) goto L59
            return r0
        L59:
            r1 = r7
        L5a:
            boolean r9 = ir.nasim.C9475a16.j(r8)
            if (r9 == 0) goto Lc1
            r9 = r8
            ai.bale.proto.PremiumOuterClass$ResponseIsPremium r9 = (ai.bale.proto.PremiumOuterClass$ResponseIsPremium) r9
            ai.bale.proto.PremiumStruct$UserPremiumStatus r10 = r9.getUserStatus()
            boolean r10 = r10.hasDetail()
            if (r10 == 0) goto Lc1
            ai.bale.proto.PremiumStruct$UserPremiumStatus r10 = r9.getUserStatus()
            ai.bale.proto.PremiumStruct$UserPremiumDetail r10 = r10.getDetail()
            boolean r10 = r10.hasBadge()
            if (r10 == 0) goto Lc1
            ai.bale.proto.PremiumStruct$UserPremiumStatus r10 = r9.getUserStatus()
            ai.bale.proto.PremiumStruct$UserPremiumDetail r10 = r10.getDetail()
            ai.bale.proto.PremiumStruct$Badge r10 = r10.getBadge()
            long r3 = r10.getBadgeId()
            ai.bale.proto.PremiumStruct$UserPremiumStatus r10 = r9.getUserStatus()
            ai.bale.proto.PremiumStruct$UserPremiumDetail r10 = r10.getDetail()
            ai.bale.proto.PremiumStruct$Badge r10 = r10.getBadge()
            java.lang.String r10 = r10.getMediaUrl()
            java.lang.String r5 = "getMediaUrl(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r5)
            ai.bale.proto.PremiumStruct$UserPremiumStatus r9 = r9.getUserStatus()
            ai.bale.proto.PremiumStruct$UserPremiumDetail r9 = r9.getDetail()
            ai.bale.proto.PremiumStruct$Badge r9 = r9.getBadge()
            ir.nasim.Dn5 r9 = r9.getMediaFormat()
            int r5 = r9.getNumber()
            r6.a = r8
            r6.d = r2
            r2 = r3
            r4 = r10
            java.lang.Object r9 = r1.d(r2, r4, r5, r6)
            if (r9 != r0) goto Lc1
            return r0
        Lc1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.k(int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5943Lm5
    public InterfaceC4557Fq2 l(long j2, String str) {
        AbstractC13042fc3.i(str, "url");
        return new f(this.b.b(j2, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C6176Mm5.g
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.Mm5$g r0 = (ir.nasim.C6176Mm5.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mm5$g r0 = new ir.nasim.Mm5$g
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.Km5 r5 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.e(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.m(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC5943Lm5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(long r5, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C6176Mm5.e
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Mm5$e r0 = (ir.nasim.C6176Mm5.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mm5$e r0 = new ir.nasim.Mm5$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.sW r8 = r4.b
            r0.c = r3
            java.lang.Object r8 = r8.a(r5, r7, r0)
            if (r8 != r1) goto L3f
            return r1
        L3f:
            ir.nasim.Jk5 r8 = (ir.nasim.C5457Jk5) r8
            if (r8 == 0) goto L4e
            byte[] r5 = r8.b()
            if (r5 == 0) goto L4e
            java.lang.String r5 = ir.nasim.AbstractC14836iZ6.A(r5)
            goto L4f
        L4e:
            r5 = 0
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6176Mm5.n(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
