package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Sd0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7535Sd0 {
    public static final void i(final boolean z, final SA2 sa2, final SA2 sa22, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        AbstractC13042fc3.i(sa2, "submitFeedback");
        AbstractC13042fc3.i(sa22, "onClosePressed");
        AbstractC13042fc3.i(ua2, "doNotShowFeedBackAgain");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2144113389);
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
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-2042612037);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.valueOf(z), null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            float f = 24;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), WX0.a(IA5.color4, interfaceC22053ub1J, 0), null, 2, null), C17784nZ1.q(f));
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar3.g();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9105Ym7.b(UY6.c(BD5.bazar_feedback_title, interfaceC22053ub1J, 0), c9784aZ0.c(aVar2, aVar3.g()), WX0.a(IA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(18), null, null, M10.p(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
            float f2 = 12;
            AbstractC9105Ym7.b(UY6.c(BD5.bazar_feedback_description, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.q.m(aVar2, 0.0f, C17784nZ1.q(f2), 0.0f, 0.0f, 13, null), WX0.a(IA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(14), null, null, M10.q(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1J, 3120, 0, 130992);
            androidx.compose.ui.e eVarC = c9784aZ0.c(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.E(aVar2, null, false, 3, null), 0.0f, C17784nZ1.q(f2), 0.0f, 0.0f, 13, null), aVar3.k());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar3.i(), interfaceC22053ub1J, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            SA2 sa2A2 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(f));
            interfaceC22053ub1J.W(2114818139);
            boolean z2 = (i3 & 7168) == 2048;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == aVar.a()) {
                interfaceC9102Ym4 = interfaceC9102Ym42;
                objB2 = new SA2() { // from class: ir.nasim.Od0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7535Sd0.o(ua2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            } else {
                interfaceC9102Ym4 = interfaceC9102Ym42;
            }
            interfaceC22053ub1J.Q();
            AbstractC24667z03.b(FV4.c(j(interfaceC9102Ym4) ? KB5.ic_checkbox_checked : KB5.ic_checkbox_unchecked, interfaceC22053ub1J, 0), "", androidx.compose.foundation.layout.q.i(androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB2, 7, null), C17784nZ1.q(2)), C24381yX0.b.i(), interfaceC22053ub1J, 3120, 0);
            AbstractC9105Ym7.b(UY6.c(BD5.bazar_feedback_check, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.q.m(aVar2, C17784nZ1.q(f2), 0.0f, 0.0f, 0.0f, 14, null), WX0.a(IA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(15), null, null, M10.q(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1J, 3120, 0, 130992);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            float f3 = 1;
            androidx.compose.ui.e eVarF = AbstractC19576qb1.f(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), WX0.a(IA5.color6_2, interfaceC22053ub1J, 0), null, 2, null), C17784nZ1.q(f3), WX0.a(IA5.color1, interfaceC22053ub1J, 0));
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.d(), aVar3.l(), interfaceC22053ub1J, 6);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            SA2 sa2A3 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            androidx.compose.ui.e eVarB = L66.b(m66, aVar2, 1.0f, false, 2, null);
            InterfaceC10031ax6 interfaceC10031ax6A = MK5.a();
            interfaceC22053ub1J.W(-1414019833);
            boolean z3 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB3 = interfaceC22053ub1J.B();
            if (z3 || objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Pd0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7535Sd0.l(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            N21 n21 = N21.a;
            boolean z4 = true;
            AbstractC16159ko0.b((SA2) objB3, eVarB, false, interfaceC10031ax6A, null, null, null, null, null, n21.a(), interfaceC22053ub1J, 805309440, SIPTransactionStack.BASE_TIMER_INTERVAL);
            androidx.compose.ui.e eVarD = AbstractC19576qb1.d(L66.b(m66, aVar2, 1.0f, false, 2, null), C17784nZ1.q(f3), WX0.a(IA5.color1, interfaceC22053ub1J, 0));
            interfaceC22053ub1J.W(-1414001369);
            if ((i3 & 896) != 256) {
                z4 = false;
            }
            Object objB4 = interfaceC22053ub1J.B();
            if (z4 || objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.Qd0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7535Sd0.k(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC16159ko0.b((SA2) objB4, eVarD, false, null, null, null, null, null, null, n21.b(), interfaceC22053ub1J, 805306368, 508);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Rd0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7535Sd0.m(z, sa2, sa22, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClosePressed");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$submitFeedback");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(boolean z, SA2 sa2, SA2 sa22, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$submitFeedback");
        AbstractC13042fc3.i(sa22, "$onClosePressed");
        AbstractC13042fc3.i(ua2, "$doNotShowFeedBackAgain");
        i(z, sa2, sa22, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(ua2, "$doNotShowFeedBackAgain");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isChecked$delegate");
        n(interfaceC9102Ym4, !j(interfaceC9102Ym4));
        ua2.invoke(Boolean.valueOf(j(interfaceC9102Ym4)));
        return C19938rB7.a;
    }

    public static final void p(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-885930949);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1290099901);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.Kd0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7535Sd0.q();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1290099773);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Ld0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7535Sd0.r();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1290099645);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.Md0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC7535Sd0.s(((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            i(false, sa2, sa22, (UA2) objB3, interfaceC22053ub1J, 3510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Nd0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7535Sd0.t(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        p(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
