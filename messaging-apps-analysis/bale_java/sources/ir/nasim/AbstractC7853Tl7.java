package ir.nasim;

/* renamed from: ir.nasim.Tl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7853Tl7 {

    /* renamed from: ir.nasim.Tl7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ AbstractC12520el0 e;
        final /* synthetic */ C6542Ny3 f;
        final /* synthetic */ C23945xm7 g;
        final /* synthetic */ InterfaceC11600dH4 h;

        /* renamed from: ir.nasim.Tl7$a$a, reason: collision with other inner class name */
        static final class C0667a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C4610Fw1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0667a(C4610Fw1 c4610Fw1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c4610Fw1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0667a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C4610Fw1 c4610Fw1 = this.c;
                    this.b = 1;
                    if (c4610Fw1.f(this) == objE) {
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
                return ((C0667a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Tl7$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C4610Fw1 e;
            final /* synthetic */ InterfaceC11600dH4 f;
            final /* synthetic */ C23945xm7 g;
            final /* synthetic */ C6542Ny3 h;
            final /* synthetic */ AbstractC12520el0 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C4610Fw1 c4610Fw1, InterfaceC11600dH4 interfaceC11600dH4, C23945xm7 c23945xm7, C6542Ny3 c6542Ny3, AbstractC12520el0 abstractC12520el0) {
                super(1);
                this.e = c4610Fw1;
                this.f = interfaceC11600dH4;
                this.g = c23945xm7;
                this.h = c6542Ny3;
                this.i = abstractC12520el0;
            }

            public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
                CK5 ck5;
                C13774gn7 c13774gn7F;
                interfaceC23919xk1.N1();
                float fD = this.e.d();
                if (fD == 0.0f) {
                    return;
                }
                int iB = this.f.b(C4301En7.n(this.g.g()));
                C14367hn7 c14367hn7L = this.h.l();
                if (c14367hn7L == null || (c13774gn7F = c14367hn7L.f()) == null || (ck5 = c13774gn7F.e(iB)) == null) {
                    ck5 = new CK5(0.0f, 0.0f, 0.0f, 0.0f);
                }
                float fD2 = AbstractC23053wG5.d((float) Math.floor(interfaceC23919xk1.w1(AbstractC8087Ul7.a())), 1.0f);
                float f = fD2 / 2;
                float fD3 = AbstractC23053wG5.d(AbstractC23053wG5.h(ck5.i() + f, Float.intBitsToFloat((int) (interfaceC23919xk1.d() >> 32)) - f), f);
                float fFloor = ((int) fD2) % 2 == 1 ? ((float) Math.floor(fD3)) + 0.5f : (float) Math.rint(fD3);
                InterfaceC17460n02.c1(interfaceC23919xk1, this.i, ZG4.e((Float.floatToRawIntBits(fFloor) << 32) | (Float.floatToRawIntBits(ck5.l()) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(ck5.e()) & 4294967295L) | (Float.floatToRawIntBits(fFloor) << 32)), fD2, 0, null, fD, null, 0, 432, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC23919xk1) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC12520el0 abstractC12520el0, C6542Ny3 c6542Ny3, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4) {
            super(3);
            this.e = abstractC12520el0;
            this.f = c6542Ny3;
            this.g = c23945xm7;
            this.h = interfaceC11600dH4;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            androidx.compose.ui.e eVarD;
            interfaceC22053ub1.W(-84507373);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-84507373, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
            }
            boolean zBooleanValue = ((Boolean) interfaceC22053ub1.H(AbstractC13040fc1.f())).booleanValue();
            boolean zA = interfaceC22053ub1.a(zBooleanValue);
            Object objB = interfaceC22053ub1.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                objB = new C4610Fw1(zBooleanValue);
                interfaceC22053ub1.s(objB);
            }
            C4610Fw1 c4610Fw1 = (C4610Fw1) objB;
            AbstractC12520el0 abstractC12520el0 = this.e;
            boolean z = ((abstractC12520el0 instanceof CH6) && ((CH6) abstractC12520el0).b() == 16) ? false : true;
            if (((InterfaceC19920r98) interfaceC22053ub1.H(AbstractC13040fc1.v())).a() && this.f.f() && C4301En7.h(this.g.g()) && z) {
                interfaceC22053ub1.W(808460990);
                C13245fu c13245fuE = this.g.e();
                C4301En7 c4301En7B = C4301En7.b(this.g.g());
                boolean zD = interfaceC22053ub1.D(c4610Fw1);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new C0667a(c4610Fw1, null);
                    interfaceC22053ub1.s(objB2);
                }
                AbstractC10721c52.f(c13245fuE, c4301En7B, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                boolean zD2 = interfaceC22053ub1.D(c4610Fw1) | interfaceC22053ub1.D(this.h) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.D(this.f) | interfaceC22053ub1.V(this.e);
                InterfaceC11600dH4 interfaceC11600dH4 = this.h;
                C23945xm7 c23945xm7 = this.g;
                C6542Ny3 c6542Ny3 = this.f;
                AbstractC12520el0 abstractC12520el02 = this.e;
                Object objB3 = interfaceC22053ub1.B();
                if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new b(c4610Fw1, interfaceC11600dH4, c23945xm7, c6542Ny3, abstractC12520el02);
                    interfaceC22053ub1.s(objB3);
                }
                eVarD = androidx.compose.ui.draw.b.d(eVar, (UA2) objB3);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(810474750);
                interfaceC22053ub1.Q();
                eVarD = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarD;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, C6542Ny3 c6542Ny3, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, AbstractC12520el0 abstractC12520el0, boolean z) {
        return z ? androidx.compose.ui.c.c(eVar, null, new a(abstractC12520el0, c6542Ny3, c23945xm7, interfaceC11600dH4), 1, null) : eVar;
    }
}
