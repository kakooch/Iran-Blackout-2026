package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC18847pM;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.pM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18847pM {

    /* renamed from: ir.nasim.pM$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ KA7 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.pM$a$a, reason: collision with other inner class name */
        static final class C1445a implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.compose.ui.e a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ KA7 c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ UA2 e;
            final /* synthetic */ SA2 f;

            C1445a(androidx.compose.ui.e eVar, SA2 sa2, KA7 ka7, UA2 ua2, UA2 ua22, SA2 sa22) {
                this.a = eVar;
                this.b = sa2;
                this.c = ka7;
                this.d = ua2;
                this.e = ua22;
                this.f = sa22;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(long j, InterfaceC17460n02 interfaceC17460n02) {
                AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
                InterfaceC17460n02.C1(interfaceC17460n02, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(UA2 ua2, KA7 ka7) {
                AbstractC13042fc3.i(ka7, "$state");
                ua2.invoke(ka7.b());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.ui.e n(androidx.compose.ui.e eVar) {
                AbstractC13042fc3.i(eVar, "$this$applyIf");
                return androidx.compose.foundation.d.c(eVar, Integer.MAX_VALUE, 0, 0, 0, null, 0.0f, 62, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(UA2 ua2, KA7 ka7) {
                AbstractC13042fc3.i(ka7, "$state");
                ua2.invoke(ka7.c());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(KA7 ka7, long j, InterfaceC17460n02 interfaceC17460n02) {
                AbstractC13042fc3.i(ka7, "$state");
                AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
                float fW1 = interfaceC17460n02.w1(C17784nZ1.q(1));
                float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - fW1;
                int iC = AbstractC24405yZ6.a.c();
                InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) * ka7.a().b()) << 32)), fW1, iC, null, 0.0f, null, 0, 480, null);
                return C19938rB7.a;
            }

            public final void h(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                final long jI = g10.a(interfaceC22053ub1, 6).I();
                final long jR = g10.a(interfaceC22053ub1, 6).r();
                androidx.compose.ui.e eVar = this.a;
                interfaceC22053ub1.W(-1456690451);
                boolean zF = interfaceC22053ub1.f(jR);
                Object objB = interfaceC22053ub1.B();
                if (zF || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.kM
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18847pM.a.C1445a.i(jR, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(androidx.compose.foundation.layout.t.h(androidx.compose.ui.draw.b.b(eVar, (UA2) objB), 0.0f, 1, null), false, null, null, this.b, 7, null);
                interfaceC22053ub1.W(-1456685498);
                boolean zD = interfaceC22053ub1.D(this.c) | interfaceC22053ub1.f(jI);
                final KA7 ka7 = this.c;
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.lM
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18847pM.a.C1445a.p(ka7, jI, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.draw.b.b(eVarF, (UA2) objB2), g10.c(interfaceC22053ub1, 6).b().r(), 0.0f, 2, null);
                InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                final KA7 ka72 = this.c;
                final UA2 ua2 = this.d;
                final UA2 ua22 = this.e;
                SA2 sa2 = this.f;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                M66 m66 = M66.a;
                int iB = ka72.b().b();
                long jI2 = g10.a(interfaceC22053ub1, 6).I();
                Integer numValueOf = Integer.valueOf(ka72.b().a());
                interfaceC22053ub1.W(1071829038);
                boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(ka72);
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.mM
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18847pM.a.C1445a.k(ua2, ka72);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC18847pM.n(iB, jI2, numValueOf, (SA2) objB3, interfaceC22053ub1, 0, 0);
                e.a aVar2 = androidx.compose.ui.e.a;
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g10.c(interfaceC22053ub1, 6).b().r()), interfaceC22053ub1, 0);
                String title = ka72.a().getTitle();
                int iF = C6399Nk7.b.f();
                long jD = g10.a(interfaceC22053ub1, 6).D();
                C9348Zn7 c9348Zn7D = g10.d(interfaceC22053ub1, 6).d();
                androidx.compose.ui.e eVarB = L66.b(m66, aVar2, 1.0f, false, 2, null);
                boolean zA = ka72.a().a();
                interfaceC22053ub1.W(1071850641);
                Object objB4 = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
                if (objB4 == aVar3.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.nM
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18847pM.a.C1445a.n((androidx.compose.ui.e) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC9339Zm7.b(title, AbstractC18847pM.t(eVarB, zA, (UA2) objB4), jD, 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 1, 1, null, c9348Zn7D, interfaceC22053ub1, 0, 27648, 40440);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g10.c(interfaceC22053ub1, 6).b().r()), interfaceC22053ub1, 0);
                int iP = ka72.c().p();
                long jY = ((C24381yX0) ka72.c().q().invoke(interfaceC22053ub1, 0)).y();
                Integer numValueOf2 = Integer.valueOf(ka72.c().j());
                interfaceC22053ub1.W(1071862115);
                boolean zV2 = interfaceC22053ub1.V(ua22) | interfaceC22053ub1.D(ka72);
                Object objB5 = interfaceC22053ub1.B();
                if (zV2 || objB5 == aVar3.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.oM
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18847pM.a.C1445a.o(ua22, ka72);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                AbstractC18847pM.n(iP, jY, numValueOf2, (SA2) objB5, interfaceC22053ub1, 0, 0);
                AbstractC18847pM.n(AbstractC24188yB5.close, g10.a(interfaceC22053ub1, 6).B(), Integer.valueOf(UD5.close_content_description), sa2, interfaceC22053ub1, 0, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                h((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(androidx.compose.ui.e eVar, SA2 sa2, KA7 ka7, UA2 ua2, UA2 ua22, SA2 sa22) {
            this.a = eVar;
            this.b = sa2;
            this.c = ka7;
            this.d = ua2;
            this.e = ua22;
            this.f = sa22;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(542195407, true, new C1445a(this.a, this.b, this.c, this.d, this.e, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pM$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ int a;
        final /* synthetic */ Integer b;
        final /* synthetic */ long c;

        b(int i, Integer num, long j) {
            this.a = i;
            this.b = num;
            this.c = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            EV4 ev4C = FV4.c(this.a, interfaceC22053ub1, 0);
            Integer num = this.b;
            interfaceC22053ub1.W(-1487410482);
            String strC = num == null ? null : UY6.c(num.intValue(), interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            AbstractC24077y03.b(ev4C, strC, androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, 6).b().r()), this.c, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final ir.nasim.KA7 r17, androidx.compose.ui.e r18, ir.nasim.SA2 r19, ir.nasim.SA2 r20, ir.nasim.UA2 r21, ir.nasim.UA2 r22, ir.nasim.InterfaceC22053ub1 r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18847pM.h(ir.nasim.KA7, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(EnumC21241tM enumC21241tM) {
        AbstractC13042fc3.i(enumC21241tM, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(AbstractC20029rM abstractC20029rM) {
        AbstractC13042fc3.i(abstractC20029rM, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(KA7 ka7, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, UA2 ua2, UA2 ua22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ka7, "$state");
        h(ka7, eVar, sa2, sa22, ua2, ua22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final int r16, final long r17, java.lang.Integer r19, final ir.nasim.SA2 r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18847pM.n(int, long, java.lang.Integer, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(int i, long j, Integer num, SA2 sa2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$onIconClicked");
        n(i, j, num, sa2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void p(final KA7 ka7, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(ka7, "state");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2086762455);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(ka7) : interfaceC22053ub1J.D(ka7) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            h(ka7, null, null, null, null, null, interfaceC22053ub1J, i2 & 14, 62);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.dM
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18847pM.q(ka7, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(KA7 ka7, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ka7, "$state");
        p(ka7, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.e t(androidx.compose.ui.e eVar, boolean z, UA2 ua2) {
        return z ? (androidx.compose.ui.e) ua2.invoke(eVar) : eVar;
    }
}
