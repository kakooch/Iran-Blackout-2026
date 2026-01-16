package ir.nasim;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5581Jy3;
import ir.nasim.InterfaceC13730gj3;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Ap, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3370Ap extends AbstractC5581Jy3 {
    private InterfaceC13730gj3 b;
    private C6781Oy3 c;
    private InterfaceC8327Vm4 d;

    /* renamed from: ir.nasim.Ap$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ C3370Ap f;
        final /* synthetic */ T33 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C23945xm7 c23945xm7, C3370Ap c3370Ap, T33 t33, UA2 ua2, UA2 ua22) {
            super(1);
            this.e = c23945xm7;
            this.f = c3370Ap;
            this.g = t33;
            this.h = ua2;
            this.i = ua22;
        }

        public final void a(C6781Oy3 c6781Oy3) {
            c6781Oy3.l(this.e, this.f.i(), this.g, this.h, this.i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6781Oy3) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC8327Vm4 p() {
        InterfaceC8327Vm4 interfaceC8327Vm4 = this.d;
        if (interfaceC8327Vm4 != null) {
            return interfaceC8327Vm4;
        }
        if (!NZ6.a()) {
            return null;
        }
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_LATEST, 2, null);
        this.d = interfaceC8327Vm4B;
        return interfaceC8327Vm4B;
    }

    private final void q(UA2 ua2) {
        AbstractC5581Jy3.a aVarI = i();
        if (aVarI == null) {
            return;
        }
        this.b = aVarI.h0(new b(ua2, this, aVarI, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AbstractC5581Jy3.a aVar, float[] fArr) {
        InterfaceC11379cu3 interfaceC11379cu3U0 = aVar.u0();
        if (interfaceC11379cu3U0 != null) {
            if (!interfaceC11379cu3U0.b()) {
                interfaceC11379cu3U0 = null;
            }
            if (interfaceC11379cu3U0 == null) {
                return;
            }
            interfaceC11379cu3U0.h0(fArr);
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void a(C23945xm7 c23945xm7, T33 t33, UA2 ua2, UA2 ua22) {
        q(new a(c23945xm7, this, t33, ua2, ua22));
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void b() {
        q(null);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void c(C23945xm7 c23945xm7, C23945xm7 c23945xm72) {
        C6781Oy3 c6781Oy3 = this.c;
        if (c6781Oy3 != null) {
            c6781Oy3.m(c23945xm7, c23945xm72);
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void d(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, UA2 ua2, CK5 ck5, CK5 ck52) {
        C6781Oy3 c6781Oy3 = this.c;
        if (c6781Oy3 != null) {
            c6781Oy3.n(c23945xm7, interfaceC11600dH4, c13774gn7, ck5, ck52);
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void e() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.b;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.b = null;
        InterfaceC8327Vm4 interfaceC8327Vm4P = p();
        if (interfaceC8327Vm4P != null) {
            interfaceC8327Vm4P.k();
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void f(CK5 ck5) {
        C6781Oy3 c6781Oy3 = this.c;
        if (c6781Oy3 != null) {
            c6781Oy3.j(ck5);
        }
    }

    @Override // ir.nasim.AbstractC5581Jy3
    public void k() {
        InterfaceC8327Vm4 interfaceC8327Vm4P = p();
        if (interfaceC8327Vm4P != null) {
            interfaceC8327Vm4P.c(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ap$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ C3370Ap e;
        final /* synthetic */ AbstractC5581Jy3.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, C3370Ap c3370Ap, AbstractC5581Jy3.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = c3370Ap;
            this.f = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = new a((InterfaceC22687vf5) this.c, this.d, this.e, this.f, null);
                this.b = 1;
                if (AbstractC20906so1.e(aVar, this) == objE) {
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
        public final Object invoke(InterfaceC22687vf5 interfaceC22687vf5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC22687vf5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.Ap$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC22687vf5 d;
            final /* synthetic */ UA2 e;
            final /* synthetic */ C3370Ap f;
            final /* synthetic */ AbstractC5581Jy3.a g;

            /* renamed from: ir.nasim.Ap$b$a$b, reason: collision with other inner class name */
            /* synthetic */ class C0270b extends EB2 implements UA2 {
                final /* synthetic */ AbstractC5581Jy3.a a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0270b(AbstractC5581Jy3.a aVar) {
                    super(1, AbstractC13042fc3.a.class, "localToScreen", "startInput$localToScreen(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;[F)V", 0);
                    this.a = aVar;
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((AV3) obj).p());
                    return C19938rB7.a;
                }

                public final void y(float[] fArr) {
                    C3370Ap.r(this.a, fArr);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC22687vf5 interfaceC22687vf5, UA2 ua2, C3370Ap c3370Ap, AbstractC5581Jy3.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC22687vf5;
                this.e = ua2;
                this.f = c3370Ap;
                this.g = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                        InterfaceC19915r93 interfaceC19915r93 = (InterfaceC19915r93) AbstractC5815Ky3.c().invoke(this.d.getView());
                        C6781Oy3 c6781Oy3 = new C6781Oy3(this.d.getView(), new C0270b(this.g), interfaceC19915r93);
                        if (NZ6.a()) {
                            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0267a(this.f, interfaceC19915r93, null), 3, null);
                        }
                        UA2 ua2 = this.e;
                        if (ua2 != null) {
                            ua2.invoke(c6781Oy3);
                        }
                        this.f.c = c6781Oy3;
                        InterfaceC22687vf5 interfaceC22687vf5 = this.d;
                        this.b = 1;
                        if (interfaceC22687vf5.a(c6781Oy3, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    this.f.c = null;
                    throw th;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }

            /* renamed from: ir.nasim.Ap$b$a$a, reason: collision with other inner class name */
            static final class C0267a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C3370Ap c;
                final /* synthetic */ InterfaceC19915r93 d;

                /* renamed from: ir.nasim.Ap$b$a$a$b, reason: collision with other inner class name */
                static final class C0269b implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC19915r93 a;

                    C0269b(InterfaceC19915r93 interfaceC19915r93) {
                        this.a = interfaceC19915r93;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                        this.a.f();
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0267a(C3370Ap c3370Ap, InterfaceC19915r93 interfaceC19915r93, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c3370Ap;
                    this.d = interfaceC19915r93;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0267a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C0268a c0268a = C0268a.e;
                        this.b = 1;
                        if (AbstractC16704lj4.b(c0268a, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            throw new KotlinNothingValueException();
                        }
                        AbstractC10685c16.b(obj);
                    }
                    InterfaceC8327Vm4 interfaceC8327Vm4P = this.c.p();
                    if (interfaceC8327Vm4P == null) {
                        return C19938rB7.a;
                    }
                    C0269b c0269b = new C0269b(this.d);
                    this.b = 2;
                    if (interfaceC8327Vm4P.b(c0269b, this) == objE) {
                        return objE;
                    }
                    throw new KotlinNothingValueException();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0267a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }

                /* renamed from: ir.nasim.Ap$b$a$a$a, reason: collision with other inner class name */
                static final class C0268a extends AbstractC8614Ws3 implements UA2 {
                    public static final C0268a e = new C0268a();

                    C0268a() {
                        super(1);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(((Number) obj).longValue());
                        return C19938rB7.a;
                    }

                    public final void a(long j) {
                    }
                }
            }
        }
    }
}
