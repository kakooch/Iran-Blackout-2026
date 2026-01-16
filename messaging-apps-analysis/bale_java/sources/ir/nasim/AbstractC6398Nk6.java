package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC6398Nk6;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Nk6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC6398Nk6 {

    /* renamed from: ir.nasim.Nk6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ int a;
        final /* synthetic */ C20996sx3 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ UA2 d;

        /* renamed from: ir.nasim.Nk6$a$a, reason: collision with other inner class name */
        static final class C0537a implements InterfaceC14603iB2 {
            final /* synthetic */ C20996sx3 a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ SA2 c;

            /* renamed from: ir.nasim.Nk6$a$a$a, reason: collision with other inner class name */
            static final class C0538a implements InterfaceC16978mB2 {
                final /* synthetic */ C20996sx3 a;
                final /* synthetic */ UA2 b;

                C0538a(C20996sx3 c20996sx3, UA2 ua2) {
                    this.a = c20996sx3;
                    this.b = ua2;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                    if ((i2 & 48) == 0) {
                        i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    C6658Ok6 c6658Ok6 = (C6658Ok6) this.a.f(i);
                    if (c6658Ok6 == null) {
                        return;
                    }
                    AbstractC6398Nk6.s(c6658Ok6, this.b, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            C0537a(C20996sx3 c20996sx3, UA2 ua2, SA2 sa2) {
                this.a = c20996sx3;
                this.b = ua2;
                this.c = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C20996sx3 c20996sx3, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(c20996sx3, "$model");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Mk6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC6398Nk6.a.C0537a.f((C6658Ok6) obj);
                    }
                }), null, AbstractC19242q11.c(343783292, true, new C0538a(c20996sx3, ua2)), 4, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object f(C6658Ok6 c6658Ok6) {
                AbstractC13042fc3.i(c6658Ok6, "it");
                return Integer.valueOf(c6658Ok6.c());
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C20996sx3 c20996sx3 = this.a;
                final UA2 ua2 = this.b;
                SA2 sa2 = this.c;
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
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(aVar, 0.0f, C17784nZ1.q(316), 1, null);
                interfaceC22053ub1.W(54873649);
                boolean zD = interfaceC22053ub1.D(c20996sx3) | interfaceC22053ub1.V(ua2);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Lk6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC6398Nk6.a.C0537a.d(c20996sx3, ua2, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 6, 510);
                AbstractC6398Nk6.l(sa2, interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(int i, C20996sx3 c20996sx3, SA2 sa2, UA2 ua2) {
            this.a = i;
            this.b = c20996sx3;
            this.c = sa2;
            this.d = ua2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int i2 = this.a;
            boolean z = this.b.i().d() instanceof AbstractC13460gG3.b;
            SA2 sa2 = this.c;
            AbstractC6398Nk6.w(i2, z, sa2, AbstractC19242q11.e(-1031788912, true, new C0537a(this.b, this.d, sa2), interfaceC22053ub1, 54), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1915405873);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f = SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(aVar, 0.0f, C17784nZ1.q(f), 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            ZV1.b(eVarA, g10.c(interfaceC22053ub1J, i3).b().e(), g10.a(interfaceC22053ub1J, i3).A(), interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.W(-30833835);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ek6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6398Nk6.m(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.A(androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null), 0.0f, C17784nZ1.q(f), 1, null), g10.c(interfaceC22053ub1J, i3).b().c());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.c(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            AbstractC9339Zm7.b(UY6.c(DD5.submit_return, interfaceC22053ub1J, 0), L66.b(M66.a, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.b()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).b(), interfaceC22053ub1J, 0, 0, 65016);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().c()), interfaceC22053ub1J, 0);
            AbstractC24077y03.b(FV4.c(AbstractC15208jB5.arrow_right, interfaceC22053ub1J, 0), null, G46.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().j()), 180.0f), g10.a(interfaceC22053ub1J, i3).B(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fk6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6398Nk6.n(sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackButtonClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBackButtonClicked");
        l(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final androidx.compose.ui.e r22, final ir.nasim.C20996sx3 r23, ir.nasim.SA2 r24, ir.nasim.UA2 r25, int r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6398Nk6.o(androidx.compose.ui.e, ir.nasim.sx3, ir.nasim.SA2, ir.nasim.UA2, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(androidx.compose.ui.e eVar, C20996sx3 c20996sx3, SA2 sa2, UA2 ua2, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(c20996sx3, "$model");
        o(eVar, c20996sx3, sa2, ua2, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s(final ir.nasim.C6658Ok6 r34, ir.nasim.UA2 r35, ir.nasim.InterfaceC22053ub1 r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6398Nk6.s(ir.nasim.Ok6, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(UA2 ua2, C6658Ok6 c6658Ok6) {
        AbstractC13042fc3.i(c6658Ok6, "$it");
        ua2.invoke(Integer.valueOf(c6658Ok6.c()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(C6658Ok6 c6658Ok6, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c6658Ok6, "$it");
        s(c6658Ok6, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void w(final int r20, final boolean r21, ir.nasim.SA2 r22, final ir.nasim.InterfaceC14603iB2 r23, ir.nasim.InterfaceC22053ub1 r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6398Nk6.w(int, boolean, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(int i, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, i, null, null, C12758f91.a.a(), 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(int i, boolean z, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$contentAfterLoading");
        w(i, z, sa2, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }
}
