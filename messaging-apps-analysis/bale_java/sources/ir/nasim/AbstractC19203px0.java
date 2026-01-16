package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC19203px0;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.px0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC19203px0 {

    /* renamed from: ir.nasim.px0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ GT4 b;
        final /* synthetic */ List c;
        final /* synthetic */ InterfaceC20315ro1 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* renamed from: ir.nasim.px0$a$a, reason: collision with other inner class name */
        static final class C1461a implements InterfaceC15796kB2 {
            final /* synthetic */ GT4 a;
            final /* synthetic */ List b;
            final /* synthetic */ InterfaceC20315ro1 c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ InterfaceC9664aL6 e;

            /* renamed from: ir.nasim.px0$a$a$a, reason: collision with other inner class name */
            static final class C1462a implements InterfaceC14603iB2 {
                final /* synthetic */ List a;
                final /* synthetic */ GT4 b;
                final /* synthetic */ InterfaceC20315ro1 c;

                /* renamed from: ir.nasim.px0$a$a$a$a, reason: collision with other inner class name */
                static final class C1463a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ GT4 c;
                    final /* synthetic */ int d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1463a(GT4 gt4, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = gt4;
                        this.d = i;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1463a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            GT4 gt4 = this.c;
                            int i2 = this.d;
                            this.b = 1;
                            if (GT4.n(gt4, i2, 0.0f, null, this, 6, null) == objE) {
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
                        return ((C1463a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.px0$a$a$a$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ String a;

                    b(String str) {
                        this.a = str;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC9339Zm7.b(this.a, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C1462a(List list, GT4 gt4, InterfaceC20315ro1 interfaceC20315ro1) {
                    this.a = list;
                    this.b = gt4;
                    this.c = interfaceC20315ro1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(InterfaceC20315ro1 interfaceC20315ro1, GT4 gt4, int i) {
                    AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
                    AbstractC13042fc3.i(gt4, "$pagerState");
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1463a(gt4, i, null), 3, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    List list = this.a;
                    final GT4 gt4 = this.b;
                    final InterfaceC20315ro1 interfaceC20315ro1 = this.c;
                    final int i2 = 0;
                    for (Object obj : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            AbstractC10360bX0.w();
                        }
                        String str = (String) obj;
                        boolean z = gt4.v() == i2;
                        interfaceC22053ub1.W(-255396222);
                        boolean zD = interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(gt4) | interfaceC22053ub1.e(i2);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.ox0
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return AbstractC19203px0.a.C1461a.C1462a.c(interfaceC20315ro1, gt4, i2);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC6142Mi7.b(z, (SA2) objB, null, false, AbstractC19242q11.e(876138315, true, new b(str), interfaceC22053ub1, 54), null, 0L, 0L, null, interfaceC22053ub1, 24576, 492);
                        i2 = i3;
                        gt4 = gt4;
                        interfaceC20315ro1 = interfaceC20315ro1;
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.px0$a$a$b */
            static final class b implements InterfaceC16978mB2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                b(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = ua2;
                    this.b = interfaceC9664aL6;
                }

                public final void a(InterfaceC22573vT4 interfaceC22573vT4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    AbstractC13042fc3.i(interfaceC22573vT4, "$this$HorizontalPager");
                    if (i == 0) {
                        interfaceC22053ub1.W(-1156449795);
                        AbstractC19203px0.H(AbstractC19203px0.n(this.b).f(), this.a, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (i == 1) {
                        interfaceC22053ub1.W(-1156446883);
                        AbstractC19203px0.D(AbstractC19203px0.n(this.b).e(), this.a, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (i == 2) {
                        interfaceC22053ub1.W(-1156443973);
                        AbstractC19203px0.z(AbstractC19203px0.n(this.b).d(), this.a, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (i == 3) {
                        interfaceC22053ub1.W(-1156441125);
                        AbstractC19203px0.v(AbstractC19203px0.n(this.b).c(), this.a, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else if (i == 4) {
                        interfaceC22053ub1.W(-1156438310);
                        AbstractC19203px0.t(AbstractC19203px0.n(this.b).b(), interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else if (i != 5) {
                        interfaceC22053ub1.W(-1489742910);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(-1156436514);
                        AbstractC19203px0.q(AbstractC19203px0.n(this.b).a(), interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC22573vT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            C1461a(GT4 gt4, List list, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = gt4;
                this.b = list;
                this.c = interfaceC20315ro1;
                this.d = ua2;
                this.e = interfaceC9664aL6;
            }

            public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                GT4 gt4 = this.a;
                List list = this.b;
                InterfaceC20315ro1 interfaceC20315ro1 = this.c;
                UA2 ua2 = this.d;
                InterfaceC9664aL6 interfaceC9664aL6 = this.e;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC8794Xi7.a(gt4.v(), null, 0L, 0L, 0.0f, null, null, AbstractC19242q11.e(1178626815, true, new C1462a(list, gt4, interfaceC20315ro1), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 126);
                AbstractC17142mT4.a(gt4, androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, AbstractC19242q11.e(929504288, true, new b(ua2, interfaceC9664aL6), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 24576, 16380);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, GT4 gt4, List list, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
            this.a = sa2;
            this.b = gt4;
            this.c = list;
            this.d = interfaceC20315ro1;
            this.e = ua2;
            this.f = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9273Zf4.a(this.a, null, null, 0.0f, null, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, 0.0f, 0L, C10084b31.a.a(), null, null, AbstractC19242q11.e(1621807785, true, new C1461a(this.b, this.c, this.d, this.e, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, 805306368, 384, 3550);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px0$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;
        final /* synthetic */ PN b;

        /* renamed from: ir.nasim.px0$b$a */
        static final class a implements UA2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ PN b;

            a(UA2 ua2, PN pn) {
                this.a = ua2;
                this.b = pn;
            }

            public final void a(long j) {
                this.a.invoke(this.b.toString());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        b(UA2 ua2, PN pn) {
            this.a = ua2;
            this.b = pn;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new a(this.a, this.b), null, null, interfaceC20295rm1, 13, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px0$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.px0$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.px0$e */
    public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            PN pn = (PN) this.e.get(i);
            interfaceC22053ub1.W(62121926);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().c());
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1.W(2008700);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(pn);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(this.f, pn);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarI, c19938rB7, (PointerInputEventHandler) objB);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9339Zm7.b("jitterBufferDelay: " + pn.f(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("jitterBufferEmittedCount: " + pn.g(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("packetsDiscarded: " + pn.h(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("fecpacketsreceived: " + pn.e(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("fecpacketsdiscarded: " + pn.d(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("concealedSamples: " + pn.b(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("concealmentEvents: " + pn.c(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("audioLevel: " + pn.a(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
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

    /* renamed from: ir.nasim.px0$f */
    static final class f implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;
        final /* synthetic */ C21986uT7 b;

        /* renamed from: ir.nasim.px0$f$a */
        static final class a implements UA2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ C21986uT7 b;

            a(UA2 ua2, C21986uT7 c21986uT7) {
                this.a = ua2;
                this.b = c21986uT7;
            }

            public final void a(long j) {
                this.a.invoke(this.b.toString());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        f(UA2 ua2, C21986uT7 c21986uT7) {
            this.a = ua2;
            this.b = c21986uT7;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new a(this.a, this.b), null, null, interfaceC20295rm1, 13, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px0$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.px0$h */
    public static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.px0$i */
    public static final class i extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            C21986uT7 c21986uT7 = (C21986uT7) this.e.get(i);
            interfaceC22053ub1.W(-718245402);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().c());
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1.W(-438807231);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(c21986uT7);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new f(this.f, c21986uT7);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarI, c19938rB7, (PointerInputEventHandler) objB);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9339Zm7.b("jitterBufferDelay: " + c21986uT7.g(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("jitterBufferEmittedCount: " + c21986uT7.h(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("framesDropped: " + c21986uT7.c(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("framesPerSecond: " + c21986uT7.d(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("pauseCount: " + c21986uT7.k(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("totalPausesDuration: " + c21986uT7.n(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("freezeCount: " + c21986uT7.f(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("totalfreezesduration: " + c21986uT7.o(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("lastpacketreceivedtimestamp: " + c21986uT7.i(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("nackCount: " + c21986uT7.j(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("firCount: " + c21986uT7.b(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("pliCount: " + c21986uT7.l(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("framesReceived: " + c21986uT7.e(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("decoderImplementation: " + c21986uT7.a(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("retransmittedPacketsReceived: " + c21986uT7.m(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
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

    /* renamed from: ir.nasim.px0$j */
    static final class j implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;
        final /* synthetic */ LM4 b;

        /* renamed from: ir.nasim.px0$j$a */
        static final class a implements UA2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ LM4 b;

            a(UA2 ua2, LM4 lm4) {
                this.a = ua2;
                this.b = lm4;
            }

            public final void a(long j) {
                this.a.invoke(this.b.toString());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        j(UA2 ua2, LM4 lm4) {
            this.a = ua2;
            this.b = lm4;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new a(this.a, this.b), null, null, interfaceC20295rm1, 13, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px0$k */
    public static final class k extends AbstractC8614Ws3 implements UA2 {
        public static final k e = new k();

        public k() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.px0$l */
    public static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.px0$m */
    public static final class m extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            LM4 lm4 = (LM4) this.e.get(i);
            interfaceC22053ub1.W(189629527);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().c());
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1.W(-1517898063);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(lm4);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new j(this.f, lm4);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarI, c19938rB7, (PointerInputEventHandler) objB);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9339Zm7.b("packetSend: " + lm4.b(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("codec: " + lm4.a(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
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

    /* renamed from: ir.nasim.px0$n */
    static final class n implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;
        final /* synthetic */ CT7 b;

        /* renamed from: ir.nasim.px0$n$a */
        static final class a implements UA2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ CT7 b;

            a(UA2 ua2, CT7 ct7) {
                this.a = ua2;
                this.b = ct7;
            }

            public final void a(long j) {
                this.a.invoke(this.b.toString());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        n(UA2 ua2, CT7 ct7) {
            this.a = ua2;
            this.b = ct7;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, new a(this.a, this.b), null, null, interfaceC20295rm1, 13, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px0$o */
    public static final class o extends AbstractC8614Ws3 implements UA2 {
        public static final o e = new o();

        public o() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.px0$p */
    public static final class p extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.px0$q */
    public static final class q extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            CT7 ct7 = (CT7) this.e.get(i);
            interfaceC22053ub1.W(-594330236);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().c());
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1.W(-1958830058);
            boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(ct7);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new n(this.f, ct7);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarI, c19938rB7, (PointerInputEventHandler) objB);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9339Zm7.b("packetSend: " + ct7.b(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("retransmittedPacketsSent: " + ct7.h(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("targetBitrate: " + ct7.k(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("codec: " + ct7.a(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("MediaSourceInfo: " + ct7.j(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("framesSent: " + ct7.d(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("hugeFramesSent: " + ct7.e(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("nackCount: " + ct7.f(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("firCount: " + ct7.c(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("pliCount: " + ct7.g(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            AbstractC9339Zm7.b("scalabilityMode: " + ct7.i(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 0, 0, 131070);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
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

    private static final List A(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$stats$delegate");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        List listA = A(interfaceC9664aL6);
        interfaceC15069ix3.a(listA.size(), null, new h(g.e, listA), AbstractC19242q11.c(-632812321, true, new i(listA, ua2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$stats");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        z(interfaceC10258bL6, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void D(final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "stats");
        AbstractC13042fc3.i(ua2, "copyToClipBoard");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(94253437);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i4 & 14, 7);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(1641779885);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6C) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ix0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19203px0.F(interfaceC9664aL6C, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub12, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.G(interfaceC10258bL6, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List E(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$stats$delegate");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        List listE = E(interfaceC9664aL6);
        interfaceC15069ix3.a(listE.size(), null, new l(k.e, listE), AbstractC19242q11.c(-632812321, true, new m(listE, ua2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$stats");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        D(interfaceC10258bL6, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void H(final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "stats");
        AbstractC13042fc3.i(ua2, "copyToClipBoard");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1297738910);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i4 & 14, 7);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(-2052632992);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6C) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.cx0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19203px0.K(interfaceC9664aL6C, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub12, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.I(interfaceC10258bL6, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$stats");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        H(interfaceC10258bL6, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private static final List J(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$stats$delegate");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        List listJ = J(interfaceC9664aL6);
        interfaceC15069ix3.a(listJ.size(), null, new p(o.e, listJ), AbstractC19242q11.c(-632812321, true, new q(listJ, ua2)));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(ir.nasim.C20403rx0 r18, final ir.nasim.SA2 r19, final ir.nasim.UA2 r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19203px0.m(ir.nasim.rx0, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19794qx0 n(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C19794qx0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(List list) {
        AbstractC13042fc3.i(list, "$tabs");
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C20403rx0 c20403rx0, SA2 sa2, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        m(c20403rx0, sa2, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void q(final InterfaceC10258bL6 interfaceC10258bL6, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "callState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1857794403);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i3 & 14, 7);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(r(interfaceC9664aL6C).toString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub12, 0, 0, 131070);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.s(interfaceC10258bL6, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final C17448mz0 r(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C17448mz0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(InterfaceC10258bL6 interfaceC10258bL6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        q(interfaceC10258bL6, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void t(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "configs");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(842554457);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub12, i3 & 14, 0, 131070);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.u(str, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(String str, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$configs");
        t(str, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void v(final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "stats");
        AbstractC13042fc3.i(ua2, "copyToClipBoard");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1651390224);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i4 & 14, 7);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(513654494);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6C) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.mx0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19203px0.x(interfaceC9664aL6C, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub12, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.y(interfaceC10258bL6, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List w(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$stats$delegate");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        List listW = w(interfaceC9664aL6);
        interfaceC15069ix3.a(listW.size(), null, new d(c.e, listW), AbstractC19242q11.c(-632812321, true, new e(listW, ua2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$stats");
        AbstractC13042fc3.i(ua2, "$copyToClipBoard");
        v(interfaceC10258bL6, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void z(final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "stats");
        AbstractC13042fc3.i(ua2, "copyToClipBoard");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1251584725);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i4 & 14, 7);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(1114324798);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6C) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.kx0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19203px0.B(interfaceC9664aL6C, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub12, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.lx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19203px0.C(interfaceC10258bL6, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
