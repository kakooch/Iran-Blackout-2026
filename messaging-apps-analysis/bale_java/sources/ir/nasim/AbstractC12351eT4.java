package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.eT4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12351eT4 {

    /* renamed from: ir.nasim.eT4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ HT4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ float i;
        final /* synthetic */ TS4 j;
        final /* synthetic */ InterfaceC12529em.c k;
        final /* synthetic */ InterfaceC7645Sp2 l;
        final /* synthetic */ UA2 m;
        final /* synthetic */ boolean n;
        final /* synthetic */ InterfaceC16978mB2 o;
        final /* synthetic */ int p;
        final /* synthetic */ int q;
        final /* synthetic */ int r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, androidx.compose.ui.e eVar, HT4 ht4, boolean z, float f, TS4 ts4, InterfaceC12529em.c cVar, InterfaceC7645Sp2 interfaceC7645Sp2, UA2 ua2, boolean z2, InterfaceC16978mB2 interfaceC16978mB2, int i2, int i3, int i4) {
            super(2);
            this.e = i;
            this.f = eVar;
            this.g = ht4;
            this.h = z;
            this.i = f;
            this.j = ts4;
            this.k = cVar;
            this.l = interfaceC7645Sp2;
            this.m = ua2;
            this.n = z2;
            this.o = interfaceC16978mB2;
            this.p = i2;
            this.q = i3;
            this.r = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC12351eT4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, interfaceC22053ub1, this.p | 1, this.q, this.r);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.eT4$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC7645Sp2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC7645Sp2 interfaceC7645Sp2) {
            super(0);
            this.e = interfaceC7645Sp2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            InterfaceC7645Sp2 interfaceC7645Sp2 = this.e;
            IG6 ig6 = interfaceC7645Sp2 instanceof IG6 ? (IG6) interfaceC7645Sp2 : null;
            if (ig6 != null) {
                return ig6.m();
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.eT4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HT4 c;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(HT4 ht4, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ht4;
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            HT4 ht4 = this.c;
            ht4.w(AbstractC23053wG5.e(Math.min(this.d - 1, ht4.k()), 0));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eT4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HT4 c;

        /* renamed from: ir.nasim.eT4$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ HT4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(HT4 ht4) {
                super(0);
                this.e = ht4;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(this.e.c());
            }
        }

        /* renamed from: ir.nasim.eT4$d$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ HT4 a;

            b(HT4 ht4) {
                this.a = ht4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.s();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.eT4$d$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.eT4$d$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.eT4$d$c$a$a, reason: collision with other inner class name */
                public static final class C1053a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1053a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC12351eT4.d.c.a.C1053a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.eT4$d$c$a$a r0 = (ir.nasim.AbstractC12351eT4.d.c.a.C1053a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.eT4$d$c$a$a r0 = new ir.nasim.eT4$d$c$a$a
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
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12351eT4.d.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(HT4 ht4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ht4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Y = AbstractC6459Nq2.y(new c(AbstractC10222bH6.r(new a(this.c))), 1);
                b bVar = new b(this.c);
                this.b = 1;
                if (interfaceC4557Fq2Y.b(bVar, this) == objE) {
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

    /* renamed from: ir.nasim.eT4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HT4 c;

        /* renamed from: ir.nasim.eT4$e$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ HT4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(HT4 ht4) {
                super(0);
                this.e = ht4;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                InterfaceC7948Tw3 interfaceC7948Tw3P = this.e.p();
                if (interfaceC7948Tw3P != null) {
                    return Integer.valueOf(interfaceC7948Tw3P.getIndex());
                }
                return null;
            }
        }

        /* renamed from: ir.nasim.eT4$e$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ HT4 a;

            b(HT4 ht4) {
                this.a = ht4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.A();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(HT4 ht4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ht4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC10222bH6.r(new a(this.c)));
                b bVar = new b(this.c);
                this.b = 1;
                if (interfaceC4557Fq2V.b(bVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eT4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WH1 c;
        final /* synthetic */ HT4 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(WH1 wh1, HT4 ht4, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = wh1;
            this.d = ht4;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.d.y(this.c.B0(this.e));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eT4$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ C22083ue1 g;
        final /* synthetic */ InterfaceC16978mB2 h;
        final /* synthetic */ C23169wT4 i;
        final /* synthetic */ int j;

        /* renamed from: ir.nasim.eT4$g$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ C22083ue1 e;
            final /* synthetic */ InterfaceC16978mB2 f;
            final /* synthetic */ C23169wT4 g;
            final /* synthetic */ int h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22083ue1 c22083ue1, InterfaceC16978mB2 interfaceC16978mB2, C23169wT4 c23169wT4, int i) {
                super(4);
                this.e = c22083ue1;
                this.f = interfaceC16978mB2;
                this.g = c23169wT4;
                this.h = i;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 14) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i3 & 731) == 146 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(1889356237, i3, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:386)");
                }
                androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(InterfaceC6988Pv3.c(interfaceC6988Pv3, androidx.compose.ui.input.nestedscroll.a.b(androidx.compose.ui.e.a, this.e, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                InterfaceC16978mB2 interfaceC16978mB2 = this.f;
                C23169wT4 c23169wT4 = this.g;
                int i4 = this.h;
                interfaceC22053ub1.A(733328855);
                InterfaceC10970cW3 interfaceC10970cW3I = androidx.compose.foundation.layout.f.i(InterfaceC12529em.a.o(), false, interfaceC22053ub1, 0);
                interfaceC22053ub1.A(-1323940314);
                WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
                EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1.H(AbstractC13040fc1.n());
                InterfaceC18354oW7 interfaceC18354oW7 = (InterfaceC18354oW7) interfaceC22053ub1.H(AbstractC13040fc1.u());
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                InterfaceC15796kB2 interfaceC15796kB2C = AbstractC19768qu3.c(eVarE);
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                interfaceC22053ub1.J();
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3I, aVar.e());
                DG7.c(interfaceC22053ub1A, wh1, aVar.c());
                DG7.c(interfaceC22053ub1A, enumC12613eu3, aVar.d());
                DG7.c(interfaceC22053ub1A, interfaceC18354oW7, aVar.h());
                interfaceC22053ub1.d();
                interfaceC15796kB2C.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1)), interfaceC22053ub1, 0);
                interfaceC22053ub1.A(2058660585);
                interfaceC22053ub1.A(-2137368960);
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC16978mB2.e(c23169wT4, Integer.valueOf(i), interfaceC22053ub1, Integer.valueOf((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896)));
                interfaceC22053ub1.U();
                interfaceC22053ub1.U();
                interfaceC22053ub1.u();
                interfaceC22053ub1.U();
                interfaceC22053ub1.U();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, UA2 ua2, C22083ue1 c22083ue1, InterfaceC16978mB2 interfaceC16978mB2, C23169wT4 c23169wT4, int i2) {
            super(1);
            this.e = i;
            this.f = ua2;
            this.g = c22083ue1;
            this.h = interfaceC16978mB2;
            this.i = c23169wT4;
            this.j = i2;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            InterfaceC15069ix3.g(interfaceC15069ix3, this.e, this.f, null, AbstractC19242q11.c(1889356237, true, new a(this.g, this.h, this.i, this.j)), 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.eT4$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ C22083ue1 g;
        final /* synthetic */ InterfaceC16978mB2 h;
        final /* synthetic */ C23169wT4 i;
        final /* synthetic */ int j;

        /* renamed from: ir.nasim.eT4$h$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ C22083ue1 e;
            final /* synthetic */ InterfaceC16978mB2 f;
            final /* synthetic */ C23169wT4 g;
            final /* synthetic */ int h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22083ue1 c22083ue1, InterfaceC16978mB2 interfaceC16978mB2, C23169wT4 c23169wT4, int i) {
                super(4);
                this.e = c22083ue1;
                this.f = interfaceC16978mB2;
                this.g = c23169wT4;
                this.h = i;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 14) == 0) {
                    i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i3 & 731) == 146 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-70560628, i3, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:415)");
                }
                androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(InterfaceC6988Pv3.g(interfaceC6988Pv3, androidx.compose.ui.input.nestedscroll.a.b(androidx.compose.ui.e.a, this.e, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                InterfaceC16978mB2 interfaceC16978mB2 = this.f;
                C23169wT4 c23169wT4 = this.g;
                int i4 = this.h;
                interfaceC22053ub1.A(733328855);
                InterfaceC10970cW3 interfaceC10970cW3I = androidx.compose.foundation.layout.f.i(InterfaceC12529em.a.o(), false, interfaceC22053ub1, 0);
                interfaceC22053ub1.A(-1323940314);
                WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
                EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1.H(AbstractC13040fc1.n());
                InterfaceC18354oW7 interfaceC18354oW7 = (InterfaceC18354oW7) interfaceC22053ub1.H(AbstractC13040fc1.u());
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                InterfaceC15796kB2 interfaceC15796kB2C = AbstractC19768qu3.c(eVarE);
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                interfaceC22053ub1.J();
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3I, aVar.e());
                DG7.c(interfaceC22053ub1A, wh1, aVar.c());
                DG7.c(interfaceC22053ub1A, enumC12613eu3, aVar.d());
                DG7.c(interfaceC22053ub1A, interfaceC18354oW7, aVar.h());
                interfaceC22053ub1.d();
                interfaceC15796kB2C.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1)), interfaceC22053ub1, 0);
                interfaceC22053ub1.A(2058660585);
                interfaceC22053ub1.A(-2137368960);
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC16978mB2.e(c23169wT4, Integer.valueOf(i), interfaceC22053ub1, Integer.valueOf((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896)));
                interfaceC22053ub1.U();
                interfaceC22053ub1.U();
                interfaceC22053ub1.u();
                interfaceC22053ub1.U();
                interfaceC22053ub1.U();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, UA2 ua2, C22083ue1 c22083ue1, InterfaceC16978mB2 interfaceC16978mB2, C23169wT4 c23169wT4, int i2) {
            super(1);
            this.e = i;
            this.f = ua2;
            this.g = c22083ue1;
            this.h = interfaceC16978mB2;
            this.i = c23169wT4;
            this.j = i2;
        }

        public final void a(InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
            InterfaceC15069ix3.g(interfaceC15069ix3, this.e, this.f, null, AbstractC19242q11.c(-70560628, true, new a(this.g, this.h, this.i, this.j)), 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC15069ix3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.eT4$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ HT4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ float i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC7645Sp2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ TS4 m;
        final /* synthetic */ boolean n;
        final /* synthetic */ InterfaceC12529em.c o;
        final /* synthetic */ InterfaceC12529em.b p;
        final /* synthetic */ InterfaceC16978mB2 q;
        final /* synthetic */ int r;
        final /* synthetic */ int s;
        final /* synthetic */ int t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, androidx.compose.ui.e eVar, HT4 ht4, boolean z, float f, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, UA2 ua2, TS4 ts4, boolean z3, InterfaceC12529em.c cVar, InterfaceC12529em.b bVar, InterfaceC16978mB2 interfaceC16978mB2, int i2, int i3, int i4) {
            super(2);
            this.e = i;
            this.f = eVar;
            this.g = ht4;
            this.h = z;
            this.i = f;
            this.j = z2;
            this.k = interfaceC7645Sp2;
            this.l = ua2;
            this.m = ts4;
            this.n = z3;
            this.o = cVar;
            this.p = bVar;
            this.q = interfaceC16978mB2;
            this.r = i2;
            this.s = i3;
            this.t = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC12351eT4.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, interfaceC22053ub1, this.r | 1, this.s, this.t);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(int r34, androidx.compose.ui.e r35, ir.nasim.HT4 r36, boolean r37, float r38, ir.nasim.TS4 r39, ir.nasim.InterfaceC12529em.c r40, ir.nasim.InterfaceC7645Sp2 r41, ir.nasim.UA2 r42, boolean r43, ir.nasim.InterfaceC16978mB2 r44, ir.nasim.InterfaceC22053ub1 r45, int r46, int r47, int r48) {
        /*
            Method dump skipped, instructions count: 752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12351eT4.a(int, androidx.compose.ui.e, ir.nasim.HT4, boolean, float, ir.nasim.TS4, ir.nasim.em$c, ir.nasim.Sp2, ir.nasim.UA2, boolean, ir.nasim.mB2, ir.nasim.ub1, int, int, int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v4 ??, still in use, count: 1, list:
          (r14v4 ?? I:java.lang.Object) from 0x044a: INVOKE (r15v3 ?? I:ir.nasim.ub1), (r14v4 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:87)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static final void b(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v4 ??, still in use, count: 1, list:
          (r14v4 ?? I:java.lang.Object) from 0x044a: INVOKE (r15v3 ?? I:ir.nasim.ub1), (r14v4 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:87)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r29v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(long j, boolean z, boolean z2) {
        return AbstractC10836cH4.a(z ? ZG4.m(j) : 0.0f, z2 ? ZG4.n(j) : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f(long j, boolean z, boolean z2) {
        return AbstractC18309oR7.a(z ? C17718nR7.h(j) : 0.0f, z2 ? C17718nR7.i(j) : 0.0f);
    }
}
