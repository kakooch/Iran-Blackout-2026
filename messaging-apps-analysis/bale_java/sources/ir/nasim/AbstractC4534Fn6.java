package ir.nasim;

import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Fn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4534Fn6 {
    private static final C7444Rt a = new C7444Rt(Float.NaN, Float.NaN);
    private static final InterfaceC5342Ix7 b = PQ7.a(a.e, b.e);
    private static final long c;
    private static final C18827pJ6 d;

    /* renamed from: ir.nasim.Fn6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return (9223372034707292159L & j) != 9205357640488583168L ? new C7444Rt(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L))) : AbstractC4534Fn6.a;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((ZG4) obj).t());
        }
    }

    /* renamed from: ir.nasim.Fn6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            float f = c7444Rt.f();
            float fG = c7444Rt.g();
            return ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return ZG4.d(a((C7444Rt) obj));
        }
    }

    /* renamed from: ir.nasim.Fn6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ UA2 f;

        /* renamed from: ir.nasim.Fn6$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6) {
                super(0);
                this.e = interfaceC9664aL6;
            }

            public final long a() {
                return c.c(this.e);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                return ZG4.d(a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SA2 sa2, UA2 ua2) {
            super(3);
            this.e = sa2;
            this.f = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long c(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((ZG4) interfaceC9664aL6.getValue()).t();
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(759876635);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(759876635, i, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:64)");
            }
            InterfaceC9664aL6 interfaceC9664aL6F = AbstractC4534Fn6.f(this.e, interfaceC22053ub1, 0);
            UA2 ua2 = this.f;
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6F);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC9664aL6F);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVar2 = (androidx.compose.ui.e) ua2.invoke((SA2) objB);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVar2;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.Fn6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ C15607js e;

        /* renamed from: ir.nasim.Fn6$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6) {
                super(0);
                this.e = interfaceC9664aL6;
            }

            public final long a() {
                return AbstractC4534Fn6.g(this.e);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                return ZG4.d(a());
            }
        }

        /* renamed from: ir.nasim.Fn6$d$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C15607js a;
            final /* synthetic */ InterfaceC20315ro1 b;

            /* renamed from: ir.nasim.Fn6$d$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C15607js c;
                final /* synthetic */ long d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C15607js c15607js, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c15607js;
                    this.d = j;
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
                        C15607js c15607js = this.c;
                        ZG4 zg4D = ZG4.d(this.d);
                        C18827pJ6 c18827pJ6E = AbstractC4534Fn6.e();
                        this.b = 1;
                        if (C15607js.h(c15607js, zg4D, c18827pJ6E, null, null, this, 12, null) == objE) {
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

            b(C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = c15607js;
                this.b = interfaceC20315ro1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((ZG4) obj).t(), interfaceC20295rm1);
            }

            public final Object b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                if ((((ZG4) this.a.q()).t() & 9223372034707292159L) == 9205357640488583168L || (j & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((ZG4) this.a.q()).t() & 4294967295L)) == Float.intBitsToFloat((int) (j & 4294967295L))) {
                    Object objX = this.a.x(ZG4.d(j), interfaceC20295rm1);
                    return objX == AbstractC14862ic3.e() ? objX : C19938rB7.a;
                }
                AbstractC10533bm0.d(this.b, null, null, new a(this.a, j, null), 3, null);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC9664aL6 interfaceC9664aL6, C15607js c15607js, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9664aL6;
            this.e = c15607js;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
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
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new a(this.d));
                b bVar = new b(this.e, interfaceC20315ro1);
                this.b = 1;
                if (interfaceC4557Fq2R.b(bVar, this) == objE) {
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

    static {
        long jE = ZG4.e((Float.floatToRawIntBits(0.01f) << 32) | (Float.floatToRawIntBits(0.01f) & 4294967295L));
        c = jE;
        d = new C18827pJ6(0.0f, 0.0f, ZG4.d(jE), 3, null);
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, SA2 sa2, UA2 ua2) {
        return androidx.compose.ui.c.c(eVar, null, new c(sa2, ua2), 1, null);
    }

    public static final C18827pJ6 e() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 f(SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1589795249, i, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:75)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC10222bH6.d(sa2);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
        Object objB2 = interfaceC22053ub1.B();
        if (objB2 == aVar.a()) {
            objB2 = new C15607js(ZG4.d(g(interfaceC9664aL6)), b, ZG4.d(c), null, 8, null);
            interfaceC22053ub1.s(objB2);
        }
        C15607js c15607js = (C15607js) objB2;
        C19938rB7 c19938rB7 = C19938rB7.a;
        boolean zD = interfaceC22053ub1.D(c15607js);
        Object objB3 = interfaceC22053ub1.B();
        if (zD || objB3 == aVar.a()) {
            objB3 = new d(interfaceC9664aL6, c15607js, null);
            interfaceC22053ub1.s(objB3);
        }
        AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 6);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((ZG4) interfaceC9664aL6.getValue()).t();
    }
}
