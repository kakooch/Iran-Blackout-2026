package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.C4049Dl7;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.p76, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18716p76 {
    public static final void c(final SA2 sa2, final C16943m76 c16943m76, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onBarClicked");
        AbstractC13042fc3.i(c16943m76, "call");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1960271168);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c16943m76) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(48)), WX0.a(TA5.color4, interfaceC22053ub1J, 0), null, 2, null);
            interfaceC22053ub1J.W(159284843);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.n76
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18716p76.d(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.e.f(eVarD, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(16), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
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
            M66 m66 = M66.a;
            AbstractC24077y03.b(FV4.c(KB5.call_bar_default_icon, interfaceC22053ub1J, 0), "avatar", androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24)), C24381yX0.b.i(), null, 2, null), WX0.a(TA5.color9, interfaceC22053ub1J, 0), interfaceC22053ub1J, 432, 0);
            float f = 8;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(L66.b(m66, aVar, 1.0f, false, 2, null), C17784nZ1.q(f), 0.0f, 0.0f, 0.0f, 14, null);
            String strB = c16943m76.a().b();
            AbstractC23365wn7.a aVar3 = AbstractC23365wn7.a;
            int iB = aVar3.b();
            long jA = WX0.a(TA5.color9, interfaceC22053ub1J, 0);
            C6399Nk7.a aVar4 = C6399Nk7.b;
            int iF = aVar4.f();
            long jG = AbstractC13784go7.g(16);
            AbstractC9998au2 abstractC9998au2Q = M10.q();
            C4049Dl7.a aVar5 = C4049Dl7.b;
            AbstractC9339Zm7.b(strB, eVarM, jA, jG, null, null, abstractC9998au2Q, 0L, null, C6399Nk7.h(iF), 0L, iB, false, 1, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, aVar4.c(), aVar5.e(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16678911, (ED1) null), interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 3120, 54704);
            androidx.compose.ui.e eVarK2 = androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(f), 0.0f, 2, null);
            AbstractC9339Zm7.b(UY6.c(c16943m76.b(), interfaceC22053ub1J, 0), eVarK2, WX0.a(TA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(14), null, null, M10.q(), 0L, null, C6399Nk7.h(aVar4.f()), 0L, aVar3.b(), false, 1, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, aVar5.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1J, 3120, 3120, 54704);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.o76
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18716p76.e(sa2, c16943m76, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBarClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(SA2 sa2, C16943m76 c16943m76, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBarClicked");
        AbstractC13042fc3.i(c16943m76, "$call");
        c(sa2, c16943m76, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
