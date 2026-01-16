package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import ir.nasim.AbstractC21071t37;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes.dex */
public abstract class Q02 {
    private static final float a;
    private static final float b;
    private static final float c = C17784nZ1.q(400);
    private static final C7479Rw7 d = new C7479Rw7(256, 0, null, 6, null);

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ T02 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC20315ro1 g;
        final /* synthetic */ long h;
        final /* synthetic */ InterfaceC10031ax6 i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ float l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC15796kB2 n;

        /* renamed from: ir.nasim.Q02$a$a, reason: collision with other inner class name */
        static final class C0585a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ T02 e;
            final /* synthetic */ WH1 f;
            final /* synthetic */ float g;
            final /* synthetic */ float h;

            /* renamed from: ir.nasim.Q02$a$a$a, reason: collision with other inner class name */
            static final class C0586a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ float e;
                final /* synthetic */ float f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0586a(float f, float f2) {
                    super(1);
                    this.e = f;
                    this.f = f2;
                }

                public final void a(MZ1 mz1) {
                    mz1.a(U02.a, this.e);
                    mz1.a(U02.b, this.f);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((MZ1) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0585a(T02 t02, WH1 wh1, float f, float f2) {
                super(0);
                this.e = t02;
                this.f = wh1;
                this.g = f;
                this.h = f2;
            }

            public final void a() {
                this.e.h(this.f);
                C8556Wm.I(this.e.c(), AbstractC8322Vm.a(new C0586a(this.g, this.h)), null, 2, null);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ T02 f;
            final /* synthetic */ InterfaceC20315ro1 g;

            /* renamed from: ir.nasim.Q02$a$b$a, reason: collision with other inner class name */
            static final class C0587a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ T02 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0587a(T02 t02, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = t02;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0587a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        T02 t02 = this.c;
                        this.b = 1;
                        if (t02.b(this) == objE) {
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
                    return ((C0587a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(boolean z, T02 t02, InterfaceC20315ro1 interfaceC20315ro1) {
                super(0);
                this.e = z;
                this.f = t02;
                this.g = interfaceC20315ro1;
            }

            public final void a() {
                if (this.e && ((Boolean) this.f.c().q().invoke(U02.a)).booleanValue()) {
                    AbstractC10533bm0.d(this.g, null, null, new C0587a(this.f, null), 3, null);
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        static final class c extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ float e;
            final /* synthetic */ float f;
            final /* synthetic */ T02 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(float f, float f2, T02 t02) {
                super(0);
                this.e = f;
                this.f = f2;
                this.g = t02;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Float invoke() {
                return Float.valueOf(Q02.i(this.e, this.f, this.g.g()));
            }
        }

        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ T02 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(T02 t02) {
                super(1);
                this.e = t02;
            }

            public final long a(WH1 wh1) {
                return AbstractC22635va3.a(AbstractC20723sV3.d(this.e.g()), 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return C22045ua3.c(a((WH1) obj));
            }
        }

        static final class e extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ String e;
            final /* synthetic */ T02 f;
            final /* synthetic */ InterfaceC20315ro1 g;

            /* renamed from: ir.nasim.Q02$a$e$a, reason: collision with other inner class name */
            static final class C0588a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ T02 e;
                final /* synthetic */ InterfaceC20315ro1 f;

                /* renamed from: ir.nasim.Q02$a$e$a$a, reason: collision with other inner class name */
                static final class C0589a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ T02 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0589a(T02 t02, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = t02;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0589a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            T02 t02 = this.c;
                            this.b = 1;
                            if (t02.b(this) == objE) {
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
                        return ((C0589a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0588a(T02 t02, InterfaceC20315ro1 interfaceC20315ro1) {
                    super(0);
                    this.e = t02;
                    this.f = interfaceC20315ro1;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    if (((Boolean) this.e.c().q().invoke(U02.a)).booleanValue()) {
                        AbstractC10533bm0.d(this.f, null, null, new C0589a(this.e, null), 3, null);
                    }
                    return Boolean.TRUE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(String str, T02 t02, InterfaceC20315ro1 interfaceC20315ro1) {
                super(1);
                this.e = str;
                this.f = t02;
                this.g = interfaceC20315ro1;
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.l0(interfaceC11943do6, this.e);
                if (this.f.e()) {
                    AbstractC9939ao6.m(interfaceC11943do6, null, new C0588a(this.f, this.g), 1, null);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(InterfaceC15796kB2 interfaceC15796kB2) {
                super(2);
                this.e = interfaceC15796kB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1941234439, i, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:544)");
                }
                androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
                InterfaceC15796kB2 interfaceC15796kB2 = this.e;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
                interfaceC15796kB2.q(C9784aZ0.a, interfaceC22053ub1, 6);
                interfaceC22053ub1.u();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(T02 t02, boolean z, InterfaceC20315ro1 interfaceC20315ro1, long j, InterfaceC10031ax6 interfaceC10031ax6, long j2, long j3, float f2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2) {
            super(3);
            this.e = t02;
            this.f = z;
            this.g = interfaceC20315ro1;
            this.h = j;
            this.i = interfaceC10031ax6;
            this.j = j2;
            this.k = j3;
            this.l = f2;
            this.m = interfaceC14603iB2;
            this.n = interfaceC15796kB2;
        }

        public final void a(InterfaceC5920Lk0 interfaceC5920Lk0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(interfaceC5920Lk0) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(816674999, i2, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:468)");
            }
            long jD = interfaceC5920Lk0.d();
            if (!C17833ne1.h(jD)) {
                throw new IllegalStateException("Drawer shouldn't have infinite width");
            }
            float f2 = -C17833ne1.l(jD);
            WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
            boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.V(wh1) | interfaceC22053ub1.c(f2);
            T02 t02 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C0585a(t02, wh1, f2, 0.0f);
                interfaceC22053ub1.s(objB);
            }
            AbstractC10721c52.i((SA2) objB, interfaceC22053ub1, 0);
            boolean z = interfaceC22053ub1.H(AbstractC13040fc1.n()) == EnumC12613eu3.b;
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarE = AbstractC8322Vm.e(aVar, this.e.c(), EnumC24286yM4.b, this.f, z, null, false, 48, null);
            T02 t022 = this.e;
            boolean z2 = this.f;
            InterfaceC20315ro1 interfaceC20315ro1 = this.g;
            long j = this.h;
            InterfaceC10031ax6 interfaceC10031ax6 = this.i;
            long j2 = this.j;
            long j3 = this.k;
            float f3 = this.l;
            InterfaceC14603iB2 interfaceC14603iB2 = this.m;
            InterfaceC15796kB2 interfaceC15796kB2 = this.n;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarE);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE2, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE3, aVar3.f());
            interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
            boolean zE = t022.e();
            boolean zA = interfaceC22053ub1.a(z2) | interfaceC22053ub1.V(t022) | interfaceC22053ub1.D(interfaceC20315ro1);
            Object objB2 = interfaceC22053ub1.B();
            if (zA || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(z2, t022, interfaceC20315ro1);
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            boolean zC = interfaceC22053ub1.c(f2) | interfaceC22053ub1.V(t022);
            Object objB3 = interfaceC22053ub1.B();
            if (zC || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new c(f2, 0.0f, t022);
                interfaceC22053ub1.s(objB3);
            }
            Q02.b(zE, sa2, (SA2) objB3, j, interfaceC22053ub1, 0);
            String strA = AbstractC23225wZ6.a(AbstractC11764dZ6.a.e(), interfaceC22053ub1, 6);
            WH1 wh12 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
            androidx.compose.ui.e eVarW = androidx.compose.foundation.layout.t.w(aVar, wh12.D(C17833ne1.n(jD)), wh12.D(C17833ne1.m(jD)), wh12.D(C17833ne1.l(jD)), wh12.D(C17833ne1.k(jD)));
            boolean zV2 = interfaceC22053ub1.V(t022);
            Object objB4 = interfaceC22053ub1.B();
            if (zV2 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new d(t022);
                interfaceC22053ub1.s(objB4);
            }
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.n.a(eVarW, (UA2) objB4), 0.0f, 0.0f, Q02.a, 0.0f, 11, null);
            boolean zV3 = interfaceC22053ub1.V(strA) | interfaceC22053ub1.V(t022) | interfaceC22053ub1.D(interfaceC20315ro1);
            Object objB5 = interfaceC22053ub1.B();
            if (zV3 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new e(strA, t022, interfaceC20315ro1);
                interfaceC22053ub1.s(objB5);
            }
            E27.a(AbstractC6919Pn6.d(eVarM, false, (UA2) objB5, 1, null), interfaceC10031ax6, j2, j3, null, f3, AbstractC19242q11.e(-1941234439, true, new f(interfaceC15796kB2), interfaceC22053ub1, 54), interfaceC22053ub1, 1572864, 16);
            interfaceC22053ub1.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC5920Lk0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ T02 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ InterfaceC10031ax6 i;
        final /* synthetic */ float j;
        final /* synthetic */ long k;
        final /* synthetic */ long l;
        final /* synthetic */ long m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ int o;
        final /* synthetic */ int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, androidx.compose.ui.e eVar, T02 t02, boolean z, InterfaceC10031ax6 interfaceC10031ax6, float f, long j, long j2, long j3, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = interfaceC15796kB2;
            this.f = eVar;
            this.g = t02;
            this.h = z;
            this.i = interfaceC10031ax6;
            this.j = f;
            this.k = j;
            this.l = j2;
            this.m = j3;
            this.n = interfaceC14603iB2;
            this.o = i;
            this.p = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            Q02.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC22053ub1, QJ5.a(this.o | 1), this.p);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, SA2 sa2) {
            super(1);
            this.e = j;
            this.f = sa2;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            InterfaceC17460n02.C1(interfaceC17460n02, this.e, 0L, 0L, ((Number) this.f.invoke()).floatValue(), null, null, 0, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(boolean z, SA2 sa2, SA2 sa22, long j, int i) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = sa22;
            this.h = j;
            this.i = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            Q02.b(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 d;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2) {
                super(1);
                this.e = sa2;
            }

            public final void a(long j) {
                this.e.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9049Yg5 interfaceC9049Yg5 = (InterfaceC9049Yg5) this.c;
                a aVar = new a(this.d);
                this.b = 1;
                if (AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, aVar, this, 7, null) == objE) {
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
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC9049Yg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;
        final /* synthetic */ SA2 f;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2) {
                super(0);
                this.e = sa2;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                this.e.invoke();
                return Boolean.TRUE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, SA2 sa2) {
            super(1);
            this.e = str;
            this.f = sa2;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.e0(interfaceC11943do6, this.e);
            AbstractC9939ao6.B(interfaceC11943do6, null, new a(this.f), 1, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(U02 u02) {
            return Boolean.TRUE;
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ U02 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(U02 u02, UA2 ua2) {
            super(0);
            this.e = u02;
            this.f = ua2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T02 invoke() {
            return new T02(this.e, this.f);
        }
    }

    static {
        float f2 = 56;
        a = C17784nZ1.q(f2);
        b = C17784nZ1.q(f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC15796kB2 r34, androidx.compose.ui.e r35, ir.nasim.T02 r36, boolean r37, ir.nasim.InterfaceC10031ax6 r38, float r39, long r40, long r42, long r44, ir.nasim.InterfaceC14603iB2 r46, ir.nasim.InterfaceC22053ub1 r47, int r48, int r49) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q02.a(ir.nasim.kB2, androidx.compose.ui.e, ir.nasim.T02, boolean, ir.nasim.ax6, float, long, long, long, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z, SA2 sa2, SA2 sa22, long j, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        androidx.compose.ui.e eVarC;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1983403750);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i2 & 1171) != 1170, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:755)");
            }
            String strA = AbstractC23225wZ6.a(AbstractC11764dZ6.a.a(), interfaceC22053ub1J, 6);
            if (z) {
                interfaceC22053ub1J.W(487534424);
                e.a aVar = androidx.compose.ui.e.a;
                int i3 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                boolean z2 = i3 == 32;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new e(sa2, null);
                    interfaceC22053ub1J.s(objB);
                }
                androidx.compose.ui.e eVarI = aVar.i(new SuspendPointerInputElement(sa2, null, null, new AbstractC21071t37.a((InterfaceC14603iB2) objB), 6, null));
                boolean zV = (i3 == 32) | interfaceC22053ub1J.V(strA);
                Object objB2 = interfaceC22053ub1J.B();
                if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new f(strA, sa2);
                    interfaceC22053ub1J.s(objB2);
                }
                eVarC = AbstractC6919Pn6.c(eVarI, true, (UA2) objB2);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(487858498);
                interfaceC22053ub1J.Q();
                eVarC = androidx.compose.ui.e.a;
            }
            androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null).i(eVarC);
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objB3 = interfaceC22053ub1J.B();
            if (z3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new c(j, sa22);
                interfaceC22053ub1J.s(objB3);
            }
            AbstractC22443vF0.a(eVarI2, (UA2) objB3, interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new d(z, sa2, sa22, j, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i(float f2, float f3, float f4) {
        float f5 = (f4 - f2) / (f3 - f2);
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            return 1.0f;
        }
        return f5;
    }

    public static final T02 j(U02 u02, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            ua2 = g.e;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:394)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = T02.c.a(ua2);
        boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(u02)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(ua2)) || (i & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new h(u02, ua2);
            interfaceC22053ub1.s(objB);
        }
        T02 t02 = (T02) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return t02;
    }
}
