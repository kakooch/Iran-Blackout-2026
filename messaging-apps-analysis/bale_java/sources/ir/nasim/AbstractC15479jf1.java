package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C24381yX0;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* renamed from: ir.nasim.jf1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC15479jf1 {
    public static final void d(final C22613vY c22613vY, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        boolean z;
        int i3;
        AbstractC13042fc3.i(c22613vY, "contact");
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1521872178);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c22613vY) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(76));
            C24381yX0.a aVar2 = C24381yX0.b;
            float f = 12;
            androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(eVarI, aVar2.i(), null, 2, null), C17784nZ1.q(f));
            interfaceC22053ub1J.W(987008360);
            int i4 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            int i5 = i2 & 14;
            boolean z2 = (i4 == 32) | (i5 == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gf1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15479jf1.e(ua2, c22613vY);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarI2, true, null, null, (SA2) objB, 6, null);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar3.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(L66.b(M66.a, aVar, 1.0f, false, 2, null), 0.0f, C17784nZ1.q(1), C17784nZ1.q(8), 0.0f, 9, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar3.j(), interfaceC22053ub1J, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strF = c22613vY.f();
            long jA = WX0.a(TA5.color9, interfaceC22053ub1J, 0);
            int iB = AbstractC23365wn7.a.b();
            androidx.compose.ui.e eVarE3 = androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), null, false, 3, null);
            C6399Nk7.a aVar5 = C6399Nk7.b;
            boolean z3 = true;
            AbstractC9105Ym7.b(strF, eVarE3, jA, AbstractC13784go7.g(16), null, null, M10.q(), 0L, null, C6399Nk7.h(aVar5.f()), 0L, iB, false, 1, 0, null, null, interfaceC22053ub1J, 3120, 3120, 120240);
            interfaceC22053ub1J.W(469230794);
            String strC = c22613vY.g() ? UY6.c(AbstractC12217eE5.members_adapter_bot_online_status, interfaceC22053ub1J, 0) : c22613vY.e();
            interfaceC22053ub1J.Q();
            AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), WX0.a(IA5.color8, interfaceC22053ub1J, 0), AbstractC13784go7.g(16), null, null, M10.q(), 0L, null, C6399Nk7.h(aVar5.c()), 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1J, 3120, 0, 64944);
            interfaceC22053ub1J.u();
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(c22613vY.c(), null, false, 0, interfaceC22053ub1J, 0, 14), "avatar", androidx.compose.foundation.layout.t.t(AbstractC9747aV.k(FV0.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, C17784nZ1.q(f), 0.0f, 11, null), aVar2.i(), null, 2, null), N46.g()), c22613vY.d(), c22613vY.f(), 0.0f, false, null, 28, null), C17784nZ1.q(52)), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1J.W(725339879);
            if (i4 == 32) {
                i3 = i5;
                z = true;
            } else {
                z = false;
                i3 = i5;
            }
            if (i3 != 4) {
                z3 = false;
            }
            boolean z4 = z | z3;
            Object objB2 = interfaceC22053ub1J.B();
            if (z4 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.hf1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15479jf1.f(ua2, c22613vY);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC24667z03.b(FV4.c(c22613vY.h() ? KB5.ic_checkbox_checked : KB5.ic_checkbox_unchecked, interfaceC22053ub1J, 0), "", androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB2, 7, null), aVar2.i(), interfaceC22053ub1J, 3120, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.if1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15479jf1.g(c22613vY, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(UA2 ua2, C22613vY c22613vY) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(c22613vY, "$contact");
        ua2.invoke(c22613vY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(UA2 ua2, C22613vY c22613vY) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(c22613vY, "$contact");
        ua2.invoke(c22613vY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C22613vY c22613vY, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c22613vY, "$contact");
        AbstractC13042fc3.i(ua2, "$onClick");
        d(c22613vY, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
