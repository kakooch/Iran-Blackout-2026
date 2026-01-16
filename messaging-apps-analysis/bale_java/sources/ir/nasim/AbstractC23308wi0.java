package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* renamed from: ir.nasim.wi0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC23308wi0 {
    public static final void d(final Avatar avatar, final String str, final String str2, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(528848292);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(avatar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 2048 : 1024;
        }
        int i4 = i3;
        if ((i4 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f = 12;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(f), 0.0f, C17784nZ1.q(16), 0.0f, 10, null), 0.0f, 1, null), C17784nZ1.q(74));
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar2.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarK = AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(50)), N46.g()), i, str, 0.0f, false, null, 28, null);
            float f2 = 1;
            float fQ = C17784nZ1.q(f2);
            G10 g10 = G10.a;
            int i5 = G10.b;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(avatar, null, false, 0, interfaceC22053ub1J, i4 & 14, 14), null, AbstractC9287Zh0.f(eVarK, fQ, g10.a(interfaceC22053ub1J, i5).C(), N46.g()), null, null, 0.0f, null, interfaceC22053ub12, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            androidx.compose.ui.e eVarB = L66.b(m66, androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(f), 0.0f, 2, null), 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.d(), aVar2.k(), interfaceC22053ub12, 6);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub12.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarB);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub12.G();
            if (interfaceC22053ub12.h()) {
                interfaceC22053ub12.g(sa2A2);
            } else {
                interfaceC22053ub12.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub12);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            String str3 = str == null ? "" : str;
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub12, i5).o();
            C6399Nk7.a aVar4 = C6399Nk7.b;
            AbstractC9339Zm7.b(str3, eVarH, g10.a(interfaceC22053ub12, i5).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar4.f()), 0L, 0, false, 0, 0, null, c9348Zn7O, interfaceC22053ub12, 48, 0, 65016);
            AbstractC9339Zm7.b(str2 == null ? "" : str2, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub12, i5).B(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar4.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub12, i5).e(), interfaceC22053ub12, 48, 0, 65016);
            interfaceC22053ub12.u();
            androidx.compose.ui.e eVarV = androidx.compose.foundation.layout.t.v(aVar, C17784nZ1.q(100), C17784nZ1.q(32));
            M46 m46D = N46.d(C17784nZ1.q(8));
            C10493bi0 c10493bi0A = AbstractC11256ci0.a(C17784nZ1.q(f2), g10.a(interfaceC22053ub12, i5).I());
            InterfaceC6180Mn0 interfaceC6180Mn0H = C6913Pn0.a.h(g10.a(interfaceC22053ub12, i5).r(), 0L, 0L, interfaceC22053ub12, C6913Pn0.l << 9, 6);
            TS4 ts4A = androidx.compose.foundation.layout.q.a(C17784nZ1.q(0));
            interfaceC22053ub12.W(-82290120);
            Object objB = interfaceC22053ub12.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ui0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23308wi0.e();
                    }
                };
                interfaceC22053ub12.s(objB);
            }
            interfaceC22053ub12.Q();
            AbstractC16750lo0.c((SA2) objB, eVarV, false, null, null, m46D, c10493bi0A, interfaceC6180Mn0H, ts4A, P21.a.a(), interfaceC22053ub12, 905969718, 28);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23308wi0.f(avatar, str, str2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(Avatar avatar, String str, String str2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        d(avatar, str, str2, i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void g(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1590970574);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            d(null, "title", "desc", 0, interfaceC22053ub1J, 3510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ti0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23308wi0.h(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        g(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
