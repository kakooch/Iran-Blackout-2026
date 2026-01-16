package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC8612Ws1;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Ws1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8612Ws1 {

    /* renamed from: ir.nasim.Ws1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11988dt1 c;
        final /* synthetic */ TR d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11988dt1 c11988dt1, TR tr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11988dt1;
            this.d = tr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.k1(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ws1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (AbstractC8612Ws1.v(this.c).e()) {
                AbstractC8612Ws1.o(this.d).invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ws1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = interfaceC9664aL62;
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
            if (AbstractC8612Ws1.v(this.c).f() && AbstractC8612Ws1.v(this.c).b().length() == 0) {
                AbstractC8612Ws1.r(this.d).invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ws1$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        d(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(AbstractC24800zD5.features_authenticator_create_password_appbar, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ws1$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ C11988dt1 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        /* renamed from: ir.nasim.Ws1$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C11988dt1 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11988dt1 c11988dt1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c11988dt1;
                this.d = i;
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
                    this.b = 1;
                    if (HG1.b(2000L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.c.f1(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC9664aL6 interfaceC9664aL6, C11988dt1 c11988dt1, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9664aL6;
            this.b = c11988dt1;
            this.c = interfaceC9102Ym4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Integer numJ = AbstractC8612Ws1.v(this.a).j();
            if (numJ == null) {
                return;
            }
            C11988dt1 c11988dt1 = this.b;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            int iIntValue = numJ.intValue();
            Integer numValueOf = Integer.valueOf(iIntValue);
            interfaceC22053ub1.W(-1903781882);
            boolean zD = interfaceC22053ub1.D(c11988dt1) | interfaceC22053ub1.e(iIntValue);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c11988dt1, iIntValue, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(numValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            AbstractC10984cY.c(UY6.c(iIntValue, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, 0.0f, 0.0f, C17784nZ1.q(((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).D(AbstractC8612Ws1.m(interfaceC9102Ym4)) + G10.a.c(interfaceC22053ub1, G10.b).b().l()), 7, null), null, 0, null, interfaceC22053ub1, 0, 28);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ws1$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ C11988dt1 a;
        final /* synthetic */ InterfaceC9664aL6 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        f(C11988dt1 c11988dt1, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9102Ym4 interfaceC9102Ym42) {
            this.a = c11988dt1;
            this.b = interfaceC9664aL6;
            this.c = interfaceC9664aL62;
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9664aL63;
            this.f = interfaceC9102Ym42;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C11988dt1 c11988dt1, String str) {
            AbstractC13042fc3.i(str, "pass");
            c11988dt1.d1(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C11988dt1 c11988dt1, String str) {
            AbstractC13042fc3.i(str, "pass");
            c11988dt1.e1(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(C11988dt1 c11988dt1) {
            c11988dt1.i1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(InterfaceC9102Ym4 interfaceC9102Ym4, int i) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$confirmButtonHeight$delegate");
            AbstractC8612Ws1.n(interfaceC9102Ym4, i);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogDismissed$delegate");
            AbstractC13042fc3.i(interfaceC9664aL6, "$currentOnPasswordChanged$delegate");
            AbstractC8612Ws1.x(interfaceC9102Ym4, true);
            AbstractC8612Ws1.r(interfaceC9664aL6).invoke();
            return C19938rB7.a;
        }

        public final void h(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(ts4) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C11367ct1 c11367ct1V = AbstractC8612Ws1.v(this.c);
            interfaceC22053ub1.W(1865508461);
            boolean zD = interfaceC22053ub1.D(this.a);
            final C11988dt1 c11988dt1 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Xs1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8612Ws1.f.i(c11988dt1, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1865512083);
            boolean zD2 = interfaceC22053ub1.D(this.a);
            final C11988dt1 c11988dt12 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Ys1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8612Ws1.f.k(c11988dt12, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1865515995);
            boolean zD3 = interfaceC22053ub1.D(this.a);
            final C11988dt1 c11988dt13 = this.a;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Zs1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8612Ws1.f.n(c11988dt13);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa2 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1865519216);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
            Object objB4 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB4 == aVar.a()) {
                objB4 = new UA2() { // from class: ir.nasim.at1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8612Ws1.f.o(interfaceC9102Ym4, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC8612Ws1.h(c11367ct1V, ts4, ua2, ua22, sa2, (UA2) objB4, interfaceC22053ub1, ((i << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 196608);
            if (AbstractC8612Ws1.q(this.e)) {
                String strB = AbstractC8612Ws1.v(this.c).b();
                if (strB == null) {
                    strB = "";
                }
                interfaceC22053ub1.W(1865528115);
                boolean zV = interfaceC22053ub1.V(this.b);
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.f;
                final InterfaceC9664aL6 interfaceC9664aL6 = this.b;
                Object objB5 = interfaceC22053ub1.B();
                if (zV || objB5 == aVar.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.bt1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8612Ws1.f.p(interfaceC9102Ym42, interfaceC9664aL6);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                TI0.c(strB, (SA2) objB5, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            h((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final C11367ct1 c11367ct1, final TS4 ts4, final UA2 ua2, final UA2 ua22, final SA2 sa2, final UA2 ua23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        e.a aVar;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1380326487);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c11367ct1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(ts4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua23) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C9023Yd6 c9023Yd6C = AbstractC8014Ud6.c(0, interfaceC22053ub1J, 0, 1);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarC = AbstractC22050ua8.c(AbstractC8014Ud6.g(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.h(aVar2, ts4), 0.0f, 1, null), c9023Yd6C, false, null, false, 14, null), AbstractC24416ya8.b(A98.a, interfaceC22053ub1J, 6));
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-1665854520);
            if (c11367ct1.c().length() > 0) {
                G10 g10 = G10.a;
                int i3 = G10.b;
                ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g10.c(interfaceC22053ub1J, i3).b().e()), interfaceC22053ub1J, 0);
                aVar = aVar2;
                AbstractC9339Zm7.b(c11367ct1.c(), androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub1J, i3).b().c(), 0.0f, 2, null), 0.0f, 1, null), g10.a(interfaceC22053ub1J, i3).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).b(), interfaceC22053ub1J, 0, 0, 65528);
            } else {
                aVar = aVar2;
            }
            interfaceC22053ub1J.Q();
            G10 g102 = G10.a;
            int i4 = G10.b;
            e.a aVar4 = aVar;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g102.c(interfaceC22053ub1J, i4).b().e()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC24800zD5.features_authenticator_create_password_description, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar4, g102.c(interfaceC22053ub1J, i4).b().c(), 0.0f, 2, null), 0.0f, 1, null), g102.a(interfaceC22053ub1J, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub1J, i4).a(), interfaceC22053ub1J, 0, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g102.c(interfaceC22053ub1J, i4).b().c()), interfaceC22053ub1J, 0);
            AbstractC14472hy4 abstractC14472hy4G = c11367ct1.g();
            int iD = c11367ct1.d();
            boolean zH = c11367ct1.h();
            String strC = UY6.c(AbstractC24800zD5.features_authenticator_create_password_label_password, interfaceC22053ub1J, 0);
            int iD2 = S33.b.d();
            int i5 = AbstractC14472hy4.a;
            S05.c(null, strC, zH, abstractC14472hy4G, iD, ua2, iD2, true, null, 0L, interfaceC22053ub1J, (i5 << 9) | 14155776 | ((i2 << 9) & 458752), 769);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g102.c(interfaceC22053ub1J, i4).b().c()), interfaceC22053ub1J, 0);
            S05.c(null, UY6.c(AbstractC24800zD5.features_authenticator_create_password_label_password2, interfaceC22053ub1J, 0), c11367ct1.h(), c11367ct1.i(), c11367ct1.d(), ua22, 0, false, null, 0L, interfaceC22053ub1J, (i5 << 9) | ((i2 << 6) & 458752), 961);
            ZH6.a(ZY0.b(c9784aZ0, aVar4, 1.0f, false, 2, null), interfaceC22053ub1J, 0);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            InterfaceC19114po0 interfaceC19114po0A = c11367ct1.a();
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar4, g102.c(interfaceC22053ub1J, i4).b().e(), g102.c(interfaceC22053ub1J, i4).b().c()), 0.0f, 1, null);
            interfaceC22053ub1J.W(-1665780149);
            boolean z = (i2 & 458752) == 131072;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Us1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC8612Ws1.i(ua23, (InterfaceC11379cu3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC17932no0.y(androidx.compose.ui.layout.c.a(eVarH, (UA2) objB), sa2, interfaceC19114po0A, null, UY6.c(AbstractC24800zD5.features_authenticator_create_password_confirm_and_continue_button, interfaceC22053ub1J, 0), null, interfaceC22053ub1J, (i2 >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 40);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Vs1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8612Ws1.j(c11367ct1, ts4, ua2, ua22, sa2, ua23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(UA2 ua2, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(ua2, "$onConfirmButtonHeightChanged");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        ua2.invoke(Integer.valueOf((int) (interfaceC11379cu3.a() & 4294967295L)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C11367ct1 c11367ct1, TS4 ts4, UA2 ua2, UA2 ua22, SA2 sa2, UA2 ua23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c11367ct1, "$uiState");
        AbstractC13042fc3.i(ts4, "$paddingValues");
        AbstractC13042fc3.i(ua2, "$onPasswordChanged");
        AbstractC13042fc3.i(ua22, "$onSecondPasswordChanged");
        AbstractC13042fc3.i(sa2, "$onConfirmAndContinueClicked");
        AbstractC13042fc3.i(ua23, "$onConfirmButtonHeightChanged");
        h(c11367ct1, ts4, ua2, ua22, sa2, ua23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(androidx.compose.ui.e r24, ir.nasim.SA2 r25, ir.nasim.SA2 r26, ir.nasim.SA2 r27, ir.nasim.C11988dt1 r28, final ir.nasim.TR r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8612Ws1.k(androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.dt1, ir.nasim.TR, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, int i) {
        interfaceC9102Ym4.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 o(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogDismissed$delegate");
        return v(interfaceC9664aL6).f() && v(interfaceC9664aL6).b().length() > 0 && !w(interfaceC9102Ym4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 r(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, C11988dt1 c11988dt1, TR tr, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(tr, "$sourceType");
        k(eVar, sa2, sa22, sa23, c11988dt1, tr, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11367ct1 v(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C11367ct1) interfaceC9664aL6.getValue();
    }

    private static final boolean w(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }
}
