package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* loaded from: classes5.dex */
public abstract class VT0 {
    public static final void b(final Avatar avatar, final String str, final int i, final long j, final SA2 sa2, final QI4 qi4, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(sa2, "showContactFragment");
        AbstractC13042fc3.i(qi4, "result");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1214002186);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(avatar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.f(j) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(qi4) ? 131072 : 65536;
        }
        int i4 = i3;
        if ((i4 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(aVar, j, N46.g());
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(avatar, null, false, 0, interfaceC22053ub1J, i4 & 14, 14), TI4.d(qi4, interfaceC22053ub1J, (i4 >> 15) & 14), androidx.compose.foundation.e.f(AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.i(aVar, C17784nZ1.q(2)), C17784nZ1.q(50)), N46.g()), i, str, 0.0f, false, null, 28, null), false, null, null, sa2, 7, null), null, null, 0.0f, null, interfaceC22053ub12, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.UT0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return VT0.c(avatar, str, i, j, sa2, qi4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(Avatar avatar, String str, int i, long j, SA2 sa2, QI4 qi4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(sa2, "$showContactFragment");
        AbstractC13042fc3.i(qi4, "$result");
        b(avatar, str, i, j, sa2, qi4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }
}
