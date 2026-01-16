package ir.nasim;

import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.eV, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12364eV {

    /* renamed from: ir.nasim.eV$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ QI4 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ long d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ SA2 f;

        a(QI4 qi4, boolean z, boolean z2, long j, UA2 ua2, SA2 sa2) {
            this.a = qi4;
            this.b = z;
            this.c = z2;
            this.d = j;
            this.e = ua2;
            this.f = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            SA2 sa2;
            UA2 ua2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(-10));
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            androidx.compose.ui.e eVarI = this.a.b().isEmpty() ? androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(8)) : androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16));
            QI4 qi4 = this.a;
            boolean z = this.b;
            boolean z2 = this.c;
            long j = this.d;
            UA2 ua22 = this.e;
            SA2 sa22 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
            if (qi4.a() == 0) {
                interfaceC22053ub1.W(313470817);
                if (!z) {
                    AbstractC16939m72.b(qi4, interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(313628297);
                for (PI4 pi4 : qi4.b()) {
                    if (pi4.b() && z2) {
                        interfaceC22053ub1.W(-39998970);
                        sa2 = sa22;
                        ua2 = ua22;
                        ZT0.d(pi4.a(), pi4.c(), pi4.d(), j, ua22, qi4, interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.Q();
                    } else {
                        sa2 = sa22;
                        ua2 = ua22;
                        interfaceC22053ub1.W(-39585461);
                        VT0.b(pi4.a(), pi4.c(), pi4.d(), j, sa2, qi4, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    }
                    ua22 = ua2;
                    sa22 = sa2;
                }
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final ir.nasim.QI4 r19, final ir.nasim.UA2 r20, final ir.nasim.SA2 r21, final long r22, boolean r24, boolean r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12364eV.b(ir.nasim.QI4, ir.nasim.UA2, ir.nasim.SA2, long, boolean, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(QI4 qi4, UA2 ua2, SA2 sa2, long j, boolean z, boolean z2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(qi4, "$result");
        AbstractC13042fc3.i(ua2, "$showStoryFragment");
        AbstractC13042fc3.i(sa2, "$showContactFragment");
        b(qi4, ua2, sa2, j, z, z2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
