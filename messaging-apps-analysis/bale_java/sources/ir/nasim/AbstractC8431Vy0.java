package ir.nasim;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC8431Vy0;
import ir.nasim.InterfaceC8534Wj4;

/* renamed from: ir.nasim.Vy0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8431Vy0 {

    /* renamed from: ir.nasim.Vy0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC10258bL6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.Vy0$a$a, reason: collision with other inner class name */
        static final class C0720a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC9102Ym4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0720a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0720a c0720a = new C0720a(this.d, interfaceC20295rm1);
                c0720a.c = obj;
                return c0720a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17448mz0 c17448mz0 = (C17448mz0) this.c;
                InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
                AbstractC7031Pz0 abstractC7031Pz0F = c17448mz0.f();
                AbstractC8431Vy0.o(interfaceC9102Ym4, abstractC7031Pz0F != null ? abstractC7031Pz0F.a() : false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0720a) create(c17448mz0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC10258bL6;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                C0720a c0720a = new C0720a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6, c0720a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vy0$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C24234yG6 a;

        /* renamed from: ir.nasim.Vy0$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ C24234yG6 a;

            /* renamed from: ir.nasim.Vy0$b$a$a, reason: collision with other inner class name */
            static final class C0721a implements InterfaceC14603iB2 {
                final /* synthetic */ InterfaceC15254jG6 a;
                final /* synthetic */ C24234yG6 b;

                C0721a(InterfaceC15254jG6 interfaceC15254jG6, C24234yG6 c24234yG6) {
                    this.a = interfaceC15254jG6;
                    this.b = c24234yG6;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC10984cY.c(this.a.a().b(), null, this.b.b(), 0, null, interfaceC22053ub1, AbstractC13463gG6.a << 6, 26);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C24234yG6 c24234yG6) {
                this.a = c24234yG6;
            }

            public final void a(InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
                }
                if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1080151784, true, new C0721a(interfaceC15254jG6, this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(C24234yG6 c24234yG6) {
            this.a = c24234yG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a.a(), androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, 0.0f, 0.0f, C17784nZ1.q(155), 7, null), AbstractC19242q11.e(-758256728, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 432, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vy0$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC10258bL6 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ C12767fA0 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ Integer j;
        final /* synthetic */ InterfaceC9102Ym4 k;
        final /* synthetic */ InterfaceC9102Ym4 l;
        final /* synthetic */ InterfaceC9102Ym4 m;

        c(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, UA2 ua22, C12767fA0 c12767fA0, UA2 ua23, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, SA2 sa23, Integer num, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43) {
            this.a = interfaceC10258bL6;
            this.b = ua2;
            this.c = ua22;
            this.d = c12767fA0;
            this.e = ua23;
            this.f = sa2;
            this.g = interfaceC14603iB2;
            this.h = sa22;
            this.i = sa23;
            this.j = num;
            this.k = interfaceC9102Ym4;
            this.l = interfaceC9102Ym42;
            this.m = interfaceC9102Ym43;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C12767fA0 c12767fA0, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$callOptionBottomSheet$delegate");
            AbstractC8431Vy0.A(interfaceC9102Ym4, true);
            c12767fA0.n2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C12767fA0 c12767fA0, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$callOptionBottomSheet$delegate");
            AbstractC8431Vy0.A(interfaceC9102Ym4, true);
            c12767fA0.n2();
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (!AbstractC8431Vy0.j(this.k)) {
                interfaceC22053ub1.W(-1782869642);
                InterfaceC10258bL6 interfaceC10258bL6 = this.a;
                UA2 ua2 = this.b;
                Integer num = this.j;
                UA2 ua22 = this.c;
                C12767fA0 c12767fA0 = this.d;
                SA2 sa2 = this.f;
                boolean zP = AbstractC8431Vy0.p(this.m);
                interfaceC22053ub1.W(-57502742);
                boolean zD = interfaceC22053ub1.D(this.d);
                final C12767fA0 c12767fA02 = this.d;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.l;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Xy0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8431Vy0.c.f(c12767fA02, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                J55.b(interfaceC10258bL6, ua2, num, ua22, c12767fA0, sa2, zP, (SA2) objB, interfaceC22053ub1, C12767fA0.x << 12);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-1783344810);
            InterfaceC10258bL6 interfaceC10258bL62 = this.a;
            UA2 ua23 = this.b;
            UA2 ua24 = this.c;
            C12767fA0 c12767fA03 = this.d;
            UA2 ua25 = this.e;
            SA2 sa22 = this.f;
            InterfaceC14603iB2 interfaceC14603iB2 = this.g;
            SA2 sa23 = this.h;
            SA2 sa24 = this.i;
            interfaceC22053ub1.W(-57517078);
            boolean zD2 = interfaceC22053ub1.D(this.d);
            final C12767fA0 c12767fA04 = this.d;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.l;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Wy0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8431Vy0.c.d(c12767fA04, interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            FL2.g(interfaceC10258bL62, ua23, ua24, c12767fA03, ua25, sa22, interfaceC14603iB2, sa23, sa24, (SA2) objB2, interfaceC22053ub1, C12767fA0.x << 9);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vy0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;
        final /* synthetic */ C24234yG6 e;
        final /* synthetic */ Resources f;

        /* renamed from: ir.nasim.Vy0$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12767fA0 a;
            final /* synthetic */ C24234yG6 b;
            final /* synthetic */ InterfaceC20315ro1 c;
            final /* synthetic */ Resources d;

            /* renamed from: ir.nasim.Vy0$d$a$a, reason: collision with other inner class name */
            static final class C0722a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C24234yG6 c;
                final /* synthetic */ AbstractC22884vz0 d;
                final /* synthetic */ Resources e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0722a(C24234yG6 c24234yG6, AbstractC22884vz0 abstractC22884vz0, Resources resources, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c24234yG6;
                    this.d = abstractC22884vz0;
                    this.e = resources;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0722a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C19391qG6 c19391qG6A = this.c.a();
                        AbstractC22884vz0 abstractC22884vz0 = this.d;
                        Resources resources = this.e;
                        AbstractC13042fc3.f(resources);
                        String strA = AbstractC20351rr7.a(abstractC22884vz0, resources);
                        EnumC17618nG6 enumC17618nG6 = EnumC17618nG6.Indefinite;
                        this.b = 1;
                        if (C19391qG6.f(c19391qG6A, strA, null, false, enumC17618nG6, this, 6, null) == objE) {
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
                    return ((C0722a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Vy0$d$a$b */
            static final class b extends AbstractC22163um1 {
                Object a;
                Object b;
                Object c;
                Object d;
                Object e;
                /* synthetic */ Object f;
                int h;

                b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.f = obj;
                    this.h |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C12767fA0 c12767fA0, C24234yG6 c24234yG6, InterfaceC20315ro1 interfaceC20315ro1, Resources resources) {
                this.a = c12767fA0;
                this.b = c24234yG6;
                this.c = interfaceC20315ro1;
                this.d = resources;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.util.List r21, ir.nasim.InterfaceC20295rm1 r22) throws android.content.res.Resources.NotFoundException {
                /*
                    Method dump skipped, instructions count: 266
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.d.a.a(java.util.List, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* renamed from: ir.nasim.Vy0$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$d$b$a$a, reason: collision with other inner class name */
                public static final class C0723a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0723a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.d.b.a.C0723a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$d$b$a$a r0 = (ir.nasim.AbstractC8431Vy0.d.b.a.C0723a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$d$b$a$a r0 = new ir.nasim.Vy0$d$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                        java.util.List r5 = r5.e()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C12767fA0 c12767fA0, C24234yG6 c24234yG6, Resources resources, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
            this.e = c24234yG6;
            this.f = resources;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, this.f, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2B = AbstractC7420Rq2.b(new b(this.d.I1()), 0, null, 3, null);
                a aVar = new a(this.d, this.e, interfaceC20315ro1, this.f);
                this.b = 1;
                if (interfaceC4557Fq2B.b(aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Vy0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15528jk0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C15528jk0 c15528jk0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15528jk0;
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
                C16119kk0 c16119kk0A = this.c.a();
                this.b = 1;
                if (c16119kk0A.a(this) == objE) {
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

    /* renamed from: ir.nasim.Vy0$f */
    /* synthetic */ class f extends EB2 implements SA2 {
        f(Object obj) {
            super(0, obj, C12767fA0.class, "closeBottomSheet", "closeBottomSheet()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12767fA0) this.receiver).A1();
        }
    }

    /* renamed from: ir.nasim.Vy0$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;

        /* renamed from: ir.nasim.Vy0$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue(AbstractC7783Te2.e(((InterfaceC8534Wj4.b) this.c).a()));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC8534Wj4.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Vy0$g$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$g$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$g$b$a$a, reason: collision with other inner class name */
                public static final class C0724a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0724a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.g.b.a.C0724a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$g$b$a$a r0 = (ir.nasim.AbstractC8431Vy0.g.b.a.C0724a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$g$b$a$a r0 = new ir.nasim.Vy0$g$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                        ir.nasim.Wj4 r5 = r5.h()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.g.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Vy0$g$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$g$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$g$c$a$a, reason: collision with other inner class name */
                public static final class C0725a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0725a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.g.c.a.C0725a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$g$c$a$a r0 = (ir.nasim.AbstractC8431Vy0.g.c.a.C0725a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$g$c$a$a r0 = new ir.nasim.Vy0$g$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.Wj4 r5 = (ir.nasim.InterfaceC8534Wj4) r5
                        boolean r2 = r5 instanceof ir.nasim.InterfaceC8534Wj4.b
                        if (r2 == 0) goto L3f
                        ir.nasim.Wj4$b r5 = (ir.nasim.InterfaceC8534Wj4.b) r5
                        goto L40
                    L3f:
                        r5 = 0
                    L40:
                        if (r5 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.g.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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
        g(C12767fA0 c12767fA0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                c cVar = new c(new b(this.d.I1()));
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(cVar, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vy0$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;

        /* renamed from: ir.nasim.Vy0$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue(AbstractC6392Nk0.a(this.c));
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Vy0$h$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$h$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$h$b$a$a, reason: collision with other inner class name */
                public static final class C0726a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0726a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.h.b.a.C0726a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$h$b$a$a r0 = (ir.nasim.AbstractC8431Vy0.h.b.a.C0726a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$h$b$a$a r0 = new ir.nasim.Vy0$h$b$a$a
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
                        ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                        ir.nasim.cv0 r5 = r5.c()
                        ir.nasim.cv0$b r2 = ir.nasim.InterfaceC11386cv0.b.a
                        boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r2)
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.h.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C12767fA0 c12767fA0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                b bVar = new b(this.d.I1());
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vy0$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;

        /* renamed from: ir.nasim.Vy0$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue(AbstractC6392Nk0.a(this.c));
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Vy0$i$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$i$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$i$b$a$a, reason: collision with other inner class name */
                public static final class C0727a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0727a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.i.b.a.C0727a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$i$b$a$a r0 = (ir.nasim.AbstractC8431Vy0.i.b.a.C0727a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$i$b$a$a r0 = new ir.nasim.Vy0$i$b$a$a
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
                        ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                        boolean r5 = r5.o()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.i.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C12767fA0 c12767fA0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.d, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                b bVar = new b(this.d.I1());
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vy0$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;

        /* renamed from: ir.nasim.Vy0$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue(AbstractC6392Nk0.a(this.c));
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Vy0$j$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Vy0$j$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Vy0$j$b$a$a, reason: collision with other inner class name */
                public static final class C0728a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0728a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.AbstractC8431Vy0.j.b.a.C0728a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Vy0$j$b$a$a r0 = (ir.nasim.AbstractC8431Vy0.j.b.a.C0728a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Vy0$j$b$a$a r0 = new ir.nasim.Vy0$j$b$a$a
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
                        ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                        ir.nasim.cv0 r5 = r5.c()
                        ir.nasim.cv0$c r2 = ir.nasim.InterfaceC11386cv0.c.a
                        boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r2)
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.j.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C12767fA0 c12767fA0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.d, interfaceC20295rm1);
            jVar.c = obj;
            return jVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                b bVar = new b(this.d.I1());
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:352:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final ir.nasim.InterfaceC10258bL6 r34, final ir.nasim.UA2 r35, final ir.nasim.SA2 r36, final java.lang.Integer r37, final ir.nasim.UA2 r38, final ir.nasim.UA2 r39, final ir.nasim.InterfaceC14603iB2 r40, final ir.nasim.SA2 r41, final ir.nasim.SA2 r42, final ir.nasim.UA2 r43, ir.nasim.C12767fA0 r44, ir.nasim.InterfaceC22053ub1 r45, final int r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8431Vy0.i(ir.nasim.bL6, ir.nasim.UA2, ir.nasim.SA2, java.lang.Integer, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.fA0, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final InterfaceC13346g43 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC13346g43) interfaceC9664aL6.getValue();
    }

    private static final boolean l(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    private static final boolean m(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    private static final boolean n(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$callOptionBottomSheet$delegate");
        A(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C12767fA0 c12767fA0, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC8960Xz0 interfaceC8960Xz0) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$callOptionBottomSheet$delegate");
        AbstractC13042fc3.i(interfaceC8960Xz0, "it");
        c12767fA0.P1(interfaceC8960Xz0);
        A(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(C12767fA0 c12767fA0) {
        c12767fA0.B1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(C12767fA0 c12767fA0) {
        c12767fA0.u2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(C12767fA0 c12767fA0) {
        c12767fA0.I2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(C12767fA0 c12767fA0) {
        c12767fA0.u2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(C12767fA0 c12767fA0) {
        c12767fA0.K2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, SA2 sa2, Integer num, UA2 ua22, UA2 ua23, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, SA2 sa23, UA2 ua24, C12767fA0 c12767fA0, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        AbstractC13042fc3.i(ua2, "$openSpeakerBottomSheet");
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        AbstractC13042fc3.i(ua22, "$showCallErrorsSnackbar");
        AbstractC13042fc3.i(ua23, "$openUserChat");
        AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
        AbstractC13042fc3.i(sa22, "$onCopyCallLink");
        AbstractC13042fc3.i(sa23, "$onShareCallLink");
        AbstractC13042fc3.i(ua24, "$copyToClipBoard");
        i(interfaceC10258bL6, ua2, sa2, num, ua22, ua23, interfaceC14603iB2, sa22, sa23, ua24, c12767fA0, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3), i4);
        return C19938rB7.a;
    }

    private static final boolean y(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    private static final boolean z(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }
}
