package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC14944ik6;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.ik6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14944ik6 {

    /* renamed from: ir.nasim.ik6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.settings_security, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ik6$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        b(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, C12167e91.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ik6$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ ZF6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C16115kj6 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ C16706lj6 e;
        final /* synthetic */ C19391qG6 f;

        /* renamed from: ir.nasim.ik6$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ZF6 c;
            final /* synthetic */ C19391qG6 d;
            final /* synthetic */ Resources e;
            final /* synthetic */ SA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ZF6 zf6, C19391qG6 c19391qG6, Resources resources, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = zf6;
                this.d = c19391qG6;
                this.e = resources;
                this.f = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(SA2 sa2) {
                sa2.invoke();
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    ZF6 zf6 = this.c;
                    if (zf6 != null) {
                        C19391qG6 c19391qG6 = this.d;
                        Resources resources = this.e;
                        final SA2 sa2 = this.f;
                        AbstractC13042fc3.f(resources);
                        SA2 sa22 = new SA2() { // from class: ir.nasim.jk6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC14944ik6.c.a.y(sa2);
                            }
                        };
                        this.b = 1;
                        if (AbstractC14944ik6.Q(c19391qG6, zf6, resources, sa22, this) == objE) {
                            return objE;
                        }
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(ZF6 zf6, SA2 sa2, C16115kj6 c16115kj6, boolean z, C16706lj6 c16706lj6, C19391qG6 c19391qG6) {
            this.a = zf6;
            this.b = sa2;
            this.c = c16115kj6;
            this.d = z;
            this.e = c16706lj6;
            this.f = c19391qG6;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Resources resources = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources();
            ZF6 zf6 = this.a;
            interfaceC22053ub1.W(1487652278);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(resources) | interfaceC22053ub1.V(this.b);
            ZF6 zf62 = this.a;
            C19391qG6 c19391qG6 = this.f;
            SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(zf62, c19391qG6, resources, sa2, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(zf6, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            AbstractC14944ik6.L(AbstractC8014Ud6.g(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null), this.c, this.d, this.e, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ik6$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ C16706lj6 a;

        d(C16706lj6 c16706lj6) {
            this.a = c16706lj6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n() {
            return C19938rB7.a;
        }

        public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C16115kj6 c16115kj6 = new C16115kj6(true, false, false);
            interfaceC22053ub1.W(1610782702);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.kk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.d.h();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            C16706lj6 c16706lj6 = this.a;
            interfaceC22053ub1.W(1610786190);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.lk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.d.i();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1610787342);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.mk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.d.k();
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa23 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1610788397);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.nk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.d.n();
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC14944ik6.t(null, c16115kj6, false, sa2, c16706lj6, sa22, sa23, (SA2) objB4, interfaceC22053ub1, 14355846);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ik6$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC14944ik6.Q(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        w(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void L(final androidx.compose.ui.e eVar, final C16115kj6 c16115kj6, final boolean z, final C16706lj6 c16706lj6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(eVar, "modifier");
        AbstractC13042fc3.i(c16115kj6, "mxpState");
        AbstractC13042fc3.i(c16706lj6, "securityNavigationCallbacks");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1132332215);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c16115kj6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c16706lj6) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9459a00.c(null, UY6.c(QD5.settings_privacy_title, interfaceC22053ub1J, 0), null, interfaceC22053ub1J, 0, 5);
            AbstractC16797ls7.i(UY6.c(QD5.inviteToGroup_header, interfaceC22053ub1J, 0), AbstractC21822uB5.main_plus, null, null, null, null, null, c16706lj6.g(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.lastseen_header, interfaceC22053ub1J, 0), AbstractC21822uB5.show, null, null, null, null, null, c16706lj6.h(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.cardToCardPolicy_header, interfaceC22053ub1J, 0), AbstractC21822uB5.card, null, null, null, null, null, c16706lj6.e(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.call_header, interfaceC22053ub1J, 0), AbstractC21822uB5.call, null, null, null, null, null, c16706lj6.d(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.story, interfaceC22053ub1J, 0), AbstractC21822uB5.story, null, null, null, null, null, c16706lj6.j(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC9459a00.c(null, UY6.c(QD5.settings_security_title, interfaceC22053ub1J, 0), null, interfaceC22053ub1J, 0, 5);
            interfaceC22053ub1J.W(1329657264);
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (c8386Vt0.Z8()) {
                AbstractC16797ls7.i(UY6.c(QD5.password_header, interfaceC22053ub1J, 0), AbstractC21822uB5.password, null, null, null, null, null, c16706lj6.i(), null, false, interfaceC22053ub1J, 0, 892);
                MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1329667913);
            if (c8386Vt0.Nb()) {
                AbstractC16797ls7.i(UY6.c(QD5.two_f_a_setting, interfaceC22053ub1J, 0), AbstractC21822uB5.twolock, null, null, null, null, null, c16706lj6.k(), null, false, interfaceC22053ub1J, 0, 892);
                MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            }
            interfaceC22053ub1J.Q();
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.app_lock, interfaceC22053ub1J, 0), AbstractC21822uB5.lock, null, null, null, null, null, c16706lj6.b(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.active_sessions, interfaceC22053ub1J, 0), AbstractC21822uB5.device, null, null, null, null, null, c16706lj6.a(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.settings_blocked_list, interfaceC22053ub1J, 0), AbstractC21822uB5.block, null, null, null, null, null, c16706lj6.c(), null, false, interfaceC22053ub1J, 0, 892);
            EnumC10352bW1 enumC10352bW1 = EnumC10352bW1.a;
            MY2.b(null, enumC10352bW1, 0L, interfaceC22053ub1J, 48, 5);
            int i4 = AbstractC21822uB5.mid_sync;
            String strC = UY6.c(QD5.sync_contacts, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1329712200);
            int i5 = i3 & 7168;
            boolean z2 = i5 == 2048;
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Wj6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC14944ik6.M(c16706lj6, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C10 c10 = new C10(z, (UA2) objB, true, false);
            Integer numValueOf = Integer.valueOf(i4);
            int i6 = C10.e;
            AbstractC24074y00.e(strC, c10, null, numValueOf, null, false, 0L, interfaceC22053ub1J, i6 << 3, 116);
            MY2.b(null, enumC10352bW1, 0L, interfaceC22053ub1J, 48, 5);
            interfaceC22053ub1J.W(1329721990);
            if (C8386Vt0.Y7()) {
                int i7 = AbstractC21822uB5.mxp;
                String strC2 = UY6.c(QD5.mxp_setting_title, interfaceC22053ub1J, 0);
                boolean zC = c16115kj6.c();
                interfaceC22053ub1J.W(1329731123);
                boolean z3 = i5 == 2048;
                Object objB2 = interfaceC22053ub1J.B();
                if (z3 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Xj6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC14944ik6.N(c16706lj6, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC24074y00.e(strC2, new C10(zC, (UA2) objB2, true, c16115kj6.d()), null, Integer.valueOf(i7), null, false, 0L, interfaceC22053ub1J, i6 << 3, 116);
                MY2.b(null, enumC10352bW1, 0L, interfaceC22053ub1J, 48, 5);
            }
            interfaceC22053ub1J.Q();
            String strC3 = UY6.c(QD5.deleteAccount_header, interfaceC22053ub1J, 0);
            int i8 = AbstractC21822uB5.delete;
            SA2 sa2F = c16706lj6.f();
            G10 g10 = G10.a;
            int i9 = G10.b;
            AbstractC16797ls7.i(strC3, i8, null, null, null, null, new C11984ds7(g10.a(interfaceC22053ub1J, i9).r(), g10.a(interfaceC22053ub1J, i9).t(), g10.a(interfaceC22053ub1J, i9).t(), g10.a(interfaceC22053ub1J, i9).t(), null), sa2F, null, false, interfaceC22053ub1J, C11984ds7.f << 18, 828);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Yj6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC14944ik6.O(eVar, c16115kj6, z, c16706lj6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(C16706lj6 c16706lj6, boolean z) {
        AbstractC13042fc3.i(c16706lj6, "$securityNavigationCallbacks");
        c16706lj6.m().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(C16706lj6 c16706lj6, boolean z) {
        AbstractC13042fc3.i(c16706lj6, "$securityNavigationCallbacks");
        c16706lj6.l().invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(androidx.compose.ui.e eVar, C16115kj6 c16115kj6, boolean z, C16706lj6 c16706lj6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(c16115kj6, "$mxpState");
        AbstractC13042fc3.i(c16706lj6, "$securityNavigationCallbacks");
        L(eVar, c16115kj6, z, c16706lj6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object Q(ir.nasim.C19391qG6 r9, ir.nasim.ZF6 r10, android.content.res.Resources r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) throws android.content.res.Resources.NotFoundException {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC14944ik6.e
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.ik6$e r0 = (ir.nasim.AbstractC14944ik6.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.ik6$e r0 = new ir.nasim.ik6$e
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L52
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            java.lang.String r10 = ir.nasim.AbstractC11593dG6.a(r10, r11)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L52
            return r0
        L52:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14944ik6.Q(ir.nasim.qG6, ir.nasim.ZF6, android.content.res.Resources, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void t(final ir.nasim.ZF6 r33, final ir.nasim.C16115kj6 r34, final boolean r35, final ir.nasim.SA2 r36, final ir.nasim.C16706lj6 r37, final ir.nasim.SA2 r38, final ir.nasim.SA2 r39, final ir.nasim.SA2 r40, ir.nasim.InterfaceC22053ub1 r41, final int r42) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14944ik6.t(ir.nasim.ZF6, ir.nasim.kj6, boolean, ir.nasim.SA2, ir.nasim.lj6, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$registerToMXP");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(ZF6 zf6, C16115kj6 c16115kj6, boolean z, SA2 sa2, C16706lj6 c16706lj6, SA2 sa22, SA2 sa23, SA2 sa24, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c16115kj6, "$mxpState");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c16706lj6, "$securityNavigationCallbacks");
        AbstractC13042fc3.i(sa22, "$resetSnackBarState");
        AbstractC13042fc3.i(sa23, "$dismissMxpDialog");
        AbstractC13042fc3.i(sa24, "$registerToMXP");
        t(zf6, c16115kj6, z, sa2, c16706lj6, sa22, sa23, sa24, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void w(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1834913349);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1897986926);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.Pj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.x();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897979694);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.dk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.y();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897983246);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.ek6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.z();
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            SA2 sa23 = (SA2) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897976718);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.fk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.A();
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            SA2 sa24 = (SA2) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897977678);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar.a()) {
                objB5 = new SA2() { // from class: ir.nasim.gk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.B();
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            SA2 sa25 = (SA2) objB5;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897978638);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.hk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.C();
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            SA2 sa26 = (SA2) objB6;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897975790);
            Object objB7 = interfaceC22053ub1J.B();
            if (objB7 == aVar.a()) {
                objB7 = new SA2() { // from class: ir.nasim.Qj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.D();
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            SA2 sa27 = (SA2) objB7;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897984494);
            Object objB8 = interfaceC22053ub1J.B();
            if (objB8 == aVar.a()) {
                objB8 = new SA2() { // from class: ir.nasim.Rj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.E();
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            SA2 sa28 = (SA2) objB8;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897982126);
            Object objB9 = interfaceC22053ub1J.B();
            if (objB9 == aVar.a()) {
                objB9 = new SA2() { // from class: ir.nasim.Sj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.F();
                    }
                };
                interfaceC22053ub1J.s(objB9);
            }
            SA2 sa29 = (SA2) objB9;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897985710);
            Object objB10 = interfaceC22053ub1J.B();
            if (objB10 == aVar.a()) {
                objB10 = new SA2() { // from class: ir.nasim.Tj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.G();
                    }
                };
                interfaceC22053ub1J.s(objB10);
            }
            SA2 sa210 = (SA2) objB10;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897974766);
            Object objB11 = interfaceC22053ub1J.B();
            if (objB11 == aVar.a()) {
                objB11 = new SA2() { // from class: ir.nasim.Zj6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.H();
                    }
                };
                interfaceC22053ub1J.s(objB11);
            }
            SA2 sa211 = (SA2) objB11;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897981006);
            Object objB12 = interfaceC22053ub1J.B();
            if (objB12 == aVar.a()) {
                objB12 = new UA2() { // from class: ir.nasim.ak6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC14944ik6.I(((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB12);
            }
            UA2 ua2 = (UA2) objB12;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1897987982);
            Object objB13 = interfaceC22053ub1J.B();
            if (objB13 == aVar.a()) {
                objB13 = new SA2() { // from class: ir.nasim.bk6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC14944ik6.J();
                    }
                };
                interfaceC22053ub1J.s(objB13);
            }
            interfaceC22053ub1J.Q();
            M10.f(false, AbstractC19242q11.e(135432832, true, new d(new C16706lj6(sa2, sa22, sa23, sa24, sa25, sa26, sa27, sa28, sa29, sa210, sa211, ua2, (SA2) objB13)), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ck6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC14944ik6.K(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z() {
        return C19938rB7.a;
    }
}
