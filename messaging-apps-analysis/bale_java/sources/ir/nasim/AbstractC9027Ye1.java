package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Ye1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC9027Ye1 {
    public static final void b(final SA2 sa2, final SA2 sa22, final SA2 sa23, final boolean z, final String str, final SA2 sa24, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "onCreateChannelClick");
        AbstractC13042fc3.i(sa22, "onCreateGroupClick");
        AbstractC13042fc3.i(sa23, "onAddContactClick");
        AbstractC13042fc3.i(sa24, "onOrganizationClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(360971268);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa24) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((i3 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC16797ls7.i(UY6.c(ED5.create_channel, interfaceC22053ub1J, 0), AbstractC15799kB5.tv, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, null, null, null, sa2, null, false, interfaceC22053ub1J, ((i3 << 21) & 29360128) | 384, 888);
            float f = 1;
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f));
            G10 g10 = G10.a;
            int i4 = G10.b;
            ZV1.b(eVarY, 0.0f, g10.a(interfaceC22053ub1J, i4).A(), interfaceC22053ub1J, 6, 2);
            AbstractC16797ls7.i(UY6.c(ED5.create_group, interfaceC22053ub1J, 0), AbstractC15799kB5.three_user, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, null, null, null, sa22, null, false, interfaceC22053ub1J, ((i3 << 18) & 29360128) | 384, 888);
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f)), 0.0f, g10.a(interfaceC22053ub1J, i4).A(), interfaceC22053ub1J, 6, 2);
            AbstractC16797ls7.i(UY6.c(ED5.add_contact, interfaceC22053ub1J, 0), AbstractC15799kB5.add_user, androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, null, null, null, sa23, null, false, interfaceC22053ub1J, ((i3 << 15) & 29360128) | 384, 888);
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f)), 0.0f, g10.a(interfaceC22053ub1J, i4).A(), interfaceC22053ub1J, 6, 2);
            interfaceC22053ub1J.W(905029722);
            if (z) {
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i4).y(), null, 2, null), g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().u());
                String strC = UY6.c(ED5.organization_title_desc, interfaceC22053ub1J, 0);
                C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1J, i4).a();
                AbstractC9339Zm7.b(strC, eVarJ, g10.a(interfaceC22053ub1J, i4).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1J, 0, 0, 65528);
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                interfaceC22053ub1J.W(905053492);
                String strD = str == null ? null : UY6.d(ED5.organization_title, new Object[]{str}, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(905052991);
                String strC2 = strD == null ? UY6.c(ED5.organization_title_desc, interfaceC22053ub1J, 0) : strD;
                interfaceC22053ub1J.Q();
                AbstractC16797ls7.i(strC2, AbstractC15799kB5.briefcase, eVarH, null, null, null, null, sa24, null, false, interfaceC22053ub1J, ((i3 << 6) & 29360128) | 384, 888);
                interfaceC22053ub12 = interfaceC22053ub1J;
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f)), 0.0f, g10.a(interfaceC22053ub12, i4).A(), interfaceC22053ub12, 6, 2);
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
            }
            interfaceC22053ub12.Q();
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ue1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9027Ye1.c(sa2, sa22, sa23, z, str, sa24, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(SA2 sa2, SA2 sa22, SA2 sa23, boolean z, String str, SA2 sa24, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onCreateChannelClick");
        AbstractC13042fc3.i(sa22, "$onCreateGroupClick");
        AbstractC13042fc3.i(sa23, "$onAddContactClick");
        AbstractC13042fc3.i(sa24, "$onOrganizationClicked");
        b(sa2, sa22, sa23, z, str, sa24, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
