package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.pG6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC18800pG6 {

    /* renamed from: ir.nasim.pG6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C24460yf2 f;
        final /* synthetic */ String g;

        /* renamed from: ir.nasim.pG6$a$a, reason: collision with other inner class name */
        static final class C1437a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ String f;

            /* renamed from: ir.nasim.pG6$a$a$a, reason: collision with other inner class name */
            static final class C1438a extends AbstractC8614Ws3 implements SA2 {
                C1438a(InterfaceC15845kG6 interfaceC15845kG6) {
                    super(0);
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    throw null;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1437a(boolean z, String str, InterfaceC15845kG6 interfaceC15845kG6) {
                super(1);
                this.e = z;
                this.f = str;
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                if (this.e) {
                    AbstractC9939ao6.k0(interfaceC11943do6, CD3.b.b());
                }
                AbstractC9939ao6.l0(interfaceC11943do6, this.f);
                AbstractC9939ao6.m(interfaceC11943do6, null, new C1438a(null), 1, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pG6$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C24460yf2 e;

            /* renamed from: ir.nasim.pG6$a$b$a, reason: collision with other inner class name */
            static final class C1439a extends AbstractC8614Ws3 implements UA2 {
                C1439a(InterfaceC15845kG6 interfaceC15845kG6) {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(C23280wf2 c23280wf2) {
                    return Boolean.valueOf(AbstractC13042fc3.d(c23280wf2.c(), null));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC15845kG6 interfaceC15845kG6, C24460yf2 c24460yf2) {
                super(0);
                this.e = c24460yf2;
            }

            public final void a() {
                if (AbstractC13042fc3.d(null, this.e.a())) {
                    return;
                }
                AbstractC13610gX0.K(this.e.b(), new C1439a(null));
                OJ5 oj5C = this.e.c();
                if (oj5C != null) {
                    oj5C.invalidate();
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15845kG6 interfaceC15845kG6, InterfaceC15845kG6 interfaceC15845kG62, List list, C24460yf2 c24460yf2, String str) {
            super(3);
            this.e = list;
            this.f = c24460yf2;
            this.g = str;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1471040642, i2, -1, "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:257)");
            }
            boolean zD = AbstractC13042fc3.d(null, null);
            int i3 = zD ? 150 : 75;
            int i4 = (!zD || AbstractC12806fC3.b(this.e).size() == 1) ? 0 : 75;
            C7479Rw7 c7479Rw7K = AbstractC5999Lt.k(i3, i4, T22.e());
            boolean zD2 = interfaceC22053ub1.D(null) | interfaceC22053ub1.D(this.f);
            C24460yf2 c24460yf2 = this.f;
            Object objB = interfaceC22053ub1.B();
            if (zD2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(null, c24460yf2);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL6F = AbstractC18800pG6.f(c7479Rw7K, zD, (SA2) objB, interfaceC22053ub1, 0, 0);
            InterfaceC9664aL6 interfaceC9664aL6G = AbstractC18800pG6.g(AbstractC5999Lt.k(i3, i4, T22.d()), zD, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarC = androidx.compose.ui.graphics.b.c(androidx.compose.ui.e.a, ((Number) interfaceC9664aL6G.getValue()).floatValue(), ((Number) interfaceC9664aL6G.getValue()).floatValue(), ((Number) interfaceC9664aL6F.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
            boolean zA = interfaceC22053ub1.a(zD) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.D(null);
            String str = this.g;
            Object objB2 = interfaceC22053ub1.B();
            if (zA || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new C1437a(zD, str, null);
                interfaceC22053ub1.s(objB2);
            }
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarC, false, (UA2) objB2, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i2 & 14));
            interfaceC22053ub1.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pG6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15845kG6 interfaceC15845kG6) {
            super(2);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2041982076, i, -1, "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:317)");
            }
            InterfaceC15796kB2 interfaceC15796kB2 = this.e;
            AbstractC13042fc3.f(null);
            interfaceC15796kB2.q(null, interfaceC22053ub1, 0);
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

    /* renamed from: ir.nasim.pG6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC15845kG6 interfaceC15845kG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC15796kB2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18800pG6.a(null, this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pG6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ A2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC15845kG6 interfaceC15845kG6, A2 a2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = a2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(null, this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            throw null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pG6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19982rG6 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC15796kB2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C19982rG6 c19982rG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2) {
            super(2);
            this.e = c19982rG6;
            this.f = eVar;
            this.g = interfaceC15796kB2;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18800pG6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pG6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC5766Kt e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C15607js c15607js, boolean z, InterfaceC5766Kt interfaceC5766Kt, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = z;
            this.e = interfaceC5766Kt;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = this.c;
                Float fC = AbstractC6392Nk0.c(this.d ? 1.0f : 0.0f);
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.f.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pG6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC5766Kt e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C15607js c15607js, boolean z, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = z;
            this.e = interfaceC5766Kt;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = this.c;
                Float fC = AbstractC6392Nk0.c(this.d ? 1.0f : 0.8f);
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC15845kG6 r21, androidx.compose.ui.e r22, ir.nasim.InterfaceC15796kB2 r23, ir.nasim.InterfaceC22053ub1 r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18800pG6.a(ir.nasim.kG6, androidx.compose.ui.e, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    public static final void b(C19982rG6 c19982rG6, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(431012348);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(c19982rG6) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (i5 != 0) {
                interfaceC15796kB2 = F91.a.a();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(431012348, i3, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:155)");
            }
            c19982rG6.a();
            A2 a2 = (A2) interfaceC22053ub1J.H(AbstractC13040fc1.c());
            boolean zD = interfaceC22053ub1J.D(null) | interfaceC22053ub1J.D(a2);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new d(null, a2, null);
                interfaceC22053ub1J.s(objB);
            }
            AbstractC10721c52.e(null, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
            c19982rG6.a();
            a(null, eVar, interfaceC15796kB2, interfaceC22053ub1J, (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896), 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        InterfaceC15796kB2 interfaceC15796kB22 = interfaceC15796kB2;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new e(c19982rG6, eVar2, interfaceC15796kB22, i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 f(InterfaceC5766Kt interfaceC5766Kt, boolean z, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 4) != 0) {
            sa2 = f.e;
        }
        SA2 sa22 = sa2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1016418159, i, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:340)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC19153ps.b(!z ? 1.0f : 0.0f, 0.0f, 2, null);
            interfaceC22053ub1.s(objB);
        }
        C15607js c15607js = (C15607js) objB;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zD = interfaceC22053ub1.D(c15607js) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i & 48) == 32) | interfaceC22053ub1.D(interfaceC5766Kt) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.V(sa22)) || (i & 384) == 256);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == aVar.a()) {
            Object gVar = new g(c15607js, z, interfaceC5766Kt, sa22, null);
            interfaceC22053ub1.s(gVar);
            objB2 = gVar;
        }
        AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i >> 3) & 14);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9664aL6 g(InterfaceC5766Kt interfaceC5766Kt, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2003504988, i, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:350)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC19153ps.b(!z ? 1.0f : 0.8f, 0.0f, 2, null);
            interfaceC22053ub1.s(objB);
        }
        C15607js c15607js = (C15607js) objB;
        Boolean boolValueOf = Boolean.valueOf(z);
        boolean zD = interfaceC22053ub1.D(c15607js) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i & 48) == 32) | interfaceC22053ub1.D(interfaceC5766Kt);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == aVar.a()) {
            objB2 = new h(c15607js, z, interfaceC5766Kt, null);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i >> 3) & 14);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    /* renamed from: ir.nasim.pG6$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }
}
