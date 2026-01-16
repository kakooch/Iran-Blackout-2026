package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.V03;
import ir.nasim.X03;

/* loaded from: classes4.dex */
public abstract class V03 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ X03 b;
        final /* synthetic */ InterfaceC10031ax6 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ Object e;
        final /* synthetic */ SA2 f;

        a(androidx.compose.ui.e eVar, X03 x03, InterfaceC10031ax6 interfaceC10031ax6, SA2 sa2, Object obj, SA2 sa22) {
            this.a = eVar;
            this.b = x03;
            this.c = interfaceC10031ax6;
            this.d = sa2;
            this.e = obj;
            this.f = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onBannerClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarA = this.a;
            boolean zD = AbstractC13042fc3.d(this.b, X03.b.b);
            InterfaceC10031ax6 interfaceC10031ax6 = this.c;
            if (zD) {
                eVarA = FV0.a(eVarA, interfaceC10031ax6);
            }
            G10 g10 = G10.a;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(eVarA, g10.a(interfaceC22053ub1, 6).r(), this.c);
            interfaceC22053ub1.W(1096666304);
            boolean zV = interfaceC22053ub1.V(this.d);
            final SA2 sa2 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.U03
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return V03.a.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarC, false, null, null, (SA2) objB, 7, null);
            Object obj = this.e;
            SA2 sa22 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            e.a aVar2 = androidx.compose.ui.e.a;
            IK.b(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), obj, null, InterfaceC13157fl1.a.d(), 0.0f, null, null, interfaceC22053ub1, 1575942, 52);
            interfaceC22053ub1.W(-450985078);
            if (sa22 != null) {
                AbstractC24077y03.b(FV4.c(AbstractC24188yB5.close, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(hVar.h(androidx.compose.foundation.layout.q.i(aVar2, g10.c(interfaceC22053ub1, 6).b().u()), C22297v0.a.e()), false, null, null, sa22, 7, null), g10.b(interfaceC22053ub1, 6).f(), interfaceC22053ub1, 48, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.e r18, final java.lang.Object r19, ir.nasim.InterfaceC10031ax6 r20, final ir.nasim.SA2 r21, ir.nasim.SA2 r22, ir.nasim.UA2 r23, ir.nasim.X03 r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V03.c(androidx.compose.ui.e, java.lang.Object, ir.nasim.ax6, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.X03, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, Object obj, InterfaceC10031ax6 interfaceC10031ax6, SA2 sa2, SA2 sa22, UA2 ua2, X03 x03, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBannerClick");
        c(eVar, obj, interfaceC10031ax6, sa2, sa22, ua2, x03, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-638556541);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, U51.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.S03
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return V03.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
